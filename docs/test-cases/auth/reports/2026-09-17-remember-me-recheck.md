# Test Report - Ghi nhớ đăng nhập (re-verify AUTH-BUG-005, AUTH-BUG-006) - 2026-09-17

Status: fail (AUTH-BUG-006 đã fix trên branch fix; AUTH-BUG-005 open, đã chốt hướng xử lý; phát hiện AUTH-BUG-007)
Tester: AI Tester (Claude) — cần người review
Environment: Local, `next dev -p 3000` tại `http://localhost:3000`, API môi trường Development (`NEXT_PUBLIC_API_URL` trong `.env`), Chromium (Playwright)
Build: `nhánh-fix-bug-develop` @ `0c6dc0c3` (chứa fix `10b598c3`, `d01a8fec`, `b4b9ea01`)
Account: Student `1hsep` (password từ `TEST_STUDENT_PASSWORD`), Parent `parent_user1` (password từ `TEST_PARENT_PASSWORD`); không ghi password vào report
Related:
  - Test cases: docs/test-cases/auth/remember-me.md
  - Automation: tests/e2e/auth/remember-me-storage.spec.ts, tests/e2e/auth/parent-switch-child.spec.ts
  - Report trước: docs/test-cases/auth/reports/2026-09-17-remember-me.md
  - Bug: docs/test-cases/auth/bugs/AUTH-BUG-005.md, docs/test-cases/auth/bugs/AUTH-BUG-006.md, docs/test-cases/auth/bugs/AUTH-BUG-007.md

## Scope

Verify các bug chưa đóng trong `docs/test-cases/auth/bugs/` (AUTH-BUG-005, AUTH-BUG-006) sau commit `b4b9ea01` ("fix các bug").

- Tìm fix: `b4b9ea01` sửa `src/app/api/auth/logout/route.tsx`, `src/app/api/auth/refresh-token/route.tsx`, `src/lib/auth-cookies.ts`, nhắm vào AUTH-BUG-006. Không có commit nào sửa phần AUTH-BUG-005.
- Chạy lại AUTH-TC-001 → 009, thêm AUTH-TC-010 → 012 cho các nhánh liên quan tìm được khi đọc flow; thêm AUTH-TC-013 cho luồng phụ huynh vào tài khoản con sau khi có account phụ huynh.
- Đọc flow xung quanh fix: `AuthProvider` (`logoutFn`, marker `userType`), interceptor axios `src/constants/config/api.ts`, middleware, route `login`/`loginPHX`/`logout`/`refresh-token`, SSO verify, chuyển sang tài khoản con của phụ huynh, rewrite H5P trong `next.config.ts`.
- `docs/requirements/change-log.md`: chưa có dòng cho các bug fix này (ghi nhận, không tự thêm).

## Kết quả

Chạy full spec 2 lần, cả 2 lần **12 pass / 0 fail** (~1.9 phút). Lần 2 có thêm bước đối chứng trong AUTH-TC-011.

Lần 3 (review độc lập bởi phiên AI Tester khác, cùng build `0c6dc0c3`, cùng dev server port 3000, sau khi spec đã chốt): **12 pass / 0 fail** (1.8 phút).

