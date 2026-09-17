# Trang Xem Lại Kết Quả Làm Homework

Status: needs-review
Owner: DEV/TEST
Last reviewed: 2026-09-11
Source: Ghi chú yêu cầu/thiết kế FE; cần xác minh với code hiện tại trước khi triển khai.
Related:
  - docs/requirements/learning-materials/homework-flow.md
  - docs/requirements/learning-materials/homework-review-page.md
  - docs/requirements/learning-materials/homework.md
  - src/app/[locale]/student/assignments/do-homework/[id]/review-result/page.tsx

Tài liệu này mô tả yêu cầu cho trang xem lại kết quả làm bài homework của học sinh.

Route đề xuất:

```txt
/{locale}/student/assignments/do-homework/{homeworkId}/review-result
```

File FE chính:

```txt
src/app/[locale]/student/assignments/do-homework/[id]/review-result/page.tsx
```

## Mục Tiêu

Trang này cho phép học sinh xem lại toàn bộ nội dung bài homework sau khi đã làm bài. UI phải giống hệt trang làm bài hiện tại, nhưng ở chế độ chỉ xem lại kết quả:

- Không cho phép kiểm tra đáp án mới.
- Không cho phép nộp bài.
- Không cho phép skip câu hỏi.
- Luôn hiển thị gợi ý và đáp án đúng của câu hiện tại, trừ `writing` và `speaking` chỉ mở hint khi user click icon hint.
- Cho phép xem lại đáp án học sinh đã chọn theo từng lần làm của mỗi câu.

Trang làm bài hiện tại đang dùng UI chung tại:

```txt
src/app/[locale]/manage/assignments/do-homework/[id]/page.tsx
```

Trang `review-result` cần tái sử dụng layout, cách render câu hỏi, sidebar/progress, media, font, màu sắc và spacing từ trang làm bài để đảm bảo trải nghiệm giống nhau.

## Query Params

Route nhận các query params sau:

| Param      | Bắt buộc | Mô tả                               |
| ---------- | -------- | ----------------------------------- |
| `lessonId` | Có       | Dùng để gọi API chi tiết homework.  |
| `from`     | Không    | Nguồn điều hướng đến trang xem lại. |
| `courseId` | Không    | Giữ context course khi quay lại.    |
| `week`     | Không    | Giữ context tuần khi quay lại.      |

Nếu thiếu `lessonId`, không gọi API và cần hiển thị trạng thái lỗi/empty phù hợp.

## API

Trang dùng API:

```http
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
  get_history_answer: true
}
```

Yêu cầu quan trọng:

- Bắt buộc truyền `get_history_answer: true`.
- Không dùng `get_history_answer: false` vì trang này cần lịch sử đáp án theo nhiều lần làm.
- `homework_id` lấy từ route param `[id]`.
- `lesson_id` lấy từ query param `lessonId`.

## Response Liên Quan

Response chính:

```ts
export interface StudentHomeworkDetailResponse {
  homework_id: string | number
  batch: number
  is_submitted?: boolean
  questions: StudentHomeworkDetailQuestion[]
}
```

Mỗi câu hỏi:

```ts
export interface StudentHomeworkDetailQuestion {
  question: unknown
  sent_times?: StudentHomeworkSentTime[]
  is_answered?: boolean
  has_correct?: boolean
  question_status?: string
  max_star?: number
  max_exp?: number
}
```

Mỗi lần làm của một câu:

```ts
export interface StudentHomeworkSentTime {
  id: string | number
  question_id: string | number
  number_time_sent: number
  is_all_correct: boolean
  ratio_score: number
  star: number
  is_see_answer: boolean
  is_skip: boolean
  batch: number
  answer_data?:
    | string
    | StudentHomeworkAnswerDataItem[]
    | Record<string, unknown>
}
```

Type hiện có nằm tại:

```txt
src/lib/homework-detail-parser.ts
```

## UI Tổng Quan

Trang `review-result` phải dùng cùng UI với trang làm bài:

