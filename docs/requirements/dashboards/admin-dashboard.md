# Tài liệu BA chi tiết: Admin Dashboard

Status: reviewed
Owner: BA/DEV
Last reviewed: 2026-09-16
Related:
  - docs/api/dashboards/dashboard.md
  - docs/api/dashboards/report.md
  - docs/security/roles/admin.md
  - docs/test-cases/overview.md
Business rule IDs:
  - ADB-BR-001: Dữ liệu dashboard được lọc theo tab, thời gian và bộ lọc nghiệp vụ tương ứng.
  - ADB-BR-002: Một số tab dùng mã gửi API khác tên hiển thị trên UI.
  - ADB-BR-003: Drill-down hoặc xem chi tiết phải dùng dữ liệu/API tương ứng với tab hiện tại.
  - ADB-BR-004: Export dashboard trả về job và lấy file theo cơ chế export chung.
  - ADB-BR-005: Dashboard có thể chứa dữ liệu nhạy cảm nên quyền xem cần theo role/permission.

Review note: Admin Dashboard hiển thị dữ liệu tổng quan toàn hệ thống cho admin. Trên giao diện có các bộ lọc để filter dữ liệu dashboard.

## 1. Khái niệm Admin Dashboard

Admin Dashboard là màn hình tổng hợp dữ liệu vận hành của hệ thống LMS dành cho admin.

Màn hình này giúp admin theo dõi nhanh:

- Quy mô người dùng, trường học, giáo viên và học sinh.
- Số người dùng đang hoạt động theo các khoảng thời gian.
- Tình hình khóa học và tỷ lệ hoàn thành.
- Chất lượng học tập của học sinh.
- Hành vi sử dụng hệ thống.
- Tình hình giao bài, nộp bài và chấm bài.
- Cấu trúc ngân hàng câu hỏi.
- Các cảnh báo vận hành và rủi ro.
- Báo cáo tổng quan hằng tuần.

Dashboard không phải là nơi nhập dữ liệu nghiệp vụ gốc. Đây là nơi tổng hợp, lọc, trình bày và xuất dữ liệu từ nhiều module khác nhau.

## 2. Phạm vi chức năng

Admin Dashboard nằm tại route:

```text
/{locale}/admin/dashboard
```

Khi người dùng vào route `/admin`, hệ thống điều hướng sang `/admin/dashboard`.

Menu admin hiển thị mục tổng quan với đường dẫn `/admin/dashboard`.

Các nhóm chức năng chính:

- Lọc dữ liệu dashboard theo trường, chương trình, khóa học, giáo viên, năm, tháng và vai trò.
- Xem dashboard theo từng tab nghiệp vụ.
- Xem danh sách người dùng đang online.
- Xem danh sách đăng nhập thất bại.
- Xem chi tiết các nhóm cảnh báo.
- Xuất dữ liệu dashboard.
- Xem và xuất báo cáo tổng quan hằng tuần.

## 3. Bộ lọc toàn cục

Dashboard có bộ lọc toàn cục nằm phía trên các tab.

Các bộ lọc gồm:

- Trường học.
- Chương trình học.
- Khóa học.
- Giáo viên.
- Năm.
- Tháng.
- Vai trò.

Bộ lọc vai trò chỉ hiển thị trong tab hành vi sử dụng.

Giá trị mặc định:

- Trường học: tất cả trường.
- Chương trình học: tất cả chương trình.
- Khóa học: tất cả khóa học.
- Giáo viên: tất cả giáo viên.
- Vai trò: tất cả vai trò.
- Năm và tháng: lấy theo thời gian hiện tại.

Khi chọn trường học:

- Khóa học được reset về tất cả khóa học.
- Giáo viên được reset về tất cả giáo viên.
- Chương trình học được reset về tất cả chương trình.

Khi chọn khóa học:

- Giáo viên được reset về tất cả giáo viên.

