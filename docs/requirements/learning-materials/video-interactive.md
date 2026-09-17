# Tài liệu BA chi tiết: Video Interactive

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-06-04
Related:
  - docs/api/interactive-contents/interactive-content.md
  - docs/api/interactive-contents/interactive-attempt.md
  - docs/security/resources/interactive-contents.md
  - docs/requirements/learning-materials/lesson.md
  - src/api/video-interactive.ts
  - src/app/[locale]/manage/video-interactive/page.tsx
  - src/components/features/video-interactive/video-interactive-form.tsx
  - src/components/features/video-interactive-view/interactive-video-player.tsx
  - docs/test-cases/overview.md

## 1. Khái niệm video interactive

Video interactive là nội dung học tập dạng video có gắn các câu hỏi tại những mốc thời gian cụ thể.

Trong code hiện tại, video interactive được quản lý qua nhóm API `/interactive/contents` và được render bằng màn hình dùng chung dưới route `manage/video-interactive`. Route `admin/video-interactive` và `teacher/video-interactive` đang re-export màn hình manage tương ứng.

Video interactive có thể được gắn vào bài học thông qua trường `interactive_content_items` của lesson.

## 2. Phạm vi chức năng hiện có

Các chức năng đã thấy trong code:

- Xem danh sách video interactive.
- Lọc danh sách theo từ khóa và trạng thái.
- Tạo video interactive.
- Cập nhật video interactive.
- Xem nội dung video interactive.
- Xóa video interactive.
- Chọn câu hỏi từ question bank để gắn vào video.
- Thiết lập thời điểm hiển thị câu hỏi bằng phút và giây, lưu xuống API bằng mili giây.
- Upload video hoặc nhập URL video trực tiếp.
- Bật hoặc tắt xáo trộn đáp án.
- Bắt đầu phiên làm video interactive.
- Khôi phục phiên đang làm nếu attempt trước đó còn trạng thái `started`.
- Gửi event trả lời câu hỏi.
- Gửi event đóng/tạm dừng phiên xem.
- Submit attempt khi video kết thúc.
- Hiển thị điểm, sao và exp sau khi submit attempt.

## 3. Quan hệ với các đối tượng khác

### 3.1. Quan hệ với lesson

Lesson có thể chứa danh sách video interactive qua `interactive_content_items`.

Trong các màn hình xem lesson, nếu lesson có một hoặc nhiều interactive content, hệ thống hiển thị khu vực video interactive trong nội dung bài học.

### 3.2. Quan hệ với question bank

Khi tạo hoặc sửa video interactive, người dùng chọn câu hỏi từ question bank.

Code dùng `questionApi.getQuestions` với các tham số:

- `page`
- `limit`
- `keyword`
- `question_type`
- `sort_created_at: newest`

Mỗi câu hỏi được lưu trong `content.events[].question`.

### 3.3. Quan hệ với attempt

Khi người học bắt đầu xem, FE gọi API start attempt với `content_item_id`.

Attempt dùng để lưu:

- Trạng thái phiên làm.
- Điểm đạt được.
- Điểm tối đa.
- Thời điểm bắt đầu và kết thúc.
- Tổng sao và exp nếu backend trả về.
- Các event trả lời hoặc đóng/tạm dừng.

## 4. Thông tin video interactive

### 4.1. Thông tin định danh

Theo `src/api/video-interactive.ts`, một interactive content gồm:

- `id`
- `type_id`
- `title`
- `status`
- `metadata`
- `created_at`
- `updated_at`

### 4.2. Nội dung video

Nội dung chính nằm trong `content`:

- `content.video.url`: URL video.
- `content.video.poster`: poster của video.
- `content.shuffle_answers`: có xáo trộn đáp án hay không.
- `content.events`: danh sách câu hỏi theo timeline.

### 4.3. Event câu hỏi

Mỗi event trong video gồm:

- `id`: ID event do backend trả về.
- `atMs`: mốc thời gian hiển thị câu hỏi, tính bằng mili giây.
- `type`: hiện code tạo mới với giá trị `question`.
- `message`: hiện code tạo mới là chuỗi rỗng.
- `question`: dữ liệu câu hỏi được chọn từ question bank.

## 5. Danh sách video interactive

Màn danh sách lấy dữ liệu từ API `/interactive/contents`.

Bộ lọc hiện có:

- `page`
- `limit`
- `keyword`
- `status`

Trạng thái lọc trên UI:

- Tất cả trạng thái
- `published`
- `draft`
- `archived`

Bảng danh sách hiển thị:

- Tiêu đề
- Trạng thái
- Hành động xem, sửa, xóa

