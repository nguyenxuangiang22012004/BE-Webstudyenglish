# AI PM/BA Workflow

Status: reviewed
Owner: PM/BA
Last reviewed: 2026-09-16
Related:
  - AGENTS.md
  - docs/ai/reading-guide.md
  - docs/ai/ba/templates/customer-request.md
  - docs/ai/ba/templates/feature-requirement.md
  - docs/ai/ba/templates/change-note.md
  - docs/requirements/requests/overview.md
  - docs/requirements/change-workflow.md
  - docs/requirements/change-log.md
  - docs/workflows/feature-delivery-workflow.md
  - docs/workflows/api-contract-workflow.md
  - docs/ai/testing/tester-workflow.md

## Mục đích

Đây là điểm vào duy nhất cho AI khi được giao vai trò PM/BA.

Tài liệu trả lời:

1. Nhận yêu cầu từ khách hàng thì lưu ở đâu?
2. Yêu cầu thuộc loại nào và xử lý theo nhánh nào?
3. Requirement viết theo template nào, cần những mục gì để Dev FE, Dev BE và Tester dùng được?
4. Khi nào được chuyển `Ready for Dev`?

## Bối cảnh bắt buộc phải nhớ

- Task được quản lý trên **ClickUp**. Mọi requirement, change-log, commit/PR, bug report dùng chung ClickUp Task ID.
- Requirement trong repo FE này là **nguồn chung cho cả Dev FE và Dev BE**. Nhu cầu API và phân quyền mới phải được viết rõ trong requirement để BE đọc.
- `docs/api/` được sinh từ Swagger, `docs/security/` được sinh từ dữ liệu phân quyền. BA **không sửa tay** hai folder này; API/quyền đề xuất ghi trong requirement.
- Tài liệu được ưu tiên hơn code (xem `AGENTS.md`): requirement mô tả hành vi **kỳ vọng**, code là hiện trạng triển khai. Khi đọc code thấy lệch requirement, ghi rõ điểm lệch; chỉ sửa requirement theo code khi xác nhận tài liệu đã lỗi thời hoặc khách hàng đồng ý hành vi hiện tại.

## Quy tắc của vai trò PM/BA

- Không sửa source code, config, test code.
- Được tạo/sửa: `docs/requirements/`, `docs/design/` (khi được giao), và cập nhật `docs/requirements/change-log.md`.
- Không tự chốt nghiệp vụ thay khách hàng. Điểm chưa rõ ghi vào `Open questions`.
- Không tự chốt API contract thay BE. Ghi ở mục "API đề xuất", đánh dấu `proposed`; PM/BA/Dev BE chốt theo `docs/workflows/api-contract-workflow.md`.
- Không lưu thông tin nhạy cảm của khách vào repo: số điện thoại, email cá nhân, dữ liệu học sinh thật, giá hợp đồng. Thay bằng mô tả hoặc che bớt.
- Output của BMad skill trong `_bmad-output/` là nháp cục bộ (gitignore). Kết quả chính thức phải ghi vào `docs/requirements/`.

## Quy ước ClickUp Task ID

| Nội dung | Quy ước |
| --- | --- |
| Định dạng trong tài liệu | `CU-<task-id>`, ví dụ `CU-86c1ab2de` |
| Custom Task ID (nếu workspace bật) | Dùng nguyên custom ID, ví dụ `LMS-123` |
| Link | Ghi URL ClickUp đầy đủ ở mục `Source` hoặc `Related` |
| Chưa có task ClickUp | Ghi `CU-pending`, phải cập nhật trước khi chuyển `Ready for Dev` |

Dùng cùng một ID trong: tên file request, cột `Task` của change-log, change log trong file requirement, commit/PR, bug report.

## Bước 1: Ghi nhận yêu cầu từ khách hàng

Yêu cầu có thể đến qua email, file, biên bản họp, tin nhắn, cuộc gọi hoặc trao đổi trực tiếp. Xử lý theo có hay không có minh chứng:

| Trường hợp | Cách ghi nhận |
| --- | --- |
| **Có minh chứng** (email, file, biên bản, ảnh chụp tin nhắn, mockup) | Tạo file `docs/requirements/requests/<yyyy-mm-dd>-<task-id>-<slug>.md` theo `docs/ai/ba/templates/customer-request.md`. Tóm tắt nội dung gốc, link tới vị trí lưu minh chứng (ClickUp attachment, Drive). Không commit file đính kèm có thông tin nhạy cảm. |
| **Không có minh chứng** (gọi điện, trao đổi miệng, họp không có biên bản) | Không bắt buộc tạo file request. Ghi mục `Source` trong requirement/change note: ai yêu cầu, ngày, kênh, người ghi nhận. Bắt buộc có bước xác nhận lại với khách (Bước 4) và ghi kết quả vào mục `Customer confirmation`. |

