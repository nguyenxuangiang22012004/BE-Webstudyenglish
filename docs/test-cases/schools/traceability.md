---
requirement: ../../requirements/schools/grade.md
domain: schools
type: traceability
---

# Traceability - Schools

Status: draft
Owner: TEST
Last reviewed: 2026-09-17
Related:
  - Test cases: docs/test-cases/schools/grade.md
  - Report: docs/test-cases/schools/reports/2026-09-17-grade.md

## Grade (quản lý khối lớp)

Requirement: `docs/requirements/schools/grade.md`. Automation: `tests/e2e/schools/grade-crud.spec.ts`. Role test: chỉ Admin. Kết quả theo lần chạy 2026-09-17 trên `develop` @ `079bbc6b`.

| Rule / nguồn | Test case | Loại | Kết quả | Bug |
| --- | --- | --- | --- | --- |
| GRD-BR-001 - CRUD khối lớp (xem, tìm, thêm, xóa) | GRD-TC-001, 002, 005, 006, 008, 011, 012, 014, 016, 019, 021, 022, 025, 026, 027 | Auto | Pass | |
| GRD-BR-001 - Sửa khối lớp | GRD-TC-020 | Auto | **Fail** | GRD-BUG-003 |
| GRD-BR-001 - Hiển thị ngày tạo | GRD-TC-003 | Auto | **Fail** | GRD-BUG-001 |
| GRD-BR-001 - Hiển thị ngày tạo bản ghi mới | GRD-TC-004 | Auto | Pass | |
| GRD-BR-001 - Phân trang | GRD-TC-007 | Auto | **Fail** | GRD-BUG-002 |
| GRD-BR-001 - Lỗi API (list/create/update/delete) | GRD-TC-009, 017, 024, 029 | Auto (mock) | Pass | |
| GRD-BR-001 - i18n locale en | GRD-TC-035 | Auto | Pass | |
| GRD-BR-002 - Grade dùng cho dữ liệu trường/chương trình | Regression impact (grade.md) | — | Chưa có test case | |
| GRD-BR-003 - Nhập được khối 1 và 12 | GRD-TC-013 | Auto | Biên Pass; hiển thị lỗi validation **Fail** | GRD-BUG-005 |
| GRD-BR-003 - Số khối không giới hạn 1-12 | GRD-TC-018 (cover bởi GRD-TC-011) | Auto | Pass | |
| GRD-BR-NEW-03 (đề xuất) - Xóa grade đang được class dùng | GRD-TC-028 | Manual | Blocked (thiếu test data, rule chưa chốt) | |
| Requirement mục 3 - Tránh trùng lặp | GRD-TC-015, 023 | — | Out-of-scope (chưa có verify trùng lặp) | GRD-BUG-004 (closed, không phải bug) |
| Requirement mục 3 - Trạng thái active/inactive | GRD-TC-010 | — | Out-of-scope | |
| Security - role khác Admin | GRD-TC-030 → 034 | — | Out-of-scope | |

Rule `GRD-BR-NEW-*` là ID đề xuất tạm của Tester, cần BA xác nhận và đưa vào requirement.
