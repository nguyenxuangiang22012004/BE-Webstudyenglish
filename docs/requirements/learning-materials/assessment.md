# Tài Liệu BA Chi Tiết: Assessment

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-06-04
Related:
  - docs/api/learning-materials/assessment.md
  - docs/security/resources/assessments.md
  - docs/requirements/criteria/assessment-criteria.md
  - docs/test-cases/overview.md
Business rule IDs:
  - ASM-BR-001: Assessment là hoạt động đánh giá gắn với bài học/chương trình/khóa học.
  - ASM-BR-002: Assessment có thể gắn tiêu chí, file nộp và kết quả chấm.
  - ASM-BR-003: Khi quản lý trong chương trình học, assessment là dữ liệu gốc dùng để tái sử dụng.
  - ASM-BR-004: Khi quản lý theo course_id, assessment thuộc bối cảnh khóa học cụ thể.

## 1. Khái niệm assessment

Assessment là thành phần bài học dùng để thực hiện đánh giá theo tiêu chí hoặc theo cấu trúc đánh giá mở rộng.

Khác với homework hoặc exam thường tập trung vào câu hỏi và điểm số trực tiếp, assessment thiên về:
- Đánh giá theo tiêu chí
- Đánh giá theo nhóm tiêu chí
- Gắn với file nộp
- Gắn với báo cáo học tập

## 2. Quan hệ của assessment với các đối tượng khác

### 2.1. Quan hệ với bài học

Assessment là một thành phần bài học.

Assessment có thể được gắn vào bài học để đánh giá kết quả học tập hoặc năng lực của học sinh trong bối cảnh bài học đó.

### 2.2. Quan hệ với chương trình học

Assessment có thể là nội dung gốc được tạo trong phạm vi chương trình học.

Assessment ở cấp chương trình là thành phần chuẩn dùng để triển khai đánh giá theo cấu trúc đã thiết kế.

### 2.3. Quan hệ với khóa học

Assessment có thể được triển khai trong bối cảnh khóa học và gắn với:
- Khóa học
- Danh sách học sinh
- Kết quả chấm điểm
- Trạng thái công bố điểm

### 2.4. Quan hệ với tiêu chí đánh giá

Assessment có thể gắn với:
- Tiêu chí đánh giá
- Nhóm tiêu chí đánh giá
- Tiêu chí báo cáo học tập

Đây là lớp dữ liệu quan trọng giúp assessment không chỉ cho điểm mà còn hỗ trợ nhận xét có cấu trúc.

### 2.5. Quan hệ với tệp nộp và báo cáo

Assessment có thể đi kèm:
- File nộp
- File thông tin
- Báo cáo học tập
- Dữ liệu nhận xét theo học sinh

## 3. Assessment gồm những thông tin gì

Một assessment có thể bao gồm các nhóm thông tin sau:

### 3.1. Thông tin định danh

- Mã assessment
- Tên assessment
- Mô tả assessment

### 3.2. Thông tin tổ chức

- Loại assessment
- Chương trình học
- Bài học nếu được dùng trong bối cảnh bài học
- Môn học nếu có

### 3.3. Thông tin đánh giá

- Nhóm tiêu chí đánh giá
- Danh sách tiêu chí đánh giá
- Tiêu chí báo cáo học tập

### 3.4. Thông tin tài nguyên

- Tệp đính kèm
- Danh sách file

### 3.5. Thông tin vận hành

- Trạng thái giao hoặc gắn vào khóa học nếu có
- Trạng thái chấm điểm
- Trạng thái công bố điểm
- Kết quả theo học sinh

## 4. Vai trò của assessment trong học tập

Assessment là thành phần dành cho các hoạt động đánh giá có cấu trúc sâu hơn bài kiểm tra thông thường.

Assessment giúp:
- Đánh giá theo tiêu chí
- Hỗ trợ nhận xét có cấu trúc
- Gắn đánh giá với kỹ năng hoặc năng lực
- Tạo dữ liệu cho báo cáo học tập

## 5. CRUD assessment

### 5.1. Tạo assessment

Cho phép tạo assessment mới.

Thông tin thường cần khai báo:
- Tên assessment
- Mô tả
- Loại assessment
- Chương trình học
- Nhóm tiêu chí đánh giá
- Tiêu chí báo cáo học tập
- Môn học nếu có
- File đính kèm nếu có

