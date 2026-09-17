# Tài liệu BA chi tiết: Môn học

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-06-04
Related:
  - docs/api/subjects/subject.md
  - docs/api/subjects/subject-hook.md
  - docs/security/resources/subjects.md
  - docs/test-cases/overview.md
Business rule IDs:
  - SUB-BR-001: Subject là phân loại học thuật cho program, course, question bank và tiêu chí.
  - SUB-BR-002: Tên/mô tả subject được trim trước khi gửi API.
  - SUB-BR-003: Xóa subject có thể bị chặn nếu đã liên kết dữ liệu khác.
  - SUB-BR-004: Danh sách chọn subject ở module khác lấy từ API subjects.

## 1. Khái niệm môn học

Môn học là danh mục học thuật dùng để phân loại nội dung học tập trong hệ thống LMS.

Môn học đóng vai trò là lớp phân nhóm cấp cao cho:

- Chương trình học.
- Khóa học.
- Ngân hàng câu hỏi.
- Tiêu chí đánh giá.
- Báo cáo học tập và báo cáo đánh giá.
- Người dùng có phạm vi chuyên môn theo môn học nếu có.

Môn học không trực tiếp chứa bài học hoặc học liệu chi tiết. Môn học là dữ liệu nền để các module khác xác định nội dung thuộc lĩnh vực học tập nào.

## 2. Phạm vi chức năng

Chức năng quản lý môn học nằm tại các route:

```text
/{locale}/admin/subjects
/{locale}/admin/subjects/create
/{locale}/admin/subjects/{id}/edit
```

Menu admin hiển thị mục quản lý môn học với đường dẫn `/admin/subjects`. Mục này bị ẩn với cấu hình `PHX`.

Các thao tác chính:

- Xem danh sách môn học.
- Tạo môn học mới.
- Cập nhật môn học.
- Xóa môn học.
- Bật hoặc tắt trạng thái môn học.

Các thao tác tạo, sửa và xóa chịu kiểm soát bởi quyền:

- `subjects:store`: tạo môn học.
- `subjects:update`: cập nhật môn học.
- `subjects:destroy`: xóa môn học.

## 3. Quan hệ của môn học với các đối tượng khác

### 3.1. Quan hệ với chương trình học

Một chương trình học thuộc một môn học.

Môn học là căn cứ để phân loại chương trình học theo lĩnh vực học tập. Khi tạo hoặc sửa chương trình học, người dùng chọn môn học từ danh sách môn học.

Một môn học có thể có nhiều chương trình học.

### 3.2. Quan hệ với khóa học

Khóa học có thông tin môn học thông qua chương trình học hoặc dữ liệu chi tiết khóa học.

Danh sách khóa học có bộ lọc theo môn học. Khi người dùng chọn môn học, hệ thống gửi `subject_id` để lọc danh sách khóa học.

Môn học giúp người dùng tìm khóa học theo lĩnh vực học tập và giúp báo cáo nhóm dữ liệu khóa học theo môn.

### 3.3. Quan hệ với ngân hàng câu hỏi

Ngân hàng câu hỏi sử dụng môn học để phân loại câu hỏi và thuộc tính câu hỏi.

Khi tạo hoặc sửa câu hỏi, người dùng có thể chọn môn học. Hệ thống cũng dùng `subject_id` để lấy thuộc tính câu hỏi phù hợp với môn học.

Trong màn quản lý thuộc tính câu hỏi, một thuộc tính có thể áp dụng cho một hoặc nhiều môn học.

### 3.4. Quan hệ với bài đánh giá và tiêu chí

Các module đánh giá sử dụng môn học để xác định phạm vi áp dụng của bài đánh giá hoặc nhóm tiêu chí.

Môn học được dùng trong:

- Tạo và sửa assessment.
- Tiêu chí đánh giá.
- Tiêu chí báo cáo.
- Báo cáo học tập theo học sinh hoặc trường.

Việc gắn môn học giúp kết quả đánh giá và báo cáo được phân tách theo lĩnh vực học tập.

### 3.5. Quan hệ với người dùng

Thông tin người dùng có thể có danh sách môn học liên quan.

Môn học trong hồ sơ người dùng có thể dùng để mô tả phạm vi chuyên môn, môn phụ trách hoặc dữ liệu liên quan đến vai trò giảng dạy.

