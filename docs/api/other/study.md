# Study API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `StudyService`
Operation count: 35

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `StudyService` trong Swagger.

## Endpoints

### `GET /v1/study/contest-rounds-by-student`

- Operation ID: `StudyService_GetContestRoundsByStudent`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentContestRoundsByStudentResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/study/contest_rounds/{id}/questions`

- Operation ID: `StudyService_GetContestRoundQuestions`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentContestRoundQuestionsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/study/exam-comment`

- Operation ID: `StudyService_PostExamComment`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentExamCommentRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentExamCommentResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/study/exam-students`

- Operation ID: `StudyService_GetExamStudents`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `exam_id` | query | False | `string` |  |
| `course_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentExamStudentResponseWithCount` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/study/exercise-students`

- Operation ID: `StudyService_GetExerciseStudents`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `exercise_id` | query | False | `string` |  |
| `course_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentExerciseStudentResponseWithCount` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/study/homework-comment`

- Operation ID: `StudyService_PostHomeworkComment`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentHomeworkCommentRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentHomeworkCommentResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/study/homework-result`

- Operation ID: `StudyService_DeleteHomeworkResult`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `homework_id` | query | False | `string` |  |
| `lesson_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentDeleteHomeworkResultResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/study/homework-students`

- Operation ID: `StudyService_GetHomeworkStudents`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `homework_id` | query | False | `string` |  |
| `course_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentHomeworkStudentsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/study/save-answer/manual-scoring`

- Operation ID: `StudyService_SaveManualAnswer`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentSaveAnswerManualRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentSaveMessage` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/study/save-score/batches`

- Operation ID: `StudyService_SaveScoreNewHomework`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentSaveScoreNewHomeworkRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentSaveScoreNewHomeworkResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/study/save-score/bulk`

- Operation ID: `StudyService_SaveScoreBulk`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentSaveScoreBulkRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentSaveScoreBulkResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/study/save-score/category`

- Operation ID: `StudyService_SaveScoreGroup`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentSaveScoreGroupRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentSaveScoreResponseGroup` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/study/save-score/check-submit-homework`

- Operation ID: `StudyService_CheckSubmitHomework`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `homework_id` | query | False | `string` |  |
| `lesson_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentCheckSubmitHomeworkResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/study/save-score/evaluate`

- Operation ID: `StudyService_Evaluate`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentEvaluateRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentEvaluateResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/study/save-score/fill-in-blank`

- Operation ID: `StudyService_SaveScoreFillInBlank`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentSaveScoreFillInBlankRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentSaveScoreResponseFillInBlank` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/study/save-score/labeling`

- Operation ID: `StudyService_SaveScoreLabeling`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentSaveScoreLabelingRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentSaveScoreResponseLabeling` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/study/save-score/manual-scoring`

- Operation ID: `StudyService_SaveScoreManual`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentSaveScoreManualRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentSaveScoreManualResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/study/save-score/matching`

- Operation ID: `StudyService_SaveScoreMatching`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentSaveScoreMatchingRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentSaveScoreResponseMatching` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/study/save-score/multiple-choice`

- Operation ID: `StudyService_SaveScoreMultipleChoice`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentSaveScoreMultipleChoiceRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentSaveScoreResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/study/save-score/ordering-and-dragdrop`

- Operation ID: `StudyService_SaveScorePosition`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentSaveScorePositionRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentSaveScoreResponsePosition` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/study/save-score/skip-question`

- Operation ID: `StudyService_SkipQuestion`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentSkipQuestionRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentSkipQuestionResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/study/save-score/submit-homework`

- Operation ID: `StudyService_SubmitHomework`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentSubmitHomeworkRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentSubmitHomeworkResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/study/save-score/submit-vocabulary`

- Operation ID: `StudyService_SubmitVocabulary`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentSubmitVocabularyRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentSubmitVocabularyResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/study/save-score/view-answer`

- Operation ID: `StudyService_SeeAnswer`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentSeeAnswerRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentSeeAnswerResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/study/send-results`

- Operation ID: `StudyService_SendResults`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentSendStudyResultsRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentSendStudyResultsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/study/student/exam-answers`

- Operation ID: `StudyService_GetStudentExamAnswers`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `exam_id` | query | False | `string` |  |
| `user_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentGetStudentExamAnswersResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/study/student/exams-by-week`

- Operation ID: `StudyService_GetStudentExamsByWeek`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `week_id` | query | False | `string` |  |
| `user_id` | query | False | `string` |  |
| `start_date` | query | False | `string` |  |
| `end_date` | query | False | `string` |  |
| `course_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentStudentExamsByWeekResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/study/student/exercise-answers`

- Operation ID: `StudyService_GetStudentExerciseAnswers`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `exercise_id` | query | False | `string` |  |
| `user_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentGetStudentExerciseAnswersResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/study/student/homework-answers`

- Operation ID: `StudyService_GetStudentHomeworkAnswers`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `homework_id` | query | False | `string` |  |
| `user_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentStudentHomeworkAnswerResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/study/student/vstep-answers`

- Operation ID: `StudyService_GetStudentVstepAnswers`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `vstep_id` | query | False | `string` |  |
| `user_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentGetStudentVstepAnswersResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/study/teacher/exam-answers`

- Operation ID: `StudyService_GetTeacherExamAnswers`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `exam_id` | query | False | `string` |  |
| `user_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentGetTeacherExamAnswersResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/study/teacher/exercise-answers`

- Operation ID: `StudyService_GetTeacherExerciseAnswers`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `exercise_id` | query | False | `string` |  |
| `user_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentGetTeacherExerciseAnswersResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/study/teacher/homework-answers`

- Operation ID: `StudyService_GetTeacherHomeworkAnswers`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `homework_id` | query | False | `string` |  |
| `user_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentTeacherHomeworkAnswerResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/study/teacher/vstep-answers`

- Operation ID: `StudyService_GetTeacherVstepAnswers`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `vstep_id` | query | False | `string` |  |
| `user_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentGetTeacherVstepAnswersResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/study/vstep-students`

- Operation ID: `StudyService_GetVstepStudents`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `vstep_id` | query | False | `string` |  |
| `course_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentVstepStudentResponseWithCount` |
| `default` | An unexpected error response. | `googleRpcStatus` |

