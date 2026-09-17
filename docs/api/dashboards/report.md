# Report API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `ReportService`
Operation count: 6

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `ReportService` trong Swagger.

## Endpoints

### `GET /v1/dashboard/assessment/report`

- Operation ID: `ReportService_GetAssessmentReport`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `class_id` | query | False | `string` | Required if class_main_id == 0 |
| `class_main_id` | query | False | `string` | If > 0, ignore class_id |
| `assessment_id` | query | False | `string` | required |
| `student_id` | query | False | `array` | optional filter |
| `get_score` | query | False | `boolean` | include score details |
| `get_study_report_criteria` | query | False | `boolean` | include study report |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetAssessmentReportResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/report`

- Operation ID: `ReportService_GetDashboardReport`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `active_student_time` | query | False | `string` | Unix timestamp để lọc học sinh hoạt động (mặc định: 15/9/2025) |
| `active_teacher_time` | query | False | `string` | Unix timestamp để lọc giáo viên hoạt động (mặc định: 8/9/2025) |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetDashboardReportResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/report/courses`

- Operation ID: `ReportService_GetDashboardReportCourses`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `school_id` | query | False | `string` | optional filter by school_id |
| `teacher_id` | query | False | `string` | optional filter by teacher_id (checks in teacher_ids column) |
| `course_id` | query | False | `string` | optional filter by course_id |
| `search` | query | False | `string` | optional search by course_name or school_name |
| `page` | query | False | `integer` | page number (default: 1) |
| `limit` | query | False | `integer` | items per page (default: 10) |
| `start_date` | query | False | `string` | start date (format: YYYY-MM-DD) |
| `end_date` | query | False | `string` | end date (format: YYYY-MM-DD) |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetDashboardReportCoursesResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/report/courses/homeworks`

- Operation ID: `ReportService_GetDashboardReportCourseHomeworks`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | query | False | `string` |  |
| `start_date` | query | False | `string` |  |
| `end_date` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetDashboardReportCourseHomeworksResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/report/courses/students`

- Operation ID: `ReportService_GetDashboardReportCourseStudents`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | query | False | `string` |  |
| `start_date` | query | False | `string` | Format: YYYY-MM-DD |
| `end_date` | query | False | `string` | Format: YYYY-MM-DD |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetDashboardReportCourseStudentsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/dashboard/report/schools`

- Operation ID: `ReportService_GetDashboardReportSchools`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `search` | query | False | `string` |  |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `start_date` | query | False | `string` |  |
| `end_date` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `analyticsGetDashboardReportSchoolsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

