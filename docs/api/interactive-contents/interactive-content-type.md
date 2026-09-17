# InteractiveContentType API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `InteractiveContentTypeService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `InteractiveContentTypeService` trong Swagger.

## Endpoints

### `GET /v1/interactive/content-types`

- Operation ID: `InteractiveContentTypeService_ListContentTypes`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `sort_id` | query | False | `string` |  |
| `sort_created_at` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentListContentTypesResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/interactive/content-types`

- Operation ID: `InteractiveContentTypeService_CreateContentType`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `contentCreateContentTypeRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentCreateContentTypeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/interactive/content-types/{id}`

- Operation ID: `InteractiveContentTypeService_DeleteContentType`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentDeleteContentTypeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/interactive/content-types/{id}`

- Operation ID: `InteractiveContentTypeService_GetContentType`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentGetContentTypeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/interactive/content-types/{id}`

- Operation ID: `InteractiveContentTypeService_UpdateContentType`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `InteractiveContentTypeServiceUpdateContentTypeBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentUpdateContentTypeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

