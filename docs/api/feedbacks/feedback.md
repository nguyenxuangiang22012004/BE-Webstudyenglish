# Feedback API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `FeedbackService`
Operation count: 6

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `FeedbackService` trong Swagger.

## Endpoints

### `GET /v1/feedbacks`

- Operation ID: `FeedbackService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `order_by` | query | False | `string` |  |
| `user_id` | query | False | `string` |  |
| `role_id` | query | False | `string` |  |
| `status` | query | False | `string` |  |
| `type` | query | False | `string` |  |
| `start_date` | query | False | `string` |  |
| `end_date` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonListFeedbackResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/feedbacks`

- Operation ID: `FeedbackService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `commonCreateFeedbackRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonCreateFeedbackResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/feedbacks/{id}`

- Operation ID: `FeedbackService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonDeleteFeedbackResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/feedbacks/{id}`

- Operation ID: `FeedbackService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonGetFeedbackResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/feedbacks/{id}`

- Operation ID: `FeedbackService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `commonFeedbackServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonUpdateFeedbackResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/feedbacks/{id}/status`

- Operation ID: `FeedbackService_UpdateStatus`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `FeedbackServiceUpdateStatusBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonUpdateFeedbackStatusResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