- Header/tên bài giống trang làm bài.
- Khu vực câu hỏi giống trang làm bài.
- Cách render từng loại câu hỏi giống trang làm bài.
- Sidebar hoặc danh sách số câu giống trang làm bài.
- Bottom action bar giống trang làm bài, nhưng thay đổi bộ nút theo yêu cầu bên dưới.

Không tạo UI mới khác style nếu có thể tái sử dụng component/hàm render hiện có.

### Vị Trí Hiển Thị Các Lần Làm

Danh sách các lần làm (`Attempt`) không hiển thị trong khu vực `Gợi ý + Đáp án`.

Vị trí đề xuất:

- Hiển thị trong sidebar bên phải, ngay dưới vòng progress `current/total`.
- Nếu sidebar đang đóng, có thể hiển thị ở floating progress panel hoặc một panel nhỏ cố định gần góc phải phía trên.

Lý do:

- `Attempt` là bộ lọc đáp án của câu hiện tại, nên nên đặt gần navigation/progress hơn là đặt chung với phần giải thích.
- Khu vực `Gợi ý + Đáp án` chỉ tập trung vào nội dung hỗ trợ và đáp án đúng.
- Khi tắt phần `Gợi ý + Đáp án`, user vẫn cần đổi lần làm để xem đáp án đã chọn.

Yêu cầu:

- Attempt selector vẫn luôn hiển thị khi câu hiện tại có `sent_times`, kể cả khi panel `Gợi ý + Đáp án` đang bị tắt.
- Nếu câu hiện tại không có `sent_times`, hiển thị text ngắn:

```txt
Chưa có lịch sử làm bài cho câu này.
```


### Nút Quay Về Danh Sách Bài Tập

Trong sidebar, ngay dưới phần `Lần làm`, hiển thị nút:

```txt
Quay về danh sách bài tập
```

Nút này điều hướng về danh sách homework của lesson:

```txt
/{locale}/student/courses/{courseId}/lesson/{lessonId}?tab=homework
```

Nguồn dữ liệu:

- `courseId` lấy từ query param `courseId`.
- `lessonId` lấy từ query param `lessonId`.
- Nếu có `week`, giữ lại query param `week` khi điều hướng.

Nút disabled khi thiếu `courseId` hoặc `lessonId`.

Ghi chú triển khai:

- Phần chọn lần làm đã được tách thành component `HomeworkAttemptSelector` tại `src/components/features/assignments/homework-attempt-selector.tsx`.
- Panel gợi ý và đáp án đúng tái sử dụng `HomeworkHintOverlay` với chế độ luôn hiển thị đáp án đúng và ẩn nút toggle xem đáp án.
- Nội dung đáp án đúng tái sử dụng `HomeworkCorrectAnswerContent`.

## Nút Hành Động

Trang chỉ có 2 nút:

```txt
Back
Next
```

Không hiển thị các nút sau:

- `Check`
- `Submit`
- `Skip`
- `Xem đáp án đúng` dạng nút toggle thủ công

Logic nút:

| Nút    | Mô tả                                                                                                                                         |
| ------ | --------------------------------------------------------------------------------------------------------------------------------------------- |
| `Back` | Chuyển về câu trước đó. Nếu đang ở câu đầu tiên thì disabled.                                                                                 |
| `Next` | Nếu chưa ở câu cuối, chuyển sang câu tiếp theo. Nếu đang ở câu cuối, có thể disabled hoặc quay lại trang kết quả/tổng quan theo UX cuối cùng. |

Gợi ý triển khai:

- Với câu đầu tiên, nút `Back` disabled giống trang làm bài.
- Với các câu sau, `Back` giảm `currentQuestionIndex`.
- `Next` disabled khi không có câu hỏi hoặc đang ở câu cuối nếu chưa có hành vi kết thúc cụ thể.

## Hiển Thị Gợi Ý Và Đáp Án Đúng

Khác với trang làm bài, trang xem lại phải hiển thị luôn với các dạng tự chấm:

