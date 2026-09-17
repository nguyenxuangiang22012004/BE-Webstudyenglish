# Department API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `DepartmentService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `DepartmentService` trong Swagger.

## Endpoints

### `GET /v1/departments`

- Operation ID: `DepartmentService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `status` | query | False | `boolean` |  |
| `sort_id` | query | False | `string` |  |
| `sort_created_at` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userListDepartmentResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/departments`

- Operation ID: `DepartmentService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `userCreateDepartmentRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userCreateDepartmentResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/departments/{id}`

- Operation ID: `DepartmentService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userDeleteDepartmentResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/departments/{id}`

- Operation ID: `DepartmentService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userGetDepartmentResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/departments/{id}`

- Operation ID: `DepartmentService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `userDepartmentServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userUpdateDepartmentResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

