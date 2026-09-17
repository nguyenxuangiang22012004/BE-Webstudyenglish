# ProvinceHook API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `ProvinceHookService`
Operation count: 3

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `ProvinceHookService` trong Swagger.

## Endpoints

### `GET /v1/hooks/provinces`

- Operation ID: `ProvinceHookService_ListProvince`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookListProvinceResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/hooks/provinces/{code}`

- Operation ID: `ProvinceHookService_GetProvince`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `code` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookGetProvinceResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/hooks/provinces/{code}/wards`

- Operation ID: `ProvinceHookService_ListWardByProvinceCode`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `code` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookListWardByProvinceCodeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

