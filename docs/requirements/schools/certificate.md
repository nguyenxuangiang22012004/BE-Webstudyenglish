# Tài Liệu BA Chi Tiết: Certificate

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-06-12
Related:
  - docs/api/schools/certificate.md
  - docs/security/resources/certificates.md
  - docs/requirements/users/user.md
  - docs/test-cases/overview.md

Business rule IDs:
  - CER-BR-001: Certificate ghi nhận chứng chỉ của user hoặc kết quả liên quan đến course.
  - CER-BR-002: Certificate có thể được lọc theo user, course và trạng thái.

## 1. Khái niệm certificate

Certificate là chứng chỉ hoặc ghi nhận hoàn thành được gắn với user và có thể liên quan đến course.

## 2. Phạm vi chức năng hiện có

API hiện có:
- `GET /v1/certificates`
- `POST /v1/certificates`
- `GET /v1/certificates/{id}`
- `PUT /v1/certificates/{id}`
- `DELETE /v1/certificates/{id}`

Danh sách hỗ trợ `keyword`, `user_id`, `course_id`, `status` và sort nếu API nhận.

## 3. Quy tắc nghiệp vụ chính

- Certificate cần gắn đúng user và course nếu có.
- Certificate có thể dùng để hiển thị thành tích/hồ sơ học tập.
- Xóa certificate cần kiểm tra ảnh hưởng tới hồ sơ hoặc báo cáo.

## 4. Ghi chú và điểm cần xác nhận

- Cần xác nhận certificate do hệ thống tự sinh hay người quản trị tạo thủ công.
- Cần xác nhận điều kiện cấp certificate.
