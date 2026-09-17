# Clone Homework And Exam

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-09-12
Source:
  - src/api/clone.ts
Related:
  - docs/requirements/learning-materials/homework.md
  - docs/requirements/learning-materials/exam.md
  - docs/api/learning-materials/homework.md
  - docs/api/learning-materials/exam.md

## 1. Purpose

Clone lets users create a new homework or exam from an existing one.

This is useful when teachers or admins want to reuse structure, questions, score setup, and metadata while changing the name, description, or lesson placement.

## 2. Frontend request

The current shared clone request body includes:

| Field | Required | Notes |
| --- | --- | --- |
| `name` | Yes | Name of the cloned item. |
| `lesson_id` | No | Target lesson, when moving the cloned item to another lesson. |
| `description` | No | Description override. |

## 3. Supported documented clone targets

- Homework: `POST /homeworks/{id}/cloned`
- Exam: `POST /exams/{id}/cloned`

## 4. Business rules

- The cloned item should receive a new identifier.
- The cloned item should not inherit student submissions, scores, comments, or grading state.
- The cloned item may inherit questions, max score, cover image, and content configuration if backend supports it.
- If `lesson_id` is provided, the cloned item should belong to the target lesson.
- Clone permission should follow the user's permission for creating the target item type.

## 5. Open questions

- Does clone copy question links or duplicate question records?
- Does clone preserve assigned status or always create an unassigned item?
- Are deadline and time-limit fields copied for exams?
- Can users clone across course/program/school boundaries?
