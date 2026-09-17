# SourceQuestion API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `SourceQuestionService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `SourceQuestionService` trong Swagger.

## Endpoints

### `GET /v1/source-questions`

- Operation ID: `SourceQuestionService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `status` | query | False | `boolean` |  |
| `sort_id` | query | False | `string` |  |
| `sort_created_at` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseListSourceQuestionResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/source-questions`

- Operation ID: `SourceQuestionService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `courseCreateSourceQuestionRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseCreateSourceQuestionResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/source-questions/{id}`

- Operation ID: `SourceQuestionService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseDeleteSourceQuestionResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/source-questions/{id}`

- Operation ID: `SourceQuestionService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseGetSourceQuestionResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/source-questions/{id}`

- Operation ID: `SourceQuestionService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `courseSourceQuestionServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseUpdateSourceQuestionResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

