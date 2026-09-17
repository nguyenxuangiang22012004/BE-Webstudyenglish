# Tài Liệu BA Chi Tiết: Notice

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-06-04
Related:
  - docs/api/notices/notice.md
  - docs/api/notices/message.md
  - docs/api/notices/push-notification.md
  - docs/api/notices/web-socket.md
  - docs/security/resources/notices.md
  - docs/test-cases/overview.md
Business rule IDs:
  - NOT-BR-001: Notice là thông báo gửi tới người dùng hoặc nhóm người dùng.
  - NOT-BR-002: Phạm vi gửi notice phụ thuộc role, school, class hoặc đối tượng nhận.
  - NOT-BR-003: Notice có trạng thái và dữ liệu gửi/nhận phục vụ hiển thị thông báo.
  - NOT-BR-004: Push notification/message/websocket là các kênh liên quan nếu backend hỗ trợ.

## 1. Khái niệm notice

Notice là thông báo được tạo và gửi trong hệ thống LMS để truyền đạt thông tin tới người dùng.

Notice có thể phục vụ nhiều mục đích:
- Thông báo vận hành hệ thống
- Thông báo học tập
- Thông báo từ nhà trường
- Thông báo từ giáo viên
- Thông báo lịch học, bài tập, kiểm tra hoặc kết quả
- Thông báo yêu cầu người dùng thực hiện hành động

Notice giúp đảm bảo thông tin quan trọng được gửi đúng người, đúng phạm vi và đúng thời điểm.

## 2. Quan hệ của notice với các đối tượng khác

### 2.1. Quan hệ với người gửi

Notice có thể được tạo bởi admin, nhà trường hoặc giáo viên tùy theo quyền.

Người gửi là căn cứ để xác định:
- Phạm vi gửi
- Quyền chỉnh sửa
- Quyền thu hồi
- Người chịu trách nhiệm nội dung

### 2.2. Quan hệ với người nhận

Notice được gửi tới một hoặc nhiều nhóm người nhận.

Người nhận có thể là:
- Toàn hệ thống
- Một trường học
- Một lớp học
- Một khóa học
- Một nhóm giáo viên
- Một nhóm học sinh
- Một người dùng cụ thể

### 2.3. Quan hệ với trường học

Notice có thể thuộc phạm vi một trường học.

Tài khoản nhà trường có thể tạo notice cho giáo viên, học sinh, lớp học hoặc khóa học thuộc trường của mình.

### 2.4. Quan hệ với lớp học

Notice có thể gửi tới một lớp học cụ thể.

Thông báo theo lớp thường dùng cho:
- Lịch học
- Hoạt động lớp
- Nhắc nhở học sinh
- Thông báo từ giáo viên hoặc nhà trường

### 2.5. Quan hệ với khóa học

Notice có thể gắn với khóa học để thông báo các nội dung liên quan tới quá trình học.

Ví dụ:
- Có bài học mới
- Có homework mới
- Sắp tới hạn nộp bài
- Có exam hoặc assessment
- Có kết quả được công bố

### 2.6. Quan hệ với trạng thái đọc

Notice có thể phát sinh trạng thái đọc theo từng người nhận.

Trạng thái đọc giúp xác định:
- Ai đã nhận thông báo
- Ai đã đọc thông báo
- Thời điểm đọc
- Người dùng nào chưa đọc thông báo quan trọng

## 3. Notice gồm những thông tin gì

Một notice có thể bao gồm các nhóm thông tin sau:

### 3.1. Thông tin định danh

- Mã notice
- Tiêu đề notice
- Nội dung notice

### 3.2. Thông tin người gửi

- Người tạo
- Vai trò người tạo
- Đơn vị hoặc trường học của người tạo nếu có

### 3.3. Thông tin người nhận

- Nhóm người nhận
- Danh sách người nhận cụ thể nếu có
- Trường học nhận
- Lớp học nhận
- Khóa học nhận
- Vai trò nhận

### 3.4. Thông tin phân loại

- Loại notice
- Mức độ ưu tiên
- Chủ đề thông báo
- Phạm vi gửi

