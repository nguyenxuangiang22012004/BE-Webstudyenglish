# Permission API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `PermissionService`
Operation count: 4

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `PermissionService` trong Swagger.

## Endpoints

### `GET /v1/permissions`

- Operation ID: `PermissionService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `` |  |  | `` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `authListPermissionResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/permissions`

- Operation ID: `PermissionService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `authUpdatePermissionRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `authUpdatePermissionResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/permissions/display`

- Operation ID: `PermissionService_ListDisplay`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `` |  |  | `` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `authPermissionListDisplayResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/permissions/display`

- Operation ID: `PermissionService_UpdateDisplay`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `authPermissionUpdateDisplayRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `authPermissionUpdateDisplayResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

