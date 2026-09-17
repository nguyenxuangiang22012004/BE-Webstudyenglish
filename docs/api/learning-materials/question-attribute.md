# QuestionAttribute API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `QuestionAttributeService`
Operation count: 8

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `QuestionAttributeService` trong Swagger.

## Endpoints

### `GET /v1/question-attributes`

- Operation ID: `QuestionAttributeService_List`

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
| `200` | A successful response. | `courseListQuestionAttributeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/question-attributes`

- Operation ID: `QuestionAttributeService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `courseCreateQuestionAttributeRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseCreateQuestionAttributeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/question-attributes/{id}`

- Operation ID: `QuestionAttributeService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseDeleteQuestionAttributeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/question-attributes/{id}`

- Operation ID: `QuestionAttributeService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseGetQuestionAttributeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/question-attributes/{id}`

- Operation ID: `QuestionAttributeService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `courseQuestionAttributeServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseUpdateQuestionAttributeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/question-attributes/bulk`

- Operation ID: `QuestionAttributeService_ListBulk`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `parent_id` | query | False | `string` |  |
| `subject_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseListBulkQuestionAttributeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/question-attributes/bulk`

- Operation ID: `QuestionAttributeService_UpsertBulk`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `courseUpsertBulkQuestionAttributeRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseUpsertBulkQuestionAttributeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/question-attributes/parent`

- Operation ID: `QuestionAttributeService_ListParent`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `subject_id` | query | False | `string` |  |
| `sort_id` | query | False | `string` |  |
| `sort_created_at` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseListParentQuestionAttributeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