Nếu đang tải dữ liệu, màn hình hiển thị trạng thái loading. Nếu API lỗi, màn hình hiển thị thông báo không thể tải danh sách. Nếu danh sách rỗng, màn hình hiển thị không có dữ liệu.

## 6. Tạo video interactive

Luồng tạo mới:

1. Người dùng mở màn tạo video interactive.
2. Nhập tiêu đề.
3. Chọn upload video hoặc nhập URL video.
4. Nếu upload, file được gửi qua `useUpload` với folder `video-interactive`.
5. Chọn câu hỏi từ question bank.
6. Thiết lập mốc thời gian cho từng câu hỏi.
7. Chọn cấu hình xáo trộn đáp án nếu cần.
8. Submit form.
9. FE gửi payload tạo mới tới `/interactive/contents`.
10. Nếu thành công, hệ thống quay về danh sách.

Payload tạo mới theo code:

- `title`: tiêu đề đã trim.
- `status`: luôn gửi `published`.
- `content.shuffle_answers`
- `content.video.poster`: chuỗi rỗng khi tạo mới.
- `content.video.url`
- `content.events[].atMs`
- `content.events[].type`: `question`
- `content.events[].message`: chuỗi rỗng.
- `content.events[].question`

## 7. Cập nhật video interactive

Luồng cập nhật:

1. FE lấy chi tiết interactive content theo ID.
2. Map dữ liệu API về form.
3. Người dùng sửa tiêu đề, video, câu hỏi hoặc mốc thời gian.
4. Submit form.
5. FE gửi payload cập nhật tới `/interactive/contents/{id}`.
6. Nếu thành công, hệ thống quay về danh sách.

Khi cập nhật, `poster` được giữ lại từ dữ liệu chi tiết nếu có.

## 8. Xem và làm video interactive

Màn xem chi tiết lấy dữ liệu từ `/interactive/contents/{id}`.

Người học hoặc người dùng xem video có thể:

- Bắt đầu phiên xem.
- Xem video bằng video.js.
- Thấy marker trên timeline tại các mốc câu hỏi.
- Click marker để mở câu hỏi.
- Trả lời câu hỏi trong dialog.
- Tạm dừng/thoát phiên xem.
- Tiếp tục phiên đang làm nếu backend trả về attempt đang `started`.
- Submit attempt khi video kết thúc.

Khi bắt đầu phiên, FE gọi `/interactive/attempts/start`.

Khi xem lại phiên đang dở, FE gọi `/interactive/attempts/state/{contentItemId}` để lấy attempt, answers và events.

## 9. Quy tắc nghiệp vụ hiện có

### VI-BR-001. Tiêu đề bắt buộc

Khi tạo hoặc cập nhật video interactive, tiêu đề không được rỗng sau khi trim.

Nếu rỗng, FE chặn submit và hiển thị lỗi.

### VI-BR-002. Video bắt buộc

Video interactive phải có `videoUrl`.

Nguồn video có thể đến từ upload hoặc URL nhập tay.

### VI-BR-003. Phải có ít nhất một câu hỏi

Khi tạo hoặc cập nhật, danh sách `events` phải có ít nhất một câu hỏi.

Nếu chưa chọn câu hỏi, FE chặn submit.

### VI-BR-004. Mốc thời gian không âm

Khi nhập mốc thời gian cho câu hỏi, nếu giá trị không hợp lệ hoặc nhỏ hơn `0`, FE đưa về `0`.

### VI-BR-005. Giây trong form giới hạn từ 0 đến 59

Form nhập thời gian tách phút và giây. Phần giây được giới hạn tối đa `59` trước khi quy đổi sang mili giây.

### VI-BR-006. Trạng thái tạo/cập nhật hiện gửi `published`

Code hiện tại luôn gửi `status: published` khi tạo và cập nhật.

Các trạng thái `draft` và `archived` có trên bộ lọc danh sách nhưng chưa thấy UI tạo/cập nhật trạng thái này trong form.

### VI-BR-007. Câu hỏi được mở khi video đi qua mốc thời gian

Khi video đang chạy và timeline đi qua `event.atMs`, hệ thống mở dialog câu hỏi và pause video.

### VI-BR-008. Tua nhanh trên 1 giây có thể bỏ qua phát hiện event tức thời

Trong code xem video, nếu delta thời gian lớn hơn 1000ms, FE cập nhật mốc thời gian hiện tại và bỏ qua detect event trong lần đó. Sau khi seek xong, hệ thống kiểm tra lại event bị crossing.

### VI-BR-009. Đóng phiên đang làm phải gửi event tạm dừng

Khi người dùng rời màn hoặc đóng tab trong lúc attempt đang chạy, FE cố gắng gửi event `interaction_closed`.

