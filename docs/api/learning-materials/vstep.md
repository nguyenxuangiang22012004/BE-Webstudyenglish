# Vstep API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `VstepService`
Operation count: 7

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `VstepService` trong Swagger.

## Endpoints

### `GET /v1/vsteps`

- Operation ID: `VstepService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `filters[string]` | query | False | `string` |  |
| `sort` | query | False | `string` |  |
| `sort_id` | query | False | `string` |  |
| `sort_created_at` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentVstepListResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/vsteps`

- Operation ID: `VstepService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentCreateVstepRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentCreateVstepResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/vsteps/{id}`

- Operation ID: `VstepService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentDeleteVstepResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/vsteps/{id}`

- Operation ID: `VstepService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentGetVstepResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/vsteps/{id}`

- Operation ID: `VstepService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `assessmentVstepServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentUpdateVstepResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/vsteps/{id}/assigned`

- Operation ID: `VstepService_Assigned`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `assessmentVstepServiceAssignedBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentAssignedVstepResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/vsteps/{id}/assigned-lessons`

- Operation ID: `VstepService_AssignedLesson`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentAssignedLessonVstepResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