Yêu cầu lớn hoặc qua nhiều vòng trao đổi thì nên tạo file request kể cả khi minh chứng không đầy đủ, để giữ lịch sử làm rõ.

## Bước 2: Phân loại yêu cầu

| Loại | Dấu hiệu | Output chính |
| --- | --- | --- |
| A. Feature mới | Chức năng/màn hình/flow chưa có trong requirement và code | File requirement mới theo `feature-requirement.md` |
| B. Thay đổi chức năng đã có | Sửa rule, field, validation, quyền, flow của chức năng hiện có | Cập nhật requirement cũ hoặc change note theo `docs/requirements/change-workflow.md` |
| C. Bug khách báo | Hệ thống không làm đúng requirement/kỳ vọng hiện tại | Bug report theo luồng bug trong `docs/workflows/feature-delivery-workflow.md`; bổ sung rule nếu requirement chưa mô tả |
| D. Câu hỏi / ước lượng / tư vấn | Khách hỏi hệ thống có làm được X không, chi phí/thời gian | Câu trả lời dựa trên requirement + code; nếu dẫn tới yêu cầu mới thì chuyển sang A hoặc B |

Nếu không chắc là A hay B: tìm trong `docs/requirements/` và code route/component. Đã có chức năng tương tự → B.

### Chọn skill BMad theo loại yêu cầu

AI tự chọn skill theo bảng dưới, người dùng không cần ghi tên skill trong prompt.

| Tình huống | Skill BMad | Ghi chú |
| --- | --- | --- |
| A. Feature mới, yêu cầu còn mơ hồ | `bmad-forge-idea` | Dùng ở Bước 4 để làm rõ ý tưởng và tìm open question. Yêu cầu đã rõ: bỏ qua. |
| Trước khi chuyển `Ready for Dev` (A hoặc B lớn) | `bmad-advanced-elicitation` | Soát lỗ hổng requirement: case biên, quyền, dữ liệu, lỗi. |
| B. Thay đổi nhỏ | Không dùng | Cập nhật trực tiếp theo `change-workflow.md`. |
| C. Bug khách báo | Không dùng | Theo luồng bug trong `feature-delivery-workflow.md`. |
| D. Tư vấn cần nghiên cứu bên ngoài (thị trường, công nghệ, đối thủ) | `bmad-deep-recon` | Câu hỏi trả lời được từ requirement/code: không dùng. |

Quy tắc khi dùng skill:

- Không dùng `bmad-prd`, `bmad-spec`, `bmad-product-brief` để viết requirement: các skill này sinh tài liệu theo format riêng, lệch template trong `docs/ai/ba/templates/`. Requirement luôn viết theo template của repo.
- Prompt ghi `Không dùng BMad` → bỏ qua bảng trên, làm trực tiếp.
- Prompt ghi tên skill cụ thể → dùng skill đó thay cho bảng trên (trừ trường hợp viết requirement ở quy tắc đầu tiên; khi đó chỉ dùng output làm nháp tham khảo).
- Skill hỏi thông tin đã có trong `docs/` → tự lấy từ tài liệu, chỉ hỏi người dùng khi tài liệu không có.
- Output skill ghi vào `_bmad-output/` là nháp; nội dung cần giữ phải chuyển vào `docs/requirements/`.

## Bước 3: Đọc context

1. `docs/requirements/overview.md` và `docs/requirements/lms-features-by-role.md` để xác định domain, role.
2. File requirement của domain liên quan và các link `Related`.
3. `docs/requirements/change-log.md`: có thay đổi nào đang dang dở trên cùng domain không.
4. `docs/security/rbac-matrix.md` hoặc `docs/security/roles/` nếu yêu cầu liên quan quyền.
5. `docs/api/<domain>/` để biết API hiện có, tránh đề xuất trùng.
6. `docs/design/<domain>/` nếu có.
7. Code route/component liên quan (`src/app/[locale]/...`, `src/components/features/...`) để xác nhận hành vi hiện tại. Chỉ đọc, không sửa.

## Bước 4: Làm rõ và xác nhận với khách hàng

- Liệt kê `Open questions`, mỗi câu có người cần trả lời (khách hàng, PM, BE, UX).
- Câu hỏi chặn nghiệp vụ phải được khách trả lời trước khi `Ready for Dev`.
- Ghi câu trả lời ngay dưới câu hỏi, kèm ngày và kênh.
- Sau khi chốt, xác nhận lại phạm vi với khách và ghi vào mục `Customer confirmation`:
  - Ai xác nhận, ngày, kênh (email/ClickUp comment/họp).
  - Nếu chỉ xác nhận miệng, ghi rõ `verbal` và người ghi nhận.

