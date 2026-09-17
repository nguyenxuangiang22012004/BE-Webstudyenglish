# SemesterHook API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `SemesterHookService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `SemesterHookService` trong Swagger.

## Endpoints

### `GET /v1/hooks/semesters`

- Operation ID: `SemesterHookService_ListSemester`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `status` | query | False | `boolean` |  |
| `school_year_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookListSemesterResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/hooks/semesters`

- Operation ID: `SemesterHookService_CreateSemester`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `webhookCreateSemesterRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookCreateSemesterResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/hooks/semesters/{id}`

- Operation ID: `SemesterHookService_DeleteSemester`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookDeleteSemesterResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/hooks/semesters/{id}`

- Operation ID: `SemesterHookService_GetSemester`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookGetSemesterResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/hooks/semesters/{id}`

- Operation ID: `SemesterHookService_UpdateSemester`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `SemesterHookServiceUpdateSemesterBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookUpdateSemesterResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

