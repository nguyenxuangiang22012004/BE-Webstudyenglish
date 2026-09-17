# Tài Liệu BA Chi Tiết: Chương Trình Học

Status: reviewed
Owner: BA/DEV
Last reviewed: 2026-09-16
Related:
  - docs/api/programs/program.md
  - docs/api/programs/chapter.md
  - docs/api/programs/program-hook.md
  - docs/security/resources/programs.md
  - docs/security/resources/chapters.md
  - docs/test-cases/overview.md
Business rule IDs:
  - PRG-BR-001: Program là cấu trúc nội dung cấp cao theo subject hoặc mục tiêu học.
  - PRG-BR-002: Program có chương/chapter và lesson để tổ chức lộ trình học.
  - PRG-BR-003: Program là nguồn dữ liệu gốc để tạo hoặc triển khai course.
  - PRG-BR-004: Phạm vi quản lý program phụ thuộc role và đơn vị quản lý.

Review note: Tài liệu program hiện tại đúng với nghiệp vụ đã xác nhận. Không giới hạn số cấp theo nghiệp vụ hiện tại.

## 1. Khái niệm chương trình học

Chương trình học là đơn vị tổ chức nội dung ở mức cao trong hệ thống học tập.

Một chương trình học dùng để gom nhóm, quản lý và trình bày lộ trình học theo một cấu trúc thống nhất, từ cấp chương học xuống bài học và từ bài học xuống các thành phần học tập cụ thể.

Chương trình học đóng vai trò:
- Là khung nội dung học tập
- Là đơn vị gắn với môn học
- Là nền tảng để tổ chức chương học
- Là nơi quy tụ các bài học
- Là lớp tổ chức bao trùm cho các thành phần học tập như homework, exam, vstep, lecture, video interactive, vocabulary, assessment

## 2. Quan hệ của chương trình học với các đối tượng khác

### 3.1. Quan hệ với môn học

Một chương trình học thuộc đúng **một môn học**.

Một môn học có thể có **nhiều chương trình học**.

Quan hệ này giúp:
- Phân loại chương trình theo lĩnh vực học tập
- Tái sử dụng cấu trúc môn học cho nhiều chương trình
- Tạo sự nhất quán giữa nội dung chương trình và nhóm dữ liệu học thuật liên quan

### 3.2. Quan hệ với chương học

Một chương trình học bao gồm **nhiều chương học**.

Chương học là đơn vị phân rã cấp 1 của chương trình học, dùng để chia chương trình thành các phần nội dung lớn, có thứ tự và có ý nghĩa sư phạm rõ ràng.

### 3.3. Quan hệ với bài học

Mỗi chương học bao gồm **nhiều bài học**.

Bài học là đơn vị học tập trực tiếp mà người học sẽ truy cập và tương tác.

### 3.4. Quan hệ với các thành phần học tập

Mỗi bài học trong chương trình có thể bao gồm một hoặc nhiều thành phần học tập sau:
- Homework
- Exam
- VSTEP
- Lecture
- Video Interactive
- Vocabulary
- Assessment

Các thành phần này giúp bài học vừa có nội dung giảng dạy, vừa có nội dung luyện tập, kiểm tra và đánh giá.

## 3. Thông tin của chương trình học

Một chương trình học có thể bao gồm các nhóm thông tin chính sau:

### 4.1. Thông tin định danh

- Mã chương trình
- Tên chương trình
- Mô tả chương trình

### 4.2. Thông tin trình bày

- Ảnh đại diện
- Thứ tự hiển thị
- Trạng thái hoạt động

### 4.3. Thông tin học thuật

- Môn học
- Mục tiêu hoặc đối tượng học
- Tài liệu hoặc sách tham chiếu nếu có

### 4.4. Thông tin thống kê và liên kết

- Danh sách chương học
- Danh sách khóa học đang sử dụng chương trình
- Số lượng người học liên quan nếu có thống kê

## 4. Cấu trúc của một chương trình học

Cấu trúc chuẩn của một chương trình học được tổ chức như sau:

