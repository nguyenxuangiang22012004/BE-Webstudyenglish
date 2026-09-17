# AI Dev Workflow (FE/BE)

Status: reviewed
Owner: DEV
Last reviewed: 2026-09-16
Related:
  - AGENTS.md
  - README.md
  - docs/ai/reading-guide.md
  - docs/workflows/api-contract-workflow.md
  - docs/workflows/feature-delivery-workflow.md
  - docs/requirements/change-log.md
  - docs/requirements/change-workflow.md
  - docs/ai/ba/ba-workflow.md
  - docs/ai/testing/tester-workflow.md

## Mục đích

Đây là điểm vào cho AI khi được giao vai trò Dev FE hoặc Dev BE trong repo này.

Tài liệu trả lời:

1. Task dev thuộc loại nào, khi nào được bắt đầu?
2. Dev FE và Dev BE làm gì trong repo này?
3. Cần kiểm tra gì trước khi tạo PR?
4. Bàn giao gì cho Tester và cập nhật tài liệu nào?

Quy tắc đọc code, ưu tiên tài liệu và quy tắc sửa code theo khu vực nằm trong `AGENTS.md`; tài liệu này không lặp lại.

## Phân vai

| Vai trò | Làm việc trong repo này | Không làm |
| --- | --- | --- |
| Dev FE | Implement UI, routing, tích hợp API trong `src/`, i18n trong `messages/`, test gần code; cập nhật tài liệu khi behavior thay đổi | Tự chốt nghiệp vụ; tự đổi contract API; sửa tay `docs/api/`, `docs/security/` |
| Dev BE | Review và xác nhận API/quyền đề xuất trong requirement; sinh lại `docs/api/`, `docs/security/` sau khi deploy | Sửa code FE; sửa nghiệp vụ trong requirement mà không có PM/BA review |

Nếu prompt không nói rõ FE hay BE, mặc định là Dev FE.

## Bước 1: Phân loại task

| Loại | Dấu hiệu | Điểm bắt đầu |
| --- | --- | --- |
| A. Implement feature/thay đổi | ClickUp task, change-log `Ready for Dev` | Requirement/change note trong change-log |
| B. Fix bug | Bug report trong `docs/test-cases/<domain>/bugs/` hoặc ClickUp | Bug report + requirement domain |
| C. Xác nhận API/quyền (BE) | Requirement có API/quyền `proposed` | `docs/workflows/api-contract-workflow.md` |
| D. Sinh lại tài liệu API/quyền (BE) | BE đã deploy thay đổi contract/quyền | `docs/workflows/api-contract-workflow.md` mục "Sinh lại" |
| E. Hotfix khẩn cấp | Lỗi production cần sửa ngay, chưa kịp có requirement/bug report | Mô tả lỗi; bổ sung tài liệu ngay sau khi fix |

## Bước 1b: Chọn skill BMad theo loại task

AI tự chọn skill theo bảng dưới, người dùng không cần ghi tên skill trong prompt.

| Loại task | Skill BMad | Ghi chú |
| --- | --- | --- |
| A. Implement feature/thay đổi | `bmad-build`, trước khi soạn PR chạy `bmad-code-review` | Vẫn phải qua Bước 2 (điều kiện bắt đầu) trước khi gọi skill. |
| B. Fix bug | Làm trực tiếp | Bug lớn, sửa nhiều file/khu vực: dùng `bmad-build`. |
| C. Xác nhận API/quyền (BE) | Không dùng | Theo `docs/workflows/api-contract-workflow.md`. |
| D. Sinh lại tài liệu API/quyền (BE) | Không dùng | Theo `docs/workflows/api-contract-workflow.md`. |
| E. Hotfix khẩn cấp | Không dùng | Ưu tiên tốc độ; bổ sung tài liệu sau khi fix. |

Quy tắc khi dùng skill:

- Prompt ghi `Không dùng BMad` → bỏ qua bảng trên, làm trực tiếp (kể cả khi skill có thể tự kích hoạt).
- Prompt ghi tên skill cụ thể → dùng skill đó thay cho bảng trên.
- Skill hỏi thông tin đã có trong `docs/` → tự lấy từ tài liệu, chỉ hỏi người dùng khi tài liệu không có.
- Quy tắc trong tài liệu này và `AGENTS.md` (branch, commit, i18n, không sửa `package.json`/`.env`, template PR) vẫn áp dụng khi chạy skill.
- Output skill ghi vào `_bmad-output/` là nháp; nội dung cần giữ phải đưa vào code, `docs/` hoặc mô tả PR.

## Bước 2: Kiểm tra điều kiện bắt đầu

Loại A — không bắt đầu implement nếu thiếu một trong các điều kiện sau; báo lại PM/BA:

