# Role: teacher

Status: generated
Owner: BA/DEV/TEST
Source: Response phân quyền do user cung cấp trong chat ngày 2026-06-12
Related role ID: `2`

## Thông tin role

| Field | Value |
| --- | --- |
| `id` | `2` |
| `name` | `teacher` |
| `status` | `False` |
| `default_page_view` | `` |
| `default_page_id` | `0` |
| `created_at` | `` |
| `updated_at` | `` |

## Permissions

| Resource | Actions allowed | Actions denied/empty |
| --- | --- | --- |
| [`assessment-criteria`](../resources/assessment-criteria.md) | `index`, `show` | `destroy`, `store`, `update` |
| [`assessment-criteria-groups`](../resources/assessment-criteria-groups.md) | `index`, `show` | `destroy`, `store`, `update` |
| [`assessment-subcriteria`](../resources/assessment-subcriteria.md) | `index`, `show` | `destroy`, `store`, `update` |
| [`assessments`](../resources/assessments.md) | `index`, `show`, `update` | `destroy`, `store` |
| [`books`](../resources/books.md) | `index`, `show` | `destroy`, `store`, `update` |
| [`certificates`](../resources/certificates.md) | `destroy`, `index`, `show`, `store`, `update` | `restore` |
| [`chapters`](../resources/chapters.md) | `index`, `show` | `destroy`, `restore`, `store`, `update` |
| [`classes`](../resources/classes.md) | `index`, `show` | `destroy`, `export`, `import`, `restore`, `store`, `update` |
| [`contest_rounds`](../resources/contest-rounds.md) | `index`, `show` | `destroy`, `restore`, `store`, `update` |
| [`contests`](../resources/contests.md) | `index`, `show` | `destroy`, `restore`, `store`, `update` |
| [`courses`](../resources/courses.md) | `index`, `show` | `destroy`, `export`, `import`, `restore`, `store`, `update` |
| [`degrees`](../resources/degrees.md) | `index`, `show` | `destroy`, `restore`, `store`, `update` |
| [`departments`](../resources/departments.md) | `index`, `show` | `destroy`, `restore`, `store`, `update` |
| [`employee-positions`](../resources/employee-positions.md) | `index`, `show` | `destroy`, `restore`, `store`, `update` |
| [`exams`](../resources/exams.md) | `index`, `show`, `update` | `destroy`, `store` |
| [`exercises`](../resources/exercises.md) | `index`, `show`, `update` | `destroy`, `store` |
| [`faculties`](../resources/faculties.md) | `index`, `show` | `destroy`, `export`, `import`, `restore`, `store`, `update` |
| [`grades`](../resources/grades.md) | `index`, `show` | `destroy`, `restore`, `store` |
| [`headings`](../resources/headings.md) | `index`, `show` | `destroy`, `store`, `update` |
| [`holidays`](../resources/holidays.md) | `index`, `show` | `destroy`, `store`, `update` |
| [`homeworks`](../resources/homeworks.md) | `index`, `show`, `update` | `destroy`, `store` |
| [`interactive/contents`](../resources/interactive-contents.md) | `index`, `show` | `destroy`, `store`, `update` |
| [`internal`](../resources/internal.md) | - | `command` |
| [`lesson-plan-parts`](../resources/lesson-plan-parts.md) | `index`, `show`, `update` | `destroy`, `store` |
| [`lesson-plans`](../resources/lesson-plans.md) | `index`, `show`, `update` | `destroy`, `store` |
| [`lesson_schedule`](../resources/lesson-schedule.md) | `store` | - |
| [`lessons`](../resources/lessons.md) | `index`, `show` | `destroy`, `restore`, `store`, `update` |
| [`medias`](../resources/medias.md) | `update` | - |
| [`meetings`](../resources/meetings.md) | `store` | - |
| [`notices`](../resources/notices.md) | `index`, `show` | `destroy`, `store`, `update` |
| [`permissions`](../resources/permissions.md) | `show` | `update` |
| [`programs`](../resources/programs.md) | `index`, `show`, `store`, `update` | `destroy`, `export`, `import` |
| [`question-attributes`](../resources/question-attributes.md) | `index`, `show` | `destroy`, `restore`, `store`, `update` |
| [`questions`](../resources/questions.md) | `destroy`, `export`, `import`, `index`, `restore`, `show`, `store`, `update` | - |
| [`roles`](../resources/roles.md) | `index`, `show` | `destroy`, `store`, `update` |
| [`schools`](../resources/schools.md) | `index`, `show` | `destroy`, `export`, `import`, `restore`, `store`, `update` |
| [`semesters`](../resources/semesters.md) | `index`, `show` | `destroy`, `store`, `update` |
| [`settings`](../resources/settings.md) | `index`, `show` | `destroy`, `store`, `update` |
| [`skills`](../resources/skills.md) | `index`, `show` | `destroy`, `restore`, `store`, `update` |
| [`source-questions`](../resources/source-questions.md) | `index`, `show` | `destroy`, `restore`, `store`, `update` |
| [`study-report-criterias`](../resources/study-report-criterias.md) | `index`, `show` | `destroy`, `store`, `update` |
| [`study-reports`](../resources/study-reports.md) | `index`, `show` | `destroy`, `store`, `update` |
| [`study-shifts`](../resources/study-shifts.md) | `index`, `show` | `destroy`, `restore`, `store`, `update` |
| [`subjects`](../resources/subjects.md) | `index`, `show` | `destroy`, `export`, `import`, `restore`, `store`, `update` |
| [`tags`](../resources/tags.md) | `index`, `show` | `destroy`, `restore`, `store`, `update` |
| [`teaching-plans`](../resources/teaching-plans.md) | `approve`, `destroy`, `index`, `show`, `store`, `update` | - |
| [`topics`](../resources/topics.md) | `index`, `show` | `destroy`, `restore`, `store`, `update` |
| [`training-levels`](../resources/training-levels.md) | `index`, `show` | `destroy`, `store`, `update` |
| [`users`](../resources/users.md) | `destroy`, `export`, `import`, `index`, `show`, `store`, `update` | - |
| [`vsteps`](../resources/vsteps.md) | `index`, `show` | `destroy`, `store`, `update` |
