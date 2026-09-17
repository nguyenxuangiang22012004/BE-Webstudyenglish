# RBAC Matrix

Status: generated
Owner: BA/DEV/TEST
Source: Response phân quyền do user cung cấp trong chat ngày 2026-06-12
Generated at: 2026-06-12 +07:00
Last reviewed: 2026-09-11
Related:
  - docs/security/overview.md
  - docs/requirements/users/permission.md
  - docs/api/users/permission.md

## Cách đọc

- `Y`: role có quyền thực hiện action trên resource.
- `-`: role không có quyền hoặc action không được khai báo.

## `assessment-criteria`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | - | - | Y | - |

## `assessment-criteria-groups`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | - | - | Y | - |

## `assessment-subcriteria`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | - | - | Y | - |

## `assessments`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | Y | - | Y | - |

## `books`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | - | - | Y | - |

## `certificates`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | Y | - | Y | - |
| `index` | Y | Y | - | Y | Y |
| `restore` | Y | - | - | Y | - |
| `show` | Y | Y | - | Y | Y |
| `store` | Y | Y | - | Y | - |
| `update` | Y | Y | - | Y | - |

## `chapters`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `restore` | Y | - | - | Y | - |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | - | - | Y | - |

## `classes`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `export` | Y | - | - | Y | - |
| `import` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `restore` | Y | - | - | Y | - |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | - | - | Y | - |

## `contest_rounds`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `restore` | Y | - | - | Y | - |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | - | - | Y | - |

## `contests`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `restore` | Y | - | - | Y | - |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | - | - | Y | - |

## `courses`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `export` | Y | - | - | Y | - |
| `import` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `restore` | Y | - | - | Y | - |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | - | - | Y | - |

## `degrees`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `index` | Y | Y | - | Y | Y |
| `restore` | Y | - | - | Y | - |
| `show` | Y | Y | - | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | - | - | Y | - |

## `departments`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `index` | Y | Y | - | Y | Y |
| `restore` | Y | - | - | Y | - |
| `show` | Y | Y | - | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | - | - | Y | - |

## `employee-positions`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `index` | Y | Y | - | Y | Y |
| `restore` | Y | - | - | Y | - |
| `show` | Y | Y | - | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | - | - | Y | - |

## `exams`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | - | - |
| `index` | Y | Y | Y | Y | Y |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | - | - |
| `update` | Y | Y | - | - | - |

## `exercises`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | Y | - | Y | - |

## `faculties`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `export` | Y | - | - | Y | - |
| `import` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `restore` | Y | - | - | Y | - |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | - | - | Y | - |

## `grades`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `restore` | Y | - | - | Y | - |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |

## `headings`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | - | - | Y | - |

## `holidays`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | - | - | Y | - |

## `homeworks`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | Y | - | Y | - |

## `interactive/contents`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | - | - | Y | - |

## `internal`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `command` | Y | - | - | - | - |

## `lesson-plan-parts`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | Y | - | Y | - |

## `lesson-plans`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | Y | - | Y | - |

## `lesson_schedule`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `store` | Y | Y | Y | Y | Y |

## `lessons`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `restore` | Y | - | - | Y | - |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | - | - | Y | - |

## `medias`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `update` | Y | Y | Y | Y | - |

## `meetings`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `store` | Y | Y | - | Y | - |

## `notices`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | - | - | Y | - |

## `permissions`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `show` | Y | Y | Y | - | Y |
| `update` | Y | - | - | - | - |

## `programs`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | - | - |
| `export` | Y | - | - | - | - |
| `import` | Y | - | - | - | - |
| `index` | Y | Y | - | Y | Y |
| `show` | Y | Y | - | Y | Y |
| `store` | Y | Y | - | - | - |
| `update` | Y | Y | - | - | - |

## `question-attributes`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `restore` | Y | - | - | Y | - |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | - | - | Y | - |

## `questions`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | Y | - | - | - |
| `export` | Y | Y | - | - | - |
| `import` | Y | Y | - | - | - |
| `index` | Y | Y | Y | Y | Y |
| `restore` | Y | Y | - | - | - |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | Y | - | - | - |
| `update` | Y | Y | - | - | - |

## `roles`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | - | - |
| `index` | Y | Y | Y | - | Y |
| `show` | Y | Y | Y | - | Y |
| `store` | Y | - | - | - | - |
| `update` | Y | - | - | - | - |

## `schools`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `export` | Y | - | - | Y | - |
| `import` | Y | - | - | Y | - |
| `index` | Y | Y | - | Y | Y |
| `restore` | Y | - | - | Y | - |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | - | - | Y | - |

## `semesters`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | - | - | Y | - |

## `settings`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | - | - |
| `index` | Y | Y | Y | Y | Y |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | - | - |
| `update` | Y | - | - | - | - |

## `skills`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `restore` | Y | - | - | Y | - |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | - | - | Y | - |

## `source-questions`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `restore` | Y | - | - | Y | - |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | - | - | Y | - |

## `study-report-criterias`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | - | - | Y | - |

## `study-reports`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | - | - | Y | - |

## `study-shifts`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `restore` | Y | - | - | Y | - |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | - | - | Y | - |

## `subjects`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `export` | Y | - | - | Y | - |
| `import` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `restore` | Y | - | - | Y | - |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | - | - | Y | - |

## `tags`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `restore` | Y | - | - | Y | - |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | - | - | Y | - |

## `teaching-plans`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `approve` | Y | Y | - | Y | - |
| `destroy` | Y | Y | - | Y | - |
| `index` | Y | Y | - | Y | Y |
| `show` | Y | Y | - | Y | Y |
| `store` | Y | Y | - | Y | - |
| `update` | Y | Y | - | Y | - |

## `topics`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `restore` | Y | - | - | Y | - |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | - | - | Y | - |

## `training-levels`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | - | - | Y | - |

## `users`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | Y | - | Y | - |
| `export` | Y | Y | - | Y | - |
| `import` | Y | Y | - | Y | - |
| `index` | Y | Y | - | Y | Y |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | Y | Y | Y | - |
| `update` | Y | Y | Y | Y | - |

## `vsteps`

| Action | admin | teacher | student | school | read only |
| --- | --- | --- | --- | --- | --- |
| `destroy` | Y | - | - | Y | - |
| `index` | Y | Y | Y | Y | Y |
| `show` | Y | Y | Y | Y | Y |
| `store` | Y | - | - | Y | - |
| `update` | Y | - | - | Y | - |