Với `pagehide`, FE dùng `postKeepAlive` để gửi event.

### VI-BR-010. Submit attempt sau khi video kết thúc

Khi video kết thúc, FE mở confirm hoàn thành. Nếu người dùng xác nhận, FE gọi API submit attempt.

## 10. Scoring và kết quả

FE không tự tính điểm tổng trong màn video interactive.

Khi submit attempt thành công, backend trả về:

- `score`
- `max_score`
- `total_star`
- `total_exp`
- `started_at`
- `finished_at`

FE hiển thị các giá trị này trong dialog kết quả.

Quy tắc tính điểm, sao và exp cần backend/BA xác nhận thêm.

## 11. API liên quan

Các API chính đang được gọi trong code:

- `GET /interactive/contents`
- `GET /interactive/contents/{id}`
- `POST /interactive/contents`
- `PUT /interactive/contents/{id}`
- `DELETE /interactive/contents/{id}`
- `POST /interactive/attempts/start`
- `GET /interactive/attempts/state/{contentItemId}`
- `POST /interactive/attempts/{attemptId}/events`
- `POST /interactive/attempts/{attemptId}/submit`

Tài liệu API liên quan:

- `docs/api/interactive-contents/interactive-content.md`
- `docs/api/interactive-contents/interactive-attempt.md`
- `docs/api/learning-materials/question.md`

## 12. Quyền và phạm vi dữ liệu

Route hiện có:

- `/[locale]/manage/video-interactive`
- `/[locale]/manage/video-interactive/create`
- `/[locale]/manage/video-interactive/[id]/edit`
- `/[locale]/manage/video-interactive/[id]/view`
- `/[locale]/admin/video-interactive`, re-export từ manage.
- `/[locale]/teacher/video-interactive`, re-export từ manage.

Theo tài liệu security hiện có, resource liên quan là `interactive/contents`.

Quyền thực tế cần đối chiếu thêm với provider/hook permission vì màn danh sách hiện chưa thấy guard hành động rõ ràng trong chính file page.

## 13. State transition

### 13.1. Interactive content

Các trạng thái xuất hiện trong UI danh sách:

- `published`
- `draft`
- `archived`

Luồng chuyển trạng thái chưa thấy form riêng trong code hiện tại. Khi tạo/cập nhật, FE gửi `published`.

### 13.2. Attempt

Các trạng thái attempt được code xử lý:

- `started`: phiên đang làm, có thể khôi phục.
- Đã submit/finished: backend trả `finished_at`, FE hiển thị kết quả sau submit.

Tên trạng thái hoàn tất chính xác cần xác nhận từ backend.

## 14. Luồng màn hình chính

### 14.1. Luồng xem danh sách

1. Người dùng mở danh sách video interactive.
2. FE gọi API danh sách với page, limit, keyword và status.
3. Người dùng có thể tìm kiếm, lọc trạng thái, phân trang.
4. Người dùng chọn xem, sửa, xóa hoặc tạo mới.

### 14.2. Luồng tạo/cập nhật

1. Người dùng nhập thông tin cơ bản.
2. Người dùng cấu hình video.
3. Người dùng chọn câu hỏi.
4. Người dùng đặt mốc thời gian cho câu hỏi.
5. Người dùng submit.
6. FE validate dữ liệu và gọi API.

### 14.3. Luồng học/xem video

1. Người dùng mở màn xem video interactive.
2. FE lấy chi tiết nội dung.
3. FE lấy attempt state nếu có.
4. Người dùng bắt đầu hoặc tiếp tục phiên xem.
5. Video chạy và mở câu hỏi tại marker.
6. Người dùng trả lời câu hỏi.
7. Khi video kết thúc, người dùng xác nhận submit.
8. FE hiển thị kết quả backend trả về.

## 15. Edge cases và điểm cần xác nhận

- Backend có cho phép tạo video interactive không có câu hỏi hay không; FE hiện chặn.
- Backend có validate định dạng URL video hay không; FE hiện chỉ kiểm tra không rỗng.
- Backend có hỗ trợ `draft` và `archived` qua form hay không; UI hiện chỉ lọc.
- Quy tắc tính `score`, `max_score`, `total_star`, `total_exp` cần xác nhận.
- Quy tắc giới hạn số lần trả lời sai hiện chỉ được FE đếm để truyền vào dialog; cần xác nhận rule nghiệp vụ cuối cùng.
- Quyền tạo/sửa/xóa giữa Admin và Teacher cần đối chiếu thêm với permission runtime.
- Khi người dùng tua qua nhiều marker trong một lần, cần xác nhận kỳ vọng nghiệp vụ là mở marker đầu tiên bị crossing hay tất cả marker.
