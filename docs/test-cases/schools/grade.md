---
requirement: ../../requirements/schools/grade.md
api: ../../api/schools/grade.md
security: ../../security/resources/grades.md
domain: schools
page: admin-grades
type: test-case
---

# Test Case - Quản lý khối lớp (Grade CRUD)

Status: draft
Owner: TEST
Last reviewed: 2026-09-17
Related:
  - Requirement: docs/requirements/schools/grade.md (GRD-BR-001, GRD-BR-002, GRD-BR-003)
  - API: docs/api/schools/grade.md
  - Security: docs/security/resources/grades.md
  - Automation: tests/e2e/schools/grade-crud.spec.ts
  - Bug: docs/test-cases/schools/bugs/
  - Report: docs/test-cases/schools/reports/2026-09-17-grade.md

## Phạm vi

Trang `/[locale]/admin/grades` (`src/app/[locale]/admin/grades/page.tsx`), dialog thêm/sửa (`src/components/features/grades/grade-form-dialog.tsx`), dialog xóa (`src/components/features/grades/delete-grade-dialog.tsx`), API module `src/api/grade.ts`.

Role test: **chỉ Admin**.

Bao gồm: xem danh sách, tìm kiếm, phân trang, thêm, sửa, xóa, validation, trạng thái lỗi API, hiển thị locale `en`.

Ngoài phạm vi (xác nhận 2026-09-17):

- Role khác Admin (teacher, student, school, chưa đăng nhập) — GRD-TC-030 → 034.
- Kiểm tra trùng lặp khối lớp — hệ thống chưa có verify trùng lặp — GRD-TC-015, 023.
- Trạng thái active/inactive — GRD-TC-010.
- Các màn hình dùng danh sách grade làm bộ lọc/dropdown (flip book, program create/edit, export report, `academic-filters`) — chỉ ghi nhận regression impact ở cuối file.

## Business rule dùng làm tiêu chí test

| Rule | Nguồn | Ghi chú kiểm thử |
| --- | --- | --- |
| GRD-BR-001 | Grade là khối/cấp lớp phân loại lớp học và học sinh | CRUD cơ bản |
| GRD-BR-002 | Grade hỗ trợ tổ chức dữ liệu trường học và chương trình học | Regression impact ở các màn hình dùng grade |
| GRD-BR-003 | Grade biểu diễn được 12 khối học (cấp 1-3) | Số khối 1 và 12 phải nhập được; **số khối không giới hạn 1-12** (xác nhận 2026-09-17) |
| Mục 3 - trùng lặp | "Grade cần có tên rõ ràng và tránh trùng lặp trong cùng phạm vi" | Ngoài phạm vi: hệ thống chưa có verify trùng lặp (xác nhận 2026-09-17) |
| Mục 3 - trạng thái | "Grade có trạng thái active/inactive" | Ngoài phạm vi: không test trạng thái (xác nhận 2026-09-17) |
| Mục 3 - xóa đang dùng | "Xóa grade đang được class sử dụng cần kiểm tra ràng buộc backend" | Chưa có Rule ID → đề xuất tạm `GRD-BR-NEW-03` (needs-review) |
| Security | admin: `index/show/store/destroy/restore` | docs/security/resources/grades.md — chỉ test role Admin |

> **Needs review (BA):**
> - Requirement mục 3 vẫn ghi "tránh trùng lặp" và "có trạng thái active/inactive", chưa khớp xác nhận 2026-09-17 (chưa có verify trùng lặp, không xét trạng thái). Đề nghị BA cập nhật requirement.
> - Hành vi khi xóa grade đang được class sử dụng (chặn hẳn / cảnh báo / soft delete) chưa chốt. Xem GRD-TC-028.

## Test Data

- Account (xem `docs/testing/test-data.md`, không ghi password): Admin `truongadmin` (`TEST_ADMIN_PASSWORD`).
- Môi trường: FE local **phải chạy ở `http://localhost:3000`** — API develop chỉ cho phép CORS từ origin này.
- Dữ liệu tạo trong test: tên bắt đầu bằng `E2E-GRD-<RUN_ID>-`, số khối ngẫu nhiên 500-899 (tránh trùng khối thật 1-12). Automation tự xóa sau mỗi test.
- Case lỗi server, phân trang nhiều trang, định dạng ngày: mock API bằng `page.route`, không tạo dữ liệu thật.
- Dữ liệu develop tại 2026-09-16: 7 khối lớp (số 1-6 và 9 `Demo1`), toàn bộ `created_at = "0001-01-01 00:00:00"`.

