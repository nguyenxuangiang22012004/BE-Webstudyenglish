# AppVersion API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `AppVersionService`
Operation count: 6

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `AppVersionService` trong Swagger.

## Endpoints

### `GET /v1/app-versions`

- Operation ID: `AppVersionService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `platform` | query | False | `string` |  |
| `is_current` | query | False | `boolean` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonListAppVersionResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/app-versions`

- Operation ID: `AppVersionService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `commonCreateAppVersionRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonCreateAppVersionResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/app-versions/{id}`

- Operation ID: `AppVersionService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonDeleteAppVersionResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/app-versions/{id}`

- Operation ID: `AppVersionService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonGetAppVersionResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/app-versions/{id}`

- Operation ID: `AppVersionService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `commonAppVersionServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonUpdateAppVersionResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/app-versions/current`

- Operation ID: `AppVersionService_GetCurrent`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `` |  |  | `` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonGetCurrentAppVersionResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

