# Tài Liệu BA Chi Tiết: Question Bank

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-06-04
Related:
  - docs/api/learning-materials/question.md
  - docs/api/learning-materials/question-attribute.md
  - docs/api/learning-materials/source-question.md
  - docs/security/resources/questions.md
  - docs/security/resources/question-attributes.md
  - docs/test-cases/overview.md
Business rule IDs:
  - QBK-BR-001: Question bank lưu câu hỏi theo loại, thuộc tính, metadata và đáp án.
  - QBK-BR-002: Câu hỏi có thể tái sử dụng cho homework, exam, assessment và video interactive.
  - QBK-BR-003: Khi quản lý trong chương trình học, question bank là nguồn câu hỏi gốc.
  - QBK-BR-004: Khi có course_id, câu hỏi thuộc bối cảnh khóa học cụ thể.

## 1. Khái niệm question bank

Question bank là ngân hàng câu hỏi dùng để quản lý, lưu trữ và tái sử dụng câu hỏi trong hệ thống học tập.

Question bank giúp tách câu hỏi khỏi từng bài kiểm tra cụ thể, nhờ đó một câu hỏi có thể được dùng lại trong nhiều ngữ cảnh khác nhau như:
- Homework
- Exam
- Luyện tập trong bài học
- Đề kiểm tra được tạo tự động

Question bank không chỉ là danh sách câu hỏi, mà còn là nơi quản lý metadata học thuật, đáp án, lời giải, cấu hình chấm điểm và quan hệ của câu hỏi với nội dung học tập.

## 2. Quan hệ của question bank với các đối tượng khác

### 2.1. Quan hệ với bài học

Câu hỏi trong question bank có thể được gắn với một hoặc nhiều bài học.

Việc gắn câu hỏi với bài học giúp:
- Xác định phạm vi kiến thức của câu hỏi
- Tìm kiếm câu hỏi theo bài học
- Tái sử dụng câu hỏi khi tạo homework hoặc exam trong bài học

### 2.2. Quan hệ với chương trình học

Question bank có thể thuộc phạm vi chương trình học.

Trong phạm vi chương trình học, câu hỏi được xem là nội dung gốc phục vụ cho cấu trúc học tập chuẩn.

### 2.3. Quan hệ với khóa học

Khi có `course_id`, câu hỏi có thể được sử dụng trong bối cảnh khóa học cụ thể.

Trong bối cảnh này, câu hỏi có thể được dùng để:
- Giao bài cho học sinh
- Tạo đề kiểm tra cho một khóa học
- Theo dõi kết quả làm bài của học sinh
- Bổ sung câu hỏi riêng cho nhu cầu vận hành khóa học

### 2.4. Quan hệ với homework và exam

Câu hỏi là đơn vị nội dung nền tảng để tạo ra các loại bài tập như homework và exam trong hệ thống. Khi người dùng gắn câu hỏi vào homework hoặc exam, hệ thống sẽ tạo một bản sao của câu hỏi trong bài tập đó.

Vì câu hỏi trong homework hoặc exam là bản sao riêng, nên nếu sau này người dùng sửa câu hỏi gốc trong ngân hàng câu hỏi, nội dung câu hỏi đã nằm trong bài tập **không bị ảnh hưởng**. Cách làm này giúp bài tập giữ nguyên nội dung tại thời điểm được tạo và không làm thay đổi câu hỏi gốc của hệ thống.

## 3. Question bank gồm những thông tin gì

Một câu hỏi trong question bank có thể bao gồm các nhóm thông tin sau:

### 3.1. Thông tin định danh

- Mã câu hỏi
- Tên hoặc tiêu đề câu hỏi
- Nội dung câu hỏi
- Mô tả nội bộ nếu có

### 3.2. Thông tin phân loại

- Loại câu hỏi
- Kỹ năng
- Chủ đề
- Bài học
- Chương trình học
- Môn học nếu có
- Cấp độ
- Độ khó
- Tag phân loại

### 3.3. Thông tin nội dung

- Nội dung câu hỏi
- Danh sách lựa chọn nếu có
- Đáp án đúng
- Đáp án mẫu nếu là câu hỏi tự luận
- Lời giải hoặc giải thích
- Gợi ý nếu có
- Media đính kèm như ảnh, audio, video hoặc file

### 3.4. Thông tin chấm điểm

- Điểm mặc định
- Cách tính điểm
- Cho phép chấm tự động hay không
- Rubric hoặc tiêu chí chấm nếu có

### 3.5. Thông tin vận hành

