# User API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `UserService`
Operation count: 6

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `UserService` trong Swagger.

## Endpoints

### `GET /v1/users`

- Operation ID: `UserService_List`

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
| `200` | A successful response. | `userListUserResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/users`

- Operation ID: `UserService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `userCreateUserRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userCreateUserResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/users/{id}`

- Operation ID: `UserService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userDeleteUserResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/users/{id}`

- Operation ID: `UserService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userGetUserResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/users/{id}`

- Operation ID: `UserService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `userUserServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userUpdateUserResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/users/{id}/reset-password`

- Operation ID: `UserService_ResetPassword`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userResetPasswordUserResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

