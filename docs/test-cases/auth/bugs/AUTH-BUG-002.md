# AUTH-BUG-002 - Tắt "Ghi nhớ đăng nhập" nhưng đóng/mở lại trình duyệt vẫn đăng nhập

Status: verified (trên branch fix) — chưa merge `develop`
Severity: high
Found: 2026-09-16
Verified: 2026-09-17
Environment: Local dev (`next dev`) + API môi trường Development (`NEXT_PUBLIC_API_URL` trong `.env`), branch `nhánh-fix-bug-develop` @ `127ecf73`
Account: Student `1hsep`
Related:
  - Test case: docs/test-cases/auth/remember-me.md#auth-tc-006
  - Requirement: docs/requirements/auth/auth.md (AUTH-BR-004; chưa có rule remember-me)
  - Bug gốc: docs/test-cases/auth/bugs/AUTH-BUG-001.md
  - ClickUp: chưa có

## Steps to reproduce

1. Mở `/vi/login`, nhập tài khoản hợp lệ, **không** tick "Ghi nhớ đăng nhập", đăng nhập.
2. Đóng hẳn trình duyệt (cookie phiên bị xóa; Local Storage giữ nguyên).
3. Mở lại trình duyệt, vào `/vi/login`.

## Expected result

Không ghi nhớ → phiên kết thúc khi đóng trình duyệt: không còn token trên máy, người dùng phải đăng nhập lại.

## Actual result

- Local Storage vẫn còn `token` (access token) và `authUser`.
- App tự điều hướng rời trang login sang `/vi` — client coi người dùng vẫn đăng nhập.

## Evidence

- Playwright `AUTH-TC-006 @known-bug` fail 2/2 lần chạy:
  - "Access token vẫn còn trong Local Storage sau khi đóng trình duyệt"
  - "App vẫn coi là đã đăng nhập và rời trang login" (URL nhận được: `http://localhost:3456/vi`)
- Screenshot/trace: `_bmad-output/test-artifacts/e2e-results/artifacts/auth-remember-me-storage-G-2d210-*` (local, không commit).

## Notes

Phân tích sơ bộ: fix `10b598c3` chuyển cookie sang cookie phiên khi tắt ghi nhớ, nhưng `AuthProvider` (`src/providers/auth.tsx`) vẫn lưu access token vào Local Storage và coi người dùng đã đăng nhập chỉ dựa vào key `token`. Local Storage không bị trình duyệt xóa khi đóng, nên lựa chọn "không ghi nhớ" không có hiệu lực ở phía client. Mức độ ảnh hưởng thực tế khi gọi API (token hết hạn/401) cần Dev xác nhận.

## Kết quả verify (2026-09-17)

| Mục | Kết quả |
| --- | --- |
| Commit fix | `d01a8fec` — "fix các bug tồn đọng trong file md" (sửa `src/providers/auth.tsx`, `src/app/[locale]/login/page.tsx`) |
| Branch chứa fix | `nhánh-fix-bug-develop` (local + `origin`), build test tại `3f11d640` |
| Đã vào `develop`? | **Chưa** (`git merge-base --is-ancestor d01a8fec origin/develop` → không; `origin/develop` @ `079bbc6b`) |
| Đã vào `main`/`pre`/`staging*`? | Chưa (`git branch -r --contains d01a8fec` chỉ có `origin/nhánh-fix-bug-develop`) |
| Automation | `AUTH-TC-006` **Pass** 2/2 lần chạy tại `http://localhost:3000` (bỏ tag `@known-bug`) |

Thay đổi chính của fix (đọc diff, không đề xuất sửa): `AuthProvider` khi mount thấy có `token` trong Local Storage nhưng không còn cookie `userType` (cookie phiên khi tắt ghi nhớ) thì xóa `token`, `authUser`, `phxLogin` và không coi người dùng đã đăng nhập.

Kết quả thực tế: tắt ghi nhớ → đóng/mở trình duyệt → Local Storage không còn `token`, người dùng ở lại trang login.

Kết luận: **đã fix trên `nhánh-fix-bug-develop`**. Chuyển `closed` sau khi fix vào `develop` và chạy lại AUTH-TC-006 trên develop.

Lưu ý khi đọc code (chưa test): luồng SSO (`src/app/[locale]/sso/verify/page.tsx`) và chuyển sang tài khoản con của phụ huynh (`src/app/[locale]/parents/childrens/page.tsx`) tự đặt cookie `userType` có hạn, nên cách kiểm tra mới vẫn áp dụng được. Chưa có account SSO/phụ huynh để test.
