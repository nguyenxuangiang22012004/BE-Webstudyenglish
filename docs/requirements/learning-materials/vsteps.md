# Tài Liệu BA Chi Tiết: VSTEP

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-06-12
Related:
  - docs/api/learning-materials/vstep.md
  - docs/security/resources/vsteps.md
  - docs/requirements/learning-materials/lesson.md
  - docs/requirements/learning-materials/question-bank.md
  - docs/test-cases/overview.md

Business rule IDs:
  - VST-BR-001: VSTEP là hoạt động học tập/đánh giá có cấu trúc riêng trong lesson.
  - VST-BR-002: VSTEP có thể sử dụng câu hỏi và cấu hình bài làm tương tự nhóm assessment/exam tùy backend.
  - VST-BR-003: VSTEP cần được quản lý theo quyền RBAC resource `vsteps`.

## 1. Khái niệm VSTEP

VSTEP là một dạng hoạt động học tập hoặc đánh giá liên quan tới chuẩn năng lực tiếng Anh VSTEP.

Trong overview bài học, VSTEP được nhắc như một thành phần có thể nằm trong lesson.

## 2. Phạm vi chức năng hiện có

API hiện có:
- `GET /v1/vsteps`
- `POST /v1/vsteps`
- `GET /v1/vsteps/{id}`
- `PUT /v1/vsteps/{id}`
- `DELETE /v1/vsteps/{id}`

Swagger ghi nhận tổng cộng 7 operation cho `VstepService`; cần đối chiếu file API đầy đủ khi triển khai test chi tiết.

## 3. Quan hệ với đối tượng khác

- Lesson: VSTEP có thể là thành phần trong bài học.
- Question bank: VSTEP có thể sử dụng câu hỏi tùy cấu hình backend.
- Student result: nếu VSTEP có lượt làm, kết quả cần gắn với người học và bối cảnh course/lesson.

## 4. Quy tắc nghiệp vụ chính

- Người dùng chỉ tạo/sửa/xóa VSTEP khi có quyền.
- Danh sách VSTEP cần hỗ trợ phân trang, tìm kiếm và sort nếu API nhận.
- VSTEP đã có lượt làm hoặc kết quả cần được kiểm soát khi sửa/xóa.
- Nếu VSTEP được gắn vào lesson, trạng thái lesson cần phản ánh dữ liệu VSTEP hợp lệ.

## 5. Ghi chú và điểm cần xác nhận

- Cần xác nhận UI quản lý VSTEP hiện nằm ở route nào hoặc chỉ có backend API.
- Cần xác nhận VSTEP khác exam/assessment ở các field nghiệp vụ nào.
- Cần xác nhận VSTEP có submit, save progress và result riêng hay không.