```text
Chương trình học
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

## 5. Vai trò của từng cấp trong cấu trúc

### 6.1. Chương trình học

Chương trình học là lớp quản lý tổng thể, đại diện cho một lộ trình học hoặc một bộ nội dung học tập hoàn chỉnh trong một môn học.

### 6.2. Chương học

Chương học là lớp tổ chức nội dung trung gian, dùng để:
- Chia chương trình thành các phần lớn
- Nhóm các bài học theo chủ đề
- Thiết lập thứ tự học tập theo mạch nội dung

### 6.3. Bài học

Bài học là đơn vị triển khai học tập trực tiếp, nơi tập hợp các nội dung học và hoạt động học.

### 6.4. Thành phần học tập của bài học

Các thành phần trong bài học có vai trò như sau:

- `Homework`: phục vụ giao bài và luyện tập
- `Exam`: phục vụ kiểm tra kết quả học tập
- `VSTEP`: phục vụ các nội dung kiểm tra hoặc luyện tập theo định dạng VSTEP
- `Lecture`: phục vụ nội dung giảng dạy
- `Video Interactive`: phục vụ nội dung học tương tác theo dạng video
- `Vocabulary`: phục vụ học từ vựng hoặc flashcard
- `Assessment`: phục vụ đánh giá theo tiêu chí hoặc theo hình thức đánh giá riêng

## 6. Quy tắc nghiệp vụ chính của chương trình học

### 7.1. Quy tắc về môn học

- Mỗi chương trình học thuộc đúng một môn học
- Không tồn tại chương trình học không gắn môn học
- Môn học là căn cứ phân loại chương trình học

### 7.2. Quy tắc về cấu trúc

- Một chương trình học có thể có nhiều chương học
- Một chương học có thể có nhiều bài học
- Một bài học có thể có một hoặc nhiều thành phần học tập
- Thành phần học tập thuộc phạm vi của bài học, không thuộc trực tiếp cấp chương trình học

### 7.3. Quy tắc về tổ chức hiển thị

- Chương học có thứ tự hiển thị trong chương trình
- Bài học có thứ tự hiển thị trong từng chương học
- Thứ tự được dùng để điều khiển trình tự học tập và trình bày nội dung

### 7.4. Quy tắc về phạm vi quản lý

- Việc quản lý chương trình học tập trung ở cấp chương trình và chương học
- Việc quản lý chi tiết homework, exam, vstep, lecture, video interactive, vocabulary, assessment không thuộc phạm vi đặc tả sâu của tài liệu này

### 7.5. Quy tắc về quan hệ với khóa học

- Backend **không** chặn xóa program đã có course phát sinh (đã xác nhận).
- Sau khi course đã được tạo từ program, program **vẫn được phép cập nhật** (đã xác nhận).
- Khi cập nhật học liệu của program, học liệu của course tạo từ program đó **cũng được cập nhật theo**. Course không phải là bản sao tĩnh tách rời mà bám theo học liệu gốc của program.

## 7. Quản lý chương học trong chương trình học

### 8.1. Mục đích của chương học

Chương học giúp phân tách nội dung chương trình thành các phần có cấu trúc, giúp người quản trị, giáo viên và người học dễ theo dõi lộ trình học.

### 8.2. Thông tin của chương học

Một chương học có thể bao gồm:
- Mã chương học
- Tên chương học
- Mô tả chương học
- Trạng thái
- Thứ tự hiển thị
- Danh sách bài học

### 8.3. CRUD chương học

Hệ thống hỗ trợ CRUD chương học trong phạm vi chương trình học:

#### Tạo chương học

Cho phép tạo mới chương học thuộc một chương trình học cụ thể.

Thông tin tối thiểu thường gồm:
- Tên chương học
- Mô tả chương học
- Trạng thái
- Chương trình học cha

#### Xem danh sách chương học

Cho phép xem danh sách chương học của một chương trình học, kèm theo thứ tự và danh sách bài học nếu có.

#### Xem chi tiết chương học

Cho phép xem đầy đủ thông tin của một chương học cùng các bài học đang thuộc chương học đó.

#### Cập nhật chương học

Cho phép chỉnh sửa:
- Tên chương học
- Mô tả
- Trạng thái
- Danh sách bài học liên kết
- Thứ tự hiển thị nếu có

#### Xóa chương học

Cho phép xóa chương học khỏi chương trình học.

Khi xóa chương học, cần xem xét ảnh hưởng tới:
- Danh sách bài học đang thuộc chương học
- Trình tự học tập của chương trình
- Tính toàn vẹn của cấu trúc chương trình

## 8. Sắp xếp chương học trong chương trình học

### 9.1. Mục đích sắp xếp

Sắp xếp chương học giúp xác định:
- Trình tự hiển thị chương học
- Trình tự học tập đề xuất
- Mạch nội dung của chương trình

### 9.2. Nguyên tắc sắp xếp

- Mỗi chương học có một vị trí trong chương trình
- Một chương trình học có thể thay đổi thứ tự chương học
- Việc thay đổi thứ tự không làm thay đổi bản chất nội dung chương học
- Thứ tự sau khi sắp xếp là thứ tự dùng để hiển thị trong chương trình

### 9.3. Kết quả sau khi sắp xếp

Sau khi sắp xếp, hệ thống cần phản ánh lại:
- Danh sách chương học theo thứ tự mới
- Trình tự hiển thị đúng ở các màn hình liên quan

## 9. Sắp xếp bài học trong chương học

### 10.1. Mục đích sắp xếp bài học

Sắp xếp bài học trong chương học giúp:
- Xác định thứ tự học trong từng chương
- Tạo luồng học tập rõ ràng cho người học
- Tổ chức bài học theo logic nội dung

### 10.2. Nguyên tắc sắp xếp bài học

- Bài học được sắp xếp trong phạm vi của từng chương học
- Mỗi bài học có một vị trí trong danh sách bài học của chương học
- Việc sắp xếp bài học của chương này không làm thay đổi bài học của chương khác
- Thứ tự bài học sau khi sắp xếp là thứ tự hiển thị chính thức của chương học

### 10.3. Ý nghĩa vận hành

Thứ tự bài học có ảnh hưởng trực tiếp đến:
- Trải nghiệm học tập
- Trình tự truyền đạt kiến thức
- Cách giáo viên và học sinh theo dõi nội dung

## 10. Phạm vi thành phần học tập trong bài học

Trong phạm vi chương trình học, các thành phần học tập được nhìn nhận như các đối tượng con của bài học.

### 11.1. Homework

Là thành phần phục vụ giao bài và luyện tập trong bài học.

### 11.2. Exam

Là thành phần phục vụ kiểm tra trong bài học.

### 11.3. VSTEP

Là thành phần phục vụ các nội dung học tập hoặc đánh giá theo định dạng VSTEP.

### 11.4. Lecture

Là thành phần phục vụ nội dung giảng dạy trong bài học.

### 11.5. Video Interactive

Là thành phần nội dung học theo dạng video có tương tác.

### 11.6. Vocabulary

Là thành phần học từ vựng hoặc flashcard trong bài học.

### 11.7. Assessment

Là thành phần phục vụ đánh giá theo tiêu chí hoặc theo hình thức đánh giá mở rộng.

## 11. Góc nhìn quản trị chương trình học

Ở góc độ quản trị, chương trình học là điểm bắt đầu để xây dựng cấu trúc nội dung học.

Người quản lý chương trình thường thực hiện các nhóm tác vụ:
- Tạo chương trình học
- Gắn chương trình với môn học
- Thiết lập cấu trúc chương học
- Sắp xếp chương học
- Gắn bài học vào từng chương học
- Sắp xếp bài học trong từng chương học
- Theo dõi độ đầy đủ của cấu trúc chương trình

## 12. Các tình huống nghiệp vụ chính

### 13.1. Tạo mới chương trình học

Người dùng tạo chương trình học mới, khai báo thông tin cơ bản, chọn môn học và chuẩn bị cấu trúc chương học ban đầu.

### 13.2. Bổ sung chương học cho chương trình

Sau khi có chương trình, người dùng thêm các chương học để hình thành khung nội dung cấp cao.

### 13.3. Sắp xếp lại chương học

Người dùng thay đổi thứ tự chương học để điều chỉnh lại lộ trình học hoặc cách trình bày nội dung.

### 13.4. Gắn bài học vào chương học

Mỗi chương học được bổ sung các bài học tương ứng với nội dung cần giảng dạy.

### 13.5. Sắp xếp lại bài học trong chương học

Người dùng điều chỉnh lại trình tự các bài học để phù hợp với logic học tập.

### 13.6. Hoàn thiện nội dung bài học

Trong từng bài học, người dùng tiếp tục gắn các thành phần như homework, exam, vstep, lecture, video interactive, vocabulary, assessment.

## 13. Ranh giới nội dung

Phần mô tả này chỉ tập trung vào:
- Chương trình học là gì
- Chương trình học có những thông tin gì
- Chương trình học được tổ chức theo cấu trúc nào
- Chương học và bài học nằm trong chương trình như thế nào
- Các nguyên tắc quản lý chương học và sắp xếp bài học

Không đi sâu đặc tả:
- Quy trình làm homework
- Quy trình làm exam
- Cấu trúc chi tiết của lesson
- Nghiệp vụ lecture
- Nghiệp vụ vocabulary
- Nghiệp vụ assessment
- Nghiệp vụ video interactive
- Nghiệp vụ VSTEP

## 14. Định hướng tài liệu liên quan

Nếu cần mở rộng tài liệu chi tiết, nên tách riêng các tài liệu sau trong thư mục `learning-materials`:
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

- Backend **không** chặn xóa program đã có course phát sinh.
- Program **vẫn được cập nhật** sau khi course đã được tạo từ program đó. Cập nhật học liệu của program sẽ kéo theo cập nhật học liệu của các course tạo từ program.
- Quyền quản lý program giữa Admin, Nhà trường và Giáo viên: xem chi tiết trong `docs/security/` (resource `programs`).
- Không giới hạn số cấp chapter/lesson theo nghiệp vụ hiện tại.
