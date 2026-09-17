# SmartClassHook API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `SmartClassHookService`
Operation count: 3

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `SmartClassHookService` trong Swagger.

## Endpoints

### `GET /v1/hooks/smart-classes`

- Operation ID: `SmartClassHookService_ListSmartClass`

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
| `200` | A successful response. | `webhookListSmartClassResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/hooks/smart-classes`

- Operation ID: `SmartClassHookService_CreateSmartClass`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `webhookCreateSmartClassRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookCreateSmartClassResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/hooks/smart-classes/delete`

- Operation ID: `SmartClassHookService_DeleteSmartClassByCondition`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `webhookDeleteSmartClassByConditionRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookDeleteSmartClassByConditionResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

