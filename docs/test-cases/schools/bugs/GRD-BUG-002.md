# GRD-BUG-002 - Ô chọn số dòng/trang hiển thị "6" trong khi danh sách tải 10 dòng

Status: open
Severity: low
Found: 2026-09-16
Environment: Local dev `next dev --turbopack` tại `http://localhost:3000`, API `https://api-enspire-develop.xlms.vn`, Chromium (Playwright)
Build: `develop` @ `079bbc6b`
Account: Admin `truongadmin` (password từ `TEST_ADMIN_PASSWORD`)
Related:
  - Test case: docs/test-cases/schools/grade.md#grd-tc-007
  - Requirement: docs/requirements/schools/grade.md
  - Report: docs/test-cases/schools/reports/2026-09-17-grade.md
  - ClickUp: sẽ cập nhật sau

## Steps to reproduce

1. Đăng nhập admin, mở `/vi/admin/grades` (cần > 6 khối lớp để thấy rõ; develop hiện có 7).
2. Xem ô "Hiển thị [n] mục mỗi trang" ở cuối bảng.
3. Khi có > 10 khối lớp: thử chọn "6" trong ô.

## Expected result

- Ô chọn hiển thị đúng số dòng/trang đang áp dụng.
- Người dùng chọn được mọi giá trị trong danh sách.

## Actual result

- Request thực tế: `GET /v1/grades?page=1&limit=10`, bảng hiển thị tối đa 10 dòng.
- Ô chọn hiển thị **"6"** (các lựa chọn: 6, 12, 24, 48 — không có 10).
- Vì ô đang hiển thị "6", chọn lại "6" không phát sinh sự kiện thay đổi → người dùng không chuyển được sang 6 dòng/trang nếu không chọn giá trị khác trước (suy ra từ hành vi `<select>` của trình duyệt; automation dùng `selectOption` nên không tái hiện được bước này).

## Evidence

- Script khám phá (Playwright) đọc DOM: `select.value = "6"`, `options = ["6","12","24","48"]`, request `limit=10`.
- Automation `GRD-TC-007` (mock 15 bản ghi), chạy 2026-09-17: **Fail** — `locator('select')` Expected `"10"`, Received `"6"`; accessibility tree: `option "6" [selected]`.

## Notes

Phân tích sơ bộ (không đề xuất fix): trang khởi tạo `pageSize = 10`, còn `ProfessionalPagination` dùng `pageSizeOptions` mặc định `[6, 12, 24, 48]`. Giá trị 10 không có trong danh sách nên trình duyệt/React hiển thị lựa chọn đầu tiên.
