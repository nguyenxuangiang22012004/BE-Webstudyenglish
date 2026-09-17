# GRD-BUG-004 - Tạo được khối lớp trùng hoàn toàn với khối lớp đã có

Status: closed (không phải bug)
Severity: —
Found: 2026-09-17
Closed: 2026-09-17
Environment: Local dev `next dev --turbopack` tại `http://localhost:3000`, API `https://api-enspire-develop.xlms.vn`, Chromium (Playwright)
Build: `develop` @ `079bbc6b`
Account: Admin `truongadmin` (password từ `TEST_ADMIN_PASSWORD`)
Related:
  - Test case: docs/test-cases/schools/grade.md#grd-tc-015 (out-of-scope)
  - Requirement: docs/requirements/schools/grade.md (mục 3)
  - Report: docs/test-cases/schools/reports/2026-09-17-grade.md
  - ClickUp: sẽ cập nhật sau

## Lý do đóng

Xác nhận ngày 2026-09-17: chức năng khối lớp **chưa có verify trùng lặp**. Việc tạo được khối lớp trùng là hành vi hiện tại theo phạm vi, không phải bug. GRD-TC-015 và GRD-TC-023 chuyển sang out-of-scope, automation tương ứng đã gỡ khỏi `tests/e2e/schools/grade-crud.spec.ts`.

## Hiện trạng ghi nhận (tham khảo)

- Tạo khối lớp có cùng Số khối, Tên tiếng Việt, Tên tiếng Anh với khối lớp đã có: `POST /v1/grades` trả HTTP 200, UI báo thành công, danh sách có 2 bản ghi giống nhau (khác id).
- Dữ liệu test (`E2E-GRD-...-duplicate-...`) đã được xóa.

## Notes

- **Needs review (BA):** requirement mục 3 vẫn ghi "Grade cần có tên rõ ràng và tránh trùng lặp trong cùng phạm vi" — cần cập nhật cho khớp xác nhận trên. Khi bổ sung verify trùng lặp, mở lại GRD-TC-015/023.
