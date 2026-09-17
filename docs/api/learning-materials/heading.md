# Heading API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `HeadingService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `HeadingService` trong Swagger.

## Endpoints

### `GET /v1/headings`

- Operation ID: `HeadingService_List`

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
| `200` | A successful response. | `courseListHeadingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/headings`

- Operation ID: `HeadingService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `courseCreateHeadingRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseCreateHeadingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/headings/{id}`

- Operation ID: `HeadingService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseDeleteHeadingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/headings/{id}`

- Operation ID: `HeadingService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseGetHeadingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/headings/{id}`

- Operation ID: `HeadingService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `courseHeadingServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseUpdateHeadingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

