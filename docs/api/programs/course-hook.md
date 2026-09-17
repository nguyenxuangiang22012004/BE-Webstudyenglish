# CourseHook API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `CourseHookService`
Operation count: 8

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `CourseHookService` trong Swagger.

## Endpoints

### `GET /v1/hooks/courses`

- Operation ID: `CourseHookService_ListCourse`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `status` | query | False | `boolean` |  |
| `description` | query | False | `string` |  |
| `program_id` | query | False | `string` |  |
| `state` | query | False | `string` |  |
| `school_id` | query | False | `string` |  |
| `by_user` | query | False | `boolean` |  |
| `parent_id` | query | False | `string` |  |
| `subject_id` | query | False | `string` |  |
| `sort_id` | query | False | `string` |  |
| `sort_created_at` | query | False | `string` |  |
| `school_year_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookListCourseResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/hooks/courses`

- Operation ID: `CourseHookService_CreateCourse`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `webhookCreateCourseRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookCreateCourseResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/hooks/courses/{id}`

- Operation ID: `CourseHookService_DeleteCourse`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookDeleteCourseResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/hooks/courses/{id}`

- Operation ID: `CourseHookService_GetCourse`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookGetCourseResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/hooks/courses/{id}`

- Operation ID: `CourseHookService_UpdateCourse`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `CourseHookServiceUpdateCourseBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookUpdateCourseResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/hooks/courses/{id}/users`

- Operation ID: `CourseHookService_ListUserCourse`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `role_id` | query | False | `integer` |  |
| `sort_id` | query | False | `string` |  |
| `sort_created_at` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookListUserCourseResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/hooks/courses/{id}/users`

- Operation ID: `CourseHookService_UpdateUserCourse`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `CourseHookServiceUpdateUserCourseBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookUpdateUserCourseResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1hooks/courses/{id}/users`

- Operation ID: `CourseHookService_AddUserCourse`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `CourseHookServiceAddUserCourseBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookAddUserCourseResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

