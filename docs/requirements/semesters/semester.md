# Tài liệu BA chi tiết: Học kỳ

Status: reviewed
Owner: BA/DEV
Last reviewed: 2026-09-16
Related:
  - docs/requirements/semesters/school-year.md
  - docs/api/semesters/semester.md
  - docs/api/semesters/week.md
  - docs/api/semesters/holiday.md
  - docs/security/resources/semesters.md
  - docs/security/resources/holidays.md
  - docs/test-cases/overview.md
Business rule IDs:
  - SEM-BR-001: Semester tổ chức thời gian học và tuần học.
  - SEM-BR-002: Tuần học và ngày nghỉ thuộc hoặc liên quan tới semester.
  - SEM-BR-003: Lịch trình khóa học dùng semester/week để sắp xếp lesson.
  - SEM-BR-004: Dữ liệu gửi API cần giữ ID ngày nghỉ cũ và làm phẳng danh sách tuần khi lưu lịch trình.
  - SEM-BR-005: Semester thuộc một năm học thông qua `school_year_id`.

Review note: Đã xác nhận semester có `school_year_id`, có `previous_semester_id`, tuần học và ngày nghỉ; menu semester hiện bị ẩn với role `school` và cấu hình `PHX`.

## 1. Khái niệm học kỳ

Học kỳ là đơn vị thời gian dùng để tổ chức hoạt động học tập trong hệ thống LMS.

Học kỳ được quản lý ở khu vực admin và được dùng làm khung thời gian cho:

- Cấu hình ngày bắt đầu và ngày kết thúc của một giai đoạn học.
- Liên kết học kỳ với các tuần học.
- Khai báo các ngày nghỉ trong học kỳ.
- Gắn một hoặc nhiều học kỳ vào khóa học.
- Hiển thị lịch trình khóa học theo học kỳ và tuần học.

Học kỳ không phải là học liệu. Học kỳ là lớp thời gian vận hành để khóa học, bài học và lịch học có cơ sở sắp xếp theo tuần.

Trong code hiện tại, học kỳ có `school_year_id` và liên kết trực tiếp với năm học.

## 2. Phạm vi chức năng hiện có

Chức năng học kỳ hiện nằm tại route:

```text
/{locale}/admin/semesters
/{locale}/admin/semesters/create
/{locale}/admin/semesters/{id}/edit
```

Menu admin hiển thị mục quản lý học kỳ với đường dẫn `/admin/semesters`. Mục này đang bị ẩn với role `school` và bị ẩn với cấu hình `PHX`.

Các thao tác đang có:

- Xem danh sách học kỳ.
- Tạo học kỳ mới.
- Cập nhật học kỳ.
- Xóa học kỳ.
- Bật hoặc tắt trạng thái học kỳ.
- Thêm, sửa, xóa ngày nghỉ trong form học kỳ.

## 3. Quan hệ của học kỳ với các đối tượng khác

### 3.1. Quan hệ với tuần học

Học kỳ có thể liên kết với tuần bắt đầu và tuần kết thúc.

Danh sách tuần được lấy từ API `/weeks`. Mỗi tuần gồm:

- Mã tuần.
- Năm.
- Số tuần trong năm.
- Ngày bắt đầu.
- Ngày kết thúc.

Khi tạo hoặc sửa học kỳ, người dùng có thể chọn:

- Tuần bắt đầu.
- Tuần kết thúc.
- Không chọn tuần, khi giá trị là `0`.

Tuần học là dữ liệu nền để hệ thống xếp lịch bài học theo từng tuần trong học kỳ.

### 3.2. Quan hệ với học kỳ trước

Một học kỳ có thể tham chiếu đến học kỳ trước thông qua `previous_semester_id`.

Trên form, người dùng có thể chọn một học kỳ đã tồn tại làm học kỳ trước hoặc chọn "Không có" với giá trị `0`.

Quan hệ này giúp biểu diễn thứ tự vận hành giữa các học kỳ. Hệ thống chưa tự động kiểm tra chuỗi học kỳ hoặc tự động sắp xếp theo quan hệ này.

### 3.3. Quan hệ với ngày nghỉ

Một học kỳ có danh sách ngày nghỉ.

Ngày nghỉ được tạo và cập nhật cùng payload của học kỳ. Mỗi ngày nghỉ có thể có:

- Tên ngày nghỉ.
- Mô tả.
- Ngày bắt đầu.
- Ngày kết thúc.
- Tuần liên quan.
- Thứ tự sắp xếp.
- Trạng thái.

Ngày nghỉ là dữ liệu thuộc học kỳ, dùng để ghi nhận các khoảng thời gian không học hoặc không vận hành bình thường trong học kỳ.

