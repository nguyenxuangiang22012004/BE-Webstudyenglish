# Tài Liệu BA Chi Tiết: Flip Book

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-09-16
Related:
  - docs/api/flip-books/book.md
  - docs/api/flip-books/book-page.md
  - docs/api/flip-books/book-tag.md
  - docs/security/resources/books.md
  - docs/test-cases/overview.md
Business rule IDs:
  - FLB-BR-001: Flip book được phân loại thành course book và reading corner với dữ liệu riêng.
  - FLB-BR-002: Trang sách có tài nguyên ảnh, text, audio và liên kết bài học tùy loại sách.
  - FLB-BR-003: Course book phục vụ bài học/chương trình, reading corner phục vụ đọc mở rộng.
  - FLB-BR-004: Publish quyết định khả năng truy cập của học sinh/giáo viên.
  - FLB-BR-005: Tiến độ và điểm reading/course book cần theo rule backend nếu có.

Review note: Cần rà lại phần Reading corner/My books với PM/BA vì hiện người review chưa xác nhận được nghiệp vụ này trong sản phẩm hiện tại. Hiện tại không có tiến độ đọc sách.

## 1. Khái niệm flip book

Flip book là phân hệ quản lý và đọc sách điện tử trong LMS.

Sách trong flip book được chia thành 2 loại chính:
- Sách giáo khoa (Course book).
- Sách truyện (Reading corner).

Hai loại sách có mục đích, cách phân loại, cách soạn thảo và cách truy cập khác nhau. Phần Reading corner/My books cần được PM/BA rà lại trước khi dùng làm source of truth cuối cùng.

## 2. Phân loại sách

### 2.1. Sách giáo khoa (Course book)

Sách giáo khoa là sách gắn với môn học, khối lớp và chương trình học.

Ví dụ:
- Môn: Toán.
- Khối: Lớp 1.
- Chương trình: chương trình học tương ứng.

Học sinh truy cập được các cuốn sách giáo khoa thuộc khóa học mà mình đã đăng ký.

Sách giáo khoa thường đã có bản thiết kế sẵn và có thể xuất thành folder ảnh theo thứ tự trang.

Đặc điểm chính:
- Dùng cho cả giáo viên và học sinh.
- Trang sách có kích thước A4.
- Trang hoặc nhóm trang có thể được gắn vào bài học trong chương trình.
- Có thể thêm audio vào vị trí bất kỳ trên trang.
- Không tính tiến độ đọc.
- Không tính điểm.

### 2.2. Sách truyện (Reading corner)

Sách truyện là sách phục vụ hoạt động đọc mở rộng.

Sách truyện được phân loại theo:
- Level: Level 1, Level 2, Level 3, Level 4, Level 5.
- Sub-level: Easy, Medium, Hard.
- Chủ đề.
- Thể loại.

Sách truyện chưa có thiết kế sẵn. RnD sẽ tự tạo các trang sách trên LMS.

Mỗi trang sách có một ảnh nền do RnD thiết kế, trong đó ảnh cần chừa không gian để chèn text.

Đặc điểm chính:
- Dùng chủ yếu cho học sinh.
- Có flashcard trước khi đọc.
- Có chế độ đọc.
- Có câu hỏi đọc hiểu sau hoặc trong quá trình đọc.
- Audio phiên bản 1 theo cấp trang: mỗi trang có một dải audio chạy hết nội dung trên trang.
- Có tính tỷ lệ hoàn thành.
- Có tính điểm theo câu hỏi đọc hiểu.

## 3. Kích thước và tài nguyên trang sách

### 3.1. Sách giáo khoa

Trang sách giáo khoa dùng kích thước A4.

Kích thước chuẩn:
- 297 x 210 mm.
- 3508 x 2480 px.

Sách có thể được nhập từ folder ảnh đã xuất theo thứ tự trang.

Mỗi ảnh tương ứng một trang sách.

### 3.2. Reading corner

Mỗi trang sách truyện có một ảnh nền.

Ảnh nền được thiết kế trực tiếp trong quy trình RnD để có vị trí đặt text, audio và các nội dung tương tác cần thiết.

## 4. Thông tin sách

### 4.1. Thông tin chung

Mọi loại sách đều có các thông tin chung:
- Tiêu đề sách.
- Năm xuất bản.
- Mô tả sách.
- Trang bìa.
- Trạng thái Publish.
- Trang bắt đầu.

Trang bắt đầu là số của trang đầu tiên do Admin nhập. Các trang sau tự động tăng thêm 1 theo thứ tự trang.

### 4.2. Thông tin riêng của sách giáo khoa

