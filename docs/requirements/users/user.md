# Tài Liệu BA Chi Tiết: User

Status: reviewed
Owner: BA/DEV
Last reviewed: 2026-09-16
Related:
  - docs/api/users/user.md
  - docs/api/users/profile.md
  - docs/api/users/student.md
  - docs/api/users/teacher.md
  - docs/requirements/users/parent.md
  - docs/security/resources/users.md
  - docs/test-cases/overview.md
Business rule IDs:
  - USR-BR-001: User là thực thể định danh có một role chính, trạng thái và liên kết tổ chức.
  - USR-BR-002: Admin/Nhà trường có thể tạo và quản lý user theo phạm vi quyền.
  - USR-BR-003: User đăng nhập để truy cập khu vực làm việc phù hợp với role.
  - USR-BR-004: User dừng hoạt động thì không đăng nhập được.
  - USR-BR-005: Hồ sơ cá nhân cho phép user xem hoặc cập nhật thông tin theo quyền.

Review note: Hệ thống hiện tại chỉ dùng một role chính cho mỗi user. Permission không gán trực tiếp cho user, chỉ gán thông qua role.

## 1. Khái niệm user

User là tài khoản người dùng trong hệ thống LMS.

User đại diện cho một cá nhân hoặc một tài khoản vận hành có quyền đăng nhập và sử dụng hệ thống theo vai trò được cấp.

Các nhóm user chính gồm:
- Admin
- Nhà trường
- Giáo viên
- Học sinh

User là nền tảng cho xác thực, phân quyền, quản lý hồ sơ, tham gia học tập, giảng dạy và vận hành hệ thống.

## 2. Quan hệ của user với các đối tượng khác

### 2.1. Quan hệ với role

User được gắn với một role chính.

Role xác định nhóm quyền cơ bản của user trong hệ thống.

Hệ thống hiện tại không dùng cơ chế một user có nhiều role song song.

### 2.2. Quan hệ với permission

User có quyền thao tác thông qua role.

Permission quyết định user được làm gì và được thao tác trên phạm vi dữ liệu nào. Hệ thống hiện tại không gán permission trực tiếp cho user.

### 2.3. Quan hệ với school

User có thể thuộc một school.

Quan hệ này đặc biệt quan trọng với:
- Nhà trường
- Giáo viên
- Học sinh

School giúp giới hạn phạm vi dữ liệu mà user được xem hoặc quản lý.

### 2.4. Quan hệ với class

User có thể liên quan đến class.

Học sinh có thể thuộc một hoặc nhiều class theo giai đoạn quản lý.

Giáo viên có thể được phân công vào class để giảng dạy, quản lý hoặc theo dõi học sinh.

### 2.5. Quan hệ với course

User có thể tham gia course với vai trò khác nhau.

Giáo viên có thể được phân công giảng dạy course.

Học sinh có thể được gán vào course để học tập, làm bài và theo dõi kết quả.

### 2.6. Quan hệ với hoạt động học tập

User có thể phát sinh dữ liệu trong các hoạt động học tập.

Ví dụ:
- Học sinh làm homework
- Học sinh làm exam
- Học sinh học vocabulary
- Giáo viên chấm điểm
- Giáo viên tạo feedback
- Người dùng đọc notice

### 2.7. Quan hệ với feedback và notice

User có thể tạo feedback, xử lý feedback hoặc nhận notice.

Notice và feedback đều cần lưu thông tin user liên quan để phục vụ truy vết và vận hành.

## 3. User gồm những thông tin gì

Một user có thể bao gồm các nhóm thông tin sau:

### 3.1. Thông tin định danh

- Mã user
- Họ và tên
- Tên hiển thị
- Mã người dùng nội bộ nếu có

### 3.2. Thông tin đăng nhập

- Tên đăng nhập
- Email
- Số điện thoại nếu dùng để đăng nhập
- Mật khẩu đã mã hóa
- Phương thức đăng nhập
- Trạng thái xác thực

### 3.3. Thông tin vai trò

- Role
- Permission bổ sung nếu có
- Phạm vi dữ liệu
- Trạng thái phân quyền

### 3.4. Thông tin tổ chức

- School
- Class
- Course liên quan
- Mã học sinh hoặc mã giáo viên nếu có

### 3.5. Thông tin cá nhân

- Ngày sinh
- Giới tính
- Ảnh đại diện
- Địa chỉ
- Thông tin liên hệ
- Người giám hộ nếu áp dụng cho học sinh

### 3.6. Thông tin vận hành

- Trạng thái tài khoản
- Thời điểm tạo
- Thời điểm cập nhật
- Lần đăng nhập gần nhất
- Người tạo
- Người cập nhật
- Ghi chú nội bộ

## 4. Nhóm user trong hệ thống

### 4.1. Admin

Admin là user quản trị toàn hệ thống.

Admin có phạm vi dữ liệu rộng nhất và thường chịu trách nhiệm cấu hình, quản trị, phân quyền và theo dõi vận hành.

### 4.2. Nhà trường

Nhà trường là user quản trị trong phạm vi school.

