# Role: parents

Status: reviewed
Owner: BA/DEV/TEST
Source: Đối chiếu code frontend; role này chưa có trong RBAC dump generated ngày 2026-06-12.
Last reviewed: 2026-09-16
Related:
  - docs/requirements/users/parent.md
  - docs/requirements/users/parent-child-switch-flow.md
  - src/middleware.ts
  - src/app/[locale]/parents/childrens/page.tsx

## Thông tin role

Role `parents` là role chính thức trong sản phẩm. Tuy nhiên nghiệp vụ cuối cùng cho role này chưa được chốt, nên tạm thời chưa cần đưa role này vào RBAC generated.

| Field | Value |
| --- | --- |
| `name` | `parents` |
| `status` | official role, RBAC deferred |
| `source` | Frontend middleware và parent flow |

## Quyền theo code hiện tại

Middleware hiện có:

```ts
roleRedirectMap.parents = '/parents/childrens'
roleAllowedPrefixesMap.parents = ['/parents']
```

Vì vậy, theo frontend routing:

- Role `parents` được điều hướng về `/parents/childrens`.
- Role `parents` được phép truy cập route prefix `/parents`.
- Role `parents` không được map vào `/admin`, `/teacher`, `/student` trừ khi thực hiện flow chuyển session sang tài khoản học sinh.

## API liên quan

- `GET /profile/children`
- `GET /profile/children-token?user_id={childUserId}`

## Ghi chú RBAC

Tài liệu RBAC generated hiện chỉ có các role:

- `admin`
- `teacher`
- `student`
- `school`
- `read only`

Role `parents` là role chính thức, nhưng nghiệp vụ cuối cùng chưa được chốt nên hiện chưa cần RBAC cho role này. File này ghi nhận behavior frontend hiện có để AI không bỏ sót role phụ huynh; khi sản phẩm chốt nghiệp vụ phụ huynh, PM/BA cần review lại quyền và RBAC tương ứng.
