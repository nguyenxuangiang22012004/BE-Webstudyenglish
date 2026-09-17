# Book API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `BookService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `BookService` trong Swagger.

## Endpoints

### `GET /v1/books`

- Operation ID: `BookService_List`

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
| `tag_ids` | query | False | `string` |  |
| `grade_id` | query | False | `string` |  |
| `subject_id` | query | False | `string` |  |
| `type` | query | False | `string` |  |
| `topic` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentListBookResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/books`

- Operation ID: `BookService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `contentCreateBookRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentCreateBookResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/books/{id}`

- Operation ID: `BookService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentDeleteBookResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/books/{id}`

- Operation ID: `BookService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentGetBookResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/books/{id}`

- Operation ID: `BookService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `contentBookServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentUpdateBookResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

