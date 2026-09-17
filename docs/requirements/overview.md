# Tổng Quan Hệ Thống LMS

Status: reviewed
Owner: BA/DEV
Last reviewed: 2026-09-16
Related:
  - docs/requirements/change-log.md
  - docs/requirements/change-workflow.md
  - docs/design/overview.md
  - docs/api/overview.md
  - docs/security/overview.md
  - docs/testing/overview.md
  - docs/test-cases/overview.md
Business rule IDs:
  - OVR-BR-001: Hệ thống LMS phục vụ Admin, Nhà trường, Giáo viên, Học sinh và Phụ huynh.
  - OVR-BR-002: Admin quản lý toàn hệ thống, Nhà trường quản lý trong phạm vi trường.
  - OVR-BR-003: Giáo viên tổ chức giảng dạy, giao/chấm bài và xem báo cáo.
  - OVR-BR-004: Học sinh tham gia khóa học, làm bài và xem kết quả.
  - OVR-BR-005: Chuỗi nghiệp vụ chính đi từ tổ chức dữ liệu học tập đến giao bài, làm bài, chấm điểm và báo cáo.

Review note: Tài liệu overview được dùng để mô tả bức tranh tổng quan. Không cần ghi riêng các chức năng đang tạm ẩn như Chat/Contest ở tài liệu này; trạng thái chi tiết của từng chức năng được ghi trong tài liệu nghiệp vụ tương ứng.

## 1. Mục đích hệ thống

Hệ thống LMS là nền tảng quản lý và tổ chức hoạt động dạy, học, giao bài, làm bài, chấm điểm, đánh giá và theo dõi tiến độ học tập.

Hệ thống phục vụ đồng thời nhiều nhóm người dùng trong cùng một môi trường:
- Quản trị toàn hệ thống
- Nhà trường
- Giáo viên
- Học sinh
- Phụ huynh

Ngoài các chức năng học tập cốt lõi, hệ thống còn hỗ trợ quản trị dữ liệu dùng chung, quản lý người dùng, phân quyền, báo cáo và đánh giá năng lực.

## 2. Vai trò người dùng

### 2.1. Quản trị (Admin)

Quản trị là vai trò có phạm vi thao tác rộng nhất trong hệ thống. Nhóm này chịu trách nhiệm cấu hình, quản trị dữ liệu nền, quản lý người dùng, học liệu, chương trình học, vận hành hệ thống và theo dõi các báo cáo tổng hợp.

Các khu vực chức năng chính của Admin gồm:
- Bảng điều khiển tổng quan
- Quản lý người dùng và phân quyền
- Quản lý trường học, lớp học, môn học, học kỳ
- Quản lý chương trình, khóa học, bài học, ngân hàng bài giảng, video tương tác, từ vựng
- Quản lý ngân hàng câu hỏi và thuộc tính câu hỏi
- Quản lý bài tập, bài kiểm tra, bài đánh giá, bài vstep
- Quản lý sách giáo khoa (flipbook)
- Quản lý thông báo, phản hồi, cài đặt
- Quản lý tệp tin
- Quản lý xuất dữ liệu và các tích hợp chuyên biệt

### 2.2. Nhà trường

Nhà trường là vai trò quản trị trong phạm vi dữ liệu của từng trường. Về mặt chức năng, nhóm này có nhiều tương đồng với Admin nhưng bị giới hạn trong phạm vi đơn vị quản lý của mình.

Nhà trường có thể thao tác trên các nhóm dữ liệu như:
- Chương trình học
- Khóa học
- Bài học
- Bài tập và học liệu
- Ngân hàng câu hỏi
- Hình ảnh và tài nguyên liên quan
- Phản hồi

Điểm khác biệt chính giữa Admin và Nhà trường là phạm vi dữ liệu:
- Admin quản lý toàn hệ thống
- Nhà trường quản lý dữ liệu thuộc trường của mình

### 2.3. Giáo viên

Giáo viên là nhóm người dùng trực tiếp tổ chức hoạt động giảng dạy và theo dõi việc học của học sinh.

Các nhóm chức năng chính của Giáo viên gồm:
- Xem lịch dạy và bài học theo tuần
- Quản lý chương trình, khóa học, bài học trong phạm vi được giao
- Quản lý ngân hàng bài giảng
- Quản lý bài tập, bài kiểm tra và hoạt động học tập
- Quản lý ngân hàng câu hỏi
- Chấm điểm, đánh giá và theo dõi báo cáo học tập
- Tạo và xem phản hồi
- Quản lý hồ sơ cá nhân
- Quản lý học liệu từ vựng

