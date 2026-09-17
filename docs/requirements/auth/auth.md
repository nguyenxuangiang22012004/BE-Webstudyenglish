# Tài Liệu BA Chi Tiết: Auth

Status: reviewed
Owner: BA/DEV
Last reviewed: 2026-09-16
Related:
  - docs/api/auth/auth.md
  - docs/api/auth/webhook-auth.md
  - docs/security/overview.md
  - docs/test-cases/overview.md

Business rule IDs:
  - AUTH-BR-001: Người dùng phải xác thực trước khi truy cập khu vực làm việc.
  - AUTH-BR-002: Hệ thống hỗ trợ đăng nhập, đăng xuất, quên mật khẩu, đổi mật khẩu và làm mới phiên.
  - AUTH-BR-003: Người dùng được điều hướng về khu vực phù hợp sau khi đăng nhập thành công.
  - AUTH-BR-004: Phiên đăng nhập và trạng thái token phải được kiểm soát theo phản hồi backend.

## 1. Khái niệm auth

Auth là nhóm chức năng xác thực và duy trì phiên đăng nhập của người dùng trong LMS.

Nhóm này bao gồm các thao tác:
- Đăng nhập
- Đăng xuất
- Làm mới token
- Quên mật khẩu
- Kiểm tra OTP
- Đổi mật khẩu
- Đồng bộ/verify với luồng SSO hoặc webhook nếu backend hỗ trợ

## 2. Phạm vi chức năng hiện có

Các endpoint hiện có trong API:
- `POST /v1/login`
- `POST /v1/logout`
- `POST /v1/refresh-token`
- `POST /v1/forgot-password`
- `POST /v1/check-otp`
- `PUT /v1/change-password`
- `POST /v1/opa-sync`
- `POST /v1/webhook/auth`

## 3. Quy tắc nghiệp vụ chính

- Người dùng phải đăng nhập để vào các route nội bộ.
- Sau khi đăng nhập, hệ thống xác định khu vực làm việc theo role và cấu hình điều hướng.
- Khi token hết hạn, hệ thống cần làm mới phiên hoặc yêu cầu đăng nhập lại.
- Người dùng đổi mật khẩu hoặc quên mật khẩu phải đi qua bước xác thực phù hợp.
- Nếu webhook/SSO thất bại, hệ thống cần có trạng thái lỗi rõ ràng để UI xử lý.

## 4. Luồng màn hình chính

1. Người dùng nhập thông tin đăng nhập.
2. Hệ thống gửi request login.
3. Nếu hợp lệ, hệ thống lưu phiên và điều hướng theo role.
4. Nếu token hết hạn, hệ thống gọi refresh token.
5. Nếu quên mật khẩu, người dùng xác minh OTP rồi đổi mật khẩu.

## 5. Ghi chú và điểm cần xác nhận

- Cần xác nhận backend trả về danh sách role/default page nào sau login.
- Cần xác nhận luồng SSO/webhook có bắt buộc cho mọi môi trường hay không.
- Cần xác nhận UI logout có chỉ xóa local session hay gọi API bắt buộc.
