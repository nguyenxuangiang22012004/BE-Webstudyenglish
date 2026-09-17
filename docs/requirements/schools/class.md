# Tài Liệu BA Chi Tiết: Class

Status: reviewed
Owner: BA/DEV
Last reviewed: 2026-09-16
Related:
  - docs/api/schools/class.md
  - docs/api/schools/class-hook.md
  - docs/requirements/semesters/school-year.md
  - docs/security/resources/classes.md
  - docs/test-cases/overview.md
Business rule IDs:
  - CLS-BR-001: Class thuộc school và quản lý danh sách học sinh.
  - CLS-BR-002: Class có thể gắn giáo viên, khóa học, năm học/học kỳ, notice và báo cáo.
  - CLS-BR-003: Chuyển lớp hoặc ngưng hoạt động class ảnh hưởng tới phạm vi dữ liệu học sinh.
  - CLS-BR-004: Quyền thao tác class phụ thuộc school/role/permission.

Review note: Các rule class hiện có trong tài liệu đã được xác nhận dùng được cho hiện trạng nghiệp vụ.

## 1. Khái niệm class

Class là lớp học thuộc một school trong hệ thống LMS.

Class dùng để tổ chức học sinh theo nhóm quản lý hành chính hoặc nhóm học tập.

Trong hệ thống, class giúp:
- Gom nhóm học sinh thuộc cùng một lớp
- Gắn giáo viên phụ trách nếu có
- Liên kết lớp với khóa học hoặc học kỳ
- Theo dõi sĩ số và trạng thái lớp
- Hỗ trợ nhà trường quản lý người học theo đơn vị lớp

## 2. Quan hệ của class với các đối tượng khác

### 2.1. Quan hệ với school

Mỗi class thuộc một school.

School là phạm vi quản lý cao hơn của class.

Quan hệ này giúp đảm bảo nhà trường chỉ quản lý các lớp thuộc trường của mình.

### 2.2. Quan hệ với học sinh

Một class có thể có nhiều học sinh.

Học sinh trong class có thể tham gia các khóa học, nhận thông báo theo lớp và được theo dõi theo nhóm lớp.

### 2.3. Quan hệ với giáo viên

Class có thể gắn với một hoặc nhiều giáo viên.

Giáo viên có thể có vai trò:
- Giáo viên chủ nhiệm
- Giáo viên bộ môn
- Giáo viên phụ trách khóa học

### 2.4. Quan hệ với khóa học

Class có thể được dùng để gán học sinh vào khóa học.

Khi một khóa học triển khai cho một class, danh sách học sinh của class có thể được sử dụng để tạo danh sách người học trong khóa học.

### 2.5. Quan hệ với năm học và học kỳ

Class có thể gắn với năm học hoặc học kỳ để phục vụ quản lý theo thời gian.

Trong code hiện tại, class có `school_year_id` và có thể trả về `school_year_name`, `school_year_start_date`, `school_year_end_date`.

Năm học giúp phân tách lớp theo từng năm vận hành. Học kỳ giúp xác định giai đoạn lớp đang hoạt động hoặc được sử dụng trong khóa học nào.

### 2.6. Quan hệ với notice

Notice có thể gửi tới một class.

Khi gửi notice theo class, người nhận thường là học sinh trong class hoặc giáo viên liên quan đến class.

### 2.7. Quan hệ với báo cáo

Class có thể là đơn vị tổng hợp báo cáo học tập.

Báo cáo theo class giúp nhà trường và giáo viên xem tiến độ, điểm số và tình trạng học tập của học sinh trong cùng lớp.

## 3. Class gồm những thông tin gì

Một class có thể bao gồm các nhóm thông tin sau:

### 3.1. Thông tin định danh

- Mã lớp
- Tên lớp
- Mô tả lớp

### 3.2. Thông tin tổ chức

- School
- Khối lớp hoặc cấp học nếu có
- Năm học (`school_year_id`) nếu có
- Học kỳ nếu có
- Trạng thái hoạt động

### 3.3. Thông tin giáo viên

- Giáo viên chủ nhiệm nếu có
- Danh sách giáo viên liên quan
- Vai trò của từng giáo viên trong lớp nếu có

### 3.4. Thông tin học sinh

- Danh sách học sinh
- Sĩ số hiện tại
- Sĩ số tối đa nếu có
- Trạng thái của học sinh trong lớp

### 3.5. Thông tin liên kết học tập

- Danh sách khóa học liên quan
- Danh sách chương trình học liên quan nếu có
- Kết quả học tập tổng hợp nếu có

### 3.6. Thông tin vận hành

