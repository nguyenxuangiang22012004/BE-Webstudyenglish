# Tài Liệu BA Chi Tiết: Bài Học

Status: reviewed
Owner: BA/DEV
Last reviewed: 2026-09-16
Related:
  - docs/api/learning-materials/lesson.md
  - docs/security/resources/lessons.md
  - docs/requirements/learning-materials/lecture.md
  - docs/requirements/learning-materials/video-interactive.md
  - docs/test-cases/overview.md
Business rule IDs:
  - LES-BR-001: Lesson là đơn vị học tập chứa lecture, homework, exam, assessment, vocabulary và video interactive nếu có.
  - LES-BR-002: Thành phần bài học trong chương trình học là dữ liệu gốc dùng để tái sử dụng.
  - LES-BR-003: Khi có course_id, thành phần bài học thuộc bối cảnh khóa học cụ thể.
  - LES-BR-004: Lesson liên kết với chương/chương trình/khóa học và lịch học nếu có.

Review note: Rule `course_id` đã được xác nhận. Trong course context có thể thêm nội dung bổ sung, nhưng không sửa/xóa nội dung gốc của program; cập nhật program sẽ đồng bộ sang course theo rule đã xác nhận ở `program.md` và `course.md`.

## 1. Khái niệm bài học

Bài học là đơn vị học tập trực tiếp thuộc chương học.

Trong cấu trúc học tập, bài học là nơi người học thực sự tiếp cận nội dung, thực hiện hoạt động học tập và tham gia các hình thức luyện tập, kiểm tra hoặc đánh giá.

Bài học là lớp trung tâm để tập hợp các **thành phần bài học**.

## 2. Quan hệ của bài học với các đối tượng khác

### 2.1. Quan hệ với chương học

Một bài học thuộc một chương học.

Chương học là đơn vị tổ chức bài học theo từng phần nội dung trong chương trình học.

### 2.2. Quan hệ với chương trình học

Bài học thuộc cấu trúc của chương trình học thông qua chương học.

Điều này có nghĩa:
- Bài học là một phần của cấu trúc chương trình
- Bài học là nội dung gốc của chương trình học
- Các thành phần bài học gốc được quản lý trong phạm vi chương trình học

### 2.3. Quan hệ với khóa học

Bài học có thể được triển khai trong khóa học khi khóa học sử dụng chương trình học chứa bài học đó.

Khi bài học được đưa vào khóa học:
- Bài học có thể được xếp lịch học
- Bài học có thể được theo dõi trạng thái hoàn thành
- Bài học có thể được bổ sung thêm thành phần bài học trong bối cảnh vận hành của khóa học

### 2.4. Quan hệ với các thành phần bài học

Mỗi bài học có thể chứa một hoặc nhiều thành phần bài học.

Các thành phần bài học hiện diện trong hệ thống gồm:
- Homework
- Exam
- VSTEP
- Lecture
- Video Interactive
- Vocabulary
- Assessment

## 3. Bài học gồm những thông tin gì

Một bài học có thể bao gồm các nhóm thông tin sau:

### 3.1. Thông tin định danh

- Mã bài học
- Tên bài học
- Mô tả bài học

### 3.2. Thông tin tổ chức

- Chương học
- Chương trình học
- Thứ tự hiển thị trong chương học
- Trạng thái hoạt động

### 3.3. Thông tin học thuật

- Chủ đề
- Kỹ năng
- Thẻ phân loại nếu có
- Các bài học phụ thuộc nếu có

### 3.4. Thông tin vận hành

- Tác giả
- Lịch học nếu bài học được triển khai trong khóa học
- Trạng thái hoàn thành nếu có
- Số lượt xem hoặc dữ liệu theo dõi nếu có

### 3.5. Thông tin thành phần bài học

- Danh sách homework
- Danh sách exam
- Danh sách vstep
- Danh sách lecture
- Danh sách video interactive
- Danh sách vocabulary
- Danh sách assessment

## 4. Vai trò của bài học trong hệ thống học tập

Bài học là đơn vị triển khai nội dung học tập trực tiếp.

Vai trò của bài học gồm:
- Là nơi quy tụ nội dung học tập của một phần kiến thức cụ thể
- Là nơi liên kết các thành phần bài học
- Là đơn vị có thể được xếp lịch trong khóa học
- Là nơi phát sinh hoạt động học tập của học sinh
- Là nơi giáo viên theo dõi tiến độ và kết quả học tập

## 5. CRUD bài học

### 5.1. Tạo bài học

Cho phép tạo mới bài học trong phạm vi chương học.

Khi tạo bài học, thường cần xác định:
- Tên bài học
- Mô tả bài học
- Chương học chứa bài học
- Trạng thái
- Các thông tin học thuật đi kèm nếu có

### 5.2. Xem danh sách bài học

Cho phép xem danh sách bài học theo:
- Chương học
- Chương trình học
- Khóa học nếu đang triển khai trong khóa học
- Trạng thái hoặc các tiêu chí lọc liên quan

### 5.3. Xem chi tiết bài học

Cho phép xem toàn bộ thông tin của bài học, bao gồm:
- Thông tin chung
- Chương học và chương trình học liên quan
- Thành phần bài học đang có
- Lịch học nếu có
- Trạng thái hoàn thành nếu có

### 5.4. Cập nhật bài học

Cho phép cập nhật:
- Tên bài học
- Mô tả bài học
- Trạng thái
- Thông tin học thuật liên quan
- Quan hệ với các thành phần bài học trong phạm vi cho phép

### 5.5. Xóa bài học

Cho phép xóa bài học khỏi chương học.

