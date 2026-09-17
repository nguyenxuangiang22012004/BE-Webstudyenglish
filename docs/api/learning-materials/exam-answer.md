# Exam Answer API

Status: code-observed
Owner: DEV/TEST
Last reviewed: 2026-09-12
Source:
  - src/api/exam-answer.ts
Related:
  - docs/requirements/learning-materials/exam-answer.md
  - docs/api/other/study.md

## Endpoints used by frontend

### `GET /study/teacher/exam-answers`

Query:

| Name | Required | Notes |
| --- | --- | --- |
| `exam_id` | Yes | Exam identifier. |
| `user_id` | Yes | Student user identifier. |

Returns exam answer detail for teacher review.

### `GET /study/student/exam-answers`

Query:

| Name | Required | Notes |
| --- | --- | --- |
| `exam_id` | Yes | Exam identifier. |

Returns exam answer detail for the signed-in student.

### `GET /study/exam-students`

Query:

| Name | Required | Notes |
| --- | --- | --- |
| `exam_id` | Yes | Exam identifier. |
| `limit` | No | Page size. |
| `page` | No | Page number. |

Returns exam info plus student submission status.

### `POST /study/save-score/manual-scoring`

Body:

| Name | Required | Notes |
| --- | --- | --- |
| `exam_id` | Conditional | Required when scoring exam answers. |
| `homework_id` | Conditional | Required when scoring homework answers. |
| `user_id` | Yes | Student user ID. |
| `score_list` | Yes | List of `{ question_id, score, comment }`. |

Saves manual scores for writing/speaking style answers.

### `GET /study/homework-students`

Query:

| Name | Required | Notes |
| --- | --- | --- |
| `homework_id` | Yes | Homework identifier. |
| `course_id` | No | Course context. |
| `limit` | No | Page size. |
| `page` | No | Page number. |

Returns homework info plus student submission status.

### `GET /study/teacher/homework-answers`

Query: `homework_id`, `user_id`.

Returns homework answer detail for teacher review.

### `GET /study/student/homework-answers`

Query: `homework_id`.

Returns homework answer detail for the signed-in student.

### `POST /study/exam-comment`

Body: `exam_id`, `student_id`, `content`.

Creates teacher comment for an exam submission.

### `POST /study/homework-comment`

Body: `homework_id`, `student_id`, `content`.

Creates teacher comment for a homework submission.

