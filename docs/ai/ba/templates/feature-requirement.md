# Template: Feature Requirement

Status: reviewed
Owner: PM/BA
Last reviewed: 2026-09-16
Related:
  - docs/ai/ba/ba-workflow.md
  - docs/ai/documentation-structure.md

Dùng cho **feature mới** (loại A). Tên file: `docs/requirements/<domain>/<feature>.md`, kebab-case tiếng Anh.

Requirement này được cả Dev FE, Dev BE và Tester đọc. Không bỏ trống mục API/quyền nếu feature cần backend; ghi `Không áp dụng` nếu thật sự không cần.

Copy phần dưới đây:

````md
# <Tên feature>

Status: draft
Owner: BA
Last reviewed: YYYY-MM-DD
Task: CU-<task-id> (<link ClickUp>)
Source: docs/requirements/requests/<file>.md | verbal: <người yêu cầu>, <ngày>, <kênh>, ghi nhận bởi <BA>
Related:
  - docs/requirements/<domain>/<file liên quan>.md
  - docs/api/<domain>/<file>.md (API hiện có, nếu dùng lại)
  - docs/security/roles/<role>.md
  - <link Figma/mockup nếu có>

## 1. Bối cảnh và mục tiêu

- Vấn đề cần giải quyết:
- Người dùng/role:
- Giá trị mang lại:

## 2. Phạm vi

- Trong phạm vi:
- Ngoài phạm vi:

## 3. Business rules

| ID | Rule | Điều kiện áp dụng | Role |
| --- | --- | --- | --- |
| <MODULE>-BR-001 |  |  |  |

## 4. Luồng người dùng

1. ...

Có thể thêm sơ đồ mermaid nếu flow phức tạp.

## 5. Màn hình và trạng thái

| Màn hình/route dự kiến | Thành phần chính | Loading/Empty/Error | Ghi chú |
| --- | --- | --- | --- |

## 6. Phân quyền đề xuất

| Role | Resource.action | Được phép | Ghi chú |
| --- | --- | --- | --- |

- Trạng thái: proposed | confirmed-by-BE | implemented | changed
- Xác nhận: <tên Dev BE>, YYYY-MM-DD, <kênh>
- Khác biệt so với đề xuất: <không có | mô tả>

## 7. API đề xuất cho BE

Bỏ qua mục này nếu chỉ dùng API đã có (link ở Related).

### <METHOD> <path>

- Trạng thái: proposed | confirmed-by-BE | implemented | changed
- Xác nhận: <tên Dev BE>, YYYY-MM-DD, <kênh>
- Khác biệt so với đề xuất: <không có | mô tả>
- Làm song song FE với mock khi chưa confirmed: Có/Không
- Mục đích:
- Quyền:
- Request (query/body):

| Field | Kiểu | Bắt buộc | Mô tả |
| --- | --- | --- | --- |

- Response:

| Field | Kiểu | Mô tả |
| --- | --- | --- |

- Lỗi nghiệp vụ và message hiển thị:

| Trường hợp | HTTP/Error code | Message người dùng thấy |
| --- | --- | --- |

Quy trình đổi trạng thái, người phụ trách (PM/BA/Dev BE) và cách sinh lại `docs/api/`: `docs/workflows/api-contract-workflow.md`.

## 8. Acceptance criteria

| ID | BR | Given | When | Then |
| --- | --- | --- | --- | --- |
| AC-01 | <MODULE>-BR-001 |  |  |  |

## 9. Test impact

None | Manual | Regression | Automation | Regression + Automation | Needs review

Flow/màn hình cần regression:

## 10. Open questions

| # | Câu hỏi | Hỏi ai | Chặn Dev? | Trả lời | Ngày/kênh |
| --- | --- | --- | --- | --- | --- |

## 11. Customer confirmation

- Phạm vi: <người xác nhận, ngày, kênh> hoặc `verbal: ...`
- UAT: <người nghiệm thu, ngày, kết quả, phản hồi>

## Change Log

| Date | Task | Summary | Test impact | Status |
| --- | --- | --- | --- | --- |
````
