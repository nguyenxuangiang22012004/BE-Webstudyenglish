# Tài Liệu BA Chi Tiết: Thuộc Tính Câu Hỏi

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-06-12
Related:
  - docs/api/learning-materials/question-attribute.md
  - docs/security/resources/question-attributes.md
  - docs/requirements/learning-materials/question-bank.md
  - docs/test-cases/overview.md

Business rule IDs:
  - QAT-BR-001: Thuộc tính câu hỏi dùng để phân loại, lọc và đánh nhãn câu hỏi.
  - QAT-BR-002: Thuộc tính câu hỏi có thể có type/trạng thái theo dữ liệu API.
  - QAT-BR-003: Thuộc tính đã gắn vào câu hỏi cần được kiểm soát khi sửa hoặc xóa.

## 1. Khái niệm thuộc tính câu hỏi

Thuộc tính câu hỏi là dữ liệu phân loại câu hỏi, ví dụ nhóm năng lực, dạng kiến thức, cấp độ hoặc nhãn nghiệp vụ.

Thuộc tính giúp người dùng:
- Lọc câu hỏi trong question bank.
- Chọn câu hỏi phù hợp khi tạo homework/exam/assessment.
- Chuẩn hóa metadata để báo cáo hoặc phân tích chất lượng câu hỏi.

## 2. Phạm vi chức năng hiện có

API hiện có:
- `GET /v1/question-attributes`
- `POST /v1/question-attributes`
- `GET /v1/question-attributes/{id}`
- `PUT /v1/question-attributes/{id}`
- `DELETE /v1/question-attributes/{id}`

Danh sách hỗ trợ lọc theo `keyword`, `status`, `type` và sort theo id/created_at nếu API nhận.

## 3. Quan hệ với đối tượng khác

- Question: câu hỏi có thể gắn một hoặc nhiều thuộc tính.
- Subject: một số màn hình chọn thuộc tính câu hỏi theo môn học.
- Assessment/report criteria: thuộc tính có thể được dùng để phân nhóm đánh giá nếu nghiệp vụ cấu hình.

## 4. Quy tắc nghiệp vụ chính

- Thuộc tính phải có tên dễ hiểu và type rõ nếu type được dùng trong UI.
- Thuộc tính bị inactive không nên được chọn mới nếu backend/UI áp dụng rule trạng thái.
- Xóa thuộc tính đã gắn câu hỏi cần kiểm tra tác động đến question bank.

## 5. Quản lý tiêu chí phân loại câu hỏi

### 5.1. Danh sách tiêu chí phân loại câu hỏi

Danh sách tiêu chí phân loại câu hỏi là nơi người dùng xem và quản lý các nhóm tiêu chí dùng để phân loại câu hỏi trong hệ thống. Màn hình này hiển thị theo cấu trúc cây, cho phép nhìn thấy tiêu chí cha và các tiêu chí con bên dưới trong cùng một danh sách.

Tại danh sách, người dùng có thể xem nhanh các thông tin chính của từng tiêu chí như:
- Tên tiêu chí
- Mô tả tiêu chí
- Môn học áp dụng
- Cấu trúc tiêu chí cha/con nếu có

Danh sách này hỗ trợ người dùng:
- Rà soát lại các tiêu chí đang có trong hệ thống
- Mở rộng hoặc thu gọn từng nhóm tiêu chí để xem chi tiết bên trong
- Thêm mới tiêu chí ở cấp hiện tại
- Chỉnh sửa trực tiếp thông tin tiêu chí ngay trên danh sách
- Xóa tiêu chí khi không còn sử dụng
- Lưu lại toàn bộ thay đổi sau khi cập nhật

### 5.2. Thêm/Sửa tiêu chí phân loại câu hỏi

Chức năng thêm và sửa được thực hiện ngay trên màn danh sách tiêu chí. Người dùng có thể tạo mới một tiêu chí ở cấp gốc hoặc thêm một tiêu chí con bên dưới một tiêu chí hiện có. Đồng thời, người dùng cũng có thể sửa trực tiếp tên, mô tả và môn học áp dụng của từng tiêu chí ngay trong danh sách.

Khi thêm mới, người dùng nhập các thông tin cần thiết cho tiêu chí và có thể gắn tiêu chí đó với một hoặc nhiều môn học phù hợp. Khi sửa, người dùng cập nhật lại thông tin của tiêu chí hiện có nếu cần thay đổi tên, mô tả hoặc phạm vi môn học áp dụng.

Tiêu chí con chỉ được tạo trong phạm vi cấu trúc hiện có của tiêu chí cha. Khi một tiêu chí có tiêu chí con, hệ thống sẽ ưu tiên quản lý theo cây để giữ đúng quan hệ phân cấp giữa các nhóm tiêu chí.

Sau khi hoàn tất thêm hoặc sửa, người dùng chọn **Lưu** để hệ thống ghi nhận toàn bộ thay đổi.

## 6. Ghi chú và điểm cần xác nhận

- Cần xác nhận danh sách `type` hợp lệ.
- Cần xác nhận thuộc tính có dạng cây cha/con hay chỉ là danh sách phẳng.
- Cần xác nhận rule khi câu hỏi đang sử dụng thuộc tính bị xóa.
