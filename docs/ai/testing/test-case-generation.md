# Quy trình tạo test case từ requirement

Status: draft
Owner: TEST
Related:
  - docs/ai/documentation-structure.md
  - docs/requirements/change-log.md
  - docs/requirements/change-workflow.md
  - docs/requirements/
  - docs/design/
  - docs/api/
  - docs/security/
  - docs/testing/
  - docs/test-cases/

## Mục đích

Tài liệu này hướng dẫn AI Tester tạo test case từ requirement một cách có truy vết, có coverage rõ ràng và có thể dùng tiếp cho manual QA hoặc automation.

Đầu ra cuối cùng phải được lưu trong `docs/test-cases/` theo domain/feature tương ứng.

Phân loại task, giới hạn vai trò và Definition of Done nằm trong `docs/ai/testing/tester-workflow.md`. Đọc file đó trước file này.

## Input cần đọc

Khi tạo test case cho một feature, AI Tester nên đọc theo thứ tự:

1. Requirement liên quan trong `docs/requirements/`.
2. Design/UI behavior liên quan trong `docs/design/` nếu có.
3. API contract liên quan trong `docs/api/` nếu feature có gọi API.
4. Permission/RBAC liên quan trong `docs/security/` nếu feature phụ thuộc role/quyền.
5. Test context trong `docs/testing/`, gồm môi trường, test data, error codes và automation standard.
6. Test case hiện có trong `docs/test-cases/` để tránh trùng lặp và xác định regression impact.

Nếu thiếu một nguồn tài liệu, AI Tester vẫn có thể tạo bản draft nhưng phải ghi rõ phần nào là giả định hoặc cần review.

Nếu task là thay đổi trên chức năng đã tồn tại, AI Tester phải đọc `docs/requirements/change-log.md` trước để xác định file requirement nào vừa đổi, `Test impact` là gì và task đang ở trạng thái nào.

## Khi input là bug hoặc security finding

Khi task bắt đầu từ mô tả bug/finding thay vì requirement:

1. Chuyển mô tả bug thành expected behavior có thể kiểm thử.
2. Tìm business rule tương ứng trong requirement domain. Nếu có, link rule đó. Nếu chưa có, đề xuất rule tạm (ví dụ `AUTH-BR-NEW-01`) và đánh dấu `needs-review` cho BA.
3. Tạo ít nhất:
   - Case xác nhận bug gốc đã được fix.
   - Case regression cho flow chạm tới phần code đã sửa.
   - Case cho bug liên quan còn sót nếu phát hiện trong quá trình đọc code/chạy test.
4. Trong `Notes` của test case, ghi nguồn bug (ticket, báo cáo pentest, commit fix).

## Quy trình

### 1. Xác định phạm vi feature

AI Tester cần xác định:

- Feature/module đang test.
- Route hoặc màn hình liên quan nếu đã biết.
- Role người dùng liên quan.
- Requirement source.
- Design/API/security source liên quan.

### 2. Tách business rule

Từ requirement, tách các rule có thể kiểm thử được.

Mỗi rule nên có:

- Rule ID.
- Mô tả ngắn gọn.
- Điều kiện áp dụng.
- Kết quả mong đợi.
- Role/permission liên quan nếu có.

Nếu requirement chưa có Rule ID, AI Tester có thể đề xuất ID tạm thời và đánh dấu `needs-review`.

Ví dụ:

```text
BR-FB-001: Admin có thể tạo flip book khi nhập đầy đủ thông tin bắt buộc.
BR-FB-002: User không có quyền store books không được tạo flip book.
```

### 3. Tạo scenario kiểm thử

Với mỗi business rule, tạo scenario theo các nhóm:

- Happy path.
- Validation.
- Permission/RBAC.
- Empty/loading/error state.
- Edge case.
- Regression.
- API error hoặc network error nếu có.

Không chỉ tạo case thành công. Mỗi rule quan trọng nên có ít nhất một case kiểm thử thất bại hoặc điều kiện biên nếu phù hợp.

