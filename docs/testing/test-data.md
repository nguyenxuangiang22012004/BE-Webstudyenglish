# Test Data

Status: draft
Owner: TEST
Related:
  - docs/testing/environments.md
  - docs/security/overview.md

## Mục đích

Tài liệu này mô tả account và dữ liệu test dùng chung cho manual QA, regression và automation.

## Test accounts

| Role | Username | Password reference | Environment |
| --- | --- | --- | --- |
| Student | `1hsep` | `TEST_STUDENT_PASSWORD` | Local, Public (`https://dev.xlms.vn`) |
| Teacher | `10gvgv` | `TEST_TEACHER_PASSWORD` | Local, Public (`https://dev.xlms.vn`) |
| Admin | `truongadmin` | `TEST_ADMIN_PASSWORD` | Local, Public (`https://dev.xlms.vn`) |
| Parent | `parent_user1` (có tài khoản con liên kết) | `TEST_PARENT_PASSWORD` | Local (đã dùng 2026-09-17); Public chưa kiểm tra |

## Quy tắc sử dụng account

- Không commit password thật vào repo.
- Không đổi password của account test nếu chưa thông báo cho team.
- Không dùng account test để tạo dữ liệu không thể rollback nếu chưa có kế hoạch cleanup.
- Khi viết automation, đọc password từ environment variables hoặc secret store.

Ví dụ biến môi trường local:

```text
TEST_STUDENT_PASSWORD=
TEST_TEACHER_PASSWORD=
TEST_ADMIN_PASSWORD=
TEST_PARENT_PASSWORD=
```

## Ghi chú cho AI Tester

- Khi test theo role, đối chiếu thêm `docs/security/` để xác định quyền kỳ vọng.
- Khi tạo test case, chỉ ghi role và username nếu cần; không ghi password vào test case.
- Nếu test cần dữ liệu seed cụ thể, bổ sung vào file này hoặc tạo file test data riêng theo domain.

