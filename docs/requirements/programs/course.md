# Tài Liệu BA Chi Tiết: Khóa Học

Status: reviewed
Owner: BA/DEV
Last reviewed: 2026-09-16
Related:
  - docs/api/programs/course.md
  - docs/api/programs/course-schedule.md
  - docs/api/programs/course-hook.md
  - docs/security/resources/courses.md
  - docs/test-cases/overview.md
Business rule IDs:
  - CRS-BR-001: Course là đơn vị triển khai thực tế của program.
  - CRS-BR-002: Course có thể gắn program, subject, school, teacher, semester, student và lịch học.
  - CRS-BR-003: Người tham gia course quyết định phạm vi học tập và báo cáo.
  - CRS-BR-004: Toàn bộ học liệu của program (chương học, bài học, thành phần trong bài học) được sao chép sang course; cập nhật học liệu program kéo theo cập nhật course.
  - CRS-BR-005: Lịch học course liên kết với semester/week nếu có.

Review note: Rule tạo course từ program và rule cập nhật học liệu program kéo theo cập nhật course đã được xác nhận.

## 1. Khái niệm khóa học

Khóa học là đơn vị triển khai thực tế của chương trình học trong môi trường vận hành.

Nếu chương trình học là lớp tổ chức nội dung gốc, thì khóa học là lớp đưa nội dung đó vào sử dụng thực tế với:
- Học kỳ cụ thể
- Lịch học cụ thể
- Danh sách giáo viên cụ thể
- Danh sách học sinh cụ thể

Khóa học là nơi chương trình học được chuyển thành kế hoạch học tập có thời gian, người dạy, người học và tiến trình triển khai thực tế.

## 2. Quan hệ của khóa học với các đối tượng khác

### 2.1. Quan hệ với chương trình học

Một khóa học thuộc đúng **một chương trình học**.

Khóa học sử dụng toàn bộ cấu trúc học liệu từ chương trình học đó, bao gồm:
- Chương học
- Bài học
- Homework
- Exam
- VSTEP
- Lecture
- Video Interactive
- Vocabulary
- Assessment

Khóa học không phải là nơi xây dựng lại cấu trúc học liệu gốc, mà là nơi triển khai và vận hành cấu trúc đó cho một nhóm người học cụ thể.

### 2.2. Quan hệ với học kỳ

Mỗi khóa học gắn với **một hoặc nhiều học kỳ** theo cấu trúc vận hành của hệ thống.

Học kỳ là căn cứ để:
- Xác định thời gian bắt đầu và kết thúc
- Tổ chức tuần học
- Xếp lịch học cho các bài học
- Điều phối lịch học theo mốc thời gian

### 2.3. Quan hệ với giáo viên

Một khóa học có thể có danh sách giáo viên được gắn vào để thực hiện công tác giảng dạy, theo dõi và đánh giá.

Giáo viên trong khóa học có vai trò:
- Theo dõi nội dung khóa học
- Giảng dạy theo lịch
- Quản lý tiến độ học tập
- Chấm điểm và đánh giá học sinh

### 2.4. Quan hệ với học sinh

Một khóa học có thể có danh sách học sinh được gắn vào để tham gia học tập.

Học sinh trong khóa học sẽ:
- Truy cập bài học trong khóa
- Thực hiện homework, exam, vstep, assessment và các thành phần học tập liên quan
- Theo dõi tiến độ và kết quả học tập trong phạm vi khóa học

### 2.5. Quan hệ với lịch học

Khóa học có lịch học riêng, được dùng để gắn các bài học vào các mốc thời gian cụ thể trong học kỳ.

Lịch học là lớp vận hành quan trọng để biến cấu trúc nội dung của chương trình thành kế hoạch học tập theo thời gian thực tế.

## 3. Thông tin của khóa học

Một khóa học có thể bao gồm các nhóm thông tin sau:

### 3.1. Thông tin định danh

