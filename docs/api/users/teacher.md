# Teacher API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `TeacherService`
Operation count: 10

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `TeacherService` trong Swagger.

## Endpoints

### `GET /v1/dashboard/teacher/assessment/students`

- Operation ID: `TeacherService_GetAssessmentStudents`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | query | False | `string` |  |
| `assessment_id` | query | False | `string` |  |
| `student_id` | query | False | `string` |  |
| `get_score` | query | False | `boolean` |  |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetAssessmentStudentsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/teacher/exam-scored`

- Operation ID: `TeacherService_GetExamScored`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | query | False | `string` |  |
| `exam_id` | query | False | `string` |  |
| `start_date` | query | False | `string` |  |
| `end_date` | query | False | `string` |  |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |
| `sort[string]` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetExamScoredResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/teacher/homework`

- Operation ID: `TeacherService_GetHomework`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | query | False | `string` |  |
| `chapter_id` | query | False | `string` |  |
| `lesson_id` | query | False | `string` |  |
| `lesson_ids` | query | False | `string` |  |
| `homework_ids` | query | False | `string` |  |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |
| `sort[string]` | query | False | `string` |  |
| `order_by` | query | False | `string` |  |
| `start_date` | query | False | `string` | YYYY-MM-DD hoặc unix |
| `end_date` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetHomeworkResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/teacher/homework-manual-scoring`

- Operation ID: `TeacherService_GetHomeworkManualScoring`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `homework_id` | query | False | `string` |  |
| `course_id` | query | False | `string` |  |
| `user_id` | query | False | `string` |  |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |
| `sort[string]` | query | False | `string` |  |
| `start_date` | query | False | `string` |  |
| `end_date` | query | False | `string` |  |
| `status` | query | False | `string` | "all", "unscored", "scored" |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetHomeworkManualScoringResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/teacher/homework-overview`

- Operation ID: `TeacherService_GetHomeworkOverview`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `homework_id` | query | False | `string` |  |
| `course_id` | query | False | `string` |  |
| `lesson_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetHomeworkOverviewResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/teacher/homework-overview-grade`

- Operation ID: `TeacherService_GetHomeworkOverviewGrade`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `start_date` | query | False | `string` |  |
| `end_date` | query | False | `string` |  |
| `course_id` | query | False | `string` |  |
| `lesson_id` | query | False | `string` |  |
| `homework_id` | query | False | `string` |  |
| `user_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetHomeworkOverviewGradeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/teacher/homework-scored`

- Operation ID: `TeacherService_GetHomeworkScored`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `homework_id` | query | False | `string` |  |
| `course_id` | query | False | `string` |  |
| `user_id` | query | False | `string` |  |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |
| `sort[string]` | query | False | `string` |  |
| `start_date` | query | False | `string` |  |
| `end_date` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetHomeworkScoredResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/teacher/homework-unscored`

- Operation ID: `TeacherService_GetHomeworkUnscored`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `homework_id` | query | False | `string` |  |
| `course_id` | query | False | `string` |  |
| `user_id` | query | False | `string` |  |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |
| `sort[string]` | query | False | `string` |  |
| `start_date` | query | False | `string` |  |
| `end_date` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetHomeworkUnscoredResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/teacher/homework/{homework_id}`

- Operation ID: `TeacherService_GetHomeworkById`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `homework_id` | path | True | `string` |  |
| `course_id` | query | False | `string` |  |
| `lesson_id` | query | False | `string` |  |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |
| `sort[string]` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetHomeworkByIdResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/teacher/homework/list-homeworks`

- Operation ID: `TeacherService_ListHomework`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | query | False | `string` |  |
| `student_id` | query | False | `string` |  |
| `chapter_id` | query | False | `string` |  |
| `lesson_id` | query | False | `string` |  |
| `lesson_ids` | query | False | `string` |  |
| `homework_ids` | query | False | `string` |  |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |
| `sort[string]` | query | False | `string` |  |
| `order_by` | query | False | `string` |  |
| `start_date` | query | False | `string` |  |
| `end_date` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsListHomeworkResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

