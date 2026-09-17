# Tài Liệu BA Chi Tiết: Grade

Status: reviewed
Owner: BA/DEV
Last reviewed: 2026-09-16
Related:
  - docs/api/schools/grade.md
  - docs/security/resources/grades.md
  - docs/requirements/schools/class.md
  - docs/test-cases/overview.md

Business rule IDs:
  - GRD-BR-001: Grade là khối/cấp lớp dùng để phân loại lớp học và học sinh.
  - GRD-BR-002: Grade hỗ trợ tổ chức dữ liệu trường học và chương trình học.
  - GRD-BR-003: Grade cần đủ khả năng biểu diễn 12 khối học nếu LMS vận hành cho cấp 1, cấp 2 và cấp 3.

Review note: Grade là dữ liệu dùng chung toàn hệ thống, có trạng thái active/inactive. Cấp học được suy ra từ `number`, không có field nhóm cấp học riêng.

## 1. Khái niệm grade

Grade là khối lớp hoặc cấp học, dùng để phân loại class và nội dung học tập.

Với mô hình K-12, grade nên biểu diễn được các khối từ lớp 1 đến lớp 12.

Có thể nhóm grade theo cấp học:

- Tiểu học: lớp 1 đến lớp 5.
- THCS: lớp 6 đến lớp 9.
- THPT: lớp 10 đến lớp 12.

Trong code frontend, grade có các trường `number`, `name_vn`, `name_en`.

## 2. Phạm vi chức năng hiện có

API hiện có:
- `GET /v1/grades`
- `POST /v1/grades`
- `GET /v1/grades/{id}`
- `PUT /v1/grades/{id}`
- `DELETE /v1/grades/{id}`

## 3. Quy tắc nghiệp vụ chính

- Grade cần có tên rõ ràng và tránh trùng lặp trong cùng phạm vi.
- Class có thể tham chiếu grade để xác định khối học.
- Program, course, học liệu, flipbook, câu hỏi hoặc báo cáo có thể dùng grade để lọc/phân loại nếu nghiệp vụ yêu cầu.
- Grade là dữ liệu dùng chung, không chia theo school.
- Grade có trạng thái active/inactive.
- Nhóm cấp học như tiểu học, THCS, THPT được suy ra từ `number`.
- Xóa grade đang được class sử dụng cần kiểm tra ràng buộc backend.

## 4. Ghi chú kiểm thử

- Khi test danh sách grade, cần kiểm tra lọc/hiển thị theo trạng thái active/inactive nếu màn hình có hỗ trợ.
- Khi test phân nhóm cấp học, dùng `number` làm nguồn suy ra nhóm lớp.
