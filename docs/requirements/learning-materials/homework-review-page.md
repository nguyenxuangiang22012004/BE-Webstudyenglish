# Trang Review Homework

Status: needs-review
Owner: DEV/TEST
Last reviewed: 2026-09-11
Source: Ghi chú màn hình FE; cần đối chiếu route và API hiện tại trước khi dùng làm nguồn triển khai.
Related:
  - docs/requirements/learning-materials/homework-flow.md
  - docs/requirements/learning-materials/homework-review-result-page.md
  - docs/requirements/learning-materials/homework.md
  - src/app/[locale]/student/assignments/do-homework/[id]/review/page.tsx

Tài liệu này mô tả trang review bài tập của học sinh tại route:

```txt
/{locale}/student/assignments/do-homework/{homeworkId}/review
```

File FE chính:

```txt
src/app/[locale]/student/assignments/do-homework/[id]/review/page.tsx
```

## Mục Tiêu

Trang review hiển thị danh sách số câu hỏi của bài tập, kèm trạng thái từng câu sau khi học sinh đã nộp bài. Mỗi câu được hiển thị bằng một ô vuông bo góc có màu nền, border và màu số riêng theo status.

Trang này không render nội dung chi tiết từng câu hỏi; chỉ render navigation list theo trạng thái và các hành động liên quan đến xem lại/làm lại bài.

## Query Params

Route dùng các query params sau:

| Param      | Bắt buộc | Mô tả                                    |
| ---------- | -------- | ---------------------------------------- |
| `lessonId` | Có       | Dùng để gọi API chi tiết bài làm.        |
| `from`     | Không    | Nguồn điều hướng đến trang review.       |
| `courseId` | Không    | Giữ context quay lại course/assignments. |
| `week`     | Không    | Giữ context tuần đang xem.               |

Nếu thiếu `lessonId`, query `getStudentHomeworkDetail` sẽ không chạy.

## API

Trang review dùng:

```txt
GET /dashboard/student/homework-detail
```

Thông qua:

```ts
dashboardApi.getStudentHomeworkDetail.useQuery()
```

Params gửi lên API:

```ts
{
  homework_id: Number(homeworkId),
  lesson_id: Number(lessonId),
  get_history_answer: false
}
```

`get_history_answer = false` để lấy dữ liệu phù hợp cho trang review hiện tại, không lấy lịch sử answer đầy đủ.

Type params nằm ở:

```txt
src/api/dashboard.ts
```

```ts
export interface StudentHomeworkDetailParams {
  homework_id: number
  lesson_id: number
  batch?: number
  get_history_answer?: boolean
}
```

## Response Liên Quan

Trang review đọc danh sách câu hỏi từ:

```ts
homeworkDetail.questions
```

Mỗi item có type:

```ts
export interface StudentHomeworkDetailQuestion {
  question: unknown
  sent_times?: StudentHomeworkSentTime[]
  is_answered?: boolean
  has_correct?: boolean
  question_status?: string
  max_star?: number | string
  max_exp?: number | string
  limit_star?: number | string
  limit_exp?: number | string
}
```

Parser/status helper nằm ở:

```txt
src/lib/homework-detail-parser.ts
```

## Làm Lại Các Câu Chưa Đúng

Trang review có thêm nút:

```txt
Làm lại các câu chưa đúng
```

Nút này dùng để tạo batch làm lại mới cho homework, sau đó điều hướng học sinh về trang làm bài:

```txt
/{locale}/student/assignments/do-homework/{homeworkId}
```

Khi click nút, FE gọi mutation:

```ts
homeWorkApi.createSaveScoreBatch.useMutation()
```

Endpoint:

```txt
POST /study/save-score/batches
```

Request:

```ts
{
  homework_id: String(homeworkId),
  lesson_id: String(lessonId)
}
```

Response cần dùng:

```ts
{
  current_batch: number | string
}
```

Sau khi API thành công, FE lấy `current_batch` từ response và route đến:

```txt
/{locale}/student/assignments/do-homework/{homeworkId}?lessonId={lessonId}&batch={current_batch}
```

Trang làm bài sẽ đọc query param `batch` này và truyền vào API:

```ts
dashboardApi.getStudentHomeworkDetail.useQuery({
  variables: {
    homework_id: Number(homeworkId),
    lesson_id: Number(lessonId),
    batch: Number(batch),
    get_history_answer: true
  }
})
```

Query params cần giữ lại khi có:

| Param      | Mô tả                                            |
| ---------- | ------------------------------------------------ |
| `lessonId` | Bắt buộc để trang làm bài lấy chi tiết homework. |
| `batch`    | Lấy từ `current_batch` của API tạo batch mới.    |
| `from`     | Giữ nguồn điều hướng nếu có.                     |
| `courseId` | Giữ context course nếu có.                       |
| `week`     | Giữ context tuần nếu có.                         |

UX:

- Nút chỉ enable khi có `lessonId`, API review load xong và có ít nhất một câu chưa đúng.
- Câu chưa đúng gồm status `need_improve`, `failure`, `skip`, `waiting_review`.
- Status `marked` là câu đã chấm và được xem như đã hoàn tất, nên không tính vào số câu cần làm lại.
- Khi đang gọi API, nút disabled và hiển thị trạng thái đang xử lý.
- Nếu API lỗi, hiện toast lỗi và giữ học sinh ở trang review.

## Xem Lại Bài Làm

Trang review có thêm nút icon để đi sang:

