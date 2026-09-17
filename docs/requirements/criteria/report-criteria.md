# Tài liệu BA chi tiết: Quản lý tiêu chí báo cáo

Status: reviewed
Owner: BA/DEV
Last reviewed: 2026-09-16
Related:
  - docs/api/dashboards/study-report-criteria.md
  - docs/security/resources/study-report-criterias.md
  - docs/security/resources/study-reports.md
  - docs/test-cases/overview.md
Business rule IDs:
  - RCR-BR-001: Tiêu chí báo cáo thuộc môn học và dùng cho đánh giá báo cáo học tập.
  - RCR-BR-002: Tiêu chí báo cáo hỗ trợ ghi chú mức sao, kỹ năng đánh giá bằng sao và tích chọn.
  - RCR-BR-003: Tạo, cập nhật, sao chép, xóa tiêu chí báo cáo phải đi qua API tiêu chí báo cáo.
  - RCR-BR-004: Điều kiện chặn xóa hoặc validate trùng tên phụ thuộc backend/API và cần review khi đặc tả chi tiết.

Review note: Tiêu chí đánh giá điểm và tiêu chí đánh giá báo cáo là hai loại khác nhau. Tiêu chí báo cáo hiện giới hạn tối đa 4 cấp.

## 1. Khái niệm tiêu chí báo cáo

Tiêu chí báo cáo là cấu hình dùng để tạo form báo cáo đánh giá học tập theo môn học.

Khác với tiêu chí điểm, tiêu chí báo cáo không chỉ phục vụ chấm điểm số. Module này cho phép cấu hình:

- Môn học áp dụng.
- Tên form tiêu chí báo cáo.
- Mô tả.
- Số sao tối đa.
- Ghi chú theo từng mức sao.
- Nhóm kỹ năng đánh giá bằng sao.
- Nhóm kỹ năng đánh giá bằng tích chọn.
- Cây tiêu chí nhiều cấp cho từng nhóm kỹ năng.

Tiêu chí báo cáo là nền tảng để giáo viên hoặc hệ thống tạo báo cáo đánh giá học tập có cấu trúc.

## 2. Phạm vi chức năng

Chức năng quản lý tiêu chí báo cáo nằm tại các route:

```text
/{locale}/admin/criteria-report
/{locale}/admin/criteria-report/create
/{locale}/admin/criteria-report/{id}
/{locale}/admin/criteria-report/{id}/edit
```

Menu admin hiển thị mục **Quản lý tiêu chí báo cáo** với đường dẫn `/admin/criteria-report`.

Các thao tác chính:

- Xem danh sách tiêu chí báo cáo.
- Lọc tiêu chí báo cáo theo môn học.
- Xem chi tiết tiêu chí báo cáo.
- Tạo tiêu chí báo cáo mới.
- Cập nhật tiêu chí báo cáo.
- Sao chép tiêu chí báo cáo.
- Xóa tiêu chí báo cáo.

## 3. Quan hệ với các đối tượng khác

### 3.1. Quan hệ với môn học

Mỗi tiêu chí báo cáo gắn với một môn học.

Môn học giúp phân loại form báo cáo và giúp các màn tạo báo cáo chỉ hiển thị form phù hợp với môn học.

### 3.2. Quan hệ với đánh giá báo cáo

Tiêu chí báo cáo dùng cho đánh giá báo cáo học tập, khác với tiêu chí đánh giá điểm.

Khi tạo hoặc sửa báo cáo đánh giá, người dùng chọn môn học trước. Sau đó hệ thống hiển thị danh sách tiêu chí báo cáo phù hợp để gắn vào báo cáo.

### 3.3. Quan hệ với báo cáo học tập

Tiêu chí báo cáo quy định cấu trúc nội dung được sử dụng khi tạo báo cáo học tập.

Cấu trúc này gồm các nhóm kỹ năng, tiêu chí con, mức sao và lựa chọn tích chọn để ghi nhận kết quả đánh giá.

## 4. Thông tin của tiêu chí báo cáo

Một tiêu chí báo cáo gồm các nhóm thông tin sau:

### 4.1. Thông tin cơ bản

- `id`: mã tiêu chí báo cáo.
- `subject_id`: mã môn học.
- `name`: tên tiêu chí báo cáo.
- `description`: mô tả.
- `max_star`: số sao tối đa.
- `created_at`: thời điểm tạo.
- `updated_at`: thời điểm cập nhật.

### 4.2. Ghi chú mức sao

Mỗi ghi chú gồm:

- `value`: giá trị sao.
- `text`: nhãn hoặc nội dung ngắn.
- `description`: mô tả chi tiết.

Ghi chú giúp diễn giải ý nghĩa từng mức sao trong báo cáo.

### 4.3. Kỹ năng đánh giá bằng sao

Mỗi nhóm kỹ năng sao gồm:

