# Tài Liệu BA Chi Tiết: Internal Command

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-06-12
Related:
  - docs/api/feedbacks/internal-comment.md
  - docs/security/resources/internal.md
  - docs/test-cases/overview.md

Business rule IDs:
  - INT-CMD-BR-001: Internal command là nhóm thao tác vận hành hệ thống nhạy cảm.
  - INT-CMD-BR-002: Chỉ role có quyền `internal.command` mới được chạy command.
  - INT-CMD-BR-003: Command cần có lịch sử thực thi và trạng thái kết quả.

## 1. Khái niệm internal command

Internal command là endpoint vận hành dùng để chạy job hoặc tác vụ hệ thống nội bộ.

Ví dụ nhóm job trong API gồm:
- Tạo hoặc tính lại thống kê school/course.
- Đồng bộ dữ liệu homework, class, assessment, teacher class.
- Xóa dữ liệu dashboard tổng hợp.

## 2. Phạm vi chức năng hiện có

API hiện có:
- `POST /v1/internal/{job_name}`
- `GET /v1/internal/jobs`
- `GET /v1/internal/jobs/{job_id}`
- `GET /v1/internal/executions`
- `GET /v1/internal/executions/summary`
- `POST /v1/internal/jobs/{job_id}/stop`

## 3. Quy tắc nghiệp vụ chính

- Internal command là chức năng rủi ro cao, chỉ admin có quyền theo RBAC hiện tại.
- Mỗi lần chạy command cần ghi nhận job name, tham số, người chạy, trạng thái và kết quả nếu backend hỗ trợ.
- Command có khả năng thay đổi dữ liệu tổng hợp cần được xác nhận trước khi chạy.
- Dừng job đang chạy cần hiển thị kết quả rõ ràng.

## 4. Ghi chú và điểm cần xác nhận

- Cần xác nhận UI hiện có cho internal command hay chỉ gọi backend/API.
- Cần xác nhận danh sách job được phép chạy theo môi trường.
- Cần xác nhận audit log có được lưu không.
