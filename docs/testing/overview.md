# Testing Documentation

Status: draft
Owner: TEST
Related:
  - docs/ai/testing/test-case-generation.md
  - docs/test-cases/

## Mục đích

Folder `docs/testing/` chứa test context và chuẩn kiểm thử dùng chung cho manual QA, regression và automation.

Folder này trả lời câu hỏi:

> Test ở đâu, dùng dữ liệu nào, account nào, error code nào và viết automation theo chuẩn nào?

## Cấu trúc đề xuất

```text
docs/testing/
  overview.md
  environments.md
  test-data.md
  error-codes.md
  bypass-login.md
  automation-standard.md
```

## Vai trò từng file

| File | Trạng thái | Nội dung |
| --- | --- | --- |
| `environments.md` | Đã có | Môi trường test, base URL, API URL, account scope và giới hạn dữ liệu. |
| `test-data.md` | Đã có | Account test, seed data, convention tạo dữ liệu và teardown. |
| `test-automation-workflow.md` | Đã có | Luồng automation, quy ước Playwright trong `tests/e2e/`, cách chạy, bảo mật evidence. |
| `error-codes.md` | Chưa có | Error code/message kỳ vọng để QA và AI Tester verify. |
| `bypass-login.md` | Chưa có | Cách bypass login nếu được phép trong môi trường test. |
| `automation-standard.md` | Chưa có | Hiện quy ước automation tạm nằm trong `test-automation-workflow.md`. |

AI không được giả định nội dung của file "Chưa có". Nếu task cần, ghi `needs-review` trong report.

## Phân biệt với test case

`docs/testing/` không chứa test case chi tiết của từng feature.

Test case thật nên đặt trong `docs/test-cases/`.

