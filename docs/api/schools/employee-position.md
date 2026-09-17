# EmployeePosition API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `EmployeePositionService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `EmployeePositionService` trong Swagger.

## Endpoints

### `GET /v1/employee-positions`

- Operation ID: `EmployeePositionService_List`

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
| `200` | A successful response. | `userListEmployeePositionResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/employee-positions`

- Operation ID: `EmployeePositionService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `userCreateEmployeePositionRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userCreateEmployeePositionResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/employee-positions/{id}`

- Operation ID: `EmployeePositionService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userDeleteEmployeePositionResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/employee-positions/{id}`

- Operation ID: `EmployeePositionService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userGetEmployeePositionResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/employee-positions/{id}`

- Operation ID: `EmployeePositionService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `userEmployeePositionServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userUpdateEmployeePositionResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

