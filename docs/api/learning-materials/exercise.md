# Exercise API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `ExerciseService`
Operation count: 8

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `ExerciseService` trong Swagger.

## Endpoints

### `GET /v1/exercises`

- Operation ID: `ExerciseService_List`

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
| `200` | A successful response. | `assessmentExerciseListResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/exercises`

- Operation ID: `ExerciseService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentCreateExerciseRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentCreateExerciseResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/exercises/{id}`

- Operation ID: `ExerciseService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentDeleteExerciseResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/exercises/{id}`

- Operation ID: `ExerciseService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentGetExerciseResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/exercises/{id}`

- Operation ID: `ExerciseService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `assessmentExerciseServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentUpdateExerciseResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/exercises/{id}/assigned`

- Operation ID: `ExerciseService_Assigned`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `assessmentExerciseServiceAssignedBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentAssignedExerciseResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/exercises/{id}/assigned-lessons`

- Operation ID: `ExerciseService_AssignedLesson`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentAssignedLessonExerciseResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/exercises/{id}/cloned`

- Operation ID: `ExerciseService_Cloned`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `assessmentExerciseServiceClonedBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentClonedExerciseResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

