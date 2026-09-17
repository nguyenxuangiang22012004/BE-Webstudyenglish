# Tài Liệu BA Chi Tiết: Lecture

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-06-04
Related:
  - docs/api/learning-materials/lesson.md
  - docs/api/programs/lesson-plan.md
  - docs/api/programs/lesson-plan-part.md
  - docs/security/resources/lesson-plans.md
  - docs/security/resources/lesson-plan-parts.md
  - docs/test-cases/overview.md
Business rule IDs:
  - LEC-BR-001: Lecture là học liệu/bài giảng gắn với lesson, program hoặc course.
  - LEC-BR-002: Lecture có thể gồm nhiều phần nội dung và tài nguyên.
  - LEC-BR-003: Khi quản lý trong chương trình học, lecture là dữ liệu gốc dùng để tái sử dụng.
  - LEC-BR-004: Khi có course_id, lecture thuộc bối cảnh khóa học cụ thể.

## 1. Khái niệm lecture

Lecture là thành phần bài học dùng để tổ chức nội dung giảng dạy.

Trong hệ thống, lecture không chỉ là một bài giảng đơn lẻ mà còn có thể bao gồm nhiều phần nội dung con để tạo thành một cấu trúc giảng dạy hoàn chỉnh.

## 2. Quan hệ của lecture với các đối tượng khác

### 2.1. Quan hệ với bài học

Lecture thuộc bài học và là một trong các thành phần bài học.

Một bài học có thể có một hoặc nhiều lecture.

### 2.2. Quan hệ với chương trình học

Lecture có thể là nội dung gốc của bài học trong chương trình học.

Trong phạm vi chương trình học, lecture là một phần của cấu trúc nội dung chuẩn.

### 2.3. Quan hệ với khóa học

Khi bài học được mở trong bối cảnh có `course_id`, lecture có thể được bổ sung hoặc được vận hành theo ngữ cảnh của khóa học.

Lecture trong khóa học gắn với:
- Người học cụ thể
- Tiến độ học tập
- Trạng thái hoàn thành

### 2.4. Quan hệ với các phần của bài giảng

Lecture có thể bao gồm nhiều phần bài giảng.

Mỗi phần bài giảng giúp chia lecture thành các khối nội dung nhỏ hơn như:
- Nội dung đọc
- Nội dung xem
- Tài nguyên đính kèm
- Hướng dẫn cho giáo viên
- Hướng dẫn cho học sinh

## 3. Lecture gồm những thông tin gì

Một lecture có thể bao gồm các nhóm thông tin sau:

### 3.1. Thông tin định danh

- Mã lecture
- Tên lecture
- Mô tả lecture

### 3.2. Thông tin tổ chức

- Bài học
- Trạng thái
- Thứ tự hiển thị

### 3.3. Thông tin nội dung

- Tổng thời lượng
- Ảnh đại diện
- Danh sách phần bài giảng

### 3.4. Thông tin vận hành

- Số lượt xem nếu có
- Trạng thái hoàn thành nếu có
- Ngữ cảnh khóa học nếu có `course_id`

## 4. Phần bài giảng là gì

Phần bài giảng là đơn vị nội dung con của lecture.

Mỗi phần bài giảng có thể bao gồm:
- Tiêu đề
- Nhãn hoặc loại nội dung
- Ảnh đại diện
- Tệp hoặc đường dẫn nội dung
- Loại tệp
- Liên kết
- Loại liên kết
- Hướng dẫn cho giáo viên
- Hướng dẫn cho học sinh
- Thời lượng
- Thứ tự hiển thị

## 5. Vai trò của lecture trong học tập

Lecture là thành phần trung tâm cho nội dung giảng dạy.

Lecture giúp:
- Trình bày nội dung học
- Tổ chức tiến trình học trong bài học
- Chia nội dung thành nhiều phần nhỏ có cấu trúc
- Theo dõi trạng thái hoàn thành khi được triển khai trong khóa học

## 6. CRUD lecture

### 6.1. Tạo lecture

Cho phép tạo lecture mới trong bài học.