## 4. Thông tin của môn học

Một môn học gồm các thông tin chính sau:

### 4.1. Thông tin định danh

- `id`: mã môn học.
- `name`: tên môn học.
- `description`: mô tả môn học.

### 4.2. Thông tin vận hành

- `status`: trạng thái hoạt động.
- `created_at`: thời điểm tạo.
- `updated_at`: thời điểm cập nhật.

### 4.3. Thông tin mở rộng

- `type`: loại môn học nếu API trả về.

Trên màn quản lý hiện tại, form tạo và sửa chỉ nhập tên, mô tả và trạng thái. Trường `type` chưa được nhập trong form quản lý môn học.

## 5. Danh sách môn học

Màn danh sách môn học cho phép admin xem toàn bộ môn học trong hệ thống.

Dữ liệu được lấy từ API:

```text
GET /subjects
```

Response gồm:

- `subjects`: danh sách môn học.

Bảng danh sách hiển thị:

- STT.
- Tên môn học.
- Mô tả.
- Trạng thái.
- Ngày tạo.
- Thao tác.

Nếu môn học không có mô tả, bảng hiển thị `-`.

Ngày tạo được hiển thị theo định dạng ngày Việt Nam. Nếu không có ngày tạo, bảng hiển thị `-`.

Khi không có dữ liệu, màn hình hiển thị trạng thái không có môn học nào.

## 6. Tạo môn học

Màn tạo môn học cho phép admin khai báo môn học mới.

Dữ liệu được gửi đến API:

```text
POST /subjects
```

Thông tin cần nhập:

- Tên môn học.
- Mô tả.
- Trạng thái.

Tên môn học là trường bắt buộc. Form không submit nếu tên môn học rỗng.

Khi submit, hệ thống chuẩn hóa dữ liệu:

- Cắt khoảng trắng ở tên môn học.
- Cắt khoảng trắng ở mô tả.
- Gửi trạng thái theo giá trị switch.

Payload tạo môn học:

```text
name
description
status
```

Nếu tạo thành công, hệ thống thông báo thành công và điều hướng về danh sách môn học.

Nếu tạo thất bại, hệ thống hiển thị thông báo không thể tạo môn học.

## 7. Cập nhật môn học

Màn cập nhật môn học cho phép admin sửa thông tin môn học đã tồn tại.

Dữ liệu chi tiết được lấy từ API:

```text
GET /subjects/{id}
```

Dữ liệu cập nhật được gửi đến API:

```text
PUT /subjects/{id}
```

Khi mở form sửa, hệ thống nạp dữ liệu môn học vào form:

- Tên môn học.
- Mô tả.
- Trạng thái.

Payload cập nhật môn học:

```text
name
description
status
```

Nếu không tải được dữ liệu môn học, hệ thống thông báo lỗi và điều hướng về danh sách môn học hoặc giữ người dùng ở màn hiện tại tùy trạng thái lỗi.

Nếu cập nhật thành công, hệ thống thông báo thành công và điều hướng về danh sách môn học.

Nếu cập nhật thất bại, hệ thống hiển thị thông báo không thể cập nhật môn học.

## 8. Xóa môn học

Màn danh sách môn học cho phép admin xóa môn học.

Dữ liệu được gửi đến API:

```text
DELETE /subjects/{id}
```

Trước khi xóa, hệ thống hiển thị hộp xác nhận với tên môn học.

Nếu người dùng xác nhận và API xóa thành công:

- Hệ thống hiển thị thông báo xóa thành công.
- Hệ thống làm mới danh sách môn học.

Nếu API xóa thất bại:

- Hệ thống hiển thị thông báo không thể xóa môn học.

Điều kiện chặn xóa khi môn học đã được gắn với chương trình học, khóa học, câu hỏi, tiêu chí hoặc báo cáo nếu có sẽ do API xử lý.

## 9. Trạng thái môn học

Môn học có trạng thái bật hoặc tắt.

Ý nghĩa theo giao diện:

- Bật: môn học được hiển thị và sử dụng.
- Tắt: môn học bị ẩn.

Trạng thái được nhập bằng switch trong form và được hiển thị bằng badge ở bảng danh sách.

Danh sách chọn môn học ở các module khác lấy dữ liệu từ API `/subjects`. Chưa có quy tắc riêng trên giao diện chỉ lấy môn học hoạt động.

