# Homework Do Page Refactor

Status: needs-review
Owner: DEV
Last reviewed: 2026-09-11
Source: Ghi chú refactor FE; không phải acceptance criteria nghiệp vụ.
Related:
  - docs/requirements/learning-materials/homework-flow.md
  - docs/requirements/learning-materials/homework-question-flow-changes.md
  - src/app/[locale]/manage/assignments/do-homework/[id]/page.tsx

Tài liệu này mô tả việc tách file `src/app/[locale]/manage/assignments/do-homework/[id]/page.tsx` thành các component và helper nhỏ hơn.

## Mục tiêu

Trước khi tách, `page.tsx` chịu quá nhiều trách nhiệm cùng lúc:

- Lấy dữ liệu homework và danh sách câu hỏi.
- Quản lý state làm bài, state feedback, hint, skip, submit.
- Render UI chính cho từng loại câu hỏi.
- Render UI riêng cho homework dạng `write`.
- Render popup xác nhận nộp bài.
- Render hint, đáp án đúng, celebration overlay.
- Kiểm tra điều kiện có thể bấm `Check`.
- Tạo feedback message.

Việc tách file giúp:

- Giảm kích thước và độ phức tạp của `page.tsx`.
- Đưa UI lặp lại vào component riêng.
- Đưa logic thuần vào `src/lib` để dễ test và tái sử dụng.
- Giữ `page.tsx` tập trung vào orchestration: lấy dữ liệu, giữ state cấp trang, gọi API và nối các component với nhau.

## Cấu trúc sau khi tách

### Page chính

File:

- `src/app/[locale]/manage/assignments/do-homework/[id]/page.tsx`

Vai trò hiện tại:

- Là entry point của route làm homework.
- Khởi tạo query/mutation liên quan đến homework.
- Quản lý state cấp trang như `questions`, `answers`, `currentQuestionIndex`, `feedbackState`, `activeHint`, submit dialog, streak, uploaded files.
- Điều phối các callback chính như `handleCheck`, `handleSkip`, `handleConfirmSubmit`, `handleFinishHomework`.
- Truyền dữ liệu và callback xuống các component đã tách.

`page.tsx` không còn trực tiếp chứa toàn bộ JSX của:

- Dialog xác nhận nộp bài.
- Hint overlay.
- Correct answer panel.
- Celebration overlay.
- Renderer cho từng loại câu hỏi.
- UI riêng của homework dạng `write`.
- Logic thuần kiểm tra answer có thay đổi hay có thể check.
- Logic thuần tạo feedback message.

## Components đã tách

### `HomeworkQuestionRenderer`

File:

- `src/components/features/assignments/homework-question-renderer.tsx`

Vai trò:

- Nhận `currentQuestion`, `answers`, `homeworkDetail`, trạng thái bài làm đã parse và callback update answer.
- Chọn component câu hỏi phù hợp theo `currentQuestion.type`.
- Render các loại câu hỏi:
  - `MultipleChoiceQuestion`
  - `FillInBlankQuestion`
  - `DragDropQuestion`
  - `OrderingQuestion`
  - `MatchingQuestion`
  - `WritingQuestion`
  - `SpeakingQuestion`
  - `CategoryQuestion`
  - `LabelingQuestion`
  - `HomeworkWriteQuestion` cho dạng `write`
- Xử lý phần dữ liệu phục vụ render:
  - Lấy correct answer khi question đã đúng hoặc cần cải thiện.
  - Lấy latest student answer khi question ở trạng thái `failure`.
  - Lấy manual answer cho `speaking` và `writing`.

Lý do tách:

- Trước đây `page.tsx` có một `switch` lớn để render từng loại câu hỏi.
- Logic này thuộc về UI rendering hơn là orchestration cấp route.
- Sau khi tách, `page.tsx` chỉ cần gọi `renderQuestion={() => <HomeworkQuestionRenderer ... />}`.

### `HomeworkWriteSubmissionView`

File:

- `src/components/features/assignments/homework-write-submission-view.tsx`

Vai trò:

- Render toàn bộ giao diện riêng cho homework có `question_form === 'write'`.
- Bao gồm:
  - Khu vực nội dung chính với `HomeworkWriteQuestion`.
  - Sidebar hiển thị tên homework và số file đã upload.
  - Progress dạng vòng tròn theo số file upload.
  - Nút submit.
  - Nút đóng/mở sidebar.
  - Floating submit button và floating progress khi sidebar bị ẩn.
  - Dialog xác nhận submit thông qua `HomeworkConfirmDialog`.