## Selector / UI element

| Element | Selector đang dùng | Ghi chú |
| --- | --- | --- |
| Tiêu đề | heading "Quản lý khối lớp" | |
| Nút thêm | button "Thêm" | |
| Ô tìm kiếm | placeholder "Tìm kiếm khối lớp..." | debounce 500 ms |
| Nút sửa/xóa trên dòng | button thứ 1 / thứ 2 trong dòng | Nút chỉ có icon, **không có accessible name** (needs-review) |
| Dialog thêm/sửa | dialog "Thêm mới khối lớp" / "Sửa khối lớp" | label "Số khối", "Tên tiếng Việt", "Tên tiếng Anh" |
| Dialog xóa | dialog "Xóa khối lớp" | nút "Xóa", "Hủy" |
| Toast | `[data-sonner-toast]`, `data-type="error"` cho lỗi | |

---

## Danh sách

## GRD-TC-001 - Mở trang từ sidebar: tiêu đề, nút Thêm, ô tìm kiếm và các cột

Status: draft
Priority: high
Type: functional
Related:
  - Business rule: GRD-BR-001

### Preconditions
Đăng nhập admin.

### Steps
1. Ở `/vi/admin/dashboard`, bấm menu sidebar "Quản lý khối lớp".

### Expected Results
- URL `/vi/admin/grades`.
- Hiển thị tiêu đề "Quản lý khối lớp", mô tả "Quản lý danh sách các khối lớp trong hệ thống", nút "Thêm", ô tìm kiếm.
- Bảng có các cột: STT, Số khối, Tên tiếng Việt, Tên tiếng Anh, Ngày tạo, Thao tác.

### Automation
tests/e2e/schools/grade-crud.spec.ts (`GRD-TC-001`)

## GRD-TC-002 - Danh sách hiển thị đúng dữ liệu API và thông tin phân trang

Status: draft
Priority: high
Type: functional
Related:
  - Business rule: GRD-BR-001
  - API: `GET /v1/grades`

### Preconditions
Đăng nhập admin, môi trường có ít nhất 1 khối lớp.

### Steps
1. Mở `/vi/admin/grades`.
2. So sánh từng dòng với response `GET /v1/grades?page=1&limit=10`.

### Expected Results
- Số dòng = số phần tử `grades` trả về.
- STT bắt đầu từ 1; Số khối, Tên tiếng Việt, Tên tiếng Anh khớp dữ liệu API.
- Thông tin phân trang: "Hiển thị 1 - min(limit, total) trong tổng số total khối lớp".

### Automation
tests/e2e/schools/grade-crud.spec.ts (`GRD-TC-002`)

## GRD-TC-003 - Cột Ngày tạo: ngày rỗng/mặc định hiển thị "-", ngày hợp lệ hiển thị dd/mm/yyyy

Status: draft
Priority: medium
Type: edge-case
Related:
  - Bug: docs/test-cases/schools/bugs/GRD-BUG-001.md

### Preconditions
Đăng nhập admin. Mock `GET /v1/grades` trả 3 bản ghi với `created_at` lần lượt: `"0001-01-01 00:00:00"`, `""`, `"2026-09-16 10:20:30"`.

### Steps
1. Mở `/vi/admin/grades`.
2. Xem cột "Ngày tạo" của 3 dòng.

### Expected Results
- `0001-01-01 00:00:00` (giá trị mặc định/zero của backend) → "-".
- Rỗng → "-".
- `2026-09-16 10:20:30` → "16/09/2026".

### Automation
tests/e2e/schools/grade-crud.spec.ts (`GRD-TC-003`, `@known-bug`)

### Notes
Expected "-" cho giá trị zero dựa trên chính logic của code (`formatDate` trả "-" khi năm <= 1) — ý định hiển thị đã rõ, không phải giả định nghiệp vụ.

## GRD-TC-004 - Khối lớp vừa tạo hiển thị ngày tạo là hôm nay

