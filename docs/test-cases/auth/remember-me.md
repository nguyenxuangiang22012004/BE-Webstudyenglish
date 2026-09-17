---
requirement: ../../requirements/auth/auth.md
domain: auth
page: login
type: test-case
---

# Test Case - Ghi nhớ đăng nhập (Remember me)

Status: draft
Owner: TEST
Last reviewed: 2026-09-17
Related:
  - Requirement: docs/requirements/auth/auth.md (AUTH-BR-002, AUTH-BR-004)
  - Automation: tests/e2e/auth/remember-me-storage.spec.ts, tests/e2e/auth/parent-switch-child.spec.ts
  - Bug: docs/test-cases/auth/bugs/
  - Report: docs/test-cases/auth/reports/2026-09-16-remember-me.md, docs/test-cases/auth/reports/2026-09-17-remember-me.md, docs/test-cases/auth/reports/2026-09-17-remember-me-recheck.md

## Phạm vi

Kiểm tra checkbox "Ghi nhớ đăng nhập" ở `/[locale]/login`: dữ liệu lưu phía client (Local Storage, Session Storage, cookie), vòng đời phiên khi bật/tắt ghi nhớ, dọn dữ liệu khi đăng xuất.

> **Needs review (BA):** `docs/requirements/auth/auth.md` chưa có rule cho "Ghi nhớ đăng nhập" (lưu gì ở client, phiên sống bao lâu khi bật/tắt). Expected result bên dưới là **giả định của Tester** dựa trên nguyên tắc bảo mật phổ biến (OWASP: không lưu mật khẩu ở client; token nhạy cảm dùng cookie httpOnly), cần BA xác nhận và bổ sung business rule.

## Test Data

- Account: Student `1hsep`, password lấy từ `TEST_STUDENT_PASSWORD`; Parent `parent_user1`, password lấy từ `TEST_PARENT_PASSWORD` (AUTH-TC-013) (xem `docs/testing/test-data.md`). Không ghi password vào tài liệu/report.
- File tĩnh cùng origin để đọc Local Storage mà không chạy app: `/logo/logo.png`.
- Account không tồn tại: sinh ngẫu nhiên `e2e_khong_ton_tai_<timestamp>`.

---

## AUTH-TC-001 - Bật ghi nhớ: mật khẩu không nằm trong Local Storage, Session Storage hay cookie

Status: draft
Priority: high
Type: regression (security)
Related:
  - Bug: docs/test-cases/auth/bugs/AUTH-BUG-001.md

### Preconditions
Chưa đăng nhập, Local Storage sạch.

### Steps
1. Mở `/vi/login`, nhập username/password hợp lệ.
2. Tick "Ghi nhớ đăng nhập", bấm "Đăng nhập".
3. Sau khi vào trang theo role, mở DevTools → Application → Local Storage, Session Storage, Cookies.

### Expected Results
- Không có key `rememberedCredentials`.
- Không có giá trị nào (Local/Session Storage, cookie) chứa mật khẩu.
- Local Storage chỉ có `rememberedUsername` = username.

### Automation
tests/e2e/auth/remember-me-storage.spec.ts (`AUTH-TC-001`)

## AUTH-TC-002 - Bật ghi nhớ: cookie phiên là httpOnly và có hạn dài

Status: draft
Priority: high
Type: functional (security)

### Steps
1. Đăng nhập có tick "Ghi nhớ đăng nhập".
2. Kiểm tra cookie `authToken`, `refreshToken`, `rememberMe`.

### Expected Results
- Cả 3 cookie tồn tại, `HttpOnly = true`, có `Expires` trong tương lai.
- `rememberMe = 1`.

### Automation
tests/e2e/auth/remember-me-storage.spec.ts (`AUTH-TC-002`)

## AUTH-TC-003 - Dữ liệu cũ `rememberedCredentials` bị xóa khi mở trang đăng nhập

Status: draft
Priority: high
Type: regression (migration)

### Preconditions
Local Storage có sẵn `rememberedCredentials` (mô phỏng người dùng đã dùng phiên bản cũ).

### Steps
1. Mở `/vi/login`, set `rememberedCredentials` giả trong Local Storage.
2. Reload trang.

### Expected Results
Key `rememberedCredentials` bị xóa khỏi Local Storage.

### Automation
tests/e2e/auth/remember-me-storage.spec.ts (`AUTH-TC-003`)

