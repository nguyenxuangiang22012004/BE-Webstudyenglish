# Tài Liệu BA Chi Tiết: School

Status: reviewed
Owner: BA/DEV
Last reviewed: 2026-09-16
Related:
  - docs/api/schools/school.md
  - docs/api/schools/school-hook.md
  - docs/security/resources/schools.md
  - docs/test-cases/overview.md
Business rule IDs:
  - SCH-BR-001: School là đơn vị tổ chức quản lý dữ liệu theo phạm vi trường.
  - SCH-BR-002: School liên kết với class, student, teacher, course, program, notice và feedback.
  - SCH-BR-003: Nhà trường chỉ quản lý dữ liệu thuộc school của mình.
  - SCH-BR-004: Admin có thể quản lý nhiều school và dữ liệu toàn hệ thống.

Review note: Nếu school bị inactive, user thuộc school đó vẫn login được. Trạng thái inactive của school không tự động chặn đăng nhập user.

## 1. Khái niệm school

School là đơn vị tổ chức đại diện cho một trường học hoặc cơ sở đào tạo trong hệ thống LMS.

School là phạm vi quản lý dữ liệu quan trọng, dùng để tách biệt người dùng, lớp học, giáo viên, học sinh, khóa học và các hoạt động vận hành theo từng đơn vị.

Trong hệ thống, school giúp xác định:
- Người dùng thuộc trường nào
- Lớp học thuộc trường nào
- Khóa học được triển khai cho trường nào
- Nhà trường được phép quản lý phạm vi dữ liệu nào
- Báo cáo và thống kê được tổng hợp theo đơn vị nào

## 2. Quan hệ của school với các đối tượng khác

### 2.1. Quan hệ với nhà trường

Nhà trường là nhóm người dùng quản trị trong phạm vi một school.

Tài khoản nhà trường có thể quản lý dữ liệu thuộc school của mình theo quyền được cấp.

### 2.2. Quan hệ với lớp học

Một school có thể có nhiều lớp học.

Class là đơn vị tổ chức học sinh trong phạm vi school.

Quan hệ này giúp:
- Quản lý danh sách lớp theo trường
- Gắn học sinh vào lớp
- Theo dõi sĩ số và trạng thái lớp
- Tổ chức học tập theo đơn vị lớp

### 2.3. Quan hệ với học sinh

Một school có thể có nhiều học sinh.

Học sinh thuộc school sẽ tham gia lớp học, khóa học và các hoạt động học tập trong phạm vi dữ liệu của school đó.

### 2.4. Quan hệ với giáo viên

Một school có thể có nhiều giáo viên.

Giáo viên thuộc school có thể được phân công vào lớp học, khóa học hoặc các hoạt động giảng dạy trong phạm vi trường.

### 2.5. Quan hệ với khóa học

School có thể là đơn vị triển khai hoặc quản lý khóa học.

Khóa học trong phạm vi school có thể gắn với:
- Chương trình học
- Học kỳ
- Lớp học
- Giáo viên
- Học sinh

### 2.6. Quan hệ với chương trình học

School có thể sử dụng chương trình học được admin cấu hình hoặc chương trình học được phép triển khai trong phạm vi trường.

Tùy mô hình hệ thống, school có thể:
- Chỉ sử dụng chương trình học chung
- Được gán chương trình học phù hợp
- Được tạo hoặc tùy chỉnh một phần nội dung nếu được cấp quyền

### 2.7. Quan hệ với notice và feedback

School là phạm vi dữ liệu cho thông báo và phản hồi.

Nhà trường có thể gửi notice và xử lý feedback trong phạm vi school của mình.

## 3. School gồm những thông tin gì

Một school có thể bao gồm các nhóm thông tin sau:

### 3.1. Thông tin định danh

- Mã trường
- Tên trường
- Tên viết tắt nếu có
- Mã định danh nội bộ nếu có

### 3.2. Thông tin liên hệ

- Địa chỉ
- Tỉnh hoặc thành phố
- Quận hoặc huyện
- Số điện thoại
- Email
- Website nếu có

### 3.3. Thông tin tổ chức