Status: draft
Priority: medium
Type: functional
Related:
  - API: `POST /v1/grades`, `GET /v1/grades`

### Preconditions
Đăng nhập admin. Tạo khối lớp `E2E-GRD-...` (qua API hoặc UI).

### Steps
1. Mở `/vi/admin/grades`, tìm dòng của khối lớp vừa tạo.

### Expected Results
- API trả `created_at` là thời điểm tạo thật (không phải `0001-01-01 00:00:00`).
- Cột "Ngày tạo" hiển thị ngày hôm nay (dd/mm/yyyy).

### Automation
tests/e2e/schools/grade-crud.spec.ts (`GRD-TC-004`)

### Notes
Case này tách bản ghi mới khỏi dữ liệu cũ: 7 khối lớp có sẵn trên develop có `created_at` mặc định (xem GRD-BUG-001), nhưng bản ghi tạo mới có ngày đúng.

## GRD-TC-005 - Tìm kiếm theo từ khóa

Status: draft
Priority: high
Type: functional
Related:
  - API: `GET /v1/grades?keyword=`

### Preconditions
Đăng nhập admin. Có khối lớp `E2E-GRD-...-search-... VN`.

### Steps
1. Mở `/vi/admin/grades`.
2. Gõ từng ký tự tên tiếng Việt của khối lớp vào ô tìm kiếm.

### Expected Results
- Chỉ gửi 1 request sau khi ngừng gõ (debounce), với `keyword` = toàn bộ từ khóa và `page=1`.
- Bảng chỉ còn 1 dòng đúng khối lớp tìm kiếm, STT = 1.

### Automation
tests/e2e/schools/grade-crud.spec.ts (`GRD-TC-005`)

## GRD-TC-006 - Tìm kiếm không có kết quả hiển thị "Không có dữ liệu"

Status: draft
Priority: medium
Type: edge-case

### Preconditions
Đăng nhập admin.

### Steps
1. Nhập từ khóa không tồn tại (`E2E-GRD-khong-ton-tai-<RUN_ID>`).

### Expected Results
- Bảng hiển thị 1 dòng "Không có dữ liệu".
- Không hiển thị thông tin/điều khiển phân trang.

### Automation
tests/e2e/schools/grade-crud.spec.ts (`GRD-TC-006`)

## GRD-TC-007 - Bộ chọn số dòng/trang hiển thị đúng số dòng đang áp dụng

Status: draft
Priority: medium
Type: functional
Related:
  - Bug: docs/test-cases/schools/bugs/GRD-BUG-002.md

### Preconditions
Đăng nhập admin. Có > 10 khối lớp (automation mock 15 bản ghi).

### Steps
1. Mở `/vi/admin/grades`.
2. Xem số dòng hiển thị và giá trị ô "Hiển thị [n] mục mỗi trang".

### Expected Results
- Giá trị ô chọn số dòng/trang bằng số dòng thực tế đang tải (`limit` của request).
- Người dùng chọn được mọi giá trị trong danh sách, kể cả giá trị đầu tiên.

### Automation
tests/e2e/schools/grade-crud.spec.ts (`GRD-TC-007`, `@known-bug`)

## GRD-TC-008 - Đổi số dòng/trang và chuyển trang

Status: draft
Priority: medium
Type: functional

### Preconditions
Đăng nhập admin. Mock danh sách 15 khối lớp.

### Steps
1. Chọn 12 dòng/trang.
2. Bấm trang "2".

### Expected Results
- Bước 1: request `page=1&limit=12`, hiển thị 12 dòng, "Hiển thị 1 - 12 trong tổng số 15 khối lớp".
- Bước 2: request `page=2&limit=12`, hiển thị 3 dòng, STT bắt đầu từ 13, "Hiển thị 13 - 15 trong tổng số 15 khối lớp".

### Automation
tests/e2e/schools/grade-crud.spec.ts (`GRD-TC-008`)

## GRD-TC-009 - Lỗi tải danh sách hiển thị thông báo lỗi

Status: draft
Priority: medium
Type: api-error

### Preconditions
Đăng nhập admin. Mock `GET /v1/grades` trả lỗi (HTTP 400).

### Steps
1. Mở `/vi/admin/grades`.

### Expected Results
- Sau khi hết lượt retry, hiển thị toast lỗi "Có lỗi xảy ra khi tải danh sách khối lớp.".

