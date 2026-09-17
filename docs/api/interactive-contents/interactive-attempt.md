# InteractiveAttempt API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `InteractiveAttemptService`
Operation count: 4

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `InteractiveAttemptService` trong Swagger.

## Endpoints

### `POST /v1/interactive/attempts/{attempt_id}/events`

- Operation ID: `InteractiveAttemptService_LogEvent`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `attempt_id` | path | True | `string` |  |
| `body` | body | True | `InteractiveAttemptServiceLogEventBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentLogEventResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/interactive/attempts/{attempt_id}/submit`

- Operation ID: `InteractiveAttemptService_SubmitAttempt`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `attempt_id` | path | True | `string` |  |
| `body` | body | True | `InteractiveAttemptServiceSubmitAttemptBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentSubmitAttemptResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/interactive/attempts/start`

- Operation ID: `InteractiveAttemptService_StartAttempt`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `contentStartAttemptRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentStartAttemptResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/interactive/attempts/state/{content_item_id}`

- Operation ID: `InteractiveAttemptService_GetAttemptState`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `content_item_id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentGetAttemptStateResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

