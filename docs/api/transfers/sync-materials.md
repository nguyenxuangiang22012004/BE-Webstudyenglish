# Sync Materials API

Status: code-observed
Owner: DEV/TEST
Last reviewed: 2026-09-12
Source:
  - src/api/syncmaterials.ts
Related:
  - docs/requirements/learning-materials/sync-materials.md

## Purpose

Frontend hooks for browsing, importing, and uploading shared material data between LMS and the shared material system.

Most requests include an optional `xlms-token` header read from browser `localStorage`.

## Question materials

### `GET /questions/share-materials`

Query:

| Name | Required | Notes |
| --- | --- | --- |
| `page` | No | Page number. |
| `limit` | No | Page size. |
| `keyword` | No | Search keyword. |
| `type` | No | Question/material type. |
| `attribute_ids` | No | Attribute filters. |
| `tags` | No | Tag filters. |

Returns paginated `SyncQuestion` items.

### `GET /questions/share-materials/{id}`

Returns one shared question material.

### `POST /questions/share-material`

Body:

| Name | Required | Notes |
| --- | --- | --- |
| `material_ids` | Yes | Shared material IDs to sync into LMS. |

Returns `{ job_id }`.

### `POST /questions/upload-material`

Body:

| Name | Required | Notes |
| --- | --- | --- |
| `question_ids` | Yes | Local question IDs to upload to shared material system. |

Returns `{ job_id }`.

## Lesson plan materials

### `GET /lesson-plans/share-materials`

Query: `page`, `limit`, `keyword`.

Returns paginated shared lesson plan materials.

### `GET /lesson-plans/share-materials/{id}`

Returns a shared lesson plan material and its parts.

### `POST /lesson-plans/share-material`

Body: `{ material_ids }`.

Returns `{ job_id }`.

## Assignment materials

Assignment materials currently document homework and exam usage only.

### `GET /assessment-materials/shared`

Query: `page`, `limit`, `keyword`, `type`.

Returns paginated shared assignments.

### `GET /assessment-materials/shared/{id}`

Query:

| Name | Required | Notes |
| --- | --- | --- |
| `type` | Yes | Assignment type, currently homework or exam in documented flow. |

Returns assignment detail and questions.

### `POST /assessment-materials/share`

Body:

| Name | Required | Notes |
| --- | --- | --- |
| `material_ids` | Yes | Shared assignment material IDs. |
| `assignment_type` | Yes | Assignment type, currently homework or exam in documented flow. |

Returns `{ job_id }`.

### `POST /assessment-materials/upload`

Body:

| Name | Required | Notes |
| --- | --- | --- |
| `assignment_ids` | Yes | Local assignment IDs. |
| `assignment_type` | Yes | Assignment type, currently homework or exam in documented flow. |

Returns `{ job_id }`.