- `id`: mã kỹ năng nếu đã tồn tại.
- `name_vn`: tên tiếng Việt.
- `name_en`: tên tiếng Anh.
- `description`: mô tả.
- `types`: danh sách tiêu chí con nhiều cấp.

Kỹ năng sao được dùng cho các tiêu chí có thang đánh giá theo số sao.

### 4.4. Kỹ năng đánh giá bằng tích chọn

Mỗi nhóm kỹ năng tích chọn gồm:

- `id`: mã kỹ năng nếu đã tồn tại.
- `name_vn`: tên tiếng Việt.
- `name_en`: tên tiếng Anh.
- `description`: mô tả.
- `types`: danh sách tiêu chí con nhiều cấp.

Kỹ năng tích chọn được dùng cho các tiêu chí dạng có hoặc không, đạt hoặc chưa đạt, hoặc các lựa chọn kiểm tra.

### 4.5. Cây tiêu chí nhiều cấp

Mỗi nhóm kỹ năng có thể có tối đa 4 cấp:

```text
Kỹ năng
└─ Type cấp 2
   └─ Node cấp 3
      └─ Node cấp 4
```

Mỗi node có thể có:

- `id`: mã node nếu đã tồn tại.
- `name_vn`: tên tiếng Việt.
- `name_en`: tên tiếng Anh.
- `sort_order`: thứ tự sắp xếp.
- `node_types`: danh sách node con.

## 5. Danh sách tiêu chí báo cáo

Màn danh sách cho phép admin xem các tiêu chí báo cáo trong hệ thống.

Dữ liệu được lấy từ API:

```text
GET /study-report-criterias
```

Params:

- `subject_id`: lọc theo môn học nếu người dùng chọn một môn cụ thể.
- `keyword`: hỗ trợ tìm kiếm nếu được truyền từ màn sử dụng.

Response gồm:

- `study_report_criterias`: danh sách tiêu chí báo cáo.
- `total_count`: tổng số tiêu chí báo cáo.

Bảng danh sách hiển thị:

- Tên tiêu chí.
- Môn học.
- Ngày tạo.
- Thao tác.

Các thao tác trên từng dòng:

- Xem chi tiết.
- Chỉnh sửa.
- Sao chép.
- Xóa.

## 6. Tạo tiêu chí báo cáo

Màn tạo cho phép admin khai báo một cấu hình tiêu chí báo cáo mới.

Dữ liệu được gửi đến API:

```text
POST /study-report-criterias
```

Thông tin cần nhập:

- Môn học.
- Tên tiêu chí báo cáo.
- Mô tả.
- Số sao tối đa.
- Ghi chú theo mức sao.
- Danh sách kỹ năng đánh giá bằng sao.
- Danh sách kỹ năng đánh giá bằng tích chọn.
- Cây tiêu chí nhiều cấp cho từng kỹ năng.

Quy tắc nhập liệu:

- Tên tiêu chí báo cáo bắt buộc.
- Môn học bắt buộc.
- Số sao tối đa mặc định là `5`.
- Số lượng ghi chú không được vượt quá số sao tối đa.
- Ghi chú không có nội dung `text` sẽ không được gửi.
- Kỹ năng không có `name_vn` sẽ không được gửi.
- Node cấp con không có giá trị sẽ không được gửi.

Khi submit, hệ thống chuẩn hóa dữ liệu:

- Chuyển `subject_id` thành số.
- Cắt khoảng trắng ở tên và mô tả.
- Lọc bỏ ghi chú rỗng.
- Lọc bỏ kỹ năng rỗng.
- Lọc bỏ node rỗng ở từng cấp.
- Giữ `id` của kỹ năng hoặc node đã tồn tại.
- Không gửi `id` tạm có tiền tố `temp-`.
- Gán `sort_order` theo thứ tự nếu chưa có.

Payload tạo gồm:

```text
subject_id
name
description
max_star
notes[]
star_skills[]
check_skills[]
```

Nếu tạo thành công, hệ thống thông báo thành công và điều hướng về danh sách tiêu chí báo cáo.

## 7. Cập nhật tiêu chí báo cáo

Màn cập nhật cho phép admin sửa tiêu chí báo cáo đã tồn tại.

Dữ liệu chi tiết được lấy từ API:

```text
GET /study-report-criterias/{id}
```

Dữ liệu cập nhật được gửi đến API:

```text
PUT /study-report-criterias/{id}
```

Khi mở màn sửa, hệ thống nạp:

- Thông tin cơ bản.
- Ghi chú sao.
- Danh sách kỹ năng sao.
- Danh sách kỹ năng tích chọn.
- Cây tiêu chí nhiều cấp.

Quy tắc validate khi cập nhật giống tạo mới:

- Tên tiêu chí báo cáo bắt buộc.
- Môn học bắt buộc.

Nếu cập nhật thành công, hệ thống thông báo thành công và điều hướng về danh sách.

Nếu tải chi tiết hoặc cập nhật lỗi, hệ thống hiển thị thông báo lỗi.

