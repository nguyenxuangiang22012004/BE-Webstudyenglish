# Template: Customer Request

Status: reviewed
Owner: PM/BA
Last reviewed: 2026-09-16
Related:
  - docs/ai/ba/ba-workflow.md
  - docs/requirements/requests/overview.md

Dùng khi yêu cầu của khách hàng **có minh chứng** (email, file, biên bản, ảnh chụp tin nhắn, mockup).

Tên file: `docs/requirements/requests/<yyyy-mm-dd>-<task-id>-<slug>.md`, ví dụ `2026-09-16-CU-86c1ab2de-export-progress-report.md`.

Copy phần dưới đây:

````md
# Request: <Tên yêu cầu ngắn>

Status: draft
Owner: PM/BA
Last reviewed: YYYY-MM-DD
Task: CU-<task-id> (<link ClickUp>)
Type: A-feature-moi | B-thay-doi | C-bug | D-cau-hoi
Related:
  - Requirement: docs/requirements/<domain>/<feature>.md

## Nguồn

| Ngày nhận | Kênh | Người yêu cầu (vai trò/đơn vị) | Người ghi nhận | Minh chứng |
| --- | --- | --- | --- | --- |
| YYYY-MM-DD | email/biên bản/tin nhắn/file | <vai trò, không ghi SĐT/email cá nhân> | <tên BA> | <link ClickUp attachment/Drive> |

## Nội dung yêu cầu gốc

Tóm tắt trung thực nội dung khách gửi. Trích nguyên văn đoạn quan trọng nếu cần, che thông tin nhạy cảm.

## Hiểu của BA

- Vấn đề khách muốn giải quyết:
- Người dùng/role bị ảnh hưởng:
- Phạm vi dự kiến:
- Ngoài phạm vi:

## Open questions

| # | Câu hỏi | Hỏi ai | Chặn Dev? | Trả lời | Ngày/kênh |
| --- | --- | --- | --- | --- | --- |
| 1 |  | Khách hàng/PM/BE/UX | Có/Không |  |  |

## Lịch sử trao đổi

| Ngày | Kênh | Nội dung chính |
| --- | --- | --- |

## Customer confirmation

- Phạm vi: <người xác nhận, ngày, kênh> hoặc `verbal: <người>, <ngày>, ghi nhận bởi <BA>`
- UAT: <người nghiệm thu, ngày, accept/reject/accept có điều kiện, phản hồi>
````