### 2.4. Học sinh

Học sinh là người sử dụng hệ thống để tham gia học tập, làm bài và theo dõi kết quả học tập của bản thân.

Các nhóm chức năng chính của Học sinh gồm:
- Truy cập khóa học đã được phân công
- Thực hiện bài tập, bài luyện tập, bài kiểm tra
- Xem bài giảng
- Xem tiến độ học tập và xếp hạng
- Tạo và xem phản hồi
- Quản lý hồ sơ cá nhân
- Theo dõi báo cáo học tập

### 2.5. Phụ huynh

Phụ huynh là nhóm người dùng theo dõi tài khoản học tập của con. Trong code hiện tại, phụ huynh có route `/parents/childrens`, xem danh sách tài khoản con và có thể chuyển phiên sang tài khoản học sinh thông qua token tài khoản con.

Các nhóm chức năng chính của Phụ huynh gồm:
- Xem danh sách tài khoản con được liên kết.
- Chuyển vào tài khoản học sinh của con để theo dõi trải nghiệm học tập.
- Đăng xuất khỏi khu vực phụ huynh.

## 3. Các phân hệ chính của hệ thống

### 3.1. Phân hệ xác thực và truy cập

Phân hệ này hỗ trợ:
- Đăng nhập
- Đăng xuất
- Làm mới phiên đăng nhập
- Đăng nhập qua SSO
- Điều hướng người dùng về khu vực làm việc phù hợp theo vai trò

Hệ thống có các khu vực truy cập tách biệt cho:
- Admin
- Nhà trường
- Giáo viên
- Học sinh

### 3.2. Phân hệ tổ chức học tập

Đây là phân hệ trung tâm của hệ thống, dùng để tổ chức nội dung và lộ trình học.

Các thành phần chính gồm:
- Năm học
- Học kỳ và tuần học
- Khối lớp
- Lớp học
- Chương trình học
- Khóa học
- Chương hoặc đơn vị nội dung
- Bài học
- Lịch học theo tuần
- Phân công giáo viên và học sinh vào khóa học

Phân hệ này liên kết trực tiếp với học liệu, bài giảng, bài tập, kiểm tra và báo cáo học tập.

### 3.3. Phân hệ học liệu và bài giảng

Phân hệ này quản lý các nội dung dùng cho giảng dạy và học tập, bao gồm:
- Ngân hàng bài giảng
- Tài nguyên media và file
- H5P
- Flip Book
- Nội dung từ vựng
- Sách và trang sách

Phân hệ này cho phép tái sử dụng nội dung trong nhiều chương trình, khóa học hoặc bài học khác nhau.

### 3.4. Phân hệ ngân hàng câu hỏi

Phân hệ ngân hàng câu hỏi là nền tảng cho các hoạt động giao bài và kiểm tra.

Hệ thống hỗ trợ:
- Lưu trữ câu hỏi theo nhiều dạng
- Gắn thuộc tính cho câu hỏi
- Gắn mức độ, kỹ năng, chủ đề và metadata
- Tái sử dụng câu hỏi cho bài tập, bài kiểm tra và bài luyện tập
- Quản lý nguồn câu hỏi

Các dạng câu hỏi trong hệ thống gồm:
- Trắc nghiệm nhiều lựa chọn
- Kéo thả
- Điền khuyết
- Sắp xếp thứ tự
- Ghép nối
- Gán nhãn
- Phân loại
- Viết
- Nói

### 3.5. Phân hệ giao bài và làm bài

Phân hệ này điều phối các hoạt động học tập được giao cho học sinh.

Các loại hoạt động chính gồm:
- Homework
- Exam
- Assessment

Phân hệ hỗ trợ:
- Tạo và cập nhật hoạt động
- Gán hoạt động vào bài học hoặc chương trình
- Giao hoạt động cho học sinh
- Theo dõi trạng thái làm bài
- Ghi nhận thời gian, tiến độ, điểm số, mức độ hoàn thành

### 3.6. Phân hệ chấm điểm và đánh giá

Phân hệ này xử lý kết quả học tập và đánh giá năng lực của học sinh.

