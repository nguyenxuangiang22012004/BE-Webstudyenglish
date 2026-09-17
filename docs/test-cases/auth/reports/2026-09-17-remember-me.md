# Test Report - Ghi nhớ đăng nhập (re-verify AUTH-BUG-001 → 005) - 2026-09-17

Status: fail (AUTH-BUG-001 → 004 đã fix trên branch fix; phát hiện AUTH-BUG-006)
Tester: AI Tester (Claude) — cần người review
Environment: Local dev `next dev -p 3000` tại `http://localhost:3000`, API môi trường Development (`NEXT_PUBLIC_API_URL` trong `.env`), Chromium (Playwright)
Build: `nhánh-fix-bug-develop` @ `3f11d640` (chứa fix `10b598c3` và `d01a8fec`)
Account: Student `1hsep` (password từ `TEST_STUDENT_PASSWORD`, không ghi vào report)
Related:
  - Test cases: docs/test-cases/auth/remember-me.md
  - Automation: tests/e2e/auth/remember-me-storage.spec.ts
  - Report trước: docs/test-cases/auth/reports/2026-09-16-remember-me.md
  - Bug: docs/test-cases/auth/bugs/AUTH-BUG-001.md → AUTH-BUG-006.md

## Scope

Verify các bug trong `docs/test-cases/auth/bugs/` sau commit `d01a8fec` ("fix các bug tồn đọng trong file md").

- Tìm fix: `d01a8fec` sửa `src/providers/auth.tsx` và `src/app/[locale]/login/page.tsx`, nhắm vào AUTH-BUG-002, 003, 004. Không có commit nào sửa phần AUTH-BUG-005.
- Fix chỉ nằm trên `nhánh-fix-bug-develop` (local + `origin`). **Chưa merge** vào `develop` (`origin/develop` @ `079bbc6b`), `main`, `pre`, `staging*` — kiểm tra bằng `git merge-base --is-ancestor` và `git branch -r --contains` sau `git fetch`.
- Chạy lại toàn bộ AUTH-TC-001 → 008, thêm AUTH-TC-009 cho bug liên quan tìm được khi đọc flow logout/refresh-token.
- Đọc flow xung quanh fix: `AuthProvider`, login page, API route `login`/`logout`/`refresh-token`/`loginPHX`, `src/lib/auth-cookies.ts`, middleware, interceptor axios `src/constants/config/api.ts`, SSO verify, chuyển sang tài khoản con của phụ huynh.
- `docs/requirements/change-log.md`: chưa có dòng cho các bug fix này (ghi nhận, không tự thêm).

## Kết quả

Chạy trên port 3000 theo yêu cầu (BE chỉ cho phép origin `localhost:3000`).

- Lần chạy 1 (full): 7 pass / 2 fail. AUTH-TC-007 và AUTH-TC-009 fail do **test code** (`page.evaluate: Execution context was destroyed`): sau fix, app điều hướng về `/login` khi đang offline nên tab chính thành trang trắng. Đã sửa test (xem bên dưới), không tính là bug.
- Chạy riêng AUTH-TC-007 + 009 sau khi sửa test: 007 pass, 009 fail (bug sản phẩm).
- Lần chạy 2 (full, sau khi sửa test): **8 pass / 1 fail**, 1.2 phút. Bảng dưới là kết quả lần này.

| TC-ID | Scenario | Loại | Kết quả | Bug |
| --- | --- | --- | --- | --- |
| AUTH-TC-001 | Bật ghi nhớ: không có mật khẩu trong Local/Session Storage, cookie | Auto | Pass | AUTH-BUG-001 (verified) |
| AUTH-TC-002 | Bật ghi nhớ: cookie httpOnly, có hạn dài | Auto | Pass | |
| AUTH-TC-003 | Xóa dữ liệu cũ `rememberedCredentials` | Auto | Pass | |
| AUTH-TC-004 | Điền sẵn username, mật khẩu trống | Auto | Pass | |
| AUTH-TC-005 | Tắt ghi nhớ: xóa username, cookie phiên | Auto | Pass | |
| AUTH-TC-006 | Tắt ghi nhớ, đóng/mở trình duyệt phải đăng nhập lại | Auto | **Pass** (trước: Fail) | AUTH-BUG-002 (verified) |
| AUTH-TC-007 | Đăng xuất khi mất mạng xóa token | Auto | **Pass** (trước: Fail) | AUTH-BUG-003 (verified) |
| AUTH-TC-008 | Đăng nhập thất bại không lưu username | Auto | **Pass** (trước: Fail) | AUTH-BUG-004 (verified) |
| AUTH-TC-009 | Đăng xuất offline rồi có mạng lại: không khôi phục phiên cũ | Auto (mới) | **Fail** | AUTH-BUG-006 (mới) |
| — | Token lộ cho JavaScript (response body + Local Storage) | Code review | Needs review | AUTH-BUG-005 (không đổi) |

Chi tiết lỗi AUTH-TC-009 (từ annotation của test, chỉ có tên/cờ):

