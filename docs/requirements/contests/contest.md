# Tài Liệu BA Chi Tiết: Contest

Status: reviewed
Owner: BA/DEV
Last reviewed: 2026-09-16
Related:
  - docs/api/other/contest.md
  - docs/security/resources/contests.md
  - docs/test-cases/overview.md

Business rule IDs:
  - CON-BR-001: Contest là cuộc thi hoặc hoạt động thi đua trong LMS.
  - CON-BR-002: Contest có thể gồm nhiều contest round.

Product note: Chức năng Contest có hoạt động trong code nhưng hiện đang bị ẩn vì sản phẩm chưa dùng. Khi sản phẩm bật lại chức năng này, PM/BA cần review lại nghiệp vụ trước khi dùng tài liệu này làm source of truth cuối cùng.

## 1. Khái niệm contest

Contest là cuộc thi hoặc sự kiện học tập có cấu trúc riêng, có thể gồm nhiều vòng thi.

## 2. Phạm vi chức năng hiện có

API hiện có:
- `GET /v1/contests`
- `POST /v1/contests`
- `GET /v1/contests/{id}`
- `PUT /v1/contests/{id}`
- `DELETE /v1/contests/{id}`

Swagger ghi nhận thêm operation ngoài nhóm CRUD cơ bản; cần đối chiếu API chi tiết khi viết test case.

## 3. Quy tắc nghiệp vụ chính

- Contest cần có tên, thời gian hoặc trạng thái rõ nếu backend yêu cầu.
- Contest round phải thuộc contest hợp lệ.
- Xóa contest có round hoặc kết quả cần kiểm tra ràng buộc backend.

## 4. Ghi chú kiểm thử

- Chức năng Contest hiện có hoạt động trong code nhưng đang bị ẩn vì sản phẩm chưa dùng.
- Khi bật lại Contest, PM/BA cần review lại nghiệp vụ, route UI quản lý, quan hệ với question bank/exam và các ràng buộc backend trước khi release.