Các khả năng chính gồm:
- Tự động chấm điểm với các dạng câu hỏi phù hợp
- Chấm điểm thủ công với các nội dung mở
- Tính điểm tổng, tỷ lệ hoàn thành, trạng thái nộp bài
- Theo dõi bài đã chấm và chưa chấm
- Công bố hoặc ẩn kết quả đánh giá
- Quản lý tiêu chí đánh giá và nhóm tiêu chí

Phân hệ này được sử dụng cho cả bài kiểm tra thông thường và các bài đánh giá theo tiêu chí.

### 3.7. Phân hệ báo cáo học tập

Phân hệ báo cáo hỗ trợ theo dõi kết quả và tiến trình học tập ở nhiều góc độ.

Các nhóm báo cáo hiện diện trong hệ thống gồm:
- Báo cáo tiến độ học tập của học sinh
- Báo cáo đánh giá theo tiêu chí
- Báo cáo theo khóa học
- Báo cáo theo giáo viên
- Xếp hạng học sinh
- Dashboard quản trị và dashboard nghiệp vụ

Phân hệ này hỗ trợ cả dữ liệu tổng hợp và dữ liệu chi tiết theo người học, khóa học hoặc hoạt động học tập.

### 3.8. Phân hệ quản trị người dùng và tổ chức

Phân hệ này quản lý cấu trúc tổ chức và người dùng trong hệ thống.

Các đối tượng chính gồm:
- Người dùng
- Vai trò
- Quyền
- Trường học
- Lớp học
- Học sinh
- Giáo viên
- Môn học
- Học kỳ

Phân hệ này là nền tảng để xác định phạm vi dữ liệu và trách nhiệm của từng nhóm người dùng.

### 3.9. Phân hệ truyền thông và vận hành

Phân hệ này phục vụ vận hành hệ thống và tương tác hỗ trợ.

Các chức năng đáng chú ý gồm:
- Thông báo
- Phản hồi
- Cài đặt hệ thống
- Xuất và nhập dữ liệu
- Theo dõi hoạt động hệ thống qua dashboard

### 3.10. Phân hệ AI và tích hợp ngoài

Hệ thống có các thành phần tích hợp hoặc xử lý chuyên biệt như:
- AI Grading
- ELSA
- Speechace
- Language Confidence
- Language Tool
- Chat

Nhóm này mở rộng khả năng chấm điểm, luyện kỹ năng ngôn ngữ, tương tác học tập và hỗ trợ đánh giá.

## 4. Các đối tượng nghiệp vụ chính

### 4.1. Người dùng

Người dùng là thực thể trung tâm của toàn hệ thống. Mỗi người dùng có thông tin nhận diện, vai trò, trạng thái hoạt động và thông tin liên kết như trường, lớp, khóa học, chứng chỉ hoặc chuyên môn.

Hệ thống phân biệt rõ các nhóm người dùng theo vai trò để kiểm soát:
- Quyền truy cập
- Phạm vi dữ liệu
- Khu vực thao tác
- Loại báo cáo được xem

### 4.2. Trường học

Trường học là đơn vị tổ chức dùng để quản lý dữ liệu theo phạm vi cơ sở giáo dục.

Thông tin đi kèm có thể bao gồm:
- Tên trường
- Tên viết tắt
- Loại trường
- Địa chỉ
- Thông tin liên hệ
- Logo
- Số lớp và số học sinh

### 4.3. Lớp học

Lớp học là đơn vị quản lý học sinh trong phạm vi trường học. Lớp học gắn với:
- Trường
- Khối hoặc cấp học
- Giáo viên phụ trách
- Số lượng học sinh

### 4.4. Môn học

Môn học là lớp phân loại học thuật dùng để tổ chức chương trình, khóa học, tiêu chí đánh giá và nội dung liên quan.

### 4.5. Học kỳ và tuần học

Học kỳ và tuần học được dùng để:
- Tổ chức lịch học
- Gắn lịch bài học
- Phân nhóm dữ liệu báo cáo theo thời gian
- Theo dõi các hoạt động học tập theo chu kỳ

### 4.6. Chương trình học

Chương trình học là đơn vị tổ chức nội dung ở mức cao, thường bao gồm:
- Thông tin mô tả chương trình
- Môn học liên quan
- Mục tiêu hoặc đối tượng học
- Hình ảnh minh họa
- Danh sách khóa học
- Danh sách chương hoặc cấu trúc nội dung