- Sau logout offline: không còn `token`/`authUser` (đúng) nhưng còn cookie httpOnly `authToken`, `refreshToken`, `h5p_token`, `rememberMe`.
- Mở `/vi/student/assignments`: `POST /api/auth/refresh-token` trả `[200, 200]`, key `token` xuất hiện lại, trang hiển thị dữ liệu học sinh của tài khoản vừa đăng xuất (URL `/vi/student/assignments?week=1&courseId=269`).

### Thay đổi test code trong lần chạy này

File `tests/e2e/auth/remember-me-storage.spec.ts`:

- Thêm helper `readSessionFlags` (đọc cờ có/không của `token`/`authUser` qua tab phụ mở `/logo/logo.png`, không chạy `AuthProvider`) và `logoutWhileOffline` (chờ request logout lỗi, rồi bật lại mạng).
- Viết lại AUTH-TC-007 dùng 2 helper trên (bản cũ lỗi khi trang điều hướng lúc offline).
- Thêm AUTH-TC-009 `@known-bug`.
- Bỏ tag `@known-bug` khỏi AUTH-TC-006, 007, 008 vì bug đã fix trên build test. Lưu ý: chạy trên `develop` hiện tại thì các test này sẽ fail (fix chưa merge).
- Các assertion chỉ ghi tên key/cookie và cờ có/không, không in giá trị password/token.

## Bug

| Bug | Severity | Status | Tóm tắt |
| --- | --- | --- | --- |
| AUTH-BUG-001 | high | verified trên branch fix, chưa vào `develop` | Mật khẩu văn bản rõ trong Local Storage |
| AUTH-BUG-002 | high | verified trên branch fix, chưa vào `develop` | Tắt ghi nhớ nhưng mở lại trình duyệt vẫn đăng nhập |
| AUTH-BUG-003 | medium | verified trên branch fix, chưa vào `develop` | Logout khi mất mạng không xóa token trong Local Storage |
| AUTH-BUG-004 | low | verified trên branch fix, chưa vào `develop` | Đăng nhập thất bại vẫn lưu username |
| AUTH-BUG-005 | medium | needs-review (không đổi) | Access/refresh token vẫn lộ cho JavaScript |
| AUTH-BUG-006 | high | **open (mới)** | Logout offline, có mạng lại thì phiên cũ tự khôi phục, lộ dữ liệu người trước |

## Needs review / Blocked

- **Dev:** merge `10b598c3` + `d01a8fec` vào `develop`; sau đó Tester chạy lại AUTH-TC-001 → 009 trên develop để chuyển AUTH-BUG-001 → 004 sang `closed`.
- **Dev/BA:** AUTH-BUG-006 — chốt hành vi mong muốn khi đăng xuất lúc mất mạng.
- **Dev/Security:** AUTH-BUG-005 vẫn chờ xác nhận là bug hay rủi ro chấp nhận.
- **BA:** `docs/requirements/auth/auth.md` vẫn chưa có rule "Ghi nhớ đăng nhập"/logout; expected result là giả định Tester.
- **PM/BA:** chưa có ClickUp task ID và dòng trong `docs/requirements/change-log.md` cho các bug fix.
- Chưa test: SSO (`/sso/verify`), chuyển sang tài khoản con của phụ huynh — không có account trong `docs/testing/test-data.md`.
- Chưa test: AUTH-BUG-006 khi tắt ghi nhớ; logout lỗi phía API trong lúc vẫn có mạng (`/api/auth/logout` trả 500 trước khi xóa cookie — chỉ đọc code).
- Không chạy lại baseline trên `develop` lần này; kết luận "bug còn trên develop" dựa trên lịch sử git.

## Cách chạy lại

```bash
# Terminal 1: bắt buộc port 3000 (BE chỉ cho phép origin localhost:3000)
git checkout nhánh-fix-bug-develop   # hoặc develop sau khi merge
pnpm install
pnpm dev -p 3000

# Terminal 2: cần TEST_STUDENT_PASSWORD trong .env
E2E_BASE_URL=http://localhost:3000 pnpm exec playwright test -c tests/e2e/playwright.config.ts tests/e2e/auth/remember-me-storage.spec.ts
E2E_BASE_URL=http://localhost:3000 pnpm exec playwright test -c tests/e2e/playwright.config.ts tests/e2e/auth/remember-me-storage.spec.ts --grep @known-bug
```

Nếu port 3000 đang bận, dừng process đang chiếm port thay vì để Next.js tự chuyển port khác (sẽ không đăng nhập được). Nên mở `/vi/login` và `/vi/student/assignments` một lần trước khi chạy để dev server compile sẵn.

## Evidence

- HTML report, screenshot, video, trace: `_bmad-output/test-artifacts/e2e-results/` (local, gitignore, không commit).
- AUTH-TC-009: `artifacts/auth-remember-me-storage-G-f9f7c-*/test-failed-2.png` cho thấy trang học sinh của tài khoản cũ sau khi đã đăng xuất.
- Trace/video có màn hình nhập mật khẩu → không chia sẻ ra ngoài team.
