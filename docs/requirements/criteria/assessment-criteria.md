# Tài liệu BA chi tiết: Quản lý tiêu chí điểm

Status: reviewed
Owner: BA/DEV
Last reviewed: 2026-09-16
Related:
  - docs/api/criteria/assessment-criteria.md
  - docs/api/criteria/assessment-criteria-group.md
  - docs/api/criteria/assessment-subcriteria.md
  - docs/security/resources/assessment-criteria.md
  - docs/security/resources/assessment-criteria-groups.md
  - docs/security/resources/assessment-subcriteria.md
  - docs/test-cases/overview.md
Business rule IDs:
  - ACR-BR-001: Bảng tiêu chí điểm thuộc môn học và dùng cho assessment.
  - ACR-BR-002: Tiêu chí và tiêu chí con xác định điểm tối đa, mô tả và cấu trúc chấm.
  - ACR-BR-003: Tạo, cập nhật, sao chép, xóa bảng tiêu chí phải đi qua API tiêu chí liên quan.
  - ACR-BR-004: Điều kiện chặn xóa hoặc validate điểm phụ thuộc backend/API và cần review khi đặc tả chi tiết.

Review note: Tiêu chí đánh giá được sử dụng cho loại bài tập Assessment. Tài liệu này đã được xác nhận đúng theo nghiệp vụ hiện tại.

## 1. Khái niệm tiêu chí điểm

Tiêu chí điểm là bảng tiêu chí dùng để chấm điểm bài assessment theo từng tiêu chí cụ thể.

Một bảng tiêu chí điểm gồm:

- Thông tin bảng tiêu chí.
- Môn học áp dụng.
- Cờ yêu cầu upload bài làm.
- Danh sách tiêu chí.
- Danh sách tiêu chí con nếu cần.
- Điểm tối đa của từng tiêu chí hoặc tiêu chí con.

Tiêu chí điểm giúp chuẩn hóa cách chấm bài, giúp giáo viên hoặc người chấm có cùng một khung đánh giá khi xử lý assessment.

## 2. Phạm vi chức năng

Chức năng quản lý tiêu chí điểm nằm tại các route:

```text
/{locale}/admin/criteria-assessment
/{locale}/admin/criteria-assessment/create
/{locale}/admin/criteria-assessment/{id}
/{locale}/admin/criteria-assessment/{id}/edit
```

Menu admin hiển thị mục **Quản lý tiêu chí điểm** với đường dẫn `/admin/criteria-assessment`.

Các thao tác chính:

- Xem danh sách bảng tiêu chí điểm.
- Lọc bảng tiêu chí điểm theo môn học.
- Xem chi tiết bảng tiêu chí điểm.
- Tạo bảng tiêu chí điểm mới.
- Cập nhật bảng tiêu chí điểm.
- Sao chép bảng tiêu chí điểm.
- Xóa bảng tiêu chí điểm.

## 3. Quan hệ với các đối tượng khác

### 3.1. Quan hệ với môn học

Mỗi bảng tiêu chí điểm gắn với một môn học.

Môn học dùng để phân loại bảng tiêu chí và giúp các màn assessment chỉ hiển thị bảng tiêu chí phù hợp với môn học đang chọn.

Danh sách bảng tiêu chí điểm có thể lọc theo môn học.

### 3.2. Quan hệ với assessment

Assessment có thể chọn một bảng tiêu chí điểm.

Khi tạo hoặc sửa assessment, người dùng chọn môn học trước, sau đó hệ thống tải danh sách bảng tiêu chí điểm phù hợp với môn học đó.

Nếu không có môn học được chọn, người dùng chưa thể chọn bảng tiêu chí điểm.

Nếu không có bảng tiêu chí phù hợp, hệ thống hiển thị trạng thái không có bảng tiêu chí phù hợp.

### 3.3. Quan hệ với file bài làm

Bảng tiêu chí điểm có cờ `has_file`.

Nếu bật cờ này, assessment sử dụng bảng tiêu chí đó có thể yêu cầu hoặc hỗ trợ upload bài làm để phục vụ chấm điểm.

## 4. Thông tin của bảng tiêu chí điểm

Một bảng tiêu chí điểm gồm các nhóm thông tin sau:

### 4.1. Thông tin bảng

