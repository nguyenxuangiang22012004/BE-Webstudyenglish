# Tài liệu BA chi tiết: Settings

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-06-05
Related:
  - docs/api/settings/setting.md
  - docs/api/settings/config.md
  - docs/security/resources/settings.md
  - src/api/settings.ts
  - src/hooks/use-setting.ts
  - src/app/[locale]/admin/settings/page.tsx
  - src/components/features/settings/setting-form.tsx
  - src/middleware.ts
  - docs/test-cases/overview.md

## 1. Khái niệm settings

Settings là nhóm cấu hình hệ thống dạng key-value dùng để bật/tắt hoặc cung cấp giá trị cấu hình cho các chức năng frontend.

Theo code hiện tại, Admin có màn CRUD settings tại route `/[locale]/admin/settings`. Một số phần runtime đọc settings qua hook `useSetting(key)` hoặc gọi trực tiếp endpoint `/settings/by-key/{key}`.

## 2. Phạm vi chức năng hiện có

Các chức năng đã thấy trong code:

- Xem danh sách settings.
- Tìm kiếm settings theo keyword.
- Lọc settings theo trạng thái active/inactive.
- Tạo setting.
- Cập nhật setting.
- Bật/tắt setting từ danh sách.
- Xóa setting.
- Phân trang danh sách.
- Đọc setting theo key trong runtime bằng hook `useSetting`.
- Middleware đọc setting maintenance theo `MAINTENANCE_KEY`.

## 3. Thông tin setting

Theo `src/api/settings.ts`, một setting gồm:

- `id`
- `key`
- `name`
- `values`
- `is_active`
- `created_by`
- `updated_by`
- `created_at`
- `updated_at`

`values` là danh sách cặp key-value:

- `values[].key`
- `values[].value`

Payload tạo/cập nhật gồm:

- `key`
- `name`
- `values`
- `is_active`

## 4. Danh sách settings

Màn danh sách gọi API `/settings`.

Tham số lọc/phân trang:

- `page`
- `per_page`
- `keyword`
- `is_active`

UI hiện có:

- Bộ lọc trạng thái: tất cả, active, inactive.
- Ô tìm kiếm keyword.
- Nút tạo mới.
- Bảng hiển thị tên, key, trạng thái và hành động.
- Switch bật/tắt trạng thái.
- Nút sửa.
- Nút xóa.
- Phân trang.

FE tính tổng số trang từ `total_count` API trả về. Nếu API không trả `total_count`, FE fallback theo số lượng item trong response.

## 5. Tạo setting

Luồng tạo mới:

1. Admin mở `/[locale]/admin/settings/create`.
2. Nhập tên setting.
3. Nhập key setting.
4. Chọn trạng thái active/inactive.
5. Nhập danh sách values.
6. Submit form.
7. FE gọi `POST /settings`.
8. Nếu thành công, quay về danh sách settings.

Form cho phép thêm nhiều dòng value. Khi submit, FE trim từng dòng và loại bỏ dòng có `key` rỗng.

## 6. Cập nhật setting

Luồng cập nhật:

1. Admin mở `/[locale]/admin/settings/{id}/edit`.
2. FE gọi `GET /settings/{id}` để lấy chi tiết.
3. Form map dữ liệu chi tiết vào các trường name, key, is_active và values.
4. Admin chỉnh sửa và submit.
5. FE gọi `PUT /settings/{id}`.
6. Nếu thành công, quay về danh sách settings.

Từ danh sách, Admin cũng có thể bật/tắt nhanh trạng thái. Khi toggle, FE gọi update với payload giữ nguyên `key`, `name`, `values` và đảo `is_active`.

## 7. Xóa setting

Luồng xóa:

1. Admin bấm xóa ở danh sách.
2. FE hiển thị confirm bằng `window.confirm`.
3. Nếu xác nhận, FE gọi `DELETE /settings/{id}`.
4. Nếu xóa item cuối của trang hiện tại và page > 1, FE lùi về trang trước.
5. Nếu không, FE invalidate query danh sách.

FE không chặn xóa và backend cũng không chặn xóa setting đang được dùng bởi runtime (đã xác nhận). Việc xóa nhầm một setting đang được runtime tham chiếu sẽ làm hook `useSetting` trả `setting: null`/`isEnabled: false` cho chức năng tương ứng.

## 8. Đọc setting trong runtime

Hook `useSetting(key)` dùng `settingApi.getSettings` để lấy danh sách settings, sau đó tìm item có `s.key === key`.

Hook trả về:

- `setting`: setting tìm được hoặc `null`.
- `isEnabled`: `true` khi setting tồn tại và `is_active === true`.
- `isLoading`: trạng thái loading cục bộ.

