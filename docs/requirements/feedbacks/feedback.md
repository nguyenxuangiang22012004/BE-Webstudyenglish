# Tài Liệu BA Chi Tiết: Feedback

Status: reviewed
Owner: BA/DEV
Last reviewed: 2026-09-16
Related:
  - docs/api/feedbacks/feedback.md
  - docs/api/feedbacks/internal-comment.md
  - docs/security/resources/internal.md
  - docs/test-cases/overview.md
Business rule IDs:
  - FDB-BR-001: Feedback gắn với người gửi và có thể gắn với người xử lý.
  - FDB-BR-002: Feedback có loại, trạng thái, liên kết nghiệp vụ và file đính kèm nếu có.
  - FDB-BR-003: Nhà trường xử lý feedback trong phạm vi trường, Admin theo dõi toàn hệ thống.
  - FDB-BR-004: Quy trình feedback đi từ tạo mới đến xử lý, yêu cầu bổ sung thông tin hoặc hoàn tất.

Review note: Feedback cho phép gửi file đính kèm. Admin/school xử lý feedback được đổi trạng thái và ghi internal comment.

## 1. Khái niệm feedback

Feedback là phản hồi do người dùng gửi trong quá trình sử dụng hệ thống LMS.

Feedback giúp người dùng báo vấn đề, góp ý cải tiến, đặt câu hỏi hỗ trợ hoặc phản ánh trải nghiệm học tập và vận hành.

Feedback có thể đến từ nhiều nhóm người dùng:
- Admin
- Nhà trường
- Giáo viên
- Học sinh

Feedback là kênh hỗ trợ vận hành, giúp đội ngũ quản trị ghi nhận, phân loại, xử lý và theo dõi các vấn đề phát sinh trong hệ thống.

## 2. Quan hệ của feedback với các đối tượng khác

### 2.1. Quan hệ với người gửi

Mỗi feedback được tạo bởi một người dùng cụ thể.

Người gửi có thể là học sinh, giáo viên, tài khoản nhà trường hoặc admin tùy theo phạm vi sử dụng hệ thống.

### 2.2. Quan hệ với người xử lý

Feedback có thể được gán cho một người hoặc một nhóm phụ trách xử lý.

Người xử lý có trách nhiệm:
- Xem nội dung phản hồi
- Phân loại mức độ ưu tiên
- Cập nhật trạng thái
- Trao đổi lại với người gửi nếu cần
- Đóng feedback khi đã xử lý xong

### 2.3. Quan hệ với trường học

Feedback có thể thuộc phạm vi một trường học.

Điều này giúp nhà trường chỉ nhìn thấy và xử lý các feedback liên quan đến dữ liệu, giáo viên hoặc học sinh thuộc trường của mình.

### 2.4. Quan hệ với khóa học và bài học

Một feedback có thể gắn với khóa học, bài học hoặc hoạt động học tập cụ thể nếu người gửi phản hồi từ một màn hình học tập.

Ví dụ:
- Phản hồi về bài học
- Phản hồi về homework
- Phản hồi về exam
- Phản hồi về lỗi học liệu
- Phản hồi về điểm hoặc kết quả học tập

### 2.5. Quan hệ với file đính kèm

Feedback có thể có file đính kèm để mô tả vấn đề rõ hơn.

File đính kèm có thể là:
- Ảnh chụp màn hình
- File tài liệu
- Video ngắn
- Log hoặc file hỗ trợ kiểm tra

## 3. Feedback gồm những thông tin gì

Một feedback có thể bao gồm các nhóm thông tin sau:

### 3.1. Thông tin định danh

- Mã feedback
- Tiêu đề feedback
- Nội dung feedback

### 3.2. Thông tin người gửi

- Người gửi
- Vai trò người gửi
- Trường học của người gửi nếu có
- Thông tin liên hệ nếu cần

### 3.3. Thông tin phân loại

- Loại feedback
- Chủ đề phản hồi
- Mức độ ưu tiên
- Phạm vi ảnh hưởng
- Nguồn phát sinh

### 3.4. Thông tin liên kết nghiệp vụ

- Khóa học liên quan nếu có
- Bài học liên quan nếu có
- Homework, exam, assessment hoặc học liệu liên quan nếu có
- Màn hình hoặc chức năng phát sinh phản hồi nếu có

### 3.5. Thông tin xử lý

- Người phụ trách xử lý
- Trạng thái xử lý
- Ghi chú xử lý
- Nội dung phản hồi lại cho người gửi
- Thời điểm tiếp nhận
- Thời điểm cập nhật gần nhất
- Thời điểm hoàn tất

### 3.6. Thông tin tài nguyên

- File đính kèm
- Ảnh minh họa
- Link liên quan nếu có

## 4. Loại feedback

Feedback có thể được phân loại theo mục đích xử lý.

Các loại phổ biến gồm:
- Báo lỗi hệ thống
- Báo lỗi học liệu
- Góp ý cải tiến
- Yêu cầu hỗ trợ
- Khiếu nại hoặc phản ánh
- Câu hỏi về cách sử dụng
- Phản hồi về điểm số hoặc kết quả học tập

Việc phân loại giúp hệ thống điều hướng feedback tới đúng người xử lý và ưu tiên phù hợp.

## 5. Trạng thái feedback

Feedback có thể đi qua nhiều trạng thái xử lý.

Các trạng thái phổ biến gồm:
- Mới tạo
- Đã tiếp nhận
- Đang xử lý
- Cần bổ sung thông tin
- Đã phản hồi
- Đã hoàn tất
- Đã hủy

Trạng thái giúp người gửi và người xử lý theo dõi tiến độ xử lý feedback.

## 6. Vai trò của feedback trong vận hành LMS

