# Tài Liệu BA Chi Tiết: Tags

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-06-12
Related:
  - docs/api/learning-materials/tag.md
  - docs/security/resources/tags.md
  - docs/requirements/learning-materials/question-bank.md
  - docs/test-cases/overview.md

Business rule IDs:
  - TAG-BR-001: Tag là nhãn phân loại dùng lại cho câu hỏi hoặc học liệu.
  - TAG-BR-002: Tag hỗ trợ tìm kiếm, lọc và tổ chức dữ liệu học tập.
  - TAG-BR-003: Tag đã được sử dụng cần được kiểm soát khi sửa hoặc xóa.

## 1. Khái niệm tag

Tag là nhãn phân loại linh hoạt dùng để gắn vào câu hỏi hoặc học liệu.

Tag giúp:
- Tìm kiếm nhanh nội dung liên quan.
- Phân nhóm câu hỏi/học liệu theo chủ đề nhỏ.
- Hỗ trợ quy trình soạn bài và rà soát nội dung.

## 2. Phạm vi chức năng hiện có

API hiện có:
- `GET /v1/tags`
- `POST /v1/tags`
- `GET /v1/tags/{id}`
- `PUT /v1/tags/{id}`
- `DELETE /v1/tags/{id}`

Danh sách hỗ trợ lọc theo `keyword`, `status`, `type` và sort nếu API nhận.

## 3. Quy tắc nghiệp vụ chính

- Tag nên có tên ngắn, dễ nhận diện và tránh trùng nghĩa.
- Tag có thể được dùng trong bộ lọc question bank hoặc các học liệu liên quan.
- Xóa tag cần xác nhận tác động tới nội dung đang gắn tag.

## 4. Ghi chú và điểm cần xác nhận

- Cần xác nhận tag có unique theo type hay toàn hệ thống.
- Cần xác nhận tag inactive có còn hiển thị trong dữ liệu cũ hay không.
- Cần xác nhận module nào ngoài question bank đang dùng tag.