Nếu không tìm thấy setting hoặc có lỗi, hook trả `setting: null` và `isEnabled: false`.

Các key đã thấy trong code:

- `focus_detection`: dùng trong preview lecture.
- `chat_course`: dùng trong màn course.

Middleware cũng gọi `/v1/settings/by-key/{MAINTENANCE_KEY}` để kiểm tra cấu hình maintenance.

## 9. Quy tắc nghiệp vụ hiện có

### SET-BR-001. Tên setting bắt buộc

Khi tạo hoặc cập nhật, `name` không được rỗng sau khi trim.

Nếu rỗng, FE hiển thị cảnh báo và không submit.

### SET-BR-002. Key setting bắt buộc

Khi tạo hoặc cập nhật, `key` không được rỗng sau khi trim.

Nếu rỗng, FE hiển thị cảnh báo và không submit.

### SET-BR-003. Value row có key rỗng không được gửi

Khi submit, FE trim từng dòng trong `values` và chỉ gửi các dòng có `values[].key` khác rỗng.

### SET-BR-004. Setting mới mặc định active

Form tạo mới khởi tạo `is_active` là `true`.

### SET-BR-005. Toggle trạng thái không được làm mất values

Khi bật/tắt từ danh sách, FE gửi lại payload gồm `key`, `name`, `values` hiện có và `is_active` mới.

### SET-BR-006. Runtime chỉ coi setting là enabled khi active

Hook `useSetting` chỉ trả `isEnabled: true` nếu setting tồn tại và `is_active === true`.

## 10. API liên quan

Các API đang được gọi trong code:

- `GET /settings`
- `GET /settings/{id}`
- `POST /settings`
- `PUT /settings/{id}`
- `DELETE /settings/{id}`

Tài liệu Swagger còn có:

- `GET /settings/by-key/{key}`
- `GET /config`

Middleware dùng endpoint dạng `/v1/settings/by-key/{key}` thông qua `NEXT_PUBLIC_API_URL`.

## 11. Quyền và phạm vi dữ liệu

Route quản lý settings hiện nằm dưới `/[locale]/admin/settings`.

Theo tài liệu security hiện có, resource liên quan là `settings`.

Vai trò và action chính xác cần đối chiếu thêm với runtime permission. Trong code page settings hiện tại chưa thấy guard action create/update/delete trực tiếp trong component.

## 12. State transition

Setting có trạng thái active/inactive qua `is_active`.

Chuyển trạng thái hiện có:

- Active -> inactive bằng switch trên danh sách.
- Inactive -> active bằng switch trên danh sách.
- Tạo mới mặc định active nhưng Admin có thể đổi trong form.
- Cập nhật có thể thay đổi trạng thái.

## 13. Luồng màn hình chính

### 13.1. Luồng xem danh sách

1. Admin mở màn settings.
2. FE gọi API danh sách với page, per_page, keyword và is_active.
3. Admin tìm kiếm, lọc trạng thái hoặc phân trang.
4. Admin có thể tạo, sửa, xóa hoặc bật/tắt setting.

### 13.2. Luồng tạo/cập nhật

1. Admin nhập tên và key.
2. Admin cấu hình trạng thái.
3. Admin nhập danh sách value.
4. FE validate name/key bắt buộc.
5. FE loại bỏ value row có key rỗng.
6. FE gọi API tạo/cập nhật.

### 13.3. Luồng đọc setting runtime

1. Component gọi `useSetting(key)`.
2. Hook lấy danh sách settings.
3. Hook tìm setting theo key.
4. Nếu setting active, component coi chức năng tương ứng là enabled.

## 14. Edge cases và điểm cần xác nhận

### Đã xác nhận

- Backend **không** kiểm tra trùng `key` giữa các setting. FE/người dùng tự chịu trách nhiệm tránh tạo key trùng; nếu trùng, hook `useSetting` lấy item đầu tiên khớp `key` trong danh sách.
- Backend **không** chặn xóa setting đang được dùng bởi runtime.
- **Không** cần quy tắc format key (không bắt buộc snake_case hay pattern cố định). `key` chỉ cần khác rỗng theo SET-BR-002.

### Còn cần xác nhận

- `values[].value` hiện là string; nếu cần boolean/number/object thì cần quy ước encode/decode.
- Hook `useSetting` hiện lấy danh sách settings rồi lọc client-side, chưa gọi endpoint `by-key`; cần xác nhận kỳ vọng hiệu năng.
- Quyền tạo/sửa/xóa settings cần đối chiếu với RBAC runtime.
- Cơ chế maintenance trong middleware cần tài liệu chi tiết hơn nếu backend trả nhiều dạng value.
