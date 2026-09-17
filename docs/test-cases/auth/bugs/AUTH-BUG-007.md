# AUTH-BUG-007 - Phụ huynh vào tài khoản con: phiên phụ huynh vẫn còn, refresh-token cấp lại token của phụ huynh

Status: open
Severity: high
Found: 2026-09-17
Environment: Local `http://localhost:3000` (`next dev -p 3000`), API môi trường Development (`NEXT_PUBLIC_API_URL` trong `.env`), branch `nhánh-fix-bug-develop` @ `0c6dc0c3`
Account: Parent `parent_user1` (password từ `TEST_PARENT_PASSWORD`), tài khoản con đầu tiên trong danh sách
Related:
  - Test case: docs/test-cases/auth/remember-me.md#auth-tc-013
  - Automation: tests/e2e/auth/parent-switch-child.spec.ts
  - Requirement: docs/requirements/auth/auth.md (chưa có rule cho chuyển sang tài khoản con)
  - Report: docs/test-cases/auth/reports/2026-09-17-remember-me-recheck.md
  - ClickUp: chưa có

## Mô tả

Khi phụ huynh bấm "Vào tài khoản" của con, hộp thoại báo "tài khoản của bạn sẽ tự động đăng xuất". Thực tế cookie httpOnly `authToken`/`refreshToken` của phụ huynh vẫn còn trên trình duyệt. App chạy bằng access token của con trong Local Storage, nhưng khi phiên được làm mới (`POST /api/auth/refresh-token`, interceptor gọi khi gặp 401) thì server dùng refresh token của phụ huynh và cấp lại token **của phụ huynh**.

## Steps to reproduce

1. Mở `/vi/login`, đăng nhập `parent_user1`, tick "Ghi nhớ đăng nhập" → vào `/vi/parents/childrens`.
2. Bấm "Vào tài khoản" ở tài khoản con đầu tiên, bấm "Xác nhận" → vào `/vi/student/assignments`.
3. DevTools → Application → Cookies: xem `authToken`, `refreshToken`.
4. Gọi `POST /api/auth/refresh-token` trong cùng trình duyệt (mô phỏng lúc access token của con hết hạn, interceptor tự gọi).
5. So sánh người dùng trong access token vừa được cấp với tài khoản con.

## Expected result (giả định Tester)

Sau khi vào tài khoản con, phiên của phụ huynh kết thúc như hộp thoại thông báo: không còn cookie phiên của phụ huynh, và làm mới phiên chỉ cấp token của tài khoản con.

## Actual result

- Sau bước 2: Local Storage `token` là token của con (đúng).
- Cookie `authToken` và `refreshToken` vẫn là của phụ huynh, cờ `httpOnly`. Không có cookie nào mang token của con.
- Bước 4: refresh-token trả `200 Refreshed Token Successfully`; access token mới có cùng định danh (claim JWT) với phụ huynh, không phải con.
- Hệ quả (suy ra từ code, chưa quan sát trên UI): khi token của con hết hạn, interceptor ghi token của phụ huynh vào Local Storage và giao diện học sinh gọi API bằng quyền phụ huynh. Người dùng tài khoản con trên máy này có thể lấy được phiên của phụ huynh.

## Evidence

- Playwright `AUTH-TC-013 @known-bug` fail 2/2 lần chạy (2026-09-17, `http://localhost:3000`). Annotation (chỉ nhãn, không có giá trị token):
  - Cookie authToken sau khi chuyển: `parent [httpOnly]`
  - Cookie refreshToken sau khi chuyển: `parent [httpOnly]`
  - Local Storage token sau khi chuyển: `child`
  - refresh-token: `200 Refreshed Token Successfully`
  - Token do refresh-token cấp thuộc về: `parent (token mới)`
- Screenshot, video, trace: `_bmad-output/test-artifacts/e2e-results/artifacts/auth-parent-switch-child-*` (local, không commit; trace có màn hình nhập mật khẩu và token trong network log — không chia sẻ ra ngoài team).

## Notes

- Phân tích sơ bộ (đọc code, không đề xuất sửa): `src/app/[locale]/parents/childrens/page.tsx` xóa/ghi `authToken`, `refreshToken` bằng `cookieStorageHelper` (JavaScript). Server đặt 2 cookie này là httpOnly (`src/lib/auth-cookies.ts`), trình duyệt không cho JavaScript xóa hoặc ghi đè cookie httpOnly, nên cookie của phụ huynh được giữ nguyên. Route `src/app/api/auth/refresh-token/route.tsx` đọc cookie `refreshToken` này.
- Không phải regression của `10b598c3`/`d01a8fec`/`b4b9ea01`: cookie đã là httpOnly từ trước `10b598c3`. Lỗi có từ khi thêm luồng phụ huynh (`02980419`).
- Chưa test: đăng xuất khi đang ở tài khoản con (route logout thu hồi refresh token nào), và luồng này khi phụ huynh không tick ghi nhớ.
- **Needs review (BA):** chưa có rule mô tả phiên phụ huynh/tài khoản con. Expected result dựa trên nội dung hộp thoại "tài khoản của bạn sẽ tự động đăng xuất".