- Mã khóa học
- Tên khóa học
- Mô tả khóa học

### 3.2. Thông tin học thuật

- Chương trình học
- Môn học liên quan
- Mục tiêu hoặc đối tượng học
- Cấp độ hoặc loại khóa học nếu có

### 3.3. Thông tin tổ chức

- Trường hoặc đơn vị quản lý
- Danh sách giáo viên
- Danh sách học sinh
- Trạng thái hoạt động

### 3.4. Thông tin thời gian

- Học kỳ
- Ngày bắt đầu
- Ngày kết thúc

### 3.5. Thông tin trình bày và vận hành

- Ảnh đại diện
- Thứ tự hiển thị
- Tiến độ hoặc tỷ lệ hoàn thành nếu có
- Thống kê số lượng học sinh tham gia nếu có

## 4. Cấu trúc học liệu của khóa học

Khóa học kế thừa học liệu từ chương trình học mà nó đang thuộc về.

Cấu trúc học liệu được sử dụng theo thứ tự:

```text
Khóa học
└─ Chương trình học
   └─ Chương học
      └─ Bài học
         ├─ Homework
         ├─ Exam
         ├─ VSTEP
         ├─ Lecture
         ├─ Video Interactive
         ├─ Vocabulary
         └─ Assessment
```

Ý nghĩa của cấu trúc này:
- Khóa học không tách rời chương trình học
- Chương trình học là nguồn học liệu gốc
- Khóa học sử dụng học liệu đó để triển khai cho người học cụ thể
- Việc học của học sinh diễn ra trong khóa học, nhưng nội dung được tổ chức theo chương trình

## 5. Vai trò của khóa học trong vận hành học tập

Khóa học đóng vai trò là cầu nối giữa cấu trúc học liệu và vận hành thực tế.

Khóa học giúp:
- Đưa chương trình học vào thực tế giảng dạy
- Gắn học liệu với người học và người dạy
- Gắn nội dung học với học kỳ
- Tổ chức lịch học theo tuần hoặc theo ngày
- Theo dõi quá trình học tập, làm bài, chấm điểm và đánh giá

## 6. Quy tắc nghiệp vụ chính của khóa học

### 6.1. Quy tắc về chương trình học

- Mỗi khóa học thuộc đúng một chương trình học
- Khóa học sử dụng học liệu từ chương trình học đó
- Cấu trúc chương học và bài học của khóa học bám theo cấu trúc của chương trình học

### 6.2. Quy tắc về học kỳ

- Khóa học phải gắn với học kỳ để có cơ sở lập lịch học
- Thời gian học của khóa học được triển khai trong khung thời gian của học kỳ
- Lịch học của bài học được sắp vào các tuần học thuộc học kỳ

### 6.3. Quy tắc về người tham gia

- Khóa học có thể gắn nhiều giáo viên
- Khóa học có thể gắn nhiều học sinh
- Danh sách giáo viên và học sinh là dữ liệu vận hành của từng khóa học, không phải dữ liệu của chương trình học

### 6.4. Quy tắc về học liệu

- Toàn bộ học liệu của program — chương học, bài học và mọi thành phần trong bài học (homework, exam, vstep, lecture, video interactive, vocabulary, assessment) — đều được sao chép sang course tạo từ program đó (đã xác nhận)
- Học liệu được vận hành trong phạm vi bài học của khóa học
- Khi học liệu của program được cập nhật, học liệu của course tạo từ program đó cũng được cập nhật theo

### 6.5. Quy tắc về lịch học

- Các bài học trong khóa học được xếp lịch theo thời gian của học kỳ
- Mỗi bài học có thể được gắn vào tuần học hoặc ngày học cụ thể
- Lịch học quyết định thời điểm triển khai bài học trong thực tế

## 7. CRUD khóa học

### 7.1. Tạo khóa học

Cho phép tạo mới khóa học để triển khai một chương trình học trong thực tế.

