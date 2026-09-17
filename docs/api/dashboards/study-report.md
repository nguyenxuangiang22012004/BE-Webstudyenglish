# StudyReport API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `StudyReportService`
Operation count: 8

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `StudyReportService` trong Swagger.

## Endpoints

### `GET /v1/publish-study-report`

- Operation ID: `StudyReportService_GetPublish`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | query | False | `string` |  |
| `assessment_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentGetPublishStudyReportResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/publish-study-report`

- Operation ID: `StudyReportService_UpdatePublish`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentUpdatePublishStudyReportRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentUpdatePublishStudyReportResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/study-reports`

- Operation ID: `StudyReportService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `status` | query | False | `boolean` |  |
| `type` | query | False | `string` |  |
| `sort_id` | query | False | `string` |  |
| `sort_created_at` | query | False | `string` |  |
| `subject_id` | query | False | `string` |  |
| `course_id` | query | False | `string` |  |
| `student_id` | query | False | `string` |  |
| `teacher_id` | query | False | `string` |  |
| `assessment_id` | query | False | `string` |  |
| `is_completed` | query | False | `boolean` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentListStudyReportResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/study-reports`

- Operation ID: `StudyReportService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentCreateStudyReportRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentCreateStudyReportResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/study-reports/{id}`

- Operation ID: `StudyReportService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentDeleteStudyReportResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/study-reports/{id}`

- Operation ID: `StudyReportService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentGetStudyReportResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/study-reports/{id}`

- Operation ID: `StudyReportService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `assessmentStudyReportServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentUpdateStudyReportResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/study-reports/evaluates/{course_id}`

- Operation ID: `StudyReportService_Evaluate`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | path | True | `string` |  |
| `assessment_id` | query | False | `string` |  |
| `is_completed` | query | False | `boolean` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentEvaluateStudyReportResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

