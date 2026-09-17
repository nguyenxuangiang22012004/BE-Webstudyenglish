# Tài Liệu BA Chi Tiết: H5P

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-06-12
Related:
  - docs/api/interactive-contents/h5-p.md
  - docs/requirements/media/media.md
  - docs/requirements/learning-materials/lesson.md
  - docs/test-cases/overview.md

Business rule IDs:
  - H5P-BR-001: H5P là nội dung tương tác có thể được quản lý và xem trước trong LMS.
  - H5P-BR-002: H5P cần có danh sách, xem chi tiết/preview và xóa theo quyền.
  - H5P-BR-003: Nội dung H5P khi render lỗi cần có trạng thái fallback rõ ràng.

## 1. Khái niệm H5P

H5P là dạng học liệu tương tác dùng để trình bày nội dung hoặc hoạt động học tập có tính tương tác.

Trong code hiện tại, H5P có route quản trị `/admin/h5p` và route preview `/admin/h5p/[id]/preview`.

## 2. Phạm vi chức năng hiện có

API hiện có:
- `GET /v1/h5p`
- `GET /v1/h5p/{content_id}`
- `DELETE /v1/h5p/{content_id}`

Các chức năng chính:
- Xem danh sách H5P.
- Tìm kiếm theo keyword.
- Xem hoặc preview một nội dung H5P.
- Xóa nội dung H5P.

## 3. Quan hệ với các đối tượng khác

### 3.1. Quan hệ với media

H5P thường dựa trên file hoặc package nội dung được upload trước đó.

### 3.2. Quan hệ với lesson

Nếu H5P được gắn vào bài học, lesson là nơi học sinh nhìn thấy và tương tác với học liệu này.

## 4. Quy tắc nghiệp vụ chính

- Danh sách H5P cần hỗ trợ phân trang và tìm kiếm.
- Preview cần render đúng nội dung tương tác nếu dữ liệu hợp lệ.
- Khi nội dung không render được, UI cần hiển thị trạng thái lỗi thay vì trang trắng.
- Xóa H5P cần kiểm tra quyền và trạng thái đang được tham chiếu.

## 5. Ghi chú và điểm cần xác nhận

- Cần xác nhận luồng tạo/upload H5P nằm ở UI hiện tại hay hệ thống ngoài.
- Cần xác nhận H5P có ghi nhận tiến độ, điểm hoặc attempt của học sinh hay không.
- Cần xác nhận rule xóa H5P đã gắn vào lesson.