- Loại trường
- Cấp học
- Đơn vị quản lý nếu có
- Người đại diện hoặc đầu mối liên hệ

### 3.4. Thông tin tài khoản quản trị

- Danh sách tài khoản nhà trường
- Người phụ trách chính
- Trạng thái tài khoản liên quan

### 3.5. Thông tin vận hành

- Trạng thái hoạt động
- Ngày tạo
- Ngày cập nhật
- Ghi chú nội bộ

### 3.6. Thông tin liên kết

- Danh sách lớp học
- Danh sách giáo viên
- Danh sách học sinh
- Danh sách khóa học
- Danh sách chương trình học được sử dụng nếu có

## 4. Vai trò của school trong hệ thống

School là lớp tổ chức dữ liệu ở cấp đơn vị.

School giúp:
- Tách biệt dữ liệu giữa các trường
- Xác định phạm vi quản trị của nhà trường
- Quản lý lớp, giáo viên, học sinh theo đơn vị
- Tổ chức khóa học và học kỳ theo trường
- Tổng hợp báo cáo theo trường
- Kiểm soát quyền truy cập dữ liệu

## 5. CRUD school

### 5.1. Tạo school

Cho phép tạo trường học mới trong hệ thống.

Thông tin thường cần khai báo:
- Tên trường
- Mã trường
- Địa chỉ
- Thông tin liên hệ
- Loại trường hoặc cấp học nếu có
- Trạng thái hoạt động
- Tài khoản quản trị trường nếu tạo đồng thời

### 5.2. Xem danh sách school

Cho phép xem danh sách trường theo:
- Từ khóa
- Tỉnh hoặc thành phố
- Loại trường
- Trạng thái
- Phân trang

### 5.3. Xem chi tiết school

Cho phép xem chi tiết school, bao gồm:
- Thông tin chung
- Thông tin liên hệ
- Tài khoản nhà trường
- Danh sách lớp
- Danh sách giáo viên
- Danh sách học sinh
- Danh sách khóa học
- Thống kê liên quan nếu có

### 5.4. Cập nhật school

Cho phép cập nhật:
- Tên trường
- Địa chỉ
- Thông tin liên hệ
- Loại trường
- Trạng thái
- Ghi chú
- Tài khoản quản trị liên quan

### 5.5. Xóa hoặc ngưng hoạt động school

Cho phép xóa hoặc ngưng hoạt động school tùy theo trạng thái dữ liệu.

Backend **không** chặn xóa/ngưng school đã có user, class, course hoặc báo cáo (đã xác nhận). Vì vậy đây là khuyến nghị nghiệp vụ phía FE/người dùng: khi school đã có lớp học, người dùng, khóa học hoặc dữ liệu học tập, nên ưu tiên chuyển trạng thái ngưng hoạt động thay vì xóa cứng để tránh mất dữ liệu liên quan.

## 6. Quản lý người dùng theo school

School là căn cứ để quản lý người dùng thuộc trường.

Các nhóm người dùng trong school gồm:
- Tài khoản nhà trường
- Giáo viên
- Học sinh

Khi người dùng thuộc một school, phạm vi truy cập dữ liệu của người đó thường bị giới hạn theo school.

Điều này giúp:
- Giáo viên chỉ thấy lớp, khóa học hoặc học sinh liên quan
- Học sinh chỉ thấy dữ liệu học tập của mình trong phạm vi trường
- Nhà trường chỉ quản lý dữ liệu thuộc trường của mình

## 7. Quản lý lớp học theo school

Một school có thể có nhiều class.

Class giúp school tổ chức học sinh theo đơn vị lớp.

School có thể quản lý:
- Danh sách lớp
- Giáo viên chủ nhiệm nếu có
- Danh sách học sinh trong lớp
- Trạng thái lớp
- Năm học hoặc học kỳ liên quan

## 8. Quản lý khóa học theo school

School có thể triển khai nhiều khóa học.

Khóa học trong school thường gắn với:
- Chương trình học
- Học kỳ
- Giáo viên
- Học sinh
- Lớp học

