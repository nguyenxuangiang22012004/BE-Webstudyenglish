# Semester API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `SemesterService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `SemesterService` trong Swagger.

## Endpoints

### `GET /v1/semesters`

- Operation ID: `SemesterService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `status` | query | False | `boolean` |  |
| `school_year_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonListSemesterResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/semesters`

- Operation ID: `SemesterService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `commonCreateSemesterRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonCreateSemesterResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/semesters/{id}`

- Operation ID: `SemesterService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonDeleteSemesterResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/semesters/{id}`

- Operation ID: `SemesterService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonGetSemesterResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/semesters/{id}`

- Operation ID: `SemesterService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `commonSemesterServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonUpdateSemesterResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

