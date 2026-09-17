# WeekHook API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `WeekHookService`
Operation count: 2

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `WeekHookService` trong Swagger.

## Endpoints

### `GET /v1/hooks/weeks`

- Operation ID: `WeekHookService_ListWeek`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | query | False | `string` |  |
| `semester_id` | query | False | `string` |  |
| `begin_at` | query | False | `string` |  |
| `end_at` | query | False | `string` |  |
| `school_year_id` | query | False | `string` |  |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookListWeekResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/hooks/weeks/by-date`

- Operation ID: `WeekHookService_GetWeekByDate`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `date` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookGetWeekByDateResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