- Có ClickUp Task ID và dòng `change-log.md` ở trạng thái `Ready for Dev` (hoặc `In Dev`).
- Requirement/change note có acceptance criteria.
- API cần dùng đã `confirmed-by-BE` hoặc `implemented`. Nếu mới `proposed`, chỉ làm phần UI/mock khi requirement ghi rõ cho phép làm song song.
- Không còn open question chặn.
- Tài liệu không ở trạng thái `needs-review`/`outdated` cho phần cần implement. Nếu nghi tài liệu lỗi thời, hỏi PM/BA trước khi code theo nó.

Loại B:

- Bug report có steps, expected, actual. Expected phải dựa trên requirement; nếu requirement chưa mô tả, báo PM/BA bổ sung rule.

Loại E:

- Được sửa trước, nhưng trong cùng ngày phải bổ sung: bug report, dòng change-log `Bug fix`/`Security fix`, và cập nhật requirement nếu hành vi đổi.

## Bước 3: Đọc context (Dev FE)

1. `AGENTS.md` (quy tắc đọc code, ưu tiên tài liệu, quy tắc theo khu vực).
2. Dòng `change-log.md` của task → requirement/change note được link.
3. Link `Related`: design, `docs/api/`, `docs/security/`.
4. Bug report và test case liên quan trong `docs/test-cases/<domain>/` (loại B, hoặc để biết Tester sẽ verify gì).
5. Code theo thứ tự trong `AGENTS.md`: route → layout/provider/middleware → feature component → shared → hook/store/API/type → i18n.

Dev BE (loại C, D) đọc: requirement mục API/quyền đề xuất, `docs/api/<domain>/`, `docs/security/`, `docs/workflows/api-contract-workflow.md`.

## Bước 4: Implement (Dev FE)

- Branch tạo từ `develop`. Tên branch nên chứa ClickUp ID, ví dụ `CU-86c1ab2de-export-progress-report`.
- Commit message nên có ClickUp ID ở đầu, ví dụ `CU-86c1ab2de: thêm xuất báo cáo tiến độ`.
- Bám acceptance criteria; mỗi AC phải có phần code tương ứng hoặc ghi rõ lý do chưa làm.
- Text UI mới: thêm cả `messages/vi.json` và `messages/en.json`.
- API lệch requirement khi tích hợp: dừng phần bị ảnh hưởng, báo theo `docs/workflows/api-contract-workflow.md`; không tự đổi logic để khớp API lệch.
- Không sửa `package.json`, `pnpm-lock.yaml`, `.env`, config build/Sentry nếu task không yêu cầu.

## Bước 5: Tự kiểm tra trước PR

| Kiểm tra | Lệnh | Bắt buộc |
| --- | --- | --- |
| Type check | `pnpm exec tsc --noEmit` | Có |
| Lint file đã sửa | `pnpm exec eslint <file-or-dir>` | Có (CI chạy `pnpm lint` trên PR vào `develop`/`main`) |
| Build | `pnpm build` | Khi đổi route, config, middleware, dependency |
| Chạy app kiểm tra AC | `pnpm dev --port 3000` + account trong `docs/testing/test-data.md` | Có với thay đổi UI/flow |
| E2E liên quan | `npx playwright test -c tests/e2e --grep <domain>` | Khi `tests/e2e/<domain>/` đã có test |

Chạy app bắt buộc ở `http://localhost:3000` vì BE chỉ cho phép CORS từ port 3000. Port bận thì tắt tiến trình đang chiếm port, không đổi port. Chi tiết: `docs/testing/environments.md`.

Pre-commit (husky + lint-staged) tự chạy `eslint --fix` và `prettier` cho file staged. Nếu lỗi type/lint đã tồn tại từ trước và không liên quan task, ghi rõ trong PR thay vì sửa lan rộng.

## Bước 6: Cập nhật tài liệu

Theo `AGENTS.md`, sau khi sửa code phải kiểm tra tài liệu liên quan:

| Thay đổi | Cập nhật |
| --- | --- |
| Behavior/user flow khác requirement đã chốt (đã được PM/BA đồng ý) | PM/BA cập nhật requirement; Dev ghi rõ trong PR |
| Fix bug | Bug report: `Status: fixed`, branch/commit fix; dòng change-log `Bug fix`/`Security fix` nếu chưa có |
| API mới/đổi đã deploy | Dev BE sinh lại `docs/api/` theo `api-contract-workflow.md` |
| Quyền mới/đổi | Dev BE sinh lại `docs/security/` |
| Account/env/test data mới cho test | `docs/testing/` |
| Không đổi behavior | Ghi trong PR: "Không cập nhật docs vì thay đổi không làm đổi behavior/tài liệu hiện có." |

Dev không tự viết lại business rule; đề xuất thay đổi cho PM/BA.

## Bước 7: Bàn giao cho Tester (PR)