- Gợi ý cuối cùng của câu hiện tại.
- Đáp án đúng của câu hiện tại.

Không cần chờ học sinh trả lời sai, không cần đếm `wrongAttempts`, không cần bấm nút `Xem đáp án đúng`.

Riêng `writing` và `speaking` dùng rule ở mục “Gợi Ý Cho `writing` Và `speaking`”.

Nguồn dữ liệu:

- Gợi ý lấy từ `currentQuestion.suggests`.
- Đáp án đúng lấy từ `currentQuestion.correct_answers`.

Rule chọn gợi ý:

```ts
const hints = currentQuestion.suggests || []
const visibleHint = hints.length ? hints[hints.length - 1] : null
```

Nếu câu có nhiều gợi ý, chỉ hiển thị gợi ý cuối cùng. Không render toàn bộ danh sách gợi ý trên trang `review-result`.

Cách render:

- Có thể tái sử dụng logic render hint hiện tại của trang làm bài.
- Có thể tái sử dụng `renderCorrectAnswerContent()` của trang làm bài.
- Với `writing` và `speaking`, hiển thị phần gợi ý và đáp án mẫu từ `question.expect_answer` nếu backend trả field này; không dùng `correct_answer` cho 2 dạng này.

Yêu cầu UX:

- Gợi ý và đáp án đúng hiển thị cố định trong khu vực feedback/bottom overlay hoặc panel tương đương trang làm bài.
- Nếu có nhiều gợi ý, chỉ hiển thị gợi ý cuối.
- Panel `Gợi ý + Đáp án` có nút:

```txt
Đã hiểu
```

- Khi click `Đã hiểu`, ẩn panel `Gợi ý + Đáp án` của câu hiện tại.
- Khi chuyển sang câu khác, panel `Gợi ý + Đáp án` hiển thị lại nếu câu đó đủ điều kiện hiển thị.
- Khi chuyển câu, nội dung gợi ý và đáp án đúng cập nhật theo câu mới.

### Gợi Ý Cho `writing` Và `speaking`

Riêng 2 dạng `writing` và `speaking` không tự động hiển thị panel `Gợi ý + Đáp án` theo logic mặc định của trang review-result.

Logic hiện tại:

1. Trang có state `activeManualHintQuestionId` để biết câu manual nào đang được mở hint chủ động.
2. `renderReviewOverlay()` kiểm tra câu hiện tại:
   - nếu câu là `writing` hoặc `speaking`;
   - và `activeManualHintQuestionId !== currentQuestion.id`;
   - thì không render overlay hint.
3. `HomeworkSubmissionPage` nhận prop `onShowHint`.
4. Header câu hỏi hiển thị icon hint khi và chỉ khi:
   - câu hiện tại là `writing` hoặc `speaking`;
   - `currentQuestion.suggests` có ít nhất 1 item.
5. Khi học sinh click icon hint:
   - gọi `handleShowManualHint()`;
   - set `activeManualHintQuestionId` bằng ID câu hiện tại;
   - reset trạng thái dismiss hint của câu hiện tại để overlay có thể mở lại.
6. Sau khi click icon, overlay dùng `HomeworkHintOverlay` như các dạng khác. Nếu backend trả `question.expect_answer`, panel đáp án hiển thị với label `Đáp án mẫu`; nếu không có `expect_answer` thì không hiển thị panel đáp án cho `writing` và `speaking`.
7. Khi bấm `Đã hiểu`, `handleDismissHintAnswer()` đóng overlay và reset `activeManualHintQuestionId`.

Nếu câu `writing` hoặc `speaking` không có `suggests`, icon hint bị ẩn và overlay hint không hiển thị.

### Câu Đã Bỏ Qua

Nếu câu hiện tại có:

```ts
question_status === 'skip'
```

thì không hiển thị panel `Gợi ý + Đáp án`.

Thay vào đó, hiển thị dòng text:

```txt
Bạn đã bỏ qua
```

Vị trí hiển thị đề xuất:

