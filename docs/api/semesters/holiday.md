# Holiday API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `HolidayService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `HolidayService` trong Swagger.

## Endpoints

### `GET /v1/holidays`

- Operation ID: `HolidayService_List`

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
| `200` | A successful response. | `commonListHolidayResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/holidays`

- Operation ID: `HolidayService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `commonCreateHolidayRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonCreateHolidayResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/holidays/{id}`

- Operation ID: `HolidayService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonDeleteHolidayResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/holidays/{id}`

- Operation ID: `HolidayService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonGetHolidayResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/holidays/{id}`

- Operation ID: `HolidayService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `commonHolidayServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonUpdateHolidayResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

