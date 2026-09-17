# LessonHook API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `LessonHookService`
Operation count: 8

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `LessonHookService` trong Swagger.

## Endpoints

### `GET /v1/hooks/lessons`

- Operation ID: `LessonHookService_ListLesson`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `status` | query | False | `boolean` |  |
| `chapter_id` | query | False | `string` |  |
| `schedule_week_id` | query | False | `string` |  |
| `schedule_course_id` | query | False | `string` |  |
| `schedule_by_user` | query | False | `boolean` |  |
| `program_id` | query | False | `string` |  |
| `sort_id` | query | False | `string` |  |
| `sort_created_at` | query | False | `string` |  |
| `course_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookListLessonResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/hooks/lessons`

- Operation ID: `LessonHookService_CreateLesson`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `webhookCreateLessonRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookCreateLessonResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/hooks/lessons/{id}`

- Operation ID: `LessonHookService_DeleteLesson`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookDeleteLessonResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/hooks/lessons/{id}`

- Operation ID: `LessonHookService_GetLesson`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `course_id` | query | False | `string` |  |
| `by_user` | query | False | `boolean` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookGetLessonResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/hooks/lessons/{id}`

- Operation ID: `LessonHookService_UpdateLesson`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `LessonHookServiceUpdateLessonBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookUpdateLessonResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/hooks/lessons/{id}/completion`

- Operation ID: `LessonHookService_CompletionLesson`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `LessonHookServiceCompletionLessonBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookCompletionLessonResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/hooks/lessons/schedules`

- Operation ID: `LessonHookService_ListScheduleLesson`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | query | False | `string` |  |
| `week_id` | query | False | `string` |  |
| `semester_id` | query | False | `string` |  |
| `week_by_course` | query | False | `boolean` |  |
| `by_user` | query | False | `boolean` |  |
| `date` | query | False | `string` |  |
| `sort_id` | query | False | `string` |  |
| `sort_created_at` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookListScheduleResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/lessons/schedules`

- Operation ID: `LessonHookService_UpdateScheduleLesson`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `webhookUpdateScheduleRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookUpdateScheduleResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

