# Message API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `MessageService`
Operation count: 18

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `MessageService` trong Swagger.

## Endpoints

### `GET /v1/notification-chat/stats`

- Operation ID: `MessageService_GetConnectionStats`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | query | False | `string` | optional, if provided returns stats for specific course |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGetConnectionStatsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/notification-courses/{course_id}/chat/messages`

- Operation ID: `MessageService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | path | True | `string` |  |
| `page` | query | False | `integer` |  |
| `per_page` | query | False | `integer` |  |
| `recipient_id` | query | False | `string` | optional: filter by recipient |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGetMessagesResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/notification-courses/{course_id}/chat/messages`

- Operation ID: `MessageService_Send`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | path | True | `string` |  |
| `body` | body | True | `MessageServiceSendBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationSendMessageResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/notification-courses/{course_id}/chat/messages/{message_id}`

- Operation ID: `MessageService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | path | True | `string` |  |
| `message_id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationDeleteMessageResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/notification-courses/{course_id}/chat/messages/{message_id}/pin`

- Operation ID: `MessageService_TogglePin`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | path | True | `string` |  |
| `message_id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationTogglePinMessageResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/notification-courses/{course_id}/chat/messages/{message_id}/reactions`

- Operation ID: `MessageService_RemoveReaction`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | path | True | `string` |  |
| `message_id` | path | True | `string` |  |
| `emoji` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationRemoveReactionResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/notification-courses/{course_id}/chat/messages/{message_id}/reactions`

- Operation ID: `MessageService_GetMessageReactions`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | path | True | `string` |  |
| `message_id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGetMessageReactionsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/notification-courses/{course_id}/chat/messages/{message_id}/reactions`

- Summary: Reactions
- Operation ID: `MessageService_AddReaction`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | path | True | `string` |  |
| `message_id` | path | True | `string` |  |
| `body` | body | True | `MessageServiceAddReactionBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationAddReactionResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/notification-courses/{course_id}/chat/messages/{message_id}/reactions/all`

- Operation ID: `MessageService_DeleteAllReactions`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | path | True | `string` |  |
| `message_id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationDeleteAllReactionsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/notification-courses/{course_id}/chat/messages/{message_id}/replies`

- Summary: Replies
- Operation ID: `MessageService_SendReply`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | path | True | `string` |  |
| `message_id` | path | True | `string` |  |
| `body` | body | True | `MessageServiceSendReplyBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationSendReplyResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/notification-courses/{course_id}/chat/messages/{message_id}/with-replies`

- Operation ID: `MessageService_GetMessageWithReplies`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | path | True | `string` |  |
| `message_id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGetMessageWithRepliesResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/notification-courses/{course_id}/chat/messages/count`

- Operation ID: `MessageService_GetCount`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGetMessageCountResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/notification-courses/{course_id}/chat/messages/pinned`

- Operation ID: `MessageService_GetPinned`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGetPinnedMessagesResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/notification-courses/{course_id}/chat/messages/recent`

- Operation ID: `MessageService_GetRecent`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | path | True | `string` |  |
| `limit` | query | False | `integer` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGetRecentMessagesResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/notification-courses/{course_id}/chat/messages/recent-senders`

- Operation ID: `MessageService_GetRecentSenders`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | path | True | `string` |  |
| `limit` | query | False | `integer` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGetRecentSendersResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/notification-courses/{course_id}/chat/messages/recipient/{recipient_id}`

- Operation ID: `MessageService_GetFromRecipient`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | path | True | `string` |  |
| `recipient_id` | path | True | `string` |  |
| `page` | query | False | `integer` |  |
| `per_page` | query | False | `integer` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGetFromRecipientResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/notification-courses/{course_id}/chat/messages/recipient/{recipient_id}`

- Summary: Private messages
- Operation ID: `MessageService_SendToRecipient`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | path | True | `string` |  |
| `recipient_id` | path | True | `string` |  |
| `body` | body | True | `MessageServiceSendToRecipientBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationSendToRecipientResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/notification-courses/{course_id}/chat/online-users`

- Summary: WebSocket stats
- Operation ID: `MessageService_GetOnlineUsers`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGetOnlineUsersResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

