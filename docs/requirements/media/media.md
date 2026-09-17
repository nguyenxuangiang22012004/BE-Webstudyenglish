# Tài Liệu BA Chi Tiết: Media và Upload

Status: reviewed
Owner: BA/DEV
Last reviewed: 2026-09-16
Related:
  - docs/api/media/media.md
  - docs/api/media/upload.md
  - src/hooks/use-upload.ts
  - src/api/file.ts
  - src/api/media.ts
  - src/app/[locale]/manage/images/page.tsx
  - docs/security/resources/medias.md
  - docs/test-cases/overview.md

Business rule IDs:
  - MED-BR-001: Media là kho file dùng chung cho nội dung học tập và vận hành.
  - MED-BR-002: Upload file phải đi qua bước presign, tải file và complete.
  - MED-BR-003: File và folder cần được quản lý theo quyền và phạm vi dữ liệu.

Review note: Code hiện tại xác nhận upload dùng flow `presign -> PUT presigned URL/storage -> complete`. Hook dùng chung là `useUpload`; trang quản lý tệp tin dùng XHR để hiển thị progress, gọi `complete`, và có thể poll `/upload/progress/{job_id}`. Giới hạn loại file/dung lượng/số lượng do BE quyết định và hiện chưa rõ trong tài liệu. BE không cho phép xóa folder có file con. File đã gắn vào lesson/question/book thì user vẫn xóa được trong quản lý tệp tin.

## 1. Khái niệm media

Media là nhóm chức năng quản lý file, folder và tài nguyên số trong hệ thống LMS.

Media được dùng cho:
- Hình ảnh minh họa
- Video, audio và file bài giảng
- File đính kèm trong bài học, bài làm hoặc phản hồi
- Tài nguyên dùng lại trong nhiều màn hình

## 2. Phạm vi chức năng hiện có

API media hiện có:
- `GET /v1/medias/folders`
- `POST /v1/medias/folders`
- `DELETE /v1/medias/folders/{folder_id}`
- `GET /v1/medias/files/{folder_id}`
- `DELETE /v1/medias/files/{file_id}`

API upload hiện có:
- `POST /v1/upload/presign`
- `POST /v1/upload/presign-multiple`
- `POST /v1/upload/complete`
- `POST /v1/upload/complete-multiple`
- `GET /v1/upload/progress/{job_id}`

## 3. Quy tắc nghiệp vụ chính

- Người dùng chọn hoặc tải file lên từ các màn hình cần media.
- Upload cần có bước lấy presigned URL trước khi gửi file.
- Sau khi tải file lên storage, client cần gọi complete để backend ghi nhận file.
- Danh sách file có thể lọc theo keyword, thời gian, loại file hoặc extension.
- Trang quản lý tệp tin cho phép user xóa file/folder; backend chịu trách nhiệm kiểm tra quyền và ràng buộc nếu file/folder đang được tham chiếu.
- Backend không cho phép xóa folder có file con.
- File đã được gắn vào lesson/question/book thì user vẫn xóa được trong trang quản lý tệp tin.

## 4. Luồng upload tổng quát

1. Người dùng chọn một hoặc nhiều file.
2. Hệ thống gọi API presign để lấy thông tin upload.
3. Client tải file lên endpoint/storage được cấp.
4. Hệ thống gọi complete hoặc complete-multiple.
5. UI cập nhật danh sách file hoặc gắn file vào entity đang thao tác.

## 5. Ghi chú kiểm thử

- Giới hạn dung lượng, định dạng và số lượng file do BE quyết định; hiện chưa rõ trong tài liệu FE.
- Khi test xóa folder có file con, kỳ vọng backend không cho phép xóa.
- Khi test xóa file đã gắn vào lesson/question/book, kỳ vọng user vẫn xóa được file trong trang quản lý tệp tin.
