# Tài Liệu BA Chi Tiết: Degree

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-06-12
Related:
  - docs/api/schools/degree.md
  - docs/security/resources/degrees.md
  - docs/requirements/users/user.md
  - docs/test-cases/overview.md

Business rule IDs:
  - DEG-BR-001: Degree là thông tin bằng cấp hoặc trình độ của user.
  - DEG-BR-002: Degree hỗ trợ quản lý hồ sơ giáo viên/người dùng.

## 1. Khái niệm degree

Degree là bằng cấp hoặc trình độ chuyên môn được gắn với user.

## 2. Phạm vi chức năng hiện có

API hiện có:
- `GET /v1/degrees`
- `POST /v1/degrees`
- `GET /v1/degrees/{id}`
- `PUT /v1/degrees/{id}`
- `DELETE /v1/degrees/{id}`

Danh sách hỗ trợ `keyword`, `user_id`, `status` và sort nếu API nhận.

## 3. Quy tắc nghiệp vụ chính

- Degree cần gắn đúng user nếu dùng trong hồ sơ cá nhân/giáo viên.
- Degree có thể được dùng để tham khảo năng lực hoặc hồ sơ nhân sự.
- Xóa degree đang dùng trong hồ sơ cần kiểm tra ràng buộc backend.

## 4. Ghi chú và điểm cần xác nhận

- Cần xác nhận degree là danh mục dùng chung hay bản ghi theo từng user.
- Cần xác nhận field bắt buộc khi tạo/cập nhật.
