# Microsoft API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `MicrosoftService`
Operation count: 26

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `MicrosoftService` trong Swagger.

## Endpoints

### `GET /v1/microsoft/auth/callback`

- Operation ID: `MicrosoftService_Callback`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `code` | query | False | `string` |  |
| `state` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationMicrosoftCallbackResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/microsoft/auth/connect`

- Operation ID: `MicrosoftService_Connect`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `communicationMicrosoftConnectRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationMicrosoftConnectResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/microsoft/auth/disconnect`

- Operation ID: `MicrosoftService_Disconnect`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `communicationMicrosoftDisconnectRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationMicrosoftDisconnectResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/microsoft/auth/status`

- Operation ID: `MicrosoftService_Status`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `` |  |  | `` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationMicrosoftStatusResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/microsoft/lessons/{lesson_id}/meeting`

- Operation ID: `MicrosoftService_CreateLessonIntegration`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `lesson_id` | path | True | `string` |  |
| `body` | body | True | `MicrosoftServiceCreateLessonIntegrationBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationMicrosoftCreateLessonIntegrationResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/microsoft/meeting-notifications`

- Operation ID: `MicrosoftService_ListMyNotifications`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationMicrosoftListMyNotificationsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/microsoft/meeting-notifications/{id}/read`

- Operation ID: `MicrosoftService_MarkNotificationRead`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `MicrosoftServiceMarkNotificationReadBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationMicrosoftMarkNotificationReadResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/microsoft/meeting-notifications/unread-count`

- Operation ID: `MicrosoftService_CountUnreadNotifications`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `` |  |  | `` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationMicrosoftCountUnreadNotificationsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/microsoft/meetings`

- Operation ID: `MicrosoftService_CreateMeeting`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `communicationMicrosoftCreateMeetingRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationMicrosoftCreateMeetingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/microsoft/meetings/{id}`

- Operation ID: `MicrosoftService_DeleteMeeting`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationMicrosoftDeleteMeetingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/microsoft/meetings/{id}`

- Operation ID: `MicrosoftService_GetMeeting`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationMicrosoftGetMeetingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/microsoft/meetings/{id}`

- Operation ID: `MicrosoftService_UpdateMeeting`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `communicationMicrosoftServiceUpdateMeetingBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationMicrosoftUpdateMeetingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/microsoft/meetings/{id}/attendances`

- Operation ID: `MicrosoftService_GetMeetingAttendances`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationMicrosoftGetMeetingAttendancesResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/microsoft/meetings/{id}/join`

- Operation ID: `MicrosoftService_JoinMeeting`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `communicationMicrosoftServiceJoinMeetingBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationMicrosoftJoinMeetingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/microsoft/meetings/{id}/leave`

- Operation ID: `MicrosoftService_LeaveMeeting`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `communicationMicrosoftServiceLeaveMeetingBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationMicrosoftLeaveMeetingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/microsoft/meetings/{id}/recording`

- Operation ID: `MicrosoftService_FetchRecording2`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationMicrosoftFetchRecordingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/microsoft/meetings/{id}/recording`

- Operation ID: `MicrosoftService_FetchRecording`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `MicrosoftServiceFetchRecordingBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationMicrosoftFetchRecordingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/microsoft/meetings/{id}/share-link`

- Operation ID: `MicrosoftService_SetRecordingShareURL`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `MicrosoftServiceSetRecordingShareURLBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationMicrosoftSetRecordingShareURLResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/microsoft/meetings/{id}/summary`

- Operation ID: `MicrosoftService_GetAttendanceSummary`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationMicrosoftGetAttendanceSummaryResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/microsoft/meetings/course/{course_id}`

- Operation ID: `MicrosoftService_GetCourseMeetings`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `course_id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationMicrosoftGetCourseMeetingsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/microsoft/meetings/join/{code}`

- Operation ID: `MicrosoftService_JoinByShortCode`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `code` | path | True | `string` |  |
| `body` | body | True | `communicationMicrosoftServiceJoinByShortCodeBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationMicrosoftJoinByShortCodeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/microsoft/meetings/lesson/{lesson_id}`

- Operation ID: `MicrosoftService_GetLessonMeetings`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `lesson_id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationMicrosoftGetLessonMeetingsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/microsoft/meetings/my-attendance`

- Operation ID: `MicrosoftService_GetUserAttendanceHistory`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationMicrosoftGetUserAttendanceHistoryResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/microsoft/meetings/permissions`

- Operation ID: `MicrosoftService_CheckMeetingPermissions`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `` |  |  | `` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationMicrosoftCheckMeetingPermissionsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/microsoft/meetings/upcoming`

- Operation ID: `MicrosoftService_GetUpcomingMeetings`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `limit` | query | False | `integer` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationMicrosoftGetUpcomingMeetingsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/microsoft/meetings/user`

- Operation ID: `MicrosoftService_GetUserMeetings`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationMicrosoftGetUserMeetingsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

