---
status: needs-review
owner: UX/DEV
last_reviewed: 2026-09-11
requirement: ../../../requirements/learning-materials/vocabulary.md
domain: vocabulary
page: study-setting
type: page-design
related:
  - ../../../requirements/learning-materials/vocabulary.md
  - ../overview.md
---

# Trang chủ - Flashcard - Cài đặt

## Requirement liên quan

- `docs/requirements/learning-materials/vocabulary.md`

## 1. Mục đích

Màn hình này mô tả trạng thái người học đang ở tab Flashcard và mở modal cài đặt. Modal cho phép bật/tắt một số tuỳ chọn học flashcard và xem phím tắt thao tác nhanh.

Nội dung flashcard phía sau vẫn hiển thị nhưng bị làm mờ, thể hiện trạng thái nền không còn là vùng tương tác chính.

## 2. Kích thước frame

```text
Frame tham chiếu: 1462 x 1320 px
Nền trang: #FFFFFF
Vùng nội dung chính: căn giữa theo chiều ngang
Modal settings: khoảng 900 x 680 px
```

## 3. Cấu trúc layout tổng thể

```text
TrangChuFlashcardSettings
├── HeaderNavigation (dimmed)
├── LessonHeader (dimmed)
├── ActivityTabs (dimmed)
├── FlashcardStatusRow (dimmed)
├── Flashcard (dimmed)
├── CardActionBar (dimmed)
├── ProgressBar (dimmed/ẩn khỏi ảnh crop)
└── SettingsModal
    ├── ModalHeader
    │   ├── Title: Cài đặt
    │   └── CloseButton
    ├── ToggleRows
    │   ├── Làm bài luyện tập thêm
    │   ├── Phát âm thanh từ tự động
    │   └── Trộn thẻ
    └── ShortcutSection
        ├── Đang học: ←
        ├── Đã nhớ: →
        └── Lật thẻ: Phím cách
```

## 4. Trạng thái nền khi modal mở

```text
UnderlyingPage
├── Opacity: khoảng 35-45%
├── Không nhận click trực tiếp
├── Giữ nguyên layout trước khi mở modal
└── Không dịch chuyển vị trí khi modal xuất hiện
```

Các thành phần nền vẫn nhìn thấy:

| Khu vực | Trạng thái |
|---------|------------|
| Header navigation | mờ, inactive |
| Lesson header | mờ, inactive |
| Activity tabs | mờ, inactive |
| Flashcard | mờ, inactive |
| Action bar | mờ, inactive |

## 5. Activity tabs phía sau modal

Trong ảnh trạng thái cài đặt, tab bar có 3 mục:

| Tab | Text | State |
|-----|------|-------|
| Video lesson | Video lesson | default, dimmed |
| Flashcard | Flashcard | active, dimmed |
| Exercise | Exercise | default, dimmed |

```text
Tab container:
├── Width: khoảng 675 px
├── Height: 68 px
├── Background: #F0F0F0
├── Border radius: 8 px
└── Opacity giảm theo trạng thái modal

Active Flashcard tab:
├── Background: #D9D9D9
├── Size: khoảng 203 x 44 px
└── Radius: 8 px
```

## 6. Settings modal

### 6.1 Container

```text
SettingsModal
├── Width: khoảng 900 px
├── Height: khoảng 680 px
├── Background: #D9D9D9
├── Border radius: 0 px theo wireframe
├── Position: center theo viewport
├── Top: khoảng 320 px từ đỉnh frame
├── Z-index: cao nhất trong page
└── Không có shadow rõ ràng trong wireframe
```

### 6.2 Padding

```text
Padding left: khoảng 50 px
Padding right: khoảng 32 px
Padding top: khoảng 34 px
Padding bottom: khoảng 44 px
```

## 7. Modal header

```text
ModalHeader
├── Layout: horizontal
├── Title nằm trái
└── CloseButton nằm góc phải trên
```

### 7.1 Title

```text
Text: "Cài đặt"
Font: 48-50 px, bold
Color: #000000
Line height: khoảng 58 px
```

### 7.2 Close button

```text
CloseButton
├── Icon: circle x / close
├── Size: khoảng 44 x 44 px
├── Stroke: #000000
├── Position: top right trong modal
├── Top: khoảng 24 px
├── Right: khoảng 32 px
└── Click: đóng modal, quay lại flashcard collapsed
```

## 8. Toggle rows

### 8.1 Layout chung

```text
ToggleRows
├── Margin top từ title: khoảng 42 px
├── Row gap: khoảng 58-66 px
└── Toggle align theo cùng một cột bên phải
```

### 8.2 Row detail

| Row | Label | Font | Toggle state |
|-----|-------|------|--------------|
| 1 | Làm bài luyện tập thêm | 31-32 px regular | on |
| 2 | Phát âm thanh từ tự động | 31-32 px regular | on |
| 3 | Trộn thẻ | 31-32 px regular | on |

```text
Label:
├── Color: #000000
└── Align left

Toggle:
├── Width: khoảng 112 px
├── Height: khoảng 36 px
├── Track background: #F2F2F2
├── Thumb: circle #4F4F4F
├── Thumb size: khoảng 40 x 40 px
├── Thumb position: right khi ON
└── Border radius track: 18 px
```

## 9. Shortcut section

### 9.1 Container

```text
ShortcutSection
├── Margin top từ toggle rows: khoảng 62 px
├── Title: "Phím tắt"
└── Danh sách 3 shortcut
```

### 9.2 Section title

```text
Text: "Phím tắt"
Font: 31-32 px regular
Color: #000000
```

### 9.3 Shortcut rows

| Action | Key label | Ý nghĩa |
|--------|-----------|---------|
| Đang học | ← | đánh dấu thẻ hiện tại là đang học |
| Đã nhớ | → | đánh dấu thẻ hiện tại là đã nhớ |
| Lật thẻ | Phím cách | lật mặt flashcard |

