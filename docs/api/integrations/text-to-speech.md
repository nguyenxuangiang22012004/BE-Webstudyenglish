# Text To Speech API

Status: code-observed
Owner: DEV/TEST
Last reviewed: 2026-09-12
Source:
  - src/api/text-to-speech.ts
Related:
  - docs/requirements/learning-materials/text-to-speech.md

## Endpoints used by frontend

### `GET /google-text-to-speech`

Query:

| Name | Required | Notes |
| --- | --- | --- |
| `ids` | Yes in frontend type | Comma-separated or backend-defined ID filter. |
| `limit` | Yes in frontend type | Page size. |
| `offset` | Yes in frontend type | Offset. |

Returns generated TTS records with input, prompt, voice, config, audio URL, and timepoints.

### `DELETE /google-text-to-speech/{id}`

Deletes one generated TTS record.

### `GET /google-cloud/voices`

Query:

| Name | Required | Notes |
| --- | --- | --- |
| `language_code` | No | Filter voices by language code. |

Returns available Google Cloud voices.

### `POST /google-cloud/text:synthesize`

Body:

| Name | Required | Notes |
| --- | --- | --- |
| `input` | Yes | Contains `text`, `ssml`, or `prompt`. |
| `voice` | Yes | Contains `languageCode`, `name`, and `ssmlGender`. |
| `audioConfig` | Yes | Contains audio encoding. |
| `enableTimePointing` | No | Optional timepoint controls. |

Returns generated audio metadata including `id`, `url`, and `timepoints`.

