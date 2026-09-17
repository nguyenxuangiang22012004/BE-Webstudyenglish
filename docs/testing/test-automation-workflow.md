# Test Automation Workflow

Status: draft
Owner: TEST
Related:
  - docs/workflows/feature-delivery-workflow.md
  - docs/testing/overview.md
  - docs/testing/environments.md
  - docs/testing/test-data.md
  - docs/requirements/change-log.md
  - docs/requirements/change-workflow.md
  - docs/test-cases/
  - docs/ai/testing/test-case-generation.md
  - docs/ai/testing/tester-workflow.md

## Mục đích

Tài liệu này mô tả luồng làm test automation cho tester trong dự án LMS frontend.

Mục tiêu là giúp tester hiểu:

- Khi nào cần đọc requirement, khi nào cần đọc code, khi nào cần chạy app.
- BMad hỗ trợ test automation ở bước nào.
- Playwright, API test, component test và CI nằm ở đâu trong workflow.
- Đầu vào và đầu ra cần có trước khi viết automation.

## Nguyên tắc chung

Test automation không bắt đầu từ việc viết code test ngay.

Luồng đúng nên là:

1. Hiểu feature cần test.
2. Xác định risk và phạm vi automation.
3. Chuẩn bị môi trường, account và test data.
4. Chọn loại test phù hợp.
5. Viết hoặc generate automation bằng AI/BMad.
6. Review test code.
7. Chạy test và debug.
8. Lưu test case, test report, bug report vào `docs/test-cases/`.
9. Đưa vào regression/CI.
10. Lưu traceability giữa requirement, test case và automation.

AI/BMad là trợ lý tăng tốc, không thay tester quyết định chất lượng test. Tester vẫn cần review selector, assertion, data, permission và mục tiêu business của từng case.

## Source of truth

Khi thông tin mâu thuẫn, ưu tiên theo thứ tự:

1. Tài liệu liên quan trực tiếp trong `docs/` — ưu tiên tài liệu gần feature hơn tài liệu tổng quan.
2. Code đang chạy trong repo.
3. Type, API module, constant, route, schema gần feature.
4. Test, story, usage thật.
5. Comment cũ hoặc suy luận của AI.

Tài liệu mô tả hành vi **kỳ vọng**; code là **hiện trạng triển khai**. Khi hai bên lệch nhau:

- Task kiểm tra/review/test: lấy tài liệu làm expected result, báo rõ điểm lệch (có thể là bug).
- Task sửa/implement: chỉnh code theo tài liệu.
- Ngoại lệ: tài liệu có `Status: generated` (kiểm tra `Source`), `needs-review`, `outdated`, mơ hồ hoặc mâu thuẫn với tài liệu khác → không tự bỏ qua, nêu rõ giả định và hỏi lại người phụ trách.

Nguồn chuẩn của quy tắc này là `AGENTS.md`.

Với automation UI, tester nên có FE repo và app chạy được. Chỉ có folder `docs/` là đủ để viết test plan sơ bộ, nhưng không đủ để viết automation ổn định.

## BMad test workflow

Repo này có hai nhóm workflow liên quan đến test.

AI Tester tự chọn skill theo loại task, xem bảng "Bước 1c" trong `docs/ai/testing/tester-workflow.md`. Phần dưới giải thích chi tiết từng workflow.

### Workflow nhanh cho automation sau khi build

Dùng khi feature đã implement và cần sinh API/E2E test:

```text
Build -> QA Automation Test -> Review/Run/Fix
```

Skill BMad:

- `bmad-qa-generate-e2e-tests`: generate automated API và end-to-end tests cho code đã implement.

Dùng workflow này khi:

- Cần viết test E2E cho một màn hình đã có code.
- Cần AI đọc code hiện tại và đề xuất test automation.
- Cần tạo test suite ban đầu cho regression.

Không dùng workflow này để review code feature. Nếu cần review code, dùng `bmad-code-review`.

### Workflow Test Architecture đầy đủ

Dùng khi team muốn thiết kế automation bài bản:

```text
Test Design -> Test Framework -> CI Setup -> ATDD -> Test Automation -> Test Review -> Traceability
```

Skill BMad:

- `bmad-testarch-test-design`: lập test design theo risk.
- `bmad-testarch-framework`: khởi tạo framework test, ví dụ Playwright cho web.
- `bmad-testarch-ci`: cấu hình pipeline để chạy test.
- `bmad-testarch-atdd`: tạo acceptance test scaffold trước implementation.
- `bmad-testarch-automate`: mở rộng automation coverage.
- `bmad-testarch-test-review`: review chất lượng test automation.
- `bmad-testarch-trace`: tạo traceability matrix và quality gate.

