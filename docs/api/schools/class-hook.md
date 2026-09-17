# ClassHook API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `ClassHookService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `ClassHookService` trong Swagger.

## Endpoints

### `GET /v1/hooks/classes`

- Operation ID: `ClassHookService_ListClass`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `school_id` | query | False | `string` |  |
| `grade_id` | query | False | `string` |  |
| `faculty_id` | query | False | `string` |  |
| `status` | query | False | `boolean` |  |
| `sort_id` | query | False | `string` |  |
| `sort_created_at` | query | False | `string` |  |
| `school_year_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookListClassResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/hooks/classes`

- Operation ID: `ClassHookService_CreateClass`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `webhookCreateClassRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookCreateClassResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/hooks/classes/{id}`

- Operation ID: `ClassHookService_DeleteClass`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookDeleteClassResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/hooks/classes/{id}`

- Operation ID: `ClassHookService_GetClass`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookGetClassResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/hooks/classes/{id}`

- Operation ID: `ClassHookService_UpdateClass`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `ClassHookServiceUpdateClassBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookUpdateClassResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