### 3.5. Thông tin thời gian

- Thời điểm tạo
- Thời điểm gửi
- Lịch gửi nếu có
- Thời điểm hết hiệu lực nếu có

### 3.6. Thông tin trạng thái

- Trạng thái nháp
- Trạng thái đã gửi
- Trạng thái đã thu hồi
- Trạng thái hết hiệu lực
- Trạng thái đọc theo từng người nhận

### 3.7. Thông tin tài nguyên

- File đính kèm
- Link liên quan
- Ảnh minh họa nếu có

## 4. Loại notice

Notice có thể được phân loại theo nội dung và mục đích gửi.

Các loại notice phổ biến gồm:
- Thông báo hệ thống
- Thông báo nhà trường
- Thông báo lớp học
- Thông báo khóa học
- Thông báo bài học
- Thông báo bài tập
- Thông báo kiểm tra
- Thông báo kết quả học tập
- Thông báo khẩn
- Thông báo nhắc nhở

Việc phân loại giúp người dùng nhận biết mức độ quan trọng và ngữ cảnh của thông báo.

## 5. Vai trò của notice trong vận hành LMS

Notice là kênh truyền thông chính thức trong hệ thống LMS.

Notice giúp:
- Truyền đạt thông tin nhanh tới người dùng
- Giảm phụ thuộc vào kênh liên lạc ngoài hệ thống
- Nhắc nhở học sinh về hoạt động học tập
- Hỗ trợ giáo viên và nhà trường điều phối lớp học
- Ghi nhận lịch sử gửi thông báo
- Theo dõi mức độ tiếp nhận thông tin qua trạng thái đọc

## 6. CRUD notice

### 6.1. Tạo notice

Cho phép tạo thông báo mới.

Thông tin thường cần khai báo:
- Tiêu đề
- Nội dung
- Loại notice
- Đối tượng nhận
- Mức độ ưu tiên
- Thời điểm gửi
- File hoặc link đính kèm nếu có

### 6.2. Xem danh sách notice

Cho phép xem danh sách notice theo:
- Từ khóa
- Loại notice
- Người gửi
- Đối tượng nhận
- Trạng thái
- Thời gian gửi
- Mức độ ưu tiên
- Phân trang

### 6.3. Xem chi tiết notice

Cho phép xem chi tiết notice, bao gồm:
- Nội dung thông báo
- Người gửi
- Đối tượng nhận
- Trạng thái gửi
- Trạng thái đọc
- File đính kèm
- Lịch sử cập nhật nếu có

### 6.4. Cập nhật notice

Cho phép cập nhật notice khi thông báo chưa gửi hoặc vẫn còn quyền chỉnh sửa.

Các thông tin có thể cập nhật:
- Tiêu đề
- Nội dung
- Đối tượng nhận
- Lịch gửi
- File đính kèm
- Trạng thái

Thông báo đã gửi cần được kiểm soát khi chỉnh sửa để tránh thay đổi nội dung đã nhận mà không có lịch sử.

### 6.5. Thu hồi hoặc xóa notice

Cho phép thu hồi notice trong trường hợp gửi sai hoặc không còn phù hợp.

Nếu notice đã được gửi, nên ưu tiên thu hồi hoặc chuyển trạng thái hết hiệu lực thay vì xóa cứng.

## 7. Gửi notice

Notice có thể được gửi ngay hoặc đặt lịch gửi.

### 7.1. Gửi ngay

Khi gửi ngay, hệ thống xác định danh sách người nhận tại thời điểm gửi và tạo bản ghi thông báo cho từng người nhận.

### 7.2. Đặt lịch gửi

Khi đặt lịch gửi, notice được lưu ở trạng thái chờ gửi.

Đến thời điểm đã cấu hình, hệ thống thực hiện gửi tới nhóm người nhận đã chọn.

### 7.3. Gửi theo sự kiện

Một số notice có thể phát sinh tự động theo sự kiện hệ thống.

Ví dụ:
- Homework được giao
- Exam sắp diễn ra
- Điểm được công bố
- Feedback được phản hồi
- Tài khoản được tạo