PR vào `develop`, tiêu đề bắt đầu bằng ClickUp ID. Mô tả PR:

```md
## Task
- ClickUp: CU-<task-id> (<link>)
- Requirement: docs/requirements/<domain>/<file>.md
- Bug report (nếu có): docs/test-cases/<domain>/bugs/<BUG-ID>.md

## Thay đổi chính
-

## Acceptance criteria
| AC | Trạng thái | Ghi chú |
| --- | --- | --- |
| AC-01 | Done/Partial/Not done |  |

## API/phân quyền phụ thuộc
- <endpoint> – confirmed-by-BE/implemented – môi trường đã có: dev/test

## Cách test nhanh
- Môi trường test đề xuất: Local (branch <tên-branch>, http://localhost:3000) | Public (sau khi deploy develop, https://dev.xlms.vn)
- Route:
- Account (role/username, không ghi password):
- Bước:

## Kiểm tra đã chạy
- [ ] pnpm exec tsc --noEmit
- [ ] pnpm exec eslint <files>
- [ ] pnpm build (nếu cần)
- [ ] Chạy app kiểm tra AC
- [ ] E2E liên quan (nếu có)

## Tài liệu
- Đã cập nhật: <file> | Không cập nhật docs vì ...

## Risk / điểm chưa chắc
-
```

Sau khi merge/deploy lên môi trường test: cập nhật ClickUp và change-log `Status = Ready for Test`.

## Definition of Done cho Dev FE

- [ ] Đã chọn skill BMad theo Bước 1b (hoặc theo prompt).
- [ ] Task đạt điều kiện bắt đầu ở Bước 2 (hoặc ghi rõ ngoại lệ hotfix).
- [ ] Code đáp ứng từng acceptance criteria; AC chưa làm được ghi lý do.
- [ ] Không tự đổi contract API; lệch API đã báo theo `api-contract-workflow.md`.
- [ ] i18n `vi`/`en` đầy đủ cho text mới.
- [ ] Type check, lint đã chạy; build và E2E khi cần; kết quả ghi trong PR.
- [ ] Tài liệu liên quan đã cập nhật hoặc ghi rõ lý do không cập nhật.
- [ ] Bug report (nếu có) đã cập nhật `fixed` + branch/commit.
- [ ] PR có ClickUp ID, link requirement, cách test (kèm môi trường test đề xuất Local/Public), risk.
- [ ] Câu trả lời cuối cùng cho người dùng liệt kê file đã sửa, kiểm tra đã chạy, điểm còn mở.

## Definition of Done cho Dev BE (phần trong repo này)

- [ ] API/quyền `proposed` đã được review; trạng thái và dòng xác nhận đã ghi trong requirement.
- [ ] Khác biệt so với đề xuất đã được PM/BA review và cập nhật requirement/AC.
- [ ] Sau khi deploy: `docs/api/` và `docs/security/` (nếu đổi quyền) đã sinh lại, metadata `Source`/`Generated at` đúng môi trường.
- [ ] Trạng thái `implemented` đã cập nhật, link sang file `docs/api/`.
- [ ] Dòng change-log `Docs generated` đã thêm.

## Prompt mẫu

Dev FE implement:

```text
Bạn đóng vai Dev FE. Đọc AGENTS.md và docs/ai/dev/dev-workflow.md.
Implement task CU-<id> theo requirement được link trong docs/requirements/change-log.md.
Kiểm tra điều kiện bắt đầu trước khi code. Sau khi sửa, chạy type check/lint, cập nhật tài liệu liên quan và soạn mô tả PR theo template.
```

Dev FE fix bug:

```text
Bạn đóng vai Dev FE. Đọc AGENTS.md và docs/ai/dev/dev-workflow.md.
Fix bug docs/test-cases/<domain>/bugs/<BUG-ID>.md (ClickUp CU-<id>).
Đối chiếu expected với requirement, sửa code, cập nhật bug report và change-log, soạn mô tả PR.
```

Dev BE xác nhận API:

```text
Bạn đóng vai Dev BE. Đọc docs/workflows/api-contract-workflow.md.
Review mục "API đề xuất cho BE" và "Phân quyền đề xuất" trong docs/requirements/<domain>/<file>.md.
Liệt kê điểm cần đổi so với đề xuất; sau khi tôi xác nhận, ghi trạng thái confirmed-by-BE và dòng xác nhận. Không sửa code FE.
```

Dev BE sinh lại tài liệu API:

```text
Bạn đóng vai Dev BE. Đọc docs/workflows/api-contract-workflow.md mục "Sinh lại docs/api".
Nguồn: swagger.json từ môi trường <env> ngày <date> tại <đường dẫn>.
Sinh lại docs/api cho domain <domain>, báo endpoint thêm/xóa/đổi, cập nhật trạng thái implemented trong requirement và change-log.
```
