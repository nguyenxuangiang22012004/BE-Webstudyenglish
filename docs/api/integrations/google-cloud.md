# GoogleCloud API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `GoogleCloudService`
Operation count: 2

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `GoogleCloudService` trong Swagger.

## Endpoints

### `POST /v1/google-cloud/text:synthesize`

- Operation ID: `GoogleCloudService_Synthesize`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `communicationGoogleCloudSynthesizeRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGoogleCloudSynthesizeResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/google-cloud/voices`

- Operation ID: `GoogleCloudService_Voices`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `language_code` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGoogleCloudVoicesResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

