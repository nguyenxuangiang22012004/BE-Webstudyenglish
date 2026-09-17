# Sync

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `Sync`
Operation count: 2

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `Sync` trong Swagger.

## Endpoints

### `POST /v1/users/sync/keycloak`

- Operation ID: `Sync_SyncAllUsersToKeycloak`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `userSyncAllUsersRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userSyncAllUsersResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/users/sync/keycloak/{user_id}`

- Operation ID: `Sync_SyncUserToKeycloak`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `user_id` | path | True | `string` |  |
| `body` | body | True | `SyncSyncUserToKeycloakBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userSyncUserResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