- Người tạo
- Người cập nhật
- Thời điểm tạo
- Thời điểm cập nhật
- Ghi chú nội bộ

## 4. Vai trò của class trong hệ thống

Class là đơn vị quản lý học sinh ở cấp lớp.

Class giúp:
- Tổ chức học sinh theo trường
- Hỗ trợ phân công giáo viên
- Hỗ trợ gán học sinh vào khóa học theo nhóm
- Gửi thông báo theo lớp
- Theo dõi tiến độ và kết quả học tập theo lớp
- Quản lý chuyển lớp hoặc thay đổi danh sách học sinh

## 5. CRUD class

### 5.1. Tạo class

Cho phép tạo lớp học mới trong phạm vi school.

Thông tin thường cần khai báo:
- Tên lớp
- School
- Khối lớp hoặc cấp học
- Năm học hoặc học kỳ nếu có
- Giáo viên chủ nhiệm nếu có
- Trạng thái

### 5.2. Xem danh sách class

Cho phép xem danh sách class theo:
- School
- Từ khóa
- Khối lớp
- Năm học
- Học kỳ
- Giáo viên phụ trách
- Trạng thái
- Phân trang

### 5.3. Xem chi tiết class

Cho phép xem chi tiết class, bao gồm:
- Thông tin chung
- School
- Giáo viên liên quan
- Danh sách học sinh
- Sĩ số
- Khóa học liên quan
- Thống kê học tập nếu có

### 5.4. Cập nhật class

Cho phép cập nhật:
- Tên lớp
- Mô tả
- Khối lớp
- Năm học
- Học kỳ
- Giáo viên chủ nhiệm
- Trạng thái
- Ghi chú

### 5.5. Xóa hoặc ngưng hoạt động class

Cho phép xóa hoặc ngưng hoạt động class tùy theo dữ liệu liên quan.

Backend **không** chặn xóa/ngưng class đã có học sinh, course hoặc báo cáo (đã xác nhận). Vì vậy đây là khuyến nghị nghiệp vụ: khi class đã có học sinh, khóa học hoặc kết quả học tập, nên ưu tiên chuyển trạng thái ngưng hoạt động thay vì xóa cứng.

## 6. Quản lý học sinh trong class

Class cần hỗ trợ quản lý danh sách học sinh.

Các thao tác chính gồm:
- Thêm học sinh vào lớp
- Xóa học sinh khỏi lớp
- Chuyển học sinh sang lớp khác
- Import danh sách học sinh
- Xem danh sách học sinh
- Theo dõi trạng thái học sinh trong lớp

Khi thêm học sinh vào class, hệ thống cần kiểm tra:
- Học sinh thuộc cùng school
- Học sinh không đang thuộc class khác — một học sinh **không thể** thuộc nhiều class đồng thời (đã xác nhận)
- Sĩ số tối đa nếu có cấu hình
- Trạng thái tài khoản học sinh

## 7. Quản lý giáo viên trong class

Class có thể gắn giáo viên để phục vụ quản lý và giảng dạy.

Các thao tác chính gồm:
- Gán giáo viên chủ nhiệm
- Gán giáo viên bộ môn
- Xóa giáo viên khỏi lớp
- Cập nhật vai trò giáo viên trong lớp

Giáo viên được gán vào class có thể được cấp quyền xem danh sách học sinh, gửi thông báo hoặc theo dõi báo cáo tùy theo cấu hình quyền.

## 8. Gán class vào khóa học

Class có thể được dùng làm nguồn danh sách học sinh khi tạo hoặc cập nhật khóa học.

Khi gán class vào khóa học:
- Học sinh trong class có thể được thêm vào khóa học
- Giáo viên liên quan có thể được phân công nếu phù hợp
- Khóa học có thể theo dõi kết quả theo class

Cần phân biệt:
- Class là nhóm quản lý học sinh
- Khóa học là nơi triển khai chương trình học
- Học sinh có thể thuộc class nhưng chỉ tham gia khóa học khi được gán vào khóa học

## 9. Chuyển lớp

Chuyển lớp là thao tác di chuyển học sinh từ class này sang class khác.

Khi chuyển lớp, cần xem xét:
- School của lớp đi và lớp đến
- Giai đoạn năm học hoặc học kỳ
- Khóa học học sinh đang tham gia
- Báo cáo và kết quả học tập đã phát sinh

Hệ thống nên lưu lịch sử chuyển lớp nếu cần phục vụ tra cứu sau này.

Hiện **không** có rule chuyển kèm dữ liệu lịch sử học tập và báo cáo khi chuyển lớp (đã xác nhận). Việc chuyển lớp chỉ thay đổi class của học sinh, không di chuyển/đồng bộ dữ liệu học tập và báo cáo cũ.