| TC-ID | Scenario | Loại | Kết quả | Bug |
| --- | --- | --- | --- | --- |
| AUTH-TC-001 | Bật ghi nhớ: không có mật khẩu trong Local/Session Storage, cookie | Auto | Pass | AUTH-BUG-001 |
| AUTH-TC-002 | Bật ghi nhớ: cookie httpOnly, có hạn dài | Auto | Pass | |
| AUTH-TC-003 | Xóa dữ liệu cũ `rememberedCredentials` | Auto | Pass | |
| AUTH-TC-004 | Điền sẵn username, mật khẩu trống | Auto | Pass | |
| AUTH-TC-005 | Tắt ghi nhớ: xóa username, cookie phiên | Auto | Pass | |
| AUTH-TC-006 | Tắt ghi nhớ, đóng/mở trình duyệt phải đăng nhập lại | Auto | Pass | AUTH-BUG-002 |
| AUTH-TC-007 | Đăng xuất khi mất mạng xóa token | Auto | Pass | AUTH-BUG-003 |
| AUTH-TC-008 | Đăng nhập thất bại không lưu username | Auto | Pass | AUTH-BUG-004 |
| AUTH-TC-009 | Logout offline rồi có mạng lại (ghi nhớ bật): không khôi phục phiên cũ | Auto | **Pass** (trước: Fail) | AUTH-BUG-006 (verified) |
| AUTH-TC-010 | Như TC-009, ghi nhớ tắt | Auto (mới) | Pass | AUTH-BUG-006 |
| AUTH-TC-011 | Phiên hợp lệ vẫn refresh được (non-regression) + đối chứng replay | Auto (mới) | Pass | |
| AUTH-TC-012 | Logout có mạng: xóa cookie httpOnly, thu hồi refresh token | Auto (mới) | Pass | |
| AUTH-TC-013 | Phụ huynh vào tài khoản con: refresh-token phải cấp token của con | Auto (mới, `@known-bug`) | **Fail** (2/2 lần) | AUTH-BUG-007 (mới) |
| — | Token lộ cho JavaScript (response body + Local Storage) | Code review | Fail | AUTH-BUG-005 (open) |

Chi tiết AUTH-TC-009 và 010 (annotation của test, chỉ tên/cờ, giống nhau ở cả 2 case):

- Ngay sau logout offline: không còn `token`/`authUser`; cookie còn sót `authToken, h5p_token, refreshToken, rememberMe`.
- Mở `/vi/student/assignments`: `POST /api/auth/refresh-token` trả `[401, 401]`; không có `token` trong Local Storage; không còn cookie phiên; URL sau 10 giây `/vi/login`.
- Gắn lại refresh token cũ và gọi refresh-token: không đổi được token mới (đã bị thu hồi ở API).

Chi tiết AUTH-TC-013 (chạy riêng `parent-switch-child.spec.ts`, 2 lần, cùng kết quả; chỉ nhãn, không có giá trị token):

- Sau khi vào tài khoản con: Local Storage `token` là của con; cookie `authToken` và `refreshToken` vẫn là của phụ huynh (`httpOnly`).
- `POST /api/auth/refresh-token`: `200 Refreshed Token Successfully`, access token mới cùng định danh JWT với phụ huynh.

AUTH-TC-011 xác nhận cách kiểm tra "refresh token cũ bị thu hồi" có ý nghĩa: replay refresh token còn hợp lệ theo cùng cách → làm mới thành công.

### Thay đổi test code trong lần chạy này

File `tests/e2e/auth/remember-me-storage.spec.ts`:

- Thêm helper `sessionCookieNames` (chỉ tên cookie), `oldRefreshTokenStillWorks` (giữ cookie cũ trong bộ nhớ test, chỉ đọc field `message` của response), `openStudentPageAsNextUser`.
- AUTH-TC-009 bỏ tag `@known-bug`, chạy cho cả ghi nhớ bật (009) và tắt (010); thêm assertion: refresh-token không trả `200`, cookie phiên bị xóa, về `/login`, refresh token cũ bị thu hồi.
- Thêm AUTH-TC-011, AUTH-TC-012.
- File mới `tests/e2e/auth/parent-switch-child.spec.ts`: AUTH-TC-013 `@known-bug`, password đọc từ `TEST_PARENT_PASSWORD`; chỉ ghi nhãn parent/child vào annotation.

## Bug

