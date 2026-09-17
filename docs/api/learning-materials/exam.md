# Exam API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `ExamService`
Operation count: 8

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `ExamService` trong Swagger.

## Endpoints

### `GET /v1/exams`

- Operation ID: `ExamService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `filters[string]` | query | False | `string` |  |
| `sort` | query | False | `string` |  |
| `sort_id` | query | False | `string` |  |
| `sort_created_at` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentExamListResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/exams`

- Operation ID: `ExamService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentCreateExamRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentCreateExamResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/exams/{id}`

- Operation ID: `ExamService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentDeleteExamResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/exams/{id}`

- Operation ID: `ExamService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentGetExamResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/exams/{id}`

- Operation ID: `ExamService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `assessmentExamServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentUpdateExamResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/exams/{id}/assigned`

- Operation ID: `ExamService_Assigned`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `assessmentExamServiceAssignedBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentAssignedExamResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/exams/{id}/assigned-lessons`

- Operation ID: `ExamService_AssignedLesson`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentAssignedLessonExamResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/exams/{id}/cloned`

- Operation ID: `ExamService_Cloned`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `assessmentExamServiceClonedBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentClonedExamResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