## Bước 5: Viết requirement

- Loại A: tạo `docs/requirements/<domain>/<feature>.md` theo `docs/ai/ba/templates/feature-requirement.md`.
- Loại B: theo `docs/requirements/change-workflow.md`; change note dùng `docs/ai/ba/templates/change-note.md`.
- Business rule ID: `<MODULE>-BR-<NUMBER>`, tiếp nối số lớn nhất đang có trong domain. Không đánh lại ID cũ.
- Acceptance criteria viết dạng Given/When/Then, mỗi AC link tới BR.
- Nếu cần API/quyền mới: điền mục "API đề xuất cho BE" và "Phân quyền đề xuất", trạng thái `proposed`.
- Nếu có UI mới: link mockup/Figma trong `Related`. Nếu cần tài liệu design chi tiết, ghi `Needs review` cho UX/DEV tạo `docs/design/<domain>/`.
- Khi tạo file requirement mới: thêm link vào mục "Tài liệu bổ sung đã thêm" của `docs/requirements/overview.md`, và cập nhật `docs/requirements/lms-features-by-role.md` nếu thêm chức năng cho role.

## Bước 6: Cập nhật change-log

Thêm dòng vào `docs/requirements/change-log.md`:

- `Task`: ClickUp Task ID.
- `Source`: file request nếu có, hoặc `verbal: <người yêu cầu>, <ngày>`.
- `Test impact`: đánh giá sơ bộ, Tester có thể điều chỉnh.
- `Status`: `Draft` khi còn open question chặn; `Ready for Dev` khi đạt Definition of Done bên dưới.

Trạng thái trên ClickUp và cột `Status` trong change-log phải khớp nhau.

## Bước 7: Nghiệm thu (UAT)

Sau khi Tester pass:

- Ghi kết quả nghiệm thu vào mục `Customer confirmation` → `UAT` của requirement/change note: người nghiệm thu, ngày, kết quả (accept/reject/accept có điều kiện), phản hồi.
- Nếu khách yêu cầu chỉnh thêm: tạo yêu cầu mới (quay lại Bước 1), không sửa lén requirement đã `Done`.
- Cập nhật change-log `Status = Done`.

## Definition of Done trước khi `Ready for Dev`

- [ ] Có ClickUp Task ID (không còn `CU-pending`).
- [ ] Nguồn yêu cầu được ghi: file request (có minh chứng) hoặc mục `Source` (không có minh chứng).
- [ ] Đã phân loại A/B/C/D, chọn skill BMad theo bảng ở Bước 2 (nếu cần) và dùng đúng template.
- [ ] Business rule có ID; acceptance criteria dạng Given/When/Then, link tới BR.
- [ ] Role/phân quyền liên quan đã ghi, đối chiếu `docs/security/`.
- [ ] Nếu cần API mới/đổi API: mục "API đề xuất cho BE" đủ endpoint, input, output, lỗi, quyền; đã `confirmed-by-BE`, hoặc ghi rõ FE làm song song với mock.
- [ ] Không còn open question chặn; câu trả lời đã ghi kèm ngày/kênh.
- [ ] Mục `Customer confirmation` đã có xác nhận phạm vi.
- [ ] Test impact đã đánh giá.
- [ ] Đã thêm dòng `change-log.md`; file mới đã link vào `requirements/overview.md`.
- [ ] Câu trả lời cuối cùng cho người dùng liệt kê file đã tạo/cập nhật và các open question còn lại.

## Prompt mẫu

Nhận yêu cầu mới:

```text
Bạn đóng vai BA. Đọc docs/ai/ba/ba-workflow.md.
Khách hàng yêu cầu: "<nội dung>". ClickUp: CU-<id>. Nguồn: <email ngày ... / gọi điện với ...>.
Phân loại yêu cầu, đọc requirement và code liên quan, tạo file request (nếu có minh chứng) và bản nháp requirement.
Liệt kê open questions cần hỏi khách. Không sửa code.
```

Cập nhật sau khi khách trả lời:

```text
Bạn đóng vai BA. Đọc docs/ai/ba/ba-workflow.md và docs/requirements/<domain>/<feature>.md.
Khách đã trả lời open questions: <nội dung, ngày, kênh>.
Cập nhật requirement, customer confirmation, change-log. Kiểm tra Definition of Done để chuyển Ready for Dev.
```