### 3.4. Quan hệ với khóa học

Khóa học có thể gắn với một hoặc nhiều học kỳ.

Trong màn tạo khóa học, người dùng có thể:

- Tự chọn nhiều học kỳ từ danh sách học kỳ.
- Sao chép học kỳ từ một khóa học mẫu nếu chọn tạo theo mẫu.

Thông tin học kỳ được lưu vào khóa học gồm:

- Mã học kỳ.
- Tên học kỳ.
- Mô tả.
- Ngày bắt đầu.
- Ngày kết thúc.

Học kỳ là cơ sở để khóa học có khung thời gian triển khai và có lịch học theo tuần.

### 3.5. Quan hệ với lịch trình khóa học

Lịch trình khóa học được hiển thị theo cấu trúc:

```text
Khóa học
└─ Học kỳ
   └─ Tuần học
      └─ Bài học được xếp lịch
```

Màn lịch trình khóa học lấy dữ liệu từ API `/lessons/schedules?course_id={course_id}&week_by_course=true`.

Nếu API trả về danh sách học kỳ, hệ thống hiển thị các học kỳ và các tuần bên trong từng học kỳ. Nếu API chỉ trả về danh sách tuần, màn hình tạo một học kỳ mặc định để tương thích dữ liệu.

Người dùng có thể kéo bài học vào tuần học, xóa bài học khỏi tuần và lưu lại lịch trình. Khi lưu, hệ thống gửi danh sách tuần đã được làm phẳng từ tất cả học kỳ lên API `/lessons/schedules`.

## 4. Thông tin của học kỳ

Một học kỳ trong hệ thống hiện có các trường dữ liệu chính sau:

### 4.1. Thông tin định danh

- `id`: mã học kỳ.
- `name`: tên học kỳ.
- `description`: mô tả học kỳ.

### 4.2. Thông tin thời gian

- `start_date`: ngày bắt đầu học kỳ.
- `end_date`: ngày kết thúc học kỳ.
- `start_week_id`: tuần bắt đầu.
- `end_week_id`: tuần kết thúc.
- `previous_semester_id`: học kỳ trước nếu có.

### 4.3. Thông tin vận hành

- `status`: trạng thái hoạt động.
- `sort_order`: thứ tự sắp xếp.
- `created_at`: thời điểm tạo.
- `updated_at`: thời điểm cập nhật.

### 4.4. Thông tin ngày nghỉ

- `holidays`: danh sách ngày nghỉ thuộc học kỳ.

Mỗi ngày nghỉ gồm:

- `id`: mã ngày nghỉ.
- `semester_id`: mã học kỳ.
- `name`: tên ngày nghỉ.
- `description`: mô tả.
- `start_date`: ngày bắt đầu nghỉ.
- `end_date`: ngày kết thúc nghỉ.
- `week_id`: tuần liên quan nếu có.
- `sort_order`: thứ tự sắp xếp.
- `status`: trạng thái.
- `created_at`: thời điểm tạo.
- `updated_at`: thời điểm cập nhật.

## 5. Danh sách học kỳ

Màn danh sách học kỳ cho phép admin xem các học kỳ đang có trong hệ thống.

Dữ liệu được lấy từ API:

```text
GET /semesters
```

Response gồm:

- `semesters`: danh sách học kỳ.
- `total_count`: tổng số học kỳ theo response API.

Trên giao diện, bảng danh sách hiển thị:

- STT.
- Tên học kỳ.
- Ngày bắt đầu.
- Ngày kết thúc.
- Số dịp nghỉ.
- Trạng thái.
- Thao tác.

Trạng thái hiển thị:

- Hoạt động nếu `status = true`.
- Không hoạt động nếu `status = false`.

Ngày có giá trị rỗng hoặc `0001-01-01` được hiển thị là `-`.

Khi không có dữ liệu, màn hình hiển thị trạng thái không có học kỳ nào.

## 6. Tạo học kỳ

Màn tạo học kỳ cho phép admin khai báo học kỳ mới.

Dữ liệu được gửi đến API:

```text
POST /semesters
```

Thông tin cần nhập trên form:

- Tên học kỳ.
- Mô tả.
- Ngày bắt đầu.
- Ngày kết thúc.
- Tuần bắt đầu.
- Tuần kết thúc.
- Học kỳ trước nếu có.
- Trạng thái.
- Danh sách ngày nghỉ nếu có.

Tên học kỳ là trường bắt buộc. Form không submit nếu tên học kỳ rỗng.

Ngày bắt đầu và ngày kết thúc đang dùng input `date` và được đánh dấu bắt buộc trên UI.

Tuần bắt đầu, tuần kết thúc và học kỳ trước có lựa chọn "Không chọn" hoặc "Không có" với giá trị `0`.