## 8. Trạng thái đọc notice

Mỗi người nhận notice có thể có trạng thái đọc riêng.

Các trạng thái phổ biến gồm:
- Chưa đọc
- Đã đọc
- Đã ẩn nếu người dùng ẩn khỏi danh sách

Hệ thống có thể ghi nhận:
- Thời điểm nhận
- Thời điểm đọc
- Thiết bị hoặc kênh đọc nếu cần

Trạng thái đọc giúp người gửi theo dõi mức độ tiếp nhận của thông báo quan trọng.

## 9. Phân quyền notice

Phân quyền notice phụ thuộc vai trò và phạm vi dữ liệu.

Admin có thể:
- Tạo notice toàn hệ thống
- Gửi notice cho nhiều trường
- Xem thống kê toàn hệ thống
- Thu hồi notice khi cần

Nhà trường có thể:
- Tạo notice trong phạm vi trường
- Gửi notice tới lớp, giáo viên hoặc học sinh thuộc trường
- Xem trạng thái đọc trong phạm vi trường

Giáo viên có thể:
- Tạo notice cho lớp hoặc khóa học được phân công nếu được cấp quyền
- Xem notice do mình tạo
- Theo dõi trạng thái đọc của học sinh liên quan

Học sinh có thể:
- Nhận notice
- Xem chi tiết notice
- Đánh dấu đã đọc

## 10. Quy tắc phạm vi gửi notice

Khi gửi notice, hệ thống cần xác định đúng phạm vi người nhận.

Các nguyên tắc chính:
- Admin được gửi theo phạm vi toàn hệ thống hoặc theo trường
- Nhà trường chỉ gửi trong phạm vi trường của mình
- Giáo viên chỉ gửi trong phạm vi lớp hoặc khóa học được phân công
- Người nhận không thuộc phạm vi gửi sẽ không thấy notice
- Notice gửi theo lớp hoặc khóa học cần dựa trên danh sách người học hiện tại tại thời điểm gửi

## 11. Báo cáo và thống kê notice

Notice có thể có dữ liệu thống kê phục vụ vận hành.

Các chỉ số có thể gồm:
- Số notice đã gửi
- Số người nhận
- Số người đã đọc
- Tỷ lệ đã đọc
- Số notice theo loại
- Số notice theo người gửi
- Số notice theo trường học hoặc lớp học

Dữ liệu này giúp đánh giá hiệu quả truyền thông trong hệ thống.

## 12. Các tình huống nghiệp vụ chính

### 12.1. Admin gửi thông báo hệ thống

Admin gửi notice tới toàn bộ người dùng để thông báo bảo trì, thay đổi chính sách hoặc cập nhật tính năng.

### 12.2. Nhà trường gửi thông báo tới giáo viên và học sinh

Nhà trường gửi notice trong phạm vi trường để thông báo lịch học, sự kiện hoặc yêu cầu vận hành.

### 12.3. Giáo viên gửi thông báo cho lớp học

Giáo viên gửi notice nhắc học sinh chuẩn bị bài, làm homework hoặc tham gia exam.

### 12.4. Hệ thống tự động gửi thông báo bài tập

Khi homework được giao, hệ thống tạo notice cho học sinh thuộc khóa học.

### 12.5. Người dùng đọc notice

Người dùng mở notice, hệ thống ghi nhận trạng thái đã đọc và thời điểm đọc.

### 12.6. Thu hồi notice đã gửi

Khi notice gửi sai nội dung hoặc sai đối tượng, người có quyền thu hồi notice để tránh tiếp tục hiển thị như thông báo hợp lệ.

## Edge cases và điểm cần xác nhận

- Cần xác nhận rule gửi lại notice khi push notification hoặc websocket thất bại.
- Cần xác nhận notice đã gửi có được sửa/xóa hay chỉ thay đổi trạng thái hiển thị.
- Cần xác nhận giới hạn phạm vi nhận khi chọn đồng thời role, school, class hoặc user cụ thể.
- Cần xác nhận cách xử lý khi người nhận bị khóa tài khoản hoặc rời khỏi class/school sau khi notice được tạo.