Thông tin thường cần khai báo gồm:
- Tên khóa học
- Mô tả khóa học
- Chương trình học
- Môn học liên quan
- Học kỳ
- Thời gian bắt đầu và kết thúc
- Trường hoặc đơn vị quản lý
- Trạng thái
- Ảnh đại diện nếu có

### 7.2. Xem danh sách khóa học

Màn danh sách khóa học là nơi người dùng tra cứu, lọc và đi vào chi tiết từng khóa học đang được triển khai.

Danh sách này thường hiển thị theo dạng thẻ hoặc bảng tùy màn hình, nhưng tối thiểu cần phản ánh các thông tin quan trọng của khóa học như:
- Ảnh đại diện
- Tên khóa học
- Mô tả ngắn
- Trạng thái hoạt động
- Trường hoặc đơn vị quản lý
- Chương trình học liên quan
- Môn học liên quan
- Số lượng giáo viên
- Số lượng học sinh
- Số chương học hoặc bài học nếu có thống kê
- Số tuần học hoặc tiến độ nếu có

Người dùng có thể lọc danh sách khóa học theo các tiêu chí chính:
- Từ khóa tìm kiếm
- Trường
- Môn học
- Chương trình học
- Người dùng đang tham gia
- Khóa học con theo `parent_id` nếu hệ thống đang dùng mô hình nhóm khóa học
- Trạng thái

Danh sách khóa học cũng cần hỗ trợ phân trang và sắp xếp theo cấu hình API, ít nhất là:
- Phân trang theo `page` và `limit`
- Sắp xếp theo `sort_id` hoặc `sort_created_at` nếu backend hỗ trợ

Phạm vi dữ liệu hiển thị phụ thuộc vào vai trò:
- Admin và nhà trường có thể xem toàn bộ khóa học trong phạm vi được cấp quyền
- Giáo viên và học sinh chỉ xem các khóa học có liên quan đến tài khoản của mình nếu hệ thống bật lọc theo người dùng

Từ danh sách, người dùng thường thực hiện các hành vi sau:
- Mở xem chi tiết khóa học
- Chuyển sang màn sửa nếu có quyền
- Xóa khóa học nếu có quyền
- Vào nhanh các luồng liên quan như lịch học hoặc danh sách người tham gia tùy màn hình

### 7.3. Xem chi tiết khóa học

Cho phép xem đầy đủ thông tin của một khóa học, bao gồm:
- Thông tin chung
- Chương trình học đang sử dụng
- Danh sách giáo viên
- Danh sách học sinh
- Học kỳ
- Lịch học
- Tiến độ hoặc các thống kê liên quan

### 7.4. Cập nhật khóa học

Cho phép cập nhật:
- Tên khóa học
- Mô tả
- Học kỳ
- Ngày bắt đầu và ngày kết thúc
- Trạng thái
- Danh sách giáo viên
- Danh sách học sinh
- Các thông tin trình bày hoặc cấu hình liên quan

### 7.5. Xóa khóa học

Cho phép xóa một khóa học khỏi hệ thống.

Backend **không** chặn xóa course đã có học sinh, lịch học hoặc kết quả học tập (đã xác nhận). Vì vậy khi xóa khóa học, cần lưu ý ảnh hưởng đến:
- Danh sách giáo viên và học sinh đã gắn
- Lịch học đã thiết lập
- Dữ liệu vận hành, tiến độ hoặc kết quả học tập liên quan

## 8. Gắn giáo viên và học sinh vào khóa học

### 8.1. Gắn giáo viên

Khóa học cho phép gắn giáo viên để xác định ai là người tham gia giảng dạy hoặc theo dõi khóa học.

Việc gắn giáo viên giúp:
- Xác định người dạy
- Phân công trách nhiệm học thuật
- Hỗ trợ các chức năng chấm điểm và báo cáo

### 8.2. Gắn học sinh

Khóa học cho phép gắn học sinh để xác định danh sách người học thực tế của khóa học.