Feedback là kênh ghi nhận vấn đề và nhu cầu thực tế từ người dùng.

Feedback giúp:
- Phát hiện lỗi hệ thống
- Phát hiện học liệu sai hoặc thiếu
- Cải thiện trải nghiệm người dùng
- Hỗ trợ học sinh và giáo viên trong quá trình học tập
- Theo dõi chất lượng vận hành theo trường, khóa học hoặc chức năng
- Tạo cơ sở dữ liệu cho cải tiến sản phẩm

## 7. CRUD feedback

### 7.1. Tạo feedback

Cho phép người dùng tạo feedback mới.

Thông tin thường cần khai báo:
- Tiêu đề
- Nội dung phản hồi
- Loại feedback
- File đính kèm nếu có
- Đối tượng liên quan nếu feedback phát sinh từ một màn hình cụ thể

### 7.2. Xem danh sách feedback

Cho phép xem danh sách feedback theo:
- Từ khóa
- Loại feedback
- Trạng thái
- Mức độ ưu tiên
- Người gửi
- Người xử lý
- Trường học
- Thời gian tạo
- Phân trang

### 7.3. Xem chi tiết feedback

Cho phép xem chi tiết feedback, bao gồm:
- Nội dung phản hồi
- Người gửi
- Thông tin liên quan
- File đính kèm
- Trạng thái xử lý
- Lịch sử trao đổi
- Ghi chú xử lý

### 7.4. Cập nhật feedback

Cho phép cập nhật feedback theo vai trò phù hợp.

Người gửi có thể cập nhật nội dung hoặc bổ sung thông tin khi feedback chưa hoàn tất.

Người xử lý có thể cập nhật:
- Trạng thái
- Người phụ trách
- Mức độ ưu tiên
- Ghi chú xử lý
- Internal comment
- Nội dung phản hồi lại

### 7.5. Xóa hoặc hủy feedback

Cho phép hủy feedback trong một số trường hợp.

Khi feedback đã phát sinh lịch sử xử lý, nên ưu tiên chuyển trạng thái hủy thay vì xóa cứng để bảo toàn dữ liệu vận hành.

## 8. Quy trình xử lý feedback

Quy trình xử lý feedback có thể gồm các bước:

1. Người dùng tạo feedback
2. Hệ thống ghi nhận feedback với trạng thái mới tạo
3. Người phụ trách tiếp nhận và phân loại
4. Feedback được xử lý hoặc yêu cầu bổ sung thông tin
5. Người xử lý phản hồi kết quả
6. Feedback được hoàn tất hoặc hủy

Quy trình này giúp đảm bảo feedback không bị bỏ sót và có lịch sử xử lý rõ ràng.

## 9. Phân quyền feedback

Phân quyền feedback phụ thuộc vào vai trò và phạm vi dữ liệu.

Admin có thể:
- Xem toàn bộ feedback
- Phân công người xử lý
- Cập nhật trạng thái
- Theo dõi thống kê toàn hệ thống

Nhà trường có thể:
- Xem feedback thuộc trường của mình
- Xử lý feedback trong phạm vi trường
- Theo dõi feedback từ giáo viên và học sinh của trường

Giáo viên có thể:
- Tạo feedback
- Xem feedback do mình tạo
- Xem feedback liên quan đến lớp hoặc khóa học được phân công nếu được cấp quyền

Học sinh có thể:
- Tạo feedback
- Xem feedback do mình tạo
- Bổ sung thông tin khi được yêu cầu

## 10. Thông báo liên quan đến feedback

Hệ thống có thể gửi thông báo khi feedback thay đổi trạng thái.

Các sự kiện có thể gửi thông báo:
- Feedback được tạo thành công
- Feedback được tiếp nhận
- Feedback cần bổ sung thông tin
- Feedback có phản hồi từ người xử lý
- Feedback đã hoàn tất

Thông báo giúp người gửi theo dõi tiến độ mà không cần kiểm tra thủ công liên tục.

## 11. Báo cáo và thống kê feedback

Feedback có thể được tổng hợp để phục vụ vận hành.

Các chỉ số có thể gồm:
- Số feedback mới
- Số feedback đang xử lý
- Số feedback đã hoàn tất
- Thời gian xử lý trung bình
- Số feedback theo loại
- Số feedback theo trường học
- Số feedback theo chức năng phát sinh

Dữ liệu này giúp admin và nhà trường đánh giá chất lượng vận hành, chất lượng học liệu và mức độ ổn định của hệ thống.

## 12. Các tình huống nghiệp vụ chính

### 12.1. Học sinh gửi feedback về bài học

Học sinh phát hiện nội dung bài học sai hoặc khó hiểu và gửi feedback kèm mô tả.

### 12.2. Giáo viên gửi feedback về học liệu

Giáo viên phản ánh bài tập, câu hỏi hoặc tài liệu chưa phù hợp để bộ phận phụ trách kiểm tra.

### 12.3. Nhà trường xử lý feedback trong phạm vi trường

Tài khoản nhà trường xem danh sách feedback của giáo viên và học sinh thuộc trường, sau đó phân loại và xử lý.

### 12.4. Admin theo dõi feedback toàn hệ thống

Admin xem toàn bộ feedback để phát hiện lỗi phổ biến, vấn đề vận hành hoặc nhu cầu cải tiến sản phẩm.

### 12.5. Người xử lý yêu cầu bổ sung thông tin

Khi feedback chưa đủ dữ liệu, người xử lý chuyển trạng thái cần bổ sung thông tin và yêu cầu người gửi cập nhật thêm.

### 12.6. Hoàn tất feedback

Sau khi vấn đề được xử lý hoặc phản hồi đầy đủ, người xử lý chuyển feedback sang trạng thái hoàn tất.
