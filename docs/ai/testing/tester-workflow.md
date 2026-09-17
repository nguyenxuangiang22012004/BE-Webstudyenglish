# AI Tester Workflow

Status: reviewed
Owner: TEST
Last reviewed: 2026-09-16
Related:
  - AGENTS.md
  - docs/ai/reading-guide.md
  - docs/ai/testing/test-case-generation.md
  - docs/workflows/feature-delivery-workflow.md
  - docs/requirements/change-log.md
  - docs/testing/test-automation-workflow.md
  - docs/testing/environments.md
  - docs/testing/test-data.md
  - docs/test-cases/overview.md

## Mục đích

Đây là điểm vào duy nhất cho AI khi được giao vai trò Tester/QA.

Tài liệu trả lời 4 câu hỏi:

1. Task test thuộc loại nào?
2. Cần đọc gì trước khi test?
3. Được làm gì và không được làm gì?
4. Output nào phải có trong repo thì task mới được xem là xong?

Chi tiết cách viết test case nằm ở `docs/ai/testing/test-case-generation.md`. Chi tiết automation nằm ở `docs/testing/test-automation-workflow.md`.

## Quy tắc bắt buộc của vai trò Tester

- Không sửa source code sản phẩm (`src/`, `messages/`, `public/`), config build, `package.json`, `pnpm-lock.yaml`, `.env`.
- Được phép tạo/sửa: test code trong `tests/`, tài liệu trong `docs/test-cases/`, và đề xuất cập nhật `docs/testing/` khi thiếu test context.
- Khi phát hiện bug: ghi bug report kèm evidence, **không tự fix** và không đề nghị fix thay Dev.
- Khi requirement thiếu rule để làm tiêu chí test: ghi `needs-review` cho BA, không tự chốt nghiệp vụ.
- Không ghi password, token, cookie thật vào tài liệu, test code, bug report hoặc log/report của test.
- Output của BMad skill trong `_bmad-output/` là **nháp cục bộ** (folder bị gitignore, team không nhìn thấy). Kết quả chính thức phải ghi vào `docs/test-cases/` và `tests/`.

## Bước 1: Phân loại task

| Loại task | Dấu hiệu | Điểm bắt đầu |
| --- | --- | --- |
| A. Test thay đổi requirement/feature | Có task ID, có dòng trong `change-log.md` | `docs/requirements/change-log.md` |
| B. Verify bug hoặc security finding | Prompt mô tả lỗi/finding, hỏi "đã fix chưa", "còn bug không" | Mô tả bug + code/commit fix |
| C. Viết/mở rộng automation | Prompt yêu cầu Playwright/E2E/API test, chạy automation | Test case hiện có trong `docs/test-cases/` |
| D. Regression trước release | Yêu cầu chạy lại bộ test theo release/version | `docs/test-cases/<domain>/` + `tests/` |

Một prompt có thể gồm nhiều loại, ví dụ B rồi C. Làm lần lượt và gom output theo checklist ở cuối.

## Bước 1b: Xác định nhánh môi trường

Chi tiết URL, account và lưu ý của từng nhánh nằm trong `docs/testing/environments.md`.

| Nhánh | Người viết prompt chọn khi | Web URL |
| --- | --- | --- |
| Local | Code cần test chưa merge vào `develop` hoặc chưa deploy (branch fix bug, feature đang dev) | `http://localhost:3000`, không dùng port khác |
| Public | Code đã merge vào `develop` và đã deploy | `https://dev.xlms.vn` |

Cách xác định (không tự kiểm tra git để suy ra nhánh):

1. Đọc dòng `Môi trường test: Local` hoặc `Môi trường test: Public` trong prompt và chạy đúng nhánh đó.
2. Prompt không ghi → mặc định **Local**, nêu rõ trong câu trả lời là đang dùng mặc định.
3. Local test code đang checkout trên máy; Public test bản đã deploy. Người viết prompt chịu trách nhiệm chọn nhánh phù hợp với code cần test.

Ghi nhánh, Web URL và branch/commit vào test report và bug report.

## Bước 1c: Chọn skill BMad theo loại task

AI tự chọn skill theo bảng dưới, tester không cần ghi tên skill trong prompt.

| Loại task | Skill BMad | Ghi chú |
| --- | --- | --- |
| A. Test thay đổi requirement/feature | `bmad-testarch-test-design` | Chỉ dùng khi feature có nhiều role/permission/data state hoặc cần phân loại Manual/Automation. Feature nhỏ: viết test case trực tiếp. |
| B. Verify bug hoặc security finding | Không dùng | Test trực tiếp để tiết kiệm thời gian và token. |
| C. Viết/mở rộng automation | `bmad-qa-generate-e2e-tests` (feature đã có code, chưa có E2E) hoặc `bmad-testarch-automate` (mở rộng coverage đã có), sau đó `bmad-testarch-test-review` | Review test trước khi ghi kết quả chạy vào report. |
| D. Regression trước release | `bmad-testarch-trace` | Map requirement → test case → automation → kết quả. |

Quy tắc khi dùng skill:

- Prompt ghi `Không dùng BMad` → bỏ qua bảng trên, làm trực tiếp.
- Prompt ghi tên skill cụ thể → dùng skill đó thay cho bảng trên.
- Skill hỏi thông tin đã có trong `docs/` → tự lấy từ tài liệu, chỉ hỏi người dùng khi tài liệu không có.
- Output skill ghi vào `_bmad-output/` là nháp; chuyển nội dung cần giữ sang `docs/test-cases/` và `tests/` theo Bước 4.
- Nhánh môi trường vẫn theo Bước 1b, không để skill tự chọn URL.

