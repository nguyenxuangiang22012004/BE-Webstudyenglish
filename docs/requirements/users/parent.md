# Tài liệu BA chi tiết: Phụ huynh

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-09-16
Source: Đối chiếu code `src/app/[locale]/parents/childrens/page.tsx`, `src/api/user.ts`, `src/middleware.ts`, `src/components/features/users/UserForm.tsx` và ghi chú `docs/requirements/users/parent-child-switch-flow.md`.
Related:
  - docs/requirements/users/parent-child-switch-flow.md
  - docs/requirements/users/user.md
  - docs/api/users/user.md
  - docs/security/roles/parents.md
  - src/app/[locale]/parents/childrens/page.tsx

Review note: Đã xác nhận phụ huynh dùng `GET /profile/children`, có thể lấy token tài khoản con và chuyển session sang học sinh. Vẫn giữ `needs-review` vì nghiệp vụ cuối cùng của role `parents` chưa chốt.

Business rule IDs:
  - PAR-BR-001: Phụ huynh là user có role `parents` trong frontend routing.
  - PAR-BR-002: Phụ huynh có thể liên kết với một hoặc nhiều tài khoản học sinh.
  - PAR-BR-003: Phụ huynh có thể lấy token tài khoản con và chuyển phiên sang vai trò học sinh.
  - PAR-BR-004: Phụ huynh chỉ được truy cập tài khoản con đã được liên kết.

## 1. Khái niệm phụ huynh

Phụ huynh là người dùng theo dõi việc học của con thông qua tài khoản học sinh được liên kết.

Trong code hiện tại:

- Middleware điều hướng `parents` tới `/parents/childrens`.
- Trang phụ huynh gọi API lấy danh sách con.
- Phụ huynh có thể chọn một học sinh và chuyển session sang tài khoản học sinh.

## 2. Phạm vi chức năng hiện có

Route hiện có:

```text
/{locale}/parents/childrens
```

Các thao tác đang có:

- Xem danh sách tài khoản con.
- Lấy token của tài khoản con.
- Xác nhận chuyển vào tài khoản học sinh.
- Clear session phụ huynh và set session học sinh.
- Điều hướng sang `/{locale}/student/assignments`.
- Đăng xuất khỏi khu vực phụ huynh.

## 3. API liên quan

Frontend đang dùng:

- `GET /profile/children`
- `GET /profile/children-token?user_id={childUserId}`

User API cũng có các trường/liên kết liên quan:

- `parent_id`
- `children_ids`
- `children`
- `parent_children`

## 4. Quan hệ với đối tượng khác

### 4.1. Quan hệ với học sinh

Một phụ huynh có thể liên kết với nhiều học sinh.

Một học sinh có thể có `parent_id` hoặc nằm trong danh sách `children` của phụ huynh tùy theo API trả về.

### 4.2. Quan hệ với session

Khi phụ huynh chuyển vào tài khoản con, frontend:

- Xóa token/session phụ huynh.
- Set token của học sinh.
- Set `userType = student`.
- Điều hướng sang màn học sinh.

### 4.3. Quan hệ với quyền

Phụ huynh hiện được middleware cho phép truy cập prefix `/parents`.

RBAC generated hiện chưa có role `parents` trong `docs/security/roles/`; tài liệu `docs/security/roles/parents.md` là bản bổ sung theo code, không phải bản sinh từ RBAC dump.

## 5. Quy tắc nghiệp vụ

- Phụ huynh chỉ thấy các tài khoản con được backend trả về từ `/profile/children`.
- Phụ huynh chỉ được lấy token cho học sinh thuộc danh sách con của mình.
- Khi chuyển sang tài khoản con, hệ thống cần đảm bảo token phụ huynh cũ không còn được dùng.
- Cần hiển thị rõ phụ huynh đang chuẩn bị vào tài khoản học sinh nào trước khi xác nhận.
- Cần có đường quay lại tài khoản phụ huynh nếu sản phẩm yêu cầu; hiện flow code đang chuyển hẳn sang session học sinh.

## 6. Điểm cần xác nhận

- Một học sinh có thể liên kết nhiều phụ huynh hay chỉ một `parent_id`.
- Có cần phụ huynh xem báo cáo riêng mà không chuyển sang tài khoản học sinh hay không.
- Có cần audit log khi phụ huynh vào tài khoản con hay không.
- Có cần giới hạn hành động khi phụ huynh đang dùng session học sinh hay được toàn quyền như học sinh.
