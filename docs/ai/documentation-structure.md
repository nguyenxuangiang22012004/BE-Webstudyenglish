# Cấu trúc tài liệu phục vụ AI

Status: reviewed
Owner: BA/DEV/TEST
Last reviewed: 2026-09-16
Related:
  - docs/ai/team-ai-overview.md
  - docs/ai/reading-guide.md
  - docs/requirements/overview.md
  - docs/design/overview.md
  - docs/testing/overview.md
  - docs/test-cases/overview.md

## Mục đích

Tài liệu này quy định cách tổ chức folder `docs/` để phục vụ việc sử dụng AI trong các công việc BA, DEV và TEST.

Mục tiêu chính:

- Giúp AI nhanh chóng hiểu đúng ngữ cảnh của project.
- Tách rõ tài liệu nghiệp vụ, thiết kế, điều kiện test, test case và hướng dẫn vận hành AI.
- Tạo liên kết truy vết giữa requirement, UI/design, API/security, code và test.
- Giảm việc AI suy đoán sai khi thiếu ngữ cảnh.
- Tạo một chuẩn chung để team cập nhật tài liệu khi requirement, UI, API hoặc code thay đổi.

## Nguyên tắc tổng quát

- `docs/ai/` không thay thế tài liệu nghiệp vụ, test case hay design. Folder này chỉ chứa workflow, checklist, prompt và quy ước để AI làm việc tốt hơn.
- `docs/requirements/` là nguồn mô tả nghiệp vụ theo domain/feature.
- `docs/design/` là nguồn mô tả UI/UX, layout, screen state và interaction.
- `docs/testing/` là nguồn mô tả điều kiện, dữ liệu và chuẩn kiểm thử dùng chung.
- `docs/test-cases/` là nơi lưu test case cụ thể có thể dùng cho manual QA, regression hoặc automation.
- Khi tài liệu liên quan trực tiếp mâu thuẫn với code đang chạy, AI ưu tiên tài liệu (hành vi kỳ vọng) và ghi nhận điểm lệch; code được xem là hiện trạng có thể đang lệch yêu cầu. Nếu tài liệu mơ hồ, lỗi thời hoặc mâu thuẫn với tài liệu khác, nêu giả định và hỏi lại.
- Khi nội dung nào chưa được xác minh, phải ghi rõ đó là giả định hoặc cần review.
- Tên file/folder nên dùng kebab-case và tiếng Anh để ổn định đường dẫn lâu dài.
- Nội dung bên trong file có thể viết bằng tiếng Việt nếu phù hợp với team.

## Cấu trúc đề xuất

```text
docs/
  ai/
    documentation-structure.md
    ba/
    dev/
    testing/
    prompts/
  requirements/
  design/
  api/
  security/
  testing/
  test-cases/
```

Ghi chú:

- `docs/api/` và `docs/security/` có thể tạo khi team cần tài liệu riêng cho API contract, RBAC, ownership hoặc security rules.
- Nếu requirement hiện tại đã chứa API/security trong từng domain, chưa bắt buộc phải tách ngay.
- Không đổi tên các folder hiện có chỉ vì chuẩn mới. Ưu tiên bổ sung dần để tránh tạo diff lớn.

## Vai trò từng folder

### `docs/ai/`

Chứa tài liệu vận hành AI.

Folder này trả lời câu hỏi:

> AI nên đọc gì, làm theo quy trình nào, dùng checklist nào và sinh output theo format nào?

Nội dung phù hợp:

- Quy ước cấu trúc tài liệu.
- Workflow cho AI BA, AI DEV, AI Tester.
- Prompt template dùng lại.
- Checklist phân tích requirement, code, bug, test case.
- Quy tắc khi tài liệu mâu thuẫn với code.
- Hướng dẫn AI tạo/cập nhật tài liệu mới.

Nội dung không nên đặt ở đây:

