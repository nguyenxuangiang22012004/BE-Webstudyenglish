# Test Report - Ghi nhớ đăng nhập (verify AUTH-BUG-001) - 2026-09-16

Status: fail (bug gốc đã fix trên branch fix; còn bug liên quan)
Tester: AI Tester (Claude) — cần người review
Environment: Local dev `next dev` tại `http://localhost:3456`, API môi trường Development (`NEXT_PUBLIC_API_URL` trong `.env`), Chromium (Playwright)
Build: `nhánh-fix-bug-develop` @ `127ecf73` (chứa fix `10b598c3`)
Account: Student `1hsep` (password từ `TEST_STUDENT_PASSWORD`, không ghi vào report)
Related:
  - Test cases: docs/test-cases/auth/remember-me.md
  - Automation: tests/e2e/auth/remember-me-storage.spec.ts
  - Bug: docs/test-cases/auth/bugs/AUTH-BUG-001.md → AUTH-BUG-005.md

## Scope

Verify bug: "Khi bật ghi nhớ đăng nhập, mật khẩu người dùng được lưu dạng văn bản rõ trong Local Storage".

- Tìm fix: commit `10b598c3`, chỉ nằm trên `nhánh-fix-bug-develop` (local + origin). **Chưa merge vào `develop`** (`origin/develop` @ `67ecb361`), `main`, `staging*`.
- Chạy regression luồng remember-me/logout trên build fix.
- Đọc flow xung quanh (login page, `AuthProvider`, API route login/logout/refresh-token/loginPHX, `auth-cookies`) để tìm bug còn sót.

## Kết quả

Chạy full suite 2 lần. Lần 1, AUTH-TC-001 fail do app compile route lần đầu (dev server lạnh, timeout chờ redirect); chạy lại riêng và chạy full lần 2 đều pass → xếp vào lỗi môi trường, không phải bug. Bảng dưới là kết quả lần 2.

| TC-ID | Scenario | Loại | Kết quả | Bug |
| --- | --- | --- | --- | --- |
| AUTH-TC-001 | Bật ghi nhớ: không có mật khẩu trong Local/Session Storage, cookie | Auto | Pass | AUTH-BUG-001 (verified) |
| AUTH-TC-002 | Bật ghi nhớ: cookie httpOnly, có hạn dài | Auto | Pass | |
| AUTH-TC-003 | Xóa dữ liệu cũ `rememberedCredentials` | Auto | Pass | |
| AUTH-TC-004 | Điền sẵn username, mật khẩu trống | Auto | Pass | |
| AUTH-TC-005 | Tắt ghi nhớ: xóa username, cookie phiên | Auto | Pass | |
| AUTH-TC-006 | Tắt ghi nhớ, đóng/mở trình duyệt phải đăng nhập lại | Auto | **Fail** | AUTH-BUG-002 |
| AUTH-TC-007 | Đăng xuất khi mất mạng xóa token | Auto | **Fail** | AUTH-BUG-003 |
| AUTH-TC-008 | Đăng nhập thất bại không lưu username | Auto | **Fail** | AUTH-BUG-004 |
| — | Token lộ cho JavaScript (response body + Local Storage) | Code review | Needs review | AUTH-BUG-005 |

Tổng: 5 pass / 3 fail (đều là `@known-bug`) / 1 needs-review.

### Lần chạy 3 (độc lập) — branch fix

Build `nhánh-fix-bug-develop` @ `127ecf73` (git worktree riêng), `http://localhost:3100`. Kết quả giống lần 2: AUTH-TC-001 → 005 pass, AUTH-TC-006/007/008 fail với cùng thông báo lỗi (`hasToken: true`, `hasAuthUser: true` sau logout offline; `rememberedUsername` được lưu cho username không tồn tại). Tổng 5 pass / 3 fail, 2.9 phút.

### Baseline — `develop` @ `67ecb361`

Build `origin/develop` (git worktree riêng), `http://localhost:3101`, chỉ chạy AUTH-TC-001 → 005.

| TC-ID | Kết quả | Ghi chú |
| --- | --- | --- |
| AUTH-TC-001 | **Fail** | Còn key `rememberedCredentials` chứa mật khẩu văn bản rõ → bug gốc còn trên `develop` |
| AUTH-TC-002 | **Fail** | Thiếu cookie `rememberMe` (chưa có fix) |
| AUTH-TC-003 | Pass | Pass ngẫu nhiên, xem AUTH-BUG-001 Notes |
| AUTH-TC-004 | **Fail** | Ô mật khẩu được điền sẵn mật khẩu thật |
| AUTH-TC-005 | **Fail** | `rememberedUsername` cũ không bị xóa (chưa có fix) |

