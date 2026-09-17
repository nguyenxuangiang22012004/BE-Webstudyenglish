# Tài Liệu BA Chi Tiết: Import và Export Dữ Liệu

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-06-12
Related:
  - docs/api/transfers/transfer-export.md
  - docs/api/transfers/transfer-import.md
  - docs/security/rbac-matrix.md
  - docs/test-cases/overview.md

Business rule IDs:
  - TRF-BR-001: Import/export hỗ trợ trao đổi dữ liệu hàng loạt giữa LMS và file bên ngoài.
  - TRF-BR-002: Import cần có cơ chế theo dõi tiến độ và kết quả xử lý.
  - TRF-BR-003: Export phải tôn trọng quyền và phạm vi dữ liệu của người dùng.

## 1. Khái niệm import/export

Import/export là nhóm chức năng dùng để nhập hoặc xuất dữ liệu hệ thống theo file, thường phục vụ vận hành, báo cáo và kiểm thử dữ liệu.

Các nhóm dữ liệu có API import/export gồm:
- Classes
- Questions
- Schools
- Subjects
- Courses
- Users
- Assessments
- Dashboard/report

## 2. Phạm vi chức năng hiện có

API export có nhiều endpoint trong nhóm `/v1/transfer/.../export`.

API import hiện có:
- Import classes
- Import questions
- Import schools
- Import subjects
- Import courses
- Import users
- Import assessments
- Xem danh sách import jobs
- Xem progress của import job

## 3. Quy tắc nghiệp vụ chính

- Người dùng chỉ được import/export module mà role có quyền tương ứng.
- Export cần áp dụng bộ lọc hiện tại nếu UI truyền filter.
- Import cần validate file, schema và dữ liệu bắt buộc trước khi ghi nhận.
- Import job cần có trạng thái để người dùng biết đang xử lý, thành công hay lỗi.
- Lỗi từng dòng nên được trả về đủ thông tin để người dùng sửa file.

## 4. Luồng import tổng quát

1. Người dùng chọn module và tải file lên.
2. Hệ thống validate file.
3. Backend tạo import job.
4. UI theo dõi progress bằng job id hoặc event.
5. Hệ thống hiển thị kết quả thành công/lỗi.

## 5. Luồng export tổng quát

1. Người dùng chọn module hoặc báo cáo cần export.
2. UI gửi filter/scope hiện tại lên API.
3. Backend tạo file export.
4. Người dùng tải file về.

## 6. Ghi chú và điểm cần xác nhận

- Cần xác nhận định dạng file chuẩn cho từng module.
- Cần xác nhận import ghi đè, bỏ qua hay báo lỗi khi dữ liệu trùng.
- Cần xác nhận thời gian lưu file export và import job history.