Danh sách khóa học phụ thuộc vào trường học và chương trình học đang chọn.

Danh sách giáo viên phụ thuộc vào trường học và khóa học đang chọn.

## 4. Các tab của Admin Dashboard

Admin Dashboard có các tab chính sau:

```text
Tổng quan
Chất lượng học tập
Hành vi sử dụng
Chấm bài
Ngân hàng câu hỏi
Cảnh báo
Báo cáo
```

Khi đổi tab, hệ thống gọi lại dữ liệu dashboard theo tab tương ứng. Riêng tab báo cáo sử dụng API báo cáo riêng.

Một số tab có mã gửi lên API khác tên hiển thị:

- Tab chất lượng học tập gửi `tab = quality`.
- Tab cảnh báo gửi `tab = warning`.
- Tab báo cáo không gửi tab dashboard chính.

Khi đổi tab, bộ lọc vai trò được reset về tất cả vai trò.

## 5. Tab Tổng quan

Tab Tổng quan hiển thị tình hình chung của hệ thống.

Các chỉ số chính:

- Tổng người dùng.
- Người dùng online trong 15 phút gần nhất.
- Người dùng hoạt động trong 24 giờ gần nhất.
- Người dùng hoạt động trong 7 ngày gần nhất.
- Người dùng hoạt động trong 30 ngày gần nhất.
- Tổng trường học.
- Tổng giáo viên.
- Tổng học sinh.
- Người dùng hoạt động trong ngày.

Một số chỉ số có thể điều hướng hoặc mở chi tiết:

- Tổng trường học điều hướng đến danh sách trường học.
- Tổng giáo viên điều hướng đến danh sách người dùng tab giáo viên.
- Tổng học sinh điều hướng đến danh sách người dùng tab học sinh.
- Người dùng online trong 15 phút mở dialog danh sách online.
- Người dùng hoạt động trong 24 giờ mở dialog danh sách hoạt động 24 giờ.

Tab Tổng quan cũng hiển thị:

- Biểu đồ tổng quan khóa học.
- Biểu đồ tỷ lệ hoàn thành theo loại dữ liệu khóa học.

## 6. Dialog người dùng online

Dashboard có dialog xem danh sách người dùng đang online.

Dialog online 15 phút sử dụng khoảng thời gian:

```text
minutes = 15
```

Dialog hoạt động 24 giờ sử dụng khoảng thời gian:

```text
minutes = 1440
```

Thông tin hiển thị trong danh sách online gồm:

- Tên hoặc username.
- Username.
- Thời lượng online.
- Thời điểm hoạt động gần nhất.

Danh sách có phân trang dạng tải thêm.

Người dùng có thể refresh danh sách trong dialog.

## 7. Tab Chất lượng học tập

Tab Chất lượng học tập cho admin theo dõi kết quả học tập và phân bố điểm.

Các chỉ số chính:

- Điểm trung bình.
- Tỷ lệ điểm cao.
- Tỷ lệ điểm thấp.
- Tỷ lệ trung bình.

Các biểu đồ và danh sách:

- Phân bố điểm theo khối hoặc nhóm dữ liệu.
- Tiến độ điểm trung bình theo tuần.
- Danh sách học sinh có điểm cao.
- Danh sách học sinh có điểm thấp nếu có dữ liệu.

Dữ liệu học sinh trong danh sách có thể gồm:

- Tên học sinh.
- Avatar nếu có.
- Trường học.
- Lớp học.
- Điểm.

## 8. Tab Hành vi sử dụng

Tab Hành vi sử dụng cho admin theo dõi mức độ tương tác với hệ thống.

Các chỉ số chính:

- Người dùng hoạt động hằng ngày.
- Thời lượng trung bình mỗi phiên.
- Tỷ lệ quay lại hằng tuần.
- Tỷ lệ tương tác.
- Số lượt hoàn thành.
- Tỷ lệ hoàn thành.

