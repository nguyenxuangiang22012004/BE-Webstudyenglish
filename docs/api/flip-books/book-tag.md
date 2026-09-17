# BookTag API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `BookTagService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `BookTagService` trong Swagger.

## Endpoints

### `GET /v1/book-tags`

- Operation ID: `BookTagService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `keyword` | query | False | `string` |  |
| `level` | query | False | `integer` |  |
| `parent_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentListBookTagResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/book-tags`

- Operation ID: `BookTagService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `contentCreateBookTagRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentCreateBookTagResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/book-tags/{id}`

- Operation ID: `BookTagService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentDeleteBookTagResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/book-tags/{id}`

- Operation ID: `BookTagService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentGetBookTagResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/book-tags/{id}`

- Operation ID: `BookTagService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `contentBookTagServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentUpdateBookTagResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