- `id`: mã bảng tiêu chí.
- `name`: tên bảng tiêu chí.
- `subject_id`: mã môn học.
- `subject_name`: tên môn học nếu API trả về.
- `has_file`: có yêu cầu upload bài làm hay không.
- `created_at`: thời điểm tạo.
- `created_by`: người tạo.
- `updated_at`: thời điểm cập nhật.
- `updated_by`: người cập nhật.

### 4.2. Thông tin tiêu chí

Mỗi tiêu chí gồm:

- `id`: mã tiêu chí nếu đã tồn tại.
- `name`: tên tiêu chí.
- `description`: mô tả tiêu chí.
- `max_score`: điểm tối đa.
- `subcriteria`: danh sách tiêu chí con nếu có.

### 4.3. Thông tin tiêu chí con

Mỗi tiêu chí con gồm:

- `id`: mã tiêu chí con nếu đã tồn tại.
- `name`: tên tiêu chí con.
- `description`: mô tả tiêu chí con.
- `max_score`: điểm tối đa.

## 5. Danh sách bảng tiêu chí điểm

Màn danh sách cho phép admin xem các bảng tiêu chí điểm trong hệ thống.

Dữ liệu được lấy từ API:

```text
GET /assessment-criteria-groups
```

Params:

- `subject_id`: lọc theo môn học nếu người dùng chọn một môn cụ thể.

Response gồm:

- `groups`: danh sách bảng tiêu chí điểm.
- `total_count`: tổng số bảng tiêu chí.

Bảng danh sách hiển thị:

- Tên bảng.
- Có tải bài làm hay không.
- Ngày tạo.
- Thao tác.

Các thao tác trên từng dòng:

- Xem chi tiết.
- Chỉnh sửa.
- Sao chép.
- Xóa.

Ngày tạo được chuyển từ timestamp giây sang định dạng ngày giờ Việt Nam.

## 6. Tạo bảng tiêu chí điểm

Màn tạo cho phép admin khai báo một bảng tiêu chí điểm mới.

Dữ liệu được gửi đến API:

```text
POST /assessment-criteria-group/with-criteria
```

Thông tin cần nhập:

- Môn học.
- Tên bảng tiêu chí.
- Có upload bài làm hay không.
- Danh sách tiêu chí.
- Tiêu chí con nếu có.

Quy tắc nhập liệu:

- Tên bảng bắt buộc.
- Môn học bắt buộc.
- Phải có ít nhất một tiêu chí.
- Tên tiêu chí bắt buộc để tiêu chí được gửi.
- Tên tiêu chí con bắt buộc để tiêu chí con được gửi.
- Điểm tối đa được chuyển thành số, nếu không hợp lệ thì dùng `0`.

Khi submit, hệ thống chuẩn hóa dữ liệu:

- Cắt khoảng trắng ở tên bảng.
- Cắt khoảng trắng ở tên và mô tả tiêu chí.
- Bỏ các tiêu chí không có tên.
- Bỏ các tiêu chí con không có tên.
- Giữ `id` của tiêu chí và tiêu chí con đã tồn tại.
- Gửi `id = 0` với tiêu chí hoặc tiêu chí con mới.

Payload tạo gồm:

```text
group.name
group.subject_id
group.has_file
criteria[].name
criteria[].description
criteria[].max_score
criteria[].subcriteria[]
```

Nếu tạo thành công, hệ thống thông báo thành công và điều hướng về danh sách bảng tiêu chí điểm.

## 7. Cập nhật bảng tiêu chí điểm

Màn cập nhật cho phép admin sửa bảng tiêu chí điểm đã tồn tại.

Dữ liệu chi tiết được lấy từ API:

```text
GET /assessment-criteria-groups/{id}
```

Dữ liệu cập nhật được gửi đến API:

```text
PUT /assessment-criteria-group/with-criteria/{id}
```

Khi mở màn sửa, hệ thống nạp:

- Tên bảng.
- Môn học.
- Trạng thái upload bài làm.
- Danh sách tiêu chí.
- Danh sách tiêu chí con.

Quy tắc validate khi cập nhật giống tạo mới:

- Tên bảng bắt buộc.
- Môn học bắt buộc.
- Phải có ít nhất một tiêu chí.

Nếu cập nhật thành công, hệ thống thông báo thành công và điều hướng về danh sách.

Nếu tải chi tiết hoặc cập nhật lỗi, hệ thống hiển thị thông báo lỗi.

## 8. Xem chi tiết bảng tiêu chí điểm

Màn chi tiết hiển thị thông tin đọc của bảng tiêu chí điểm.

