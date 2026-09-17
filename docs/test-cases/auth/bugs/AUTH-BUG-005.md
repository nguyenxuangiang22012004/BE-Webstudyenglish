# AUTH-BUG-005 - Access/refresh token vẫn lộ cho JavaScript dù đã dùng cookie httpOnly

Status: open
Severity: medium
Found: 2026-09-16
Re-checked: 2026-09-17
Environment: Local, code review branch `nhánh-fix-bug-develop` @ `0c6dc0c3` (chưa có evidence runtime trực tiếp)
Account: Bất kỳ (đã đối chiếu luồng Student, Parent → tài khoản con, SSO)
Related:
  - Requirement: docs/requirements/auth/auth.md (AUTH-BR-004)
  - Security: docs/security/overview.md
  - Bug liên quan: docs/test-cases/auth/bugs/AUTH-BUG-006.md, docs/test-cases/auth/bugs/AUTH-BUG-007.md
  - Automation (đã viết, chưa chạy): tests/e2e/auth/token-exposure.spec.ts
  - ClickUp: chưa có

## Mô tả

Sau `10b598c3`, access token và refresh token đã được server đặt trong cookie httpOnly. Nhưng app vẫn trả token trong response body và lưu access token ở Local Storage, vì các request API được gọi thẳng từ trình duyệt tới `NEXT_PUBLIC_API_URL` với header `Authorization: Bearer <token>` đọc từ Local Storage. Script chạy trên trang (XSS, extension độc hại) hoặc người dùng chung máy có thể lấy được token.

## Hướng xử lý đã chốt (2026-09-17)

Chọn **phương án 1 — Next server gắn token (BFF/proxy)**:

- Trình duyệt chỉ gọi route của Next; Next server đọc cookie httpOnly `authToken` và gắn `Authorization` khi chuyển tiếp tới API.
- Token không trả về và không lưu ở nơi JavaScript đọc được.

Các phương án đã loại: giữ access token trong bộ nhớ (XSS vẫn đọc được trong lúc trang mở), API tự đọc cookie (phụ thuộc thay đổi backend), `sessionStorage` hoặc cookie không httpOnly (JavaScript vẫn đọc được).

## Steps to reproduce

1. Mở DevTools → Network, đăng nhập Student (có hoặc không tick ghi nhớ).
2. Xem response body của `POST /api/auth/login`.
3. Xem Application → Local Storage.
4. Gọi hoặc chờ `POST /api/auth/refresh-token`, xem response body.
5. Xem request bất kỳ tới API (`NEXT_PUBLIC_API_URL`), kiểm tra header `Authorization`.

## Expected result (tiêu chí đóng bug)

- Response body của `/api/auth/login`, `/api/auth/loginPHX`, `/api/auth/refresh-token` không chứa `access_token`/`refresh_token`.
- Local Storage và Session Storage không có key chứa token (`token`).
- Trình duyệt không tự gắn `Authorization: Bearer` khi gọi API; token chỉ được gắn ở phía Next server.
- Luồng phụ huynh vào tài khoản con không đưa token của con cho JavaScript.
- Không regression: đăng nhập, làm mới phiên, đăng xuất, ghi nhớ đăng nhập, SSO, phụ huynh vào tài khoản con vẫn hoạt động (AUTH-TC-001 → 013).

## Actual result (theo code @ `0c6dc0c3`)

- `src/app/api/auth/login/route.tsx` trả `{ ...data }` gồm `exchange_token.access_token` và `exchange_token.refresh_token`.
- `src/app/api/auth/loginPHX/route.ts` (SSO) trả `data` gồm `exchange_token`; `src/app/[locale]/sso/verify/page.tsx` lưu access token vào Local Storage key `token`.
- `src/app/api/auth/refresh-token/route.tsx` trả `data: data.exchange_token` (gồm refresh token); interceptor `src/constants/config/api.ts` lưu access token mới vào key `token`.
- `src/providers/auth.tsx` lưu access token vào key `token` sau đăng nhập.
- API `/profile/children-token` (`src/api/user.ts`) trả cặp token của tài khoản con cho trình duyệt; `src/app/[locale]/parents/childrens/page.tsx` lưu vào Local Storage và cookie không httpOnly.
- 10 file trong `src/` đọc hoặc ghi key `token`: `src/api/auth.ts`, `src/api/chat.ts`, `src/api/course.ts`, `src/constants/config/api.ts`, `src/providers/auth.tsx`, `src/app/[locale]/parents/childrens/page.tsx`, `src/app/[locale]/manage/question-bank/create-question/page.tsx`, `src/components/features/chat/FileMessage.tsx`, `src/components/features/chat/FilePreviewDialog.tsx`, `src/components/features/question-editor/create-question-modal.tsx`. Đây là phạm vi retest khi fix.

## Evidence

- Code review tại `0c6dc0c3`. Không ghi giá trị token.
- Evidence runtime gián tiếp: AUTH-TC-009 trên build `3f11d640` (trước fix AUTH-BUG-006) thấy `POST /api/auth/refresh-token` trả `200` và key `token` xuất hiện lại trong Local Storage.
- AUTH-TC-013 (AUTH-BUG-007): Local Storage `token` chứa token của tài khoản con sau khi phụ huynh vào tài khoản con.
- `tests/e2e/auth/token-exposure.spec.ts` (AUTH-TC-014 `@known-bug`, chỉ ghi tên field/key) đã viết nhưng **chưa chạy**.

## Notes

- Hành vi có từ trước `10b598c3`, không phải regression của các fix auth.
- Không có commit nào sửa bug này tính tới `0c6dc0c3`.
- `src/app/[locale]/callback/page.tsx` lưu `xlms-token` (token đăng nhập Supabase qua popup) vào Local Storage — khác cặp token LMS ở trên, cần Dev xác nhận có nằm trong phạm vi phương án 1 không.
- Fix theo phương án 1 nên xử lý cùng AUTH-BUG-007: phiên chỉ còn một nguồn là cookie do server quản lý.
- **Needs review (Dev/Security):** xác nhận phạm vi thay đổi (danh sách file ở trên, luồng SSO, tài khoản con, `xlms-token`) và cách chống CSRF cho các route proxy (hiện cookie dùng `sameSite: 'lax'`).
- **Needs review (BA):** bổ sung rule lưu token ở client vào `docs/requirements/auth/auth.md` (AUTH-BR-004) theo hướng đã chốt.

## Lịch sử re-check

- 2026-09-17 @ `3f11d640` (có `d01a8fec`): không đổi; token trong body refresh-token là một mắt xích của AUTH-BUG-006.
- 2026-09-17 @ `0c6dc0c3` (có `b4b9ea01`): không đổi; AUTH-BUG-006 đã chặn việc khôi phục phiên sau logout offline, nhưng token vẫn lộ trong phiên đang đăng nhập.
- 2026-09-17: chốt phương án 1, chuyển trạng thái `needs-review` → `open`.