Sách giáo khoa có thêm:
- Môn học.
- Khối lớp.
- Chương trình học.

### 4.3. Thông tin riêng của Reading corner

Reading corner có thêm:
- Level.
- Sub-level.
- Chủ đề.
- Thể loại.

Các thể loại gồm:
- Truyện theo cấu trúc (sentence pattern).
- Truyện có người dẫn (story with narrative).
- Truyện chỉ có thoại (dialogue story).

## 5. Quản lý sách cho Admin

### 5.1. Danh sách sách

Admin xem danh sách toàn bộ sách trong hệ thống.

Danh sách cần hỗ trợ bộ lọc:
- Phân loại: Course book, Reading corner.
- Từ khóa theo tên sách.
- Trạng thái Publish nếu cần.

### 5.2. Bộ lọc chi tiết cho Course book

Khi chọn phân loại Course book, hệ thống hỗ trợ lọc theo:
- Môn học.
- Khối lớp.
- Chương trình học.

### 5.3. Bộ lọc chi tiết cho Reading corner

Khi chọn phân loại Reading corner, hệ thống hỗ trợ lọc theo:
- Level.
- Mức độ khó.
- Chủ đề.
- Thể loại nếu cần.

### 5.4. Thống kê

Màn quản lý sách cần hiển thị:
- Tổng số sách.
- Số sách đã Publish.

## 6. Soạn thảo sách

### 6.1. Tạo hoặc cập nhật thông tin sách

Admin tạo sách mới hoặc cập nhật sách đã có.

Khi tạo sách, Admin chọn loại sách trước để hệ thống hiển thị đúng nhóm thông tin cần nhập.

Thông tin bắt buộc và quy tắc validate cần phụ thuộc vào loại sách.

### 6.2. Tải folder ảnh

Admin có thể tải folder ảnh để tạo danh sách trang sách.

Quy tắc:
- Mỗi ảnh là một trang.
- Thứ tự trang mặc định theo thứ tự ảnh trong folder hoặc theo tên file nếu hệ thống dùng tên file để sắp xếp.
- Kích thước ảnh nên bằng kích thước trang.
- Với Course book, ảnh nên theo chuẩn A4.

### 6.3. Sắp xếp trang sách

Admin có thể kéo thả để thay đổi thứ tự trang.

Sau khi kéo thả:
- Số thứ tự trang tự cập nhật theo thứ tự mới.
- Số trang bắt đầu từ giá trị Trang bắt đầu.
- Các trang sau tự tăng thêm 1.

### 6.4. Nhập text vào trang sách

Admin có thể nhập text vào vị trí bất kỳ trên trang sách.

Thông tin vùng text gồm:
- Nội dung text.
- Vị trí.
- Kích thước.
- Trang chứa text.

### 6.5. Soạn thảo Course book

Với sách giáo khoa, Admin có thể:
- Chọn chương cho một trang.
- Chọn bài học cho một trang.
- Chọn chương và bài học cho một nhóm trang.
- Thêm audio vào vị trí bất kỳ trong trang.

Luồng gắn bài học có thể hỗ trợ tab chọn nhiều trang:
- Chọn các trang cần gắn.
- Lọc chương hoặc bài học.
- Chọn chương hoặc bài học tương ứng.
- Lưu liên kết.

### 6.6. Soạn thảo Reading corner

Với sách truyện, Admin hoặc RnD có thể:
- Thêm audio cho cả trang sách.
- Chọn thẻ flashcard đã có.
- Tạo thẻ flashcard mới.
- Duplicate thẻ flashcard.
- Chọn câu hỏi đã có.
- Tạo câu hỏi mới.
- Duplicate câu hỏi.

Các dạng câu hỏi đọc hiểu cần hỗ trợ:
- MCQs.
- Reorder.
- Drag and drop.
- Fill.

## 7. Trang sách

### 7.1. Thông tin chung của trang

Mỗi trang sách gồm:
- Sách chứa trang.
- Số trang.
- Ảnh nền.
- Danh sách vùng text nếu có.
- Danh sách audio nếu có.

### 7.2. Trang sách giáo khoa

Trang Course book có thể có:
- Chương liên kết.
- Bài học liên kết.
- Audio tại vị trí bất kỳ.
- Annotation do giáo viên tạo trong lúc giảng dạy nếu có.

Một trang hoặc nhóm trang có thể cùng liên kết với một bài học.

### 7.3. Trang Reading corner

Trang Reading corner có thể có:
- Text được chèn trên ảnh.
- Audio cấp trang.
- Dữ liệu karaoke nếu đọc kèm audio.
- Flashcard liên quan.
- Câu hỏi đọc hiểu liên quan.

