# Profile API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `ProfileService`
Operation count: 6

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `ProfileService` trong Swagger.

## Endpoints

### `GET /v1/profile`

- Operation ID: `ProfileService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `` |  |  | `` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userGetProfileResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/profile`

- Operation ID: `ProfileService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `userUpdateProfileRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userUpdateProfileResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/profile/children`

- Operation ID: `ProfileService_GetChildren`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `` |  |  | `` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userGetChildrenResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/profile/children-token`

- Operation ID: `ProfileService_GetChildrenToken`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `user_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userGetChildrenTokenResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/profile/confirm-email`

- Operation ID: `ProfileService_ConfirmEmail`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `userConfirmEmailRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userConfirmEmailResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/profile/get-otp`

- Operation ID: `ProfileService_GetOtp`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `userGeOtpRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userGetOtpResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

