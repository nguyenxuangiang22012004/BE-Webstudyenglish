# Tài Liệu BA Chi Tiết: Meetings

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-06-12
Related:
  - docs/api/integrations/google.md
  - docs/api/integrations/microsoft.md
  - docs/security/resources/meetings.md
  - docs/requirements/integrations/external-integrations.md
  - docs/test-cases/overview.md

Business rule IDs:
  - MTG-BR-001: Meeting là buổi học/cuộc họp online gắn với course hoặc lesson.
  - MTG-BR-002: Meeting có thể được tạo qua tích hợp Google hoặc Microsoft.
  - MTG-BR-003: Quyền tạo meeting theo RBAC resource `meetings`.

## 1. Khái niệm meeting

Meeting là buổi học hoặc cuộc họp trực tuyến được tạo thông qua nhà cung cấp tích hợp như Google hoặc Microsoft.

## 2. Phạm vi chức năng hiện có

API integration có các nhóm endpoint:
- Tạo meeting cho lesson/course.
- CRUD meeting.
- Join/leave meeting.
- Attendance, recording, summary.
- Meeting notifications.

RBAC hiện tại của resource `meetings` chỉ khai báo action `store`.

## 3. Quy tắc nghiệp vụ chính

- Chỉ role có quyền `meetings.store` mới được tạo meeting.
- Meeting cần gắn đúng course/lesson nếu được tạo từ bối cảnh học tập.
- Join/leave và attendance cần gắn đúng user.
- Lỗi provider ngoài cần được hiển thị rõ và không làm mất dữ liệu lesson/course.

## 4. Ghi chú và điểm cần xác nhận

- Cần xác nhận provider nào đang bật theo môi trường.
- Cần xác nhận meeting có UI quản trị riêng hay chỉ tạo từ course/lesson.
