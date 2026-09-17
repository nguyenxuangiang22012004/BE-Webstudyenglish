# School API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `SchoolService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `SchoolService` trong Swagger.

## Endpoints

### `GET /v1/schools`

- Operation ID: `SchoolService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `limit` | query | False | `integer` |  |
| `page` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `type` | query | False | `string` |  |
| `status` | query | False | `boolean` |  |
| `province_code` | query | False | `string` |  |
| `ward_code` | query | False | `string` |  |
| `sort_id` | query | False | `string` |  |
| `sort_created_at` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userListSchoolResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/schools`

- Operation ID: `SchoolService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `userCreateSchoolRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userCreateSchoolResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/schools/{id}`

- Operation ID: `SchoolService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userDeleteSchoolResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/schools/{id}`

- Operation ID: `SchoolService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userGetSchoolResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/schools/{id}`

- Operation ID: `SchoolService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `userSchoolServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `userUpdateSchoolResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

