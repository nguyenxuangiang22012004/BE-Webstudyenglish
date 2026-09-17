# FacultyHook API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `FacultyHookService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `FacultyHookService` trong Swagger.

## Endpoints

### `GET /v1/hooks/faculties`

- Operation ID: `FacultyHookService_ListFaculty`

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
| `200` | A successful response. | `webhookListFacultyResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/hooks/faculties`

- Operation ID: `FacultyHookService_CreateFaculty`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `webhookCreateFacultyRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookCreateFacultyResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/hooks/faculties/{id}`

- Operation ID: `FacultyHookService_DeleteFaculty`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookDeleteFacultyResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/hooks/faculties/{id}`

- Operation ID: `FacultyHookService_GetFaculty`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookGetFacultyResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/hooks/faculties/{id}`

- Operation ID: `FacultyHookService_UpdateFaculty`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `FacultyHookServiceUpdateFacultyBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookUpdateFacultyResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

