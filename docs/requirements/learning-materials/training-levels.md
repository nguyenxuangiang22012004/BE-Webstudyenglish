# Tài Liệu BA Chi Tiết: Trình Độ Đào Tạo

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-06-12
Related:
  - docs/api/learning-materials/training-level.md
  - docs/security/resources/training-levels.md
  - docs/requirements/learning-materials/question-bank.md
  - docs/test-cases/overview.md

Business rule IDs:
  - TRL-BR-001: Training level là trình độ đào tạo hoặc cấp độ học tập dùng để phân loại nội dung.
  - TRL-BR-002: Training level hỗ trợ lọc câu hỏi/học liệu theo mức độ hoặc đối tượng học.
  - TRL-BR-003: Training level đã dùng trong dữ liệu học tập cần được kiểm soát khi sửa hoặc xóa.

## 1. Khái niệm training level

Training level là danh mục trình độ đào tạo hoặc cấp độ học tập.

Danh mục này giúp phân loại nội dung theo độ phù hợp với người học hoặc chương trình học.

## 2. Phạm vi chức năng hiện có

API hiện có:
- `GET /v1/training-levels`
- `POST /v1/training-levels`
- `GET /v1/training-levels/{id}`
- `PUT /v1/training-levels/{id}`
- `DELETE /v1/training-levels/{id}`

Danh sách hỗ trợ lọc theo `keyword`, `status` và sort nếu API nhận.

## 3. Quan hệ với đối tượng khác

- Question bank: câu hỏi có thể được phân loại theo training level.
- Program/course: chương trình hoặc khóa học có thể dùng training level để xác định đối tượng.
- Skill/topic: training level có thể phối hợp với các phân loại khác.

## 4. Quy tắc nghiệp vụ chính

- Training level cần có tên rõ ràng và tránh trùng lặp.
- Nội dung inactive không nên được chọn mới nếu UI/backend áp dụng rule trạng thái.
- Xóa training level đang được dùng cần kiểm tra ràng buộc.

## 5. Ghi chú và điểm cần xác nhận

- Cần xác nhận training level có tương ứng với grade/cấp học hay là danh mục riêng.
- Cần xác nhận trường bắt buộc khi tạo/cập nhật.
- Cần xác nhận rule hiển thị training level trong question bank.
