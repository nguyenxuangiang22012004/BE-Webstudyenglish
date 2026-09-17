# SubjectHook API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `SubjectHookService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `SubjectHookService` trong Swagger.

## Endpoints

### `GET /v1/hooks/subjects`

- Operation ID: `SubjectHookService_ListSubject`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `status` | query | False | `boolean` |  |
| `sort_id` | query | False | `string` |  |
| `sort_created_at` | query | False | `string` |  |
| `faculty_id` | query | False | `string` |  |
| `school_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookListSubjectResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/hooks/subjects`

- Operation ID: `SubjectHookService_CreateSubject`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `webhookCreateSubjectRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookCreateSubjectResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/hooks/subjects/{id}`

- Operation ID: `SubjectHookService_DeleteSubject`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookDeleteSubjectResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/hooks/subjects/{id}`

- Operation ID: `SubjectHookService_GetSubject`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookGetSubjectResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/hooks/subjects/{id}`

- Operation ID: `SubjectHookService_UpdateSubject`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `SubjectHookServiceUpdateSubjectBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookUpdateSubjectResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