Các biểu đồ:

- Phân bố thiết bị sử dụng.
- Thời lượng sử dụng trung bình theo tuần.

Tab này có thêm bộ lọc vai trò:

- Tất cả vai trò.
- Giáo viên.
- Học sinh.

## 9. Tab Chấm bài

Tab Chấm bài theo dõi tình hình giao bài, nộp bài và chấm bài.

Các chỉ số chính:

- Tổng số bài.
- Tổng số bài đã giao.
- Tổng số bài đã nộp.
- Tổng số bài nộp.
- Tổng số bài đã chấm.
- Tổng số bài chưa chấm.

Các biểu đồ:

- Tình trạng giao bài theo tuần.
- Tổng bài đã nộp và tổng bài chưa chấm theo tuần.
- Tỷ lệ giao bài, nộp bài và chưa chấm theo tuần.

Tab này cũng hiển thị danh sách chưa chấm theo tuần nếu có dữ liệu:

- Bài kiểm tra chưa chấm.
- Bài tập về nhà chưa chấm.
- Bài luyện tập chưa chấm.

Thông tin trong danh sách chưa chấm gồm:

- Học sinh.
- Giáo viên.
- Tên bài.
- Thời điểm nộp.
- Số câu hỏi cần chấm.

## 10. Tab Ngân hàng câu hỏi

Tab Ngân hàng câu hỏi giúp admin theo dõi cấu trúc và mức độ sử dụng câu hỏi.

Các chỉ số liên quan media:

- Tổng số câu hỏi.
- Tỷ lệ câu hỏi có audio.
- Tỷ lệ câu hỏi có ảnh.
- Số câu hỏi có audio.
- Số câu hỏi có ảnh.

Các biểu đồ:

- Thống kê câu hỏi theo dạng câu hỏi.
- Thống kê câu hỏi theo thuộc tính.

Thuộc tính câu hỏi được hiển thị động theo dữ liệu API, ví dụ:

- Kỹ năng.
- Mức độ.
- Mức độ nhận thức.

Mỗi nhóm thuộc tính hiển thị số lượng và tỷ lệ câu hỏi theo từng giá trị thuộc tính.

## 11. Tab Cảnh báo

Tab Cảnh báo giúp admin phát hiện các rủi ro vận hành.

Các nhóm cảnh báo:

- Học sinh không hoạt động.
- Học sinh có dấu hiệu giảm sút.
- Giáo viên chấm bài chậm.
- Đăng nhập thất bại.

Các nhóm học sinh không hoạt động, học sinh giảm sút và giáo viên chấm chậm có thể mở chi tiết dạng bảng.

Thông tin chi tiết học sinh gồm:

- Mã.
- Tên.
- Lớp.
- Lần đăng nhập gần nhất.
- Số ngày vắng hoặc không hoạt động.

Thông tin chi tiết giáo viên chấm chậm gồm:

- Mã.
- Tên.
- Số bài đã chấm.
- Số bài đã nộp.
- Thời gian chờ trung bình.
- Tỷ lệ.

Cảnh báo đăng nhập thất bại lấy dữ liệu trong 1 giờ gần nhất và tự refresh số lượng theo chu kỳ 5 phút.

## 12. Dialog đăng nhập thất bại

Dialog đăng nhập thất bại hiển thị các lần đăng nhập lỗi trong 1 giờ gần nhất.

Danh sách có phân trang dạng tải thêm.

Thông tin hiển thị gồm:

- Username đã thử đăng nhập.
- Thời điểm đăng nhập thất bại.
- Thông tin đăng nhập đã thử.
- Mật khẩu được ẩn bằng `***`.
- Thông báo lỗi trả về.

Dialog này phục vụ theo dõi rủi ro bảo mật và hành vi đăng nhập bất thường.

## 13. Tab Báo cáo

Tab Báo cáo hiển thị báo cáo tổng quan hằng tuần.