Việc gắn học sinh giúp:
- Xác định đối tượng tham gia
- Theo dõi tiến độ học tập
- Theo dõi bài làm và kết quả đánh giá

## 9. Lịch học của khóa học

### 9.1. Khái niệm lịch học

Lịch học là cấu phần cho phép triển khai các bài học của chương trình học theo thời gian thực tế trong khóa học.

Lịch học giúp biến cấu trúc nội dung thành kế hoạch học tập cụ thể theo tuần hoặc theo ngày học.

### 9.2. Dữ liệu cốt lõi của lịch học

Lịch học của khóa học thường gắn với:
- Học kỳ
- Tuần học
- Ngày học
- Bài học
- Chương học
- Khóa học hiện tại

### 9.3. Nguyên tắc xếp lịch học

- Các bài học được xếp theo thời gian của học kỳ
- Bài học được phân bổ vào từng tuần học
- Mỗi tuần có thể có một hoặc nhiều bài học
- Lịch học được sử dụng để điều hướng tiến độ triển khai bài học trong thực tế

### 9.4. Vai trò của lịch học

Lịch học hỗ trợ:
- Giáo viên biết bài học nào cần triển khai ở từng thời điểm
- Học sinh biết nội dung nào cần học theo tuần
- Hệ thống theo dõi tiến độ triển khai nội dung

## 10. Chức năng sửa lịch học

### 10.1. Mục đích sửa lịch học

Sửa lịch học cho phép điều chỉnh kế hoạch học tập của khóa học khi có thay đổi về:
- Tiến độ thực tế
- Kế hoạch học kỳ
- Phân bổ bài học
- Điều kiện vận hành

### 10.2. Các thao tác chính khi sửa lịch học

Chức năng sửa lịch học có thể bao gồm:
- Xem lịch học hiện tại theo tuần
- Thêm bài học vào một tuần học
- Bỏ bài học khỏi một tuần học
- Điều chỉnh lại bài học giữa các tuần
- Lưu lại toàn bộ cấu trúc lịch học sau khi thay đổi

### 10.3. Kết quả sau khi sửa lịch học

Sau khi sửa lịch học:
- Khóa học phản ánh trình tự triển khai mới
- Danh sách bài học theo tuần được cập nhật
- Giáo viên và học sinh sử dụng lịch học mới để theo dõi việc học

### 10.4. Ảnh hưởng khi semester/week thay đổi

Khi semester hoặc week thay đổi sau khi course đã có lịch học, lịch học cũng sẽ thay đổi theo (đã xác nhận). Khi đó user cần **sắp xếp lại lịch học** cho khóa học để khớp với khung thời gian mới.

## 11. Đồng bộ lịch học với các khóa con cùng chương trình

### 11.1. Khái niệm khóa hiện tại và khóa con cùng chương trình

Trong một số trường hợp, một khóa học có thể đóng vai trò nguồn tham chiếu lịch học cho các khóa khác cùng chương trình.

Khi đó:
- Khóa hiện tại là khóa được dùng làm nguồn đồng bộ
- Khóa con cùng chương trình là các khóa nhận lịch học được đồng bộ từ khóa hiện tại

### 11.2. Mục đích đồng bộ lịch học

Đồng bộ lịch học giúp:
- Giảm thao tác cấu hình lặp lại
- Đảm bảo nhiều khóa cùng chương trình có lịch học thống nhất
- Hỗ trợ vận hành đồng loạt trong nhiều lớp hoặc nhiều đơn vị triển khai

### 11.3. Phạm vi đồng bộ

Chức năng đồng bộ lịch học tập trung vào:
- Lịch học của các bài học
- Cấu trúc triển khai theo tuần
- Trật tự bài học trong quá trình vận hành

Chức năng này không mang ý nghĩa thay đổi bản chất chương trình học, mà chỉ sao chép hoặc áp dụng lịch triển khai từ khóa hiện tại sang các khóa con cùng chương trình.