Lý do tách:

- Nhánh `write` có layout khác hoàn toàn so với dạng question thông thường.
- Nếu để trong `page.tsx`, file route phải chứa một block JSX lớn và khó đọc.
- Component này giúp `page.tsx` chỉ còn nhánh điều kiện ngắn:

```tsx
if (homeworkDetail?.question_form === 'write') {
  return (
    <MobileOrientationGuard requireLandscape={true}>
      <HomeworkWriteSubmissionView ... />
    </MobileOrientationGuard>
  )
}
```

### `HomeworkConfirmDialog`

File:

- `src/components/features/assignments/homework-confirm-dialog.tsx`

Vai trò:

- Render dialog xác nhận nộp bài.
- Dùng chung cho:
  - Homework dạng câu hỏi thông thường.
  - Homework dạng `write`.
- Hiển thị lỗi API nếu có.
- Hiển thị thông tin số câu chưa hoàn thành, câu skipped, câu failure dựa trên `pendingSkipInfo`.
- Nhận toàn bộ label từ `page.tsx` để vẫn dùng được translation hiện tại.

Lý do tách:

- Dialog submit xuất hiện ở nhiều nhánh UI.
- Tách ra giúp tránh duplicate JSX và gom logic hiển thị message submit vào một nơi.

### `HomeworkHintOverlay`

File:

- `src/components/features/assignments/homework-hint-overlay.tsx`

Vai trò:

- Render overlay gợi ý sau khi học sinh làm sai.
- Hiển thị:
  - Nội dung text/html của hint.
  - File media của hint.
  - Combo text/media nếu có.
  - Panel xem đáp án đúng khi đủ điều kiện.
- Nhận `renderCorrectAnswerContent` từ ngoài để render phần đáp án đúng.

Lý do tách:

- Hint overlay có cấu trúc UI riêng, gồm nhiều loại nội dung media.
- `page.tsx` chỉ cần quản lý state `activeHint`, `showCorrectAnswerPanel`, `isViewingCorrectAnswer` và truyền xuống.

### `HomeworkCorrectAnswerContent`

File:

- `src/components/features/assignments/homework-correct-answer-content.tsx`

Vai trò:

- Render nội dung đáp án đúng theo từng loại câu hỏi.
- Hỗ trợ các dạng:
  - `multiple_choice`
  - `fill_in_blanks`
  - `drag_drop`
  - `matching`
  - `ordering`
  - `labeling`
  - `category`
- Render text/html bằng `TiptapMathViewer`.
- Render media bằng `MediaDisplay`.

Lý do tách:

- Logic hiển thị đáp án đúng phụ thuộc từng question type và có nhiều nhánh.
- Đây là UI độc lập, không nên nằm trong route page.

### `HomeworkCelebrationOverlay`

File:

- `src/components/features/assignments/homework-celebration-overlay.tsx`

Vai trò:

- Render ảnh celebration overlay khi người học trả lời đúng trong một số trường hợp.
- Nhận:
  - `imageSrc`
  - `isVisible`

Lý do tách:

- Overlay celebration là UI nhỏ, độc lập.
- Tách ra giúp phần render cuối page gọn hơn.

## Helpers đã tách

### `canCheckHomeworkAnswer`

File:

- `src/lib/homework-answer-state.ts`

Vai trò:

- Kiểm tra xem câu hiện tại có đủ điều kiện bấm `Check` hay không.
- Nhận vào:
  - `currentQuestion`
  - `homeworkDetail`
  - `answers`
  - `lastCheckedAnswers`
  - `canCheckQuestionByStatus`
- Kiểm tra theo từng dạng câu hỏi:
  - Multiple choice phải có selected ids.
  - Fill in blanks phải có ít nhất một ô có text.
  - Ordering phải có order.
  - Drag drop phải fill đủ blank.
  - Matching phải match đủ left items.
  - Category phải có item được gán vào category.
  - Labeling chỉ cần `isAnswered === true`.
  - Writing phải có text.
  - Speaking phải có file URL và không đang upload.
  - Write-form phải có uploaded files hợp lệ.

### `hasHomeworkAnswerChanged`

File:

- `src/lib/homework-answer-state.ts`

Vai trò:

- So sánh answer hiện tại với snapshot answer đã check lần cuối.
- Nếu answer chưa thay đổi thì không cho check lại.
- So sánh theo cấu trúc riêng của từng question type.

