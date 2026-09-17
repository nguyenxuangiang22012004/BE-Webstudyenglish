# AUTH-BUG-001 - Mật khẩu lưu dạng văn bản rõ trong Local Storage khi bật "Ghi nhớ đăng nhập"

Status: verified (trên branch fix) — chưa merge `develop`
Severity: high
Found: 2026-09-16
Verified: 2026-09-16, re-verified 2026-09-17
Environment: Local dev (`next dev`) + API môi trường Development (`NEXT_PUBLIC_API_URL` trong `.env`)
Account: Student `1hsep` (password từ `TEST_STUDENT_PASSWORD`)
Related:
  - Test case: docs/test-cases/auth/remember-me.md#auth-tc-001, #auth-tc-002, #auth-tc-003, #auth-tc-004, #auth-tc-005
  - Requirement: docs/requirements/auth/auth.md (chưa có rule, xem Notes)
  - Report: docs/test-cases/auth/reports/2026-09-16-remember-me.md
  - ClickUp: chưa có task ID — cần PM/BA bổ sung

## Mô tả

Khi bật tính năng ghi nhớ đăng nhập, mật khẩu của người dùng được lưu trữ dưới dạng văn bản rõ trong Local Storage (key `rememberedCredentials`). Lưu thông tin nhạy cảm như mật khẩu trong Local Storage mà không có biện pháp bảo vệ làm tăng nguy cơ bị truy cập/đánh cắp (XSS, extension, thiết bị dùng chung).

## Steps to reproduce

1. Mở `/vi/login`.
2. Nhập username/password hợp lệ, tick "Ghi nhớ đăng nhập", bấm "Đăng nhập".
3. DevTools → Application → Local Storage.

## Expected result

- Không lưu mật khẩu ở bất kỳ storage phía client nào.
- Chỉ lưu username (nếu cần để điền sẵn form); việc duy trì phiên do cookie httpOnly đảm nhiệm.
- Dữ liệu `rememberedCredentials` cũ trên máy người dùng bị xóa.

## Actual result (trước fix — code `develop` @ `67ecb361`)

Local Storage có key `rememberedCredentials` = JSON `{ username, password, rememberMe }`, mật khẩu dạng văn bản rõ. Mở lại trang login thì mật khẩu được điền sẵn vào form.

Nguồn: `src/app/[locale]/login/page.tsx` (hàm `onSubmit` và `useEffect` load credentials) trên `develop`/`AI_doc`.

## Kết quả verify (2026-09-16)

| Mục | Kết quả |
| --- | --- |
| Commit fix | `10b598c3` — "xóa mật khẩu được lưu ở localstorage khi ấn ghi nhớ đăng nhập và refactor code cơ chế auth" |
| Branch chứa fix | `nhánh-fix-bug-develop` (local + `origin`), build test tại `127ecf73` |
| Đã vào `develop`? | **Chưa** (`git merge-base --is-ancestor 10b598c3 origin/develop` → không) |
| Đã vào `main`/`staging*`? | Chưa |
| Automation trên branch fix | AUTH-TC-001 → 005: **Pass** trên `127ecf73` (3 lần chạy full, lần 3 chạy độc lập tại `http://localhost:3100`) |
| Baseline trên `develop` @ `67ecb361` | AUTH-TC-001, 002, 004, 005: **Fail**; AUTH-TC-003: Pass (xem Notes) — **bug vẫn tồn tại trên `develop`** |

Chi tiết baseline `develop` (chạy tại `http://localhost:3101`, không ghi giá trị):

- AUTH-TC-001: Local Storage có key `rememberedCredentials` chứa username + mật khẩu dạng văn bản rõ → tái hiện đúng bug.
- AUTH-TC-004: mở lại trang login, ô mật khẩu được điền sẵn mật khẩu thật.
- AUTH-TC-002 / 005: chưa có cookie `rememberMe`, không xóa `rememberedUsername` — đúng vì `develop` chưa có fix.
- AUTH-TC-003 pass ngẫu nhiên: code cũ `JSON.parse` giá trị đã được helper parse sẵn → lỗi → nhánh `catch` xóa key. Không có nghĩa `develop` có cơ chế dọn dữ liệu cũ.

