# SchoolYear API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `SchoolYearService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `SchoolYearService` trong Swagger.

## Endpoints

### `GET /v1/school-years`

- Operation ID: `SchoolYearService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonListSchoolYearResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/school-years`

- Operation ID: `SchoolYearService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `commonCreateSchoolYearRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonCreateSchoolYearResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/school-years/{id}`

- Operation ID: `SchoolYearService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonDeleteSchoolYearResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/school-years/{id}`

- Operation ID: `SchoolYearService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonGetSchoolYearResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/school-years/{id}`

- Operation ID: `SchoolYearService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `commonSchoolYearServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonUpdateSchoolYearResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

