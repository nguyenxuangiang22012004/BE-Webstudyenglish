# Phx API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `PhxService`
Operation count: 1

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `PhxService` trong Swagger.

## Endpoints

### `POST /v1/phx/login`

- Operation ID: `PhxService_Login`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `webhookPhxLoginRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `webhookPhxLoginResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

