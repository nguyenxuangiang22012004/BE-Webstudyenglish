# Dashboard API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `DashboardService`
Operation count: 17

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `DashboardService` trong Swagger.

## Endpoints

### `GET /v1/dashboard`

- Operation ID: `DashboardService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `user_id` | query | False | `string` |  |
| `role` | query | False | `string` |  |
| `tab` | query | False | `string` |  |
| `program_id` | query | False | `string` |  |
| `course_id` | query | False | `string` |  |
| `school_id` | query | False | `string` |  |
| `class_id` | query | False | `string` |  |
| `teacher_id` | query | False | `string` |  |
| `role_id` | query | False | `string` |  |
| `object_type` | query | False | `string` |  |
| `province_code` | query | False | `string` |  |
| `ward_code` | query | False | `string` |  |
| `year` | query | False | `integer` |  |
| `quarter` | query | False | `integer` |  |
| `month` | query | False | `integer` |  |
| `time_type` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetDashboardResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/active-users`

- Operation ID: `DashboardService_GetActiveUser`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `minutes` | query | False | `integer` |  |
| `start_time` | query | False | `string` |  |
| `end_time` | query | False | `string` |  |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |
| `school_id` | query | False | `string` |  |
| `course_id` | query | False | `string` |  |
| `program_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetActiveUsersResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/chapter-list`

- Operation ID: `DashboardService_GetChapterList`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `course_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetChapterListResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/class-list`

- Operation ID: `DashboardService_GetClassList`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `school_id` | query | False | `string` |  |
| `class_main_id` | query | False | `string` |  |
| `sort[string]` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetClassListResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/class-main-list`

- Operation ID: `DashboardService_GetClassMainList`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `school_id` | query | False | `string` |  |
| `sort[string]` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetClassMainListResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/course-list`

- Operation ID: `DashboardService_GetCourseList`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `sort[string]` | query | False | `string` |  |
| `school_id` | query | False | `string` |  |
| `program_id` | query | False | `string` |  |
| `subject_id` | query | False | `string` |  |
| `parent_course_id` | query | False | `string` |  |
| `assessment_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetCourseListResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/exam/ranking`

- Operation ID: `DashboardService_GetExamRanking`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | query | False | `string` |  |
| `lesson_id` | query | False | `string` |  |
| `exam_id` | query | False | `string` |  |
| `start_date` | query | False | `string` |  |
| `end_date` | query | False | `string` |  |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |
| `order_by` | query | False | `string` | asc | desc |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetExamRankingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/failed-logins`

- Operation ID: `DashboardService_GetFailedLogin`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `minutes` | query | False | `integer` |  |
| `start_time` | query | False | `string` |  |
| `end_time` | query | False | `string` |  |
| `user_id` | query | False | `string` |  |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetFailedLoginResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/failed-logins-count`

- Operation ID: `DashboardService_GetFailedLoginCount`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `minutes` | query | False | `integer` |  |
| `start_time` | query | False | `string` |  |
| `end_time` | query | False | `string` |  |
| `user_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetFailedLoginCountResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/homework-list`

- Operation ID: `DashboardService_GetHomeworkList`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `sort[string]` | query | False | `string` | sort[field] = asc|desc |
| `course_id` | query | False | `string` |  |
| `subject_id` | query | False | `string` |  |
| `chapter_id` | query | False | `string` |  |
| `lesson_id` | query | False | `string` |  |
| `lesson_ids` | query | False | `string` | Danh sách lesson_id cách nhau bởi dấu phẩy (ví dụ: "1,2,3") |
| `homework_ids` | query | False | `string` | Danh sách homework_id cách nhau bởi dấu phẩy (ví dụ: "1,2,3") |
| `is_assigned` | query | False | `boolean` | Optional bool (tương đương *bool trong Go) |
| `start_date` | query | False | `string` | Format: YYYY-MM-DD hoặc Unix timestamp |
| `end_date` | query | False | `string` | Format: YYYY-MM-DD hoặc Unix timestamp |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetHomeworkListResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/lesson-list`

- Operation ID: `DashboardService_GetLessonList`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `course_id` | query | False | `string` |  |
| `chapter_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetLessonListResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/program-list`

- Operation ID: `DashboardService_GetProgramList`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `school_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetProgramListResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/ranking/assessment`

- Operation ID: `DashboardService_GetAssessmentRanking`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `assessment_id` | query | False | `string` |  |
| `course_id` | query | False | `string` |  |
| `order_by` | query | False | `string` | "score" hoặc "star" |
| `sort` | query | False | `string` | "asc" hoặc "desc" (mặc định "desc") |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetAssessmentRankingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/ranking/homework`

- Operation ID: `DashboardService_GetHomeworkRanking`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | query | False | `string` |  |
| `order_by` | query | False | `string` | "star" hoặc "exp" |
| `sort` | query | False | `string` | "asc" hoặc "desc" (mặc định là "desc") |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetHomeworkRankingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/school-list`

- Operation ID: `DashboardService_GetSchoolList`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetSchoolListResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/subject-list`

- Operation ID: `DashboardService_GetSubjectList`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetSubjectListResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/teacher-list`

- Operation ID: `DashboardService_GetTeacherList`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `course_id` | query | False | `string` |  |
| `school_id` | query | False | `string` |  |
| `program_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetTeacherListResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

