# Faculty API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `FacultyService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `FacultyService` trong Swagger.

## Endpoints

### `GET /v1/faculties`

- Operation ID: `FacultyService_List`

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
| `200` | A successful response. | `userListFacultyResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/faculties`

- Operation ID: `FacultyService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `userCreateFacultyRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userCreateFacultyResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/faculties/{id}`

- Operation ID: `FacultyService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userDeleteFacultyResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/faculties/{id}`

- Operation ID: `FacultyService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userGetFacultyResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/faculties/{id}`

- Operation ID: `FacultyService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `userFacultyServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userUpdateFacultyResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

