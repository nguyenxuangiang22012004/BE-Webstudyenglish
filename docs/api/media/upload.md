# Upload API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `UploadService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `UploadService` trong Swagger.

## Endpoints

### `POST /v1/upload/complete`

- Operation ID: `UploadService_Complete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `contentUploadCompleteRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentCompleteResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/upload/complete-multiple`

- Operation ID: `UploadService_CompleteMultiple`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `contentUploadCompleteMultipleRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentCompleteMultipleResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/upload/presign`

- Operation ID: `UploadService_Presign`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `contentUploadPresignRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentUploadPresignResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/upload/presign-multiple`

- Operation ID: `UploadService_PresignMultiple`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `contentUploadPresignMultipleRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentUploadPresignMultipleResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/upload/progress/{job_id}`

- Operation ID: `UploadService_GetUploadProgress`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `job_id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentGetUploadProgressResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

