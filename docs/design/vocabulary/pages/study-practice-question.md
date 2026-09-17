---
status: needs-review
owner: UX/DEV
last_reviewed: 2026-09-11
requirement: ../../../requirements/learning-materials/vocabulary.md
domain: vocabulary
page: study-practice-question
type: page-design
related:
  - ../../../requirements/learning-materials/vocabulary.md
  - ../overview.md
---

# Trang chủ - Flashcard - Làm câu hỏi thêm

## 1. Mục đích

Màn hình này mô tả trạng thái người học đang làm phần luyện tập thêm sau hoặc trong quá trình học flashcard. Nội dung chính là một panel lớn `Extra practice`, yêu cầu người học nhìn nội dung câu hỏi và chọn đáp án đúng.

Page flashcard phía sau vẫn tồn tại ở nền dưới, nhưng vùng tương tác chính chuyển sang panel luyện tập thêm.

## 2. Kích thước frame

```text
Frame tham chiếu: 1462 x 1320 px
Nền trang: #FFFFFF
ExtraPracticePanel: khoảng 1375 x 995 px
Panel top: khoảng 33 px từ đỉnh frame
Panel left/right margin: khoảng 23-65 px
```

## 3. Cấu trúc layout tổng thể

```text
TrangChuFlashcardExtraPractice
├── HeaderNavigation (nằm phía sau, bị che/mờ một phần)
├── ExtraPracticePanel
│   ├── PracticeHeader
│   │   ├── Title: Extra practice
│   │   └── CloseButton
│   ├── HeaderDivider
│   ├── InstructionText
│   ├── QuestionContentArea
│   ├── SkipPracticeAction
│   └── CheckButton
├── CardActionBar phía sau/bên dưới panel
└── ProgressBar phía sau/bên dưới panel
```

## 4. Trạng thái nền khi extra practice mở

```text
UnderlyingPage
├── Header navigation vẫn thấy mờ ở phía trên
├── Flashcard chính bị che bởi panel luyện tập thêm
├── Action bar và progress bar vẫn thấy phía dưới panel
├── Opacity nền: khoảng 35-45%
└── Không nhận click trực tiếp trừ khi panel đóng
```

Các thành phần nền nhìn thấy:

| Khu vực | Trạng thái |
|---------|------------|
| Header navigation | bị panel che một phần, mờ |
| Flashcard content | bị che |
| Action bar | mờ, inactive |
| Progress bar | mờ, inactive |

## 5. Extra practice panel

### 5.1 Container

```text
ExtraPracticePanel
├── Width: khoảng 1375 px
├── Height: khoảng 995 px
├── Background: #D9D9D9
├── Border radius: 0 px theo wireframe
├── Position: gần full-width, căn giữa theo viewport
├── Z-index: cao hơn flashcard page
└── Không có shadow rõ ràng trong wireframe
```

### 5.2 Layout

```text
ExtraPracticePanel
├── Header height: khoảng 96 px
├── Divider: 1 px #000000
├── Instruction top area: khoảng 90 px
├── Question area: nằm giữa panel
├── Skip action: bên phải, dưới question area
└── Check button: bottom center
```

## 6. Practice header

### 6.1 Title

```text
Text: "Extra practice"
Font: 48-50 px regular
Color: #000000
Align: center horizontal
Position top: khoảng 56 px từ đỉnh frame
```

### 6.2 Close button

```text
CloseButton
├── Icon: circle x / close
├── Size: khoảng 46 x 46 px
├── Stroke: #000000
├── Position: top right trong panel
├── Top: khoảng 24 px
├── Right: khoảng 34 px
└── Click: đóng ExtraPracticePanel, quay lại flashcard
```

### 6.3 Header divider

```text
HeaderDivider
├── Height: 1 px
├── Width: full panel
├── Background: #000000
└── Position: dưới title/header
```

## 7. Instruction text

```text
InstructionText
├── Text: "Look and choose the correct answer"
├── Font: 25-26 px regular
├── Color: #000000
├── Align: center
├── Margin top từ divider: khoảng 30 px
└── Line height: khoảng 32 px
```

## 8. Question content area

```text
QuestionContentArea
├── Width: khoảng 1245 px
├── Height: khoảng 500 px
├── Background: #828282
├── Position: center horizontal
├── Margin top từ instruction: khoảng 42 px
└── Dùng làm vùng hiển thị câu hỏi/ảnh/đáp án trong wireframe
```

Wireframe hiện tại chỉ thể hiện một vùng chữ nhật xám lớn. Nếu bài tập cần chọn đáp án, các option có thể nằm trong vùng này hoặc bên dưới vùng này, nhưng ảnh chưa thể hiện chi tiết option.

## 9. Skip practice action

```text
SkipPracticeAction
├── Position: bên phải, dưới QuestionContentArea
├── Text: "Bỏ qua luyện tập thêm"
├── Icon: skip/next
├── Font: 21-22 px regular
├── Color: #000000
├── Gap text-icon: khoảng 24 px
└── Click: bỏ qua phần luyện tập thêm
```

```text
Vị trí tham chiếu:
├── X: khoảng 1055 px từ trái frame
├── Y: khoảng 820 px từ đỉnh frame
└── Align theo mép phải của QuestionContentArea
```

## 10. Check button