## AUTH-TC-004 - Mở lại trang đăng nhập: điền sẵn username, mật khẩu để trống

Status: draft
Priority: medium
Type: functional

### Steps
1. Đăng nhập có tick ghi nhớ.
2. Xóa cookie (mô phỏng hết phiên), mở lại `/vi/login`.

### Expected Results
- Ô username điền sẵn username đã ghi nhớ.
- Ô mật khẩu trống.
- Checkbox "Ghi nhớ đăng nhập" đang tick.

### Automation
tests/e2e/auth/remember-me-storage.spec.ts (`AUTH-TC-004`)

## AUTH-TC-005 - Tắt ghi nhớ: xóa username đã lưu và cookie là cookie phiên

Status: draft
Priority: medium
Type: functional

### Preconditions
Local Storage có `rememberedUsername` từ lần trước.

### Steps
1. Đăng nhập **không** tick ghi nhớ.
2. Kiểm tra Local Storage và cookie.

### Expected Results
- `rememberedUsername` bị xóa.
- `authToken`, `refreshToken`, `rememberMe` là cookie phiên (không có Expires); `rememberMe = 0`.

### Automation
tests/e2e/auth/remember-me-storage.spec.ts (`AUTH-TC-005`)

## AUTH-TC-006 - Tắt ghi nhớ, đóng trình duyệt rồi mở lại: phải đăng nhập lại

Status: draft
Priority: high
Type: functional (security)
Related:
  - Bug: docs/test-cases/auth/bugs/AUTH-BUG-002.md

### Steps
1. Đăng nhập **không** tick ghi nhớ.
2. Đóng hẳn trình duyệt (cookie phiên bị xóa, Local Storage giữ nguyên), mở lại và vào `/vi/login`.

### Expected Results
- Không còn access token trong Local Storage.
- Người dùng ở lại trang đăng nhập (phải đăng nhập lại).

### Automation
tests/e2e/auth/remember-me-storage.spec.ts (`AUTH-TC-006`)

## AUTH-TC-007 - Đăng xuất khi mất mạng: token trên máy vẫn phải bị xóa

Status: draft
Priority: medium
Type: edge-case (security)
Related:
  - Bug: docs/test-cases/auth/bugs/AUTH-BUG-003.md

### Steps
1. Đăng nhập có tick ghi nhớ.
2. Mở menu avatar, ngắt mạng, bấm "Đăng xuất".
3. Kiểm tra Local Storage.

### Expected Results
`token` và `authUser` bị xóa khỏi Local Storage dù request logout lỗi.

### Automation
tests/e2e/auth/remember-me-storage.spec.ts (`AUTH-TC-007`)

## AUTH-TC-008 - Đăng nhập thất bại không được lưu username

Status: draft
Priority: low
Type: validation
Related:
  - Bug: docs/test-cases/auth/bugs/AUTH-BUG-004.md

### Steps
1. Mở `/vi/login`, nhập username không tồn tại + mật khẩu sai, tick ghi nhớ, bấm "Đăng nhập".
2. Kiểm tra Local Storage.

### Expected Results
- Hiển thị lỗi đăng nhập, vẫn ở trang login.
- Không có `rememberedUsername` cho lần đăng nhập thất bại.

### Automation
tests/e2e/auth/remember-me-storage.spec.ts (`AUTH-TC-008`)

## AUTH-TC-009 - Đăng xuất khi mất mạng rồi có mạng lại: không khôi phục phiên cũ

Status: draft
Priority: high
Type: edge-case (security)
Related:
  - Bug: docs/test-cases/auth/bugs/AUTH-BUG-006.md
  - Bug: docs/test-cases/auth/bugs/AUTH-BUG-003.md

### Preconditions
Chưa đăng nhập, Local Storage sạch.

### Steps
1. Đăng nhập có tick "Ghi nhớ đăng nhập".
2. Mở menu avatar, ngắt mạng, bấm "Đăng xuất"; chờ request logout lỗi.
3. Bật lại mạng.
4. Mở `/vi/student/assignments` (mô phỏng người dùng tiếp theo trên cùng máy), chờ 10 giây.
5. Kiểm tra Local Storage và nội dung trang.

