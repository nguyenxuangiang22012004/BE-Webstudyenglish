# Sync Materials

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-09-12
Source:
  - src/api/syncmaterials.ts
  - src/app/[locale]/admin/sync-materials/page.tsx
Related:
  - docs/api/transfers/sync-materials.md
  - docs/requirements/learning-materials/question-bank.md
  - docs/requirements/learning-materials/lesson-plan.md
  - docs/requirements/transfers/import-export.md

## 1. Purpose

Sync Materials supports moving reusable learning content between the LMS and a shared material system.

Current frontend code covers:

- Shared questions/materials.
- Shared lesson plan materials.
- Shared assignment materials for homework and exam.
- Uploading local items to the shared material system.
- Syncing shared items into the local LMS.

## 2. Authentication context

Requests attach `xlms-token` from browser `localStorage` when available.

This token is separate from the normal LMS API session and should be treated as an integration credential for the shared material system.

## 3. Main flows

### Browse shared materials

User opens the sync materials area and searches or filters shared content by keyword, type, attributes, or tags.

The system shows whether an item has already been used locally through fields such as `used`, `used_question_id`, `used_assignment_id`, or `used_lesson_plan_id`.

### View material detail

User opens a shared question, lesson plan, or assignment detail to inspect its content before syncing.

### Sync shared material into LMS

User selects one or more shared material IDs. The frontend sends the IDs to the backend, which returns a `job_id`.

The job imports or maps the selected content into the local LMS.

### Upload local material to shared system

User selects local questions or assignments. The frontend sends the local IDs to the backend, which returns a `job_id`.

The job publishes or syncs selected local content to the shared material system.

## 4. Business rules

- Users should only sync or upload materials that their role can access locally.
- The UI should clearly show whether a shared item is already used locally.
- Sync jobs should be trackable through a job/progress mechanism.
- Imported questions must preserve type, content, media, options, answers, attributes, subject, and source metadata where supported.
- Imported lesson plan materials must preserve lesson plan parts and teacher/student guide fields where supported.
- Assignment sync currently documents homework and exam only.

## 5. Open questions

- Which roles can use sync materials?
- Is `xlms-token` issued by LMS login, SSO, or a separate integration flow?
- What is the official job status API for material sync progress?
- Should syncing duplicate an existing item, update it, or block the operation when `used = true`?