User nhóm nhà trường có thể quản lý lớp, giáo viên, học sinh, khóa học, notice, feedback và báo cáo trong phạm vi trường nếu được cấp quyền.

### 4.3. Giáo viên

Giáo viên là user trực tiếp tham gia giảng dạy.

Giáo viên có thể được phân công vào class hoặc course để quản lý bài học, giao bài, chấm điểm và theo dõi học sinh.

### 4.4. Học sinh

Học sinh là user tham gia học tập.

Học sinh truy cập khóa học, học bài, làm bài, nhận notice, gửi feedback và xem kết quả học tập của bản thân.

### 4.5. Phụ huynh

Phụ huynh là user có role `parents` trong frontend routing.

Phụ huynh có thể:

- Xem danh sách tài khoản con.
- Chọn tài khoản con để chuyển phiên sang học sinh.
- Theo dõi trải nghiệm học tập của con thông qua phiên học sinh.

Chi tiết nằm trong `docs/requirements/users/parent.md`.

## 5. Trạng thái user

User có thể có nhiều trạng thái vận hành.

Các trạng thái phổ biến gồm:
- Hoạt động
- Chưa kích hoạt
- Tạm khóa
- Ngưng hoạt động
- Đã xóa

Trạng thái user ảnh hưởng trực tiếp đến khả năng đăng nhập và thao tác trong hệ thống.

## 6. CRUD user

### 6.1. Tạo user

Cho phép tạo tài khoản user mới.

Thông tin bắt buộc khi tạo user:
- Họ tên
- Tài khoản
- Mật khẩu

Thông tin khai báo tùy bối cảnh hoặc theo phân quyền:
- Role
- School nếu có
- Class nếu là học sinh
- Thông tin liên hệ
- Trạng thái tài khoản

### 6.2. Xem danh sách user

Cho phép xem danh sách user theo:
- Từ khóa
- Role
- School
- Class
- Trạng thái
- Ngày tạo
- Phân trang

### 6.3. Xem chi tiết user

Cho phép xem chi tiết user, bao gồm:
- Thông tin cá nhân
- Thông tin đăng nhập
- Role và permission
- School, class, course liên quan
- Trạng thái tài khoản
- Lịch sử hoạt động nếu có

### 6.4. Cập nhật user

Cho phép cập nhật:
- Họ tên
- Thông tin liên hệ
- Ảnh đại diện
- Role
- School
- Class
- Trạng thái tài khoản
- Ghi chú nội bộ

Việc cập nhật role hoặc school cần được kiểm soát vì có thể ảnh hưởng tới phạm vi dữ liệu người dùng được truy cập.

### 6.5. Xóa hoặc ngưng hoạt động user

Cho phép xóa hoặc ngưng hoạt động user.

Theo xác nhận nghiệp vụ hiện tại, backend không chặn xóa user dù user đã có dữ liệu học tập, bài nộp hoặc lịch sử thao tác.

Về vận hành, nếu cần giữ truy vết dữ liệu cũ, team có thể ưu tiên chuyển trạng thái ngưng hoạt động thay vì xóa cứng. Đây là khuyến nghị vận hành, không phải rule chặn từ backend.

## 7. Tạo user hàng loạt

Hệ thống có thể hỗ trợ import user từ file.

Import user giúp:
- Tạo nhanh danh sách học sinh
- Tạo nhanh danh sách giáo viên
- Gán school hoặc class hàng loạt
- Chuẩn hóa dữ liệu người dùng theo mẫu

Khi import, hệ thống cần kiểm tra:
- Dữ liệu bắt buộc
- Email hoặc tên đăng nhập trùng
- School hợp lệ
- Class hợp lệ
- Role hợp lệ
- Định dạng file

## 8. Quản lý tài khoản đăng nhập

User cần có thông tin đăng nhập để truy cập hệ thống.

Các chức năng liên quan gồm:
- Đăng nhập
- Đăng xuất
- Làm mới phiên đăng nhập
- Đổi mật khẩu
- Quên mật khẩu
- Kích hoạt tài khoản
- Khóa tài khoản
- Mở khóa tài khoản

Hệ thống cần bảo vệ thông tin đăng nhập và không lưu mật khẩu ở dạng rõ.

## 9. Hồ sơ cá nhân

User có thể có trang hồ sơ cá nhân.

Hồ sơ cá nhân có thể hiển thị:
- Họ tên
- Ảnh đại diện
- Email
- Số điện thoại
- School
- Class hoặc course liên quan
- Vai trò

Tùy vai trò, user có thể được phép tự cập nhật một số thông tin cá nhân.

## 10. Quản lý user theo school

School là phạm vi tổ chức quan trọng của user.

Nhà trường có thể quản lý user thuộc school của mình nếu được cấp quyền.

Các thao tác có thể gồm:
- Tạo giáo viên
- Tạo học sinh
- Gán học sinh vào class
- Gán giáo viên vào class hoặc course
- Khóa hoặc ngưng hoạt động tài khoản trong phạm vi school

Admin có thể quản lý user ở mọi school.

## 11. Quản lý học sinh

