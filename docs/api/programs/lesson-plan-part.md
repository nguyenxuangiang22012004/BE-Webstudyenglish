# LessonPlanPart API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `LessonPlanPartService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `LessonPlanPartService` trong Swagger.

## Endpoints

### `GET /v1/lesson-plan-parts`

- Operation ID: `LessonPlanPartService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `lesson_plan_id` | query | False | `string` |  |
| `course_id` | query | False | `string` |  |
| `sort_id` | query | False | `string` |  |
| `sort_created_at` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseListLessonPlanPartResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/lesson-plan-parts`

- Operation ID: `LessonPlanPartService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `courseCreateLessonPlanPartRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseCreateLessonPlanPartResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/lesson-plan-parts/{id}`

- Operation ID: `LessonPlanPartService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseDeleteLessonPlanPartResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/lesson-plan-parts/{id}`

- Operation ID: `LessonPlanPartService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseGetLessonPlanPartResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/lesson-plan-parts/{id}`

- Operation ID: `LessonPlanPartService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `courseLessonPlanPartServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseUpdateLessonPlanPartResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

