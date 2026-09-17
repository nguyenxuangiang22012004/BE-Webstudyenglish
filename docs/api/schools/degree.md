# Degree API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `DegreeService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `DegreeService` trong Swagger.

## Endpoints

### `GET /v1/degrees`

- Operation ID: `DegreeService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `user_id` | query | False | `string` |  |
| `status` | query | False | `boolean` |  |
| `sort_id` | query | False | `string` |  |
| `sort_created_at` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userListDegreeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/degrees`

- Operation ID: `DegreeService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `userCreateDegreeRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userCreateDegreeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/degrees/{id}`

- Operation ID: `DegreeService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userDeleteDegreeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/degrees/{id}`

- Operation ID: `DegreeService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userGetDegreeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/degrees/{id}`

- Operation ID: `DegreeService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `userDegreeServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userUpdateDegreeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

