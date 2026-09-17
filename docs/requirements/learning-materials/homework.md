# Tài Liệu BA Chi Tiết: Homework

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-06-04
Related:
  - docs/api/learning-materials/homework.md
  - docs/security/resources/homeworks.md
  - docs/requirements/learning-materials/question-bank.md
  - docs/test-cases/overview.md
Business rule IDs:
  - HWK-BR-001: Homework là bài tập về nhà gắn với bài học/chương trình/khóa học.
  - HWK-BR-002: Homework dùng câu hỏi để học sinh làm, lưu tiến độ, nộp và nhận kết quả.
  - HWK-BR-003: Khi quản lý trong chương trình học, homework là dữ liệu gốc dùng để tái sử dụng.
  - HWK-BR-004: Khi có course_id, homework thuộc bối cảnh khóa học cụ thể và có thể được giao cho học sinh.

## 1. Khái niệm homework

Homework là thành phần bài học dùng để giao bài luyện tập hoặc bài làm về nhà cho học sinh.

Homework gắn với bài học và được sử dụng để:
- Giao nhiệm vụ học tập
- Tổ chức phần luyện tập
- Theo dõi tiến độ làm bài
- Chấm điểm và ghi nhận kết quả

## 2. Quan hệ của homework với các đối tượng khác

### 2.1. Quan hệ với bài học

Mỗi homework thuộc một bài học.

Homework là một trong các thành phần bài học và được quản lý trong cấu trúc của bài học.

### 2.2. Quan hệ với chương trình học

Homework có thể là nội dung gốc được tạo trong phạm vi chương trình học.

Khi ở phạm vi chương trình học, homework là thành phần chuẩn của bài học.

### 2.3. Quan hệ với khóa học

Khi bài học được mở trong bối cảnh có `course_id`, homework có thể được thêm vào để phục vụ vận hành của khóa học.

Homework trong khóa học được dùng để:
- Giao bài cho học sinh trong khóa cụ thể
- Theo dõi trạng thái làm bài
- Ghi nhận kết quả theo bối cảnh khóa học

### 2.4. Quan hệ với câu hỏi

Homework có thể chứa danh sách câu hỏi.

Các câu hỏi là nền tảng để:
- Hiển thị nội dung làm bài
- Lưu câu trả lời
- Tính điểm
- Xác định mức độ hoàn thành

## 3. Homework gồm những thông tin gì

Một homework có thể bao gồm các nhóm thông tin sau:

### 3.1. Thông tin định danh

- Mã homework
- Tên homework
- Mô tả homework

### 3.2. Thông tin tổ chức

- Bài học
- Trạng thái
- Loại biểu mẫu câu hỏi nếu có

### 3.3. Thông tin học tập

- Điểm tối đa
- Tổng số câu hỏi
- Tổng thời gian nếu có
- Hạn nộp nếu có

### 3.4. Thông tin trình bày

- Ảnh đại diện
- Tệp đính kèm hoặc tài nguyên kèm theo nếu có

### 3.5. Thông tin vận hành

- Trạng thái giao bài
- Thời điểm giao
- Trạng thái hoàn thành
- Số câu đã làm
- Câu gần nhất đã làm

## 4. Vai trò của homework trong học tập

Homework là công cụ chính để triển khai luyện tập và giao bài sau phần học.

Homework giúp:
- Củng cố kiến thức sau bài học
- Tạo đầu việc cụ thể cho học sinh
- Theo dõi tiến độ làm bài
- Tính điểm và đánh giá mức độ hoàn thành

## 5. CRUD homework

### 5.1. Tạo homework

Cho phép tạo homework mới trong bài học.

Thông tin thường cần khai báo:
- Tên homework
- Mô tả
- Bài học
- Trạng thái
- Điểm tối đa
- Ảnh đại diện nếu có

### 5.2. Xem danh sách homework

Cho phép xem danh sách homework theo:
- Bài học
- Trạng thái
- Từ khóa
- Phân trang

### 5.3. Xem chi tiết homework

