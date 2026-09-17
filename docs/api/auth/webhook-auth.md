# WebhookAuth API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `WebhookAuthService`
Operation count: 1

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `WebhookAuthService` trong Swagger.

## Endpoints

### `POST /v1/hooks/token`

- Operation ID: `WebhookAuthService_GetToken`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `webhookGetWebhookTokenRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookGetWebhookTokenResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

