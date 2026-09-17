# Class API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `ClassService`
Operation count: 12

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `ClassService` trong Swagger.

## Endpoints

### `GET /v1/classes`

- Operation ID: `ClassService_List`

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
| `200` | A successful response. | `userListClassResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/classes`

- Operation ID: `ClassService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `userCreateClassRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userCreateClassResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/classes/{class_id}/user-relation`

- Operation ID: `ClassService_ClassUserRelation`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `class_id` | path | True | `string` |  |
| `body` | body | True | `ClassServiceClassUserRelationBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userClassUserRelationResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/classes/{id}`

- Operation ID: `ClassService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userDeleteClassResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/classes/{id}`

- Operation ID: `ClassService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userGetClassResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/classes/{id}`

- Operation ID: `ClassService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `userClassServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userUpdateClassResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/classes/{id}/users`

- Operation ID: `ClassService_ListUser`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `role_id` | query | False | `string` |  |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userClassListUserResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/classes/{id}/users`

- Operation ID: `ClassService_UpdateUser`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `userClassServiceUpdateUserBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userClassUpdateUserResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/classes/{id}/users`

- Operation ID: `ClassService_AddUser`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `userClassServiceAddUserBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userClassAddUserResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/classes/add-teachers`

- Operation ID: `ClassService_AddTeachers`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `userClassAddTeachersRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userClassAddTeachersResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/classes/histories`

- Operation ID: `ClassService_Histories`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |
| `role_id` | query | False | `string` |  |
| `name` | query | False | `string` |  |
| `user_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userClassHistoriesResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/classes/remove-teachers`

- Operation ID: `ClassService_RemoveTeachers`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `userClassRemoveTeachersRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userClassRemoveTeachersResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

