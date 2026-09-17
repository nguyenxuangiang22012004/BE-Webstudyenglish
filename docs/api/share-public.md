# Share Public API

Status: code-observed
Owner: DEV/TEST
Last reviewed: 2026-09-12
Source:
  - src/api/share-public.ts
Related:
  - docs/requirements/public-share.md

## Purpose

Frontend wrapper for public share endpoints. These calls use a public axios instance instead of the authenticated `apiHelper`.

## Endpoints used by frontend

### `GET /share/profile`

Query:

| Name | Required | Notes |
| --- | --- | --- |
| `key` | Yes | Public share key. |

Returns user profile data shaped like `UserRes`.

### `GET /share/schools/{schoolId}`

Path:

| Name | Required | Notes |
| --- | --- | --- |
| `schoolId` | Yes | School identifier. |

Query:

| Name | Required | Notes |
| --- | --- | --- |
| `key` | Yes | Public share key. |

Returns school detail shaped like `SchoolItem`.

### `GET /share/study-reports/{id}`

Path:

| Name | Required | Notes |
| --- | --- | --- |
| `id` | Yes | Study report identifier. |

Query:

| Name | Required | Notes |
| --- | --- | --- |
| `key` | Yes | Public share key. |

Returns study report detail shaped like `StudyReportResponseData`.

### `GET /share/dashboard/student/assessments`

Query:

| Name | Required | Notes |
| --- | --- | --- |
| `key` | Yes | Public share key. |
| dashboard filters | No | Same parameter shape as `DashboardStudentAssessmentParams`. |

Returns student assessment dashboard list shaped like `DashboardStudentAssessmentListResponseData`.

## Implementation notes

- Base URL and timeout come from `API_CONFIG`.
- Default content type is JSON.
- These endpoints should be tested with invalid, expired, and missing share keys.