Dùng workflow này khi:

- Feature lớn, có nhiều role, permission, data state.
- Cần thiết kế coverage trước khi code.
- Cần đưa automation vào CI/CD.
- Cần chứng minh requirement nào đã có test bao phủ.

## Công cụ test trong repo

Tại thời điểm cập nhật (2026-09-16):

- `playwright` đã có trong `devDependencies`. Package này đã chứa test runner, import từ `playwright/test`; không cần cài thêm `@playwright/test`.
- `vitest` và `@vitest/browser` đã có trong `devDependencies`.
- `package.json` chưa có script `test`, `test:e2e` hoặc `test:unit`. Thêm script là thay đổi `package.json`, cần Dev/team đồng ý.
- Chưa có CI job chạy E2E.

Việc BMad có workflow test không có nghĩa là mọi công cụ đã được setup hoàn chỉnh. BMad giúp chọn, scaffold và viết test; tester/dev vẫn cần xác nhận tool đã được cài và có script chạy thật.

## Quy ước E2E Playwright

| Nội dung | Quy ước |
| --- | --- |
| Config | `tests/e2e/playwright.config.ts` |
| Test code | `tests/e2e/<domain>/<feature>.spec.ts` |
| Tên test | Bắt đầu bằng ID test case, ví dụ `AUTH-TC-001 - ...` |
| Test bug còn tồn tại | Assert hành vi kỳ vọng, gắn tag `@known-bug` |
| Base URL | Biến `E2E_BASE_URL`, mặc định `http://localhost:3000` (nhánh Local). Nhánh Public đặt URL public, xem `docs/testing/environments.md` |
| Password | Đọc từ `.env` (`TEST_*_PASSWORD`), không hard-code |
| Evidence | `_bmad-output/test-artifacts/e2e-results/` (gitignore) |

Chuẩn bị máy lần đầu:

```bash
npx playwright install chromium
```

Chọn nhánh chạy test theo `docs/testing/environments.md`:

- Code chưa deploy → **Nhánh 1: Local**.
- Code đã deploy lên bản public → **Nhánh 2: Public**.

### Nhánh 1: Chạy trên local

Bắt buộc dùng `http://localhost:3000` vì BE chỉ cho phép CORS từ port 3000. Không chạy test trên port khác.

Terminal 1, chạy app:

```bash
pnpm dev --port 3000
```

Nếu port 3000 bận, lệnh trên báo lỗi. Tắt tiến trình đang chiếm port rồi chạy lại, không đổi port.

Terminal 2, chạy test (không cần đặt `E2E_BASE_URL`):

```bash
npx playwright test -c tests/e2e
npx playwright test -c tests/e2e --grep @known-bug
```

### Nhánh 2: Chạy trên bản public

Không cần chạy `pnpm dev`. URL public hiện tại là `https://dev.xlms.vn` (nếu đổi, cập nhật bảng trong `docs/testing/environments.md`), truyền qua `E2E_BASE_URL` trên dòng lệnh.

Git Bash:

```bash
E2E_BASE_URL=https://dev.xlms.vn npx playwright test -c tests/e2e <file-hoặc-thư-mục>
```

PowerShell:

```powershell
$env:E2E_BASE_URL = "https://dev.xlms.vn"; npx playwright test -c tests/e2e <file-hoặc-thư-mục>
Remove-Item Env:E2E_BASE_URL
```

Lưu ý:

- Chỉ chạy test đọc dữ liệu hoặc có cleanup rõ ràng; không chạy cả bộ nếu trong đó có test tạo/sửa/xóa dữ liệu.
- Ưu tiên truyền `E2E_BASE_URL` trên dòng lệnh. Nếu đặt trong `.env`, các lần chạy sau sẽ chạy vào bản public, kể cả khi định chạy local; nhớ xóa hoặc comment lại sau khi dùng.
- Ghi Web URL và branch/version đang deploy vào test report.

### Bảo mật khi chạy automation

- Assertion không được in giá trị password, token, cookie ra report. Chỉ assert cờ có/không, hoặc tên key.
- Trace Playwright ghi lại giá trị nhập vào form, kể cả password. Không commit, không gửi trace/video ra ngoài team.
- Không dùng account test để thử sai mật khẩu nhiều lần (có thể bị khóa account). Case đăng nhập thất bại nên dùng username không tồn tại.

## Chọn loại test

### E2E/UI test

