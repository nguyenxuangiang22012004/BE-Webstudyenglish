# Question API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `QuestionService`
Operation count: 10

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `QuestionService` trong Swagger.

## Endpoints

### `GET /v1/questions`

- Operation ID: `QuestionService_List`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `status` | query | False | `boolean` |  |
| `question_type` | query | False | `string` |  |
| `subject_id` | query | False | `string` |  |
| `begin_at` | query | False | `string` |  |
| `end_at` | query | False | `string` |  |
| `created_at` | query | False | `string` |  |
| `homework_id` | query | False | `string` |  |
| `lesson_plan_part_id` | query | False | `string` |  |
| `exam_id` | query | False | `string` |  |
| `level_test_id` | query | False | `string` |  |
| `attribute_ids` | query | False | `string` |  |
| `contest_round_id` | query | False | `string` |  |
| `exercise_id` | query | False | `string` |  |
| `vocabulary_id` | query | False | `string` |  |
| `lesson_id` | query | False | `string` |  |
| `sort_id` | query | False | `string` |  |
| `sort_created_at` | query | False | `string` |  |
| `source_question_id` | query | False | `string` |  |
| `ids` | query | False | `string` |  |
| `vstep_id` | query | False | `string` |  |
| `source_question_ids` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseListQuestionResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/questions`

- Operation ID: `QuestionService_Create`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `courseCreateQuestionRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseCreateQuestionResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/questions/{id}`

- Operation ID: `QuestionService_Delete`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseDeleteQuestionResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/questions/{id}`

- Operation ID: `QuestionService_Get`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `homework_id` | query | False | `string` |  |
| `exam_id` | query | False | `string` |  |
| `contest_round_id` | query | False | `string` |  |
| `exercise_id` | query | False | `string` |  |
| `source_question_id` | query | False | `string` |  |
| `vstep_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseGetQuestionResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/questions/{id}`

- Operation ID: `QuestionService_Update`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `courseQuestionServiceUpdateBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseUpdateQuestionResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/questions/copy`

- Operation ID: `QuestionService_Copy`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `courseCopyQuestionRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseCreateQuestionResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/questions/share-material`

- Operation ID: `QuestionService_ShareMaterial`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `courseShareMaterialRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseShareMaterialResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/questions/share-materials`

- Operation ID: `QuestionService_ListSharedMaterial`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `type` | query | False | `string` |  |
| `attribute_ids` | query | False | `array` |  |
| `tags` | query | False | `array` |  |
| `subject_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseListSharedQuestionResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/questions/share-materials/{id}`

- Operation ID: `QuestionService_GetSharedMaterial`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseGetSharedQuestionResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/questions/upload-material`

- Operation ID: `QuestionService_UploadMaterial`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `courseUploadMaterialRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseUploadMaterialResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