AUTH-TC-006 → 008 chưa chạy trên `develop`: lần chạy full bị chặn bởi chính sách quyền của phiên AI (đăng nhập lặp lại vào API develop dùng chung) — cần tester chạy tay nếu muốn so sánh.

### Thay đổi test code trong lần chạy này

Khi chạy baseline `develop`, assertion của AUTH-TC-001 (`toBeUndefined` trên giá trị `rememberedCredentials`) và AUTH-TC-004 (`toHaveValue('')` trên ô mật khẩu) **in giá trị mật khẩu thật** ra console và HTML report khi fail. Đã sửa `tests/e2e/auth/remember-me-storage.spec.ts` để hai assertion này chỉ kiểm tra cờ có/không. Bản sửa **chưa được chạy lại** (bị chặn như trên) — cần chạy lại cả trên branch fix lẫn `develop` để xác nhận.

## Bug

| Bug | Severity | Status | Tóm tắt |
| --- | --- | --- | --- |
| AUTH-BUG-001 | high | verified trên branch fix, chưa vào `develop` | Mật khẩu văn bản rõ trong Local Storage — đã fix |
| AUTH-BUG-002 | high | open | Tắt ghi nhớ nhưng token vẫn trong Local Storage, mở lại trình duyệt vẫn đăng nhập |
| AUTH-BUG-003 | medium | open | Logout khi mất mạng không xóa token |
| AUTH-BUG-004 | low | open | Đăng nhập thất bại vẫn lưu username (regression nhỏ của fix) |
| AUTH-BUG-005 | medium | needs-review | Access/refresh token vẫn lộ cho JavaScript |

## Needs review / Blocked

- **BA:** `docs/requirements/auth/auth.md` chưa có rule "Ghi nhớ đăng nhập" (lưu gì ở client, vòng đời phiên khi bật/tắt). Expected result hiện là giả định Tester.
- **PM/BA:** chưa có ClickUp task ID và chưa có dòng trong `docs/requirements/change-log.md` cho bug fix này.
- **Dev:** merge `10b598c3` vào `develop`; sau đó Tester chạy lại AUTH-TC-001 → 005 trên develop để chuyển AUTH-BUG-001 sang `closed`.
- **Dev/Security:** xác nhận AUTH-BUG-005 là bug hay rủi ro chấp nhận.
- Đã chạy baseline AUTH-TC-001 → 005 trên `develop` @ `67ecb361` (bug gốc còn). Chưa chạy AUTH-TC-006 → 008 trên `develop`.
- **Tester:** chạy lại spec sau khi sửa assertion (xem "Thay đổi test code") trên cả hai build.
- Chưa test luồng SSO (`/api/auth/loginPHX`, `callback`) — không có tài khoản SSO trong `docs/testing/test-data.md`.

## Cách chạy lại

```bash
# Terminal 1: chạy app ở branch cần test
git checkout nhánh-fix-bug-develop   # hoặc develop sau khi merge
pnpm install
pnpm dev -p 3456

# Terminal 2: chạy test (cần TEST_STUDENT_PASSWORD trong .env)
E2E_BASE_URL=http://localhost:3456 pnpm exec playwright test -c tests/e2e/playwright.config.ts tests/e2e/auth/remember-me-storage.spec.ts
```

Nên mở `/vi/login` và `/vi/student` một lần trước khi chạy để dev server compile sẵn, tránh timeout ở test đầu.

## Evidence

- HTML report, screenshot, video, trace: `_bmad-output/test-artifacts/e2e-results/` (local, gitignore, không commit).
- Test chỉ ghi tên key/cờ có-không, không ghi giá trị password/token. Trace/video có thể chứa màn hình nhập mật khẩu → không chia sẻ ra ngoài.
- **Cảnh báo:** HTML report/artifact của lần chạy baseline `develop` (trước khi sửa assertion) chứa mật khẩu văn bản rõ của account `1hsep`. Xóa `_bmad-output/test-artifacts/e2e-results/` hoặc chạy lại để ghi đè; không chia sẻ thư mục này.
