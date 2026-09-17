# SchoolYear API

Status: reviewed
Owner: DEV/TEST
Last reviewed: 2026-09-16
Source: Đối chiếu frontend API wrapper `src/api/school-years.ts`; chưa thấy file Swagger generated tương ứng trong `docs/api/`.
Review note: API school years đã được xác nhận đang đúng với BE.
Related:
  - docs/requirements/semesters/school-year.md
  - src/api/school-years.ts
  - src/app/[locale]/admin/school-years/page.tsx

Tài liệu này mô tả các endpoint năm học đang được frontend gọi.

## Endpoints

### `GET /school-years`

Lấy danh sách năm học.

#### Query params

| Name | Required | Description |
| --- | --- | --- |
| `page` | No | Trang hiện tại. |
| `limit` | No | Số bản ghi mỗi trang. |
| `keyword` | No | Từ khóa tìm kiếm. |

#### Response shape frontend expects

```ts
{
  school_years: SchoolYear[]
  total_count: string | number
}
```

### `GET /school-years/{id}`

Lấy chi tiết năm học.

#### Path params

| Name | Required | Description |
| --- | --- | --- |
| `id` | Yes | ID năm học. |

#### Response shape frontend expects

```ts
{
  id: string | number
  name: string
  start_date: string
  end_date: string
  close_course_date?: string
  created_at: string
  updated_at: string
}
```

### `POST /school-years`

Tạo năm học mới.

#### Request body

```ts
{
  name: string
  start_date: string
  end_date: string
}
```

### `PUT /school-years/{id}`

Cập nhật năm học.

#### Request body

```ts
{
  name?: string
  start_date?: string
  end_date?: string
  close_course_date?: string
}
```

### `DELETE /school-years/{id}`

Xóa năm học.

## Ghi chú

- Frontend form đang convert ngày nhập từ input date sang ISO string.
- `close_course_date` có trong type update/detail nhưng chưa xuất hiện trong form tạo/sửa cơ bản.
- Cần đối chiếu Swagger/backend để xác nhận prefix `/v1` và rule validate chính thức.
