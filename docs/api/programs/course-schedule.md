# CourseSchedule API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `CourseScheduleService`
Operation count: 3

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `CourseScheduleService` trong Swagger.

## Endpoints

### `POST /v1/course-schedule/assign-parent`

- Operation ID: `CourseScheduleService_AssignParent`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `courseAssignParentRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseAssignParentResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/course-schedule/family`

- Operation ID: `CourseScheduleService_GetCourseFamily`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseGetCourseFamilyResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/list-courses-family`

- Operation ID: `CourseScheduleService_ListCoursesFamily`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `program_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseListCoursesFamilyResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

