# Tài liệu BA chi tiết: Năm học

Status: reviewed
Owner: BA/DEV
Last reviewed: 2026-09-16
Source: Đối chiếu code `src/api/school-years.ts`, route `src/app/[locale]/admin/school-years/page.tsx`, form năm học và các liên kết `school_year_id` trong semester/class.
Related:
  - docs/api/school-years.md
  - docs/requirements/semesters/semester.md
  - docs/requirements/schools/class.md
  - docs/test-cases/overview.md

Business rule IDs:
  - SYR-BR-001: Năm học là khung thời gian cấp cao để tổ chức học kỳ, lớp học, khóa học và báo cáo.
  - SYR-BR-002: Năm học có ngày bắt đầu và ngày kết thúc hợp lệ.
  - SYR-BR-003: Học kỳ và lớp học có thể tham chiếu `school_year_id` để phân tách dữ liệu theo năm học.
  - SYR-BR-004: Không nên xóa cứng năm học đã có dữ liệu liên quan nếu backend chưa chặn bằng ràng buộc.

Review note: Năm học là dữ liệu dùng chung toàn hệ thống, không chia theo school. Trường `close_course_date` dùng để chuyển `status` của course thành `false`, tức đóng khóa học.

## 1. Khái niệm năm học

Năm học là đơn vị thời gian cấp cao của hệ thống LMS.

Năm học dùng để:

- Tổ chức học kỳ và tuần học.
- Phân tách lớp học theo từng giai đoạn vận hành.
- Làm bối cảnh cho khóa học, lịch học và báo cáo.
- Hỗ trợ nhà trường xem dữ liệu theo từng năm học.

Trong code hiện tại, module năm học dùng thuật ngữ `school year` và API `/school-years`.

## 2. Phạm vi chức năng hiện có

Chức năng năm học hiện nằm tại route:

```text
/{locale}/admin/school-years
```

Các thao tác đang có:

- Xem danh sách năm học.
- Tìm kiếm theo từ khóa.
- Tạo năm học.
- Cập nhật năm học.
- Xóa năm học.
- Phân trang danh sách.

API hiện có trong frontend:

- `GET /school-years`
- `GET /school-years/{id}`
- `POST /school-years`
- `PUT /school-years/{id}`
- `DELETE /school-years/{id}`

## 3. Quan hệ với đối tượng khác

### 3.1. Quan hệ với học kỳ

Semester có trường `school_year_id`.

Năm học giúp nhóm các học kỳ theo cùng một giai đoạn học tập. Khi tạo hoặc sửa học kỳ, hệ thống cần chọn năm học nếu backend yêu cầu.

### 3.2. Quan hệ với lớp học

Class có thể có `school_year_id`, `school_year_name`, `school_year_start_date`, `school_year_end_date`.

Điều này cho phép nhà trường quản lý lớp theo từng năm học, ví dụ `6A - 2026-2027`.

### 3.3. Quan hệ với khóa học và lịch học

Khóa học có thể gián tiếp nằm trong năm học thông qua học kỳ, tuần học hoặc lớp học.

Nếu cần báo cáo theo năm học, hệ thống nên xác định nguồn chuẩn:

- Theo `school_year_id` của lớp.
- Theo `school_year_id` của học kỳ.
- Theo khóa học đang gắn học kỳ.

## 4. Thông tin của năm học

Một năm học gồm:

- `id`
- `name`
- `start_date`
- `end_date`
- `close_course_date` nếu có
- `created_at`
- `updated_at`

## 5. Quy tắc nghiệp vụ

- `name`, `start_date`, `end_date` là thông tin bắt buộc khi tạo.
- `start_date` phải nhỏ hơn hoặc bằng `end_date`.
- Tên năm học nên rõ ràng, ví dụ `2026-2027`.
- Nếu đã có semester, class, course hoặc report liên quan, nên ưu tiên khóa/ngưng sử dụng thay vì xóa cứng.
- Khi lọc báo cáo theo năm học, cần thống nhất lấy năm học từ class, semester hay course.
- Năm học là dữ liệu dùng chung toàn hệ thống, không phân tách theo school.
- `close_course_date` dùng để đóng khóa học bằng cách chuyển `status` của course thành `false`.

## 6. Ghi chú kiểm thử

- Khi test xóa năm học đã được semester/class sử dụng, cần ghi nhận hành vi thực tế của backend.
- Khi test nhiều năm học có thời gian overlap, cần ghi nhận backend cho phép hay trả lỗi để bổ sung test case chi tiết.
