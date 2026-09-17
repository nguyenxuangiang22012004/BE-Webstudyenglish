# AiGrading API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `AiGradingService`
Operation count: 3

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `AiGradingService` trong Swagger.

## Endpoints

### `POST /v1/ai/grading/image`

- Operation ID: `AiGradingService_GradeImage`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `communicationGradeImageRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGradeImageResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/ai/grading/speaking`

- Operation ID: `AiGradingService_GradeSpeaking`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `communicationGradeSpeakingRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGradeSpeakingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/ai/grading/writing`

- Operation ID: `AiGradingService_GradeWriting`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `communicationGradeWritingRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `communicationGradeWritingResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