Dữ liệu được lấy từ API:

```text
GET /dashboard/report
```

Các chỉ số hiển thị:

- Tổng trường và lớp.
- Tổng người dùng.
- Học sinh active từ mốc 15/09.
- Giáo viên active từ mốc 08/09.
- Học sinh active trong tuần gần nhất.
- Giáo viên active trong tuần gần nhất.
- Học sinh đăng nhập ít nhất 2 lần từ mốc 15/09.
- Học sinh đăng nhập ít nhất 2 lần trong tuần gần nhất.

Phần tóm tắt chỉ số quan trọng gồm:

- Tỷ lệ học sinh active tuần trên tổng học sinh active.
- Tỷ lệ giáo viên active tuần trên tổng giáo viên active.
- Tỷ lệ học sinh đăng nhập thường xuyên.

Người dùng có thể xuất báo cáo tổng quan hằng tuần ra PDF.

## 14. Xuất dữ liệu dashboard

Nút xuất báo cáo ở phần bộ lọc toàn cục dùng để xuất dữ liệu dashboard theo bộ lọc hiện tại.

API xuất dữ liệu:

```text
GET /transfer/dashboard/export
```

Params gửi theo bộ lọc:

- `course_id`.
- `school_id`.
- `teacher_id`.
- `program_id`.
- `role_id`.
- `year`.
- `month`.

API trả về `job_id`. Hệ thống dùng `job_id` để lấy file export theo cơ chế export chung.

Ngoài ra tab Báo cáo có chức năng xuất PDF trực tiếp từ dữ liệu báo cáo hằng tuần.

## 15. API liên quan

API chính của Admin Dashboard:

```text
GET /dashboard
```

Params:

- `course_id`.
- `school_id`.
- `teacher_id`.
- `program_id`.
- `role_id`.
- `year`.
- `month`.
- `tab`.

API lấy dữ liệu bộ lọc:

```text
GET /dashboard/school-list
GET /dashboard/course-list
GET /dashboard/teacher-list
GET /programs
```

API người dùng hoạt động:

```text
GET /dashboard/active-users
```

Params:

- `minutes`.
- `page`.
- `limit`.

API cảnh báo đăng nhập thất bại:

```text
GET /dashboard/failed-logins-count
GET /dashboard/failed-logins
```

API báo cáo:

```text
GET /dashboard/report
GET /transfer/dashboard/export
```

## 16. Cấu trúc dữ liệu tổng hợp

Dashboard tổng hợp dữ liệu theo các nhóm chính:

### 16.1. Tổng quan người dùng

- Người dùng.
- Trường học.
- Học sinh.
- Giáo viên.
- Hoạt động trong ngày.
- Người dùng online.

### 16.2. Tổng quan khóa học

- Số lượng theo từng nhóm khóa học.
- Tỷ lệ hoàn thành theo từng nhóm.
- Tổng số và số đã hoàn thành.

### 16.3. Chất lượng học tập

- Điểm trung bình theo tuần.
- Gem theo tuần nếu có.
- Học sinh điểm cao.
- Học sinh điểm thấp.
- Phân bố điểm.

### 16.4. Hành vi sử dụng

- Thời lượng phiên.
- Người dùng active.
- Tỷ lệ quay lại.
- Tỷ lệ tương tác.
- Thiết bị sử dụng.
- Thời lượng sử dụng theo tuần.

### 16.5. Hiệu suất chấm bài

- Tổng số bài.
- Bài đã giao.
- Bài đã nộp.
- Bài đã chấm.
- Bài chưa chấm.
- Tỷ lệ giao, nộp và chưa chấm theo tuần.

### 16.6. Ngân hàng câu hỏi

- Media usage.
- Dạng câu hỏi.
- Thuộc tính câu hỏi.

### 16.7. Rủi ro và cảnh báo

