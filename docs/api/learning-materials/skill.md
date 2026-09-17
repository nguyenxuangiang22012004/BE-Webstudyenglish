# Skill API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `SkillService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `SkillService` trong Swagger.

## Endpoints

### `GET /v1/skills`

- Operation ID: `SkillService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `status` | query | False | `boolean` |  |
| `type` | query | False | `string` |  |
| `parent_id` | query | False | `string` |  |
| `sort_id` | query | False | `string` |  |
| `sort_created_at` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseListSkillResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/skills`

- Operation ID: `SkillService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `courseCreateSkillRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseCreateSkillResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/skills/{id}`

- Operation ID: `SkillService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseDeleteSkillResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/skills/{id}`

- Operation ID: `SkillService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseGetSkillResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/skills/{id}`

- Operation ID: `SkillService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `courseSkillServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseUpdateSkillResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

