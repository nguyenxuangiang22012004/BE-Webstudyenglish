# Tài Liệu BA Chi Tiết: Vocabulary

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-06-04
Related:
  - docs/design/vocabulary/overview.md
  - docs/api/learning-materials/flashcard.md
  - docs/security/resources/lessons.md
  - docs/test-cases/overview.md
Business rule IDs:
  - VOC-BR-001: Vocabulary là bộ từ vựng gắn với lesson, program hoặc course.
  - VOC-BR-002: Vocabulary gồm danh sách mục từ vựng và tài nguyên học tập liên quan.
  - VOC-BR-003: Flashcard/luyện tập vocabulary phụ thuộc setting và dữ liệu kết quả học.
  - VOC-BR-004: Khi có course_id, vocabulary thuộc bối cảnh khóa học cụ thể.

## 1. Khái niệm vocabulary

Vocabulary là thành phần bài học dùng để quản lý và triển khai nội dung học từ vựng.

Vocabulary có thể bao gồm danh sách từ, cụm từ, nghĩa, phiên âm, ví dụ, hình ảnh, audio và các thông tin học thuật liên quan.

Trong hệ thống học tập, vocabulary phục vụ các nhu cầu:
- Học từ mới
- Ôn tập từ vựng
- Luyện ghi nhớ qua flashcard
- Luyện tập theo bài học hoặc chủ đề
- Theo dõi tiến độ học từ vựng của học sinh

## 2. Quan hệ của vocabulary với các đối tượng khác

### 2.1. Quan hệ với bài học

Vocabulary là một thành phần bài học.

Một bài học có thể chứa một hoặc nhiều bộ vocabulary để học sinh tiếp cận nhóm từ vựng liên quan đến nội dung của bài học đó.

### 2.2. Quan hệ với chương trình học

Vocabulary có thể là nội dung gốc được tạo trong phạm vi chương trình học.

Vocabulary ở cấp chương trình học là nguồn từ vựng chuẩn, có thể được tái sử dụng khi chương trình học được triển khai thành nhiều khóa học.

### 2.3. Quan hệ với khóa học

Khi có `course_id`, vocabulary có thể được sử dụng trong bối cảnh một khóa học cụ thể.

Trong bối cảnh khóa học, vocabulary có thể gắn với:
- Trạng thái học từ của từng học sinh
- Kết quả luyện tập
- Nội dung bổ sung riêng cho khóa học

### 2.4. Quan hệ với học sinh

Vocabulary có thể phát sinh dữ liệu học tập theo từng học sinh.

Dữ liệu này có thể gồm:
- Từ đã học
- Từ chưa học
- Từ cần ôn tập
- Kết quả luyện tập
- Số lần ôn
- Mức độ ghi nhớ nếu có

## 3. Vocabulary gồm những thông tin gì

Một vocabulary có thể bao gồm các nhóm thông tin sau:

### 3.1. Thông tin định danh

- Mã vocabulary
- Tên bộ từ vựng
- Mô tả bộ từ vựng

### 3.2. Thông tin tổ chức

- Bài học
- Chương trình học
- Khóa học nếu có
- Thứ tự hiển thị
- Trạng thái

### 3.3. Thông tin học thuật

- Chủ đề
- Cấp độ
- Kỹ năng liên quan
- Môn học nếu có
- Tag phân loại

### 3.4. Thông tin từ vựng

Mỗi mục từ vựng có thể bao gồm:
- Từ hoặc cụm từ
- Loại từ
- Nghĩa tiếng Việt
- Nghĩa tiếng Anh nếu cần
- Phiên âm
- Ví dụ
- Dịch nghĩa ví dụ
- Ghi chú sử dụng
- Từ đồng nghĩa nếu có
- Từ trái nghĩa nếu có

### 3.5. Thông tin tài nguyên

- Audio phát âm
- Hình ảnh minh họa
- Video nếu có
- File đính kèm nếu có

### 3.6. Thông tin vận hành

- Người tạo
- Người cập nhật
- Thời điểm tạo
- Thời điểm cập nhật
- Trạng thái công khai
- Dữ liệu học tập theo học sinh nếu có

## 4. Vai trò của vocabulary trong học tập

Vocabulary giúp tổ chức nội dung từ vựng thành các nhóm học tập có cấu trúc.

Vocabulary giúp:
- Học sinh tiếp cận từ vựng theo bài học
- Giáo viên chuẩn bị nội dung từ vựng thống nhất
- Tăng khả năng ghi nhớ thông qua flashcard và luyện tập
- Liên kết từ vựng với homework, exam hoặc hoạt động học tập khác
- Theo dõi tiến độ học từ của học sinh trong khóa học