## Bước 2: Đọc context theo loại task

### Loại A — Thay đổi requirement/feature

1. `docs/requirements/change-log.md` → lấy file requirement, `Test impact`, `Status`.
2. Requirement liên quan trong `docs/requirements/`.
3. Design/API/security được link trong `Related`.
4. `docs/testing/environments.md`, `docs/testing/test-data.md`.
5. Test case hiện có trong `docs/test-cases/<domain>/`.
6. Code route/component liên quan để xác minh hành vi thực tế.

### Loại B — Verify bug hoặc security finding

1. Mô tả bug/finding gốc: hành vi sai, mức độ, điều kiện tái hiện.
2. Xác định domain và requirement liên quan trong `docs/requirements/<domain>/`.
   - Nếu requirement chưa có rule mô tả hành vi đúng → ghi `needs-review` cho BA bổ sung rule, dùng expected behavior hợp lý nhất làm giả định và ghi rõ là giả định.
3. `docs/requirements/change-log.md`: kiểm tra đã có dòng cho bug fix chưa. Nếu chưa có, ghi nhận vào report (không tự thêm dòng thay BA/Dev).
4. Code và lịch sử fix: tìm commit/branch fix (`git log` theo file liên quan), kiểm tra fix đã vào branch/môi trường nào (ví dụ đã merge `develop` chưa).
5. Đọc flow liên quan xung quanh fix (provider, middleware, API route, storage) để tìm bug còn sót hoặc regression.
6. `docs/security/` nếu là finding bảo mật/phân quyền.
7. `docs/testing/` và `docs/test-cases/<domain>/` như loại A.

### Loại C — Automation

1. Test case trong `docs/test-cases/<domain>/`. Nếu chưa có, tạo test case trước (theo loại A/B) rồi mới viết automation.
2. `docs/testing/test-automation-workflow.md` (vị trí code, cách chạy, bảo mật evidence).
3. `docs/testing/environments.md`, `docs/testing/test-data.md`.
4. Route/component để chọn selector ổn định.

### Loại D — Regression

1. Test case và report gần nhất trong `docs/test-cases/<domain>/`.
2. `docs/requirements/change-log.md` để biết thay đổi từ lần regression trước.

## Bước 3: Thực hiện

- Test case: viết theo format trong `docs/test-cases/overview.md`, ID `<MODULE>-TC-<NUMBER>`.
- Automation: đặt trong `tests/e2e/<domain>/`, mỗi test ghi ID test case tương ứng trong tên test.
- Test kiểm tra bug còn tồn tại vẫn assert **hành vi kỳ vọng** và gắn tag `@known-bug`; fail nghĩa là bug còn. Không nới assertion để test pass.
- Khi test fail: phân biệt fail do test code (sửa test), do môi trường/data (ghi Blocked), hay do sản phẩm (ghi bug).

## Bước 4: Ghi output vào repo

| Output | Vị trí | Bắt buộc khi |
| --- | --- | --- |
| Test case | `docs/test-cases/<domain>/<feature>.md` | Mọi loại task |
| Bug report | `docs/test-cases/<domain>/bugs/<BUG-ID>.md` | Có bug mới hoặc bug còn tồn tại |
| Test report | `docs/test-cases/<domain>/reports/<yyyy-mm-dd>-<feature>.md` | Đã chạy test (manual hoặc automation) |
| Traceability | `docs/test-cases/<domain>/traceability.md` | Feature có business rule ID |
| Automation code | `tests/e2e/<domain>/*.spec.ts` | Loại C, hoặc `Test impact` có Automation |
| Test context thiếu | Ghi đề xuất trong report, mục `Needs review` | Thiếu account, data, env |

Template test case, bug report và test report nằm trong `docs/test-cases/overview.md`.

## Definition of Done cho AI Tester

Trước khi báo hoàn thành, kiểm tra đủ:

- [ ] Đã phân loại task, chọn nhánh môi trường (Bước 1b), chọn skill BMad (Bước 1c) và đọc đúng nguồn theo Bước 2.
- [ ] Test case đã có/được cập nhật trong `docs/test-cases/<domain>/`, link về requirement hoặc business rule.
- [ ] Nếu đã chạy test: có test report với nhánh môi trường (Local/Public) và Web URL, branch/commit, account (không kèm password), kết quả từng case, vị trí evidence.
- [ ] Mỗi bug có bug report riêng: steps, expected, actual, severity, evidence, trạng thái.
- [ ] Automation (nếu có) nằm trong `tests/e2e/<domain>/`, có lệnh chạy trong report, không hard-code secret, report không in token/password.
- [ ] Điểm thiếu requirement/test data được ghi `needs-review` kèm người cần xác nhận (BA/Dev).
- [ ] Không sửa source code sản phẩm.
- [ ] Câu trả lời cuối cùng cho người dùng liệt kê các file đã tạo/cập nhật.

## Prompt mẫu

Verify bug:

```text
Bạn đóng vai Tester. Đọc docs/ai/testing/tester-workflow.md.
Verify bug: "<mô tả bug>".
Môi trường test: <Local | Public>.
Kiểm tra đã fix chưa, fix nằm ở branch nào, còn bug liên quan không.
Ghi test case, bug report và test report vào docs/test-cases theo đúng quy ước.
Không sửa source code.
```

Automation:

```text
Bạn đóng vai Tester. Đọc docs/ai/testing/tester-workflow.md và docs/testing/test-automation-workflow.md.
Viết Playwright E2E cho test case trong docs/test-cases/<domain>/<feature>.md và chạy.
Môi trường test: <Local | Public>.
Cập nhật test report và bug report theo kết quả chạy.
```