### Expected Results
- Không có `token` trong Local Storage.
- `POST /api/auth/refresh-token` không trả `200`; cookie phiên cũ (`authToken`, `refreshToken`, `h5p_token`, `rememberMe`, `userType`, `userId`) bị xóa.
- Không hiển thị dữ liệu của tài khoản vừa đăng xuất; người dùng được đưa về trang đăng nhập.
- Refresh token của phiên cũ không còn đổi được token mới (đã bị thu hồi ở API).

> **Needs review (BA/Dev):** chưa có rule cho đăng xuất khi mất mạng. Expected result là giả định của Tester.

### Automation
tests/e2e/auth/remember-me-storage.spec.ts (`AUTH-TC-009`; bỏ tag `@known-bug` từ 2026-09-17 sau fix `b4b9ea01`)

## AUTH-TC-010 - Đăng xuất khi mất mạng rồi có mạng lại (tắt ghi nhớ): không khôi phục phiên cũ

Status: draft
Priority: high
Type: edge-case (security)
Related:
  - Bug: docs/test-cases/auth/bugs/AUTH-BUG-006.md

### Steps
Như AUTH-TC-009 nhưng đăng nhập **không** tick "Ghi nhớ đăng nhập".

### Expected Results
Như AUTH-TC-009.

> **Needs review (BA/Dev):** như AUTH-TC-009.

### Automation
tests/e2e/auth/remember-me-storage.spec.ts (`AUTH-TC-010`)

## AUTH-TC-011 - Phiên đang đăng nhập vẫn làm mới token được (non-regression)

Status: draft
Priority: high
Type: regression
Related:
  - Bug: docs/test-cases/auth/bugs/AUTH-BUG-006.md (kiểm tra fix không chặn nhầm phiên hợp lệ)

### Steps
1. Đăng nhập có tick ghi nhớ.
2. Gọi `POST /api/auth/refresh-token` trong cùng trình duyệt.

### Expected Results
- Response `200`, message làm mới thành công.
- Cookie `authToken`, `refreshToken`, `userType` vẫn còn.
- (Đối chứng cho automation) gắn lại refresh token còn hợp lệ rồi gọi refresh-token → vẫn làm mới được.

### Automation
tests/e2e/auth/remember-me-storage.spec.ts (`AUTH-TC-011`)

## AUTH-TC-012 - Đăng xuất khi có mạng: xóa cookie httpOnly và thu hồi refresh token

Status: draft
Priority: high
Type: functional (security)
Related:
  - Bug: docs/test-cases/auth/bugs/AUTH-BUG-006.md

### Steps
1. Đăng nhập có tick ghi nhớ.
2. Mở menu avatar, bấm "Đăng xuất" (có mạng).
3. Kiểm tra cookie; gắn lại refresh token cũ và gọi `POST /api/auth/refresh-token`.

### Expected Results
- `/api/auth/logout` trả `200`, về trang đăng nhập.
- Không còn cookie phiên (`authToken`, `refreshToken`, `h5p_token`, `rememberMe`, `userType`, `userId`).
- Refresh token cũ không đổi được token mới.

### Automation
tests/e2e/auth/remember-me-storage.spec.ts (`AUTH-TC-012`)

## AUTH-TC-013 - Phụ huynh vào tài khoản con: làm mới phiên phải cấp token của con

Status: draft
Priority: high
Type: functional (security)
Related:
  - Bug: docs/test-cases/auth/bugs/AUTH-BUG-007.md

### Preconditions
Account phụ huynh có ít nhất 1 tài khoản con liên kết.

### Steps
1. Đăng nhập Parent `parent_user1`, tick "Ghi nhớ đăng nhập" → `/vi/parents/childrens`.
2. Bấm "Vào tài khoản" ở tài khoản con đầu tiên, bấm "Xác nhận".
3. Kiểm tra Local Storage `token` và cookie `authToken`, `refreshToken`.
4. Gọi `POST /api/auth/refresh-token`, xác định token mới thuộc về ai.

### Expected Results
- Vào `/vi/student/assignments`, Local Storage `token` là của tài khoản con.
- Không còn cookie phiên của phụ huynh.
- Token do refresh-token cấp là của tài khoản con, không phải phụ huynh.

> **Needs review (BA):** chưa có rule cho phiên phụ huynh/tài khoản con. Expected result dựa trên hộp thoại "tài khoản của bạn sẽ tự động đăng xuất".

### Automation
tests/e2e/auth/parent-switch-child.spec.ts (`AUTH-TC-013 @known-bug`)
