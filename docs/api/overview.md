# API Documentation

Status: generated
Owner: DEV/TEST
Source: `swagger.json` (bản nhận ngày 2026-09-16; môi trường BE: chưa ghi nhận)
Generated at: 2026-09-16 +07:00
Last reviewed: 2026-09-11
Related:
  - README.md
  - docs/requirements/overview.md
  - src/api
  - src/types

## Mục đích

Folder này chứa tài liệu API được bóc tách từ Swagger để BA, DEV và AI Tester dễ tra cứu theo domain/service.

Ghi chú: tài liệu này được sinh từ Swagger, chưa thay thế việc đối chiếu với code hiện tại trong `src/api/`, `src/types/` và `next.config.ts`.

## Cấu trúc

### `auth/`

- [Auth API](auth/auth.md) - 12 operations
- [WebhookAuth API](auth/webhook-auth.md) - 1 operations

### `criteria/`

- [AssessmentCriteria API](criteria/assessment-criteria.md) - 6 operations
- [AssessmentCriteriaGroup API](criteria/assessment-criteria-group.md) - 7 operations
- [AssessmentSubcriteria API](criteria/assessment-subcriteria.md) - 5 operations

### `dashboards/`

- [Dashboard API](dashboards/dashboard.md) - 17 operations
- [Report API](dashboards/report.md) - 6 operations
- [StudyReport API](dashboards/study-report.md) - 8 operations
- [StudyReportCriteria API](dashboards/study-report-criteria.md) - 5 operations

### `feedbacks/`

- [Feedback API](feedbacks/feedback.md) - 6 operations
- [InternalComment API](feedbacks/internal-comment.md) - 6 operations

### `flip-books/`

- [Book API](flip-books/book.md) - 5 operations
- [BookPage API](flip-books/book-page.md) - 6 operations
- [BookTag API](flip-books/book-tag.md) - 5 operations

### `geography/`

- [Province API](geography/province.md) - 3 operations
- [ProvinceHook API](geography/province-hook.md) - 3 operations
- [Ward API](geography/ward.md) - code-observed frontend wrapper

### `integrations/`

- [AiGrading API](integrations/ai-grading.md) - 3 operations
- [Elsa API](integrations/elsa.md) - 1 operations
- [EnspireOnline API](integrations/enspire-online.md) - 1 operations
- [Face API](integrations/face.md) - 6 operations
- [Google API](integrations/google.md) - 22 operations
- [GoogleCloud API](integrations/google-cloud.md) - 2 operations
- [GoogleTextToSpeech API](integrations/google-text-to-speech.md) - 2 operations
- [LanguageConfidence API](integrations/language-confidence.md) - 1 operations
- [Languagetool API](integrations/languagetool.md) - 2 operations
- [Linguix API](integrations/linguix.md) - 1 operations
- [Microsoft API](integrations/microsoft.md) - 26 operations
- [Phx API](integrations/phx.md) - 1 operations
- [Speechace API](integrations/speechace.md) - 1 operations
- [Text To Speech API](integrations/text-to-speech.md) - code-observed frontend wrapper

### `interactive-contents/`

- [H5P API](interactive-contents/h5-p.md) - 3 operations
- [InteractiveAttempt API](interactive-contents/interactive-attempt.md) - 4 operations
- [InteractiveContent API](interactive-contents/interactive-content.md) - 5 operations
- [InteractiveContentType API](interactive-contents/interactive-content-type.md) - 5 operations

### `learning-materials/`

- [Assessment API](learning-materials/assessment.md) - 10 operations
- [Exam Answer API](learning-materials/exam-answer.md) - code-observed frontend wrapper
- [Exam API](learning-materials/exam.md) - 8 operations
- [Exercise API](learning-materials/exercise.md) - 8 operations
- [Flashcard API](learning-materials/flashcard.md) - 14 operations
- [Heading API](learning-materials/heading.md) - 5 operations
- [Homework API](learning-materials/homework.md) - 10 operations
- [Lesson API](learning-materials/lesson.md) - 7 operations
- [LessonHook API](learning-materials/lesson-hook.md) - 8 operations
- [Question API](learning-materials/question.md) - 10 operations
- [QuestionAttribute API](learning-materials/question-attribute.md) - 8 operations
- [QuestionRelation API](learning-materials/question-relation.md) - 1 operations
- [Skill API](learning-materials/skill.md) - 5 operations
- [SourceQuestion API](learning-materials/source-question.md) - 5 operations
- [Tag API](learning-materials/tag.md) - 5 operations
- [Topic API](learning-materials/topic.md) - 5 operations
- [TrainingLevel API](learning-materials/training-level.md) - 5 operations
- [Vstep API](learning-materials/vstep.md) - 7 operations