- Trong khu vực feedback/bottom overlay, dùng style tương đương message trạng thái của trang làm bài.
- Không hiển thị danh sách hints.
- Không hiển thị đáp án đúng.
- Không hiển thị nút `Đã hiểu`.

Lưu ý:

- Attempt selector vẫn có thể hiển thị nếu backend có `sent_times`.
- Câu `skip` vẫn cho phép Back/Next như các câu khác.

## Nhiều Lần Làm Của Mỗi Câu

Mỗi câu có thể có nhiều lần làm trong `sent_times`.

Ví dụ: câu 1 có 5 lần làm. Khi học sinh đang xem câu 1, UI cần hiển thị 5 lựa chọn tương ứng 5 lần làm. Khi click vào từng lần, câu hỏi phải hiển thị đáp án mà học sinh đã chọn ở lần đó.

### UI Chọn Lần Làm

Hiển thị danh sách lần làm của câu hiện tại ở vị trí riêng, không nằm trong panel `Gợi ý + Đáp án`.

Ví dụ:

```txt
Lần 1  Lần 2  Lần 3  Lần 4  Lần 5
```

Mapping label:

- Ưu tiên dùng `number_time_sent` nếu có giá trị hợp lệ.
- Nếu không có, dùng index trong mảng `sent_times` bắt đầu từ 1.

Ví dụ:

```ts
const attemptLabel = sentTime.number_time_sent
  ? `Lần ${sentTime.number_time_sent}`
  : `Lần ${index + 1}`
```

Trạng thái active:

- Lần đang chọn cần có style active rõ ràng.
- Mặc định chọn lần làm cuối cùng của câu, vì đây thường là đáp án gần nhất của học sinh.
- Khi panel `Gợi ý + Đáp án` bị tắt bằng nút `Đã hiểu`, danh sách lần làm vẫn hiển thị và vẫn click được.

### Khi Click Một Lần Làm

Khi user click `Lần n`:

1. Set `selectedSentTimeId` hoặc `selectedSentTimeIndex`.
2. Kiểm tra `sentTime.is_all_correct`.
3. Nếu `sentTime.is_all_correct === true`, hiển thị đáp án đúng của câu hỏi. Đây cũng chính là đáp án user đã chọn ở lần làm đó.
4. Nếu `sentTime.is_all_correct === false`, parse `sentTime.answer_data` của lần đó.
5. Convert dữ liệu đã parse thành `QuestionAnswer` tương ứng loại câu.
6. Truyền answer đó vào component render câu hỏi hiện tại.
7. Component câu hỏi hiển thị đáp án học sinh đã chọn ở lần làm đó.

Không gọi API khi đổi lần làm. Dữ liệu lấy từ response `homework-detail`.

Rule hiển thị đáp án theo từng lần làm:

| Field                               | Cách hiển thị                                                                                                                              |
| ----------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------ |
| `sentTime.is_all_correct === true`  | Hiển thị đáp án đúng từ `question.correct_answers`/question options. Không ưu tiên `answer_data` vì đáp án user chọn đã trùng đáp án đúng. |
| `sentTime.is_all_correct === false` | Hiển thị đáp án user đã chọn từ `sentTime.answer_data`.                                                                                    |
| Không có `sentTime` hoặc parse lỗi  | Hiển thị câu hỏi ở trạng thái chưa chọn đáp án.                                                                                            |

Gợi ý triển khai:

```ts
const selectedAnswer = selectedSentTime?.is_all_correct
  ? buildCorrectAnswerAsStudentAnswer(currentQuestion)
  : buildStudentAnswerFromSentTime(currentQuestion, selectedSentTime)
```

Với `writing` và `speaking`, `sentTime.answer_data` chỉ dùng để dựng lại bài làm của học sinh. Đáp án mẫu trong panel hint lấy từ `question.expect_answer` nếu backend trả field này.

Khi `sentTime.is_all_correct === true`, ngoài việc dựng `selectedAnswer`, cần truyền `correctAnswer` vào component câu hỏi tương ứng để UI hiển thị trạng thái đúng theo style của từng dạng câu, ví dụ màu xanh lá cây/check state.