### 4.7. Khóa học

Khóa học là đơn vị triển khai thực tế của chương trình học.

Khóa học có thể gắn với:
- Chương trình học
- Môn học
- Trường học
- Giáo viên
- Học kỳ
- Học sinh
- Lịch học theo tuần
- Tiến độ học tập

### 4.8. Chương hoặc đơn vị nội dung

Đây là cấp tổ chức nằm giữa chương trình hoặc khóa học và bài học, dùng để nhóm các bài học thành các cụm nội dung logic.

### 4.9. Bài học

Bài học là đơn vị học tập chính trong hệ thống. Một bài học có thể bao gồm:
- Nội dung mô tả
- Bài giảng
- Bài tập
- Bài luyện tập
- Bài kiểm tra
- Bài đánh giá
- Từ vựng
- Kế hoạch bài học
- Lịch học

### 4.10. Bài giảng

Bài giảng là học liệu được sử dụng trong quá trình giảng dạy. Bài giảng có thể là nội dung độc lập hoặc được đưa vào bài học.

### 4.11. Câu hỏi

Câu hỏi là đơn vị nhỏ nhất trong các hoạt động làm bài. Mỗi câu hỏi có thể mang:
- Loại câu hỏi
- Nội dung
- Media
- Hướng dẫn
- Điểm số
- Thời gian
- Gợi ý
- Đáp án đúng
- Thuộc tính phân loại

### 4.12. Thuộc tính câu hỏi

Thuộc tính câu hỏi dùng để phân loại và đánh trọng số cho câu hỏi theo cây cấu trúc. Đối tượng này hỗ trợ:
- Chuẩn hóa ngân hàng câu hỏi
- Gắn năng lực hoặc tiêu chí
- Phân tích chất lượng bài làm

### 4.13. Homework

Homework là bài tập về nhà gắn với bài học. Học sinh có thể làm bài, lưu tiến độ, bỏ qua câu hỏi, nộp bài và nhận kết quả chấm.

### 4.14. Exam

Exam là bài kiểm tra có giới hạn về thời gian, điểm số hoặc hạn nộp, được sử dụng để đánh giá kết quả học tập theo bài học hoặc khóa học.

### 4.15. Assessment

Assessment là đối tượng đánh giá có thể gắn với tiêu chí, file nộp và kết quả chấm theo nhóm tiêu chí. Đây là thành phần quan trọng cho các đánh giá định tính hoặc bán định lượng.

### 4.16. Tiêu chí đánh giá

Hệ thống có các đối tượng tiêu chí phục vụ đánh giá, bao gồm:
- Tiêu chí đánh giá
- Nhóm tiêu chí đánh giá
- Tiêu chí báo cáo học tập

Nhóm này hỗ trợ việc chấm theo năng lực, kỹ năng hoặc nhận xét có cấu trúc.

### 4.17. Báo cáo học tập

Báo cáo học tập là kết quả tổng hợp đánh giá của học sinh theo tiêu chí. Báo cáo có thể chứa:
- Nhận xét chung
- Điểm sao hoặc mức đánh giá
- Trạng thái hoàn thành
- Dữ liệu kỹ năng
- Ghi chú và nhận xét
- Liên kết với học sinh, giáo viên, khóa học và bài đánh giá

### 4.18. Phản hồi

Phản hồi là kênh ghi nhận hoặc trao đổi thông tin giữa người dùng với hệ thống hoặc đơn vị quản lý.

### 4.19. Thông báo

Thông báo là cơ chế truyền tải thông tin từ hệ thống hoặc người quản trị tới người dùng hoặc nhóm người dùng.

### 4.20. File, media và hình ảnh

Hệ thống có lớp dữ liệu dành cho file, media và hình ảnh nhằm phục vụ:
- Nội dung học tập
- Bài nộp
- Hình minh họa
- Tài nguyên chia sẻ

## 5. Mối liên hệ giữa vai trò, phân hệ và đối tượng

### 5.1. Admin

Admin làm việc trên hầu hết các phân hệ và có thể quản lý gần như toàn bộ đối tượng nghiệp vụ trong hệ thống.

Trọng tâm của Admin là:
- Cấu hình và vận hành hệ thống
- Tổ chức dữ liệu nền
- Quản trị người dùng và quyền
- Quản lý học liệu và hoạt động học tập
- Theo dõi dashboard và báo cáo

