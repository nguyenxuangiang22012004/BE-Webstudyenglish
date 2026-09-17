# GradeHook API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `GradeHookService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `GradeHookService` trong Swagger.

## Endpoints

### `GET /v1/hooks/grades`

- Operation ID: `GradeHookService_ListGrade`

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
| `200` | A successful response. | `webhookListGradeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/hooks/grades`

- Operation ID: `GradeHookService_CreateGrade`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `webhookCreateGradeRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookCreateGradeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/hooks/grades/{id}`

- Operation ID: `GradeHookService_DeleteGrade`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookDeleteGradeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/hooks/grades/{id}`

- Operation ID: `GradeHookService_GetGrade`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookGetGradeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/hooks/grades/{id}`

- Operation ID: `GradeHookService_UpdateGrade`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `GradeHookServiceUpdateGradeBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookUpdateGradeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

