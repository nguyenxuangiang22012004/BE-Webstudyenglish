# Tài Liệu BA Chi Tiết: Permission

Status: reviewed
Owner: BA/DEV
Last reviewed: 2026-09-16
Related:
  - docs/api/users/permission.md
  - docs/api/users/role.md
  - docs/security/rbac-matrix.md
  - docs/security/resources/permissions.md
  - docs/security/resources/roles.md
  - docs/test-cases/overview.md
Business rule IDs:
  - PER-BR-001: Permission xác định hành động người dùng được phép thực hiện.
  - PER-BR-002: Permission được gán theo role, không gán trực tiếp cho user.
  - PER-BR-003: Permission cần đi kèm phạm vi dữ liệu như system, school, class, course hoặc cá nhân.
  - PER-BR-004: FE dùng permission để ẩn/hiện UI.
  - PER-BR-005: Backend chịu trách nhiệm chặn action trái quyền.

Review note: Permission thực tế có thể thay đổi do role admin setting. Hệ thống không gán permission trực tiếp vào user mà gán theo role. FE dùng permission để ẩn/hiện UI; việc chặn action phải do BE đảm bảo.

## 1. Khái niệm permission

Permission là quyền thao tác của người dùng trong hệ thống LMS.

Permission xác định người dùng được phép xem, tạo, cập nhật, xóa hoặc thực hiện hành động nghiệp vụ nào trong từng phân hệ.

Phân quyền giúp hệ thống kiểm soát:
- Ai được truy cập chức năng nào
- Ai được thao tác trên dữ liệu nào
- Phạm vi dữ liệu được phép xem hoặc chỉnh sửa
- Quyền quản trị theo toàn hệ thống, theo trường, theo lớp hoặc theo khóa học

## 2. Quan hệ của permission với các đối tượng khác

### 2.1. Quan hệ với user

Permission được áp dụng cho user thông qua vai trò.

Hệ thống hiện tại dùng một role chính cho mỗi user.

### 2.2. Quan hệ với role

Role là nhóm quyền được định nghĩa sẵn.

Các role chính trong hệ thống gồm:
- Admin
- Nhà trường
- Giáo viên
- Học sinh

Role giúp gom nhiều permission thành một nhóm dễ quản lý.

### 2.3. Quan hệ với school

Permission có thể bị giới hạn theo school.

Ví dụ:
- Admin có thể xem dữ liệu toàn hệ thống
- Nhà trường chỉ quản lý dữ liệu thuộc school của mình
- Giáo viên chỉ xem lớp hoặc khóa học được phân công
- Học sinh chỉ xem dữ liệu học tập của bản thân

### 2.4. Quan hệ với class

Permission có thể giới hạn theo class.

Giáo viên được phân công vào class có thể được xem danh sách học sinh, gửi notice hoặc xem báo cáo của class nếu được cấp quyền.

### 2.5. Quan hệ với course

Permission có thể giới hạn theo course.

Người dùng chỉ được thao tác trên khóa học nếu có vai trò phù hợp hoặc được phân công vào khóa học đó.

### 2.6. Quan hệ với module

Permission thường được gắn với module hoặc chức năng.

Các module có thể gồm:
- User
- Permission
- School
- Class
- Program
- Course
- Lesson
- Learning materials
- Question bank
- Homework
- Exam
- Assessment
- Notice
- Feedback
- Report
- Settings

## 3. Permission gồm những thông tin gì

Một permission có thể bao gồm các nhóm thông tin sau:

### 3.1. Thông tin định danh

- Mã permission
- Tên permission
- Mô tả permission
- Mã chức năng hoặc hành động

### 3.2. Thông tin phân loại

- Module
- Nhóm chức năng
- Loại hành động
- Vai trò áp dụng mặc định nếu có

### 3.3. Thông tin phạm vi

- Phạm vi toàn hệ thống
- Phạm vi school
- Phạm vi class
- Phạm vi course
- Phạm vi dữ liệu cá nhân

### 3.4. Thông tin trạng thái

- Trạng thái hoạt động
- Trạng thái hệ thống hoặc quyền tùy chỉnh
- Thời điểm tạo
- Thời điểm cập nhật

## 4. Role trong hệ thống

Role là vai trò nghiệp vụ của người dùng.

Các role chính gồm:

### 4.1. Admin

Admin là vai trò quản trị toàn hệ thống.

