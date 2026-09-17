# Homework API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `HomeworkService`
Operation count: 10

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `HomeworkService` trong Swagger.

## Endpoints

### `GET /v1/homeworks`

- Operation ID: `HomeworkService_List`

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
| `200` | A successful response. | `assessmentHomeworkListResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/homeworks`

- Operation ID: `HomeworkService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentCreateHomeworkRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentCreateHomeworkResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/homeworks/{id}`

- Operation ID: `HomeworkService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentDeleteHomeworkResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/homeworks/{id}`

- Operation ID: `HomeworkService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentGetHomeworkResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/homeworks/{id}`

- Operation ID: `HomeworkService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `assessmentHomeworkServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentUpdateHomeworkResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/homeworks/{id}/assigned`

- Operation ID: `HomeworkService_Assigned`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `assessmentHomeworkServiceAssignedBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentAssignedHomeworkResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/homeworks/{id}/assigned-lessons`

- Operation ID: `HomeworkService_AssignedLesson`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentAssignedLessonHomeworkResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/homeworks/{id}/cloned`

- Operation ID: `HomeworkService_Cloned`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `assessmentHomeworkServiceClonedBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentClonedHomeworkResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/homeworks/assigned/bulk`

- Operation ID: `HomeworkService_BulkAssigned`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentBulkAssignedHomeworkRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentBulkAssignedHomeworkResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/homeworks/students-doing/list`

- Operation ID: `HomeworkService_StudentsDoing`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `homework_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentHomeworkStudentsDoingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

