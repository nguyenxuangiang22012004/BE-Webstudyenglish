# Customer Requests

Status: reviewed
Owner: PM/BA
Last reviewed: 2026-09-16
Related:
  - docs/ai/ba/ba-workflow.md
  - docs/ai/ba/templates/customer-request.md
  - docs/requirements/change-log.md

## Mục đích

Folder này lưu yêu cầu gốc của khách hàng **khi có minh chứng** (email, file, biên bản, ảnh chụp tin nhắn, mockup) và lịch sử làm rõ yêu cầu.

File trong folder này **không phải requirement chính thức**. Dev và Tester dùng file requirement trong `docs/requirements/<domain>/`; file request chỉ để truy vết "khách đã yêu cầu gì, đã chốt gì".

Yêu cầu không có minh chứng (gọi điện, trao đổi miệng) không bắt buộc có file ở đây; nguồn được ghi trong mục `Source` của requirement. Xem Bước 1 trong `docs/ai/ba/ba-workflow.md`.

## Quy ước

- Tên file: `<yyyy-mm-dd>-<task-id>-<slug>.md`, ví dụ `2026-09-16-CU-86c1ab2de-export-progress-report.md`.
- Template: `docs/ai/ba/templates/customer-request.md`.
- Minh chứng gốc (file đính kèm, ảnh) lưu ở ClickUp hoặc Drive, chỉ link trong file request.
- Không ghi số điện thoại, email cá nhân, dữ liệu học sinh thật, thông tin hợp đồng.
- Mỗi file request link sang requirement tương ứng; requirement link ngược lại trong mục `Source`.
