# Media API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `MediaService`
Operation count: 5

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `MediaService` trong Swagger.

## Endpoints

### `DELETE /v1/medias/files/{file_id}`

- Operation ID: `MediaService_DeleteFile`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `file_id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentDeleteFileResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/medias/files/{folder_id}`

- Operation ID: `MediaService_ListFile`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `folder_id` | path | True | `string` | Cannot be optional - used in path parameter |
| `page` | query | False | `integer` |  |
| `per_page` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `filter_time` | query | False | `string` |  |
| `filter_type` | query | False | `string` |  |
| `filter_extension` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentListFileResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/medias/folders`

- Operation ID: `MediaService_ListFolder`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `folder_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentListFolderResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/medias/folders`

- Operation ID: `MediaService_CreateFolder`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `contentCreateFolderRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentCreateFolderResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/medias/folders/{folder_id}`

- Operation ID: `MediaService_DeleteFolder`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `folder_id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `contentDeleteFolderResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

