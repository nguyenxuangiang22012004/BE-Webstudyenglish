# AssessmentMaterial API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `AssessmentMaterialService`
Operation count: 4

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `AssessmentMaterialService` trong Swagger.

## Endpoints

### `POST /v1/assessment-materials/share`

- Operation ID: `AssessmentMaterialService_ShareMaterial`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentShareMaterialRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentShareMaterialResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/assessment-materials/shared`

- Operation ID: `AssessmentMaterialService_ListSharedMaterial`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `type` | query | False | `string` |  |
| `subject_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentListSharedMaterialResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/assessment-materials/shared/{id}`

- Operation ID: `AssessmentMaterialService_GetSharedMaterial`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `type` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentGetSharedMaterialResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/assessment-materials/upload`

- Operation ID: `AssessmentMaterialService_UploadMaterial`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentUploadMaterialRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentUploadMaterialResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

