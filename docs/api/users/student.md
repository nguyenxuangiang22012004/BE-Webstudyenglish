# Student API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `StudentService`
Operation count: 8

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `StudentService` trong Swagger.

## Endpoints

### `GET /v1/dashboard/student/assessments`

- Operation ID: `StudentService_GetStudentAssessments`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | query | False | `string` |  |
| `assessment_id` | query | False | `string` |  |
| `assessment_type` | query | False | `string` | Filter assessments.type: 'mini_test' hoặc 'final_exam' |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `month` | query | False | `integer` |  |
| `year` | query | False | `integer` |  |
| `school_year` | query | False | `integer` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetStudentAssessmentsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/student/exam`

- Operation ID: `StudentService_GetStudentExam`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | query | False | `string` |  |
| `start_date` | query | False | `string` |  |
| `end_date` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetStudentExamResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/student/exam-list`

- Operation ID: `StudentService_ListStudentExam`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | query | False | `string` |  |
| `start_date` | query | False | `string` |  |
| `end_date` | query | False | `string` |  |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsListStudentExamResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/student/homework`

- Operation ID: `StudentService_GetStudentHomework`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | query | False | `string` |  |
| `start_date` | query | False | `string` |  |
| `end_date` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetStudentHomeworkResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/student/homework-detail`

- Operation ID: `StudentService_GetStudentHomeworkDetail`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `homework_id` | query | False | `string` |  |
| `lesson_id` | query | False | `string` |  |
| `batch` | query | False | `integer` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetStudentHomeworkDetailResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/student/homework-list`

- Operation ID: `StudentService_ListStudentHomework`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | query | False | `string` |  |
| `chapter_id` | query | False | `string` |  |
| `lesson_id` | query | False | `string` |  |
| `status` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |
| `week_id` | query | False | `string` |  |
| `get_missing_homework` | query | False | `boolean` |  |
| `is_unlock` | query | False | `boolean` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsListStudentHomeworkResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/student/homework-report-list`

- Operation ID: `StudentService_ListStudentHomework2`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | query | False | `string` |  |
| `chapter_id` | query | False | `string` |  |
| `lesson_id` | query | False | `string` |  |
| `status` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |
| `week_id` | query | False | `string` |  |
| `get_missing_homework` | query | False | `boolean` |  |
| `is_unlock` | query | False | `boolean` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsListStudentHomeworkResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/student/vocabulary-report-list`

- Operation ID: `StudentService_ListStudentVocabularyReport`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `program_id` | query | False | `string` |  |
| `course_id` | query | False | `string` |  |
| `lesson_id` | query | False | `string` |  |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |
| `chapter_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsListStudentVocabularyReportResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

