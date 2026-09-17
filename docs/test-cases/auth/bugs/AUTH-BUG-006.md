# AUTH-BUG-006 - Đăng xuất khi mất mạng: có mạng lại thì phiên cũ tự khôi phục, người dùng sau xem được dữ liệu người trước

Status: verified (trên branch fix `nhánh-fix-bug-develop`)
Severity: high
Found: 2026-09-17
Re-checked: 2026-09-17 (fix `b4b9ea01`)
Environment: Local dev (`next dev -p 3000`) + API môi trường Development (`NEXT_PUBLIC_API_URL` trong `.env`), branch `nhánh-fix-bug-develop` @ `3f11d640` (chứa fix `10b598c3`, `d01a8fec`)
Account: Student `1hsep` (password từ `TEST_STUDENT_PASSWORD`)
Related:
  - Test case: docs/test-cases/auth/remember-me.md#auth-tc-009
  - Requirement: docs/requirements/auth/auth.md (AUTH-BR-002; chưa có rule remember-me/logout offline)
  - Bug liên quan: docs/test-cases/auth/bugs/AUTH-BUG-003.md (fix chưa trọn), docs/test-cases/auth/bugs/AUTH-BUG-005.md
  - Report: docs/test-cases/auth/reports/2026-09-17-remember-me.md, docs/test-cases/auth/reports/2026-09-17-remember-me-recheck.md
  - ClickUp: chưa có

## Mô tả

Sau fix AUTH-BUG-003, đăng xuất khi mất mạng đã xóa `token`/`authUser` trong Local Storage và cookie `userType`/`userId`. Nhưng request `/api/auth/logout` không tới được server nên các cookie httpOnly `authToken`, `refreshToken`, `h5p_token`, `rememberMe` vẫn còn và refresh token chưa bị thu hồi. Khi có mạng lại, chỉ cần mở một trang của role cũ, app tự lấy lại access token bằng refresh token còn sót và hiển thị dữ liệu của người vừa đăng xuất.

## Steps to reproduce

1. Mở `/vi/login`, đăng nhập Student, tick "Ghi nhớ đăng nhập".
2. Mở menu avatar ở header.
3. DevTools → Network → Offline, bấm "Đăng xuất".
4. Chuyển Network về Online.
5. Mở `/vi/student/assignments` (mô phỏng người dùng tiếp theo trên cùng máy).

## Expected result

Đăng xuất xong (kể cả lúc mất mạng) thì phiên cũ không được khôi phục: người dùng tiếp theo không xem được dữ liệu của người trước, không có access token mới trong Local Storage và phải đăng nhập lại.

## Actual result

- Sau bước 3: Local Storage không còn `token`/`authUser` (đúng, AUTH-BUG-003 đã fix).
- Cookie httpOnly còn sót: `authToken`, `refreshToken`, `h5p_token`, `rememberMe`.
- Sau bước 5: `POST /api/auth/refresh-token` được gọi 2 lần, cả 2 trả `200`; Local Storage có lại key `token`.
- Trang dừng ở `/vi/student/assignments?week=1&courseId=269`, hiển thị header học sinh (avatar, điểm), "Khóa học của tôi" và bài học của tài khoản vừa đăng xuất.

## Evidence

- Playwright `AUTH-TC-009 @known-bug` fail 2/2 lần chạy (2026-09-17, `http://localhost:3000`): "Phiên cũ được khôi phục: access token xuất hiện lại trong Local Storage".
- Annotation của test (chỉ tên/cờ, không có giá trị): cookie còn sót `authToken, refreshToken, h5p_token, rememberMe`; refresh-token responses `[200,200]`; URL sau 10 giây `/vi/student/assignments?week=1&courseId=269`.
- Screenshot `test-failed-2.png`, video, trace: `_bmad-output/test-artifacts/e2e-results/artifacts/auth-remember-me-storage-G-f9f7c-*` (local, không commit; trace có màn hình nhập mật khẩu).

## Notes

- Phân tích sơ bộ (đọc code, không đề xuất sửa):
  - `logoutFn` (`src/providers/auth.tsx`) chỉ dọn được dữ liệu phía client; cookie httpOnly chỉ xóa được ở server qua `/api/auth/logout`.
  - Middleware (`src/middleware.ts`) không chặn route `/student` khi thiếu cookie `userType`.
  - Interceptor axios (`src/constants/config/api.ts`) gặp 401 sẽ gọi `/api/auth/refresh-token`; route này dùng cookie `refreshToken` còn sót, trả access token trong response body (xem AUTH-BUG-005) và interceptor ghi lại vào Local Storage.
