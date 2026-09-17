# InternalComment API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `InternalCommentService`
Operation count: 6

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `InternalCommentService` trong Swagger.

## Endpoints

### `POST /v1/internal/{job_name}`

- Summary: Run một job nội bộ theo tên.
- Operation ID: `InternalCommentService_RunJob`
- Description: Endpoint: POST /v1/internal/{job_name} Ví dụ các job có sẵn: - school-statistics-generate: Tạo thống kê theo trường cho khoảng thời gian cụ thể - school-statistics-last-week: Tạo thống kê theo trường cho tuần trước - course-statistics-generate: Tạo thống kê theo khóa học cho khoảng thời gian cụ thể - course-statistics-last-week: Tạo thống kê theo khóa học cho tuần trước - daily-school-statistics: Chạy Daily School Statistics Job (4 khoảng thời gian) - daily-course-statistics: Chạy Daily Course Statistics Job (4 khoảng thời gian) - daily-all-statistic-courses: Chạy tất cả Daily Course Statistics Jobs - daily-all-statistic-schools: Chạy tất cả Daily School Statistics Jobs - clear-dashboard-schools-data: Xóa tất cả dữ liệu trong bảng dashboard_report_schools - clear-dashboard-courses-data: Xóa tất cả dữ liệu trong bảng dashboard_report_courses - sync-homework-user-questions: Đồng bộ homework_user_questions từ các bảng homework_question_user_* - recalculate-homework-users-metrics: Tính lại metrics cho homework_users - sync-class-main: Đồng bộ classes_main từ classes - sync-assessment-ref-lesson: Đồng bộ assessment_ref_lessons - sync-teacher-classes: Đồng bộ user_classes cho giáo viên từ user_courses Body (JSON): tuỳ job, có thể là: - {} (empty) cho các job không cần tham số - {"start_date": "2025-01-01", "end_date": "2025-01-31"} cho các job cần khoảng thời gian - {"only_homework_zero_score": true} cho các job có option filter

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `job_name` | path | True | `string` | Tên logic của job (lấy từ path /v1/internal/{job_name}). Xem danh sách đầy đủ bằng cách gọi ListJobs API. Ví dụ: "school-statistics-generate", "daily-course-statistics", "sync-homework-user-questions" |
| `body` | body | True | `InternalCommentServiceRunJobBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonRunJobResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/internal/executions`

- Summary: Liệt kê các job execution (đang chạy, đã chạy xong, hoặc theo job_name). Endpoint: GET /v1/internal/executions?status=running&job_name=xxx&limit=50
- Operation ID: `InternalCommentService_ListJobExecutions`
- Description: Query params: - status: "running" (đang chạy), "queued" (đang chờ), "all" (tất cả, mặc định) - job_name: filter theo tên job cụ thể (optional) - limit: số lượng kết quả tối đa (mặc định 50)

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `status` | query | False | `string` | Filter theo status: "running" (đang chạy), "queued" (đang chờ), "all" (tất cả, mặc định) |
| `job_name` | query | False | `string` | Filter theo job_name (optional) |
| `limit` | query | False | `integer` | Số lượng kết quả tối đa (mặc định 50) |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonListJobExecutionsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/internal/executions/summary`

- Summary: Lấy tổng quan tiến độ các job trong hệ thống (số lượng queued, running, danh sách đang chạy, v.v.). Endpoint: GET /v1/internal/executions/summary
- Operation ID: `InternalCommentService_GetJobExecutionsSummary`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `` |  |  | `` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonGetJobExecutionsSummaryResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/internal/jobs`

- Summary: Liệt kê tất cả các job có sẵn và có thể chạy. Endpoint: GET /v1/internal/jobs
- Operation ID: `InternalCommentService_ListJobs`
- Description: Response chứa danh sách các job với tên và mô tả chi tiết. Dùng API này để biết các job_name hợp lệ khi gọi RunJob.

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `` |  |  | `` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonListJobsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/internal/jobs/{job_id}`

- Summary: Lấy trạng thái một job đã được dispatch. Endpoint: GET /v1/internal/jobs/{job_id}
- Operation ID: `InternalCommentService_GetJobStatus`
- Description: Hiện tại chức năng này đang được implement, sẽ lấy trạng thái từ Redis/DB.

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `job_id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonGetJobStatusResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/internal/jobs/{job_id}/stop`

- Summary: Dừng một job (cập nhật DB + hủy trong queue nếu đang chạy). Endpoint: POST /v1/internal/jobs/{job_id}/stop
- Operation ID: `InternalCommentService_StopJob`
- Description: Lưu ý: Cần gọi schedule-svc trực tiếp (POST /internal/stop-job) hoặc cấu hình SCHEDULE_INTERNAL_URL để dừng job đang chạy.

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `job_id` | path | True | `string` |  |
| `body` | body | True | `InternalCommentServiceStopJobBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonStopJobResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

