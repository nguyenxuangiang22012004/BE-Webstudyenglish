# Assessment API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `AssessmentService`
Operation count: 10

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `AssessmentService` trong Swagger.

## Endpoints

### `GET /v1/assessments`

- Operation ID: `AssessmentService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `type` | query | False | `string` |  |
| `program_id` | query | False | `string` |  |
| `subject_id` | query | False | `string` |  |
| `course_id` | query | False | `string` |  |
| `lesson_id` | query | False | `string` |  |
| `class_main_id` | query | False | `string` |  |
| `grade_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentListAssessmentResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/assessments`

- Operation ID: `AssessmentService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentCreateAssessmentRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentCreateAssessmentResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/assessments/{id}`

- Operation ID: `AssessmentService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentDeleteAssessmentResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/assessments/{id}`

- Operation ID: `AssessmentService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentGetAssessmentResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/assessments/{id}`

- Operation ID: `AssessmentService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `assessmentAssessmentServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentUpdateAssessmentResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/assessments/ref-lesson`

- Operation ID: `AssessmentService_CreateRefLesson`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentCreateRefAssessmentLessonRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentCreateRefLessonAssessmentResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/assessments/save-score/bulk`

- Operation ID: `AssessmentService_SaveScoreBulk`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentSaveScoreBulkAssessmentRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentSaveScoreBulkAssessmentResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/assessments/with-criteria`

- Operation ID: `AssessmentService_CreateWithCriteria`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentCreateWithCriteriaAssessmentRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentCreateWithCriteriaAssessmentResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/publish-assessments`

- Operation ID: `AssessmentService_GetPublish`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | query | False | `string` |  |
| `assessment_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentGetPublishAssessmentResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/publish-assessments`

- Operation ID: `AssessmentService_UpdatePublish`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentUpdatePublishAssessmentRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentUpdatePublishAssessmentResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