Ví dụ:

```ts
const correctAnswerForSelectedAttempt = selectedSentTime?.is_all_correct
  ? currentQuestion.correct_answers
  : null
```

Sau đó truyền `correctAnswer={correctAnswerForSelectedAttempt}` cho các dạng hỗ trợ `correctAnswer`. Riêng `matching` cần map về format:

```ts
correctAnswer={
  correctAnswerForSelectedAttempt
    ? { matches: correctAnswerForSelectedAttempt.list }
    : null
}
```

## Parse `answer_data`

`sentTime.answer_data` có thể là:

- JSON string.
- Object.
- Array.
- Empty/null.

FE cần parse an toàn:

```ts
const parseAnswerData = (answerData: unknown) => {
  if (!answerData) return null

  if (typeof answerData === 'string') {
    try {
      return JSON.parse(answerData)
    } catch {
      return null
    }
  }

  return answerData
}
```

Trang làm bài hiện đã có các helper parse answer theo từng loại câu ở:

```txt
src/app/[locale]/manage/assignments/do-homework/[id]/page.tsx
```

Các logic có thể tái sử dụng/tham khảo:

- `parseSentTimeAnswerData`
- `parseAnswerDataRecord`
- `buildStudentAnswerFromSentTime`
- `renderQuestion`

## Mapping Đáp Án Theo Loại Câu

Khi parse `answer_data`, cần convert về format answer mà component câu hỏi đang nhận.

| Loại câu          | Dữ liệu user answer cần dựng lại                                                                                                                                      |
| ----------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `multiple_choice` | `selectedIds` từ `answer_ids` hoặc danh sách item có `answer_id`.                                                                                                     |
| `fill_in_blanks`  | `answers: [{ position, text }]`.                                                                                                                                      |
| `ordering`        | `order` theo thứ tự user đã chọn. Nếu `answer_data` là array, sort theo `sort_position`, rồi map `answer_group_position` hoặc `answer_content` về answer id.          |
| `drag_drop`       | `placements` theo vị trí kéo thả. Nếu `answer_data` là array, map `sort_position` -> `answer_content`; fallback `answer_group_position` -> option text.               |
| `matching`        | `matches`/mapping source-target. Nếu `answer_data` là array, map `first_item_id` -> `second_item_id`.                                                                 |
| `category`        | `connections` theo category và answer ids. Nếu `answer_data` là array, map `group_id` -> danh sách `answer_id`; item không có `group_id` xem như chưa được phân loại. |
| `labeling`        | `placements` theo blank id và label id. Nếu `answer_data` là array, map `blank_id` -> `answer_id`.                                                                    |
| `writing`         | Text answer từ `answer`.                                                                                                                                              |
| `speaking`        | File/audio url từ `file_url` hoặc field tương đương nếu backend trả.                                                                                                  |

Với `speaking`, trang `review-result` chỉ truyền audio đã nộp qua `userAnswer.fileUrl`. Không truyền lại cùng URL vào `studentAnswer.fileUrl`, vì `SpeakingQuestion` render player từ cả `userAnswer` và `studentAnswer`; truyền trùng sẽ làm hiển thị 2 audio giống nhau.

Nếu parse thất bại hoặc không có `answer_data`, hiển thị câu hỏi ở trạng thái chưa chọn đáp án, nhưng vẫn hiển thị gợi ý và đáp án đúng.

Khi `sentTime.is_all_correct === true`, dựng answer từ đáp án đúng:

