# Tài Liệu BA Chi Tiết: Lesson Plan Part

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-06-12
Related:
  - docs/api/programs/lesson-plan-part.md
  - docs/security/resources/lesson-plan-parts.md
  - docs/requirements/programs/lesson-plan.md
  - docs/test-cases/overview.md

Business rule IDs:
  - LPP-BR-001: Lesson plan part là phần chi tiết trong lesson plan.
  - LPP-BR-002: Lesson plan part giúp chia giáo án thành các hoạt động hoặc mục nội dung.
  - LPP-BR-003: Lesson plan part được quản lý theo quyền RBAC resource `lesson-plan-parts`.

## 1. Khái niệm lesson plan part

Lesson plan part là một phần nhỏ trong lesson plan, dùng để mô tả hoạt động, nội dung hoặc bước triển khai cụ thể.

## 2. Phạm vi chức năng hiện có

API hiện có:
- `GET /v1/lesson-plan-parts`
- `POST /v1/lesson-plan-parts`
- `GET /v1/lesson-plan-parts/{id}`
- `PUT /v1/lesson-plan-parts/{id}`
- `DELETE /v1/lesson-plan-parts/{id}`

Danh sách hỗ trợ `lesson_plan_id`, `course_id` và sort nếu API nhận.

## 3. Quan hệ với đối tượng khác

- Lesson plan: part thuộc về một lesson plan.
- Course: part có thể được vận hành hoặc lọc theo course.

## 4. Quy tắc nghiệp vụ chính

- Part cần giữ đúng thứ tự nếu lesson plan có cấu trúc tuần tự.
- Xóa part không nên làm mất dữ liệu lesson plan khác.
- Nếu part theo course khác với part gốc, cần xác nhận cơ chế đồng bộ.

## 5. Ghi chú và điểm cần xác nhận

- Cần xác nhận part có loại nội dung chuẩn hay chỉ là text/free-form.
- Cần xác nhận rule sao chép part từ program sang course.