### Automation
tests/e2e/schools/grade-crud.spec.ts (`GRD-TC-009`)

### Notes
Khi lỗi, bảng hiển thị "Không có dữ liệu" (dễ hiểu nhầm là danh sách trống). Requirement/design chưa quy định error state của bảng → needs-review, không xếp bug.

## GRD-TC-010 - Hiển thị và lọc khối lớp theo trạng thái active/inactive

Status: out-of-scope
Priority: —
Type: —

### Notes
Ngoài phạm vi task (xác nhận 2026-09-17): không test trạng thái active/inactive. Hiện trạng tham khảo: API và màn hình chưa có field/cột/bộ lọc trạng thái. Không có automation.

---

## Thêm mới

## GRD-TC-011 - Tạo khối lớp hợp lệ

Status: draft
Priority: high
Type: functional
Related:
  - Business rule: GRD-BR-001
  - API: `POST /v1/grades`

### Preconditions
Đăng nhập admin.

### Test Data
Số khối ngẫu nhiên 500-899, tên `E2E-GRD-<RUN_ID>-create-xxxx VN` / `... EN`.

### Steps
1. Bấm "Thêm" → dialog "Thêm mới khối lớp", các trường trống.
2. Nhập Số khối, Tên tiếng Việt, Tên tiếng Anh.
3. Bấm "Lưu".

### Expected Results
- Request `POST /v1/grades` body `{ number: <number>, name_vn, name_en }` (number là kiểu số).
- Toast "Tạo khối lớp thành công.", dialog đóng.
- Danh sách tự tải lại, có dòng mới đúng Số khối/Tên.
- Dữ liệu được lưu ở backend (có đúng 1 bản ghi với tên vừa tạo).

### Automation
tests/e2e/schools/grade-crud.spec.ts (`GRD-TC-011`)

## GRD-TC-012 - Bỏ trống tất cả trường

Status: draft
Priority: high
Type: validation

### Steps
1. Bấm "Thêm", không nhập gì, bấm "Lưu".

### Expected Results
- Hiển thị: "Số khối phải là số nguyên lớn hơn 0", "Tên tiếng Việt không được để trống", "Tên tiếng Anh không được để trống".
- Dialog vẫn mở, không gửi `POST /v1/grades`.

### Automation
tests/e2e/schools/grade-crud.spec.ts (`GRD-TC-012`)

## GRD-TC-013 - Số khối không hợp lệ bị chặn; biên 1 và 12 hợp lệ

Status: draft
Priority: high
Type: validation
Related:
  - Business rule: GRD-BR-003
  - Bug: docs/test-cases/schools/bugs/GRD-BUG-005.md

### Test Data
- Không hợp lệ: `0`, `-1`, `1.5`.
- Hợp lệ: `1` (nhỏ nhất), `12` — automation mock `POST` để không tạo thêm khối trùng số với dữ liệu thật.

### Steps
1. Mở dialog thêm, nhập tên hợp lệ và lần lượt từng số khối không hợp lệ, bấm "Lưu".
2. Mở dialog thêm, nhập số khối `1` (rồi `12`), bấm "Lưu".

### Expected Results
- Bước 1: mỗi giá trị hiển thị "Số khối phải là số nguyên lớn hơn 0", không gửi request tạo.
- Bước 2: không báo lỗi, gửi request với `number` = 1 / 12, dialog đóng khi thành công.

### Automation
tests/e2e/schools/grade-crud.spec.ts (`GRD-TC-013`, `@known-bug`)

### Notes
- Hiện trạng 2026-09-17: `0`, `-1`, `1.5` bị validation gốc HTML5 của trình duyệt chặn (tooltip tiếng Anh), thông báo của form không hiện → GRD-BUG-005. Không có request tạo nào được gửi.
- Code chặn cả giá trị có số 0 đầu như `01` (regex `^[1-9]\d*$`) với thông báo "phải là số nguyên lớn hơn 0". Requirement không quy định → không assert, ghi trong GRD-BUG-005.

## GRD-TC-014 - Tên chỉ có khoảng trắng bị chặn; khoảng trắng đầu/cuối được cắt

Status: draft
Priority: medium
Type: validation