### 11.4. Kết quả kỳ vọng sau đồng bộ

Sau khi đồng bộ:
- Các khóa con cùng chương trình nhận được lịch học từ khóa hiện tại
- Trình tự triển khai bài học giữa các khóa trở nên thống nhất hơn
- Công tác vận hành và quản lý lịch học được đơn giản hóa

## 12. Các tình huống nghiệp vụ chính

### 12.1. Tạo mới khóa học từ chương trình học

Người dùng tạo khóa học mới, chọn chương trình học, khai báo thông tin tổ chức và thiết lập học kỳ để đưa chương trình vào vận hành.

### 12.2. Gắn giáo viên và học sinh vào khóa học

Sau khi khóa học được tạo, người dùng gắn giáo viên và học sinh để xác định người dạy và người học thực tế.

### 12.3. Xếp lịch học theo học kỳ

Người dùng thiết lập lịch học bằng cách phân bổ các bài học của chương trình vào các tuần hoặc mốc thời gian thuộc học kỳ.

### 12.4. Điều chỉnh lịch học

Trong quá trình vận hành, người dùng có thể sửa lịch học để phù hợp với tiến độ thực tế.

### 12.5. Đồng bộ lịch học sang các khóa con cùng chương trình

Khi cần chuẩn hóa tiến độ học tập giữa nhiều khóa liên quan, người dùng dùng khóa hiện tại làm nguồn và đồng bộ lịch học sang các khóa con cùng chương trình.

## 13. Ranh giới nội dung

Phần mô tả này tập trung vào:
- Khóa học là gì
- Quan hệ giữa khóa học với chương trình học
- Học kỳ, giáo viên, học sinh và lịch học
- CRUD khóa học
- Sửa lịch học
- Đồng bộ lịch học với các khóa con cùng chương trình

Không đi sâu đặc tả:
- Cấu trúc chi tiết của chương trình học
- Cấu trúc chi tiết của bài học
- Nghiệp vụ chi tiết của homework, exam, vstep, lecture, video interactive, vocabulary, assessment
- Logic đánh giá hoặc chấm điểm chi tiết

## 14. Định hướng tài liệu liên quan

Các tài liệu nên được tham chiếu kèm theo:
- `program.md`
- `lesson.md`
- `homework.md`
- `exam.md`
- `vstep.md`
- `lecture.md`
- `video-interactive.md`
- `vocabulary.md`
- `assessment.md`

## Edge cases và ghi chú kiểm thử

### Đã xác nhận

- Backend **không** chặn xóa course đã có học sinh, lịch học hoặc kết quả học tập.
- Khi tạo course từ program, **tất cả** học liệu của program (chương học, bài học, thành phần trong bài học) đều được sao chép sang course. Cập nhật học liệu program kéo theo cập nhật course tương ứng.
- Khi semester/week thay đổi sau khi course đã có lịch học, lịch học sẽ thay đổi theo và user cần sắp xếp lại lịch học (xem mục 10.4).
- Quyền xem/sửa course theo RBAC (resource `courses` trong `docs/security/resources/courses.md`):
  - **Admin**: toàn quyền — `index`, `show`, `store`, `update`, `destroy`, `export`, `import`, `restore`.
  - **Nhà trường (school)**: toàn quyền — `index`, `show`, `store`, `update`, `destroy`, `export`, `import`, `restore`.
  - **Giáo viên (teacher)**: chỉ `index` + `show` (chỉ xem).
  - **Học sinh (student)**: chỉ `index` + `show` (chỉ xem).
  - **Read only**: chỉ `index` + `show`.

> Lưu ý: mô tả "Giáo viên quản lý khóa học" ở overview và các mục trên là theo nghiệp vụ kỳ vọng, nhưng RBAC hiện tại chỉ cấp quyền xem cho role teacher trên resource `courses`. Khi dùng làm tiêu chí test, ưu tiên theo bảng RBAC ở trên.
