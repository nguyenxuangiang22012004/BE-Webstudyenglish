# Parent -> Child account switch flow

Status: reviewed
Owner: DEV/TEST
Last reviewed: 2026-09-16
Source: Ghi chú luồng FE/auth; đã đối chiếu với middleware, page phụ huynh và API hiện tại.
Related:
  - docs/requirements/auth/auth.md
  - docs/api/auth/auth.md
  - docs/requirements/users/user.md
  - src/app/[locale]/parents/childrens/page.tsx
  - src/middleware.ts

Review note: Luồng parent -> child được xác nhận đúng. Hệ thống chuyển hẳn session sang học sinh, route đích là `/{locale}/student/assignments`, hiện không cần giữ đường quay lại tài khoản phụ huynh trong flow này.

Tài liệu này mô tả luồng đăng nhập phụ huynh, xem danh sách tài khoản con, và chuyển sang tài khoản học sinh từ màn `/parents/childrens`.

## Mục tiêu

- Phụ huynh đăng nhập thành công vào hệ thống.
- Phụ huynh vào trang `/{locale}/parents/childrens`.
- Trang hiển thị danh sách các tài khoản con đã được liên kết.
- Mỗi card học sinh có nút `Vào tài khoản`.
- Khi chọn một học sinh, hệ thống lấy token của học sinh và chuyển session sang tài khoản đó.

## Trạng thái hiện tại của app

### 1. Đăng nhập phụ huynh

- FE gọi `/api/auth/login` hoặc `/api/auth/loginPHX`.
- Server route gọi BE login.
- Cookie `authToken` và `refreshToken` được set ở server route.
- FE đồng thời lưu:
  - `localStorage.token`
  - `localStorage.authUser`
  - cookie `userType`
  - cookie `userId`
- Nếu là PHX login thì có thêm `localStorage.phxLogin = true`.

### 2. Điều hướng theo role

Middleware trong `src/middleware.ts` được dùng để:

- redirect user theo `userType`
- bảo vệ route theo role
- map vai trò:
  - `student` -> `/{locale}/student/assignments`
  - `parents` -> `/{locale}/parents/childrens`

### 3. Trang danh sách con

File hiện tại:

- `src/app/[locale]/parents/childrens/page.tsx`

Trang này:

- gọi `userApi.getProfileChildren`
- render các card học sinh
- có nút `Vào tài khoản`
- hiện dialog xác nhận trước khi chuyển

## API liên quan

### Lấy danh sách con

- `GET /profile/children`
- FE wrapper: `userApi.getProfileChildren`

### Lấy token của học sinh

- `GET /profile/children-token?user_id=...`
- FE wrapper: `userApi.getProfileChildrenToken`

Response trả về:

```json
{
  "access_token": "string",
  "expires_in": 300,
  "refresh_expires_in": 1800,
  "refresh_token": "string",
  "token_type": "Bearer"
}
```

## Luồng mong đợi

### B1. Phụ huynh vào trang con

1. Phụ huynh đăng nhập bằng tài khoản PH.
2. FE redirect về `/{locale}/parents/childrens`.
3. FE gọi `userApi.getProfileChildren`.
4. Danh sách học sinh được hiển thị.

### B2. Phụ huynh chọn một học sinh

1. Phụ huynh bấm nút `Vào tài khoản`.
2. FE gọi `userApi.getProfileChildrenToken(user_id)`.
3. FE hiện dialog:
   - `Bạn có chắc chắn muốn vào tài khoản của {name} không?`
   - `Khi vào tài khoản của con, tài khoản của bạn sẽ tự động đăng xuất.`
4. Phụ huynh bấm `Xác nhận`.
5. Hệ thống clear session PH hiện tại.
6. Hệ thống set session mới của học sinh.
7. FE route sang `/{locale}/student/assignments`.

## Session cần xử lý khi switch

Khi chuyển từ PH sang học sinh, cần clear các giá trị cũ và set các giá trị mới.

### Clear session cũ

- `localStorage.token`
- `localStorage.authUser`
- `localStorage.phxLogin` nếu có
- cookie `userType`
- cookie `userId`
- cookie `authToken`
- cookie `refreshToken`

### Set session mới

Từ response `getProfileChildrenToken`:

- `localStorage.token = access_token`
- `cookie userType = student`
- `cookie userId = child id`

Nếu muốn đồng bộ y chang luồng login hiện tại thì cần có cách set cookie/server route phù hợp cho `authToken` và `refreshToken`.

## Hai cách triển khai

### Cách 1: FE-only

FE tự:

- lấy token con
- clear session PH
- set token con
- route sang trang học sinh

Ưu điểm:

- nhanh
- ít thay đổi backend/route

Nhược điểm:

- không đồng nhất hoàn toàn với luồng login hiện tại
- refresh token và cookie auth có thể khác cơ chế login gốc

### Cách 2: Có thêm server route switch

FE gọi `getProfileChildrenToken`, sau đó POST sang một route server side trong FE, ví dụ:

- `/api/auth/switch-child`

Route này sẽ:

- clear session cũ
- set cookie auth mới
- set cookie refresh mới
- trả về status thành công để FE redirect

Ưu điểm:

- đồng nhất với architecture auth hiện tại
- an toàn hơn nếu cần cookie `httpOnly`
- dễ mở rộng khi cần switch qua lại giữa các role

Nhược điểm:

- cần thêm 1 route FE server-side

## Ghi chú implementation hiện tại

- `getProfileChildrenToken` đã được khai báo trong `src/api/user.ts`.
- Màn `parents/childrens` đã có nút `Vào tài khoản` và dialog xác nhận.
- Nút `Xác nhận` thực hiện clear session phụ huynh, set session học sinh và chuyển tới `/{locale}/student/assignments`.

## Route đích

Sau khi chuyển session sang học sinh, route cần về là:

- `/{locale}/student/assignments`

Không phải `/students/assignments`.

## Kết luận

Luồng nghiệp vụ bạn mô tả là hợp lý:

1. PH login
2. xem danh sách con
3. chọn 1 con
4. lấy token của con
5. chuyển sang session học sinh
6. route sang trang học sinh

Flow hiện tại dùng hướng FE-only: lấy token con, clear session phụ huynh, set session học sinh và chuyển route sang màn học sinh.