## 5. Cấu trúc bộ từ vựng

Một bộ vocabulary có thể chứa nhiều mục từ vựng.

Mỗi mục từ vựng là một đơn vị học tập nhỏ, thường đại diện cho một từ hoặc cụm từ.

Cấu trúc này giúp:
- Quản lý nhóm từ theo bài học hoặc chủ đề
- Sắp xếp thứ tự học
- Bổ sung media cho từng từ
- Tái sử dụng từ vựng trong nhiều hoạt động luyện tập

## 6. CRUD vocabulary

### 6.1. Tạo vocabulary

Cho phép tạo bộ vocabulary mới trong bài học hoặc chương trình học.

Thông tin thường cần khai báo:
- Tên bộ từ vựng
- Mô tả
- Bài học
- Chương trình học
- Chủ đề
- Cấp độ
- Trạng thái
- Danh sách từ vựng

### 6.2. Xem danh sách vocabulary

Cho phép xem danh sách vocabulary theo:
- Bài học
- Chương trình học
- Khóa học nếu có
- Chủ đề
- Cấp độ
- Trạng thái
- Từ khóa
- Phân trang

### 6.3. Xem chi tiết vocabulary

Cho phép xem chi tiết vocabulary, bao gồm:
- Thông tin chung
- Danh sách từ vựng
- Media đính kèm
- Thứ tự hiển thị
- Dữ liệu học tập theo học sinh nếu có

### 6.4. Cập nhật vocabulary

Cho phép cập nhật:
- Tên bộ từ vựng
- Mô tả
- Chủ đề
- Cấp độ
- Trạng thái
- Thứ tự từ vựng
- Danh sách từ vựng
- Audio, hình ảnh hoặc tài nguyên liên quan

### 6.5. Xóa vocabulary

Cho phép xóa vocabulary khỏi bài học hoặc chương trình học.

Khi xóa vocabulary, cần xem xét ảnh hưởng đến:
- Cấu trúc bài học
- Dữ liệu học tập của học sinh
- Homework hoặc exam đang sử dụng từ vựng
- Báo cáo tiến độ nếu có

Nếu vocabulary đã phát sinh dữ liệu học tập, nên cân nhắc ngưng sử dụng thay vì xóa cứng.

## 7. CRUD mục từ vựng

### 7.1. Thêm mục từ vựng

Cho phép thêm từ hoặc cụm từ vào bộ vocabulary.

Thông tin thường cần khai báo:
- Từ hoặc cụm từ
- Nghĩa
- Phiên âm
- Loại từ
- Ví dụ
- Audio
- Hình ảnh
- Ghi chú

### 7.2. Cập nhật mục từ vựng

Cho phép cập nhật nội dung của từng mục từ vựng.

Khi cập nhật, cần xem xét ảnh hưởng nếu mục từ đã được dùng trong homework, exam hoặc dữ liệu luyện tập.

### 7.3. Xóa mục từ vựng

Cho phép xóa mục từ khỏi bộ vocabulary.

Nếu mục từ đã phát sinh dữ liệu học tập, nên xem xét chuyển trạng thái ngưng sử dụng để bảo toàn lịch sử học tập.

### 7.4. Sắp xếp mục từ vựng

Cho phép thay đổi thứ tự hiển thị của các mục từ trong bộ vocabulary.

Thứ tự này có thể ảnh hưởng đến trải nghiệm học tuần tự của học sinh.

## 8. Flashcard và luyện tập vocabulary

Vocabulary có thể được triển khai dưới dạng flashcard.

Flashcard có thể hiển thị:
- Từ hoặc cụm từ
- Nghĩa
- Phiên âm
- Audio phát âm
- Hình ảnh minh họa
- Ví dụ

Các hình thức luyện tập có thể gồm:
- Xem flashcard
- Lật thẻ để xem nghĩa
- Chọn nghĩa đúng
- Nghe và chọn từ đúng
- Điền từ vào chỗ trống
- Ghép từ với nghĩa
- Ôn tập từ đã sai hoặc từ chưa nhớ

## 9. Import và export vocabulary

Vocabulary có thể hỗ trợ import để tạo nhiều mục từ vựng cùng lúc.

Import giúp:
- Tạo nhanh bộ từ vựng
- Chuẩn hóa dữ liệu từ file mẫu
- Chuyển dữ liệu từ nguồn bên ngoài vào hệ thống

