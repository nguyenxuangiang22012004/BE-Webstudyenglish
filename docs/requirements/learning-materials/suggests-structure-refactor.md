# Suggests Structure Refactor

Status: needs-review
Owner: DEV
Last reviewed: 2026-09-11
Source: Ghi chú thay đổi cấu trúc dữ liệu; cần đối chiếu type/API hiện tại trước khi dùng làm contract.
Related:
  - docs/requirements/learning-materials/question-bank.md
  - docs/api/learning-materials/question.md
  - src/types
  - src/api

## 📌 Tổng Quan

Cấu trúc của phần `suggests` trong request tạo/sửa question được mở rộng để hỗ trợ **combo suggestions** - những gợi ý phụ liên quan đến từng gợi ý chính.

## 🔄 Thay Đổi So Với Trước

### Cũ (v1)

```json
{
  "suggests": [
    {
      "text": "Gợi ý chính",
      "file_urls": ["url1", "url2"]
    }
  ]
}
```

### Mới (v2)

```json
{
  "suggests": [
    {
      "text": "Gợi ý chính",
      "file_urls": ["url1", "url2"],
      "combos": [
        {
          "combo_text": "Gợi ý combo 1",
          "combo_url": "url_combo_1"
        },
        {
          "combo_text": "Gợi ý combo 2",
          "combo_url": "url_combo_2"
        }
      ]
    }
  ]
}
```

## 📋 Chi Tiết Thay Đổi

### 1. API Interface (`src/api/question.ts`)

- **Trước**: `QuestionSuggest` chỉ có `text` và `file_urls`
- **Sau**: Thêm trường `combos` (optional) chứa mảng các combo suggestions

### 2. Frontend Store (`src/stores/question-store.ts`)

- **Trước**: `QuestionSuggestItem` có `id`, `text`, `medias`
- **Sau**: Thêm trường `combos` chứa `SuggestCombo[]`
  - `SuggestCombo` có: `id`, `text`, `media` (SuggestMedia)

### 3. Conversion Logic (`src/lib/question/convert-to-api-format.ts`)

- Hàm `createSuggestsArray()` được update để convert `combos` từ store thành `combos` trong API payload
- Mỗi combo trong store có media object, khi gửi lên API chỉ lấy URL

### 4. UI Component (`src/components/features/question-editor/question-suggests-editor.tsx`)

- Thêm section để quản lý combo suggestions cho mỗi suggest item
- UI cho phép:
  - Thêm/xóa combo suggestion
  - Chỉnh sửa text của combo
  - Upload/quản lý media cho combo

## 🎯 Tính Năng

| Chức Năng         | Mô Tả                                                       |
| ----------------- | ----------------------------------------------------------- |
| Main Suggests     | Gợi ý chính với text và multiple media files                |
| Combo Suggestions | Sub-suggestions liên quan, mỗi combo có text và 1 media     |
| Optional          | Combo suggestions là tùy chọn (có thể để trống)             |
| Media Management  | Hỗ trợ upload/thêm/xóa media cho cả main suggests và combos |

## 📝 Ví Dụ Cụ Thể

### Gợi ý về Grammar với combo suggestions:

```json
{
  "text": "Hãy ôn tập lại thì Present Perfect",
  "file_urls": ["https://domain/uploads/suggest/present-perfect-overview.png"],
  "combos": [
    {
      "combo_text": "Video hướng dẫn chi tiết",
      "combo_url": "https://domain/uploads/suggest/present-perfect-video.mp4"
    },
    {
      "combo_text": "Bài tập thực hành",
      "combo_url": "https://domain/uploads/suggest/present-perfect-exercises.pdf"
    }
  ]
}
```

## 🔧 Migration Guide

Khi backend API nhận request:

1. Nếu `combos` không có → xử lý như bình thường
2. Nếu `combos` có → lưu thêm các combo suggestions liên kết
3. Khi trả về question detail → cần include cả `combos` nếu có

## ⚠️ Breaking Changes

- Frontend: Cấu trúc store thay đổi, cần update components sử dụng suggests
- API: Nếu backend chưa hỗ trợ `combos` → ignore field này (graceful degradation)
- Database: Nếu cần lưu → cần migration để thêm table/field mới cho combos

## 📊 Affected Files

1. `src/api/question.ts` - Type definitions
2. `src/stores/question-store.ts` - State management
3. `src/lib/question/convert-to-api-format.ts` - Data conversion
4. `src/components/features/question-editor/question-suggests-editor.tsx` - UI
5. `src/app/[locale]/manage/question-bank/create-question/page.tsx` - Main component

## UX Update

- `QuestionSuggestsEditor` supports collapsing and expanding each main suggest item.
- Each combo suggestion also supports collapsing and expanding independently.
- Combo suggestion text uses `RichTextEditor` instead of plain `Input`, matching the main suggest text editing experience.