Trong phiên bản 1, mỗi trang Reading corner có một audio chạy hết nội dung trên trang.

## 8. Audio

### 8.1. Audio trong Course book

Course book hỗ trợ audio tại một vị trí bất kỳ trên trang.

Người dùng có thể bấm icon audio trên trang để nghe.

### 8.2. Audio trong Reading corner

Reading corner hỗ trợ audio cấp trang.

Khi học sinh mở trang hoặc nhấn nghe, audio chạy hết nội dung của trang.

Ở chế độ đọc kèm audio, hệ thống có thể highlight nội dung theo kiểu karaoke nếu có dữ liệu căn thời gian.

## 9. Flashcard và câu hỏi trong Reading corner

### 9.1. Flashcard

Reading corner có thể gắn flashcard cho sách.

Học sinh xem hoặc lật thẻ từ vựng trước khi đọc sách.

Admin hoặc RnD có thể:
- Chọn flashcard đã có.
- Tạo flashcard mới.
- Duplicate flashcard.

### 9.2. Câu hỏi đọc hiểu

Reading corner có câu hỏi đọc hiểu để tính điểm.

Admin hoặc RnD có thể:
- Chọn câu hỏi đã có.
- Tạo câu hỏi mới.
- Duplicate câu hỏi.

Câu hỏi đọc hiểu hỗ trợ các dạng:
- MCQs.
- Reorder.
- Drag and drop.
- Fill.

## 10. Truy cập của học sinh

### 10.1. Tìm kiếm và My books

Học sinh có thể:
- Tìm kiếm theo tên sách.
- Tìm kiếm theo chủ đề.
- Tìm kiếm theo level.
- Tìm kiếm theo sub-level.
- Lưu sách yêu thích vào My books.

### 10.2. Danh sách Course book của học sinh

Học sinh chỉ nhìn thấy các sách giáo khoa thuộc khóa học mà mình đã đăng ký.

Bộ lọc danh sách Course book:
- Môn học.
- Chương trình học.

### 10.3. Luồng đọc Course book

Luồng đọc:
1. Mở sách.
2. Lật trang.
3. Bấm nghe audio nếu trang có audio.

Bộ lọc trong một cuốn Course book:
- Chọn trang sách.
- Chọn chương.

Course book không tính tiến độ và không tính điểm.

### 10.4. Danh sách Reading corner của học sinh

Học sinh có thể lọc Reading corner theo:
- Chủ đề.
- Level.
- Sub-level.
- Thể loại.

### 10.5. Luồng đọc Reading corner

Luồng đọc:
1. Chọn sách.
2. Lật thẻ từ vựng.
3. Chọn chế độ đọc.
4. Lật trang.
5. Làm câu hỏi đọc hiểu.

Reading corner có 2 chế độ đọc:
- Tự đọc: không tự phát audio.
- Đọc kèm audio: phát audio và hỗ trợ karaoke nếu có dữ liệu.

Khi học sinh chọn Tự đọc, trong trang vẫn có icon loa để học sinh chủ động bấm nghe nếu muốn.

Bộ lọc trong một cuốn Reading corner:
- Chọn trang sách.

Reading corner có tính:
- Tỷ lệ hoàn thành phần đọc sách.
- Tỷ lệ hoàn thành phần làm câu hỏi đọc hiểu.
- Điểm theo câu hỏi đọc hiểu.

## 11. Truy cập của giáo viên

Giáo viên chỉ truy cập Course book.

Giáo viên dùng Course book trong luồng giảng dạy.

Khi giáo viên giảng dạy bài học:
- Hệ thống mở đúng trang hoặc nhóm trang sách đã gắn với bài học.
- Giáo viên có thể lật trang trong phạm vi liên quan.
- Giáo viên có thể bấm nghe audio nếu trang có audio.
- Giáo viên có thể viết lên trang sách.
- Giáo viên có thể vẽ lên trang sách.
- Giáo viên có thể highlight nội dung.
- Giáo viên có thể tẩy nội dung đã viết, vẽ hoặc highlight.

Các thao tác viết, vẽ, highlight, tẩy là thao tác phục vụ giảng dạy trên trang sách đang mở. Cần xác định thêm việc dữ liệu annotation có lưu lại hay chỉ tồn tại trong phiên dạy.

## 12. Truy cập của Admin

Admin quản lý cả Course book và Reading corner.

Admin có thể:
- Tạo sách.
- Cập nhật thông tin sách.
- Publish hoặc unpublish sách.
- Tải folder ảnh.
- Sắp xếp trang.
- Gắn trang với chương và bài học cho Course book.
- Thêm text và audio.
- Quản lý flashcard và câu hỏi cho Reading corner.
- Xóa sách hoặc trang sách nếu có quyền.