Admin có thể:
- Quản lý người dùng và phân quyền
- Quản lý trường học, lớp học, học kỳ
- Quản lý chương trình học và khóa học
- Quản lý học liệu, câu hỏi, bài tập, bài kiểm tra
- Quản lý thông báo, phản hồi, cài đặt
- Xem báo cáo toàn hệ thống

### 4.2. Nhà trường

Nhà trường là vai trò quản trị trong phạm vi school.

Nhà trường có thể:
- Quản lý dữ liệu thuộc school của mình
- Quản lý lớp học, giáo viên, học sinh
- Theo dõi khóa học và báo cáo trong phạm vi trường
- Gửi notice và xử lý feedback thuộc trường

### 4.3. Giáo viên

Giáo viên là vai trò trực tiếp giảng dạy và theo dõi học sinh.

Giáo viên có thể:
- Xem lớp hoặc khóa học được phân công
- Quản lý bài học hoặc học liệu trong phạm vi được cấp quyền
- Giao homework, exam hoặc assessment nếu được phép
- Chấm điểm và xem báo cáo học tập
- Gửi feedback hoặc notice nếu được cấp quyền

### 4.4. Học sinh

Học sinh là vai trò tham gia học tập.

Học sinh có thể:
- Xem khóa học được phân công
- Học bài, làm homework, làm exam, tham gia assessment
- Xem kết quả học tập của bản thân
- Nhận notice
- Tạo feedback

## 5. Loại hành động phân quyền

Permission có thể được chia theo loại hành động.

Các hành động phổ biến gồm:
- Xem danh sách
- Xem chi tiết
- Tạo mới
- Cập nhật
- Xóa
- Import
- Export
- Giao bài
- Chấm điểm
- Công bố điểm
- Gửi notice
- Xử lý feedback
- Xem báo cáo
- Cấu hình hệ thống

Việc chia quyền theo hành động giúp kiểm soát chi tiết hơn so với chỉ chia theo module.

## 6. Phạm vi dữ liệu

Permission cần đi kèm phạm vi dữ liệu.

Các phạm vi chính gồm:

### 6.1. Toàn hệ thống

Người dùng có thể xem hoặc thao tác dữ liệu trên toàn hệ thống.

Phạm vi này thường dành cho admin.

### 6.2. School

Người dùng chỉ được xem hoặc thao tác dữ liệu thuộc school của mình.

Phạm vi này thường dành cho nhà trường.

### 6.3. Class

Người dùng chỉ được xem hoặc thao tác dữ liệu thuộc class được phân công.

Phạm vi này thường áp dụng cho giáo viên.

### 6.4. Course

Người dùng chỉ được xem hoặc thao tác dữ liệu trong course được phân công hoặc tham gia.

### 6.5. Cá nhân

Người dùng chỉ được xem hoặc thao tác dữ liệu của chính mình.

Phạm vi này thường áp dụng cho học sinh.

## 7. CRUD permission

### 7.1. Tạo permission

Cho phép tạo permission mới nếu hệ thống hỗ trợ quyền tùy chỉnh.

Thông tin thường cần khai báo:
- Tên permission
- Mã permission
- Module
- Hành động
- Phạm vi dữ liệu
- Trạng thái

### 7.2. Xem danh sách permission

Cho phép xem danh sách permission theo:
- Module
- Hành động
- Vai trò
- Trạng thái
- Từ khóa
- Phân trang

### 7.3. Xem chi tiết permission

Cho phép xem chi tiết permission, bao gồm:
- Thông tin định danh
- Module liên quan
- Hành động được phép
- Phạm vi dữ liệu
- Role đang sử dụng permission
- User đang được gán quyền nếu có

### 7.4. Cập nhật permission

Cho phép cập nhật:
- Tên permission
- Mô tả
- Trạng thái
- Nhóm chức năng
- Phạm vi áp dụng nếu được phép

Các permission hệ thống cần được kiểm soát chặt khi chỉnh sửa để tránh ảnh hưởng quyền truy cập toàn hệ thống.

### 7.5. Xóa hoặc ngưng sử dụng permission

Cho phép xóa hoặc ngưng sử dụng permission tùy theo loại quyền.

Nếu permission đang được gán cho role hoặc user, nên ngưng sử dụng thay vì xóa cứng.

## 8. Quản lý role và gán quyền

Hệ thống cần hỗ trợ quản lý quyền theo role.

Các thao tác chính gồm:
- Xem danh sách role
- Xem danh sách permission của role
- Gán permission cho role
- Gỡ permission khỏi role
- Sao chép cấu hình quyền từ role khác nếu có
- Khôi phục quyền mặc định nếu có

