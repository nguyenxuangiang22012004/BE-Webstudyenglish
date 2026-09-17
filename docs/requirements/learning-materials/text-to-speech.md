# Text To Speech

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-09-12
Source:
  - src/api/text-to-speech.ts
  - src/app/[locale]/admin/text-to-speech/page.tsx
Related:
  - docs/api/integrations/text-to-speech.md
  - docs/requirements/integrations/external-integrations.md
  - docs/requirements/media/media.md

## 1. Purpose

Text To Speech lets admin generate and manage audio assets from text using Google Cloud voices.

The generated audio can support listening, pronunciation, language-learning, or content-authoring workflows.

## 2. Current frontend capabilities

- List existing Google Text-to-Speech audio records.
- Delete generated audio records.
- Fetch Google Cloud voices by optional language code.
- Synthesize audio from text, SSML, or prompt.
- Receive an audio URL and optional timepoints.

## 3. Business rules

- Users should choose a supported voice before synthesis.
- The synthesis request must include input text, SSML, or prompt.
- The audio encoding is one of `MP3`, `OGG_OPUS`, or `LINEAR16`.
- Generated audio should be treated as a managed media asset.
- Delete should remove only the selected TTS record and should respect role permissions.

## 4. Open questions

- Which roles can access the Text To Speech admin screen?
- Is generated audio reusable inside lessons, questions, vocabulary, or media library?
- What are the limits for text length, prompt length, voice language, and generation frequency?
- Are costs/quota surfaced to admin users?