Học sinh là user có dữ liệu học tập phát sinh nhiều nhất.

Thông tin quản lý học sinh có thể gồm:
- Mã học sinh
- School
- Class
- Danh sách course đang học
- Kết quả học tập
- Tiến độ học
- Feedback đã gửi
- Notice đã nhận

Khi học sinh chuyển lớp hoặc ngưng học, hệ thống cần bảo toàn dữ liệu học tập cũ.

## 12. Quản lý giáo viên

Giáo viên là user được phân công giảng dạy hoặc hỗ trợ học tập.

Thông tin quản lý giáo viên có thể gồm:
- Mã giáo viên
- School
- Danh sách class được phân công
- Danh sách course được phân công
- Môn học hoặc chuyên môn nếu có
- Hoạt động chấm điểm hoặc phản hồi

Quyền của giáo viên phụ thuộc vào phân công và permission được cấp.

## 13. Phân quyền user

Phân quyền user xác định khả năng truy cập chức năng và dữ liệu.

Các yếu tố ảnh hưởng tới quyền user:
- Role
- Permission trực tiếp nếu có
- School
- Class
- Course
- Trạng thái tài khoản

Hệ thống cần kiểm tra cả role và phạm vi dữ liệu trước khi cho phép user thao tác.

## 14. Bảo mật và kiểm soát truy cập

User là đối tượng trung tâm của bảo mật hệ thống.

Các nguyên tắc chính:
- Mật khẩu không được lưu dạng rõ
- User bị khóa bị chặn ở lần đăng nhập tiếp theo
- User ngưng hoạt động bị chặn ở lần đăng nhập tiếp theo
- Quyền truy cập cần kiểm tra theo vai trò và phạm vi dữ liệu
- Thay đổi thông tin quan trọng cần ghi nhận lịch sử nếu có
- Phiên đăng nhập cần hết hạn theo chính sách hệ thống

## 15. Nhật ký hoạt động user

Hệ thống có thể ghi nhận nhật ký hoạt động của user.

Các hoạt động có thể ghi nhận:
- Đăng nhập
- Đăng xuất
- Đổi mật khẩu
- Cập nhật hồ sơ
- Thay đổi role hoặc permission
- Thao tác tạo, sửa, xóa dữ liệu quan trọng

Nhật ký giúp truy vết khi có vấn đề về bảo mật hoặc vận hành.

## 16. Quy tắc nghiệp vụ user

Các quy tắc chính gồm:
- Mỗi user cần có định danh duy nhất
- User cần có role để sử dụng hệ thống
- User thuộc school phải bị giới hạn dữ liệu theo school nếu không phải admin
- Học sinh cần được gắn class hoặc course để học tập
- Giáo viên cần được phân công class hoặc course để giảng dạy
- Backend hiện không chặn xóa cứng user đã phát sinh dữ liệu học tập, bài nộp hoặc lịch sử thao tác
- Trạng thái user quyết định khả năng đăng nhập
- User có một role chính; quyền của user được xác định theo role đó
- Thay đổi role cần kiểm soát vì ảnh hưởng tới quyền truy cập

## 17. Các tình huống nghiệp vụ chính

### 17.1. Admin tạo user nhà trường

Admin tạo tài khoản nhà trường và gán school để tài khoản quản lý dữ liệu trong phạm vi trường.

### 17.2. Nhà trường tạo học sinh

Nhà trường tạo học sinh mới, gán vào school và class phù hợp.

### 17.3. Nhà trường tạo giáo viên

Nhà trường tạo giáo viên, gán school và phân công vào class hoặc course.

### 17.4. User đăng nhập hệ thống

User nhập thông tin đăng nhập, hệ thống xác thực tài khoản, kiểm tra trạng thái và điều hướng theo role.

### 17.5. Admin khóa tài khoản user

Admin khóa tài khoản khi user không còn được phép truy cập hoặc có rủi ro bảo mật.

### 17.6. Học sinh cập nhật hồ sơ cá nhân

Học sinh cập nhật các thông tin cá nhân được phép chỉnh sửa như ảnh đại diện hoặc số điện thoại.

### 17.7. Giáo viên xem danh sách học sinh được phân công

Giáo viên truy cập danh sách học sinh trong class hoặc course được phân công nếu có quyền phù hợp.

### 17.8. User ngưng hoạt động

Khi user không còn sử dụng hệ thống, tài khoản được chuyển sang trạng thái ngưng hoạt động để bảo toàn dữ liệu cũ.

## Edge cases và quyết định đã xác nhận

- Đã xác nhận: backend không chặn xóa user đã có dữ liệu học tập, bài nộp hoặc lịch sử thao tác.
- Đã xác nhận: hệ thống hiện tại chỉ dùng một role chính cho mỗi user; không gán permission trực tiếp cho user.
- Đã xác nhận: khi Admin khóa tài khoản hoặc chuyển user sang ngưng hoạt động, user bị chặn ở lần đăng nhập tiếp theo.
- Đã xác nhận: dữ liệu bắt buộc khi tạo user gồm họ tên, tài khoản và mật khẩu.