### 5.2. Xem danh sách assessment

Cho phép xem danh sách assessment theo:
- Từ khóa
- Loại assessment
- Môn học
- Khóa học
- Khối lớp nếu có
- Phân trang

### 5.3. Xem chi tiết assessment

Cho phép xem chi tiết assessment, bao gồm:
- Thông tin chung
- Tiêu chí đánh giá
- File đính kèm
- Cấu hình liên quan tới báo cáo học tập

### 5.4. Cập nhật assessment

Cho phép cập nhật:
- Tên assessment
- Mô tả
- Loại assessment
- Tiêu chí đánh giá
- File đính kèm
- Môn học
- Cấu hình liên quan

### 5.5. Xóa assessment

Cho phép xóa assessment.

Khi xóa assessment, cần xem xét ảnh hưởng đến:
- Kết quả chấm điểm
- Báo cáo học tập
- Dữ liệu học sinh liên quan

## 6. Quy tắc quản lý assessment trong chương trình học

Trong phạm vi chương trình học:
- Được phép tạo assessment
- Được phép sửa assessment
- Được phép xóa assessment

Assessment ở cấp chương trình là nội dung gốc của bài học hoặc cấu trúc đánh giá chuẩn.

## 7. Quy tắc quản lý assessment khi có course_id

Khi thao tác trong bối cảnh có `course_id`:
- Được phép thêm assessment vào bài học
- Không làm thay đổi nội dung gốc đã có trong chương trình
- Không xóa nội dung gốc đã có trong chương trình

Trong bối cảnh khóa học, assessment được dùng để vận hành đánh giá cho nhóm học sinh cụ thể.

## 8. Chấm điểm assessment

Assessment hỗ trợ chấm điểm theo tiêu chí cho từng học sinh.

Kết quả chấm có thể bao gồm:
- Điểm tổng
- Điểm theo tiêu chí
- Điểm theo tiêu chí con
- File nộp của học sinh
- Trạng thái đã chấm hoặc chưa chấm

## 9. Công bố điểm assessment

Assessment có thể có trạng thái công bố điểm trong phạm vi khóa học.

Việc công bố điểm giúp:
- Kiểm soát thời điểm học sinh được xem kết quả
- Phân tách giữa chấm nội bộ và công bố chính thức

## 10. Báo cáo và dữ liệu theo học sinh

Assessment có thể được dùng để:
- Lấy danh sách học sinh theo assessment
- Theo dõi trạng thái chấm điểm
- Tạo báo cáo assessment
- Xuất dữ liệu báo cáo

Assessment cũng có liên hệ với dữ liệu báo cáo học tập theo tiêu chí.

## 11. Các tình huống nghiệp vụ chính

### 11.1. Tạo assessment trong chương trình học

Người dùng tạo assessment mới với cấu trúc tiêu chí đánh giá và các cấu hình liên quan.

### 11.2. Cập nhật assessment gốc

Người dùng điều chỉnh assessment chuẩn trong phạm vi chương trình học.

### 11.3. Thêm assessment trong bối cảnh khóa học

Khi bài học được mở với `course_id`, người dùng được thêm assessment để phục vụ riêng cho khóa học.

### 11.4. Chấm điểm assessment cho học sinh

Giáo viên hoặc người chấm nhập điểm theo tiêu chí cho từng học sinh trong khóa học.

### 11.5. Công bố điểm và tạo báo cáo

Sau khi chấm điểm, assessment có thể được công bố và sử dụng để tạo báo cáo đánh giá hoặc báo cáo học tập.

## Edge cases và điểm cần xác nhận

- Cần xác nhận backend có chặn xóa assessment đã có bài nộp, kết quả chấm hoặc báo cáo liên quan hay không.
- Cần xác nhận assessment trong chương trình học và assessment theo course_id có được đồng bộ hai chiều hay chỉ sao chép một lần.
- Cần xác nhận rule xử lý khi tiêu chí đánh giá bị thay đổi sau khi học sinh đã nộp bài.
- Cần xác nhận trạng thái assessment khi quá hạn, chưa chấm, đã chấm hoặc đã công bố kết quả.
