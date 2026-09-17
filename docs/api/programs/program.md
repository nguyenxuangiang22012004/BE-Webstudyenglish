# Program API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `ProgramService`
Operation count: 7

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `ProgramService` trong Swagger.

## Endpoints

### `GET /v1/programs`

- Operation ID: `ProgramService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `status` | query | False | `boolean` |  |
| `subject_id` | query | False | `string` |  |
| `school_id` | query | False | `string` |  |
| `faculty_id` | query | False | `string` |  |
| `grade_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseListProgramResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/programs`

- Operation ID: `ProgramService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `courseCreateProgramRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseCreateProgramResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/programs/{id}`

- Operation ID: `ProgramService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseDeleteProgramResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/programs/{id}`

- Operation ID: `ProgramService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseGetProgramResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/programs/{id}`

- Operation ID: `ProgramService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `courseProgramServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseUpdateProgramResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/programs/{id}/cloned`

- Operation ID: `ProgramService_Cloned`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `courseProgramServiceClonedBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseClonedProgramResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/programs/{id}/sort-chapters`

- Operation ID: `ProgramService_SortChapter`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `ProgramServiceSortChapterBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseSortChapterResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

