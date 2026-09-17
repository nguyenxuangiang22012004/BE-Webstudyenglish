# AI Reading Guide

Status: reviewed
Owner: BA/DEV/TEST
Last reviewed: 2026-09-16
Related:
  - docs/ai/team-ai-overview.md
  - docs/ai/documentation-structure.md
  - docs/workflows/feature-delivery-workflow.md
  - docs/requirements/change-log.md
  - docs/requirements/change-workflow.md
  - AGENTS.md
  - README.md

Tài liệu này là lối vào nhanh cho AI khi cần đọc tài liệu trong repo.

Nếu người đọc chưa biết folder `docs/` dùng để làm gì, BMad là gì hoặc luồng PM/BA -> Dev -> Test đi như thế nào, hãy bắt đầu từ `docs/ai/team-ai-overview.md`.

## Nguyên tắc ưu tiên

1. Nếu task liên quan code đang chạy, đọc `AGENTS.md` và code gần task trước.
2. Nếu tài liệu liên quan trực tiếp mâu thuẫn với code, ưu tiên tài liệu (hành vi kỳ vọng), xem code là hiện trạng có thể đang lệch, và ghi rõ điểm lệch. Nếu tài liệu mơ hồ, lỗi thời hoặc mâu thuẫn với tài liệu khác, nêu giả định và hỏi lại. Chi tiết trong `AGENTS.md`.
3. Nếu file có `Status: generated`, kiểm tra `Source` trước khi xem đó là contract cuối cùng.
4. Nếu file có `Status: needs-review`, dùng làm định hướng nhưng không coi là đã xác minh.
5. Nếu file thiếu metadata, coi là ghi chú cũ hoặc chưa phân loại cho tới khi có bằng chứng khác.
6. Với nghiệp vụ hiện tại, không đưa `exercise` vào flow hoặc requirement trừ khi người dùng yêu cầu rõ.

## Khi làm BA hoặc phân tích nghiệp vụ

Bắt đầu bằng `docs/ai/ba/ba-workflow.md`. File này quy định:

- Ghi nhận yêu cầu khách hàng: có minh chứng thì tạo file trong `docs/requirements/requests/`, không có minh chứng thì ghi mục `Source` trong requirement.
- Phân loại yêu cầu: feature mới, thay đổi chức năng cũ, bug, câu hỏi/ước lượng.
- Template requirement, change note, customer request trong `docs/ai/ba/templates/`.
- Quy ước ClickUp Task ID, API/quyền đề xuất cho BE, xác nhận và nghiệm thu với khách.
- Definition of Done trước khi `Ready for Dev`.

Nguồn đọc thường dùng sau đó:

1. `docs/requirements/overview.md`
2. File domain trong `docs/requirements/`
3. Link `Related` sang design, API, security và test case nếu có
4. Code route/component/API gần feature nếu cần xác minh thực tế

## Khi làm DEV

Bắt đầu bằng `AGENTS.md` và `docs/ai/dev/dev-workflow.md`. File workflow quy định:

- Phân vai Dev FE (code trong repo này) và Dev BE (xác nhận API/quyền, sinh lại `docs/api/`, `docs/security/`).
- Điều kiện bắt đầu implement, tự kiểm tra trước PR, template mô tả PR, tài liệu cần cập nhật.
- Quy trình chốt API giữa PM/BA, Dev BE, Dev FE nằm trong `docs/workflows/api-contract-workflow.md`.

Nguồn đọc thường dùng sau đó:

1. `AGENTS.md`
2. `README.md`
3. Route/page entry liên quan trong `src/app/`
4. Feature component trong `src/components/features/`
5. API/type/store/hook liên quan
6. Tài liệu `docs/requirements/`, `docs/design/`, `docs/api/`, `docs/security/` được link từ task

## Khi làm TEST hoặc tạo test case

Bắt đầu bằng `docs/ai/testing/tester-workflow.md`. File này quy định:

- Phân loại task: test thay đổi requirement, verify bug/security finding, automation, regression.
- Thứ tự đọc cho từng loại task.
- Giới hạn của vai trò Tester: không sửa source code sản phẩm.
- Output bắt buộc và vị trí lưu: test case, bug report, test report trong `docs/test-cases/<domain>/`; automation trong `tests/e2e/`.
- Definition of Done trước khi báo hoàn thành.

Nguồn đọc thường dùng sau đó:

1. `docs/ai/testing/test-case-generation.md`
2. Requirement liên quan trong `docs/requirements/`
3. Design liên quan trong `docs/design/`
4. API contract trong `docs/api/`
5. Permission/security trong `docs/security/`
6. Test context trong `docs/testing/`
7. Test case hiện có trong `docs/test-cases/`

Không dừng ở output nháp của BMad trong `_bmad-output/`; folder này bị gitignore.

## Dấu hiệu cần hỏi lại hoặc xác minh

- `Status: needs-review` nhưng task yêu cầu quyết định nghiệp vụ cuối cùng.
- `Status: generated` nhưng thiếu `Source`.
- Tài liệu nói một route/API tồn tại nhưng code không tìm thấy.
- Tài liệu design thiếu requirement hoặc page/component liên quan.
- Có nhiều file mô tả cùng một luồng nhưng khác nhau về API, permission hoặc state.

## Khi task là thay đổi requirement

Nếu task mới thay đổi một chức năng đã tồn tại, đọc thêm:

1. `docs/requirements/change-workflow.md` để biết nên sửa file requirement cũ hay tạo file mới.
2. `docs/requirements/change-log.md` để biết file requirement nào đã thay đổi và test impact là gì.

Tester nên bắt đầu từ `docs/requirements/change-log.md` trước khi mở file requirement chi tiết.

## Khi task là bug hoặc security finding

Bug/finding thường không có sẵn dòng trong `change-log.md`. Không vì thế mà bỏ qua tài liệu:

- BA/Dev: làm theo mục "Bug fix và security finding" trong `docs/requirements/change-workflow.md`.
- Tester: làm theo "Loại B" trong `docs/ai/testing/tester-workflow.md`.

## Khi cần hiểu luồng PM/BA -> Dev -> Test

Đọc `docs/workflows/feature-delivery-workflow.md` để nắm luồng tổng thể của một task/chức năng từ lúc làm rõ yêu cầu đến khi test và accept.
