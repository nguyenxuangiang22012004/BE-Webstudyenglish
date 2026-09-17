# ContestRound API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `ContestRoundService`
Operation count: 12

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `ContestRoundService` trong Swagger.

## Endpoints

### `GET /v1/contest-rounds`

- Operation ID: `ContestRoundService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `filters[string]` | query | False | `string` |  |
| `sort` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentListContestRoundResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/contest-rounds`

- Operation ID: `ContestRoundService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentCreateContestRoundRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentCreateContestRoundResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/contest-rounds/{id}`

- Operation ID: `ContestRoundService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentDeleteContestRoundResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/contest-rounds/{id}`

- Operation ID: `ContestRoundService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentGetContestRoundResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/contest-rounds/{id}`

- Operation ID: `ContestRoundService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `assessmentContestRoundServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentUpdateContestRoundResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/contest-rounds/{id}/joiners`

- Operation ID: `ContestRoundService_RemoveJoiner`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `join_level` | query | False | `string` |  |
| `joiner_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentRemoveJoinerContestRoundResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/contest-rounds/{id}/joiners`

- Operation ID: `ContestRoundService_GetContestRoundJoiners`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `filters[string]` | query | False | `string` |  |
| `sort` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentGetContestRoundJoinersResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/contest-rounds/{id}/joiners`

- Operation ID: `ContestRoundService_AddJoiner`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `ContestRoundServiceAddJoinerBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentAddJoinerContestRoundResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/contest-rounds/{id}/joiners/bulk`

- Operation ID: `ContestRoundService_BulkRemoveJoiners`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `join_level` | query | False | `string` |  |
| `joiner_ids` | query | False | `array` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentBulkRemoveJoinersContestRoundResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/contest-rounds/{id}/students`

- Operation ID: `ContestRoundService_GetContestRoundStudents`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentGetContestRoundStudentsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/contest-rounds/{id}/users`

- Operation ID: `ContestRoundService_GetContestRoundUsers`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentGetContestRoundUsersResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/contests/{id}/contest-rounds`

- Operation ID: `ContestRoundService_GetByContestId`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentGetByContestIdContestRoundResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

