# Tài Liệu BA Chi Tiết: Lesson Plan

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-06-12
Related:
  - docs/api/programs/lesson-plan.md
  - docs/security/resources/lesson-plans.md
  - docs/requirements/learning-materials/lesson.md
  - docs/test-cases/overview.md

Business rule IDs:
  - LPN-BR-001: Lesson plan là giáo án hoặc kế hoạch dạy học gắn với lesson.
  - LPN-BR-002: Lesson plan có thể gồm nhiều phần lesson plan part.
  - LPN-BR-003: Lesson plan được quản lý theo quyền RBAC resource `lesson-plans`.

## 1. Khái niệm lesson plan

Lesson plan là kế hoạch dạy học hoặc giáo án cho một bài học.

Lesson plan giúp giáo viên/người quản trị mô tả cách triển khai bài học, hoạt động dạy học và cấu trúc nội dung cần dùng.

## 2. Phạm vi chức năng hiện có

API hiện có:
- `GET /v1/lesson-plans`
- `POST /v1/lesson-plans`
- `GET /v1/lesson-plans/{id}`
- `PUT /v1/lesson-plans/{id}`
- `DELETE /v1/lesson-plans/{id}`

Danh sách hỗ trợ lọc theo `lesson_id`, `keyword` và sort nếu API nhận.

## 3. Quan hệ với đối tượng khác

- Lesson: lesson plan gắn với lesson.
- Lesson plan part: mỗi lesson plan có thể có nhiều phần nội dung chi tiết.
- Course: lesson plan part có thể được lọc theo course trong API riêng.

## 4. Quy tắc nghiệp vụ chính

- Một lesson có thể có lesson plan nếu nghiệp vụ yêu cầu chuẩn bị giáo án.
- Xóa lesson plan cần kiểm tra các part con.
- Khi lesson được sao chép sang course, cần xác nhận lesson plan có được sao chép theo hay không.

## 5. Ghi chú và điểm cần xác nhận

- Cần xác nhận một lesson có một hay nhiều lesson plan.
- Cần xác nhận lesson plan có trạng thái duyệt/publish hay chỉ là nội dung nội bộ.
