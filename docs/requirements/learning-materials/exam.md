# Tài Liệu BA Chi Tiết: Exam

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-06-04
Related:
  - docs/api/learning-materials/exam.md
  - docs/security/resources/exams.md
  - docs/requirements/learning-materials/question-bank.md
  - docs/test-cases/overview.md
Business rule IDs:
  - EXM-BR-001: Exam là bài kiểm tra gắn với bài học/chương trình/khóa học.
  - EXM-BR-002: Exam dùng câu hỏi để học sinh làm bài và hệ thống/giáo viên chấm điểm.
  - EXM-BR-003: Khi quản lý trong chương trình học, exam là dữ liệu gốc dùng để tái sử dụng.
  - EXM-BR-004: Khi có course_id, exam thuộc bối cảnh khóa học cụ thể và có thể được giao cho học sinh.

## 1. Khái niệm exam

Exam là thành phần bài học dùng để tổ chức kiểm tra kết quả học tập.

Exam thường có tính đánh giá rõ hơn homework và có thể gắn với:
- Thời gian làm bài
- Điểm tối đa
- Hạn nộp
- Trạng thái giao bài

## 2. Quan hệ của exam với các đối tượng khác

### 2.1. Quan hệ với bài học

Mỗi exam thuộc một bài học.

Exam là một thành phần bài học và được dùng để đánh giá kết quả học tập trong phạm vi bài học đó.

### 2.2. Quan hệ với chương trình học

Exam có thể là nội dung gốc của bài học trong chương trình học.

Khi ở phạm vi chương trình học, exam là thành phần chuẩn thuộc cấu trúc học tập.

### 2.3. Quan hệ với khóa học

Khi có `course_id`, exam có thể được thêm vào bài học để phục vụ nhu cầu vận hành của khóa học.

Exam trong khóa học thường gắn với:
- Học sinh cụ thể
- Trạng thái giao bài
- Kết quả làm bài theo khóa học

### 2.4. Quan hệ với câu hỏi

Exam có thể chứa danh sách câu hỏi được liên kết để làm nội dung kiểm tra.

Các câu hỏi là nền tảng để:
- Tạo đề kiểm tra
- Tính điểm
- Đánh giá kết quả

## 3. Exam gồm những thông tin gì

Một exam có thể bao gồm các nhóm thông tin sau:

### 3.1. Thông tin định danh

- Mã exam
- Tên exam
- Mô tả exam

### 3.2. Thông tin tổ chức

- Bài học
- Trạng thái
- Trạng thái giao bài nếu có

### 3.3. Thông tin kiểm tra

- Thời gian làm bài
- Điểm tối đa
- Hạn nộp
- Tổng số câu hỏi

### 3.4. Thông tin trình bày

- Ảnh đại diện

### 3.5. Thông tin vận hành

- Thời điểm giao bài nếu có
- Trạng thái hoàn thành nếu có
- Dữ liệu chấm điểm

## 4. Vai trò của exam trong học tập

Exam là công cụ đánh giá kết quả học tập chính thức hơn trong phạm vi bài học.

Exam giúp:
- Đo lường mức độ tiếp thu kiến thức
- Tạo đầu ra kiểm tra có cấu trúc
- Tính điểm và tỷ lệ hoàn thành
- Hỗ trợ giáo viên theo dõi kết quả học tập

## 5. CRUD exam

### 5.1. Tạo exam

Cho phép tạo exam mới trong bài học.

Thông tin thường cần khai báo:
- Tên exam
- Mô tả
- Bài học
- Trạng thái
- Thời gian làm bài
- Điểm tối đa
- Ảnh đại diện nếu có

### 5.2. Xem danh sách exam

Cho phép xem danh sách exam theo:
- Bài học
- Trạng thái
- Từ khóa
- Phân trang

### 5.3. Xem chi tiết exam

Cho phép xem chi tiết exam, bao gồm:
- Thông tin chung
- Thời gian làm bài
- Điểm tối đa
- Hạn nộp
- Câu hỏi liên kết nếu có

### 5.4. Cập nhật exam

Cho phép cập nhật:
- Tên exam
- Mô tả
- Trạng thái
- Thời gian làm bài
- Điểm tối đa
- Ảnh đại diện
- Hạn nộp

### 5.5. Xóa exam

Cho phép xóa exam khỏi bài học.

Khi xóa exam, cần xem xét ảnh hưởng đến:
- Câu hỏi đã liên kết
- Kết quả làm bài
- Dữ liệu chấm điểm

## 6. Quy tắc quản lý exam trong chương trình học

Trong phạm vi chương trình học:
- Được phép tạo exam
- Được phép sửa exam
- Được phép xóa exam

Exam ở cấp chương trình là nội dung gốc của bài học.

## 7. Quy tắc quản lý exam khi có course_id

Khi thao tác trong bối cảnh có `course_id`:
- Được phép thêm exam vào bài học
- Không làm thay đổi nội dung gốc đã có trong chương trình
- Không xóa nội dung gốc đã có trong chương trình

Điều này giúp phân biệt:
- Nội dung kiểm tra chuẩn của chương trình
- Nội dung kiểm tra được bổ sung riêng cho khóa học

## 8. Giao exam trong khóa học

Exam có thể được giao trong phạm vi khóa học.

Khi exam được giao, hệ thống có thể ghi nhận:
- Trạng thái đã giao
- Khóa học đang triển khai
- Bài học liên quan
- Dữ liệu làm bài của học sinh

## 9. Làm bài và chấm điểm exam

Exam hỗ trợ quy trình làm bài và chấm điểm theo nhiều dạng câu hỏi.

Kết quả có thể bao gồm:
- Điểm tổng
- Tỷ lệ đúng
- Thời gian làm bài
- Dữ liệu chi tiết theo từng dạng câu hỏi

## 10. Các tình huống nghiệp vụ chính

### 10.1. Tạo exam trong bài học

Người dùng tạo exam để bổ sung hoạt động kiểm tra cho bài học.

### 10.2. Cập nhật exam trong chương trình học

Người dùng chỉnh sửa exam gốc trong phạm vi chương trình học để cập nhật nội dung chuẩn.

### 10.3. Thêm exam trong bối cảnh khóa học

Khi bài học được mở với `course_id`, người dùng được thêm exam để phục vụ riêng cho khóa học.

### 10.4. Giao exam cho học sinh

Giáo viên hoặc hệ thống có thể giao exam cho học sinh trong khóa học.

### 10.5. Chấm điểm exam

Exam được dùng để chấm điểm và đánh giá kết quả học tập của học sinh theo bài học.

## Edge cases và điểm cần xác nhận

- Cần xác nhận backend có chặn sửa/xóa exam đã được giao hoặc đã có lượt làm hay không.
- Cần xác nhận rule thời gian làm bài, hạn nộp và xử lý khi học sinh thoát giữa chừng.
- Cần xác nhận exam trong chương trình học và exam theo course_id có được đồng bộ hai chiều hay chỉ sao chép một lần.
- Cần xác nhận rule chấm điểm cho câu hỏi tự luận/nói và các câu hỏi cần chấm thủ công.