### `media/`

- [Media API](media/media.md) - 5 operations
- [Upload API](media/upload.md) - 5 operations

### `notices/`

- [Message API](notices/message.md) - 18 operations
- [Notice API](notices/notice.md) - 5 operations
- [PushNotification API](notices/push-notification.md) - 12 operations
- [WebSocket API](notices/web-socket.md) - 2 operations

### `other/`

- [Contest API](other/contest.md) - 7 operations
- [ContestRound API](other/contest-round.md) - 12 operations
- [Share API](other/share.md) - 3 operations
- [Study API](other/study.md) - 35 operations

### `programs/`

- [Chapter API](programs/chapter.md) - 6 operations
- [ChapterHook API](programs/chapter-hook.md) - 6 operations
- [Course API](programs/course.md) - 11 operations
- [CourseHook API](programs/course-hook.md) - 8 operations
- [CourseSchedule API](programs/course-schedule.md) - 3 operations
- [LessonPlan API](programs/lesson-plan.md) - 10 operations
- [LessonPlanPart API](programs/lesson-plan-part.md) - 5 operations
- [Program API](programs/program.md) - 7 operations
- [ProgramHook API](programs/program-hook.md) - 6 operations
- [SmartClass API](programs/smart-class.md) - 6 operations
- [SmartClassHook API](programs/smart-class-hook.md) - 3 operations
- [TeachingPlan API](programs/teaching-plan.md) - 6 operations

### `school-years/`

- [SchoolYear API](school-years.md) - 5 operations

### `schools/`

- [Certificate API](schools/certificate.md) - 5 operations
- [Class API](schools/class.md) - 12 operations
- [ClassHook API](schools/class-hook.md) - 5 operations
- [Degree API](schools/degree.md) - 5 operations
- [Department API](schools/department.md) - 5 operations
- [EmployeePosition API](schools/employee-position.md) - 5 operations
- [Faculty API](schools/faculty.md) - 5 operations
- [FacultyHook API](schools/faculty-hook.md) - 5 operations
- [Grade API](schools/grade.md) - 5 operations
- [GradeHook API](schools/grade-hook.md) - 5 operations
- [School API](schools/school.md) - 5 operations
- [SchoolHook API](schools/school-hook.md) - 5 operations

### `semesters/`

- [Holiday API](semesters/holiday.md) - 5 operations
- [HolidayHook API](semesters/holiday-hook.md) - 5 operations
- [SchoolYear API](semesters/school-year.md) - 5 operations
- [Semester API](semesters/semester.md) - 5 operations
- [SemesterHook API](semesters/semester-hook.md) - 5 operations
- [Week API](semesters/week.md) - 2 operations
- [WeekHook API](semesters/week-hook.md) - 2 operations

### `settings/`

- [AppVersion API](settings/app-version.md) - 6 operations
- [Config API](settings/config.md) - 1 operations
- [Setting API](settings/setting.md) - 6 operations

### `subjects/`

- [Subject API](subjects/subject.md) - 5 operations
- [SubjectHook API](subjects/subject-hook.md) - 5 operations

### `transfers/`

- [AssessmentMaterial API](transfers/assessment-material.md) - 4 operations
- [Material API](transfers/material.md) - 5 operations
- [Sync Materials API](transfers/sync-materials.md) - code-observed frontend hooks
- [Sync](transfers/sync.md) - 2 operations
- [TransferExport API](transfers/transfer-export.md) - 25 operations
- [TransferImport API](transfers/transfer-import.md) - 13 operations

### `users/`

- [Permission API](users/permission.md) - 4 operations
- [Profile API](users/profile.md) - 6 operations
- [Role API](users/role.md) - 6 operations
- [Student API](users/student.md) - 8 operations
- [Teacher API](users/teacher.md) - 10 operations
- [User API](users/user.md) - 6 operations
- [UserHook API](users/user-hook.md) - 5 operations

### Public share

- [Share Public API](share-public.md) - code-observed public share wrapper