### 5.2. Nhà trường

Nhà trường làm việc trên tập con của các phân hệ quản trị và học tập, với trọng tâm là dữ liệu trong phạm vi trường.

Trọng tâm của Nhà trường là:
- Quản lý chương trình, khóa học, bài học
- Quản lý học liệu, bài tập và ngân hàng câu hỏi
- Quản lý phản hồi và hình ảnh
- Quản lý dữ liệu vận hành thuộc trường

### 5.3. Giáo viên

Giáo viên làm việc chủ yếu với phân hệ tổ chức học tập, giao bài, chấm điểm và báo cáo.

Trọng tâm của Giáo viên là:
- Tổ chức bài học
- Giao hoạt động học tập
- Theo dõi tiến độ học sinh
- Chấm điểm và đánh giá
- Xem báo cáo theo lớp hoặc học sinh

### 5.4. Học sinh

Học sinh làm việc chủ yếu với phân hệ học tập và theo dõi kết quả.

Trọng tâm của Học sinh là:
- Tham gia khóa học
- Học theo bài
- Làm bài được giao
- Xem tiến độ, kết quả và xếp hạng
- Nhận phản hồi

## 6. Phạm vi chức năng theo vai trò

### 6.1. Admin

Admin hiện có các nhóm chức năng nổi bật:
- Dashboard
- Quản trị người dùng
- Quản trị quyền và hiển thị quyền
- Quản trị trường học, lớp học, môn học, học kỳ
- Quản trị chương trình, khóa học, bài học
- Quản trị ngân hàng bài giảng, ngân hàng câu hỏi, thuộc tính câu hỏi
- Quản trị assignment, exam, assessment
- Quản trị báo cáo và xuất dữ liệu
- Quản trị notices, feedback, settings, images
- Quản trị các tích hợp chuyên biệt như ELSA, Speechace, H5P, Language Confidence

### 6.2. Nhà trường

Nhà trường hiện có các nhóm chức năng nổi bật:
- Quản lý chương trình
- Quản lý khóa học
- Quản lý bài học
- Quản lý bài tập và hoạt động học tập
- Quản lý ngân hàng bài giảng
- Quản lý ngân hàng câu hỏi
- Quản lý hình ảnh
- Quản lý từ vựng
- Quản lý phản hồi

### 6.3. Giáo viên

Giáo viên hiện có các nhóm chức năng nổi bật:
- Lịch bài học theo tuần
- Quản lý chương trình và khóa học được giao
- Quản lý bài học
- Quản lý assignments
- Quản lý lecture bank
- Quản lý question bank
- Xem và xử lý báo cáo
- Quản lý phản hồi
- Quản lý từ vựng

### 6.4. Học sinh

Học sinh hiện có các nhóm chức năng nổi bật:
- Danh sách khóa học
- Danh sách assignments
- Làm homework và exam
- Xem kết quả và review bài làm
- Xem feedback
- Xem progress report
- Xem ranking
- Quản lý hồ sơ cá nhân

## 7. Ranh giới quản trị giữa Admin và Nhà trường

Admin và Nhà trường có mô hình chức năng gần nhau nhưng khác nhau ở tầng quản trị dữ liệu.

Admin:
- Điều hành toàn hệ thống
- Quản lý dữ liệu dùng chung
- Quản lý nhiều trường và nhiều nhóm người dùng
- Xem các dashboard và báo cáo ở mức hệ thống

Nhà trường:
- Điều hành trong phạm vi trường
- Quản lý dữ liệu thuộc trường mình
- Tập trung vào vận hành học tập và học liệu của đơn vị
- Không mang tính quản trị toàn cục như Admin

## 8. Nhận diện tổng quan kiến trúc nghiệp vụ

Về mặt nghiệp vụ, hệ thống có thể được nhìn như một chuỗi vận hành khép kín:

1. Tổ chức người dùng và đơn vị quản lý
2. Tạo cấu trúc học tập gồm chương trình, khóa học, bài học
3. Chuẩn bị học liệu và ngân hàng câu hỏi
4. Tạo các hoạt động học tập và đánh giá
5. Giao bài cho học sinh
6. Học sinh học, làm bài và nộp kết quả
7. Hệ thống và giáo viên chấm điểm, đánh giá
8. Báo cáo kết quả, tiến độ và xếp hạng

