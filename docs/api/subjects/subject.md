# Subject API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `SubjectService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `SubjectService` trong Swagger.

## Endpoints

### `GET /v1/subjects`

- Operation ID: `SubjectService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `status` | query | False | `boolean` |  |
| `sort_id` | query | False | `string` |  |
| `sort_created_at` | query | False | `string` |  |
| `faculty_id` | query | False | `string` |  |
| `school_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseListSubjectResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/subjects`

- Operation ID: `SubjectService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `courseCreateSubjectRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseCreateSubjectResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/subjects/{id}`

- Operation ID: `SubjectService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseDeleteSubjectResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/subjects/{id}`

- Operation ID: `SubjectService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseGetSubjectResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/subjects/{id}`

- Operation ID: `SubjectService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `courseSubjectServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseUpdateSubjectResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

