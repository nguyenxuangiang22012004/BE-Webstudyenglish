# GRD-BUG-003 - Admin không sửa được khối lớp: `PUT /v1/grades/{id}` luôn trả 404 "Access denied: Not Found"

Status: open
Severity: high
Found: 2026-09-17
Environment: Local dev `next dev --turbopack` tại `http://localhost:3000`, API `https://api-enspire-develop.xlms.vn`, Chromium (Playwright)
Build: `develop` @ `079bbc6b`
Account: Admin `truongadmin` (password từ `TEST_ADMIN_PASSWORD`)
Related:
  - Test case: docs/test-cases/schools/grade.md#grd-tc-020
  - Requirement: docs/requirements/schools/grade.md (mục 2: API `PUT /v1/grades/{id}`)
  - API: docs/api/schools/grade.md
  - Security: docs/security/resources/grades.md
  - Report: docs/test-cases/schools/reports/2026-09-17-grade.md
  - ClickUp: sẽ cập nhật sau

## Steps to reproduce

1. Đăng nhập admin, mở `/vi/admin/grades`.
2. Bấm nút sửa (icon bút) trên một khối lớp.
3. Đổi Tên tiếng Việt (hoặc bất kỳ trường nào), bấm "Lưu".

## Expected result

- Cập nhật thành công: toast "Cập nhật khối lớp thành công.", dialog đóng, danh sách hiển thị giá trị mới.
- Admin có quyền cập nhật grade (requirement mục 2 liệt kê `PUT /v1/grades/{id}`; admin có toàn quyền trên resource `grades`).

## Actual result

- `PUT /v1/grades/{id}` trả **HTTP 404** body `{"message":"Access denied: Not Found","error":"Not Found"}`.
- Dialog vẫn mở, dữ liệu không đổi. Theo code, toast lỗi hiển thị message server "Access denied: Not Found" — thông báo khó hiểu với người dùng.
- Cùng bản ghi đó, `GET /v1/grades/{id}` trả 200 và `DELETE /v1/grades/{id}` hoạt động bình thường → bản ghi tồn tại, không phải lỗi id.

Kiểm tra trực tiếp API bằng token admin (bản ghi test `E2E-GRD-PROBE-A`, id 29, đã xóa sau khi kiểm tra):

| Payload `PUT /v1/grades/29` | HTTP |
| --- | --- |
| `number` giữ nguyên + đổi 2 tên + `fields: "number,name_vn,name_en"` (đúng payload FE gửi) | 404 |
| Đổi `number` + đổi 2 tên + `fields` | 404 |
| Đổi 2 tên, không có `fields` | 404 |
| Chỉ `name_vn` + `fields: "name_vn"` | 404 |

## Evidence

- Automation `GRD-TC-020` (2026-09-17): request `PUT` gửi đúng id và payload; assertion `PUT /v1/grades/{id} trả HTTP 404` → **Fail**. Screenshot lúc fail: dialog "Sửa khối lớp" vẫn mở với giá trị mới, dòng trong bảng giữ tên cũ (`_bmad-output/test-artifacts/e2e-results/artifacts/`, local, không commit).
- Script probe API (Playwright `APIRequestContext`, không log token) — bảng kết quả ở trên.

## Notes

- `docs/security/resources/grades.md` chỉ có các action `destroy`, `index`, `restore`, `show`, `store` — **không có `update`**. Thông báo "Access denied" gợi ý request bị chặn ở tầng phân quyền, có thể do action `update` của resource `grades` chưa được khai báo/gán cho role. Đây là phỏng đoán từ tài liệu và message, cần BE xác nhận.
- Ảnh hưởng: toàn bộ chức năng "Sửa" trên màn hình quản lý khối lớp không dùng được với role Admin.
- Sau khi fix: chạy lại GRD-TC-020 (và GRD-TC-019, 021, 022, 024 để regression dialog sửa).
