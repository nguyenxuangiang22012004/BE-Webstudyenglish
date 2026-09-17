# AUTH-BUG-004 - Đăng nhập thất bại vẫn lưu username vào Local Storage

Status: verified (trên branch fix) — chưa merge `develop`
Severity: low
Found: 2026-09-16
Verified: 2026-09-17
Environment: Local dev (`next dev`) + API môi trường Development (`NEXT_PUBLIC_API_URL` trong `.env`), branch `nhánh-fix-bug-develop` @ `127ecf73`
Account: username không tồn tại (sinh ngẫu nhiên)
Related:
  - Test case: docs/test-cases/auth/remember-me.md#auth-tc-008
  - Requirement: docs/requirements/auth/auth.md (chưa có rule remember-me)
  - Bug gốc: docs/test-cases/auth/bugs/AUTH-BUG-001.md
  - ClickUp: chưa có

## Steps to reproduce

1. Mở `/vi/login`.
2. Nhập username không tồn tại + mật khẩu sai, tick "Ghi nhớ đăng nhập", bấm "Đăng nhập".
3. Kiểm tra Local Storage.

## Expected result

Đăng nhập thất bại → hiển thị lỗi, không lưu `rememberedUsername`.

## Actual result

Hiển thị lỗi và ở lại trang login (đúng), nhưng Local Storage có `rememberedUsername` = username vừa nhập sai. Lần sau mở trang login, form điền sẵn username sai. Tương tự, đăng nhập thất bại với checkbox tắt sẽ xóa username đã ghi nhớ trước đó.

## Evidence

- Playwright `AUTH-TC-008 @known-bug` fail: "Username của lần đăng nhập thất bại vẫn bị lưu".
- Screenshot/trace: `_bmad-output/test-artifacts/e2e-results/artifacts/auth-remember-me-storage-G-4f290-*` (local, không commit).

## Notes

Phân tích sơ bộ: trong fix `10b598c3`, login page ghi/xóa `rememberedUsername` **trước** khi gọi `login()`; ngoài ra `login()` trong `AuthProvider` tự bắt lỗi và không throw, nên login page không biết đăng nhập thất bại. Đây là regression nhỏ do fix (code cũ lưu sau `login()`, nhưng cũng không phân biệt thành công/thất bại).

## Kết quả verify (2026-09-17)

| Mục | Kết quả |
| --- | --- |
| Commit fix | `d01a8fec` — "fix các bug tồn đọng trong file md" (sửa `src/providers/auth.tsx`, `src/app/[locale]/login/page.tsx`) |
| Branch chứa fix | `nhánh-fix-bug-develop` (local + `origin`), build test tại `3f11d640` |
| Đã vào `develop`? | **Chưa** (`git merge-base --is-ancestor d01a8fec origin/develop` → không; `origin/develop` @ `079bbc6b`) |
| Đã vào `main`/`pre`/`staging*`? | Chưa (`git branch -r --contains d01a8fec` chỉ có `origin/nhánh-fix-bug-develop`) |
| Automation | `AUTH-TC-008` **Pass** 2/2 lần chạy tại `http://localhost:3000` (bỏ tag `@known-bug`) |

Thay đổi chính của fix (đọc diff, không đề xuất sửa): login page không còn ghi/xóa `rememberedUsername` trước khi gọi `login()`; `login()` trong `AuthProvider` chỉ ghi/xóa key này sau khi đăng nhập thành công và trả `true`/`false`.

Kết quả thực tế: đăng nhập với username không tồn tại → vẫn ở `/login`, không có `rememberedUsername`.

Chưa test (đọc code): đăng nhập thất bại khi checkbox tắt không còn xóa username đã nhớ trước đó — cùng nhánh code với case đã test.

Kết luận: **đã fix trên `nhánh-fix-bug-develop`**. Chuyển `closed` sau khi fix vào `develop` và chạy lại AUTH-TC-008.