Export giúp:
- Xuất danh sách từ vựng để rà soát
- Sao lưu nội dung
- Chia sẻ dữ liệu cho bộ phận học thuật

Khi import, hệ thống cần kiểm tra:
- Định dạng file
- Trường dữ liệu bắt buộc
- Từ trùng lặp
- Định dạng audio hoặc hình ảnh nếu có
- Cấu trúc ví dụ và nghĩa

## 10. Theo dõi trạng thái học vocabulary

Khi vocabulary được triển khai trong khóa học, hệ thống có thể theo dõi trạng thái học của từng học sinh.

Trạng thái có thể gồm:
- Chưa học
- Đang học
- Đã học
- Cần ôn tập
- Đã ghi nhớ

Dữ liệu theo dõi có thể bao gồm:
- Số từ đã học
- Số từ đã nhớ
- Số từ trả lời sai
- Lần học gần nhất
- Kết quả luyện tập theo từng dạng bài

## 11. Quy tắc quản lý vocabulary trong chương trình học

Trong phạm vi chương trình học:
- Được phép tạo vocabulary
- Được phép sửa vocabulary
- Được phép xóa hoặc ngưng sử dụng vocabulary
- Được phép thêm, sửa, xóa mục từ vựng
- Được phép gắn vocabulary với bài học, chủ đề hoặc cấp độ

Vocabulary ở cấp chương trình học là nội dung gốc dùng chung cho các khóa học triển khai từ chương trình đó.

## 12. Quy tắc quản lý vocabulary khi có course_id

Khi thao tác trong bối cảnh có `course_id`:
- Được phép sử dụng vocabulary gốc trong khóa học
- Được phép bổ sung vocabulary riêng cho khóa học nếu cần
- Không được chỉnh sửa nội dung gốc của chương trình học nếu không có quyền phù hợp
- Không được xóa nội dung gốc đã thuộc chương trình học

Điều này giúp phân biệt:
- Bộ từ vựng chuẩn của chương trình học
- Bộ từ vựng bổ sung riêng cho khóa học
- Dữ liệu học tập phát sinh theo học sinh trong khóa học

## 13. Dữ liệu kết quả học vocabulary

Vocabulary có thể phát sinh dữ liệu kết quả học tập.

Dữ liệu này có thể phục vụ:
- Theo dõi tiến độ học từ
- Gợi ý ôn tập
- Báo cáo kết quả học tập
- Phân tích từ học sinh thường sai
- Điều chỉnh nội dung giảng dạy

Kết quả học vocabulary không nhất thiết là điểm số chính thức, nhưng có thể được dùng làm dữ liệu hỗ trợ đánh giá tiến độ.

## 14. Các tình huống nghiệp vụ chính

### 14.1. Tạo bộ vocabulary trong bài học

Người dùng tạo bộ từ vựng mới và gắn vào một bài học cụ thể.

### 14.2. Thêm danh sách từ vựng

Người dùng thêm từng mục từ hoặc import danh sách từ vựng từ file.

### 14.3. Học vocabulary bằng flashcard

Học sinh xem từ, nghe phát âm, xem nghĩa và ví dụ để ghi nhớ từ vựng.

### 14.4. Luyện tập vocabulary

Học sinh thực hiện các dạng luyện tập như chọn nghĩa đúng, điền từ hoặc ghép từ với nghĩa.

### 14.5. Theo dõi tiến độ học từ

Hệ thống ghi nhận số từ đã học, số từ cần ôn và kết quả luyện tập của học sinh.

### 14.6. Cập nhật vocabulary gốc

Người dùng chỉnh sửa bộ từ vựng trong chương trình học để cập nhật nội dung chuẩn.

### 14.7. Bổ sung vocabulary trong khóa học

Khi mở bài học với `course_id`, giáo viên có thể bổ sung bộ từ vựng riêng phục vụ nhu cầu vận hành của khóa học.

### 14.8. Ngưng sử dụng mục từ vựng

Khi một mục từ không còn phù hợp, người dùng chuyển trạng thái ngưng sử dụng để không ảnh hưởng dữ liệu học tập cũ.

## Edge cases và điểm cần xác nhận

- Cần xác nhận backend có chặn xóa vocabulary đã có tiến độ học hoặc kết quả luyện tập hay không.
- Cần xác nhận rule import/export khi dữ liệu trùng từ, thiếu audio/image hoặc sai format.
- Cần xác nhận setting flashcard áp dụng theo user, lesson hay toàn hệ thống.
- Cần xác nhận cách xử lý khi mục từ vựng bị sửa sau khi học sinh đã có tiến độ học.