## 13. Publish

Trạng thái Publish quyết định sách có sẵn sàng được hiển thị cho người dùng học tập hay không.

Sách chưa Publish nên được xem là bản nháp hoặc bản đang soạn.

Quy tắc hiển thị cụ thể cần phụ thuộc vai trò:
- Admin có thể xem cả sách đã Publish và chưa Publish nếu có quyền.
- Học sinh chỉ nên thấy sách đã Publish.
- Giáo viên chỉ nên thấy Course book đã Publish hoặc sách được cấp quyền trong luồng giảng dạy.

## 14. Tiến độ và điểm

### 14.1. Course book

Course book không tính:
- Tiến độ đọc.
- Điểm.

### 14.2. Reading corner

Hiện tại chưa có tiến độ đọc sách được xác nhận cho Reading corner.

Nếu sau này bật lại hoặc chốt nghiệp vụ Reading corner, PM/BA cần xác nhận lại có tính điểm theo câu hỏi đọc hiểu hay không.

## 15. Quyền và phạm vi dữ liệu

Phân hệ flip book cần kiểm soát quyền theo vai trò và phạm vi dữ liệu.

Các nhóm quyền chính:
- Tạo sách.
- Cập nhật sách.
- Xóa sách.
- Publish sách.
- Xem sách.
- Xuất dữ liệu hoặc xuất PDF nếu có.
- Quản lý trang sách.
- Quản lý flashcard và câu hỏi trong Reading corner.

Phạm vi dữ liệu:
- Admin quản lý toàn bộ sách.
- Giáo viên truy cập Course book liên quan đến bài học hoặc khóa học được phân công.
- Học sinh truy cập Course book thuộc khóa học đã đăng ký và Reading corner được Publish.

## 16. Các tình huống nghiệp vụ chính

### 16.1. Admin tạo Course book

Admin chọn loại Course book, nhập thông tin sách, chọn môn, khối, chương trình, tải bìa, tải folder ảnh và publish khi sách sẵn sàng.

### 16.2. Admin gắn trang Course book với bài học

Admin chọn một trang hoặc nhiều trang, lọc chương và bài học, sau đó gắn các trang đã chọn với bài học tương ứng.

### 16.3. Giáo viên mở sách khi giảng dạy

Giáo viên mở bài học đang dạy. Hệ thống mở đúng trang hoặc nhóm trang Course book đã gắn với bài học. Giáo viên có thể viết, vẽ, highlight, tẩy và nghe audio.

### 16.4. Học sinh đọc Course book

Học sinh mở sách thuộc khóa học đã đăng ký, lật trang và nghe audio nếu có. Hệ thống không tính tiến độ và không tính điểm.

### 16.5. Admin hoặc RnD tạo Reading corner

Admin hoặc RnD chọn loại Reading corner, nhập level, sub-level, chủ đề, thể loại, tạo hoặc tải ảnh trang, chèn text, thêm audio, flashcard và câu hỏi đọc hiểu.

### 16.6. Học sinh đọc Reading corner

Học sinh chọn sách, xem flashcard, chọn chế độ đọc, đọc sách và làm câu hỏi đọc hiểu nếu nghiệp vụ Reading corner được bật. Hiện tại chưa có tiến độ đọc sách được xác nhận.

### 16.7. Học sinh lưu My books

My books cần được PM/BA rà lại vì hiện chưa xác nhận được nghiệp vụ này trong sản phẩm hiện tại.

## 17. Lưu ý cần xác nhận thêm

- Annotation của giáo viên có lưu lại theo phiên dạy, theo giáo viên, theo lớp hay chỉ hiển thị tạm thời.
- Quy tắc học sinh nhìn thấy Reading corner theo toàn hệ thống, theo trường, theo cấp học hay theo cấu hình riêng.
- Quy tắc duplicate flashcard và duplicate câu hỏi: tạo bản sao độc lập hay tạo liên kết dùng lại.
- Cách sắp xếp ảnh khi tải folder: theo tên file, thứ tự upload hay metadata của folder.
- Reading corner/My books hiện chưa được xác nhận trong sản phẩm hiện tại; nếu dùng lại cần PM/BA review nghiệp vụ.
- Hiện tại không có tiến độ đọc sách.
- Cách xử lý trang bắt đầu khi có trang bìa, trang mục lục hoặc trang không hiển thị số trang.
- Course book hiện có code gắn `program_id`, `chapter_id`, `lesson_id`; các trường môn, khối, loại sách, level, sub-level, thể loại cần được xác nhận thêm với API/backend nếu chưa có.
