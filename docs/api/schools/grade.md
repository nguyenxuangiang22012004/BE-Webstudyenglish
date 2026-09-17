# Grade API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `GradeService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `GradeService` trong Swagger.

## Endpoints

### `GET /v1/grades`

- Operation ID: `GradeService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `sort_id` | query | False | `string` |  |
| `sort_created_at` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userListGradeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/grades`

- Operation ID: `GradeService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `userCreateGradeRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userCreateGradeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/grades/{id}`

- Operation ID: `GradeService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userDeleteGradeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/grades/{id}`

- Operation ID: `GradeService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userGetGradeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/grades/{id}`

- Operation ID: `GradeService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `userGradeServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userUpdateGradeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

