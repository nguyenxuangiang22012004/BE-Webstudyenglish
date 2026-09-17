# Tài Liệu BA Chi Tiết: Nguồn Câu Hỏi

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-06-12
Related:
  - docs/api/learning-materials/source-question.md
  - docs/security/resources/source-questions.md
  - docs/requirements/learning-materials/question-bank.md
  - docs/test-cases/overview.md

Business rule IDs:
  - SQN-BR-001: Source question dùng để phân loại nguồn gốc câu hỏi trong question bank.
  - SQN-BR-002: Người dùng có quyền có thể quản lý danh mục nguồn câu hỏi.
  - SQN-BR-003: Nguồn câu hỏi đã được sử dụng cần được kiểm soát khi sửa hoặc xóa.

## 1. Khái niệm nguồn câu hỏi

Nguồn câu hỏi là danh mục mô tả câu hỏi được lấy từ đâu hoặc thuộc bộ tài liệu nào.

Nguồn câu hỏi giúp:
- Truy vết nguồn tạo câu hỏi.
- Lọc câu hỏi khi soạn bài tập, bài kiểm tra hoặc đề luyện tập.
- Chuẩn hóa dữ liệu ngân hàng câu hỏi.

## 2. Phạm vi chức năng hiện có

API hiện có:
- `GET /v1/source-questions`
- `POST /v1/source-questions`
- `GET /v1/source-questions/{id}`
- `PUT /v1/source-questions/{id}`
- `DELETE /v1/source-questions/{id}`

Danh sách hỗ trợ lọc theo `keyword`, `status` và sort theo id/created_at nếu API nhận.

## 3. Quan hệ với đối tượng khác

- Question bank: câu hỏi có thể gắn nguồn câu hỏi.
- Subject/course/lesson: nguồn câu hỏi có thể hỗ trợ lọc khi chọn câu hỏi cho học liệu.

## 4. Quy tắc nghiệp vụ chính

- Tên nguồn câu hỏi cần đủ rõ để người soạn câu hỏi phân biệt.
- Xóa nguồn câu hỏi đã được dùng cần kiểm tra ràng buộc backend.
- Danh sách nguồn câu hỏi nên hỗ trợ trạng thái hoạt động/ngưng hoạt động nếu API có.

## 5. Ghi chú và điểm cần xác nhận

- Cần xác nhận nguồn câu hỏi có unique theo tên hay mã không.
- Cần xác nhận xóa là xóa mềm hay xóa cứng.
- Cần xác nhận câu hỏi đang gắn source bị xử lý thế nào khi source bị xóa.