### Steps
1. Mở dialog thêm, Số khối `7`, hai tên = `"   "`, bấm "Lưu".
2. Mở lại, Số khối `7`, tên `"  Khối 7  "` / `"  Grade 7  "`, bấm "Lưu" (automation mock `POST`).

### Expected Results
- Bước 1: lỗi "Tên tiếng Việt không được để trống", "Tên tiếng Anh không được để trống"; không gửi request.
- Bước 2: request body `{ number: 7, name_vn: "Khối 7", name_en: "Grade 7" }`.

### Automation
tests/e2e/schools/grade-crud.spec.ts (`GRD-TC-014`)

## GRD-TC-015 - Tạo khối lớp trùng với khối lớp đã có bị từ chối

Status: out-of-scope
Priority: —
Type: —

### Notes
Ngoài phạm vi task (xác nhận 2026-09-17): hệ thống chưa có verify trùng lặp khối lớp. Hiện trạng tham khảo: tạo khối lớp trùng cả số khối và 2 tên vẫn thành công (HTTP 200) — không phải bug. Không có automation.

## GRD-TC-016 - Hủy hoặc đóng dialog tạo

Status: draft
Priority: medium
Type: functional

### Steps
1. Mở dialog thêm, nhập dữ liệu, bấm "Hủy".
2. Mở lại dialog thêm.
3. Nhập dữ liệu, nhấn `Esc`.

### Expected Results
- Dialog đóng ở bước 1 và 3, không gửi `POST`, không có dòng mới.
- Bước 2: các trường trống.

### Automation
tests/e2e/schools/grade-crud.spec.ts (`GRD-TC-016`)

## GRD-TC-017 - Lỗi server khi tạo

Status: draft
Priority: medium
Type: api-error

### Preconditions
Mock `POST /v1/grades` phản hồi chậm 1,5 giây rồi trả HTTP 400 `{ message: "E2E mock: số khối đã tồn tại" }`.

### Steps
1. Mở dialog thêm, nhập dữ liệu hợp lệ, bấm "Lưu".

### Expected Results
- Trong lúc chờ: nút đổi thành "Đang lưu..." và bị khóa, nút "Hủy" bị khóa (chống gửi 2 lần).
- Sau khi lỗi: toast lỗi hiển thị message server, dialog vẫn mở, giữ dữ liệu đã nhập, nút "Lưu" bấm lại được.

### Automation
tests/e2e/schools/grade-crud.spec.ts (`GRD-TC-017`)

## GRD-TC-018 - Số khối lớn hơn 12 được chấp nhận

Status: draft
Priority: low
Type: edge-case
Related:
  - Business rule: GRD-BR-003 (số khối không giới hạn 1-12, xác nhận 2026-09-17)

### Steps
1. Tạo khối lớp với Số khối lớn hơn 12 (ví dụ `13`, `500`).

### Expected Results
- Không báo lỗi validation, tạo thành công, khối lớp hiển thị trong danh sách với đúng số khối.

### Automation
Cover bởi GRD-TC-011: automation luôn tạo khối lớp với số khối ngẫu nhiên 500-899.

---

## Chỉnh sửa

## GRD-TC-019 - Mở dialog sửa: form điền sẵn dữ liệu

Status: draft
Priority: high
Type: functional
Related:
  - API: `GET /v1/grades/{id}`

### Preconditions
Đăng nhập admin. Có khối lớp `E2E-GRD-...-edit-open-...`.

### Steps
1. Bấm nút sửa (icon bút) trên dòng khối lớp.

### Expected Results
- Dialog "Sửa khối lớp".
- Số khối, Tên tiếng Việt, Tên tiếng Anh điền sẵn đúng dữ liệu hiện tại.

### Automation
tests/e2e/schools/grade-crud.spec.ts (`GRD-TC-019`)

## GRD-TC-020 - Sửa khối lớp hợp lệ

Status: draft
Priority: high
Type: functional
Related:
  - API: `PUT /v1/grades/{id}`
  - Bug: docs/test-cases/schools/bugs/GRD-BUG-003.md

### Steps
1. Mở dialog sửa của khối lớp.
2. Đổi Số khối và 2 tên sang giá trị mới hợp lệ, bấm "Lưu".

