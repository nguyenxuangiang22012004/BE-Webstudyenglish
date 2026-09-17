# UserHook API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `UserHookService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `UserHookService` trong Swagger.

## Endpoints

### `GET /v1/hooks/users`

- Operation ID: `UserHookService_UserList`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `course_id` | query | False | `string` |  |
| `class_id` | query | False | `string` |  |
| `ward_code` | query | False | `string` |  |
| `province_code` | query | False | `string` |  |
| `role_id` | query | False | `string` |  |
| `is_used` | query | False | `boolean` |  |
| `school_id` | query | False | `string` |  |
| `parent_id` | query | False | `string` |  |
| `begin_at` | query | False | `string` |  |
| `end_at` | query | False | `string` |  |
| `created_at` | query | False | `string` |  |
| `sort_id` | query | False | `string` |  |
| `sort_created_at` | query | False | `string` |  |
| `status` | query | False | `boolean` |  |
| `program_id` | query | False | `string` |  |
| `faculty_id` | query | False | `string` |  |
| `subject_id` | query | False | `string` |  |
| `fail_the_subject` | query | False | `boolean` |  |
| `not_participated` | query | False | `boolean` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookListUserResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/hooks/users/{source_id}`

- Operation ID: `UserHookService_UserGet`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `source_id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookUserHookGetResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/hooks/users/created`

- Operation ID: `UserHookService_UserCreate`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `webhookUserHookCreateRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookUserHookCreateResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/hooks/users/deleted/{source_id}`

- Operation ID: `UserHookService_UserDelete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `source_id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookUserHookDeleteResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/hooks/users/updated/{source_id}`

- Operation ID: `UserHookService_UserUpdate`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `source_id` | path | True | `string` |  |
| `body` | body | True | `UserHookServiceUserUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookUserHookUpdateResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

