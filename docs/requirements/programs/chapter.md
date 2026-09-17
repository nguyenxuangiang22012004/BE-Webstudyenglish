# Tài Liệu BA Chi Tiết: Chapter

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-06-12
Related:
  - docs/api/programs/chapter.md
  - docs/security/resources/chapters.md
  - docs/requirements/programs/program.md
  - docs/requirements/learning-materials/lesson.md
  - docs/test-cases/overview.md

Business rule IDs:
  - CHP-BR-001: Chapter là đơn vị nhóm bài học trong chương trình học hoặc khóa học.
  - CHP-BR-002: Chapter giúp sắp xếp lesson theo cấu trúc nội dung.
  - CHP-BR-003: Chapter được quản lý theo quyền RBAC resource `chapters`.

## 1. Khái niệm chapter

Chapter là chương hoặc cụm nội dung dùng để nhóm các bài học trong program/course.

Chapter giúp:
- Chia chương trình học thành các phần nội dung.
- Sắp xếp thứ tự bài học.
- Lọc hoặc hiển thị bài học theo cấu trúc chương.

## 2. Phạm vi chức năng hiện có

API hiện có:
- `GET /v1/chapters`
- `POST /v1/chapters`
- `GET /v1/chapters/{id}`
- `PUT /v1/chapters/{id}`
- `DELETE /v1/chapters/{id}`

Danh sách hỗ trợ `keyword`, `status`, `program_id` và sort nếu API nhận.

## 3. Quan hệ với đối tượng khác

- Program: chapter thuộc hoặc được lọc theo program.
- Lesson: chapter chứa danh sách lesson.
- Course: khi program được tạo thành course, chapter có thể được sao chép theo cấu trúc học liệu.

## 4. Quy tắc nghiệp vụ chính

- Chapter cần có tên và vị trí rõ ràng trong program/course.
- Xóa chapter đã có lesson cần kiểm tra ràng buộc backend.
- Khi sao chép program sang course, chapter cần giữ quan hệ với lesson tương ứng nếu backend hỗ trợ.

## 5. Ghi chú và điểm cần xác nhận

- Cần xác nhận chapter có hỗ trợ sort_position riêng hay không.
- Cần xác nhận xóa chapter có xóa/di chuyển lesson con hay bị chặn.