Khi submit, hệ thống chuẩn hóa dữ liệu:

- Cắt khoảng trắng ở tên học kỳ.
- Cắt khoảng trắng ở mô tả học kỳ.
- Chuyển ngày học kỳ sang định dạng ISO.
- Gán `sort_order = 0`.
- Gửi trạng thái theo giá trị switch.
- Gửi danh sách ngày nghỉ trong cùng payload.

Nếu tạo thành công, hệ thống thông báo thành công và điều hướng về danh sách học kỳ.

Nếu tạo thất bại, hệ thống hiển thị thông báo không thể tạo học kỳ.

## 7. Cập nhật học kỳ

Màn cập nhật học kỳ cho phép admin sửa thông tin học kỳ đã tồn tại.

Dữ liệu chi tiết được lấy từ API:

```text
GET /semesters/{semesterId}
```

Dữ liệu cập nhật được gửi đến API:

```text
PUT /semesters/{semesterId}
```

Khi mở form sửa, hệ thống nạp dữ liệu học kỳ vào form:

- Tên học kỳ.
- Mô tả.
- Ngày bắt đầu.
- Ngày kết thúc.
- Tuần bắt đầu.
- Tuần kết thúc.
- Học kỳ trước.
- Trạng thái.
- Danh sách ngày nghỉ.

Ngày được chuyển về định dạng phù hợp cho input `date`.

Với ngày nghỉ đã tồn tại, hệ thống giữ lại `id` để API có thể nhận biết bản ghi cũ. Với ngày nghỉ mới, `id` rỗng.

Nếu tải chi tiết học kỳ lỗi, hệ thống hiển thị thông báo lỗi và điều hướng về danh sách học kỳ.

Nếu cập nhật thành công, hệ thống thông báo thành công và điều hướng về danh sách học kỳ.

Nếu cập nhật thất bại, hệ thống hiển thị thông báo không thể cập nhật học kỳ.

## 8. Xóa học kỳ

Màn danh sách học kỳ cho phép admin xóa học kỳ.

Dữ liệu được gửi đến API:

```text
DELETE /semesters/{semesterId}
```

Trước khi xóa, hệ thống hiển thị hộp xác nhận với tên học kỳ.

Nếu người dùng xác nhận và API xóa thành công:

- Hiển thị thông báo xóa thành công.
- Làm mới lại danh sách học kỳ.

Nếu API xóa thất bại:

- Hiển thị thông báo không thể xóa học kỳ.

Điều kiện chặn xóa khi học kỳ đã được gắn với khóa học, tuần học, lịch học hoặc ngày nghỉ nếu có sẽ do API xử lý.

## 9. Quản lý ngày nghỉ trong học kỳ

Ngày nghỉ được quản lý trực tiếp trong form tạo và sửa học kỳ.

Admin có thể:

- Thêm một ngày nghỉ mới.
- Nhập tên ngày nghỉ.
- Nhập mô tả ngày nghỉ.
- Chọn ngày bắt đầu.
- Chọn ngày kết thúc.
- Chọn tuần liên quan.
- Bật hoặc tắt trạng thái ngày nghỉ.
- Xóa ngày nghỉ khỏi form.

Tên ngày nghỉ, ngày bắt đầu và ngày kết thúc được đánh dấu bắt buộc trên UI.

Khi thêm ngày nghỉ mới, hệ thống gán mặc định:

- `id = ''`.
- `week_id = '0'`.
- `sort_order` bằng số lượng ngày nghỉ hiện có.
- `status = true`.

Khi học kỳ không có ngày nghỉ, form hiển thị trạng thái chưa có ngày nghỉ nào.

## 10. Trạng thái học kỳ

Học kỳ có trạng thái bật hoặc tắt.

Ý nghĩa theo giao diện:

- Bật: học kỳ được hiển thị và sử dụng.
- Tắt: học kỳ bị ẩn.

Trạng thái được nhập bằng switch trong form và được hiển thị bằng badge ở bảng danh sách.

Danh sách chọn học kỳ lấy từ API `/semesters` và hiển thị theo dữ liệu API trả về. Chưa có bộ lọc chỉ lấy học kỳ hoạt động khi chọn học kỳ cho khóa học.

## 11. Quy tắc nghiệp vụ hiện có

### 11.1. Quy tắc nhập liệu

- Tên học kỳ bắt buộc.
- Ngày bắt đầu học kỳ bắt buộc trên UI.
- Ngày kết thúc học kỳ bắt buộc trên UI.
- Tên ngày nghỉ bắt buộc khi có dòng ngày nghỉ.
- Ngày bắt đầu và ngày kết thúc ngày nghỉ bắt buộc khi có dòng ngày nghỉ.
- Tuần bắt đầu, tuần kết thúc, học kỳ trước và tuần của ngày nghỉ có thể không chọn.

