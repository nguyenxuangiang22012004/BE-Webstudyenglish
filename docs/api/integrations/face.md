# Face API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `FaceService`
Operation count: 6

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `FaceService` trong Swagger.

## Endpoints

### `POST /v1/face/check-liveness`

- Summary: Check Liveness (Anti-Spoofing test)
- Operation ID: `FaceService_CheckLiveness`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `faceCheckLivenessRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `faceCheckLivenessResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/face/identify`

- Summary: Identify face against all enrolled profiles (1:N search)
- Operation ID: `FaceService_IdentifyFace`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `faceIdentifyFaceRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `faceIdentifyFaceResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/face/profile/{user_id}`

- Summary: Delete registered face profile
- Operation ID: `FaceService_DeleteFaceProfile`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `user_id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `faceDeleteFaceProfileResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/face/profile/{user_id}`

- Summary: Get user face profile metadata
- Operation ID: `FaceService_GetFaceProfile`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `user_id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `faceGetFaceProfileResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/face/register`

- Summary: Register user face profile
- Operation ID: `FaceService_RegisterFace`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `faceRegisterFaceRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `faceRegisterFaceResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/face/verify`

- Summary: Verify face against registered profile (1:1 match)
- Operation ID: `FaceService_VerifyFace`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `faceVerifyFaceRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `faceVerifyFaceResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

