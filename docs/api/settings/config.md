# Config API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `ConfigService`
Operation count: 1

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `ConfigService` trong Swagger.

## Endpoints

### `GET /v1/config`

- Operation ID: `ConfigService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `platform` | query | False | `string` |  |
| `version` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `commonGetConfigResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