### 4. Đối chiếu design

Khi có tài liệu design, AI Tester cần kiểm tra:

- UI element nào cần thao tác.
- Form field nào cần validation.
- Button/action nào bị disabled/hidden theo state.
- Toast, dialog, empty state, error state nào cần verify.
- Responsive behavior có ảnh hưởng test không.

Nếu design yêu cầu selector ổn định cho automation nhưng code/tài liệu chưa có, ghi `needs-review`.

### 5. Đối chiếu API

Khi feature gọi API, AI Tester cần kiểm tra:

- Endpoint/method liên quan.
- Request payload.
- Response payload.
- Validation error.
- Permission error.
- Side effect sau khi API thành công.

Test case nên ghi rõ expected result ở mức người dùng nhìn thấy, không chỉ ghi status code.

### 6. Đối chiếu security

Khi feature phụ thuộc role hoặc permission, AI Tester cần đọc `docs/security/`.

Test case nên bao gồm:

- Role có quyền thực hiện action.
- Role không có quyền thực hiện action.
- Resource/action liên quan, ví dụ `books.store`, `users.index`, `courses.destroy`.
- Expected UI/API behavior khi không có quyền.

### 7. Kiểm tra test context

Trước khi viết test case cuối cùng, kiểm tra `docs/testing/` để biết:

- Test environment.
- Account hoặc role dùng để test.
- Seed data có sẵn.
- Quy tắc tạo/xóa dữ liệu test.
- Error code/message kỳ vọng.
- Automation standard nếu case sẽ tự động hóa.

Nếu test data chưa có, test case phải ghi rõ data cần chuẩn bị.

### 8. Viết test case

Test case nên có format tối thiểu:

```text
## TC-ID - Scenario

Status: draft
Priority: high/medium/low
Type: functional/validation/permission/edge-case/regression
Related:
  - Requirement: docs/requirements/...
  - Business rule: BR-...
  - Design: docs/design/...
  - API: docs/api/...
  - Security: docs/security/...

### Preconditions

### Test Data

### Steps

### Expected Results

### Notes
```

### 9. Kiểm tra coverage

Sau khi tạo test case, AI Tester cần kiểm tra:

- Mỗi business rule quan trọng đã có test case chưa.
- Mỗi role/permission quan trọng đã có case allow/deny chưa.
- Mỗi validation rule quan trọng đã có case hợp lệ/không hợp lệ chưa.
- Mỗi API error quan trọng đã có expected UI behavior chưa.
- Edge case quan trọng đã được cover chưa.
- Test case có bị trùng scenario hiện có không.

## Quy tắc đặt ID

Đề xuất format:

```text
<MODULE>-TC-<NUMBER>
```

Ví dụ:

- `AUTH-TC-001`
- `FB-TC-001`
- `USER-TC-001`
- `VOCAB-TC-001`

Nếu module đã có quy ước riêng trong `docs/test-cases/`, ưu tiên quy ước hiện có.

## Output mong muốn

AI Tester phải tạo hoặc cập nhật file trong `docs/test-cases/` theo domain/feature. Nếu đã chạy test hoặc phát hiện bug, tạo thêm test report và bug report theo template trong `docs/test-cases/overview.md`.

Ví dụ:

```text
docs/test-cases/
  flip-books/
    flip-book.md
  users/
    permission.md
  learning-materials/
    vocabulary.md
```

Mỗi file test case nên có phần `Related Documents` để liên kết ngược về requirement, design, API và security.

## Khi thiếu thông tin

Nếu thiếu thông tin, AI Tester không được tự kết luận là hệ thống hoạt động theo suy đoán.

Cách ghi nhận:

- `Assumption`: giả định được dùng để viết draft.
- `Needs review`: điểm cần BA/DEV/QA xác minh.
- `Blocked`: không thể viết test case có ý nghĩa nếu thiếu thông tin cốt lõi.

