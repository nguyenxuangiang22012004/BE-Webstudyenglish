# Topic API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `TopicService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `TopicService` trong Swagger.

## Endpoints

### `GET /v1/topics`

- Operation ID: `TopicService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `status` | query | False | `boolean` |  |
| `type` | query | False | `string` |  |
| `parent_id` | query | False | `string` |  |
| `sort_id` | query | False | `string` |  |
| `sort_created_at` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseListTopicResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/topics`

- Operation ID: `TopicService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `courseCreateTopicRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseCreateTopicResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/topics/{id}`

- Operation ID: `TopicService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseDeleteTopicResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/topics/{id}`

- Operation ID: `TopicService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseGetTopicResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/topics/{id}`

- Operation ID: `TopicService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `courseTopicServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseUpdateTopicResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

