# Role API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `RoleService`
Operation count: 6

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `RoleService` trong Swagger.

## Endpoints

### `GET /v1/roles`

- Operation ID: `RoleService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `status` | query | False | `boolean` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `authListRoleResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/roles`

- Operation ID: `RoleService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `authCreateRoleRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `authCreateRoleResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/roles/{id}`

- Operation ID: `RoleService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `authDeleteRoleResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/roles/{id}`

- Operation ID: `RoleService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `authGetRoleResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/roles/{id}`

- Operation ID: `RoleService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `authRoleServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `authUpdateRoleResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/roles/{id}/permissions`

- Operation ID: `RoleService_ListPermission`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `authRoleListPermissionResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