- Requirement nghiệp vụ chi tiết.
- Test case cụ thể của feature.
- API contract chi tiết của từng endpoint.
- Test account, test data hoặc thông tin môi trường.

### `docs/ai/ba/`

Chứa quy trình và template AI hỗ trợ PM/BA.

Hiện có:

- `ba-workflow.md`: điểm vào cho AI PM/BA.
- `templates/customer-request.md`: ghi nhận yêu cầu khách hàng có minh chứng.
- `templates/feature-requirement.md`: requirement cho feature mới.
- `templates/change-note.md`: change note cho thay đổi lớn trên chức năng đã có.

Có thể bổ sung sau: `requirement-review-checklist.md`.

Nội dung nên có:

- Cách tách requirement từ mô tả nghiệp vụ.
- Cách viết business rule có ID rõ ràng.
- Cách viết acceptance criteria.
- Cách phát hiện điểm mơ hồ, mâu thuẫn hoặc thiếu điều kiện biên.
- Cách mapping requirement với design, API, permission và test case.

### `docs/ai/dev/`

Chứa quy trình và template AI hỗ trợ DEV.

Hiện có:

- `dev-workflow.md`: điểm vào cho AI Dev FE/BE.

Có thể bổ sung sau:

- `code-reading-workflow.md`
- `implementation-checklist.md`
- `api-integration-checklist.md`
- `code-review-checklist.md`
- `refactor-checklist.md`

Nội dung nên có:

- Thứ tự đọc code trước khi sửa: route, layout, provider, feature component, shared component, hook/store, API/type.
- Checklist khi thêm UI.
- Checklist khi tích hợp API.
- Checklist khi sửa component dùng lại.
- Checklist review code và regression risk.

### `docs/ai/testing/`

Chứa quy trình và template AI hỗ trợ TEST/QA.

Folder này trả lời câu hỏi:

> AI Tester nên tạo test, phân tích coverage và sinh automation theo cách nào?

Ví dụ:

- `tester-workflow.md` (đã có: điểm vào cho AI Tester)
- `test-case-generation.md` (đã có)
- `manual-qa-checklist.md`
- `regression-checklist.md`
- `automation-generation.md`

Nội dung nên có:

- Cách tạo test case từ requirement/design/API.
- Cách phân loại functional, permission, validation, edge case, regression.
- Checklist đánh giá coverage.
- Quy ước sinh test case có ID, precondition, steps, expected result.
- Quy ước sinh automation test dựa trên `docs/testing/` và `docs/test-cases/`.

### `docs/ai/prompts/`

Chứa prompt template dùng lại cho AI.

Ví dụ:

- `analyze-requirement.md`
- `create-test-cases.md`
- `review-code.md`
- `analyze-bug.md`
- `create-regression-checklist.md`

Prompt nên ghi rõ:

- Input AI cần đọc.
- Output format mong muốn.
- Quy tắc xử lý khi thiếu thông tin.
- Cách ghi nhận giả định và câu hỏi cần làm rõ.

### `docs/requirements/`

Chứa tài liệu nghiệp vụ theo domain hoặc feature.

Folder này trả lời câu hỏi:

> Hệ thống cần làm gì và business rule là gì?

Nội dung nên có:

- Feature overview.
- Business rules có ID.
- Role/permission liên quan.
- User flow.
- State transition nếu có.
- Edge cases.
- Scoring rules hoặc calculation rules nếu có.
- Link sang design, API, security và test case liên quan.

Ví dụ:

```text
docs/requirements/
  requests/        # yêu cầu gốc của khách hàng khi có minh chứng
  flip-books/
    flip-book.md
  learning-materials/
    lesson.md
    vocabulary.md
  users/
    permission.md
```

### `docs/design/`

Chứa tài liệu UI/UX, screen behavior và interaction.

Folder này trả lời câu hỏi:

> Màn hình hiển thị và phản ứng như thế nào?

Nội dung nên có:

