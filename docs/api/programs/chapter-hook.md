# ChapterHook API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `ChapterHookService`
Operation count: 6

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `ChapterHookService` trong Swagger.

## Endpoints

### `GET /v1/hooks/chapters`

- Operation ID: `ChapterHookService_ListChapter`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `status` | query | False | `boolean` |  |
| `program_id` | query | False | `string` |  |
| `sort_id` | query | False | `string` |  |
| `sort_created_at` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookListChapterResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/hooks/chapters`

- Operation ID: `ChapterHookService_CreateChapter`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `webhookCreateChapterRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookCreateChapterResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/hooks/chapters/{id}`

- Operation ID: `ChapterHookService_DeleteChapter`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookDeleteChapterResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/hooks/chapters/{id}`

- Operation ID: `ChapterHookService_GetChapter`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookGetChapterResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/hooks/chapters/{id}`

- Operation ID: `ChapterHookService_UpdateChapter`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `ChapterHookServiceUpdateChapterBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookUpdateChapterResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/hooks/chapters/{id}/sort-lessons`

- Operation ID: `ChapterHookService_ChapterSortLesson`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `ChapterHookServiceChapterSortLessonBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookSortLessonResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