```text
CheckButton
├── Text: "Check"
├── Width: khoảng 360 px
├── Height: khoảng 68 px
├── Background: #FFFFFF
├── Border radius: 18 px
├── Font: 32-34 px regular
├── Text color: #000000
├── Position: bottom center trong panel
└── Click: kiểm tra đáp án đã chọn
```

```text
Vị trí:
├── Margin top từ question area: khoảng 166 px
├── Bottom margin trong panel: khoảng 58 px
└── Center x theo panel
```

## 11. Action bar phía sau panel

Phía dưới panel vẫn nhìn thấy flashcard action bar ở trạng thái mờ.

```text
BackgroundActionBar
├── Opacity giảm theo overlay/panel
├── Left: Đang học
├── Center: 1/12
├── Right: Đã nhớ
├── Gear icon
└── Fullscreen icon
```

Khi extra practice đang mở, action bar phía sau không nhận tương tác.

## 12. Progress bar phía sau panel

```text
BackgroundProgressBar
├── Width: khoảng 1150 px
├── Height: 9-10 px
├── Background: #D9D9D9
├── Filled segment: #8E8989
├── Filled width: khoảng 23%
└── Opacity giảm theo trạng thái extra practice
```

## 13. Màu sắc

| Token | Giá trị | Dùng cho |
|-------|---------|----------|
| `pageBackground` | `#FFFFFF` | nền toàn trang |
| `panelBackground` | `#D9D9D9` | nền panel Extra practice |
| `questionArea` | `#828282` | vùng nội dung câu hỏi |
| `primaryText` | `#000000` | text/icon chính |
| `divider` | `#000000` | đường chia header |
| `checkButtonBackground` | `#FFFFFF` | nền nút Check |
| `progressFilled` | `#8E8989` | phần progress đã học |
| `dimmedText` | `#8F8F8F` | text nền phía sau |

## 14. Typography

| Thành phần | Font size | Weight |
|------------|-----------|--------|
| Modal title `Extra practice` | 48-50 px | regular |
| Instruction text | 25-26 px | regular |
| Skip practice text | 21-22 px | regular |
| Check button text | 32-34 px | regular |
| Background action bar text | giữ size gốc, giảm opacity | theo state gốc |

## 15. Trạng thái

### 15.1 Extra practice panel

| State | Mô tả |
|-------|-------|
| closed | không hiển thị panel; người học ở flashcard bình thường |
| open | hiển thị panel luyện tập thêm; nền flashcard inactive |
| answered | người học đã chọn đáp án; nút Check có thể kiểm tra |
| checked | đã kiểm tra đáp án; hiển thị đúng/sai nếu có UI bổ sung |
| skipped | người học bỏ qua luyện tập thêm |

### 15.2 Check button

| State | Mô tả |
|-------|-------|
| default | nền trắng, text đen |
| disabled | dùng khi chưa chọn đáp án nếu product yêu cầu |
| active | dùng khi đã chọn đáp án |
| loading | dùng khi đang gửi/kiểm tra đáp án |

Wireframe hiện tại thể hiện nút `Check` ở trạng thái default.

### 15.3 Question area

| State | Mô tả |
|-------|-------|
| loading | placeholder xám hoặc skeleton |
| ready | hiển thị câu hỏi và đáp án |
| selected | một đáp án được chọn |
| correct | đáp án đúng sau khi Check |
| incorrect | đáp án sai sau khi Check |

## 16. Tương tác

| Trigger | Kết quả |
|---------|---------|
| Bấm close icon | đóng ExtraPracticePanel, quay lại flashcard |
| Bấm `Bỏ qua luyện tập thêm` | bỏ qua bài luyện tập thêm, quay lại hoặc chuyển thẻ tiếp theo |
| Bấm đáp án trong QuestionContentArea | chọn đáp án |
| Bấm `Check` | kiểm tra đáp án đã chọn |
| Nhấn Esc | nên đóng panel nếu được hỗ trợ |
| Bấm nền phía sau panel | không có tác dụng theo wireframe |

## 17. Dữ liệu cần hiển thị

```json
{
  "extraPractice": {
    "isOpen": true,
    "title": "Extra practice",
    "instruction": "Look and choose the correct answer",
    "questionType": "image_choice",
    "selectedAnswerId": null,
    "status": "ready"
  },
  "question": {
    "id": "practice-1",
    "prompt": null,
    "imageUrl": null,
    "answers": [],
    "correctAnswerId": null
  },
  "flashcardProgress": {
    "currentIndex": 1,
    "total": 12,
    "progressPercent": 0.23,
    "learningCount": 8,
    "rememberedCount": 7
  }
}
```

## 18. Ghi chú implementation

- Nên dựng phần này thành component riêng: `FlashcardExtraPracticePanel`.
- Panel luyện tập thêm có thể hoạt động như modal full-width, nhưng không che toàn bộ chiều cao vì action bar/progress bar phía sau vẫn thấy.
- Khi panel mở, khóa interaction của flashcard và action bar phía sau.
- Vùng `QuestionContentArea` trong wireframe chưa thể hiện option; implementation cần mapping rõ vị trí đáp án khi có design chi tiết hơn.
- `Check` nên disabled nếu chưa chọn đáp án, trừ khi product muốn cho phép kiểm tra trạng thái trống.
- `Bỏ qua luyện tập thêm` cần quyết định chuyển về flashcard hiện tại hay đi tới flashcard tiếp theo.
- Nếu người dùng tắt setting `Làm bài luyện tập thêm`, page này không xuất hiện trong flow học.
