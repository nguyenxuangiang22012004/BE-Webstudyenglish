# Certificate API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `CertificateService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `CertificateService` trong Swagger.

## Endpoints

### `GET /v1/certificates`

- Operation ID: `CertificateService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `user_id` | query | False | `string` |  |
| `course_id` | query | False | `string` |  |
| `status` | query | False | `boolean` |  |
| `sort_id` | query | False | `string` |  |
| `sort_created_at` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userListCertificateResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/certificates`

- Operation ID: `CertificateService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `userCreateCertificateRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userCreateCertificateResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/certificates/{id}`

- Operation ID: `CertificateService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userDeleteCertificateResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/certificates/{id}`

- Operation ID: `CertificateService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userGetCertificateResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/certificates/{id}`

- Operation ID: `CertificateService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `userCertificateServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userUpdateCertificateResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

