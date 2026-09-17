# SchoolHook API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `SchoolHookService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `SchoolHookService` trong Swagger.

## Endpoints

### `GET /v1/hooks/schools`

- Operation ID: `SchoolHookService_ListSchool`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `type` | query | False | `string` |  |
| `status` | query | False | `boolean` |  |
| `province_code` | query | False | `string` |  |
| `ward_code` | query | False | `string` |  |
| `sort_id` | query | False | `string` |  |
| `sort_created_at` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookListSchoolResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/hooks/schools`

- Operation ID: `SchoolHookService_CreateSchool`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `webhookCreateSchoolRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookCreateSchoolResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/hooks/schools/{id}`

- Operation ID: `SchoolHookService_DeleteSchool`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookDeleteSchoolResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/hooks/schools/{id}`

- Operation ID: `SchoolHookService_GetSchool`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookGetSchoolResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/hooks/schools/{id}`

- Operation ID: `SchoolHookService_UpdateSchool`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `SchoolHookServiceUpdateSchoolBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookUpdateSchoolResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

