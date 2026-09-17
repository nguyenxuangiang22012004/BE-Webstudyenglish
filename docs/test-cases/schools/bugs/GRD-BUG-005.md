# GRD-BUG-005 - Số khối 0, -1, 1.5 hiện tooltip gốc của trình duyệt (tiếng Anh) thay vì thông báo lỗi của form

Status: open
Severity: low
Found: 2026-09-17
Environment: Local dev `next dev --turbopack` tại `http://localhost:3000`, API `https://api-enspire-develop.xlms.vn`, Chromium (Playwright, locale `vi-VN`)
Build: `develop` @ `079bbc6b`
Account: Admin `truongadmin` (password từ `TEST_ADMIN_PASSWORD`)
Related:
  - Test case: docs/test-cases/schools/grade.md#grd-tc-013
  - Requirement: docs/requirements/schools/grade.md
  - Report: docs/test-cases/schools/reports/2026-09-17-grade.md
  - ClickUp: sẽ cập nhật sau

## Steps to reproduce

1. Đăng nhập admin, mở `/vi/admin/grades`, bấm "Thêm".
2. Nhập Tên tiếng Việt, Tên tiếng Anh hợp lệ.
3. Nhập Số khối lần lượt `0`, `-1`, `1.5`, `01`; mỗi lần bấm "Lưu".

## Expected result

- Mỗi giá trị không hợp lệ hiển thị thông báo lỗi của form dưới ô Số khối, cùng kiểu và ngôn ngữ với các lỗi khác ("Số khối phải là số nguyên lớn hơn 0").
- Không gửi request tạo.

## Actual result

| Giá trị | Kết quả | Thông báo |
| --- | --- | --- |
| `0` | Bị chặn bởi validation gốc HTML5 (`rangeUnderflow`) | Tooltip trình duyệt: "Value must be greater than or equal to 1." |
| `-1` | Bị chặn bởi validation gốc HTML5 (`rangeUnderflow`) | "Value must be greater than or equal to 1." |
| `1.5` | Bị chặn bởi validation gốc HTML5 (`stepMismatch`) | "Please enter a valid value. The two nearest valid values are 1 and 2." |
| `01` | Qua validation trình duyệt, bị chặn bởi validation của form | "Số khối phải là số nguyên lớn hơn 0" |

- Dữ liệu không hợp lệ **không** được gửi lên server (0 request `POST`) → không có rủi ro dữ liệu.
- Thông báo lỗi của form (tiếng Việt) không bao giờ hiện với `0`, `-1`, `1.5`; thay vào đó là tooltip gốc theo ngôn ngữ của trình duyệt, tự biến mất, không nằm cùng vị trí các lỗi khác.
- Với `01`, thông báo "phải là số nguyên lớn hơn 0" sai nghĩa (01 là số nguyên lớn hơn 0).

## Evidence

- Automation `GRD-TC-013` (2026-09-17, chạy 2 lần): 3 soft assertion "thông báo lỗi hiển thị" fail với `0`, `-1`, `1.5`; assertion "không gọi API" và biên `1`, `12` pass.
- Script probe đọc DOM: `form.noValidate = false`; `input.validity` và `validationMessage` như bảng trên.
- Tooltip gốc trình duyệt không xuất hiện trong screenshot headless; bằng chứng là `validationMessage`.

## Notes

- Phân tích sơ bộ (không đề xuất fix): input Số khối là `type="number" min={1} step={1}` trong form không có `noValidate`, nên trình duyệt chặn submit trước khi validation của `react-hook-form`/zod chạy.
- Ngôn ngữ tooltip phụ thuộc ngôn ngữ giao diện trình duyệt, không theo locale của app — người dùng Chrome tiếng Anh trên giao diện tiếng Việt sẽ thấy thông báo tiếng Anh.
- **Needs review (BA/Design):** requirement/design chưa quy định cách hiển thị lỗi validation. Xếp mức low vì chức năng chặn dữ liệu vẫn đúng.
