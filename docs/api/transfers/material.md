# Material API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `MaterialService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `MaterialService` trong Swagger.

## Endpoints

### `GET /v1/materials/sync-attributes`

- Operation ID: `MaterialService_SyncAttributes`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `tenant_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationSyncAttributesResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/materials/sync-progress/{job_id}`

- Operation ID: `MaterialService_GetSyncProgress`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `job_id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGetSyncProgressResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/materials/sync-subjects`

- Operation ID: `MaterialService_SyncSubjects`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `` |  |  | `` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationSyncSubjectsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/materials/tags`

- Operation ID: `MaterialService_ListMaterialTag`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationListMaterialTagResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/materials/tenants`

- Operation ID: `MaterialService_ListTenant`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationListTenantResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