Thông tin thường cần khai báo:
- Tên lecture
- Mô tả
- Bài học
- Trạng thái
- Thứ tự hiển thị
- Tổng thời lượng
- Ảnh đại diện

### 6.2. Xem danh sách lecture

Cho phép xem danh sách lecture theo:
- Bài học
- Trạng thái
- Từ khóa
- Phân trang

### 6.3. Xem chi tiết lecture

Cho phép xem chi tiết lecture, bao gồm:
- Thông tin chung
- Danh sách phần bài giảng
- Trạng thái hoàn thành nếu có

### 6.4. Cập nhật lecture

Cho phép cập nhật:
- Tên lecture
- Mô tả
- Trạng thái
- Thứ tự hiển thị
- Tổng thời lượng
- Ảnh đại diện
- Danh sách bài học liên kết nếu có

### 6.5. Xóa lecture

Cho phép xóa lecture khỏi bài học.

Khi xóa lecture, cần xem xét ảnh hưởng đến:
- Các phần bài giảng
- Tiến độ học tập
- Trạng thái hoàn thành trong khóa học

## 7. CRUD phần bài giảng

### 7.1. Tạo phần bài giảng

Cho phép tạo phần bài giảng mới trong một lecture.

### 7.2. Xem phần bài giảng

Cho phép xem danh sách phần bài giảng theo lecture.

### 7.3. Cập nhật phần bài giảng

Cho phép cập nhật thông tin từng phần bài giảng.

### 7.4. Xóa phần bài giảng

Cho phép xóa phần bài giảng khỏi lecture.

## 8. Quy tắc quản lý lecture trong chương trình học

Trong phạm vi chương trình học:
- Được phép tạo lecture
- Được phép sửa lecture
- Được phép xóa lecture
- Được phép tạo, sửa, xóa phần bài giảng

Lecture ở cấp chương trình là nội dung gốc của bài học.

## 9. Quy tắc quản lý lecture khi có course_id

Khi thao tác trong bối cảnh có `course_id`:
- Được phép thêm lecture vào bài học
- Được phép bổ sung phần nội dung phục vụ vận hành khóa học
- Không làm thay đổi nội dung gốc đã có trong chương trình
- Không xóa nội dung gốc đã có trong chương trình

Ngoài ra, lecture trong khóa học còn có thể được dùng để theo dõi trạng thái hoàn thành.

## 10. Trạng thái hoàn thành lecture

Lecture có thể ghi nhận trạng thái hoàn thành trong bối cảnh khóa học.

Trạng thái này giúp:
- Theo dõi tiến độ học của học sinh
- Xác định mức độ hoàn thành nội dung giảng dạy
- Hỗ trợ điều phối quá trình học tập

## 11. Các tình huống nghiệp vụ chính

### 11.1. Tạo lecture trong bài học

Người dùng tạo lecture để bổ sung nội dung giảng dạy cho bài học.

### 11.2. Tạo phần bài giảng trong lecture

Người dùng chia bài giảng thành nhiều phần để tổ chức nội dung rõ ràng hơn.

### 11.3. Cập nhật lecture gốc trong chương trình học

Người dùng chỉnh sửa nội dung lecture chuẩn của bài học trong chương trình học.

### 11.4. Thêm lecture trong bối cảnh khóa học

Khi bài học được mở với `course_id`, người dùng được thêm lecture để phục vụ thực tế triển khai của khóa học.

### 11.5. Theo dõi hoàn thành lecture

Lecture được dùng để theo dõi tiến độ hoàn thành nội dung học của người học trong khóa học.

## Edge cases và điểm cần xác nhận

- Cần xác nhận backend có chặn xóa lecture đang được gắn vào lesson/course hay không.
- Cần xác nhận rule xử lý file/học liệu không còn tồn tại hoặc upload lỗi.
- Cần xác nhận lecture trong chương trình học và lecture theo course_id có được đồng bộ hai chiều hay chỉ sao chép một lần.
- Cần xác nhận rule hiển thị với H5P hoặc media đặc biệt nếu file không render được trên client.