| Loại câu              | Cách dựng answer đúng                                                                                   |
| --------------------- | ------------------------------------------------------------------------------------------------------- |
| `multiple_choice`     | `selectedIds` từ `question.correct_answers.ids` hoặc option có `is_correct=true`.                       |
| `fill_in_blanks`      | `answers` từ `question.correct_answers.list` nếu có, fallback option theo `correct_position`.           |
| `ordering`            | `order` là danh sách answer id sắp xếp theo `correct_position`.                                         |
| `drag_drop`           | `placements` theo vị trí đúng và text của answer đúng.                                                  |
| `matching`            | `matches` từ `question.correct_answers.list`.                                                           |
| `category`            | `connections` dựng bằng cách đảo mapping `answer_id -> category_id` từ `question.correct_answers.list`. |
| `labeling`            | `placements` từ `question.correct_answers.list`.                                                        |
| `writing`, `speaking` | Không dựng đáp án đúng từ `correct_answers`; dùng `sentTime.answer_data` để hiển thị bài làm của học sinh và dùng `question.expect_answer` cho đáp án mẫu trong hint nếu có. |

## Readonly Mode

Tất cả component câu hỏi trên trang này phải ở chế độ chỉ xem:

- Không cho thay đổi đáp án.
- Không gọi `handleAnswerUpdate` để ghi state mới.
- Không gọi API save score.
- Không upload file mới.
- Không ghi nhận view answer.

Nếu component hiện tại chưa có prop readonly/disabled, cần bổ sung theo hướng tái sử dụng được:

```ts
readonly?: boolean
disabled?: boolean
```

Trang `review-result` truyền prop này vào mọi component câu hỏi.

## State Đề Xuất

```ts
const [questions, setQuestions] = useState<QuestionType[]>([])
const [currentQuestionIndex, setCurrentQuestionIndex] = useState(0)
const [selectedSentTimeByQuestionId, setSelectedSentTimeByQuestionId] =
  useState<Record<string, number>>({})
const [dismissedHintAnswerByQuestionId, setDismissedHintAnswerByQuestionId] =
  useState<Record<string, boolean>>({})
const [activeManualHintQuestionId, setActiveManualHintQuestionId] =
  useState<string | null>(null)
```

Derived data:

```ts
const currentQuestion = questions[currentQuestionIndex]
const currentDetailItem = homeworkDetail?.questions[currentQuestionIndex]
const sentTimes = currentDetailItem?.sent_times || []
const selectedSentTimeIndex =
  selectedSentTimeByQuestionId[String(currentQuestion.id)] ??
  Math.max(sentTimes.length - 1, 0)
const selectedSentTime = sentTimes[selectedSentTimeIndex]
const selectedAnswer = buildStudentAnswerFromSentTime(
  currentQuestion,
  selectedSentTime
)
const isCurrentQuestionSkipped = currentDetailItem?.question_status === 'skip'
const shouldShowHintAnswerPanel =
  !isCurrentQuestionSkipped &&
  !dismissedHintAnswerByQuestionId[String(currentQuestion.id)]
```

Với `writing` và `speaking`, cần thêm điều kiện:

```ts
const isManualQuestion =
  currentQuestion.type === 'writing' || currentQuestion.type === 'speaking'

if (
  isManualQuestion &&
  activeManualHintQuestionId !== String(currentQuestion.id)
) {
  return null
}
```

Khi đổi câu:

- Nếu câu mới chưa có selected sent time, mặc định chọn lần cuối.
- Reset các state UI phụ thuộc câu hiện tại nếu có.
- Panel `Gợi ý + Đáp án` hiển thị theo state riêng của từng câu. Nếu câu A đã bấm `Đã hiểu`, quay lại câu A thì vẫn có thể giữ trạng thái đã tắt theo UX mong muốn.

## Điều Hướng Back

Back ra khỏi trang cần giữ logic context giống các trang homework khác:

| Điều kiện                                         | Route quay lại                                                        |
| ------------------------------------------------- | --------------------------------------------------------------------- |
| `from=lesson-detail` và có `courseId`, `lessonId` | `/{locale}/student/courses/{courseId}/lesson/{lessonId}?tab=homework` |
| `from=progress-report`                            | `/{locale}/student/progress-report`                                   |
| Mặc định                                          | `/{locale}/student/assignments`                                       |

Nếu có `week` và `courseId`, giữ lại khi quay về route phù hợp.

## Loading Và Empty State

