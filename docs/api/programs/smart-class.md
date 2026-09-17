# SmartClass API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `SmartClassService`
Operation count: 6

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `SmartClassService` trong Swagger.

## Endpoints

### `GET /v1/smart-classes`

- Operation ID: `SmartClassService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `lesson_id` | query | False | `string` |  |
| `course_id` | query | False | `string` |  |
| `get_by_user` | query | False | `boolean` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseListSmartClassResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/smart-classes`

- Operation ID: `SmartClassService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `courseCreateSmartClassRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseCreateSmartClassResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/smart-classes/{id}`

- Operation ID: `SmartClassService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseDeleteSmartClassResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/smart-classes/{id}`

- Operation ID: `SmartClassService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseGetSmartClassResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/smart-classes/{id}`

- Operation ID: `SmartClassService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `courseSmartClassServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseUpdateSmartClassResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/smart-classes/delete`

- Operation ID: `SmartClassService_DeleteByCondition`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `courseDeleteSmartClassByConditionRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseDeleteSmartClassByConditionResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