| Bug | Severity | Status | Tóm tắt |
| --- | --- | --- | --- |
| AUTH-BUG-005 | medium | open (đã chốt hướng xử lý: phương án 1 — BFF/proxy) | Access/refresh token vẫn lộ cho JavaScript |
| AUTH-BUG-006 | high | **verified trên branch fix** | Logout offline, có mạng lại thì phiên cũ tự khôi phục |
| AUTH-BUG-007 | high | **open (mới)** | Phụ huynh vào tài khoản con: phiên phụ huynh vẫn còn, refresh-token cấp lại token của phụ huynh. Có từ khi thêm luồng phụ huynh (`02980419`), không phải regression của các fix auth. |

## Needs review / Blocked

- **Dev:** AUTH-BUG-007 — phiên phụ huynh không kết thúc khi vào tài khoản con.
- **Tạm bỏ qua (quyết định Tester):** sau logout offline, cookie httpOnly `authToken`/`h5p_token`/`refreshToken` vẫn nằm trên trình duyệt cho tới lần đầu route refresh-token chạy. `next.config.ts` rewrite `/:locale(vi|en)/h5p/*` sang `NEXT_PUBLIC_H5P_URL`, nên nếu người dùng tiếp theo mở URL H5P trước tiên, cookie của người trước có thể được gửi tới H5P server. Chưa test.
- **Dev (đọc code):** nếu người dùng tiếp theo đăng nhập ngay sau logout offline, cookie cũ bị ghi đè nhưng refresh token cũ không được thu hồi ở API (còn hiệu lực tới khi hết hạn, không còn trên máy).
- **Dev/BA:** AUTH-BUG-006 — vẫn chưa có rule cho đăng xuất khi mất mạng; expected result là giả định Tester.
- **Dev/Security:** AUTH-BUG-005 đã chốt phương án 1 (Next server gắn token); cần xác nhận phạm vi và cách chống CSRF, xem bug report.
- **PM/BA:** chưa có ClickUp task ID và dòng trong `docs/requirements/change-log.md` cho các bug fix.
- Chưa test: SSO (`/sso/verify`) — thiếu account. Đọc code: luồng này đặt cookie `userType` nên không bị refresh-token coi là đã đăng xuất.
- Chưa test (luồng phụ huynh): đăng xuất khi đang ở tài khoản con; phụ huynh không tick ghi nhớ.
- **Test data:** thêm `TEST_PARENT_PASSWORD` vào `.env` để chạy lại AUTH-TC-013 (đã bổ sung account vào `docs/testing/test-data.md`).
- Chưa test: `/v1/logout` lỗi khi vẫn có mạng (không mô phỏng được lỗi server-to-server bằng Playwright). Đọc code: route logout không còn trả `500` trước khi xóa cookie.

## Cách chạy lại

```bash
# Terminal 1: bắt buộc port 3000 (BE chỉ cho phép origin localhost:3000)
git checkout nhánh-fix-bug-develop
pnpm install
pnpm dev -p 3000

# Terminal 2: cần TEST_STUDENT_PASSWORD trong .env
E2E_BASE_URL=http://localhost:3000 pnpm exec playwright test -c tests/e2e/playwright.config.ts tests/e2e/auth/remember-me-storage.spec.ts
# Cần TEST_PARENT_PASSWORD trong .env
E2E_BASE_URL=http://localhost:3000 pnpm exec playwright test -c tests/e2e/playwright.config.ts tests/e2e/auth/parent-switch-child.spec.ts
```

Nếu port 3000 đang bận, kiểm tra process đang chiếm port có phải `next dev` của đúng branch cần test không; không để Next.js tự chuyển port khác.

## Evidence

- Kết quả list + annotation: output Playwright của 2 lần chạy (không có giá trị token/password).
- HTML report: `_bmad-output/test-artifacts/e2e-results/html` (local, gitignore, không commit). Không có screenshot/trace vì tất cả test pass (`retain-on-failure`).
- AUTH-TC-013: screenshot, video, trace tại `_bmad-output/test-artifacts/e2e-results/artifacts/auth-parent-switch-child-*` (local, không commit; trace có màn hình nhập mật khẩu và token trong network log → không chia sẻ ra ngoài team).
