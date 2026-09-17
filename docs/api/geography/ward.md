# Ward API

Status: code-observed
Owner: DEV/TEST
Last reviewed: 2026-09-12
Source:
  - src/api/wards.ts
Related:
  - docs/api/geography/province.md
  - docs/requirements/schools/school.md
  - docs/requirements/users/user.md

## Purpose

Frontend wrapper for loading wards by province code. Used by school and user address forms.

## Endpoint used by frontend

### `GET /provinces/{provinceCode}/wards`

Path:

| Name | Required | Notes |
| --- | --- | --- |
| `provinceCode` | Yes | Province code selected in address form. |

Response shape:

| Field | Notes |
| --- | --- |
| `wards` | List of ward records. |
| `total_count` | Total count returned as string in frontend type. |

Ward fields:

| Field | Notes |
| --- | --- |
| `code` | Ward code. |
| `province_code` | Parent province code. |
| `name` | Short ward name. |
| `full_name` | Full ward name. |

