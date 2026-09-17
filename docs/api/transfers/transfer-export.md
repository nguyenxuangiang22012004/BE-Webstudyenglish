# TransferExport API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `TransferExportService`
Operation count: 25

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `TransferExportService` trong Swagger.

## Endpoints

### `GET /v1/transfer/assessment/data-report-excel`

- Operation ID: `TransferExportService_AssessmentDataReportExcel`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `assessment_type` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferAssessmentDataReportExcelResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/transfer/assessment/report-excel`

- Operation ID: `TransferExportService_AssessmentReportExcel`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `transferAssessmentReportExcelRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferAssessmentReportExcelResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/transfer/assessment/report-excel-all`

- Operation ID: `TransferExportService_AssessmentReportExcelAll`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `transferAssessmentReportExcelAllRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferAssessmentReportExcelAllResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/transfer/assessments/export-excel`

- Summary: Assessment export excel
- Operation ID: `TransferExportService_AssessmentExportExcel`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_ids` | query | False | `string` |  |
| `assessment_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferAssessmentExportExcelResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/transfer/classes/export`

- Summary: Class export
- Operation ID: `TransferExportService_ExportClasses`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `keyword` | query | False | `string` |  |
| `school_id` | query | False | `string` |  |
| `status` | query | False | `boolean` |  |
| `sort` | query | False | `array` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferExportClassesResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/transfer/courses/export`

- Summary: Course export
- Operation ID: `TransferExportService_ExportCourse`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferExportCourseResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/transfer/dashboard/export`

- Summary: Dashboard export
- Operation ID: `TransferExportService_ExportDashboard`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `time_type` | query | False | `string` | "month", "week", "day", "24h" |
| `school_id` | query | False | `string` |  |
| `program_id` | query | False | `string` |  |
| `course_id` | query | False | `string` |  |
| `province_code` | query | False | `string` |  |
| `ward_code` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferExportDashboardResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/transfer/dashboard/report/courses/export`

- Summary: Dashboard report course export
- Operation ID: `TransferExportService_ExportDashboardReportCourse`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `school_id` | query | False | `string` |  |
| `teacher_id` | query | False | `string` |  |
| `course_id` | query | False | `string` |  |
| `start_date` | query | False | `string` |  |
| `end_date` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferExportDashboardReportCourseResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/transfer/dashboard/report/schools/export`

- Summary: Dashboard report school export
- Operation ID: `TransferExportService_ExportDashboardReportSchool`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `end_date` | query | False | `string` |  |
| `start_date` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferExportDashboardReportSchoolResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/transfer/export/jobs`

- Summary: List all export jobs
- Operation ID: `TransferExportService_ListExportJobs`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `status` | query | False | `string` | Optional: filter by status (pending, running, completed, failed) |
| `limit` | query | False | `integer` | Optional: limit number of results (default: 100) |
| `offset` | query | False | `integer` | Optional: offset for pagination (default: 0) |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferListExportJobsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/transfer/export/progress/{job_id}`

- Summary: Get export progress
- Operation ID: `TransferExportService_GetExportProgress`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `job_id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferGetExportProgressResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/transfer/export/progress/{job_id}/event`

- Summary: Get export progress event
- Operation ID: `TransferExportService_GetExportProgressEvent`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `job_id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferGetExportProgressEventResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/transfer/faculties/export`

- Summary: Faculty export
- Operation ID: `TransferExportService_ExportFaculties`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `keyword` | query | False | `string` |  |
| `status` | query | False | `boolean` |  |
| `sort` | query | False | `array` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferExportFacultiesResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/transfer/google-cloud/text-to-speech/export`

- Summary: Export google text to speech
- Operation ID: `TransferExportService_ExportGoogleTextToSpeech`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `keyword` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferExportGoogleTextToSpeechResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/transfer/homeworks/export-results`

- Summary: Export homework results
- Operation ID: `TransferExportService_ExportHomeworkResult`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `transferExportHomeworkResultRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferExportHomeworkResultResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/transfer/programs/export`

- Summary: Program export
- Operation ID: `TransferExportService_ExportPrograms`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `program_id` | query | False | `string` | Required: export specific program |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferExportProgramsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/transfer/questions/export`

- Summary: Question export
- Operation ID: `TransferExportService_ExportQuestions`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `keyword` | query | False | `string` |  |
| `question_type` | query | False | `string` |  |
| `status` | query | False | `boolean` |  |
| `sort` | query | False | `array` |  |
| `program_ids` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferExportQuestionsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/transfer/schools/export`

- Summary: School export
- Operation ID: `TransferExportService_ExportSchools`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `keyword` | query | False | `string` |  |
| `type` | query | False | `string` |  |
| `status` | query | False | `boolean` |  |
| `sort` | query | False | `array` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferExportSchoolsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/transfer/students/export`

- Summary: Export students by classes/courses
- Operation ID: `TransferExportService_ExportStudents`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `transferExportStudentsRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferExportStudentsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/transfer/subjects/export`

- Summary: Subject export
- Operation ID: `TransferExportService_ExportSubjects`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `keyword` | query | False | `string` |  |
| `faculty_id` | query | False | `string` |  |
| `status` | query | False | `boolean` |  |
| `sort` | query | False | `array` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferExportSubjectsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/transfer/teacher/homework/{homework_id}/export`

- Summary: Dashboard export teacher homework student
- Operation ID: `TransferExportService_ExportTeacherHomeworkStudent`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `homework_id` | path | True | `string` |  |
| `course_id` | query | False | `string` |  |
| `lesson_id` | query | False | `string` |  |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |
| `sort[string]` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferExportTeacherHomeworkStudentResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/transfer/teacher/homework/export`

- Summary: Dashboard export teacher homework stats
- Operation ID: `TransferExportService_ExportTeacherHomeworkStats`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | query | False | `string` |  |
| `chapter_id` | query | False | `string` |  |
| `lesson_id` | query | False | `string` |  |
| `lesson_ids` | query | False | `string` |  |
| `homework_ids` | query | False | `string` |  |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |
| `sort[string]` | query | False | `string` |  |
| `order_by` | query | False | `string` |  |
| `start_date` | query | False | `string` | YYYY-MM-DD hoặc unix |
| `end_date` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferExportTeacherHomeworkStatsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/transfer/users/export`

- Summary: User export
- Operation ID: `TransferExportService_ExportUsers`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `keyword` | query | False | `string` |  |
| `school_id` | query | False | `string` |  |
| `role_id` | query | False | `string` |  |
| `status` | query | False | `boolean` |  |
| `sort` | query | False | `array` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferExportUsersResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/transfer/users/export-pdf`

- Summary: Export users PDF
- Operation ID: `TransferExportService_ExportUsersPDF`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `school_id` | query | False | `string` |  |
| `class_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferExportUsersPDFResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/transfer/vocabularies/export`

- Summary: Vocabulary export
- Operation ID: `TransferExportService_ExportVocabulary`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `lesson_id` | query | False | `string` |  |
| `program_id` | query | False | `string` |  |
| `chapter_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferExportVocabularyResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