- Trạng thái câu hỏi
- Người tạo
- Người cập nhật
- Thời điểm tạo
- Thời điểm cập nhật
- Lịch sử sử dụng nếu có
- Số lần được dùng trong homework hoặc exam nếu có

## 4. Các loại câu hỏi

Question bank có thể hỗ trợ nhiều loại câu hỏi.

Các loại câu hỏi phổ biến gồm:
- Trắc nghiệm
- Điền từ
- Ghép cặp
- Sắp xếp thứ tự
- Nói
- Viết
- Gán nhãn
- Phân loại
- Kéo thả

Mỗi loại câu hỏi có cấu trúc dữ liệu và quy tắc chấm điểm khác nhau.

## 5. Vai trò của question bank trong học tập

Question bank là nguồn nội dung câu hỏi dùng chung cho các hoạt động luyện tập và đánh giá.

Question bank giúp:
- Chuẩn hóa câu hỏi theo chương trình học
- Tái sử dụng câu hỏi giữa nhiều bài học hoặc khóa học
- Giảm thời gian tạo homework và exam
- Hỗ trợ tạo đề kiểm tra nhanh hơn
- Hỗ trợ phân tích chất lượng câu hỏi nếu có dữ liệu làm bài
- Giữ nội dung câu hỏi gốc ổn định khi triển khai nhiều khóa học

## 6. CRUD question bank

### 6.1. Tạo câu hỏi

Cho phép tạo câu hỏi mới trong question bank.

Thông tin thường cần khai báo:
- Nội dung câu hỏi
- Loại câu hỏi
- Đáp án
- Lời giải
- Điểm mặc định
- Kỹ năng
- Chủ đề
- Độ khó
- Bài học hoặc chương trình học liên quan
- Media đính kèm nếu có

### 6.2. Xem danh sách câu hỏi

Cho phép xem danh sách câu hỏi theo:
- Từ khóa
- Loại câu hỏi
- Kỹ năng
- Chủ đề
- Độ khó
- Bài học
- Chương trình học
- Trạng thái
- Tag
- Phân trang

### 6.3. Xem chi tiết câu hỏi

Cho phép xem toàn bộ thông tin của câu hỏi, bao gồm:
- Nội dung câu hỏi
- Đáp án
- Lời giải
- Metadata phân loại
- Cấu hình chấm điểm
- Media đính kèm
- Các bài kiểm tra hoặc bài tập đang sử dụng câu hỏi nếu có

### 6.4. Cập nhật câu hỏi

Cho phép cập nhật:
- Nội dung câu hỏi
- Loại câu hỏi nếu chưa phát sinh ràng buộc sử dụng
- Đáp án
- Lời giải
- Điểm mặc định
- Metadata phân loại
- Trạng thái
- Media đính kèm

Khi câu hỏi đã được sử dụng trong homework hoặc exam, cần xem xét việc cập nhật có ảnh hưởng tới kết quả học sinh hay không.

### 6.5. Xóa câu hỏi

Cho phép xóa hoặc ngưng sử dụng câu hỏi.

Khi xóa câu hỏi, cần xem xét ảnh hưởng đến:
- Homework đang dùng câu hỏi
- Exam đang dùng câu hỏi
- Kết quả làm bài của học sinh
- Báo cáo hoặc dữ liệu thống kê

Trong trường hợp câu hỏi đã phát sinh dữ liệu làm bài, nên ưu tiên chuyển trạng thái ngưng sử dụng thay vì xóa cứng.

## 7. Import và export câu hỏi

Question bank có thể hỗ trợ import câu hỏi từ file để tạo dữ liệu hàng loạt.

Import giúp:
- Tạo nhanh nhiều câu hỏi
- Chuyển dữ liệu câu hỏi từ nguồn bên ngoài vào hệ thống
- Chuẩn hóa kho câu hỏi theo mẫu dữ liệu thống nhất

Export giúp:
- Xuất danh sách câu hỏi để rà soát
- Sao lưu dữ liệu câu hỏi
- Chia sẻ bộ câu hỏi cho bộ phận học thuật

Khi import, hệ thống cần kiểm tra:
- Định dạng file
- Loại câu hỏi
- Cấu trúc đáp án
- Dữ liệu bắt buộc
- Câu hỏi trùng lặp nếu có

## 8. Tái sử dụng câu hỏi trong homework và exam

Câu hỏi trong question bank có thể được tái sử dụng theo nhiều cách:
- Chọn trực tiếp từng câu hỏi
- Chọn theo bộ lọc
- Random theo số lượng
- Random theo độ khó
- Random theo kỹ năng hoặc chủ đề

