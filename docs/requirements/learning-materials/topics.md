# Tài Liệu BA Chi Tiết: Topics

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-06-12
Related:
  - docs/api/learning-materials/topic.md
  - docs/security/resources/topics.md
  - docs/requirements/learning-materials/question-bank.md
  - docs/test-cases/overview.md

Business rule IDs:
  - TOP-BR-001: Topic là chủ đề dùng để phân loại nội dung học tập hoặc câu hỏi.
  - TOP-BR-002: Topic có thể có quan hệ cha/con nếu API dùng `parent_id`.
  - TOP-BR-003: Topic hỗ trợ lọc nội dung theo chủ đề học tập.

## 1. Khái niệm topic

Topic là chủ đề học tập hoặc nhóm nội dung dùng để phân loại câu hỏi/học liệu.

Topic giúp người dùng chọn nội dung đúng phạm vi kiến thức khi tạo hoạt động học tập.

## 2. Phạm vi chức năng hiện có

API hiện có:
- `GET /v1/topics`
- `POST /v1/topics`
- `GET /v1/topics/{id}`
- `PUT /v1/topics/{id}`
- `DELETE /v1/topics/{id}`

Danh sách hỗ trợ lọc theo `keyword`, `status`, `type`, `parent_id` và sort nếu API nhận.

## 3. Quan hệ với đối tượng khác

- Question: câu hỏi có thể gắn topic để lọc và thống kê.
- Skill/tag: topic có thể phối hợp với các danh mục phân loại khác.
- Lesson/course: topic có thể phản ánh chủ đề nội dung học.

## 4. Quy tắc nghiệp vụ chính

- Topic có parent cần tránh vòng lặp cha/con.
- Topic bị xóa hoặc inactive cần xác định ảnh hưởng tới nội dung đang gắn.
- Bộ lọc theo topic cần giữ đúng ngữ cảnh subject/course nếu UI có truyền.

## 5. Ghi chú và điểm cần xác nhận

- Cần xác nhận topic có bắt buộc gắn subject không.
- Cần xác nhận độ sâu tối đa của cây topic.
- Cần xác nhận topic dùng cho question bank hay cả lesson/course.