### Expected Results
- Request `PUT /v1/grades/{id}` đúng id, body chứa `number`, `name_vn`, `name_en` mới; response thành công.
- Toast "Cập nhật khối lớp thành công.", dialog đóng.
- Danh sách hiển thị giá trị mới, không còn tên cũ.
- `GET /v1/grades/{id}` trả giá trị mới.

### Automation
tests/e2e/schools/grade-crud.spec.ts (`GRD-TC-020`, `@known-bug`)

## GRD-TC-021 - Validation khi sửa

Status: draft
Priority: medium
Type: validation

### Steps
1. Mở dialog sửa, xóa trống Số khối và Tên tiếng Việt, đặt Tên tiếng Anh `"  "`, bấm "Lưu".

### Expected Results
- Hiển thị 3 lỗi validation như GRD-TC-012.
- Không gửi `PUT`.

### Automation
tests/e2e/schools/grade-crud.spec.ts (`GRD-TC-021`)

### Notes
Dùng Số khối trống (không dùng `0`): giá trị `0`/`-1`/`1.5` bị validation gốc trình duyệt chặn trước nên không hiện lỗi của form (đã cover ở GRD-TC-013, GRD-BUG-005).

## GRD-TC-022 - Hủy sửa

Status: draft
Priority: medium
Type: functional

### Steps
1. Mở dialog sửa, đổi Tên tiếng Việt, bấm "Hủy".
2. Mở lại dialog sửa của cùng khối lớp.

### Expected Results
- Không gửi `PUT`; danh sách và backend giữ tên cũ.
- Bước 2: form hiển thị tên cũ.

### Automation
tests/e2e/schools/grade-crud.spec.ts (`GRD-TC-022`)

## GRD-TC-023 - Sửa thành trùng với khối lớp khác bị từ chối

Status: out-of-scope
Priority: —
Type: —

### Notes
Ngoài phạm vi task (xác nhận 2026-09-17): hệ thống chưa có verify trùng lặp khối lớp. Không có automation.

## GRD-TC-024 - Lỗi server khi sửa

Status: draft
Priority: medium
Type: api-error

### Preconditions
Mock `PUT /v1/grades/{id}` trả HTTP 400 `{ message: "E2E mock: không thể cập nhật" }`.

### Steps
1. Mở dialog sửa, đổi tên, bấm "Lưu".

### Expected Results
- Toast lỗi hiển thị message server; dialog vẫn mở; nút "Lưu" bấm lại được.

### Automation
tests/e2e/schools/grade-crud.spec.ts (`GRD-TC-024`)

---

## Xóa

## GRD-TC-025 - Dialog xóa hiển thị đúng thông tin; Hủy không xóa

Status: draft
Priority: high
Type: functional

### Steps
1. Bấm nút xóa (icon thùng rác) trên dòng khối lớp.
2. Bấm "Hủy".

### Expected Results
- Bước 1: dialog "Xóa khối lớp", nội dung "Bạn có chắc chắn muốn xóa khối lớp <Tên tiếng Việt>? Hành động này không thể hoàn tác.", hiển thị Số khối, Tên tiếng Việt, Tên tiếng Anh.
- Bước 2: dialog đóng, không gửi `DELETE`, khối lớp vẫn còn.

### Automation
tests/e2e/schools/grade-crud.spec.ts (`GRD-TC-025`)

## GRD-TC-026 - Xóa khối lớp thành công

Status: draft
Priority: high
Type: functional
Related:
  - API: `DELETE /v1/grades/{id}`

### Preconditions
Khối lớp `E2E-GRD-...-delete-...` không được lớp học nào sử dụng.

### Steps
1. Bấm nút xóa → "Xóa".

### Expected Results
- `DELETE /v1/grades/{id}` thành công.
- Toast "Xóa khối lớp thành công.", dialog đóng, dòng biến mất.
- Khối lớp không còn trong `GET /v1/grades`.

### Automation
tests/e2e/schools/grade-crud.spec.ts (`GRD-TC-026`)

## GRD-TC-027 - Xóa bản ghi duy nhất của trang cuối quay về trang trước

Status: draft
Priority: low
Type: edge-case

### Preconditions
Mock 11 khối lớp, 10 dòng/trang.

### Steps
1. Chuyển sang trang 2 (1 dòng, STT 11).
2. Xóa dòng đó.

