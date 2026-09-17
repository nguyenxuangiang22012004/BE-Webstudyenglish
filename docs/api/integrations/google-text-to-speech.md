# GoogleTextToSpeech API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `GoogleTextToSpeechService`
Operation count: 2

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `GoogleTextToSpeechService` trong Swagger.

## Endpoints

### `GET /v1/google-text-to-speech`

- Operation ID: `GoogleTextToSpeechService_ListGoogleTextToSpeech`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `ids` | query | False | `string` |  |
| `limit` | query | False | `integer` |  |
| `offset` | query | False | `integer` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentListGoogleTextToSpeechResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/google-text-to-speech/{id}`

- Operation ID: `GoogleTextToSpeechService_DeleteGoogleTextToSpeech`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentDeleteGoogleTextToSpeechResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

