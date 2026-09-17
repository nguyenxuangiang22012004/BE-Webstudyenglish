# H5P API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `H5PService`
Operation count: 3

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `H5PService` trong Swagger.

## Endpoints

### `GET /v1/h5p`

- Operation ID: `H5PService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentListH5PResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/h5p/{content_id}`

- Operation ID: `H5PService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `content_id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentDeleteH5PResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/h5p/{content_id}`

- Operation ID: `H5PService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `content_id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentGetH5PResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