```text
ShortcutRows
├── Margin top từ title: khoảng 24 px
├── Row height: khoảng 44 px
├── Label column x: khoảng 80 px từ mép trái modal
├── Key column x: khoảng 270 px từ mép trái modal
└── Row gap: khoảng 10-12 px
```

### 9.4 Shortcut label

```text
Action label:
├── Font: 23-24 px regular
├── Color: #000000
└── Align left
```

### 9.5 Key badge

```text
Arrow key badge:
├── Size: khoảng 32 x 28 px
├── Border: 1 px #000000
├── Background: transparent hoặc #D9D9D9
├── Font: 20 px regular
└── Text align center

Space key badge:
├── Width: khoảng 88 px
├── Height: khoảng 26 px
├── Border: 1 px #000000
├── Text: "Phím cách"
├── Font: 15-16 px regular
└── Text align center
```

## 10. Card action bar phía sau

```text
CardActionBar
├── Opacity giảm theo modal
├── Center counter: "1/12"
├── Left action: Đang học
├── Right action: Đã nhớ
├── Gear icon vẫn thấy ở nền nhưng inactive
└── Fullscreen icon vẫn thấy ở nền nhưng inactive
```

Khi modal mở, gear icon không mở thêm modal mới; chỉ modal hiện tại nhận tương tác.

## 11. Màu sắc

| Token | Giá trị | Dùng cho |
|-------|---------|----------|
| `pageBackground` | `#FFFFFF` | nền toàn trang |
| `primaryText` | `#000000` | text chính, icon |
| `dimmedText` | `#8F8F8F` | text nền khi modal mở |
| `modalBackground` | `#D9D9D9` | nền modal |
| `toggleTrack` | `#F2F2F2` | track toggle |
| `toggleThumb` | `#4F4F4F` | nút tròn toggle |
| `flashcardBackground` | `#F2F2F2` | card nền phía sau |
| `activeControl` | `#D9D9D9` | tab active, badge, hint bar |

## 12. Typography

| Thành phần | Font size | Weight |
|------------|-----------|--------|
| Modal title | 48-50 px | bold |
| Toggle label | 31-32 px | regular |
| Shortcut title | 31-32 px | regular |
| Shortcut action | 23-24 px | regular |
| Key badge arrow | 20 px | regular |
| Key badge space | 15-16 px | regular |
| Background page text | giữ size gốc, giảm opacity | theo state gốc |

## 13. Trạng thái

### 13.1 Modal

| State | Mô tả |
|-------|-------|
| closed | không hiển thị modal, page flashcard hoạt động bình thường |
| open | hiển thị modal, nền dimmed và inactive |

### 13.2 Toggle

| State | Track | Thumb | Thumb position |
|-------|-------|-------|----------------|
| on | #F2F2F2 | #4F4F4F | right |
| off | #F2F2F2 hoặc #E5E5E5 | #9A9A9A | left |

Ảnh hiện tại thể hiện cả 3 toggle đang ở trạng thái `on`.

### 13.3 Keyboard shortcuts

| Phím | Điều kiện hoạt động |
|------|---------------------|
| ← | hoạt động khi modal đóng; trong modal chỉ hiển thị hướng dẫn |
| → | hoạt động khi modal đóng; trong modal chỉ hiển thị hướng dẫn |
| Space | hoạt động khi modal đóng; trong modal chỉ hiển thị hướng dẫn |
| Esc | nên đóng modal nếu được hỗ trợ |

## 14. Tương tác

| Trigger | Kết quả |
|---------|---------|
| Bấm gear trong flashcard action bar | mở SettingsModal |
| Bấm close icon | đóng SettingsModal |
| Bấm ngoài modal | có thể đóng modal nếu product yêu cầu; wireframe chưa thể hiện rõ |
| Bấm toggle `Làm bài luyện tập thêm` | bật/tắt thêm bài luyện tập sau flashcard |
| Bấm toggle `Phát âm thanh từ tự động` | bật/tắt tự động phát âm thanh khi chuyển thẻ |
| Bấm toggle `Trộn thẻ` | bật/tắt shuffle thứ tự flashcard |
| Nhấn Esc | đóng modal nếu có hỗ trợ keyboard |

## 15. Dữ liệu cần hiển thị

```json
{
  "settings": {
    "extraPracticeEnabled": true,
    "autoPlayAudioEnabled": true,
    "shuffleCardsEnabled": true
  },
  "shortcuts": [
    {
      "action": "Đang học",
      "key": "ArrowLeft"
    },
    {
      "action": "Đã nhớ",
      "key": "ArrowRight"
    },
    {
      "action": "Lật thẻ",
      "key": "Space"
    }
  ],
  "modal": {
    "isOpen": true,
    "title": "Cài đặt"
  }
}
```

## 16. Ghi chú implementation

- Nên dựng modal bằng component riêng: `FlashcardSettingsModal`.
- Khi modal mở, khóa tương tác của flashcard phía sau bằng overlay hoặc state `isSettingsOpen`.
- Overlay trong wireframe không tối màu rõ ràng; hiệu ứng chính là giảm opacity toàn bộ nền.
- Toggle nên là custom switch để khớp wireframe thay vì dùng checkbox mặc định.
- Close icon cần vùng click lớn hơn icon thật, tối thiểu 44 x 44 px.
- Nếu có keyboard support, ưu tiên `Esc` để đóng modal; các phím `←`, `→`, `Space` không nên tác động thẻ khi modal đang focus.
- Nếu người dùng bật/tắt `Trộn thẻ`, cần quyết định áp dụng ngay cho deck hiện tại hay áp dụng từ lượt học kế tiếp.