Lý do tách `homework-answer-state.ts`:

- Đây là logic thuần, không phụ thuộc React.
- Có thể viết unit test riêng mà không cần render page.
- Giảm đáng kể số dòng và số nhánh điều kiện trong `page.tsx`.

### `getHomeworkFeedbackMessage`

File:

- `src/lib/homework-feedback.ts`

Vai trò:

- Trả về message feedback theo:
  - `feedbackState`
  - `currentQuestion`
  - `homeworkDetail`
- Với trạng thái initial, ưu tiên `currentQuestion.metadata.instructions`.
- Với `writing`, `speaking`, `write` hoặc homework dạng `write`, trả về message giáo viên sẽ chấm sau.
- Với auto-graded question, trả về message đúng/sai.

Lý do tách:

- Đây là logic thuần và nhỏ.
- Giúp `page.tsx` không phải chứa thêm điều kiện UI message.

## Luồng render hiện tại

### Homework dạng question thông thường

1. `page.tsx` lấy `homeworkDetail` và `studentHomeworkDetail`.
2. `studentHomeworkDetail` được parse bằng `parseStudentHomeworkDetail`.
3. `page.tsx` truyền dữ liệu vào `HomeworkSubmissionPage`.
4. `HomeworkSubmissionPage` gọi `renderQuestion`.
5. `renderQuestion` trả về `HomeworkQuestionRenderer`.
6. `HomeworkQuestionRenderer` chọn component câu hỏi phù hợp theo `currentQuestion.type`.
7. Nếu có hint, `page.tsx` truyền `bottomOverlayContent={renderHintOverlay()}`.
8. `HomeworkHintOverlay` có thể render `HomeworkCorrectAnswerContent`.
9. Khi submit, `HomeworkConfirmDialog` được render.
10. Khi có celebration, `HomeworkCelebrationOverlay` được render.

### Homework dạng `write`

1. `page.tsx` kiểm tra `homeworkDetail?.question_form === 'write'`.
2. Nếu đúng, page render `HomeworkWriteSubmissionView`.
3. `HomeworkWriteSubmissionView` tự render layout write-form, sidebar, progress, floating controls và confirm dialog.
4. State upload file vẫn được giữ ở `page.tsx` và truyền xuống qua props.

## Trách nhiệm còn lại trong `page.tsx`

Sau khi tách, `page.tsx` vẫn còn giữ các phần có nhiều side effect và phụ thuộc route:

- Query/mutation API.
- Điều hướng route sau khi submit.
- `handleCheck` gọi các API save score theo từng dạng câu hỏi.
- `handleConfirmSubmit`.
- `handleFinishHomework`.
- Skip logic.
- Completion queue.
- Streak và celebration state.
- State lifecycle khi đổi câu hỏi.

Các phần này vẫn nằm ở page vì chúng liên kết nhiều state, mutation và route params. Nếu tách tiếp, nên tách thành hook chứ không nên chỉ chuyển code cơ học sang component.

## Hướng tách tiếp theo

Nếu tiếp tục refactor, nên ưu tiên các hook sau:

### `useHomeworkCheckAnswer`

Mục tiêu:

- Tách `handleCheck`.
- Gom logic build request theo từng question type.
- Gom xử lý response correct/incorrect/manual scoring.
- Giảm phần lớn logic API khỏi `page.tsx`.

Rủi ro:

- Đây là phần có nhiều side effect nhất: feedback, audio, hint, streak, completion, snapshot, API mutation.
- Nên tách từng bước nhỏ và chạy lint/typecheck sau mỗi bước.

### `useHomeworkSubmitFlow`

Mục tiêu:

- Tách `handleFinishHomework`, `handleConfirmSubmit`, `handleCancelSubmit`.
- Gom logic check submit, lưu result storage, điều hướng trang result.

### `useHomeworkNavigation`

Mục tiêu:

- Tách `handleNext`, `handleBack`, `maxViewedQuestionIndex`, completion queue.

### `useHomeworkCelebration`

Mục tiêu:

- Tách celebration image/audio, streak badge và timeout ẩn overlay.

## Ghi chú kiểm tra

Sau các bước tách hiện tại:

- ESLint trên các file refactor đã pass.
- `npx tsc --noEmit` vẫn fail do lỗi có sẵn ở `src/api/index.ts`: export trùng `Vocabulary`.
- Lỗi TypeScript này không phát sinh từ việc tách `page.tsx`.
