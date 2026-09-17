# Template: Change Note

Status: reviewed
Owner: PM/BA
Last reviewed: 2026-09-16
Related:
  - docs/ai/ba/ba-workflow.md
  - docs/requirements/change-workflow.md

Dùng cho **thay đổi lớn trên chức năng đã có** (loại B) khi `docs/requirements/change-workflow.md` quyết định tạo file mới thay vì sửa file requirement cũ.

Tên file: `docs/requirements/<domain>/<feature>-<thay-doi>.md`, ví dụ `homework-question-flow-changes.md`.

Thay đổi nhỏ không cần file này: sửa trực tiếp file requirement cũ và thêm dòng vào mục `Change Log` của file đó.

Copy phần dưới đây:

````md
# Feature Change: <Tên thay đổi>

Status: draft
Owner: BA
Last reviewed: YYYY-MM-DD
Task: CU-<task-id> (<link ClickUp>)
Source: docs/requirements/requests/<file>.md | verbal: <người yêu cầu>, <ngày>, <kênh>, ghi nhận bởi <BA>
Related:
  - docs/requirements/<domain>/<requirement chính>.md
  - docs/api/<domain>/<file>.md
  - docs/security/roles/<role>.md

## 1. Bối cảnh

Hành vi hiện tại (đối chiếu code/requirement) và lý do thay đổi.

## 2. Nội dung thay đổi

| Hạng mục | Hiện tại | Sau thay đổi | BR liên quan |
| --- | --- | --- | --- |

Business rule mới/sửa: dùng tiếp ID trong requirement chính, ghi rõ `new` hoặc `updated`.

## 3. Phân quyền đề xuất

Không áp dụng | bảng như template feature-requirement

## 4. API đề xuất cho BE

Không áp dụng | theo mục 7 của `docs/ai/ba/templates/feature-requirement.md`

## 5. Acceptance criteria

| ID | BR | Given | When | Then |
| --- | --- | --- | --- | --- |

## 6. Impact

- Màn hình/role bị ảnh hưởng:
- Dữ liệu cũ/migration:
- Test impact:

## 7. Open questions

| # | Câu hỏi | Hỏi ai | Chặn Dev? | Trả lời | Ngày/kênh |
| --- | --- | --- | --- | --- | --- |

## 8. Customer confirmation

- Phạm vi:
- UAT:
````

Sau khi thay đổi đã `Done`, BA đồng bộ phần ổn định vào requirement chính và đổi `Status` của change note sang `outdated` hoặc ghi rõ đã hợp nhất.