- Không phải regression của `d01a8fec`: trước fix, logout offline không xóa gì nên phiên cũng không kết thúc (AUTH-BUG-003). Fix đã xử lý phần client nhưng chưa làm phiên kết thúc thật sự.
- Đọc code thấy cùng hậu quả có thể xảy ra khi có mạng nhưng request `/v1/logout` từ Next server tới API bị lỗi: `src/app/api/auth/logout/route.tsx` trả 500 trước khi gọi `clearAuthCookies`. Trường hợp này **chưa tái hiện bằng test**.
- Đã chạy với "Ghi nhớ đăng nhập" bật. Khi tắt ghi nhớ, cookie còn sót là cookie phiên nên dự kiến rủi ro kéo dài tới khi đóng trình duyệt — chưa chạy test.
- **Needs review (BA/Dev):** chưa có rule mô tả hành vi mong muốn khi đăng xuất lúc mất mạng (ví dụ chặn đăng xuất, hay cho đăng xuất nhưng phải vô hiệu hóa phiên khi có mạng lại). Expected result ở trên là giả định của Tester.

## Re-check (2026-09-17, fix `b4b9ea01`)

Môi trường: Local, `http://localhost:3000` (`next dev -p 3000`), API Development (`NEXT_PUBLIC_API_URL` trong `.env`), branch `nhánh-fix-bug-develop` @ `0c6dc0c3`. Account Student `1hsep`.

### Fix

Commit `b4b9ea01` "fix các bug" (sửa `src/app/api/auth/logout/route.tsx`, `src/app/api/auth/refresh-token/route.tsx`, `src/lib/auth-cookies.ts`):

- `refresh-token`: nếu thiếu cookie `userType` (client đã đăng xuất) thì không cấp token mới, gọi thu hồi refresh token ở API, xóa cookie và trả `401`.
- `logout`: luôn xóa cookie kể cả khi gọi `/v1/logout` lỗi (bỏ nhánh trả `500` trước khi xóa cookie); thu hồi refresh token có gửi kèm access token.

### Kết quả

Chạy full `tests/e2e/auth/remember-me-storage.spec.ts` 2 lần: **12/12 pass** cả 2 lần.

| TC-ID | Kết quả | Ghi chú (chỉ tên/cờ, không có giá trị) |
| --- | --- | --- |
| AUTH-TC-009 (ghi nhớ bật) | Pass | Cookie còn sót ngay sau logout offline: `authToken, h5p_token, refreshToken, rememberMe`. Mở `/vi/student/assignments`: refresh-token `[401, 401]`, không có `token` trong Local Storage, cookie phiên bị xóa hết, URL `/vi/login`. Refresh token cũ không đổi được token mới. |
| AUTH-TC-010 (ghi nhớ tắt, mới) | Pass | Giống TC-009. |
| AUTH-TC-011 (non-regression, mới) | Pass | Phiên hợp lệ vẫn refresh được; đối chứng replay refresh token còn hợp lệ → làm mới được. |
| AUTH-TC-012 (logout online, mới) | Pass | Logout `200`, không còn cookie phiên, refresh token cũ bị thu hồi ở API. |

Kết luận: hành vi mô tả ở bug **không còn tái hiện** trên branch fix. Chuyển `closed` sau khi branch fix được review.

### Rủi ro còn lại / chưa test

- **Khoảng hở trước lần gọi refresh-token đầu tiên:** sau logout offline, cookie httpOnly `authToken`, `h5p_token`, `refreshToken` vẫn nằm trên trình duyệt cho tới khi có request làm route refresh-token chạy. `next.config.ts` rewrite `/:locale(vi|en)/h5p/*` sang `NEXT_PUBLIC_H5P_URL`, nên nếu người dùng tiếp theo mở URL H5P trước tiên thì cookie của người trước có thể được gửi kèm tới H5P server. **Tạm bỏ qua** theo quyết định Tester (2026-09-17), chưa test.
- Nếu người dùng tiếp theo đăng nhập ngay (không mở trang cần refresh), cookie cũ bị ghi đè nhưng refresh token cũ **không được thu hồi** ở API, còn hiệu lực tới khi hết hạn (không còn nằm trên máy). Chỉ đọc code.
- Trường hợp `/v1/logout` lỗi khi vẫn có mạng: chỉ đọc code (route không còn trả `500` trước khi xóa cookie); không mô phỏng được lỗi API server-to-server bằng Playwright.
- Luồng SSO (`/sso/verify`) và chuyển tài khoản con của phụ huynh đều đặt cookie `userType` nên không bị route refresh-token coi là đã đăng xuất (đọc code). Luồng phụ huynh đã test runtime: có bug riêng, xem [AUTH-BUG-007](AUTH-BUG-007.md). SSO chưa test vì thiếu account.
