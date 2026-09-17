# Notice API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `NoticeService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `NoticeService` trong Swagger.

## Endpoints

### `GET /v1/notices`

- Operation ID: `NoticeService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `status` | query | False | `string` | filter by status (true/false) |
| `type` | query | False | `string` | filter by type |
| `sort` | query | False | `string` | sort field |
| `order` | query | False | `string` | asc/desc |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationListNoticeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/notices`

- Operation ID: `NoticeService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `communicationCreateNoticeRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationCreateNoticeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/notices/{id}`

- Operation ID: `NoticeService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationDeleteNoticeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/notices/{id}`

- Operation ID: `NoticeService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGetNoticeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/notices/{id}`

- Operation ID: `NoticeService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `communicationNoticeServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationUpdateNoticeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