### Expected Results
- Sau khi xóa, danh sách tải lại `page=1`, hiển thị 10 dòng, "Hiển thị 1 - 10 trong tổng số 10 khối lớp" (không kẹt ở trang 2 trống).

### Automation
tests/e2e/schools/grade-crud.spec.ts (`GRD-TC-027`)

## GRD-TC-028 - Xóa khối lớp đang được lớp học sử dụng

Status: blocked
Priority: high
Type: validation
Related:
  - Business rule: GRD-BR-NEW-03 (đề xuất)
  - Requirement: docs/requirements/schools/class.md

### Preconditions
Khối lớp **dành riêng cho test** đang được ít nhất 1 lớp học (class) tham chiếu.

### Steps
1. Xóa khối lớp đó.

### Expected Results
- Backend từ chối xóa; UI hiển thị toast lỗi (message server); khối lớp vẫn còn; lớp học vẫn giữ khối lớp.

### Automation
Manual. Phần hiển thị lỗi ở FE đã được cover bằng mock trong GRD-TC-029.

### Notes
Blocked: chưa có test data (khối lớp + lớp học riêng cho test). Không thử trên khối lớp thật 1-6 vì nếu backend không chặn sẽ xóa mất dữ liệu dùng chung. Requirement chỉ nói "cần kiểm tra ràng buộc backend", chưa chốt hành vi (chặn hẳn / soft delete / cảnh báo) → needs-review BA/BE.

## GRD-TC-029 - Lỗi server khi xóa

Status: draft
Priority: medium
Type: api-error

### Preconditions
Mock danh sách 1 khối lớp; mock `DELETE /v1/grades/{id}` trả HTTP 400 `{ message: "E2E mock: khối lớp đang được lớp học sử dụng" }`.

### Steps
1. Bấm xóa → "Xóa".

### Expected Results
- Toast lỗi hiển thị message server.
- Dialog vẫn mở, nút "Xóa" không bị kẹt trạng thái loading.
- Khối lớp vẫn còn trong danh sách.

### Automation
tests/e2e/schools/grade-crud.spec.ts (`GRD-TC-029`)

---

## Phân quyền

Ngoài phạm vi task (xác nhận 2026-09-17): chỉ test role Admin. Các ID dưới đây giữ lại để không tái sử dụng, không có automation.

| TC-ID | Scenario | Status |
| --- | --- | --- |
| GRD-TC-030 | Teacher mở trang quản lý khối lớp | out-of-scope |
| GRD-TC-031 | Student mở trang quản lý khối lớp | out-of-scope |
| GRD-TC-032 | Chưa đăng nhập mở trang quản lý khối lớp | out-of-scope |
| GRD-TC-033 | Teacher gọi trực tiếp API tạo/sửa/xóa khối lớp | out-of-scope |
| GRD-TC-034 | Role school thực hiện CRUD khối lớp | out-of-scope |

---

## Đa ngôn ngữ

## GRD-TC-035 - Locale en

Status: draft
Priority: low
Type: functional (i18n)

### Steps
1. Mở `/en/admin/grades`.
2. Bấm "Add", bấm "Save" khi form trống.

### Expected Results
- Tiêu đề "Grade Management"; cột: No., Grade Number, Vietnamese Name, English Name, Created At, Actions.
- Dialog "Add New Grade"; lỗi "Grade number must be an integer greater than 0".

### Automation
tests/e2e/schools/grade-crud.spec.ts (`GRD-TC-035`)

### Notes
Cột ngày luôn định dạng `vi-VN` kể cả locale `en` — requirement/design chưa quy định định dạng ngày theo locale → needs-review, không xếp bug.

---

## Regression impact

Thay đổi dữ liệu/API grade ảnh hưởng các màn hình dùng `gradeApi.getListGrade`:

- `src/app/[locale]/manage/flip-book/page.tsx`, `src/components/features/flip-book/book-form.tsx`
- `src/app/[locale]/manage/programs/create/page.tsx`, `src/app/[locale]/manage/programs/[id]/edit/page.tsx`
- `src/components/features/export-admin/assessment-school-report-tab.tsx`
- `src/components/shared/academic-filters.tsx`

Chưa có test case cho các màn hình này trong đợt test 2026-09-16.
