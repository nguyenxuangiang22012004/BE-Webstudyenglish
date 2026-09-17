# AssessmentSubcriteria API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `AssessmentSubcriteriaService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `AssessmentSubcriteriaService` trong Swagger.

## Endpoints

### `GET /v1/assessment-subcriteria`

- Operation ID: `AssessmentSubcriteriaService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `criterion_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentListAssessmentSubcriteriaResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/assessment-subcriteria`

- Operation ID: `AssessmentSubcriteriaService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentCreateAssessmentSubcriteriaRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentCreateAssessmentSubcriteriaResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/assessment-subcriteria/{id}`

- Operation ID: `AssessmentSubcriteriaService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentDeleteAssessmentSubcriteriaResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/assessment-subcriteria/{id}`

- Operation ID: `AssessmentSubcriteriaService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentGetAssessmentSubcriteriaResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/assessment-subcriteria/{id}`

- Operation ID: `AssessmentSubcriteriaService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `assessmentAssessmentSubcriteriaServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentUpdateAssessmentSubcriteriaResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

