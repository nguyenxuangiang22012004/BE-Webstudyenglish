# AssessmentCriteriaGroup API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `AssessmentCriteriaGroupService`
Operation count: 7

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `AssessmentCriteriaGroupService` trong Swagger.

## Endpoints

### `POST /v1/assessment-criteria-group/with-criteria`

- Operation ID: `AssessmentCriteriaGroupService_CreateWithCriteria`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentCreateAssessmentCriteriaGroupWithCriteriaRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentCreateAssessmentCriteriaGroupWithCriteriaResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/assessment-criteria-group/with-criteria/{id}`

- Operation ID: `AssessmentCriteriaGroupService_UpdateWithCriteria`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `AssessmentCriteriaGroupServiceUpdateWithCriteriaBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentUpdateAssessmentCriteriaGroupWithCriteriaResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/assessment-criteria-groups`

- Operation ID: `AssessmentCriteriaGroupService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `name` | query | False | `string` |  |
| `subject_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentListAssessmentCriteriaGroupResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/assessment-criteria-groups`

- Operation ID: `AssessmentCriteriaGroupService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentCreateAssessmentCriteriaGroupRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentCreateAssessmentCriteriaGroupResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/assessment-criteria-groups/{id}`

- Operation ID: `AssessmentCriteriaGroupService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentDeleteAssessmentCriteriaGroupResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/assessment-criteria-groups/{id}`

- Operation ID: `AssessmentCriteriaGroupService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentGetAssessmentCriteriaGroupResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/assessment-criteria-groups/{id}`

- Operation ID: `AssessmentCriteriaGroupService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `assessmentAssessmentCriteriaGroupServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentUpdateAssessmentCriteriaGroupResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

