# Tài Liệu BA Chi Tiết: Holiday

Status: reviewed
Owner: BA/DEV
Last reviewed: 2026-09-16
Related:
  - docs/api/semesters/holiday.md
  - docs/security/resources/holidays.md
  - docs/requirements/semesters/semester.md
  - docs/test-cases/overview.md

Business rule IDs:
  - HLD-BR-001: Holiday là ngày nghỉ ảnh hưởng đến lịch học hoặc vận hành học kỳ.
  - HLD-BR-002: Holiday có thể được lọc theo trạng thái và loại.

Review note: Holiday áp dụng theo semester tương ứng và có thể là khoảng nghỉ nhiều ngày.

## 1. Khái niệm holiday

Holiday là ngày nghỉ hoặc khoảng thời gian nghỉ được cấu hình trong hệ thống.

Holiday giúp hệ thống điều chỉnh lịch học, lịch dạy hoặc báo cáo theo thời gian học thực tế.

## 2. Phạm vi chức năng hiện có

API hiện có:
- `GET /v1/holidays`
- `POST /v1/holidays`
- `GET /v1/holidays/{id}`
- `PUT /v1/holidays/{id}`
- `DELETE /v1/holidays/{id}`

Danh sách hỗ trợ `keyword`, `status`, `type`.

## 3. Quan hệ với đối tượng khác

- Semester/week: holiday áp dụng theo semester tương ứng và có thể ảnh hưởng lịch học trong học kỳ đó.
- Course schedule: lịch học cần xử lý ngày nghỉ nếu backend áp dụng.

## 4. Quy tắc nghiệp vụ chính

- Holiday cần có ngày/thời gian rõ ràng.
- Holiday có thể kéo dài nhiều ngày, thường được hiểu là một khoảng từ ngày bắt đầu đến ngày kết thúc.
- Lịch học trùng holiday cần có rule xử lý: bỏ qua, dời lịch hoặc vẫn giữ.
- Xóa holiday đã ảnh hưởng lịch học cần kiểm tra tác động.

## 5. Ghi chú kiểm thử

- Khi test lịch học trùng holiday, cần ghi nhận rõ backend xử lý bỏ qua, dời lịch hay vẫn giữ lịch.
- Khi test xóa holiday đã ảnh hưởng lịch học, cần ghi nhận tác động thực tế tới lịch học đã sinh.