- Screen overview.
- UI elements quan trọng.
- Trạng thái loading, empty, error, success.
- Validation UI.
- Toast/message/confirm dialog.
- Responsive behavior nếu có.
- Link sang requirement và test case liên quan.

### `docs/api/`

Chứa API contract nếu team cần tách riêng khỏi requirement.

Folder này trả lời câu hỏi:

> FE/AI Tester cần gọi endpoint nào, request/response/error ra sao?

Nội dung nên có:

- Endpoint, method, path/query params.
- Header/cookie/auth requirement.
- Request payload.
- Response payload.
- Validation rules.
- Error responses.
- Side effects.
- Related business rules.

Ghi chú:

- Trong repo frontend này, code API hiện nằm chủ yếu ở `src/api/`, `src/types/`, config rewrite ở `next.config.ts`.
- Tài liệu trong `docs/api/` không thay thế code contract hiện tại; khi lệch nhau phải ghi rõ cần review.

### `docs/security/`

Chứa tài liệu về permission, RBAC, ownership và bảo mật dữ liệu nếu cần tách riêng.

Folder này trả lời câu hỏi:

> Ai được làm gì, với dữ liệu nào, trong điều kiện nào?

Nội dung nên có:

- RBAC matrix.
- Ownership rules.
- Route/page access.
- API access expectation.
- Data visibility rules.
- Security edge cases.

Nếu permission đã nằm trong `docs/requirements/users/permission.md`, có thể link về file đó thay vì duplicate.

### `docs/testing/`

Chứa test context và chuẩn kiểm thử dùng chung.

Folder này trả lời câu hỏi:

> AI Tester test ở đâu, dùng dữ liệu nào, login ra sao và viết automation theo chuẩn nào?

Nội dung phù hợp:

- `environments.md`: môi trường test, base URL, API URL, account scope.
- `test-data.md`: seed data, account test, data convention.
- `error-codes.md`: mã lỗi nội bộ và expected message.
- `bypass-login.md`: cách bypass login nếu được phép trong môi trường test.
- `automation-standard.md`: chuẩn viết automation, framework, selector, setup/teardown.

Nội dung không nên đặt ở đây:

- Test case chi tiết của từng feature. Phần đó đặt trong `docs/test-cases/`.
- Prompt hoặc workflow AI. Phần đó đặt trong `docs/ai/testing/`.

### `docs/test-cases/`

Chứa test case cụ thể theo feature/module.

Folder này trả lời câu hỏi:

> Cần kiểm thử những scenario nào và expected result là gì?

Nội dung nên có:

- Test case ID.
- Scenario.
- Preconditions.
- Steps.
- Expected results.
- Priority/severity nếu cần.
- Test type: functional, validation, permission, edge case, regression.
- Related requirement/business rule/design/API.
- Automation status nếu cần.

Ví dụ:

```text
docs/test-cases/
  auth/
    login.md
  flip-books/
    flip-book.md
  learning-materials/
    vocabulary.md
```

## Phân biệt các folder testing

```text
docs/ai/testing/  = cách AI Tester làm việc
docs/testing/     = điều kiện và chuẩn kiểm thử dùng chung
docs/test-cases/  = test case thật để thực thi
```

Ví dụ:

- Muốn biết cách AI sinh test case: đọc `docs/ai/testing/test-case-generation.md`.
- Muốn biết dùng account nào để test: đọc `docs/testing/test-data.md`.
- Muốn biết feature Flip Book cần test scenario nào: đọc `docs/test-cases/flip-books/flip-book.md`.

## Quy trình từ requirement ra test case

Quy trình chi tiết nằm trong `docs/ai/testing/test-case-generation.md`.

Luồng chuẩn:

```text
Requirement -> Business Rule -> Scenario -> Test Case -> Coverage Review
```

Khi AI Tester tạo test case, cần đọc requirement trước, sau đó đối chiếu thêm design, API, security và test context nếu có.

## Liên kết truy vết