- Học sinh không hoạt động.
- Học sinh giảm sút.
- Giáo viên chấm chậm.
- Đăng nhập thất bại.

## 17. Trạng thái tải và lỗi

Khi dữ liệu dashboard đang tải, từng tab hiển thị trạng thái loading.

Khi API dashboard lỗi ở tab Tổng quan, hệ thống hiển thị thông báo lỗi.

Một số section có trạng thái riêng:

- Không có dữ liệu thì hiển thị trạng thái không có dữ liệu.
- Lỗi tải báo cáo hằng tuần thì hiển thị thông báo lỗi.
- Lỗi tải đăng nhập thất bại thì hiển thị thông báo lỗi trong dialog.

## 18. Quy tắc nghiệp vụ chính

### 18.1. Quy tắc lọc dữ liệu

- Dữ liệu dashboard phải phản ánh bộ lọc hiện tại.
- Bộ lọc trường học ảnh hưởng đến danh sách chương trình, khóa học và giáo viên.
- Bộ lọc khóa học ảnh hưởng đến danh sách giáo viên.
- Bộ lọc vai trò chỉ áp dụng cho tab hành vi sử dụng.
- Khi tab thay đổi, dữ liệu được tải lại theo tab mới.

### 18.2. Quy tắc xem chi tiết

- Chỉ số online 15 phút có thể mở danh sách người dùng online.
- Chỉ số hoạt động 24 giờ có thể mở danh sách người dùng hoạt động 24 giờ.
- Cảnh báo có dữ liệu có thể mở bảng chi tiết.
- Danh sách chi tiết có phân trang hoặc cuộn nếu dữ liệu nhiều.

### 18.3. Quy tắc xuất dữ liệu

- Xuất dữ liệu dashboard phải dùng đúng bộ lọc hiện tại.
- Kết quả export theo API `/transfer/dashboard/export` trả về dạng job.
- Báo cáo hằng tuần có thể xuất PDF từ dữ liệu đang hiển thị.

### 18.4. Quy tắc bảo mật thông tin

- Mật khẩu trong danh sách đăng nhập thất bại không được hiển thị thật.
- Dialog đăng nhập thất bại chỉ hiển thị username, thời điểm và thông báo lỗi cần thiết cho theo dõi vận hành.

## 19. Ghi chú kiểm thử

Các điểm dưới đây cần kiểm tra với API/backend khi viết test chi tiết:

- Quyền truy cập riêng cho Admin Dashboard có cần tách khỏi quyền admin chung hay không.
- Công thức tính từng chỉ số phần trăm trong dashboard.
- Mốc ngày 08/09 và 15/09 trong báo cáo hằng tuần có cố định theo năm học hay chỉ là cấu hình tạm thời.
- Dashboard là tổng quan toàn hệ thống cho admin; dữ liệu có thể được filter bằng các bộ lọc trên giao diện.
- Các cảnh báo học sinh giảm sút, không hoạt động và giáo viên chấm chậm dùng ngưỡng nào.
- Người dùng hoạt động trong 7 ngày và 30 ngày có cần mở danh sách chi tiết như 15 phút và 24 giờ hay không.
- Dữ liệu export dashboard có bao gồm tab đang chọn hay chỉ gồm toàn bộ dashboard theo bộ lọc.

## 20. Luồng sử dụng tổng quát

1. Admin mở màn Admin Dashboard.
2. Hệ thống tải dữ liệu dashboard theo tab mặc định và bộ lọc hiện tại.
3. Admin thay đổi tab, thời gian hoặc bộ lọc nghiệp vụ.
4. Hệ thống gọi lại API tương ứng và cập nhật chỉ số, biểu đồ, bảng hoặc cảnh báo.
5. Admin xem chi tiết các chỉ số có hỗ trợ drill-down nếu có dữ liệu.
6. Admin xuất dữ liệu dashboard hoặc báo cáo theo bộ lọc hiện tại nếu cần.