## 10. Quy tắc nghiệp vụ chính

### 10.1. Quy tắc nhập liệu

- Tên môn học bắt buộc.
- Mô tả không bắt buộc.
- Trạng thái mặc định khi tạo mới là hoạt động.
- Tên và mô tả được cắt khoảng trắng trước khi gửi API.

### 10.2. Quy tắc quyền

- Người dùng chỉ thấy nút tạo môn học khi có quyền `subjects:store`.
- Người dùng chỉ thấy nút sửa môn học khi có quyền `subjects:update`.
- Người dùng chỉ thấy nút xóa môn học khi có quyền `subjects:destroy`.

### 10.3. Quy tắc liên kết chương trình học

- Chương trình học cần gắn với môn học.
- Danh sách môn học trong form chương trình học được sắp xếp theo tên.
- Nếu không có môn học, form chương trình học hiển thị trạng thái không có môn học nào.

### 10.4. Quy tắc lọc khóa học

- Danh sách khóa học có thể lọc theo môn học.
- Khi chọn môn học, hệ thống gửi `subject_id` trong params lấy danh sách khóa học.
- Khi đổi môn học lọc, phân trang được đưa về trang đầu.

### 10.5. Quy tắc áp dụng cho thuộc tính câu hỏi

- Thuộc tính câu hỏi có thể áp dụng cho nhiều môn học.
- Người dùng có thể chọn từng môn học hoặc chọn tất cả môn học.
- Khi chọn tất cả, hệ thống lấy toàn bộ `id` môn học trong danh sách môn học.

## 11. API liên quan

Các API môn học:

```text
GET /subjects
POST /subjects
GET /subjects/{id}
PUT /subjects/{id}
DELETE /subjects/{id}
```

Một số API module khác sử dụng `subject_id`:

```text
GET /programs
GET /courses
GET /question-attributes?subject_id={subject_id}
```

Các module assessment, criteria và report cũng sử dụng môn học để lọc hoặc gắn phạm vi dữ liệu.

## 12. Luồng màn hình chính

### 12.1. Luồng xem danh sách

1. Admin mở màn quản lý môn học.
2. Hệ thống gọi API lấy danh sách môn học.
3. Hệ thống hiển thị bảng môn học.
4. Admin có thể tạo mới, sửa hoặc xóa môn học tùy quyền.

### 12.2. Luồng tạo mới

1. Admin chọn tạo môn học mới.
2. Hệ thống mở form tạo môn học.
3. Admin nhập tên, mô tả và trạng thái.
4. Admin submit form.
5. Hệ thống validate tên môn học.
6. Hệ thống gửi dữ liệu tạo môn học.
7. Thành công thì quay về danh sách môn học.

### 12.3. Luồng cập nhật

1. Admin chọn sửa một môn học.
2. Hệ thống tải chi tiết môn học theo `id`.
3. Hệ thống nạp dữ liệu vào form.
4. Admin chỉnh sửa thông tin.
5. Admin submit form.
6. Hệ thống validate tên môn học.
7. Hệ thống gửi dữ liệu cập nhật.
8. Thành công thì quay về danh sách môn học.

### 12.4. Luồng xóa

1. Admin chọn xóa một môn học.
2. Hệ thống hỏi xác nhận.
3. Nếu admin hủy, không thực hiện xóa.
4. Nếu admin xác nhận, hệ thống gọi API xóa môn học.
5. Thành công thì làm mới danh sách.

## 13. Ghi chú và điểm cần xác nhận

Các điểm dưới đây cần xác nhận với API hoặc nghiệp vụ nếu viết đặc tả chi tiết hơn:

- API có kiểm tra trùng tên môn học hay không.
- API có chặn xóa môn học đã gắn với chương trình học, khóa học, câu hỏi hoặc báo cáo hay không.
- `status = false` có loại môn học khỏi các dropdown chọn môn học hay không.
- Trường `type` có còn dùng trong nghiệp vụ môn học hay không.
- Môn học có cần phân cấp theo nhóm môn, khối lớp hoặc chương trình đào tạo hay không.
- Môn học trong hồ sơ người dùng có dùng để giới hạn quyền truy cập dữ liệu hay chỉ để mô tả chuyên môn.
