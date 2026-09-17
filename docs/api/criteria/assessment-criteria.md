# AssessmentCriteria API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `AssessmentCriteriaService`
Operation count: 6

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `AssessmentCriteriaService` trong Swagger.

## Endpoints

### `GET /v1/assessment-criteria`

- Operation ID: `AssessmentCriteriaService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `subject_id` | query | False | `string` |  |
| `has_subcriteria` | query | False | `boolean` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentListAssessmentCriteriaResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/assessment-criteria`

- Operation ID: `AssessmentCriteriaService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentCreateAssessmentCriteriaRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentCreateAssessmentCriteriaResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/assessment-criteria/{id}`

- Operation ID: `AssessmentCriteriaService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentDeleteAssessmentCriteriaResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/assessment-criteria/{id}`

- Operation ID: `AssessmentCriteriaService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentGetAssessmentCriteriaResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/assessment-criteria/{id}`

- Operation ID: `AssessmentCriteriaService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `assessmentAssessmentCriteriaServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentUpdateAssessmentCriteriaResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/assessment-criteria/bulk`

- Operation ID: `AssessmentCriteriaService_Bulk`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentBulkAssessmentCriteriaRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentBulkAssessmentCriteriaResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

