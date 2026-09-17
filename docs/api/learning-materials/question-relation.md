# QuestionRelation API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `QuestionRelationService`
Operation count: 1

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `QuestionRelationService` trong Swagger.

## Endpoints

### `POST /v1/question-relation`

- Operation ID: `QuestionRelationService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `assessmentCreateQuestionRelationRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `assessmentCreateQuestionRelationResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

