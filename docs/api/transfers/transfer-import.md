# TransferImport API

Status: generated
Owner: DEV/TEST
Source: `swagger.json`
Related tag: `TransferImportService`
Operation count: 13

## Tổng quan

Tài liệu này liệt kê các endpoint thuộc tag `TransferImportService` trong Swagger.

## Endpoints

### `POST /v1/transfer/assessments/import-excel`

- Summary: Assessment import excel
- Operation ID: `TransferImportService_AssessmentImportExcel`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `transferAssessmentImportExcelRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferAssessmentImportExcelResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/transfer/classes/import`

- Summary: Class import
- Operation ID: `TransferImportService_ImportClasses`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `transferImportClassesRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferImportClassesResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/transfer/courses/import`

- Summary: Course import
- Operation ID: `TransferImportService_ImportCourse`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `transferImportCourseRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferImportCourseResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/transfer/google-cloud/text-to-speech/import`

- Summary: Import google text to speech
- Operation ID: `TransferImportService_ImportGoogleTextToSpeech`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `transferImportGoogleTextToSpeechRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferImportGoogleTextToSpeechResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/transfer/import/jobs`

- Summary: List all import jobs
- Operation ID: `TransferImportService_ListImportJobs`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `status` | query | False | `string` | Optional: filter by status (pending, running, completed, failed) |
| `limit` | query | False | `integer` | Optional: limit number of results (default: 100) |
| `offset` | query | False | `integer` | Optional: offset for pagination (default: 0) |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferListImportJobsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/transfer/import/progress/{job_id}`

- Summary: Get import progress
- Operation ID: `TransferImportService_GetImportProgress`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `job_id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferGetImportProgressResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `GET /v1/transfer/import/progress/{job_id}/event`

- Summary: Get import progress event
- Operation ID: `TransferImportService_GetImportProgressEvent`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `job_id` | path | True | `string` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferGetImportProgressEventResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/transfer/programs/import`

- Summary: Program import
- Operation ID: `TransferImportService_ImportPrograms`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `transferImportProgramsRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferImportProgramsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/transfer/questions/import`

- Summary: Question import
- Operation ID: `TransferImportService_ImportQuestions`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `transferImportQuestionsRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferImportQuestionsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/transfer/schools/import`

- Summary: School import
- Operation ID: `TransferImportService_ImportSchools`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `transferImportSchoolsRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferImportSchoolsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/transfer/students/import`

- Summary: Student import to classes/courses
- Operation ID: `TransferImportService_ImportStudents`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `transferImportStudentsRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferImportStudentsResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/transfer/users/import`

- Summary: User import
- Operation ID: `TransferImportService_ImportUsers`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `transferImportUsersRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferImportUsersResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

### `POST /v1/transfer/vocabularies/import`

- Summary: Vocabulary import
- Operation ID: `TransferImportService_ImportVocabularies`

#### Parameters

| Name | In | Required | Type/Schema | Description |
| --- | --- | --- | --- | --- |
| `body` | body | True | `transferImportVocabulariesRequest` |  |

#### Responses

| Status | Description | Schema |
| --- | --- | --- |
| `200` | A successful response. | `transferImportVocabulariesResponse` |
| `default` | An unexpected error response. | `googleRpcStatus` |

