# Flashcard API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `FlashcardService`
Operation count: 14

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `FlashcardService` trong Swagger.

## Endpoints

### `GET /v1/flashcard/{lesson_id}/settings`

- Operation ID: `FlashcardService_GetSettingFlashcard`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `lesson_id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseGetSettingFlashcardResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/flashcard/lessons/{lesson_id}/progress`

- Operation ID: `FlashcardService_GetVocabularyLesson`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `lesson_id` | path | True | `string` |  |
| `course_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseGetVocabularyLessonResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/flashcard/lessons/{lesson_id}/vocabularies`

- Operation ID: `FlashcardService_AddVocabularyLesson`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `lesson_id` | path | True | `string` |  |
| `body` | body | True | `FlashcardServiceAddVocabularyLessonBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseAddVocabularyLessonResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/flashcard/settings`

- Operation ID: `FlashcardService_UpdateSettingFlashcard`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `courseUpdateSettingFlashcardRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseUpdateSettingFlashcardResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/flashcard/vocabularies`

- Operation ID: `FlashcardService_ListVocabulary`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |
| `difficulty` | query | False | `integer` |  |
| `part_of_speech` | query | False | `string` |  |
| `language_code` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseListVocabularyResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/flashcard/vocabularies`

- Operation ID: `FlashcardService_CreateVocabulary`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `courseCreateVocabularyRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseCreateVocabularyResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/flashcard/vocabularies/{id}`

- Operation ID: `FlashcardService_DeleteVocabulary`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseDeleteVocabularyResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/flashcard/vocabularies/{id}`

- Operation ID: `FlashcardService_UpdateVocabulary`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `FlashcardServiceUpdateVocabularyBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseUpdateVocabularyResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/flashcard/vocabularies/{vocabulary_id}`

- Operation ID: `FlashcardService_GetVocabulary`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `vocabulary_id` | path | True | `string` |  |
| `lesson_id` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseGetVocabularyResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/flashcard/vocabulary-progress/{vocabulary_id}`

- Operation ID: `FlashcardService_UpdateVocabularyProgress`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `vocabulary_id` | path | True | `string` |  |
| `body` | body | True | `FlashcardServiceUpdateVocabularyProgressBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseUpdateVocabularyProgressResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/flashcard/vocabulary-tags`

- Operation ID: `FlashcardService_ListVocabularyTag`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `page` | query | False | `integer` |  |
| `limit` | query | False | `integer` |  |
| `keyword` | query | False | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseListVocabularyTagResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/flashcard/vocabulary-tags`

- Operation ID: `FlashcardService_CreateVocabularyTag`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `courseCreateVocabularyTagRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseCreateVocabularyTagResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `DELETE /v1/flashcard/vocabulary-tags/{id}`

- Operation ID: `FlashcardService_DeleteVocabularyTag`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseDeleteVocabularyTagResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `PUT /v1/flashcard/vocabulary-tags/{id}`

- Operation ID: `FlashcardService_UpdateVocabularyTag`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `id` | path | True | `string` |  |
| `body` | body | True | `FlashcardServiceUpdateVocabularyTagBody` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `courseUpdateVocabularyTagResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