Khi API đang loading:

- Hiển thị skeleton giống trang làm bài.
- Không hiển thị nút `Check`, `Submit`, `Skip`.

Khi không có câu hỏi:

```txt
Chưa có dữ liệu câu hỏi.
```

Khi câu hiện tại không có `sent_times`:

```txt
Chưa có lịch sử làm bài cho câu này.
```

Vẫn hiển thị câu hỏi, gợi ý và đáp án đúng nếu có.

## Acceptance Criteria

1. Trang gọi đúng `GET /dashboard/student/homework-detail` với `homework_id`, `lesson_id`, `get_history_answer=true`.
2. UI tổng thể giống trang làm bài hiện tại.
3. Không hiển thị `Check`, `Submit`, `Skip`.
4. Chỉ hiển thị `Back` và `Next`.
5. Ở câu đầu tiên, nút `Back` disabled.
6. Gợi ý của câu hiện tại hiển thị nếu có và câu không phải `skip`; nếu có nhiều gợi ý thì chỉ hiển thị gợi ý cuối.
7. Đáp án đúng của câu hiện tại hiển thị nếu có và câu không phải `skip`.
8. Panel `Gợi ý + Đáp án` có nút `Đã hiểu` để tắt panel.
9. Câu có `question_status === 'skip'` không hiển thị `Gợi ý + Đáp án`, chỉ hiển thị text `Bạn đã bỏ qua`.
10. Với `writing` và `speaking`, panel hint không tự hiển thị; chỉ mở khi user click icon hint.
11. Icon hint của `writing` và `speaking` chỉ hiển thị khi câu có `suggests`.
12. Click icon hint ở `writing` và `speaking` mở overlay hint của câu hiện tại; nếu có `expect_answer`, overlay hiển thị thêm panel `Đáp án mẫu`; click `Đã hiểu` đóng overlay.
13. Với câu có nhiều `sent_times`, UI hiển thị đủ các lần làm ở vị trí riêng, không nằm trong panel `Gợi ý + Đáp án`.
14. Click từng lần làm sẽ render đúng đáp án học sinh đã chọn ở lần đó.
15. Với lần làm có `is_all_correct=true`, câu hỏi hiển thị đáp án đúng vì đó cũng chính là đáp án user đã chọn.
16. Với lần làm có `is_all_correct=false`, câu hỏi hiển thị đáp án user chọn từ `answer_data`.
17. Đổi câu không làm mất lựa chọn lần làm đã chọn trước đó của câu cũ.
18. Không gọi các API save score, submit, skip, view answer trên trang này.

## Gợi Ý Kiểm Thử

Test thủ công các case:

- Homework có 1 câu, 1 lần làm.
- Homework có 1 câu, nhiều lần làm.
- Homework có nhiều câu, mỗi câu số lần làm khác nhau.
- Câu không có `sent_times`.
- `answer_data` là JSON string.
- `answer_data` là object.
- `answer_data` là array.
- `answer_data` lỗi format JSON.
- Các loại câu: multiple choice, fill in blanks, ordering, drag drop, matching, category, labeling, writing, speaking.
- `writing`/`speaking` có `suggests`: icon hint hiển thị, click icon mới mở overlay.
- `writing`/`speaking` không có `suggests`: icon hint không hiển thị và overlay hint không tự mở.

Lệnh verify sau khi triển khai:

```bash
pnpm exec tsc --noEmit --pretty false
pnpm exec vitest run
```

## Cập Nhật: Hiển Thị Trạng Thái Theo Từng Lần Làm

Phần này mô tả hành vi hiện tại và thay thế quy tắc cũ dùng
`is_all_correct` để dựng đáp án chuẩn thành đáp án của học sinh.

### Nguyên tắc dữ liệu

- Luôn dựng đáp án học sinh từ `selectedSentTime.answer_data`, kể cả khi
  `selectedSentTime.is_all_correct === true`.
- `question.correct_answers` chỉ dùng để đối chiếu đúng/sai và render panel đáp
  án đúng; không được thay thế đáp án lịch sử của học sinh.