Dùng Playwright khi cần verify hành vi người dùng trên trình duyệt.

Phù hợp cho:

- Login/logout.
- Điều hướng route theo role.
- Preview bài giảng, xem video, đóng modal.
- Tạo/sửa/xóa dữ liệu qua UI.
- Regression cho workflow quan trọng.

Cần có:

- FE app chạy local ở `http://localhost:3000` hoặc URL bản public (xem `docs/testing/environments.md`).
- Account test.
- Test data ổn định.
- Selector ổn định, ưu tiên accessible role/name hoặc `data-testid` nếu cần.

### API test

Dùng khi cần verify contract, status code, response shape và permission của backend.

Cần có:

- API docs/OpenAPI/Postman collection hoặc BE repo.
- Base API URL của môi trường test.
- Auth/token flow.
- Test data và cleanup strategy.

### Component/unit test

Dùng Vitest/Testing Library khi cần test logic gần component hoặc helper.

Phù hợp cho:

- Parser/formatter.
- Conditional rendering.
- Hook/helper có input-output rõ.
- Component có nhiều state nhưng không cần browser flow đầy đủ.

Cần có FE repo và khả năng import component/hook cần test.

### Contract test

Dùng Pact hoặc công cụ tương đương khi FE và BE phát triển độc lập, cần đảm bảo API contract không bị vỡ.

Phù hợp cho:

- API quan trọng, thay đổi thường xuyên.
- Flow FE phụ thuộc nhiều vào shape response.
- Team FE/BE release khác nhịp.

## Luồng làm việc đề xuất cho tester

### Bước 1: Nhận scope

Đầu vào có thể là:

- Ticket/user story.
- Dòng thay đổi trong `docs/requirements/change-log.md`.
- Requirement trong `docs/requirements/`.
- Màn hình hoặc route cần test.
- Component/feature trong `src/components/features/`.
- Bug report cần regression.

Tester cần xác định:

- Feature nào cần test.
- Role nào liên quan.
- Môi trường nào sẽ chạy test.
- Data nào cần có sẵn.

### Bước 2: Đọc context

Với UI automation, đọc theo thứ tự:

1. `docs/requirements/change-log.md` để biết requirement nào vừa thay đổi.
2. Requirement gần feature trong `docs/requirements/`.
3. Route/page entry trong `src/app/`.
4. Feature component trong `src/components/features/`.
5. API module, type, store, hook liên quan.
6. Test data và environment trong `docs/testing/`.

Nếu code hiện tại khác tài liệu: dùng tài liệu làm expected result và ghi điểm lệch (có thể là bug). Vẫn phải đọc code để chọn selector và hiểu flow thực tế.

### Bước 3: Thiết kế test

Dùng `bmad-testarch-test-design` nếu cần test design bài bản.

Đầu ra nên có:

- Risk list.
- Test scope.
- Case nào automation, case nào manual.
- Priority P0/P1/P2.
- Loại test cho từng case: E2E, API, component, contract.

### Bước 4: Chuẩn bị framework

Dùng `bmad-testarch-framework` nếu repo chưa có test framework hoàn chỉnh.

Checklist:

- Playwright config đã có nếu làm E2E (`tests/e2e/playwright.config.ts`).
- Có lệnh chạy test rõ ràng (script trong `package.json` hoặc lệnh `npx` ghi trong tài liệu này).
- Browser dependencies đã cài.
- Base URL lấy từ env.
- Auth fixture không hard-code password.
- Trace/video/screenshot được cấu hình cho debug.

### Bước 5: Viết automation

Có hai cách:

- Dùng `bmad-qa-generate-e2e-tests` cho feature đã build xong.
- Dùng `bmad-testarch-automate` để mở rộng coverage trong workflow Test Architecture.

Prompt nên đưa cho AI/BMad:

```text
Hãy tạo Playwright E2E test cho feature [tên feature].
Nguồn cần đọc:
- route: [đường dẫn route/page]
- component: [đường dẫn component]
- requirement: [đường dẫn docs]
- test data: [account/data]

Cần cover:
- happy path
- permission/role nếu có
- loading/empty/error state nếu có
- assertion rõ ràng
- selector ổn định
```

### Bước 6: Review test code

Tester cần review:

- Test có assert đúng business behavior không.
- Selector có ổn định không.
- Test có phụ thuộc timing tùy tiện không.
- Test data có thể reset/cleanup không.
- Password/token có bị hard-code không.
- Test fail có dễ debug không.

Nếu cần review chuyên sâu, dùng `bmad-testarch-test-review`.

