# Testing Environments

Status: draft
Owner: TEST
Related:
  - docs/testing/test-data.md
  - docs/testing/test-automation-workflow.md

## Mục đích

Tài liệu này mô tả các môi trường dùng cho manual QA, regression và automation.

Có hai nhánh test, chọn theo trạng thái của code cần test:

| Nhánh | Khi nào dùng | Web URL | Code được test |
| --- | --- | --- | --- |
| 1. Local | Code chưa deploy lên bản public (đang dev, verify fix trên branch) | `http://localhost:3000` (cố định) | Code trên máy tester |
| 2. Public | Code đã deploy, cần smoke/regression trên bản người dùng truy cập | `https://dev.xlms.vn` | Bản build đang deploy |

Automation chọn nhánh qua biến `E2E_BASE_URL`. Không đặt biến này thì mặc định chạy nhánh Local.

## Nhánh 1: Local

| Key | Value |
| --- | --- |
| Web URL | `http://localhost:3000` |
| API URL | Giá trị `NEXT_PUBLIC_API_URL` trong `.env` |
| Locale mặc định | `vi` |
| Account test | `docs/testing/test-data.md` (environment Development) |
| `E2E_BASE_URL` | Không cần đặt (mặc định `http://localhost:3000`) |

### Bắt buộc dùng port 3000

BE chỉ cho phép CORS từ `localhost:3000`. Chạy app ở port khác thì request API bị trình duyệt chặn, test fail nhưng không phải do bug sản phẩm.

- Chạy app bằng `pnpm dev --port 3000`. Khi chỉ định port, Next.js báo lỗi nếu port bận thay vì tự chuyển sang port khác.
- Nếu port 3000 bận: tắt tiến trình đang chiếm port rồi chạy lại. Không đổi sang port khác.
- Dùng `http`, không dùng `https`.
- Nếu log `pnpm dev` hiện URL không phải `http://localhost:3000`, dừng lại và xử lý port trước khi chạy test.

### Tài nguyên máy

Máy tester chạy cả Next.js dev server và trình duyệt Playwright, nên tốn RAM hơn nhánh Public. Config đang dùng 1 worker để giảm tải.

## Nhánh 2: Public

Cập nhật bảng dưới khi URL hoặc bản deploy thay đổi. Không ghi password, token hoặc API URL vào bảng.

| Môi trường | Web URL | Branch/version đang deploy | Account test | Ghi chú |
| --- | --- | --- | --- | --- |
| Public | `https://dev.xlms.vn` | `develop` | `docs/testing/test-data.md` | |

### Lưu ý khi test bản public

- **Code được test là bản đang deploy**, không phải code trên máy. Ghi branch/version vào test report để biết kết quả thuộc bản nào.
- **Dữ liệu thật:** chỉ chạy test đọc dữ liệu hoặc test có cleanup rõ ràng. Không chạy test tạo/sửa/xóa dữ liệu nếu chưa được team đồng ý.
- **Account:** dùng account trong `docs/testing/test-data.md`.
- **Không thử sai mật khẩu nhiều lần** trên account thật hoặc account dùng chung.
- **Tốc độ mạng:** test phụ thuộc mạng, dễ chạm timeout hơn local. Fail do timeout cần chạy lại để phân biệt với bug.
- **Tài nguyên máy:** không cần chạy dev server; máy chỉ chạy trình duyệt Playwright và test runner.

## Ghi chú bảo mật

- Không ghi password thật vào tài liệu trong repo.
- Không ghi API URL thật vào tài liệu test; tham chiếu biến `NEXT_PUBLIC_API_URL` trong `.env`.
- Password test nên được lấy từ secret store, password manager hoặc biến môi trường local.
- Khi AI Tester cần chạy automation, truyền password qua environment variables thay vì hard-code trong test.
