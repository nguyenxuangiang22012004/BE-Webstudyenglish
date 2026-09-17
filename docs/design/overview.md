# Design Docs

Status: reviewed
Owner: UX/DEV
Last reviewed: 2026-09-16
Related:
  - docs/ai/documentation-structure.md
  - docs/requirements/overview.md

Folder này chứa tài liệu thiết kế của project.

## Quy ước liên kết với requirements

Mỗi tài liệu design nên khai báo requirement liên quan bằng frontmatter ở đầu file.

Với file overview của một domain:

```md
---
requirement: ../../requirements/learning-materials/vocabulary.md
domain: vocabulary
type: design-overview
---
```

Với file thiết kế từng page:

```md
---
requirement: ../../../requirements/learning-materials/vocabulary.md
domain: vocabulary
page: study-setting
type: page-design
---
```

Nếu một file design phụ thuộc nhiều requirement:

```md
---
requirements:
  - ../../../requirements/learning-materials/vocabulary.md
  - ../../../requirements/programs/course.md
domain: vocabulary
page: study-setting
type: page-design
---
```

## Quy ước đặt file

- Folder domain trong `docs/design/` nên trùng tên với requirement chính, ví dụ `vocabulary/` tương ứng `docs/requirements/learning-materials/vocabulary.md`.
- Page design đặt trong `docs/design/<domain>/pages/`.
- File page dùng kebab-case theo tên page hoặc trạng thái, ví dụ `study-setting.md`, `study-collapsed.md`.
- `overview.md` của domain dùng để mô tả phạm vi thiết kế và liệt kê các page design liên quan.