Mỗi feature nên có thể truy vết theo chuỗi:

```text
Requirement -> Design -> API/Security -> Test Context -> Test Case -> Code
```

Khi tạo hoặc cập nhật tài liệu, nên bổ sung:

- Requirement hoặc business rule liên quan.
- Route/page/màn hình liên quan.
- Component/API/store/type liên quan nếu đã biết.
- Test case liên quan.
- Trạng thái tài liệu.

## Metadata bắt buộc cho tài liệu AI đọc

Mỗi file tài liệu quan trọng nên có metadata ngắn ở đầu file để AI biết độ tin cậy, owner và tài liệu liên quan trước khi đọc phần nội dung dài:

```text
Status: draft
Owner: BA/DEV/TEST
Last reviewed: YYYY-MM-DD
Source: code/swagger/user-input/design/assumption nếu có
Related:
  - docs/requirements/...
  - docs/design/...
  - docs/test-cases/...
```

Với file dùng YAML frontmatter, dùng các key tương đương:

```yaml
---
status: needs-review
owner: UX/DEV
last_reviewed: YYYY-MM-DD
source: figma/code/assumption
related:
  - ../requirements/...
---
```

`Status` trong metadata thể hiện **độ tin cậy của tài liệu**, không phải trạng thái task. Trạng thái task (`Draft`, `Ready for Dev`, `Ready for Test`, `Done`...) chỉ ghi trong `docs/requirements/change-log.md`, mục `Change Log` của file requirement và trên ClickUp.

Ý nghĩa trạng thái tài liệu:

- `draft`: đang phác thảo, chưa xác minh đầy đủ.
- `needs-review`: cần người phụ trách kiểm tra lại.
- `reviewed`: owner (BA/DEV/TEST) đã review nội dung.
- `code-observed`: mô tả được bóc tách từ code hiện tại, chưa được BA xác nhận là hành vi kỳ vọng.
- `verified`: đã đối chiếu với source hiện tại (code, API, khách hàng xác nhận).
- `outdated`: biết là đã lệch với code, requirement hoặc design mới.
- `generated`: sinh từ nguồn khác như Swagger hoặc permission dump; cần đọc `Source` và ưu tiên source gốc nếu có mâu thuẫn. Không sửa tay; sinh lại từ nguồn.

Tài liệu, template và test report có thể có trường `Status` riêng với ý nghĩa khác (ví dụ bug report `open/fixed/verified`); ý nghĩa đó được định nghĩa trong template tương ứng.

## Quy tắc cập nhật

- Khi requirement thay đổi, cập nhật `docs/requirements/` trước.
- Khi UI/UX thay đổi, cập nhật `docs/design/` và test case liên quan.
- Khi API contract thay đổi, cập nhật `docs/api/` nếu có, hoặc phần API trong requirement liên quan.
- Khi permission/security thay đổi, cập nhật `docs/security/` hoặc requirement permission liên quan.
- Khi test account, test data, environment hoặc automation standard thay đổi, cập nhật `docs/testing/`.
- Khi thêm/sửa scenario kiểm thử, cập nhật `docs/test-cases/`.
- Khi thay đổi cách AI làm việc, prompt hoặc checklist, cập nhật `docs/ai/`.
- Khi AI tạo tài liệu mới, phải ghi rõ phần đã xác minh và phần đang là giả định.

## Quy tắc bắt buộc nên áp dụng dần

- Mỗi business rule quan trọng nên có ID.
- Mỗi test case nên link về business rule hoặc requirement liên quan.
- UI element quan trọng cho automation nên có selector ổn định nếu code cho phép.
- API contract nên có request, response, validation và error response mẫu.
- Edge case quan trọng nên được ghi rõ trong requirement hoặc test case.
- Test data nên có khả năng tái sử dụng và có quy tắc setup/teardown.
- Không dùng mô tả quá định tính nếu có thể đưa ra điều kiện cụ thể.