Chuỗi này thể hiện hệ thống không chỉ là công cụ quản lý nội dung học tập mà còn là nền tảng điều phối toàn bộ vòng đời học tập, kiểm tra và đánh giá trong môi trường giáo dục.

## 9. Luồng nghiệp vụ tổng quát

1. Admin hoặc Nhà trường thiết lập dữ liệu nền như người dùng, trường, năm học, học kỳ, khối, lớp và môn học.
2. Admin, Nhà trường hoặc Giáo viên tạo chương trình, khóa học, bài học và học liệu.
3. Giáo viên hoặc vai trò được phân quyền giao hoạt động học tập cho học sinh.
4. Học sinh truy cập khóa học, học bài, làm bài và nộp kết quả.
5. Hệ thống tự chấm các câu hỏi phù hợp và ghi nhận tiến độ.
6. Giáo viên chấm hoặc đánh giá thủ công các nội dung cần xử lý bởi người dùng.
7. Hệ thống tổng hợp báo cáo, ranking, progress report và dữ liệu dashboard.
8. Người dùng theo vai trò xem kết quả trong phạm vi quyền và dữ liệu của mình.

## 10. Tài liệu bổ sung đã thêm

- [LMS Business Flow Overview](lms-business-flow.md)
- [Auth](auth/auth.md)
- [Profile](users/profile.md)
- [Parent](users/parent.md)
- [School Year](semesters/school-year.md)
- [Public Share Links](public-share.md)
- [Media và Upload](media/media.md)
- [H5P](learning-materials/h5p.md)
- [Sync Materials](learning-materials/sync-materials.md)
- [Text To Speech](learning-materials/text-to-speech.md)
- [Exam Answer Review And Manual Scoring](learning-materials/exam-answer.md)
- [Clone Homework And Exam](learning-materials/clone-homework-exam.md)
- [Import và Export dữ liệu](transfers/import-export.md)
- [Tích hợp ngoài và AI](integrations/external-integrations.md)
- [Progress Report và Ranking](reports/student-progress-ranking.md)
- [Teacher Reports và Weekly Lessons](reports/teacher-reports-weekly-lessons.md)
- [Course Chat](chat/course-chat.md)
- [Nguồn câu hỏi](learning-materials/source-questions.md)
- [Thuộc tính câu hỏi](learning-materials/question-attributes.md)
- [Tags](learning-materials/tags.md)
- [Topics](learning-materials/topics.md)
- [Skills](learning-materials/skills.md)
- [Trình độ đào tạo](learning-materials/training-levels.md)
- [VSTEP](learning-materials/vsteps.md)
- [Chapter](programs/chapter.md)
- [Lesson Plan](programs/lesson-plan.md)
- [Lesson Plan Part](programs/lesson-plan-part.md)
- [Grade](schools/grade.md)
- [Class](schools/class.md)
- [Certificate](schools/certificate.md)
- [Degree](schools/degree.md)
- [Holiday](semesters/holiday.md)
- [Contest](contests/contest.md)
- [Contest Round](contests/contest-round.md)
- [Meetings](integrations/meetings.md)
- [Internal Command](operations/internal-command.md)

## Nguyên tắc sử dụng tài liệu và điểm cần lưu ý

Các nguyên tắc dưới đây đã được xác nhận và áp dụng khi dùng tài liệu overview:

- Tài liệu overview chỉ mô tả tổng quan, **không** thay thế rule chi tiết của từng domain. Khi cần rule cụ thể, đọc file requirement của domain tương ứng.
- Khi overview lệch với file requirement của domain, **ưu tiên file domain** (gần feature hơn) và cập nhật lại overview.
- Khi requirement lệch với route/API/code hiện tại, **ưu tiên tài liệu** là hành vi kỳ vọng; ghi rõ điểm lệch để BA/Dev xác nhận. Chỉ cập nhật requirement theo code khi BA xác nhận tài liệu đã lỗi thời.
- Các phân hệ tích hợp ngoài như ELSA, Speechace, AI grading cần đối chiếu thêm với API và cấu hình runtime trước khi kết luận hành vi.
- Ranh giới Admin/Nhà trường/Giáo viên/Học sinh mô tả ở đây là theo nghiệp vụ kỳ vọng; cần đối chiếu với **RBAC thực tế** (`docs/security/`) trước khi dùng làm tiêu chí test.
