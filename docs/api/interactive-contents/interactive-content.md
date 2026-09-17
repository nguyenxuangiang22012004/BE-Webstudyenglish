# InteractiveContent API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `InteractiveContentService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `InteractiveContentService` trong Swagger.

## Endpoints

### `GET /v1/interactive/contents`

- Operation ID: `InteractiveContentService_ListContentItems`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `status` | query | False | `string` |  |
| `type_id` | query | False | `string` |  |
| `sort_id` | query | False | `string` |  |
| `sort_created_at` | query | False | `string` |  |
| `subject_id` | query | False | `string` |  |
| `grade_id` | query | False | `string` |  |
| `program_id` | query | False | `string` |  |
| `chapter_id` | query | False | `string` |  |
| `lesson_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentListContentItemsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/interactive/contents`

- Operation ID: `InteractiveContentService_CreateContentItem`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `contentCreateContentItemRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentCreateContentItemResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/interactive/contents/{id}`

- Operation ID: `InteractiveContentService_DeleteContentItem`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentDeleteContentItemResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/interactive/contents/{id}`

- Operation ID: `InteractiveContentService_GetContentItem`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentGetContentItemResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/interactive/contents/{id}`

- Operation ID: `InteractiveContentService_UpdateContentItem`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `InteractiveContentServiceUpdateContentItemBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentUpdateContentItemResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

