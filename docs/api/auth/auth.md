# Auth API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `AuthService`
Operation count: 12

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `AuthService` trong Swagger.

## Endpoints

### `PUT /v1/change-password`

- Operation ID: `AuthService_ChangePassword`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `authChangePasswordRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `authChangePasswordResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/check-otp`

- Operation ID: `AuthService_CheckOtp`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `authCheckOtpRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `authCheckOtpResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/forgot-password`

- Operation ID: `AuthService_ForgotPassword`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `authForgotPasswordRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `authForgotPasswordResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/login`

- Operation ID: `AuthService_Login`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `authLoginRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `authLoginResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/login-learning-resource-system`

- Operation ID: `AuthService_LoginLearningResourceSystem`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `authLoginRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `authExchangeToken` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/logout`

- Operation ID: `AuthService_Logout`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `authLogoutRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `authLogoutResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/opa-sync`

- Operation ID: `AuthService_OpaSync`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `authOpaSyncRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `authOpaSyncResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/rate-limit/lockouts`

- Operation ID: `AuthService_ListRateLimitLockouts`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `status` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `authListRateLimitLockoutsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/rate-limit/unlock`

- Operation ID: `AuthService_UnlockRateLimitLockout`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `authUnlockRateLimitLockoutRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `authUnlockRateLimitLockoutResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/refresh-token`

- Operation ID: `AuthService_RefreshToken`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `authRefreshTokenRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `authRefreshTokenResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/register`

- Operation ID: `AuthService_Register`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `authRegisterRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `authRegisterResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/reset-password`

- Operation ID: `AuthService_ResetPassword`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `authResetPasswordRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `authResetPasswordResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

