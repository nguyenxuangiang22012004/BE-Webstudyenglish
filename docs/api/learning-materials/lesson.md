# Lesson API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `LessonService`
Operation count: 7

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `LessonService` trong Swagger.

## Endpoints

### `GET /v1/lessons`

- Operation ID: `LessonService_List`

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
| `200` | A successful response. | `courseListLessonResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/lessons`

- Operation ID: `LessonService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `courseCreateLessonRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseCreateLessonResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/lessons/{id}`

- Operation ID: `LessonService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseDeleteLessonResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/lessons/{id}`

- Operation ID: `LessonService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `course_id` | query | False | `string` |  |
| `by_user` | query | False | `boolean` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseGetLessonResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/lessons/{id}`

- Operation ID: `LessonService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `courseLessonServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseUpdateLessonResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/lessons/{id}/completion`

- Operation ID: `LessonService_Completion`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `LessonServiceCompletionBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseCompletionLessonResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/lessons/schedules`

- Operation ID: `LessonService_ListSchedule`

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
| `200` | A successful response. | `courseListScheduleResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

