# Google API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `GoogleService`
Operation count: 22

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `GoogleService` trong Swagger.

## Endpoints

### `POST /v1/google-courses/{id}/meeting`

- Operation ID: `GoogleService_CreateCourseMeeting`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `GoogleServiceCreateCourseMeetingBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGoogleCreateCourseMeetingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/google-courses/{id}/meetings`

- Operation ID: `GoogleService_GetCourseMeeting`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGoogleGetCourseMeetingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/google-lessons/{id}/meeting`

- Operation ID: `GoogleService_CreateLessonMeeting`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `GoogleServiceCreateLessonMeetingBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGoogleCreateLessonMeetingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/google-lessons/{id}/meetings`

- Operation ID: `GoogleService_GetLessonMeeting`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGoogleGetLessonMeetingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/google/auth/callback`

- Operation ID: `GoogleService_Callback`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `code` | query | False | `string` |  |
| `state` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGoogleCallbackResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/google/auth/connect`

- Operation ID: `GoogleService_Connect`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `communicationGoogleConnectRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGoogleConnectResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/google/auth/disconnect`

- Operation ID: `GoogleService_Disconnect`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `communicationGoogleDisconnectRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGoogleDisconnectResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/google/auth/refresh`

- Operation ID: `GoogleService_Refresh`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `communicationGoogleRefreshRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGoogleRefreshResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/google/auth/status`

- Operation ID: `GoogleService_Status`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `` |  |  | `` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGoogleStatusResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/google/meetings`

- Operation ID: `GoogleService_ListMeeting`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGoogleListMeetingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/google/meetings`

- Operation ID: `GoogleService_CreateMeeting`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `communicationGoogleCreateMeetingRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGoogleCreateMeetingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/google/meetings/{id}`

- Operation ID: `GoogleService_DeleteMeeting`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGoogleDeleteMeetingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/google/meetings/{id}`

- Operation ID: `GoogleService_GetMeeting`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGoogleGetMeetingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/google/meetings/{id}`

- Operation ID: `GoogleService_UpdateMeeting`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `communicationGoogleServiceUpdateMeetingBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGoogleUpdateMeetingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/google/meetings/{id}/attendances`

- Operation ID: `GoogleService_GetMeetingAttendances`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGoogleGetMeetingAttendancesResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/google/meetings/{id}/force`

- Operation ID: `GoogleService_ForceDeleteMeeting`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGoogleForceDeleteMeetingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/google/meetings/{id}/join`

- Operation ID: `GoogleService_JoinMeeting`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `communicationGoogleServiceJoinMeetingBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGoogleJoinMeetingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/google/meetings/{id}/leave`

- Operation ID: `GoogleService_LeaveMeeting`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `communicationGoogleServiceLeaveMeetingBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGoogleLeaveMeetingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/google/meetings/{id}/recording`

- Operation ID: `GoogleService_UpdateRecording`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `GoogleServiceUpdateRecordingBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGoogleUpdateRecordingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/google/meetings/{id}/summary`

- Operation ID: `GoogleService_GetAttendanceSummary`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGoogleGetAttendanceSummaryResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/google/meetings/join/{code}`

- Operation ID: `GoogleService_JoinByShortCode`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `code` | path | True | `string` |  |
| `body` | body | True | `communicationGoogleServiceJoinByShortCodeBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGoogleJoinByShortCodeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/google/meetings/upcoming`

- Operation ID: `GoogleService_GetUpcomingMeetings`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `limit` | query | False | `integer` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGoogleGetUpcomingMeetingsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