Thông tin hiển thị:

- Môn học.
- Tên bảng.
- Ngày tạo.
- Danh sách tiêu chí.
- Điểm tối đa của từng tiêu chí.
- Mô tả tiêu chí nếu có.
- Danh sách tiêu chí con nếu có.
- Điểm tối đa của từng tiêu chí con.

Từ màn chi tiết, người dùng có thể chuyển sang màn chỉnh sửa.

## 9. Sao chép bảng tiêu chí điểm

Màn danh sách cho phép sao chép một bảng tiêu chí điểm.

Khi người dùng chọn sao chép:

1. Hệ thống mở hộp xác nhận.
2. Người dùng xác nhận sao chép.
3. Hệ thống gọi API tạo bảng mới với tham chiếu bảng nguồn.

Payload sao chép:

```text
group.copy_from_assessment_criteria_group_id
criteria = []
```

Nếu sao chép thành công, hệ thống làm mới danh sách bảng tiêu chí.

## 10. Xóa bảng tiêu chí điểm

Màn danh sách cho phép xóa bảng tiêu chí điểm.

Dữ liệu được gửi đến API:

```text
DELETE /assessment-criteria-groups/{id}
```

Trước khi xóa, hệ thống hỏi xác nhận với tên bảng tiêu chí.

Nếu xóa thành công:

- Hệ thống thông báo thành công.
- Hệ thống làm mới danh sách.

Nếu xóa thất bại:

- Hệ thống hiển thị thông báo không thể xóa nhóm.

Điều kiện chặn xóa khi bảng tiêu chí đã được dùng trong assessment nếu có sẽ do API xử lý.

## 11. API liên quan

Các API chính:

```text
GET /assessment-criteria-groups
POST /assessment-criteria-group/with-criteria
GET /assessment-criteria-groups/{id}
PUT /assessment-criteria-group/with-criteria/{id}
DELETE /assessment-criteria-groups/{id}
```

API môn học liên quan:

```text
GET /subjects
```

## 12. Luồng màn hình chính

### 12.1. Luồng xem danh sách

1. Admin mở màn quản lý tiêu chí điểm.
2. Hệ thống tải danh sách môn học.
3. Hệ thống tải danh sách bảng tiêu chí điểm.
4. Admin có thể lọc theo môn học.
5. Admin có thể xem, sửa, sao chép hoặc xóa một bảng tiêu chí.

### 12.2. Luồng tạo mới

1. Admin chọn tạo mới.
2. Hệ thống mở form tạo bảng tiêu chí điểm.
3. Admin chọn môn học và nhập tên bảng.
4. Admin thêm ít nhất một tiêu chí.
5. Admin thêm tiêu chí con nếu cần.
6. Admin submit form.
7. Hệ thống validate dữ liệu.
8. Hệ thống gửi dữ liệu tạo bảng tiêu chí.
9. Thành công thì quay về danh sách.

### 12.3. Luồng cập nhật

1. Admin chọn chỉnh sửa.
2. Hệ thống tải chi tiết bảng tiêu chí.
3. Hệ thống nạp dữ liệu vào form.
4. Admin chỉnh sửa thông tin.
5. Admin submit form.
6. Hệ thống gửi dữ liệu cập nhật.
7. Thành công thì quay về danh sách.

### 12.4. Luồng sao chép

1. Admin chọn sao chép một bảng tiêu chí.
2. Hệ thống hỏi xác nhận.
3. Admin xác nhận.
4. Hệ thống tạo bảng tiêu chí mới từ bảng nguồn.
5. Hệ thống làm mới danh sách.

## 13. Ghi chú và điểm cần xác nhận

Các điểm dưới đây cần xác nhận với API hoặc nghiệp vụ nếu viết đặc tả chi tiết hơn:

- API có kiểm tra tổng điểm tiêu chí con so với điểm tối đa của tiêu chí cha hay không.
- API có kiểm tra điểm tối đa phải lớn hơn `0` hay không.
- Một bảng tiêu chí điểm đã được gắn vào assessment có được sửa hoặc xóa hay không.
- Cờ upload bài làm ảnh hưởng chính xác thế nào đến luồng nộp bài của học sinh.
- Khi sao chép bảng tiêu chí, tên bảng mới được sinh như thế nào.
- Có cần phân quyền riêng cho tạo, sửa, xóa bảng tiêu chí điểm hay dùng quyền admin chung.
