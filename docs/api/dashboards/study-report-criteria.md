# StudyReportCriteria API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `StudyReportCriteriaService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `StudyReportCriteriaService` trong Swagger.

## Endpoints

### `GET /v1/study-report-criterias`

- Operation ID: `StudyReportCriteriaService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `status` | query | False | `boolean` |  |
| `type` | query | False | `string` |  |
| `sort_id` | query | False | `string` |  |
| `sort_created_at` | query | False | `string` |  |
| `subject_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentListStudyReportCriteriaResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/study-report-criterias`

- Operation ID: `StudyReportCriteriaService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentCreateStudyReportCriteriaRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentCreateStudyReportCriteriaResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/study-report-criterias/{id}`

- Operation ID: `StudyReportCriteriaService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentDeleteStudyReportCriteriaResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/study-report-criterias/{id}`

- Operation ID: `StudyReportCriteriaService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentGetStudyReportCriteriaResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/study-report-criterias/{id}`

- Operation ID: `StudyReportCriteriaService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `assessmentStudyReportCriteriaServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentUpdateStudyReportCriteriaResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

