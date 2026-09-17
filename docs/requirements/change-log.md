# Requirements Change Log

Status: draft
Owner: BA/PM/TEST
Related:
  - docs/requirements/change-workflow.md
  - docs/ai/ba/ba-workflow.md
  - docs/requirements/requests/overview.md
  - docs/testing/overview.md
  - docs/testing/test-automation-workflow.md
  - docs/test-cases/

## Mục đích

File này là danh sách tổng hợp các thay đổi requirement để DEV và TEST biết file nào đã đổi, đổi vì task nào và có ảnh hưởng test hay không.

Tester nên đọc file này trước khi bắt đầu test một task mới, đặc biệt khi task là thay đổi trên chức năng đã tồn tại.

## Cách dùng

Mỗi khi PM/BA cập nhật requirement cũ hoặc tạo requirement mới, cần thêm một dòng vào bảng bên dưới.

Quy tắc:

- Một task có thể có nhiều dòng nếu ảnh hưởng nhiều file requirement.
- Nếu thay đổi không ảnh hưởng test, vẫn ghi `Test impact = None` để tester biết đã được đánh giá.
- Nếu thay đổi còn draft, ghi `Status = Draft`; chỉ chuyển `Ready for Dev` hoặc `Ready for Test` khi nội dung đã đủ rõ.
- Nếu task có file change note riêng, link cả file change note và file requirement chính.

## Trạng thái đề xuất

| Status | Ý nghĩa |
| --- | --- |
| Draft | Requirement đang viết, chưa dùng để dev/test chính thức. |
| Ready for Dev | Requirement đủ rõ để Dev phân tích và implement. |
| In Dev | Dev đang implement theo requirement này. |
| Ready for Test | Đã có build/env để tester kiểm thử. |
| Done | Đã test xong và được chấp nhận. |
| Superseded | Thay đổi đã bị thay thế bởi requirement/task khác. |

## Change type đề xuất

| Change type | Ý nghĩa |
| --- | --- |
| New doc | Tạo tài liệu requirement/workflow mới. |
| Update rule | Sửa business rule, validation, permission. |
| New flow | Thêm flow/module mới. |
| Bug fix | Sửa lỗi để code đúng với requirement hiện có. |
| Security fix | Xử lý finding bảo mật; link bug report trong cột Summary. |
| Docs workflow | Thay đổi quy trình/tài liệu vận hành, không đổi hành vi sản phẩm. |
| Docs generated | Sinh lại `docs/api/` hoặc `docs/security/` từ Swagger/dữ liệu phân quyền sau khi BE deploy. |

## Test impact đề xuất

| Test impact | Ý nghĩa |
| --- | --- |
| None | Không cần test lại đáng kể. |
| Manual | Cần test thủ công. |
| Regression | Cần chạy lại regression liên quan. |
| Automation | Cần thêm/sửa automation. |
| Regression + Automation | Cần regression và cập nhật automation. |
| Needs review | Chưa xác định, tester/BA/Dev cần cùng review. |

## Change Log

| Date | Task | Source | Requirement file | Change type | Summary | Test impact | Status | Owner |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| 2026-09-16 | DOCS-TEST-AUTO | internal | docs/testing/test-automation-workflow.md | New doc | Bổ sung workflow test automation bằng BMad/AI/Playwright. | Manual | Done | TEST |
| 2026-09-16 | DOCS-TESTER-FLOW | internal | docs/ai/testing/tester-workflow.md | Docs workflow | Thêm luồng AI Tester (phân loại task, output bắt buộc, DoD), luồng bug/security finding, template bug report và test report, quy ước E2E trong `tests/e2e/`. | None | Done | TEST |
| 2026-09-16 | DOCS-BA-FLOW | internal | docs/ai/ba/ba-workflow.md | Docs workflow | Thêm luồng AI PM/BA: ghi nhận yêu cầu khách (file request khi có minh chứng, `Source` khi không), phân loại yêu cầu, template requirement/change note/request, ClickUp Task ID, API/quyền đề xuất cho BE, UAT, DoD trước Ready for Dev. | None | Done | PM/BA |
| 2026-09-16 | DOCS-SOURCE-PRIORITY | internal | AGENTS.md | Docs workflow | Đồng bộ quy tắc ưu tiên: tài liệu liên quan trực tiếp được ưu tiên hơn code trong reading-guide, team-ai-overview, documentation-structure, test-automation-workflow, requirements/overview, change-workflow, ba-workflow. | None | Done | PM/BA |
| 2026-09-16 | DOCS-DEV-FLOW | internal | docs/ai/dev/dev-workflow.md | Docs workflow | Thêm luồng AI Dev FE/BE (điều kiện bắt đầu, tự kiểm tra, template PR, cập nhật tài liệu, DoD) và `docs/workflows/api-contract-workflow.md` (PM/BA/Dev BE chốt API/quyền, trạng thái proposed/confirmed-by-BE/implemented/changed, sinh lại docs/api, docs/security). | None | Done | DEV |
| 2026-09-16 | DOCS-API-REGEN | internal | docs/api/overview.md | Docs generated | Sinh lại `docs/api/` từ swagger.json bản 2026-09-16: 600 → 702 operation, 13 tag mới (13 file mới), 31 file cập nhật endpoint/param; `POST /v1/lessons/schedules` chuyển từ LessonService sang LessonHookService; sửa lỗi font tiếng Việt trong mô tả cũ. Không có endpoint bị xóa. | Needs review | Done | DEV |

## Template dòng mới

```md
| YYYY-MM-DD | CU-<task-id> | docs/requirements/requests/<file>.md hoặc verbal: <người>, <ngày> | docs/requirements/.../feature.md | Update rule | Tóm tắt thay đổi ngắn gọn. | Regression | Ready for Test | BA |
```

Quy ước cột:

- `Task`: ClickUp Task ID dạng `CU-<task-id>` (hoặc custom ID của ClickUp). Task nội bộ không có ClickUp (ví dụ sửa tài liệu quy trình) dùng mã `DOCS-...`.
- `Source`: file request trong `docs/requirements/requests/` nếu yêu cầu có minh chứng; `verbal: <người yêu cầu>, <ngày>` nếu không có minh chứng; `internal` nếu là thay đổi nội bộ team.
- `Status` phải khớp với trạng thái task trên ClickUp.

## Checklist khi thêm dòng

- Đã ghi ClickUp Task ID và Source.
- Đã link đúng file requirement bị thay đổi.
- Summary đủ ngắn để tester hiểu scope.
- Test impact không để trống.
- Status phản ánh đúng trạng thái hiện tại.
- Nếu thay đổi có nhiều role/quyền, đã link thêm tài liệu trong `docs/security/`.
- Nếu thay đổi có API liên quan, đã link thêm tài liệu trong `docs/api/`.
