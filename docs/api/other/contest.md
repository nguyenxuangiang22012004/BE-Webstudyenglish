# Contest API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `ContestService`
Operation count: 7

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `ContestService` trong Swagger.

## Endpoints

### `GET /v1/contests`

- Operation ID: `ContestService_List`

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
| `200` | A successful response. | `assessmentListContestResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/contests`

- Operation ID: `ContestService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentCreateContestRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentCreateContestResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/contests/{id}`

- Operation ID: `ContestService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentDeleteContestResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/contests/{id}`

- Operation ID: `ContestService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentGetContestResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/contests/{id}`

- Operation ID: `ContestService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `assessmentContestServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentUpdateContestResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/contests/{id}/rounds`

- Operation ID: `ContestService_GetContestRounds`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentGetContestRoundsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/contests/{id}/with-rounds`

- Operation ID: `ContestService_GetContestWithRounds`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentGetContestWithRoundsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