### 11.2. Quy tắc dữ liệu gửi API

- Tạo và cập nhật học kỳ dùng cùng shape `CreateSemesterRequest`.
- Ngày học kỳ và ngày nghỉ được chuyển sang ISO trước khi gửi.
- Ngày nghỉ được gửi chung trong payload học kỳ.
- Khi sửa, ngày nghỉ cũ có `id`; ngày nghỉ mới không có `id`.
- `sort_order` của học kỳ được gửi cố định là `0`.

### 11.3. Quy tắc liên kết khóa học

- Một khóa học có thể chọn nhiều học kỳ.
- Khi chọn học kỳ cho khóa học, hệ thống lưu các trường cơ bản của học kỳ vào dữ liệu khóa học.
- Khi sao chép từ khóa học mẫu, hệ thống lấy danh sách học kỳ của khóa mẫu và map lại với danh sách học kỳ hiện có theo `id`.
- Nếu học kỳ của khóa mẫu không tồn tại trong danh sách học kỳ, học kỳ đó không được đưa vào danh sách đã chọn.

### 11.4. Quy tắc lịch học

- Lịch trình khóa học được tổ chức theo học kỳ và tuần học.
- Bài học có thể được kéo thả vào một tuần thuộc một học kỳ.
- Một bài học đã được gán vào tuần sẽ không nằm trong danh sách bài học chưa gán.
- Khi lưu lịch trình, hệ thống gửi toàn bộ tuần của tất cả học kỳ trong một danh sách tuần.

## 12. API liên quan

Các API học kỳ liên quan:

```text
GET /semesters
POST /semesters
GET /semesters/{semesterId}
PUT /semesters/{semesterId}
DELETE /semesters/{semesterId}
```

API tuần học liên quan:

```text
GET /weeks
```

API lịch trình khóa học liên quan:

```text
GET /lessons/schedules?course_id={course_id}&week_by_course=true
POST /lessons/schedules
```

## 13. Luồng màn hình chính

### 13.1. Luồng xem danh sách

1. Admin mở màn quản lý học kỳ.
2. Hệ thống gọi API lấy danh sách học kỳ.
3. Hệ thống hiển thị bảng học kỳ.
4. Admin có thể chọn tạo mới, sửa hoặc xóa học kỳ.

### 13.2. Luồng tạo mới

1. Admin chọn tạo học kỳ mới.
2. Hệ thống mở form học kỳ.
3. Hệ thống tải danh sách tuần và danh sách học kỳ để chọn học kỳ trước.
4. Admin nhập thông tin học kỳ và ngày nghỉ nếu có.
5. Admin submit form.
6. Hệ thống validate tên học kỳ.
7. Hệ thống gửi dữ liệu tạo học kỳ.
8. Thành công thì quay về danh sách học kỳ.

### 13.3. Luồng cập nhật

1. Admin chọn sửa một học kỳ.
2. Hệ thống tải chi tiết học kỳ theo `id`.
3. Hệ thống tải danh sách tuần và danh sách học kỳ.
4. Hệ thống nạp dữ liệu vào form.
5. Admin chỉnh sửa thông tin.
6. Admin submit form.
7. Hệ thống gửi dữ liệu cập nhật.
8. Thành công thì quay về danh sách học kỳ.

### 13.4. Luồng xóa

1. Admin chọn xóa một học kỳ.
2. Hệ thống hỏi xác nhận.
3. Nếu admin hủy, không thực hiện xóa.
4. Nếu admin xác nhận, hệ thống gọi API xóa học kỳ.
5. Thành công thì refresh danh sách.

## 14. Ghi chú khi viết test/API chi tiết

Các điểm dưới đây cần đối chiếu với API hoặc nghiệp vụ nếu viết test âm hoặc đặc tả chi tiết hơn:

- API có kiểm tra ngày kết thúc phải sau ngày bắt đầu hay không.
- API có kiểm tra tuần kết thúc phải sau tuần bắt đầu hay không.
- API có kiểm tra ngày nghỉ nằm trong khoảng thời gian học kỳ hay không.
- API có kiểm tra trùng thời gian giữa các học kỳ hay không.
- API có chặn xóa học kỳ đã gắn với khóa học hoặc lịch học hay không.
- `total_count` trong danh sách học kỳ có thể khác số phần tử đang hiển thị hay không.
- `status = false` có loại học kỳ khỏi các dropdown chọn học kỳ hay không.
- `previous_semester_id` có được dùng để tự động sắp xếp hoặc ràng buộc chuỗi học kỳ hay chỉ là thông tin tham chiếu.
