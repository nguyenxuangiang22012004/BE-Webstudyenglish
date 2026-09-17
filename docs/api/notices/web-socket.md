# WebSocket API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `WebSocketService`
Operation count: 2

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `WebSocketService` trong Swagger.

## Endpoints

### `GET /v1/notification-courses/chat`

- Summary: Events (WebSocket - real-time events via WebSocket connections)
- Operation ID: `WebSocketService_ConnectWebSocketCourseEvents`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | query | False | `string` |  |
| `user_id` | query | False | `string` | Optional: user_id can be provided via query parameter or header |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationConnectWebSocketCourseEventsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/notification-courses/chat/private`

- Operation ID: `WebSocketService_ConnectWebSocketPrivateMessageEvents`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | query | False | `string` |  |
| `user_id` | query | False | `string` | optional |
| `recipient_id` | query | False | `string` | optional filter |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationConnectWebSocketPrivateMessageEventsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

