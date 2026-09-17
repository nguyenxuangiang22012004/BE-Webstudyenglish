# Tag API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `TagService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `TagService` trong Swagger.

## Endpoints

### `GET /v1/tags`

- Operation ID: `TagService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `status` | query | False | `boolean` |  |
| `type` | query | False | `string` |  |
| `sort_id` | query | False | `string` |  |
| `sort_created_at` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseListTagResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/tags`

- Operation ID: `TagService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `courseCreateTagRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseCreateTagResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/tags/{id}`

- Operation ID: `TagService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseDeleteTagResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/tags/{id}`

- Operation ID: `TagService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseGetTagResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/tags/{id}`

- Operation ID: `TagService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `courseTagServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseUpdateTagResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

