# Test Cases Docs

Status: draft
Owner: TEST
Related:
  - docs/ai/testing/test-case-generation.md
  - docs/ai/testing/tester-workflow.md
  - docs/testing/

Folder này chứa tài liệu test case/manual QA của project.

Code test tự động không đặt ở đây. Unit test đặt gần source code trong `src/`; UI/E2E test đặt trong `tests/`.

## Mục đích

Folder `docs/test-cases/` chứa test case cụ thể theo feature/module.

Folder này trả lời câu hỏi:

> Cần kiểm thử những scenario nào và expected result là gì?

## Luồng tài liệu

Thứ tự đọc và viết tài liệu test:

1. Requirement: `docs/requirements/`
2. Design: `docs/design/`
3. API contract: `docs/api/` nếu feature có gọi API.
4. Security/RBAC: `docs/security/` nếu feature phụ thuộc role/quyền.
5. Test context: `docs/testing/`.
6. Test plan: phạm vi test, môi trường, dữ liệu, rủi ro.
7. Test scenarios: luồng test mức cao.
8. Test cases: bước test chi tiết và expected result.
9. Test data: dữ liệu dùng khi test.
10. Traceability: mapping requirement/design/API/security/test case.
11. Test report: kết quả chạy test theo version/release.

Quy trình chi tiết để AI Tester sinh test case từ requirement nằm trong `docs/ai/testing/test-case-generation.md`.

## Quy ước liên kết với requirements và design

Mỗi file test case nên khai báo requirement và design liên quan bằng frontmatter ở đầu file.

Với test case của một page:

```md
---
requirement: ../../requirements/learning-materials/vocabulary.md
design: ../../design/vocabulary/pages/study-practice-question.md
domain: vocabulary
page: study-practice-question
type: test-case
---
```

Nếu một test case liên quan nhiều design hoặc requirement:

```md
---
requirements:
  - ../../requirements/learning-materials/vocabulary.md
designs:
  - ../../design/vocabulary/pages/study-collapsed.md
  - ../../design/vocabulary/pages/study-practice-question.md
domain: vocabulary
type: test-case
---
```

Nếu test case liên quan API hoặc permission, bổ sung link tương ứng:

```md
---
requirement: ../../requirements/users/permission.md
api: ../../api/users/permission.md
security: ../../security/resources/permissions.md
domain: users
type: permission
---
```

## Cấu trúc khuyến nghị

```text
docs/test-cases/
├─ overview.md
└─ <domain>/
   ├─ overview.md
   ├─ test-plan.md
   ├─ scenarios.md
   ├─ test-data.md
   ├─ traceability.md
   ├─ <feature>.md
   ├─ pages/
   │  └─ <page-name>.md
   ├─ bugs/
   │  └─ <BUG-ID>.md
   └─ reports/
      └─ <yyyy-mm-dd>-<feature>.md
```

Không cần tạo folder rỗng cho mọi domain. Chỉ tạo khi đã có test case tương ứng.

- `<feature>.md`: test case theo feature khi không gắn với một page cụ thể, ví dụ `auth/remember-me.md`.
- `bugs/`: bug report do tester tạo. Nếu bug cũng được tạo trên ClickUp, vẫn tạo file ngắn chứa ClickUp Task ID, link và evidence để AI đọc được.
- `reports/`: kết quả một lần chạy test (manual hoặc automation).

## Format test case đề xuất

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

### Automation
tests/e2e/<domain>/<file>.spec.ts hoặc "Manual"

### Notes
```

## Format bug report

File: `docs/test-cases/<domain>/bugs/<BUG-ID>.md`, ID theo format `<MODULE>-BUG-<NUMBER>`.

```text
# <BUG-ID> - <Tiêu đề ngắn>

Status: open/fixed/verified/closed/needs-review
Severity: critical/high/medium/low
Found: YYYY-MM-DD
Environment: <Local http://localhost:3000 | Public https://dev.xlms.vn>, <branch/commit>
Account: <role/username, không ghi password>
Related:
  - Test case: docs/test-cases/<domain>/<feature>.md#<TC-ID>
  - Requirement: docs/requirements/...
  - ClickUp: CU-<task-id> (<link>)

## Steps to reproduce

## Expected result

## Actual result

## Evidence
Screenshot/video/trace/log (không chứa password/token)

## Notes
Phân tích nguyên nhân sơ bộ nếu có, không đề xuất code fix thay Dev.
```

## Format test report

File: `docs/test-cases/<domain>/reports/<yyyy-mm-dd>-<feature>.md`.

```text
# Test Report - <feature> - YYYY-MM-DD

Status: pass/fail/blocked
Tester: <người hoặc AI + người review>
Environment: <Local http://localhost:3000 | Public https://dev.xlms.vn>
Build: <branch + commit>
Account: <role/username>
Related:
  - Test cases: docs/test-cases/<domain>/<feature>.md
  - Automation: tests/e2e/<domain>/...

## Scope

## Kết quả

| TC-ID | Scenario | Loại (Manual/Auto) | Kết quả | Bug |
| --- | --- | --- | --- | --- |

## Bug

## Needs review / Blocked

## Cách chạy lại

## Evidence
Vị trí evidence. Không commit trace/video có chứa password, token.
```

## Quy ước đặt tên

- Folder domain dùng kebab-case và nên trùng domain ở `docs/design/`.
- File page test dùng cùng tên với file page design, ví dụ `study-practice-question.md`.
- Test report dùng ngày + feature hoặc release name, ví dụ `2026-05-21-remember-me.md` hoặc `release-1.2.0.md`.
- Bug report ID theo format `<MODULE>-BUG-<NUMBER>`, ví dụ `AUTH-BUG-001`.
- Test case ID nên theo format `<MODULE>-TC-<NUMBER>`, ví dụ `AUTH-TC-001`, `FB-TC-001`.

## Quy tắc

- Mỗi test case nên link về requirement hoặc business rule liên quan.
- Test case permission nên link thêm `docs/security/`.
- Test case API-heavy nên link thêm `docs/api/`.
- Test data dùng chung nên link về `docs/testing/test-data.md`.
- Không ghi workflow tạo test case ở đây; workflow đó nằm trong `docs/ai/testing/test-case-generation.md`.
- Phân loại task test và Definition of Done cho AI Tester nằm trong `docs/ai/testing/tester-workflow.md`.
- Không ghi password, token, cookie thật vào test case, bug report hoặc report.

