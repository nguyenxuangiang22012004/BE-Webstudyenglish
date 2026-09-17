# Tài Liệu BA Chi Tiết: Course Chat

Status: reviewed
Owner: BA/DEV
Last reviewed: 2026-09-16
Related:
  - src/api/chat.ts
  - src/app/[locale]/student/courses/[id]/chat/page.tsx
  - src/components/features/chat/message-item.tsx
  - src/components/features/chat/FileUploadDialog.tsx
  - docs/test-cases/overview.md

Business rule IDs:
  - CHT-BR-001: Course chat cho phép trao đổi trong phạm vi một course.
  - CHT-BR-002: Tin nhắn có thể gồm text, file, reaction, reply và trạng thái pin nếu API hỗ trợ.
  - CHT-BR-003: Chat realtime cần xử lý trạng thái kết nối và đồng bộ lịch sử tin nhắn.

Product note: Chức năng chat trong khóa học có hoạt động trong code nhưng hiện đang bị ẩn vì sản phẩm chưa dùng. Khi sản phẩm bật lại chức năng này, PM/BA cần review lại nghiệp vụ trước khi dùng tài liệu này làm source of truth cuối cùng.

Review note: Chat là luồng trao đổi trong khóa học giữa giáo viên và học sinh thuộc khóa học. Luồng sử dụng giống nhau: vào khóa học -> mở chat -> trò chuyện/nhắn tin. Quyền xóa tin nhắn thuộc về chủ tin nhắn.

## 1. Khái niệm course chat

Course chat là màn hình trao đổi giữa người học và người dạy trong bối cảnh một khóa học.

Route hiện có:
- `/student/courses/[id]/chat`

## 2. Phạm vi chức năng hiện có

Các chức năng thấy trong code:
- Xem danh sách tin nhắn.
- Gửi tin nhắn text.
- Reply tin nhắn.
- Upload nhiều file đính kèm.
- Hiển thị file trong tin nhắn.
- Thêm hoặc xóa reaction.
- Xóa tin nhắn.
- Pin hoặc bỏ pin tin nhắn.
- Theo dõi kết nối realtime qua SSE.
- Hiển thị trạng thái online/offline của kết nối.

## 3. Quan hệ với các đối tượng khác

- Course: phạm vi phòng chat.
- User: người gửi/nhận tin nhắn.
- File/media: file đính kèm trong tin nhắn.

## 4. Quy tắc nghiệp vụ chính

- Người dùng chỉ được vào chat của course mà họ có quyền truy cập.
- Giáo viên và học sinh trong cùng khóa học dùng chung luồng chat trong khóa học để trao đổi.
- Tin nhắn gửi thất bại cần có trạng thái để người dùng biết và thử lại nếu cần.
- File đính kèm cần tuân thủ rule upload chung.
- Tin nhắn pin cần đồng bộ với danh sách pinned messages.
- Chỉ chủ tin nhắn được xóa tin nhắn của chính mình.
- Khi kết nối realtime mất, UI cần báo trạng thái và vẫn giữ lịch sử đã tải.

## 5. Ghi chú kiểm thử

- Khi bật lại chức năng chat, PM/BA cần review lại nghiệp vụ trước khi release.
- Giới hạn file, độ dài tin nhắn và số reaction phụ thuộc backend/API.
