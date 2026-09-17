# Security Documentation

Status: generated
Owner: BA/DEV/TEST
Source: Response phân quyền do user cung cấp trong chat ngày 2026-06-12
Generated at: 2026-06-12 +07:00
Last reviewed: 2026-09-11
Related:
  - docs/security/rbac-matrix.md
  - docs/requirements/users/permission.md
  - docs/api/users/permission.md

## Mục đích

Folder này chứa tài liệu phân quyền RBAC được bóc tách từ response `role_permissions` và `permissions` để BA, DEV và AI Tester tra cứu quyền theo role hoặc theo resource.

Ghi chú: tài liệu này phản ánh response phân quyền được cung cấp, chưa thay thế việc đối chiếu với code hiện tại, API contract hoặc cấu hình backend.

## Tổng quan dữ liệu

- Số role trong RBAC dump: 5
- Số resource: 50
- Actions: `approve`, `command`, `destroy`, `export`, `import`, `index`, `restore`, `show`, `store`, `update`

Ghi chú: code frontend hiện có role `parents`, nhưng role này không nằm trong RBAC dump generated ngày 2026-06-12. Xem thêm [parents](roles/parents.md).

## Cấu trúc

- [RBAC Matrix](rbac-matrix.md): bảng quyền tổng hợp theo resource/action/role.
- `roles/`: tài liệu quyền theo từng role.
- `resources/`: tài liệu quyền theo từng resource.

## Roles

- [admin](roles/admin.md)
- [teacher](roles/teacher.md)
- [student](roles/student.md)
- [school](roles/school.md)
- [read only](roles/read-only.md)
- [parents](roles/parents.md) — needs-review, bổ sung theo code frontend

## Resources

- [assessment-criteria](resources/assessment-criteria.md)
- [assessment-criteria-groups](resources/assessment-criteria-groups.md)
- [assessment-subcriteria](resources/assessment-subcriteria.md)
- [assessments](resources/assessments.md)
- [books](resources/books.md)
- [certificates](resources/certificates.md)
- [chapters](resources/chapters.md)
- [classes](resources/classes.md)
- [contest_rounds](resources/contest-rounds.md)
- [contests](resources/contests.md)
- [courses](resources/courses.md)
- [degrees](resources/degrees.md)
- [departments](resources/departments.md)
- [employee-positions](resources/employee-positions.md)
- [exams](resources/exams.md)
- [exercises](resources/exercises.md)
- [faculties](resources/faculties.md)
- [grades](resources/grades.md)
- [headings](resources/headings.md)
- [holidays](resources/holidays.md)
- [homeworks](resources/homeworks.md)
- [interactive/contents](resources/interactive-contents.md)
- [internal](resources/internal.md)
- [lesson-plan-parts](resources/lesson-plan-parts.md)
- [lesson-plans](resources/lesson-plans.md)
- [lesson_schedule](resources/lesson-schedule.md)
- [lessons](resources/lessons.md)
- [medias](resources/medias.md)
- [meetings](resources/meetings.md)
- [notices](resources/notices.md)
- [permissions](resources/permissions.md)
- [programs](resources/programs.md)
- [question-attributes](resources/question-attributes.md)
- [questions](resources/questions.md)
- [roles](resources/roles.md)
- [schools](resources/schools.md)
- [semesters](resources/semesters.md)
- [settings](resources/settings.md)
- [skills](resources/skills.md)
- [source-questions](resources/source-questions.md)
- [study-report-criterias](resources/study-report-criterias.md)
- [study-reports](resources/study-reports.md)
- [study-shifts](resources/study-shifts.md)
- [subjects](resources/subjects.md)
- [tags](resources/tags.md)
- [teaching-plans](resources/teaching-plans.md)
- [topics](resources/topics.md)
- [training-levels](resources/training-levels.md)
- [users](resources/users.md)
- [vsteps](resources/vsteps.md)
