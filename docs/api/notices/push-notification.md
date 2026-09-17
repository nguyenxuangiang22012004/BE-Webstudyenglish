# PushNotification API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `PushNotificationService`
Operation count: 12

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `PushNotificationService` trong Swagger.

## Endpoints

### `GET /v1/push/confirm-users`

- Operation ID: `PushNotificationService_GetConfirmUsers`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `notice_socket_log_id` | query | False | `string` |  |
| `page` | query | False | `integer` |  |
| `per_page` | query | False | `integer` |  |
| `is_confirmed` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGetConfirmUsersResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/push/devices`

- Operation ID: `PushNotificationService_GetMyDevices`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `` |  |  | `` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGetMyDevicesResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/push/devices/register`

- Summary: Device management
- Operation ID: `PushNotificationService_RegisterDevice`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `communicationRegisterDeviceRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationRegisterDeviceResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/push/devices/unregister`

- Operation ID: `PushNotificationService_UnregisterDevice`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `communicationUnregisterDeviceRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationUnregisterDeviceResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/push/my-notices`

- Operation ID: `PushNotificationService_GetMyNotices`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `per_page` | query | False | `integer` |  |
| `status` | query | False | `string` | optional: true/false/1/0 |
| `distinct` | query | False | `boolean` | optional: distinct by notices.id |
| `type` | query | False | `string` | optional: comma-separated notice types (e.g. general, reminder, submission_graded, homework_assigned) |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGetMyNoticesResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/push/notices/{id}/send`

- Summary: Notice push (admin only)
- Operation ID: `PushNotificationService_SendNoticeWithPush`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` | notice id |
| `body` | body | True | `PushNotificationServiceSendNoticeWithPushBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationSendNoticeWithPushResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/push/notices/{id}/send-socket`

- Operation ID: `PushNotificationService_SendNoticeWithSocket`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` | notice id |
| `body` | body | True | `PushNotificationServiceSendNoticeWithSocketBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationSendNoticeWithPushResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/push/notices/accept-socket`

- Operation ID: `PushNotificationService_Accept`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `communicationAcceptNoticeRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationAcceptNoticeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/push/notices/confirm-socket`

- Operation ID: `PushNotificationService_ConfirmSocket`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `communicationConfirmNoticeRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationConfirmNoticeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/push/pushed-notices`

- Operation ID: `PushNotificationService_GetPushedNotices`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `notice_id` | query | False | `string` |  |
| `page` | query | False | `integer` |  |
| `per_page` | query | False | `integer` |  |
| `start_date` | query | False | `string` |  |
| `end_date` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGetPushedNoticesResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/push/scan-unscanned-firebase`

- Operation ID: `PushNotificationService_ScanUnscannedFirebaseNotices`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `communicationScanUnscannedFirebaseNoticesRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationScanUnscannedFirebaseNoticesResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/push/test`

- Summary: Test notification
- Operation ID: `PushNotificationService_SendTestNotification`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `communicationSendTestNotificationRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationSendTestNotificationResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

