# ProgramHook API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `ProgramHookService`
Operation count: 6

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `ProgramHookService` trong Swagger.

## Endpoints

### `GET /v1/hooks/programs`

- Operation ID: `ProgramHookService_ListProgram`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `status` | query | False | `boolean` |  |
| `subject_id` | query | False | `string` |  |
| `school_id` | query | False | `string` |  |
| `faculty_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookListProgramResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/hooks/programs`

- Operation ID: `ProgramHookService_CreateProgram`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `webhookCreateProgramRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookCreateProgramResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/hooks/programs/{id}`

- Operation ID: `ProgramHookService_DeleteProgram`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookDeleteProgramResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/hooks/programs/{id}`

- Operation ID: `ProgramHookService_GetProgram`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookGetProgramResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/hooks/programs/{id}`

- Operation ID: `ProgramHookService_UpdateProgram`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `ProgramHookServiceUpdateProgramBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookUpdateProgramResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/hooks/programs/{id}/sort-chapters`

- Operation ID: `ProgramHookService_ProgramSortChapter`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `ProgramHookServiceProgramSortChapterBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookSortChapterResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

