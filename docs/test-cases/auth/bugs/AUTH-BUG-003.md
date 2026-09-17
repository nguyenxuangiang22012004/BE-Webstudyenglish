# AUTH-BUG-003 - Đăng xuất khi mất mạng không xóa token trong Local Storage

Status: verified (trên branch fix) — chưa merge `develop`
Severity: medium
Found: 2026-09-16
Verified: 2026-09-17
Environment: Local dev (`next dev`) + API môi trường Development (`NEXT_PUBLIC_API_URL` trong `.env`), branch `nhánh-fix-bug-develop` @ `127ecf73`
Account: Student `1hsep`
Related:
  - Test case: docs/test-cases/auth/remember-me.md#auth-tc-007
  - Requirement: docs/requirements/auth/auth.md (AUTH-BR-002)
  - Bug gốc: docs/test-cases/auth/bugs/AUTH-BUG-001.md
  - ClickUp: chưa có

## Steps to reproduce

1. Đăng nhập có tick "Ghi nhớ đăng nhập".
2. Mở menu avatar ở header.
3. Ngắt mạng (DevTools → Network → Offline), bấm "Đăng xuất".
4. Kiểm tra Local Storage.

## Expected result

Dù request logout lỗi, dữ liệu phiên trên máy (`token`, `authUser`) phải bị xóa để người dùng khác trên cùng thiết bị không dùng lại được.

## Actual result

Sau 10 giây, `token` và `authUser` vẫn còn trong Local Storage.

## Evidence

- Playwright `AUTH-TC-007 @known-bug` fail: "token/authUser vẫn còn trong Local Storage sau khi đăng xuất" (`hasToken: true`, `hasAuthUser: true`).
- Screenshot/trace: `_bmad-output/test-artifacts/e2e-results/artifacts/auth-remember-me-storage-G-9a774-*` (local, không commit).

## Notes

Phân tích sơ bộ: trong `logoutFn` (`src/providers/auth.tsx`), lệnh xóa Local Storage nằm sau `fetch('/api/auth/logout')`; khi fetch lỗi mạng, hàm throw trước khi tới bước xóa và `logout()` bỏ qua lỗi. Hành vi này đã có từ trước fix `10b598c3`, không phải regression.

## Kết quả verify (2026-09-17)

| Mục | Kết quả |
| --- | --- |
| Commit fix | `d01a8fec` — "fix các bug tồn đọng trong file md" (sửa `src/providers/auth.tsx`, `src/app/[locale]/login/page.tsx`) |
| Branch chứa fix | `nhánh-fix-bug-develop` (local + `origin`), build test tại `3f11d640` |
| Đã vào `develop`? | **Chưa** (`git merge-base --is-ancestor d01a8fec origin/develop` → không; `origin/develop` @ `079bbc6b`) |
| Đã vào `main`/`pre`/`staging*`? | Chưa (`git branch -r --contains d01a8fec` chỉ có `origin/nhánh-fix-bug-develop`) |
| Automation | `AUTH-TC-007` **Pass** 2/2 lần chạy tại `http://localhost:3000` (bỏ tag `@known-bug`) |

Thay đổi chính của fix (đọc diff, không đề xuất sửa): `logoutFn` gọi dọn dữ liệu client (`token`, `authUser`, `rememberedCredentials`, `phxLogin`, cookie `userType`/`userId`) trong `finally`, nên chạy kể cả khi request logout lỗi; `logout()` luôn reset state và điều hướng về `/login`.

Kết quả thực tế: đăng xuất khi offline → Local Storage không còn `token`/`authUser`.

Thay đổi test code: bản cũ của AUTH-TC-007 đọc Local Storage trên tab chính; sau fix, app điều hướng về `/login` khi đang offline nên tab chính thành trang trắng và `page.evaluate` lỗi "Execution context was destroyed" (lỗi test code, không phải bug). Test giờ chờ request logout lỗi, bật lại mạng rồi đọc cờ qua tab phụ mở file tĩnh cùng origin.

Kết luận: **phạm vi bug này (dữ liệu trên Local Storage) đã fix trên `nhánh-fix-bug-develop`**. Chuyển `closed` sau khi fix vào `develop` và chạy lại AUTH-TC-007.

**Còn bug liên quan:** cookie httpOnly và refresh token không bị hủy khi logout offline, có mạng lại thì phiên cũ tự khôi phục → [AUTH-BUG-006](AUTH-BUG-006.md) (high, open).
