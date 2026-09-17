# LessonPlan API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `LessonPlanService`
Operation count: 10

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `LessonPlanService` trong Swagger.

## Endpoints

### `GET /v1/lesson-plans`

- Operation ID: `LessonPlanService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `lesson_id` | query | False | `string` |  |
| `keyword` | query | False | `string` |  |
| `sort_id` | query | False | `string` |  |
| `sort_created_at` | query | False | `string` |  |
| `course_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseListLessonPlanResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/lesson-plans`

- Operation ID: `LessonPlanService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `courseCreateLessonPlanRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseCreateLessonPlanResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/lesson-plans/{id}`

- Operation ID: `LessonPlanService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseDeleteLessonPlanResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/lesson-plans/{id}`

- Operation ID: `LessonPlanService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `course_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseGetLessonPlanResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/lesson-plans/{id}`

- Operation ID: `LessonPlanService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `courseLessonPlanServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseUpdateLessonPlanResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/lesson-plans/{id}/complete`

- Operation ID: `LessonPlanService_Complete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `courseLessonPlanServiceCompleteBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseCompleteLessonPlanResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/lesson-plans/share-material`

- Operation ID: `LessonPlanService_ShareMaterial`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `courseShareLessonPlanRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseShareLessonPlanResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/lesson-plans/share-materials`

- Operation ID: `LessonPlanService_ListSharedMaterial`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `attribute_ids` | query | False | `array` |  |
| `tags` | query | False | `array` |  |
| `subject_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseListSharedLessonPlanResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/lesson-plans/share-materials/{id}`

- Operation ID: `LessonPlanService_GetSharedMaterial`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseGetSharedLessonPlanResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/lesson-plans/upload-material`

- Operation ID: `LessonPlanService_UploadMaterial`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `courseUploadLessonPlanRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseUploadLessonPlanResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