## 8. Xem chi tiết tiêu chí báo cáo

Màn chi tiết sử dụng form ở chế độ chỉ đọc.

Người dùng có thể xem:

- Môn học.
- Tên tiêu chí báo cáo.
- Mô tả.
- Số sao tối đa.
- Ghi chú mức sao.
- Kỹ năng đánh giá bằng sao.
- Kỹ năng đánh giá bằng tích chọn.
- Cấu trúc tiêu chí nhiều cấp.

Ở chế độ chỉ đọc:

- Không hiển thị thao tác lưu.
- Không cho thêm, sửa hoặc xóa ghi chú, kỹ năng và node.

## 9. Sao chép tiêu chí báo cáo

Màn danh sách cho phép sao chép một tiêu chí báo cáo.

Khi người dùng chọn sao chép:

1. Hệ thống mở hộp xác nhận.
2. Người dùng xác nhận sao chép.
3. Hệ thống gọi API tạo mới với tham chiếu tiêu chí nguồn.

Payload sao chép:

```text
copy_from_study_report_criteria_id
```

Nếu sao chép thành công, hệ thống làm mới danh sách tiêu chí báo cáo.

## 10. Xóa tiêu chí báo cáo

Màn danh sách cho phép xóa tiêu chí báo cáo.

Dữ liệu được gửi đến API:

```text
DELETE /study-report-criterias/{id}
```

Trước khi xóa, hệ thống hỏi xác nhận với tên tiêu chí.

Nếu xóa thành công:

- Hệ thống thông báo thành công.
- Hệ thống làm mới danh sách.

Nếu xóa thất bại:

- Hệ thống hiển thị thông báo không thể xóa tiêu chí.

Điều kiện chặn xóa khi tiêu chí báo cáo đã được dùng trong assessment hoặc báo cáo học tập nếu có sẽ do API xử lý.

## 11. API liên quan

Các API chính:

```text
GET /study-report-criterias
POST /study-report-criterias
GET /study-report-criterias/{id}
PUT /study-report-criterias/{id}
DELETE /study-report-criterias/{id}
```

API môn học liên quan:

```text
GET /subjects
```

## 12. Luồng màn hình chính

### 12.1. Luồng xem danh sách

1. Admin mở màn quản lý tiêu chí báo cáo.
2. Hệ thống tải danh sách môn học.
3. Hệ thống tải danh sách tiêu chí báo cáo.
4. Admin có thể lọc theo môn học.
5. Admin có thể xem, sửa, sao chép hoặc xóa một tiêu chí báo cáo.

### 12.2. Luồng tạo mới

1. Admin chọn tạo mới.
2. Hệ thống mở form tạo tiêu chí báo cáo.
3. Admin chọn môn học và nhập tên tiêu chí.
4. Admin khai báo số sao tối đa.
5. Admin thêm ghi chú mức sao nếu cần.
6. Admin thêm kỹ năng sao hoặc kỹ năng tích chọn.
7. Admin thêm các cấp tiêu chí con nếu cần.
8. Admin submit form.
9. Hệ thống validate dữ liệu.
10. Hệ thống gửi dữ liệu tạo tiêu chí báo cáo.
11. Thành công thì quay về danh sách.

### 12.3. Luồng cập nhật

1. Admin chọn chỉnh sửa.
2. Hệ thống tải chi tiết tiêu chí báo cáo.
3. Hệ thống nạp dữ liệu vào form.
4. Admin chỉnh sửa thông tin.
5. Admin submit form.
6. Hệ thống gửi dữ liệu cập nhật.
7. Thành công thì quay về danh sách.

### 12.4. Luồng sao chép

1. Admin chọn sao chép một tiêu chí báo cáo.
2. Hệ thống hỏi xác nhận.
3. Admin xác nhận.
4. Hệ thống tạo tiêu chí báo cáo mới từ tiêu chí nguồn.
5. Hệ thống làm mới danh sách.

## 13. Ghi chú kiểm thử

Các điểm dưới đây cần kiểm tra với API/backend khi viết test chi tiết:

- API có kiểm tra tên tiêu chí báo cáo trùng trong cùng môn học hay không.
- Số sao tối đa có giới hạn trên hay không.
- Có bắt buộc phải khai báo đủ ghi chú cho tất cả mức sao hay không.
- Có bắt buộc phải có ít nhất một kỹ năng sao hoặc kỹ năng tích chọn hay không.
- Cây tiêu chí báo cáo được hỗ trợ tối đa 4 cấp.
- Một tiêu chí báo cáo đã được gắn vào assessment hoặc báo cáo học tập có được sửa hoặc xóa hay không.
- Khi sao chép tiêu chí báo cáo, tên bản sao được sinh như thế nào.
- Có cần phân quyền riêng cho tạo, sửa, xóa tiêu chí báo cáo hay dùng quyền admin chung.