Quyền theo role giúp quản trị nhanh và nhất quán cho nhóm người dùng cùng loại.

## 9. Quyền theo role

Hệ thống hiện tại không gán quyền trực tiếp cho user.

Permission được gán theo role. Admin có thể thay đổi cấu hình permission của role, và thay đổi đó ảnh hưởng tới các user thuộc role tương ứng.

Vì vậy, khi cần thay đổi quyền của một nhóm người dùng, thao tác đúng là cập nhật role/permission thay vì gán permission riêng cho từng user.

## 10. Ma trận quyền

Ma trận quyền là bảng thể hiện role nào được làm hành động nào trên module nào.

Ví dụ cấu trúc ma trận:
- Module
- Hành động
- Admin
- Nhà trường
- Giáo viên
- Học sinh
- Ghi chú phạm vi dữ liệu

Ma trận quyền giúp:
- Dễ rà soát quyền
- Dễ phát hiện quyền thừa hoặc thiếu
- Làm căn cứ kiểm thử chức năng
- Làm căn cứ thiết kế giao diện ẩn hiện menu và nút thao tác

## 11. Quy tắc kiểm tra quyền

Khi người dùng thao tác, hệ thống cần kiểm tra cả quyền chức năng và phạm vi dữ liệu.

Ví dụ:
- Có quyền xem danh sách học sinh chưa
- Danh sách học sinh có thuộc school của người dùng không
- Người dùng có được phân công vào class hoặc course đó không
- Người dùng có đang ở trạng thái hoạt động không

Kiểm tra quyền chỉ theo role là chưa đủ nếu không kiểm tra phạm vi dữ liệu.

## 12. Hiển thị giao diện theo permission

Permission có thể ảnh hưởng tới giao diện người dùng.

Hệ thống có thể:
- Ẩn menu không có quyền truy cập
- Ẩn nút tạo, sửa, xóa nếu không có quyền
- Hạn chế hiển thị các entry point không phù hợp với permission
- Hiển thị thông báo không có quyền khi backend từ chối thao tác

Việc ẩn giao diện không thay thế kiểm tra quyền ở backend. Backend phải là lớp chặn action trái quyền.

## 13. Nhật ký thay đổi quyền

Thay đổi quyền có thể ảnh hưởng lớn tới hệ thống.

Hệ thống nên ghi nhận lịch sử:
- Ai thay đổi quyền
- Thay đổi quyền nào
- Thay đổi cho role nào
- Thời điểm thay đổi
- Giá trị trước và sau nếu cần

Nhật ký giúp truy vết khi phát sinh lỗi truy cập hoặc rủi ro bảo mật.

## 14. Quy tắc nghiệp vụ permission

Các quy tắc chính gồm:
- User cần có role để xác định quyền cơ bản
- Permission cần gắn với module và hành động rõ ràng
- Quyền thao tác phải đi kèm kiểm tra phạm vi dữ liệu
- Admin có phạm vi toàn hệ thống
- Nhà trường bị giới hạn trong school
- Giáo viên bị giới hạn theo class hoặc course được phân công
- Học sinh bị giới hạn theo dữ liệu học tập của bản thân
- Không nên xóa cứng permission đang được sử dụng
- Thay đổi quyền cần có lịch sử để truy vết

## 15. Các tình huống nghiệp vụ chính

### 15.1. Admin cấu hình quyền cho role

Admin chọn role và gán danh sách permission phù hợp với phạm vi nghiệp vụ.

### 15.2. Nhà trường truy cập dữ liệu trong school

Tài khoản nhà trường chỉ xem được lớp, giáo viên, học sinh và khóa học thuộc school của mình.

### 15.3. Giáo viên xem khóa học được phân công

Giáo viên chỉ thấy khóa học hoặc lớp mà mình được gán quyền tham gia giảng dạy.

### 15.4. Học sinh xem dữ liệu cá nhân

Học sinh chỉ xem được khóa học, bài học, điểm số và báo cáo của bản thân.

### 15.5. Người dùng bị chặn thao tác không có quyền

Khi người dùng truy cập chức năng không được cấp quyền, hệ thống từ chối thao tác và hiển thị thông báo phù hợp.

### 15.6. Admin rà soát ma trận quyền

Admin xem ma trận quyền để kiểm tra role nào đang được phép thao tác trên từng module.
