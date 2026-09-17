# TrainingLevel API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `TrainingLevelService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `TrainingLevelService` trong Swagger.

## Endpoints

### `GET /v1/training-levels`

- Operation ID: `TrainingLevelService_List`

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
| `200` | A successful response. | `courseListTrainingLevelResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/training-levels`

- Operation ID: `TrainingLevelService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `courseCreateTrainingLevelRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseCreateTrainingLevelResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/training-levels/{id}`

- Operation ID: `TrainingLevelService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseDeleteTrainingLevelResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/training-levels/{id}`

- Operation ID: `TrainingLevelService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseGetTrainingLevelResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/training-levels/{id}`

- Operation ID: `TrainingLevelService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `courseTrainingLevelServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseUpdateTrainingLevelResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

