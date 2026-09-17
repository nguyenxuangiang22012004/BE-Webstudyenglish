# Exam Answer Review And Manual Scoring

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-09-12
Source:
  - src/api/exam-answer.ts
  - src/app/[locale]/teacher/lessons/[id]/exam/[examId]/student/[studentId]/page.tsx
Related:
  - docs/api/learning-materials/exam-answer.md
  - docs/requirements/learning-materials/exam.md
  - docs/requirements/learning-materials/homework.md
  - docs/requirements/reports/teacher-reports-weekly-lessons.md

## 1. Purpose

This document covers the answer review and manual scoring flow for exams and homework.

The main exam document explains how an exam is created and assigned. This document explains what happens after students answer and submit.

## 2. Actors

- Teacher reviews student submissions, sees answer details, adds manual scores, and comments.
- Student reviews their own submitted answers and results.

## 3. Exam answer review

For an exam, the system can show:

- Student name.
- Duration.
- Total score and ratio.
- Submitted time.
- Manual scoring status.
- Total question count.
- Unscored question count.
- Teacher comment.
- Per-question answer details.

Supported question answer shapes in current frontend types include multiple choice, fill in blank, matching, drag/drop or ordering positions, labeling, category/grouping, writing, and speaking/manual answers.

## 4. Manual scoring

Writing and speaking style answers may require manual scoring.

Teacher submits a score list containing:

- `question_id`
- `score`
- `comment`

The request can target an `exam_id` or `homework_id` plus `user_id`.

## 5. Student list for grading

Teacher can load student submission status for an exam or homework, including:

- Submitted/not submitted.
- Submitted time.
- Duration.
- Score.
- Ratio.
- Unscored count.
- Completion count for homework.

## 6. Comments

Teacher can post comments for:

- Exam submission.
- Homework submission.

Comments should be visible in the related review/result experience according to backend rules.

## 7. Business rules

- Auto-scored answers should display correctness and score when available.
- Manual answers should clearly show whether they have been scored.
- Teacher should be able to identify unscored submissions before publishing or finalizing review.
- Student review should not expose teacher-only controls.
- Manual scoring must respect max score rules defined by the assignment/question.

## 8. Open questions

- Can manual scores be edited after submission?
- When does a student see teacher comments?
- Is there a publish/finalize state after all manual scoring is complete?
- Are homework and exam comments stored and displayed with the same lifecycle?

