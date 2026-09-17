# TeachingPlan API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `TeachingPlanService`
Operation count: 6

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `TeachingPlanService` trong Swagger.

## Endpoints

### `PUT /v1/teaching-plan-approve`

- Operation ID: `TeachingPlanService_Approve`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `courseApproveTeachingPlanRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseApproveTeachingPlanResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/teaching-plans`

- Operation ID: `TeachingPlanService_List`

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
| `200` | A successful response. | `courseListTeachingPlanResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/teaching-plans`

- Operation ID: `TeachingPlanService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `courseCreateTeachingPlanRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseCreateTeachingPlanResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/teaching-plans/{id}`

- Operation ID: `TeachingPlanService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseDeleteTeachingPlanResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/teaching-plans/{id}`

- Operation ID: `TeachingPlanService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseGetTeachingPlanResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/teaching-plans/{id}`

- Operation ID: `TeachingPlanService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `courseTeachingPlanServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseUpdateTeachingPlanResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

