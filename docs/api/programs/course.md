# Course API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `CourseService`
Operation count: 11

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `CourseService` trong Swagger.

## Endpoints

### `GET /v1/courses`

- Operation ID: `CourseService_List`

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
| `200` | A successful response. | `courseListCourseResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/courses`

- Operation ID: `CourseService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `courseCreateCourseRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseCreateCourseResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/courses/{id}`

- Operation ID: `CourseService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseDeleteCourseResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/courses/{id}`

- Operation ID: `CourseService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseGetCourseResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/courses/{id}`

- Operation ID: `CourseService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `courseCourseServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseUpdateCourseResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/courses/{id}/score`

- Operation ID: `CourseService_GetScore`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseGetCourseScoreResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/courses/{id}/users`

- Operation ID: `CourseService_ListUser`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` | Cannot be optional - used in path parameter |
| `role_id` | query | False | `integer` |  |
| `sort_id` | query | False | `string` |  |
| `sort_created_at` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseListUserCourseResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/courses/{id}/users`

- Operation ID: `CourseService_UpdateUser`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `courseCourseServiceUpdateUserBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseUpdateUserCourseResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/courses/{id}/users`

- Operation ID: `CourseService_AddUser`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `courseCourseServiceAddUserBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseAddUserCourseResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/courses/resync-schedules`

- Operation ID: `CourseService_ResyncSchedule`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `courseResyncScheduleRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseResyncScheduleResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/courses/sort`

- Operation ID: `CourseService_Sort`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `courseSortCourseRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseSortCourseResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