Khi xóa bài học, cần xem xét ảnh hưởng đến:
- Cấu trúc chương học
- Trình tự học tập
- Các thành phần bài học đã gắn
- Lịch học của khóa học nếu bài học đã được triển khai

## 6. Thành phần bài học

Các thành phần bài học là các đối tượng nội dung hoặc hoạt động học tập được gắn vào bài học.

### 6.1. Homework

Là thành phần phục vụ giao bài và luyện tập.

### 6.2. Exam

Là thành phần phục vụ kiểm tra.

### 6.3. VSTEP

Là thành phần phục vụ nội dung học tập hoặc đánh giá theo định dạng VSTEP.

### 6.4. Lecture

Là thành phần phục vụ nội dung giảng dạy.

### 6.5. Video Interactive

Là thành phần nội dung học theo dạng video tương tác.

### 6.6. Vocabulary

Là thành phần học từ vựng hoặc flashcard.

### 6.7. Assessment

Là thành phần phục vụ đánh giá theo tiêu chí hoặc hình thức đánh giá mở rộng.

## 7. Quy tắc quản lý thành phần bài học trong chương trình học

Trong phạm vi chương trình học, các thành phần bài học được xem là nội dung gốc của bài học.

Trong bối cảnh này:
- Được phép tạo thành phần bài học
- Được phép sửa thành phần bài học
- Được phép xóa thành phần bài học

Điều này có nghĩa chương trình học là nơi quản lý nội dung chuẩn của bài học.

## 8. Quy tắc quản lý thành phần bài học khi có course_id

Khi thao tác trong bối cảnh có `course_id`, bài học được hiểu là đang được sử dụng trong một khóa học cụ thể.

Trong bối cảnh này:
- Được phép thêm các thành phần có trong bài học
- Không được chỉnh sửa các nội dung có sẵn trong chương trình
- Không được xóa các nội dung có sẵn trong chương trình

Ý nghĩa của quy tắc này:
- Chương trình học vẫn là nguồn nội dung gốc
- Khóa học chỉ được phép bổ sung thêm nội dung cho bài học khi cần vận hành thực tế
- Nội dung chuẩn của chương trình không bị thay đổi bởi thao tác trong phạm vi khóa học

## 9. Phân biệt nội dung gốc và nội dung bổ sung trong khóa học

### 9.1. Nội dung gốc của bài học

Nội dung gốc là các thành phần bài học được tạo trong phạm vi chương trình học.

Nhóm nội dung này:
- Thuộc cấu trúc chuẩn của chương trình
- Có thể được tạo, sửa, xóa trong phạm vi chương trình học
- Là nền tảng nội dung chung cho các khóa học sử dụng chương trình đó

### 9.2. Nội dung bổ sung trong khóa học

Nội dung bổ sung là các thành phần bài học được thêm trong bối cảnh có `course_id`.

Nhóm nội dung này:
- Phát sinh trong phạm vi khóa học cụ thể
- Dùng để phục vụ nhu cầu vận hành thực tế của khóa học
- Không thay thế hay ghi đè nội dung gốc của chương trình

## 10. Tình huống nghiệp vụ chính

### 10.1. Tạo bài học trong chương trình học

Người dùng tạo bài học mới trong một chương học để mở rộng cấu trúc của chương trình.

### 10.2. Cập nhật thông tin bài học

Người dùng chỉnh sửa thông tin mô tả, trạng thái hoặc cấu trúc liên quan của bài học.

### 10.3. Tạo thành phần bài học trong chương trình học

Người dùng thêm homework, exam, vstep, lecture, video interactive, vocabulary hoặc assessment vào bài học trong phạm vi chương trình học.

### 10.4. Sửa hoặc xóa thành phần bài học trong chương trình học

Người dùng cập nhật hoặc loại bỏ các thành phần bài học gốc của chương trình khi cần thay đổi nội dung chuẩn.

### 10.5. Thêm thành phần bài học trong bối cảnh khóa học

Khi bài học được mở trong bối cảnh có `course_id`, người dùng được thêm các thành phần có trong bài học để phục vụ vận hành khóa học.

### 10.6. Bảo toàn nội dung gốc của chương trình

Khi thao tác trong bối cảnh khóa học, các thành phần có sẵn của chương trình không được sửa hoặc xóa.

## 11. Ý nghĩa vận hành của bài học

Trong toàn bộ hệ thống, bài học là điểm giao nhau giữa:
- Cấu trúc học thuật của chương trình
- Vận hành học tập trong khóa học
- Nội dung giảng dạy
- Hoạt động luyện tập và đánh giá

Nhờ đó, bài học vừa là đơn vị nội dung, vừa là đơn vị vận hành học tập trong thực tế.

## Edge cases và ghi chú kiểm thử

### Đã xác nhận

- Trong bối cảnh có `course_id`, người dùng được thêm nội dung bổ sung cho bài học trong khóa học.
- Trong bối cảnh có `course_id`, không sửa/xóa nội dung gốc có sẵn từ chương trình học.
- Cập nhật học liệu của program sẽ đồng bộ sang course theo rule đã xác nhận ở tài liệu program/course.

### Ghi chú kiểm thử

- Khi test xóa lesson đã có lịch học, bài tập, bài kiểm tra hoặc kết quả học tập, cần ghi nhận backend cho phép hay trả lỗi.
- Khi test lesson có nhiều video interactive hoặc nhiều học liệu cùng loại, cần ghi nhận UI/API hiển thị và sắp xếp dữ liệu như thế nào.
- Khi API trả thiếu một phần học liệu, cần ghi nhận trạng thái hiển thị thực tế của lesson.