```txt
/{locale}/student/assignments/do-homework/{homeworkId}/review-result
```

Khi click, FE giữ lại các query params hiện có, tối thiểu gồm:

- `lessonId`
- `from`
- `courseId`
- `week`
- `name`

Nút chỉ nên enable khi có `lessonId` để trang `review-result` gọi được API chi tiết homework.

## Kết Thúc

Trang review có thêm nút:

```txt
Kết thúc
```

Nút này quay về:

```txt
/{locale}/student/courses/{courseId}/lesson/{lessonId}?tab=homework
```

Nếu có `week` thì giữ thêm query param này. Nút chỉ enable khi có `courseId` và `lessonId`.

## Thứ Tự Hiển Thị Trong Card

Thứ tự từ trên xuống dưới:

1. Nút `Quay lại`
2. Thống kê số câu theo trạng thái
3. Nút icon `Xem lại bài làm`
4. Danh sách câu đánh số
5. Nút `Làm lại các câu chưa đúng`
6. Nút `Kết thúc`

## Mapping Trạng Thái Câu Hỏi

Trang review dùng helper:

```ts
getHomeworkReviewQuestionStatus(question, homeworkDetail?.batch)
```

Status hợp lệ:

```ts
type HomeworkReviewQuestionStatus =
  | 'correct'
  | 'need_improve'
  | 'failure'
  | 'skip'
  | 'marked'
  | 'waiting_review'
```

Thứ tự xác định status:

1. Nếu API trả `question_status` hợp lệ, dùng trực tiếp.
2. Nếu không có `question_status`, lấy `sent_time` theo `batch`.
3. Nếu `sent_time.is_skip === true`, status là `skip`.
4. Nếu `sent_time.is_all_correct === true`, status là `correct`.
5. Nếu `has_correct === true`, status là `need_improve`.
6. Còn lại là `failure`.

## UI Status

Mỗi câu hỏi hiển thị bằng một ô vuông bo góc `64px x 64px`. Trong ô có 2 hàng:

- Hàng trên hiển thị số thứ tự câu hỏi, bắt đầu từ `1`.
- Hàng dưới hiển thị `{max_star}/{limit_star}` kèm hình ảnh `/images/star.png`.
- Nếu `max_star` hoặc `limit_star` không có dữ liệu, hiển thị `0`.

| Status           | Màu nền   | Border    | Màu số    |
| ---------------- | --------- | --------- | --------- |
| `correct`        | `#CEF5DD` | Không có  | `#008F3A` |
| `need_improve`   | `#D8E6FF` | Không có  | `#24498C` |
| `failure`        | `#FFE2E2` | Không có  | `#C10007` |
| `skip`           | `#D1D5DC` | Không có  | `#364153` |
| `marked`         | `#FFFBEB` | `#FEF3C6` | `#FD9A00` |
| `waiting_review` | `#F5F3FF` | `#EDE9FE` | `#8E51FF` |

Code style mapping:

```ts
const statusStyles: Record<HomeworkReviewQuestionStatus, string> = {
  correct: 'bg-[#CEF5DD] text-[#008F3A]',
  need_improve: 'bg-[#D8E6FF] text-[#24498C]',
  failure: 'bg-[#FFE2E2] text-[#C10007]',
  skip: 'bg-[#D1D5DC] text-[#364153]',
  marked: 'border border-[#FEF3C6] bg-[#FFFBEB] text-[#FD9A00]',
  waiting_review: 'border border-[#EDE9FE] bg-[#F5F3FF] text-[#8E51FF]'
}
```

Phần thống kê trạng thái phía trên danh sách câu hỏi hiển thị thêm:

| Status           | Label    | Màu icon  | Icon                       |
| ---------------- | -------- | --------- | -------------------------- |
| `marked`         | Đã chấm  | `#FFD230` | `Check`                    |
| `waiting_review` | Chờ chấm | `#7F22FE` | `Clock` nền trắng, nét tím |

Mỗi badge có thêm:

- `aria-label`: `Câu {n}: {status}, {max_star}/{limit_star} sao`
- `title`: status hiện tại và số sao của câu

## Loading Và Empty State

Khi API đang loading, UI hiển thị 8 skeleton square cards:

```ts
Array.from({ length: 8 })
```

Khi API load xong nhưng không có câu hỏi, UI hiển thị message:

```txt
Chưa có dữ liệu câu hỏi.
```

## Back Navigation

Nút back giữ logic điều hướng theo `from`:

| Điều kiện                                         | Route quay lại                                                        |
| ------------------------------------------------- | --------------------------------------------------------------------- |
| `from=lesson-detail` và có `courseId`, `lessonId` | `/{locale}/student/courses/{courseId}/lesson/{lessonId}?tab=homework` |
| `from=progress-report`                            | `/{locale}/student/progress-report`                                   |
| Mặc định                                          | `/{locale}/student/assignments`                                       |

Nếu có `week` và `courseId`, các params này được giữ lại khi quay về assignments/lesson detail.

## Test Coverage

Test status mapping nằm ở:

```txt
tests/homework-detail-parser.test.ts
```

Case đã cover:

- Ưu tiên `question_status` từ API.
- Fallback `has_correct === true` thành `need_improve`.
- Fallback `sent_time.is_skip === true` thành `skip`.

Lệnh verify:

```bash
pnpm exec vitest run tests/homework-detail-parser.test.ts
pnpm exec vitest run
pnpm exec tsc --noEmit --pretty false
```