Thay đổi chính của fix (đọc diff, không đề xuất sửa):

- Login page chỉ lưu `rememberedUsername`; mật khẩu không còn ghi vào client.
- `rememberedCredentials` bị xóa khi mở trang login, khi `AuthProvider` mount và khi logout.
- Thêm `src/lib/auth-cookies.ts`: cookie `authToken`/`refreshToken`/`h5p_token`/`rememberMe` httpOnly; có `maxAge` khi bật ghi nhớ, cookie phiên khi tắt. Refresh token giữ nguyên vòng đời theo cookie `rememberMe`.

Kết luận: bug gốc **đã được fix và verify trên `nhánh-fix-bug-develop`**. Chuyển `closed` sau khi fix merge vào `develop` và chạy lại AUTH-TC-001 → 005 trên môi trường develop.

## Re-verify (2026-09-17)

| Mục | Kết quả |
| --- | --- |
| Build | `nhánh-fix-bug-develop` @ `3f11d640` (thêm fix `d01a8fec` cho bug liên quan) |
| Đã vào `develop`? | **Chưa** — `origin/develop` @ `079bbc6b` không chứa `10b598c3` lẫn `d01a8fec` |
| Đã vào `main`/`pre`/`staging*`? | Chưa (`git branch -r --contains` chỉ có `origin/nhánh-fix-bug-develop`) |
| Automation | AUTH-TC-001 → 005: **Pass** 2/2 lần chạy full tại `http://localhost:3000` — không bị regression bởi `d01a8fec` |

Trạng thái giữ nguyên: đã fix trên branch fix, bug vẫn tồn tại trên `develop` (theo lịch sử git; không chạy lại baseline develop lần này).

## Bug liên quan phát hiện khi verify

Trạng thái cập nhật 2026-09-17:

- [AUTH-BUG-002](AUTH-BUG-002.md) — Tắt ghi nhớ nhưng access token vẫn nằm trong Local Storage, đóng/mở trình duyệt vẫn đăng nhập (high) — **verified trên branch fix** (`d01a8fec`).
- [AUTH-BUG-003](AUTH-BUG-003.md) — Đăng xuất khi mất mạng không xóa token trong Local Storage (medium) — **verified trên branch fix** (`d01a8fec`).
- [AUTH-BUG-004](AUTH-BUG-004.md) — Đăng nhập thất bại vẫn lưu username (low) — **verified trên branch fix** (`d01a8fec`).
- [AUTH-BUG-005](AUTH-BUG-005.md) — Access/refresh token vẫn lộ cho JavaScript (response body + Local Storage), làm giảm tác dụng của cookie httpOnly (medium, needs-review) — không đổi.
- [AUTH-BUG-006](AUTH-BUG-006.md) — Đăng xuất khi mất mạng: có mạng lại thì phiên cũ tự khôi phục (high, open) — mới, phát hiện 2026-09-17.

## Evidence

- Kết quả Playwright: `_bmad-output/test-artifacts/e2e-results/html` (local, không commit).
- Không có screenshot/trace chứa password; test chỉ ghi tên key bị lộ, không ghi giá trị.

## Notes

- **Needs review (BA):** `docs/requirements/auth/auth.md` chưa có rule cho "Ghi nhớ đăng nhập". Expected result là giả định của Tester.
- **Change-log:** `docs/requirements/change-log.md` chưa có dòng cho bug fix này — ghi nhận, không tự thêm.
- Người dùng đã bật ghi nhớ ở phiên bản cũ: mật khẩu chỉ bị xóa khi họ mở lại app sau khi deploy fix. Cân nhắc khuyến nghị đổi mật khẩu cho thiết bị dùng chung (quyết định thuộc PM/BA).