Cho phép xem đầy đủ thông tin của homework, bao gồm:
- Thông tin chung
- Danh sách câu hỏi nếu có
- Tiến độ làm bài nếu có
- Hạn nộp và trạng thái giao bài

### 5.4. Cập nhật homework

Cho phép cập nhật:
- Tên homework
- Mô tả
- Trạng thái
- Điểm tối đa
- Ảnh đại diện
- Hạn nộp hoặc cấu hình liên quan

### 5.5. Xóa homework

Cho phép xóa homework khỏi bài học.

Khi xóa homework, cần xem xét ảnh hưởng đến:
- Câu hỏi đã liên kết
- Dữ liệu làm bài
- Tiến độ học tập của học sinh

## 6. Quy tắc quản lý homework trong chương trình học

Trong phạm vi chương trình học:
- Được phép tạo homework
- Được phép sửa homework
- Được phép xóa homework

Trong bối cảnh này, homework là một phần của nội dung gốc của bài học.

## 7. Quy tắc quản lý homework khi có course_id

Khi thao tác trong bối cảnh có `course_id`:
- Được phép thêm homework vào bài học
- Không làm thay đổi nội dung gốc đã có trong chương trình
- Không xóa nội dung gốc đã có trong chương trình

Ý nghĩa của quy tắc này:
- Chương trình học vẫn là nguồn nội dung chuẩn
- Khóa học chỉ bổ sung thêm homework để phục vụ vận hành thực tế

## 8. Giao homework trong khóa học

Homework có thể được sử dụng trong bối cảnh khóa học để giao cho học sinh.

Khi homework được giao trong khóa học, hệ thống có thể ghi nhận:
- Trạng thái đã giao hoặc chưa giao
- Thời điểm giao bài
- Trạng thái nộp bài
- Tiến độ làm bài của từng học sinh

## 9. Thực hiện homework

Trong quá trình làm homework, học sinh có thể:
- Trả lời câu hỏi
- Lưu tiến độ
- Bỏ qua câu hỏi
- Nộp bài

Hệ thống có thể theo dõi:
- Số câu đã hoàn thành
- Số câu bỏ qua
- Câu gần nhất đã làm
- Tỷ lệ hoàn thành

## 10. Chấm điểm homework

Homework hỗ trợ chấm điểm theo nhiều dạng câu hỏi.

Kết quả chấm có thể bao gồm:
- Điểm số
- Tỷ lệ đúng
- Trạng thái đúng hoặc sai
- Dữ liệu chi tiết theo từng câu
- Trạng thái có cần chấm tay hay không

## 11. Các tình huống nghiệp vụ chính

### 11.1. Tạo homework trong bài học

Người dùng tạo homework mới để bổ sung hoạt động luyện tập cho bài học.

### 11.2. Cập nhật nội dung homework

Người dùng chỉnh sửa homework gốc trong chương trình học khi cần điều chỉnh nội dung chuẩn.

### 11.3. Thêm homework trong bối cảnh khóa học

Khi bài học được mở với `course_id`, người dùng được thêm homework để phục vụ vận hành của khóa học.

### 11.4. Giao homework cho học sinh

Homework được sử dụng như một hoạt động học tập có thể giao cho học sinh trong khóa học.

### 11.5. Theo dõi và chấm điểm homework

Giáo viên hoặc hệ thống theo dõi tiến độ làm bài, kết quả nộp bài và dữ liệu chấm điểm của homework.

## Edge cases và điểm cần xác nhận

- Cần xác nhận backend có chặn sửa/xóa homework đã giao hoặc đã có lượt nộp hay không.
- Cần xác nhận rule lưu nháp, bỏ qua câu hỏi, nộp muộn và làm lại bài.
- Cần xác nhận homework trong chương trình học và homework theo course_id có được đồng bộ hai chiều hay chỉ sao chép một lần.
- Cần xác nhận cách xử lý khi câu hỏi trong homework bị sửa sau khi học sinh đã làm bài.
