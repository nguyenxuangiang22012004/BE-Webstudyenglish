# Setting API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `SettingService`
Operation count: 6

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `SettingService` trong Swagger.

## Endpoints

### `GET /v1/settings`

- Operation ID: `SettingService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `sort_by` | query | False | `string` |  |
| `sort_order` | query | False | `string` |  |
| `is_active` | query | False | `boolean` |  |
| `key` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonListSettingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/settings`

- Operation ID: `SettingService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `commonCreateSettingRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonCreateSettingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/settings/{id}`

- Operation ID: `SettingService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonDeleteSettingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/settings/{id}`

- Operation ID: `SettingService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonGetSettingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/settings/{id}`

- Operation ID: `SettingService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `commonSettingServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonUpdateSettingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/settings/by-key/{key}`

- Operation ID: `SettingService_GetByKey`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `key` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonGetSettingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

