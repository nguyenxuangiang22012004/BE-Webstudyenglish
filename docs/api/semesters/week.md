# Week API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `WeekService`
Operation count: 2

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `WeekService` trong Swagger.

## Endpoints

### `GET /v1/weeks`

- Operation ID: `WeekService_List`

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
| `200` | A successful response. | `commonListWeekResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/weeks/by-date`

- Operation ID: `WeekService_GetByDate`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `date` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonGetWeekByDateResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