### Bước 7: Chạy và debug

Khi test fail:

1. Đọc error message.
2. Xem screenshot/video/trace nếu có.
3. Kiểm tra app có chạy đúng env không.
4. Kiểm tra account/test data.
5. Kiểm tra selector và assertion.
6. Nếu fail do bug sản phẩm, tạo bug report kèm evidence.
7. Nếu fail do test code, sửa test và chạy lại.

Không sửa assertion yếu đi chỉ để test pass.

### Bước 8: Lưu kết quả vào repo

Kết quả chỉ nằm trong chat hoặc `_bmad-output/` thì team không dùng lại được. Sau khi chạy test, phải ghi:

| Output | Vị trí |
| --- | --- |
| Test case (nếu chưa có hoặc có thay đổi) | `docs/test-cases/<domain>/<feature>.md` |
| Test report của lần chạy | `docs/test-cases/<domain>/reports/<yyyy-mm-dd>-<feature>.md` |
| Bug report | `docs/test-cases/<domain>/bugs/<BUG-ID>.md` |
| Automation code | `tests/e2e/<domain>/` |

Template nằm trong `docs/test-cases/overview.md`. Checklist hoàn thành nằm trong `docs/ai/testing/tester-workflow.md`.

Lưu ý về BMad: các skill như `bmad-qa-generate-e2e-tests` mặc định ghi summary vào `_bmad-output/`. Folder này bị gitignore nên chỉ xem là nháp; nội dung cần giữ phải chuyển sang các vị trí ở bảng trên.

### Bước 9: Đưa vào regression/CI

Dùng `bmad-testarch-ci` nếu cần setup pipeline.

Cần xác định:

- Test nào chạy trên mỗi pull request.
- Test nào chạy nightly.
- Test nào chạy manual khi release.
- Các flaky test được xử lý thế nào.
- Ai là owner khi test fail.

### Bước 10: Traceability

Dùng `bmad-testarch-trace` để map:

```text
Requirement -> Test case -> Automation file -> Result -> Quality gate
```

Traceability giúp team biết:

- Requirement nào đã có automation.
- Requirement nào chỉ test manual.
- Risk nào chưa được cover.
- Release có đang bị chặn bởi bug/test fail nào không.

## Ví dụ áp dụng cho lecture preview

Feature liên quan:

- `src/components/features/lecture-bank/preview-lecture.tsx`
- `src/components/features/lecture-bank/preview/components/content-player/index.tsx`
- `src/components/features/lecture-bank/content-overlay.tsx`

E2E cases có thể automation:

- Mở màn preview lecture thành công.
- Hiển thị đúng title và nội dung lecture.
- Content player render đúng loại nội dung: video, file, H5P hoặc nội dung text nếu feature hỗ trợ.
- Trạng thái loading không bị treo.
- Trạng thái empty/error hiển thị đúng.
- Nút đóng/back đưa người dùng về đúng màn hình trước.
- User không có quyền không xem được nội dung nếu có permission rule.

Đầu vào cần có:

- Route preview lecture.
- Lecture ID hợp lệ trên môi trường test.
- Account teacher/admin/student tùy scope.
- API hoặc seed data tạo lecture mẫu.

Prompt mẫu cho BMad/AI:

```text
Tạo Playwright E2E test cho lecture preview.
Hãy đọc route, component preview lecture và content player hiện tại.
Cần cover:
- mở preview với lecture hợp lệ
- kiểm tra title/nội dung/player hiển thị
- đóng preview
- empty/error state nếu code có xử lý

Dùng account test từ docs/testing/test-data.md.
Không hard-code password.
Nếu repo chưa có Playwright config/script, đề xuất thay đổi tối thiểu cần thêm.
```

## Definition of done cho test automation

Một automation case được xem là sẵn sàng khi:

- Chạy pass trên môi trường mục tiêu.
- Assert hành vi có ý nghĩa, không chỉ assert page load.
- Không hard-code secret.
- Data setup/cleanup rõ ràng.
- Fail message/evidence đủ để debug.
- Được review bởi tester/dev liên quan.
- Được gắn với requirement hoặc test case tương ứng.

## Khi nào không nên automation

Không nên automation ngay nếu:

- Requirement chưa ổn định.
- UI đang thay đổi liên tục.
- Test data không thể tạo lại.
- Flow phụ thuộc hệ thống ngoài chưa có mock/stub.
- Giá trị regression thấp hơn chi phí bảo trì.

Trong các trường hợp này, nên viết manual test case trước, hoặc chỉ automation phần API/helper ổn định.