School là phạm vi để nhà trường theo dõi quá trình triển khai khóa học và kết quả học tập.

## 9. Phân quyền school

Phân quyền school giúp kiểm soát ai được xem và thao tác dữ liệu của trường.

Admin có thể:
- Tạo, sửa, xóa hoặc ngưng hoạt động school
- Xem toàn bộ dữ liệu trường
- Gán tài khoản nhà trường
- Theo dõi thống kê toàn hệ thống

Nhà trường có thể:
- Xem thông tin school của mình
- Quản lý lớp, giáo viên, học sinh trong phạm vi quyền
- Quản lý khóa học và hoạt động học tập trong phạm vi trường
- Xem báo cáo của trường

Giáo viên có thể:
- Xem thông tin trường liên quan đến mình nếu được cấp quyền
- Xem lớp hoặc khóa học được phân công

Học sinh có thể:
- Xem thông tin cơ bản liên quan đến trường nếu hệ thống cho phép
- Truy cập dữ liệu học tập thuộc trường của mình

## 10. Quy tắc nghiệp vụ school

Các quy tắc chính gồm:
- Mỗi school cần có thông tin định danh rõ ràng
- Mã trường nên là duy nhất trong hệ thống
- Lớp học phải thuộc một school cụ thể
- Giáo viên và học sinh cần được xác định thuộc school nào
- Nhà trường không được truy cập dữ liệu ngoài phạm vi school nếu không có quyền admin
- Không nên xóa cứng school đã phát sinh dữ liệu học tập
- Khi school ngưng hoạt động, user thuộc school vẫn login được; việc giới hạn truy cập dữ liệu liên quan nếu có phải do rule riêng xử lý.

## 11. Báo cáo và thống kê school

School có thể có các dữ liệu thống kê phục vụ quản trị.

Các chỉ số có thể gồm:
- Số lớp học
- Số giáo viên
- Số học sinh
- Số khóa học đang hoạt động
- Tỷ lệ hoàn thành học tập
- Kết quả học tập theo khóa học
- Số feedback theo trường
- Số notice đã gửi trong trường

Dữ liệu này giúp admin và nhà trường theo dõi hoạt động của từng đơn vị.

Phạm vi thống kê theo vai trò (đã xác nhận):
- Admin thấy thống kê của **tất cả** trường có trong hệ thống.
- Nhà trường chỉ thấy dữ liệu/thống kê của **trường mình**.

## 12. Các tình huống nghiệp vụ chính

### 12.1. Admin tạo school mới

Admin tạo hồ sơ trường học mới và cấu hình thông tin liên hệ, trạng thái, tài khoản quản trị trường.

### 12.2. Nhà trường quản lý dữ liệu của school

Tài khoản nhà trường đăng nhập và thao tác trên lớp học, giáo viên, học sinh, khóa học thuộc school của mình.

### 12.3. Admin cập nhật trạng thái school

Admin chuyển school sang trạng thái ngưng hoạt động khi trường không còn sử dụng hệ thống.

### 12.4. Nhà trường xem thống kê hoạt động

Nhà trường xem thống kê số lớp, số học sinh, khóa học và kết quả học tập trong phạm vi trường.

### 12.5. Gán giáo viên và học sinh vào school

Admin hoặc nhà trường tạo hoặc import người dùng, sau đó gán vào đúng school để xác định phạm vi dữ liệu.

### 12.6. Kiểm soát truy cập theo school

Hệ thống kiểm tra school của người dùng để giới hạn dữ liệu được xem và thao tác.

## Edge cases và ghi chú kiểm thử

### Đã xác nhận

- Backend **không** chặn xóa/ngưng school đã có user, class, course hoặc báo cáo. Việc giữ school dạng ngưng hoạt động thay vì xóa cứng là khuyến nghị nghiệp vụ, không phải ràng buộc backend.
- **Không** có rule chuyển dữ liệu giữa school hoặc gộp/tách school.
- Admin thấy thống kê của tất cả trường trong hệ thống; nhà trường chỉ thấy dữ liệu của trường mình.
- Trường hợp school bị inactive thì user thuộc school vẫn đăng nhập được.