- Khi đổi lần làm, component phải giữ nguyên nội dung user đã gửi ở lần đó.
- Các question component nhận `reviewResult` để phân biệt chế độ xem lịch sử với
  chế độ render toàn bộ đáp án đúng.

Quy tắc màu trong `reviewResult`:

| Trạng thái item | Hiển thị |
| --- | --- |
| User có chọn/đặt và item đúng | Nền, viền hoặc nội dung màu xanh |
| User có chọn/đặt và item sai | Nền, viền hoặc nội dung màu đỏ |
| User không chọn/không đặt | Trạng thái trung tính |

Không tự động tô xanh đáp án chuẩn nếu user không chọn đáp án đó. Đáp án chuẩn
đầy đủ đã được hiển thị riêng trong panel `Gợi ý + Đáp án`.

### Phạm vi hỗ trợ trạng thái item

Chế độ trạng thái xanh/đỏ theo item áp dụng cho 7 dạng:

1. `multiple_choice`
2. `fill_in_blanks`
3. `drag_drop`
4. `ordering`
5. `matching`
6. `category`
7. `labeling`

Không áp dụng trạng thái theo item cho `writing`, `speaking` và `write`.

Chi tiết từng dạng:

- `multiple_choice`: chỉ lựa chọn user đã chọn được tô màu. Lựa chọn đúng nhưng
  user không chọn vẫn trung tính.
- `fill_in_blanks`: từng blank đã điền được so sánh độc lập; blank trống trung
  tính. Chuỗi nhiều đáp án hợp lệ dùng `{&}`, ví dụ `got{&}took`.
- `drag_drop`: item trong từng drop zone được tô cả nền, viền và chữ; item chưa
  được đặt giữ trạng thái bình thường.
- `ordering`: mọi item đều có vị trí nên từng item được đánh giá theo vị trí
  hiện tại trong thứ tự user gửi.
- `matching`: từng cặp source-target được đánh giá độc lập ở cả hai layout của
  component; item chưa ghép trung tính.
- `category`: chỉ item user đã đưa vào category được đánh giá theo category đã
  chọn; item chưa phân loại trung tính.
- `labeling`: chỉ label đã đặt vào blank được tô màu; blank chưa có label trung
  tính.

### Lưu ý `fill_in_blanks`

Với `answer_data` dạng array, không được mặc định vị trí theo thứ tự phần tử của
mảng vì backend có thể trả về không theo thứ tự blank. Mapping vị trí dùng thứ
tự ưu tiên:

```ts
correct_position ?? sort_position ?? position ?? index + 1
```

Ví dụ backend có thể trả `sort_position` theo thứ tự `4, 5, 1, 2, 3`. Nếu dùng
`index + 1`, đáp án đúng sẽ bị so sánh với blank khác và hiển thị sai màu đỏ.

Khi kiểm tra nhiều đáp án hợp lệ:

```ts
const acceptedAnswers = trueAnswer
  .split('{&}')
  .map((value) => value.trim().toLocaleLowerCase())

const isCorrect = acceptedAnswers.includes(
  userAnswer.trim().toLocaleLowerCase()
)
```

### Acceptance criteria bổ sung

1. Mỗi lần làm luôn hiển thị đúng `answer_data` của lần đó, không thay bằng đáp
   án chuẩn.
2. Trong 7 dạng được hỗ trợ, chỉ item user đã tương tác mới có trạng thái
   xanh/đỏ.
3. Đáp án đúng nhưng user không chọn phải giữ giao diện trung tính.
4. Multiple choice không được rò màu xanh từ nội dung, icon hoặc media của đáp
   án chuẩn chưa được chọn.
5. Matching phải truyền cùng trạng thái cho cả hai layout của component.
6. Fill in blanks phải hỗ trợ `sort_position` và nhiều đáp án phân cách bằng
   `{&}`.
7. Writing, speaking và write không bị thay đổi bởi chế độ trạng thái theo item.
