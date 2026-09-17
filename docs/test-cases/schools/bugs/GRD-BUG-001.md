# GRD-BUG-001 - Cột "Ngày tạo" hiển thị sai "01/01/2001" thay vì "-" khi backend trả ngày mặc định

Status: open
Severity: low
Found: 2026-09-16
Environment: Local dev `next dev --turbopack` tại `http://localhost:3000`, API `https://api-enspire-develop.xlms.vn`, Chromium (Playwright)
Build: `develop` @ `079bbc6b`
Account: Admin `truongadmin` (password từ `TEST_ADMIN_PASSWORD`)
Related:
  - Test case: docs/test-cases/schools/grade.md#grd-tc-003
  - Requirement: docs/requirements/schools/grade.md
  - Report: docs/test-cases/schools/reports/2026-09-17-grade.md
  - ClickUp: sẽ cập nhật sau

## Steps to reproduce

1. Đăng nhập admin, mở `/vi/admin/grades`.
2. Xem cột "Ngày tạo" của các khối lớp có sẵn (Khối 1-6, Demo1).

## Expected result

Bản ghi không có ngày tạo hợp lệ (`created_at` rỗng hoặc giá trị mặc định `0001-01-01 00:00:00`) hiển thị "-". Đây là hành vi chính code trang đã dự định (`formatDate` trả "-" khi năm <= 1).

## Actual result

Cả 7 khối lớp có sẵn trên develop hiển thị **"01/01/2001"** — một ngày không có thật, dễ gây hiểu nhầm là dữ liệu tạo năm 2001.

Response `GET /v1/grades` trả `created_at: "0001-01-01 00:00:00"` cho 7 bản ghi này.

## Evidence

- Automation `GRD-TC-003` (mock 3 bản ghi), chạy 2026-09-17:
  - `created_at = "0001-01-01 00:00:00"` → Expected `-`, Received `01/01/2001` → **Fail**.
  - `created_at = ""` → `-` → Pass.
  - `created_at = "2026-09-16 10:20:30"` → `16/09/2026` → Pass.
- Screenshot khám phá 2026-09-16 (local, không commit): cột Ngày tạo = 01/01/2001 cho mọi dòng.
- Tái hiện độc lập bằng V8 (Node 20.11, cùng engine với Chromium):

  ```text
  new Date("0001-01-01 00:00:00").getFullYear()  → 2001
  new Date("0001-01-01T00:00:00Z").getFullYear() → 1
  ```

## Notes

Phân tích sơ bộ (không đề xuất fix):

- `formatDate` trong `src/app/[locale]/admin/grades/page.tsx` dùng `new Date(dateString)` rồi kiểm tra `getFullYear() <= 1`.
- Chuỗi `"0001-01-01 00:00:00"` (có dấu cách, không phải ISO chuẩn) được V8 parse theo nhánh legacy, năm `0001` bị hiểu là `2001` → điều kiện `<= 1` không bao giờ đúng.
- Khối lớp **tạo mới** có `created_at` đúng (ví dụ `2026-09-17 09:15:21`, GRD-TC-004 Pass) → lỗi chỉ lộ ra với dữ liệu cũ không có ngày tạo. Backend không có bug về lưu ngày tạo cho bản ghi mới.
- **Needs review (BE/Data):** 7 khối lớp có sẵn trên develop có `created_at` = giá trị mặc định; cần xác nhận môi trường khác (staging/production) có dữ liệu tương tự không để đánh giá phạm vi ảnh hưởng.
- Chưa kiểm tra các màn hình khác có parse chuỗi ngày dạng `YYYY-MM-DD HH:mm:ss` theo cùng cách (ngoài phạm vi đợt test này).