## 10. Phân quyền class

Phân quyền class phụ thuộc vai trò và phạm vi dữ liệu.

Admin có thể:
- Quản lý toàn bộ class trong hệ thống
- Xem và cập nhật dữ liệu lớp ở mọi school
- Theo dõi thống kê theo lớp

Nhà trường có thể:
- Tạo, sửa, ngưng hoạt động class trong school của mình
- Quản lý học sinh và giáo viên trong class
- Xem báo cáo theo class

Giáo viên có thể:
- Xem class được phân công
- Xem danh sách học sinh nếu có quyền
- Gửi notice hoặc theo dõi kết quả học tập của class nếu được cấp quyền

Quyền của giáo viên chủ nhiệm và giáo viên bộ môn khi xem/sửa dữ liệu class **chính là quyền của role Giáo viên đối với class** (đã xác nhận); không có tập quyền riêng theo vai trò chủ nhiệm/bộ môn. Chi tiết action được cấp xem trong `docs/security/` (resource `classes`).

Học sinh có thể:
- Xem thông tin lớp của mình nếu hệ thống cho phép
- Nhận notice theo class

## 11. Quy tắc nghiệp vụ class

Các quy tắc chính gồm:
- Mỗi class thuộc một school
- Tên class nên không trùng trong cùng school và cùng năm học nếu có ràng buộc
- Học sinh trong class phải thuộc cùng school
- Một học sinh không thể thuộc nhiều class đồng thời
- Giáo viên gắn với class phải thuộc school hoặc được cấp quyền phù hợp
- Không nên xóa cứng class đã có dữ liệu học tập
- Khi class ngưng hoạt động, không nên tiếp tục gán học sinh hoặc khóa học mới vào class đó
- Việc chuyển lớp cần không làm mất kết quả học tập cũ của học sinh

## 12. Báo cáo và thống kê class

Class có thể có dữ liệu thống kê phục vụ quản lý.

Các chỉ số có thể gồm:
- Sĩ số lớp
- Số học sinh đang hoạt động
- Số khóa học liên quan
- Tỷ lệ hoàn thành bài học
- Điểm trung bình theo khóa học hoặc hoạt động
- Số homework đã nộp
- Số exam đã hoàn thành
- Tiến độ học tập của từng học sinh

Dữ liệu này giúp nhà trường và giáo viên theo dõi chất lượng học tập theo lớp.

## 13. Các tình huống nghiệp vụ chính

### 13.1. Nhà trường tạo class mới

Tài khoản nhà trường tạo lớp học mới trong phạm vi school và khai báo thông tin tổ chức ban đầu.

### 13.2. Thêm học sinh vào class

Nhà trường thêm học sinh vào lớp thủ công hoặc import danh sách học sinh từ file.

### 13.3. Gán giáo viên chủ nhiệm

Nhà trường gán giáo viên chủ nhiệm để phụ trách lớp và theo dõi học sinh.

### 13.4. Gán class vào khóa học

Nhà trường hoặc admin sử dụng class để thêm nhóm học sinh vào khóa học.

### 13.5. Chuyển học sinh sang class khác

Khi học sinh đổi lớp, nhà trường chuyển học sinh sang class mới và hệ thống lưu lại dữ liệu học tập cũ.

### 13.6. Gửi notice theo class

Giáo viên hoặc nhà trường gửi thông báo tới học sinh trong class.

### 13.7. Xem báo cáo theo class

Nhà trường hoặc giáo viên xem báo cáo học tập tổng hợp theo lớp để đánh giá tiến độ và kết quả.

### 13.8. Ngưng hoạt động class

Khi lớp không còn sử dụng, nhà trường chuyển class sang trạng thái ngưng hoạt động để bảo toàn dữ liệu cũ.

## Edge cases và ghi chú kiểm thử

### Đã xác nhận

- Backend **không** chặn xóa/ngưng class đã có học sinh, course hoặc báo cáo. Giữ class dạng ngưng hoạt động thay vì xóa cứng là khuyến nghị nghiệp vụ.
- **Không** có rule chuyển kèm dữ liệu lịch sử học tập và báo cáo khi chuyển lớp; chuyển lớp chỉ đổi class của học sinh.
- Một học sinh **không thể** thuộc nhiều class đồng thời.
- Quyền của giáo viên chủ nhiệm/giáo viên bộ môn khi xem/sửa dữ liệu class chính là quyền của role Giáo viên với class — xem chi tiết trong `docs/security/` (resource `classes`).
