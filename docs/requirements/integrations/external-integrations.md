# Tài Liệu BA Chi Tiết: Tích Hợp Ngoài và AI

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-09-16
Related:
  - docs/api/integrations/ai-grading.md
  - docs/api/integrations/elsa.md
  - docs/api/integrations/speechace.md
  - docs/api/integrations/language-confidence.md
  - docs/api/integrations/languagetool.md
  - docs/api/integrations/google.md
  - docs/api/integrations/microsoft.md
  - docs/test-cases/overview.md

Business rule IDs:
  - INT-BR-001: Tích hợp ngoài mở rộng khả năng chấm điểm, luyện phát âm, kiểm tra ngôn ngữ và xử lý nội dung.
  - INT-BR-002: Client không nên gọi trực tiếp provider nếu hệ thống đã có proxy backend.
  - INT-BR-003: Lỗi provider ngoài phải được xử lý rõ ràng và không làm mất dữ liệu học tập chính.

Review note: Provider production hiện chưa được xác nhận. Cần DEV/PM xác định provider nào đang dùng thật trong production trước khi chuyển tài liệu này sang reviewed.

## 1. Khái niệm tích hợp ngoài

Tích hợp ngoài là nhóm chức năng kết nối LMS với dịch vụ bên ngoài hoặc dịch vụ AI để xử lý tác vụ chuyên biệt.

Các nhóm hiện diện trong API/code gồm:
- AI Grading
- ELSA
- Speechace
- Language Confidence
- LanguageTool
- Google/Microsoft integration
- PHX integration

## 2. Phạm vi chức năng hiện có

Một số dịch vụ được expose dưới dạng proxy:
- `POST /v1/elsa`
- `POST /v1/speechace`
- `POST /v1/language-confidence`

Các API khác nằm trong nhóm integration tương ứng và cần đối chiếu thêm từng file API.

## 3. Use case chính

- Chấm hoặc hỗ trợ chấm nội dung tự luận/nói.
- Đánh giá phát âm hoặc độ tự tin ngôn ngữ.
- Kiểm tra lỗi ngôn ngữ.
- Gửi payload tới provider ngoài qua backend proxy.
- Nhận kết quả provider để hiển thị trong bài làm, bài chấm hoặc màn hình chuyên biệt.

## 4. Quy tắc nghiệp vụ chính

- Tích hợp ngoài phải có trạng thái loading, success và error rõ ràng.
- Nếu provider lỗi, hệ thống không được làm mất bài làm hoặc dữ liệu đã lưu.
- Kết quả provider cần được gắn với đúng user, bài làm, câu hỏi hoặc phiên xử lý.
- Dữ liệu nhạy cảm gửi sang provider cần tuân thủ cấu hình môi trường và chính sách backend.

## 5. Ghi chú và điểm cần xác nhận

- Cần xác nhận provider nào đang dùng trong production.
- Cần xác nhận dữ liệu nào được phép gửi ra dịch vụ ngoài.
- Cần xác nhận retry, timeout và fallback khi provider không phản hồi.
- Cần xác nhận kết quả AI/provider có được lưu lại hay chỉ hiển thị tạm thời.