Khi câu hỏi được đưa vào homework hoặc exam, hệ thống cần xác định câu hỏi được tham chiếu trực tiếp hay được sao chép thành bản riêng.

Nếu tham chiếu trực tiếp, thay đổi ở câu hỏi gốc có thể ảnh hưởng tới nơi đang sử dụng.

Nếu sao chép thành bản riêng, homework hoặc exam có thể giữ nội dung ổn định tại thời điểm tạo.

## 9. Quy tắc quản lý question bank trong chương trình học

Trong phạm vi chương trình học:
- Được phép tạo câu hỏi gốc
- Được phép sửa câu hỏi gốc
- Được phép xóa hoặc ngưng sử dụng câu hỏi gốc
- Được phép gắn câu hỏi với bài học, kỹ năng

Câu hỏi ở cấp chương trình học là nguồn nội dung chuẩn để các khóa học sử dụng.

## 10. Quy tắc quản lý question bank khi có course_id

Khi thao tác trong bối cảnh có `course_id`:
- Được phép sử dụng câu hỏi gốc trong homework hoặc exam của khóa học
- Được phép bổ sung câu hỏi riêng cho khóa học nếu cần
- Không được làm thay đổi câu hỏi gốc của chương trình học nếu không có quyền phù hợp
- Không được xóa câu hỏi gốc đã thuộc chương trình học

Quy tắc này giúp phân biệt:
- Câu hỏi chuẩn thuộc chương trình học
- Câu hỏi bổ sung phục vụ riêng cho khóa học
- Dữ liệu làm bài phát sinh từ học sinh trong khóa học

## 11. Làm bài và chấm điểm từ question bank

Khi câu hỏi được sử dụng trong homework hoặc exam, hệ thống có thể ghi nhận kết quả làm bài theo từng câu hỏi.

Kết quả có thể bao gồm:
- Đáp án học sinh đã chọn hoặc đã nhập
- Trạng thái đúng sai
- Điểm đạt được
- Thời gian trả lời
- Số lần làm nếu có
- Nhận xét hoặc điểm chấm tay nếu có

Câu hỏi có đáp án xác định có thể được chấm tự động.

Câu hỏi tự luận hoặc câu hỏi mở thường cần giáo viên chấm tay hoặc chấm theo rubric.

## 12. Chất lượng và thống kê câu hỏi

Question bank có thể hỗ trợ dữ liệu thống kê để đánh giá chất lượng câu hỏi.

Các chỉ số có thể gồm:
- Số lần câu hỏi được sử dụng
- Tỷ lệ trả lời đúng
- Tỷ lệ bỏ qua
- Thời gian trung bình để trả lời
- Mức độ phân hóa nếu có
- Phản hồi từ giáo viên hoặc học sinh nếu có

Dữ liệu này giúp bộ phận học thuật rà soát, điều chỉnh hoặc loại bỏ câu hỏi chưa phù hợp.

## 13. Các tình huống nghiệp vụ chính

### 13.1. Tạo câu hỏi trong ngân hàng câu hỏi

Người dùng tạo câu hỏi mới, khai báo loại câu hỏi, nội dung, đáp án, lời giải và metadata học thuật.

### 13.2. Tìm kiếm câu hỏi để tạo homework

Giáo viên lọc câu hỏi theo bài học, kỹ năng, độ khó hoặc tag để đưa vào homework.

### 13.3. Tạo exam từ question bank

Giáo viên chọn câu hỏi thủ công hoặc random câu hỏi theo điều kiện để tạo đề kiểm tra.

### 13.4. Import câu hỏi hàng loạt

Người dùng tải file câu hỏi lên hệ thống, hệ thống kiểm tra dữ liệu và tạo câu hỏi trong question bank.

### 13.5. Cập nhật câu hỏi gốc

Người dùng chỉnh sửa câu hỏi trong chương trình học để cập nhật nội dung chuẩn.

### 13.6. Bổ sung câu hỏi trong khóa học

Khi mở bài học với `course_id`, giáo viên có thể bổ sung câu hỏi riêng để phục vụ nhu cầu vận hành của khóa học.

### 13.7. Ngưng sử dụng câu hỏi

Khi câu hỏi không còn phù hợp hoặc đã phát sinh nhiều lỗi, người dùng chuyển câu hỏi sang trạng thái ngưng sử dụng để tránh ảnh hưởng dữ liệu cũ.
