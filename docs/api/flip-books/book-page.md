# BookPage API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `BookPageService`
Operation count: 6

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `BookPageService` trong Swagger.

## Endpoints

### `GET /v1/book-pages`

- Operation ID: `BookPageService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `book_id` | query | False | `string` |  |
| `chapter_id` | query | False | `string` |  |
| `lesson_id` | query | False | `string` |  |
| `page_number` | query | False | `integer` |  |
| `sort_id` | query | False | `string` |  |
| `sort_created_at` | query | False | `string` |  |
| `sort_page_number` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentListBookPageResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/book-pages`

- Operation ID: `BookPageService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `contentCreateBookPageRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentCreateBookPageResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/book-pages/{id}`

- Operation ID: `BookPageService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentDeleteBookPageResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/book-pages/{id}`

- Operation ID: `BookPageService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentGetBookPageResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/book-pages/{id}`

- Operation ID: `BookPageService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `contentBookPageServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentUpdateBookPageResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/book-pages/attach`

- Operation ID: `BookPageService_AttachPages`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `contentAttachBookPagesRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentAttachBookPagesResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

