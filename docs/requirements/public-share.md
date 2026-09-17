# Public Share Links

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-09-12
Source:
  - src/api/share-public.ts
Related:
  - docs/api/share-public.md
  - docs/requirements/users/profile.md
  - docs/requirements/reports/student-progress-ranking.md
  - docs/security/overview.md

## 1. Purpose

Public share links allow selected LMS data to be opened through a share `key` without using the normal authenticated API helper.

This flow is used for sharing limited user, school, study report, and student assessment dashboard data outside the signed-in LMS session.

## 2. Current frontend surface

The current frontend API wrapper exposes:

- Shared user profile: `GET /share/profile?key=...`
- Shared school detail: `GET /share/schools/{schoolId}?key=...`
- Shared study report detail: `GET /share/study-reports/{id}?key=...`
- Shared student assessment dashboard: `GET /share/dashboard/student/assessments?...&key=...`

The wrapper uses a public axios instance with `API_CONFIG.BASE_URL`, timeout, and JSON content type. It does not use the authenticated `apiHelper` flow.

## 3. Business rules

- `key` is required for every public share request.
- Shared responses must be limited to the data intended for public viewing.
- The share key must define the effective access scope; the frontend should not assume normal user session permissions.
- Public share pages should avoid exposing admin-only controls, mutation actions, or internal identifiers unless required by the shared view.
- Missing, expired, invalid, or revoked keys should be handled as access-denied or not-found states.

## 4. Security notes

- Treat public share links as sensitive URLs.
- Do not log share keys in user-visible error messages.
- Do not mix public share responses with authenticated state unless the screen explicitly supports both contexts.
- Backend must enforce ownership, expiry, revocation, and field-level filtering.

## 5. Open questions

- What is the official expiry policy for share keys?
- Can a share key be revoked manually?
- Which roles can create or distribute public share links?
- Are shared study reports visible to parents, external users, or only users with the link?

