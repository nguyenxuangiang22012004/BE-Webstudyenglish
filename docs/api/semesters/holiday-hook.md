# HolidayHook API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `HolidayHookService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `HolidayHookService` trong Swagger.

## Endpoints

### `GET /v1/hooks/holidays`

- Operation ID: `HolidayHookService_ListHoliday`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `status` | query | False | `boolean` |  |
| `type` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookListHolidayResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/hooks/holidays`

- Operation ID: `HolidayHookService_CreateHoliday`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `webhookCreateHolidayRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookCreateHolidayResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/hooks/holidays/{id}`

- Operation ID: `HolidayHookService_DeleteHoliday`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookDeleteHolidayResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/hooks/holidays/{id}`

- Operation ID: `HolidayHookService_GetHoliday`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookGetHolidayResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/hooks/holidays/{id}`

- Operation ID: `HolidayHookService_UpdateHoliday`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `HolidayHookServiceUpdateHolidayBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookUpdateHolidayResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

