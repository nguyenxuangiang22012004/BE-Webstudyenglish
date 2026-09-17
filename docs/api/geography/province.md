# Province API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `ProvinceService`
Operation count: 3

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `ProvinceService` trong Swagger.

## Endpoints

### `GET /v1/provinces`

- Operation ID: `ProvinceService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonListProvinceResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/provinces/{code}`

- Operation ID: `ProvinceService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `code` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonGetProvinceResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/provinces/{code}/wards`

- Operation ID: `ProvinceService_ListWardByProvinceCode`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `code` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonListWardByProvinceCodeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

