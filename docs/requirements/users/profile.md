# Tài Liệu BA Chi Tiết: Profile

Status: reviewed
Owner: BA/DEV
Last reviewed: 2026-09-16
Related:
  - docs/api/users/profile.md
  - docs/security/resources/users.md
  - docs/requirements/users/user.md
  - src/app/[locale]/admin/profile/page.tsx
  - src/app/[locale]/admin/profile/layout.tsx
  - src/app/[locale]/student/profile/page.tsx
  - src/app/[locale]/student/profile/layout.tsx
  - src/components/features/teacher-profile/personal-info-tab.tsx
  - src/components/features/teacher-profile/teacher-profile-sidebar.tsx
  - src/api/user.ts
  - docs/test-cases/overview.md

Business rule IDs:
  - PRF-BR-001: Mỗi user có trang hồ sơ cá nhân để xem thông tin của chính mình.
  - PRF-BR-002: User có thể cập nhật một phần thông tin hồ sơ nếu được phép.
  - PRF-BR-003: Dữ liệu hồ sơ phải đồng bộ với thông tin user đang đăng nhập.

Review note: Đã đối chiếu code profile theo từng role. Profile cho phép user sửa các thông tin mà UI đang cho chỉnh sửa, có đổi avatar từ profile. Đổi mật khẩu dùng API riêng `PUT /change-password`, không phải `PUT /profile`.

## 1. Khái niệm profile

Profile là màn hình hồ sơ cá nhân của user trong hệ thống LMS.

Trang này dùng để:
- Xem thông tin cá nhân
- Cập nhật thông tin cho phép sửa
- Kiểm tra trạng thái tài khoản đang đăng nhập

## 2. Phạm vi chức năng hiện có

API hiện có:
- `GET /v1/profile`
- `PUT /v1/profile`

Trong UI hiện có, profile xuất hiện ở các khu vực theo role như admin, teacher và student.

## 3. Thông tin hồ sơ

Profile thường bao gồm:
- Họ tên
- Email
- Số điện thoại
- Avatar
- Vai trò
- Trạng thái tài khoản
- Thông tin trường/lớp nếu có

## 4. Quy tắc nghiệp vụ chính

- User chỉ được xem hoặc sửa hồ sơ của chính mình, trừ khi backend cho phép bối cảnh khác.
- Các trường nhạy cảm như role, permission, school, class không nên sửa trực tiếp từ profile nếu không có rule riêng.
- Thay đổi hồ sơ phải đồng bộ với dữ liệu user đang hoạt động.

## 5. Luồng màn hình chính

1. User mở trang profile.
2. Hệ thống gọi API lấy thông tin hiện tại.
3. User cập nhật thông tin cho phép sửa.
4. Hệ thống lưu thay đổi và refresh dữ liệu hiển thị.

## 6. Field được phép sửa theo UI hiện tại

### 6.1. Admin profile

Màn admin profile đang cho sửa các field:
- `username`
- `name`
- `email`
- `address`
- `phone_number`

Avatar được đổi tại layout profile của admin, upload vào nhóm `avatars` rồi cập nhật bằng `PUT /profile`.

### 6.2. Student profile

Màn student profile đang cho sửa các field:
- `name`
- `date_of_birth`
- `username`
- `email`
- `phone_number`
- `address`

Khi đổi email, UI gọi OTP profile trước khi lưu thay đổi. Avatar được đổi tại layout profile của student, upload vào nhóm `avatars` rồi cập nhật bằng `PUT /profile`.

### 6.3. Teacher profile

Màn teacher profile đang cho sửa các field:
- `name`
- `identifier`
- `email`
- `address`
- `phone_number`

`username` được hiển thị trong modal sửa thông tin nhưng đang bị disable, không cho sửa từ UI teacher. Avatar được đổi tại sidebar teacher profile; UI kiểm tra file phải là ảnh và dung lượng không quá 5MB trước khi crop/upload.

### 6.4. Field không sửa trực tiếp từ profile

Các thông tin như role, permission, school, class và trạng thái tài khoản không sửa trực tiếp từ profile. Các thay đổi liên quan mật khẩu sử dụng API `PUT /change-password`.
