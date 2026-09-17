# Chapter API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `ChapterService`
Operation count: 6

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `ChapterService` trong Swagger.

## Endpoints

### `GET /v1/chapters`

- Operation ID: `ChapterService_List`

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
| `200` | A successful response. | `courseListChapterResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/chapters`

- Operation ID: `ChapterService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `courseCreateChapterRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseCreateChapterResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/chapters/{id}`

- Operation ID: `ChapterService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseDeleteChapterResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/chapters/{id}`

- Operation ID: `ChapterService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseGetChapterResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/chapters/{id}`

- Operation ID: `ChapterService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `courseChapterServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseUpdateChapterResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/chapters/{id}/sort-lessons`

- Operation ID: `ChapterService_SortLesson`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `ChapterServiceSortLessonBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseSortLessonResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

