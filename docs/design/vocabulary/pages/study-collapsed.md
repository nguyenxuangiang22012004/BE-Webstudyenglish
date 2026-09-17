---
status: needs-review
owner: UX/DEV
last_reviewed: 2026-09-11
requirement: ../../../requirements/learning-materials/vocabulary.md
domain: vocabulary
page: study-collapsed
type: page-design
related:
  - ../../../requirements/learning-materials/vocabulary.md
  - ../overview.md
---

# Trang chủ - Flashcard - collapsed

## Requirement liên quan

- `docs/requirements/learning-materials/vocabulary.md`

## 1. Mục đích

Màn hình này hiển thị bài học từ vựng ở trạng thái học bằng flashcard. Người học xem mặt trước của thẻ, nghe phát âm, xem ví dụ, đánh dấu từ đang học hoặc đã nhớ, lật thẻ để xem nội dung phía sau, và điều hướng qua danh sách thẻ trong bài.

Trạng thái `collapsed` trong tên page được hiểu là giao diện không mở thêm panel phụ; nội dung chính tập trung vào một flashcard lớn ở giữa màn hình.

## 2. Kích thước frame

```text
Frame tham chiếu: 1462 x 1320 px
Nền trang: #FFFFFF
Vùng nội dung chính: căn giữa theo chiều ngang
Chiều rộng nội dung chính: khoảng 1150-1160 px
```

## 3. Cấu trúc layout tổng thể

```text
TrangChuFlashcardCollapsed
├── HeaderNavigation
│   ├── MainNav
│   │   ├── Trang chủ (active)
│   │   ├── Khóa học
│   │   ├── Báo cáo
│   │   ├── Leaderboard
│   │   └── Phản hồi & góp ý
│   └── UserArea
│       ├── StatusPillGroup
│       ├── SegmentedProgressPill
│       ├── UserName
│       └── Avatar
├── LessonHeader
│   ├── LessonBadge
│   ├── LessonTitle
│   └── MetaChips
├── ActivityTabs
│   ├── Video lesson
│   ├── Flashcard (active)
│   ├── Pronunciation practice
│   └── Exercise
├── FlashcardStatusRow
│   ├── Đang học count
│   └── Đã nhớ count
├── Flashcard
│   ├── FrontContent
│   │   ├── Word + partOfSpeech
│   │   ├── PronunciationAudioRow
│   │   ├── ExampleAudioRow
│   │   └── ImagePlaceholder
│   ├── BookmarkButton
│   └── FlipHintBar
├── CardActionBar
│   ├── MarkLearningAction
│   ├── CardCounter
│   ├── MarkRememberedAction
│   └── UtilityActions
└── ProgressBar
```

## 4. Header navigation

### 4.1 Layout

```text
HeaderNavigation
├── Height: khoảng 64 px
├── Padding left: 40 px
├── Padding right: 38 px
├── Display: horizontal
├── MainNav nằm bên trái
└── UserArea nằm bên phải
```

### 4.2 Main navigation

| Item | Text | State | Font | Ghi chú |
|------|------|-------|------|--------|
| 1 | Trang chủ | active | 22 px, bold | Màu #000000 |
| 2 | Khóa học | default | 21-22 px, regular | Màu #000000 |
| 3 | Báo cáo | default | 21-22 px, regular | Màu #000000 |
| 4 | Leaderboard | default | 21-22 px, regular | Màu #000000 |
| 5 | Phản hồi & góp ý | default | 21-22 px, regular | Màu #000000 |

```text
Nav gap: khoảng 36-40 px
Active item không có underline, chỉ dùng font-weight bold.
```

### 4.3 User area

```text
UserArea
├── 2 pill ngắn màu #D9D9D9
│   ├── Size mỗi pill: khoảng 51 x 25 px
│   └── Radius: 9-10 px
├── 1 pill dài màu #D9D9D9
│   ├── Size: khoảng 136 x 25 px
│   └── Có đường chia dọc ở giữa
├── UserName: "Lê Lung Linh"
│   ├── Font: 22 px regular
│   └── Màu: #000000
└── Avatar
    ├── Circle: 44 x 44 px
    └── Fill: #D9D9D9
```

## 5. Lesson header

```text
LessonHeader
├── Margin top từ header: khoảng 12 px
├── Left aligned với nội dung chính
├── Row 1: LessonBadge + LessonTitle
└── Row 2: MetaChips
```

### 5.1 Lesson badge

```text
Text: "Lesson 1"
Size: khoảng 144 x 55 px
Background: #F0F0F0
Border radius: 8 px
Font: 25-26 px, bold
Text color: #000000
Align: center
```

### 5.2 Lesson title

```text
Text: "Vocabulary and structure"
Font: 25-26 px, bold
Text color: #000000
Margin left so với badge: 14-16 px
```

### 5.3 Meta chips

| Chip | Text | Size | Background | Radius | Font |
|------|------|------|------------|--------|------|
| Week | Week 29 | khoảng 106 x 32 px | #E5E5E5 | 8 px | 16 px regular |
| Unit | Unit 1: Meal time | khoảng 150 x 32 px | #E5E5E5 | 8 px | 16 px regular |

```text
Meta row margin top: khoảng 21 px
Chip gap: khoảng 16 px
```

## 6. Activity tabs

### 6.1 Container

```text
ActivityTabs
├── Width: khoảng 960 px
├── Height: 68 px
├── Margin top từ meta chips: khoảng 62 px
├── Background: #F0F0F0
├── Border radius: 8 px
├── Padding horizontal: 16-18 px
└── Items hiển thị theo hàng ngang
```

### 6.2 Tab items

| Tab | Icon | Text | State |
|-----|------|------|-------|
| Video lesson | video/window icon | Video lesson | default |
| Flashcard | document/card icon | Flashcard | active |
| Pronunciation practice | mouth/sound icon | Pronunciation practice | default |
| Exercise | exercise/tools icon | Exercise | default |

```text
Default tab:
├── Background: transparent
├── Text color: #000000
├── Icon color: #000000
└── Font: 22 px regular

Active tab:
├── Background: #D9D9D9
├── Size: khoảng 203 x 44 px
├── Border radius: 8 px
├── Text color: #000000
└── Font: 22 px regular
```

## 7. Flashcard status row

```text
FlashcardStatusRow
├── Width: bằng flashcard container
├── Height: khoảng 46 px
├── Margin top từ tab: 19 px
├── Left: learning count + label
└── Right: remembered label + count
```

### 7.1 Đang học

```text
Count badge:
├── Text: "8"
├── Size: 42 x 45 px
├── Background: #D9D9D9
├── Radius: 8 px
├── Font: 20 px regular
└── Align center

Label:
├── Text: "Đang học"
├── Font: 20 px regular
└── Margin left từ badge: 14 px
```

### 7.2 Đã nhớ

```text
Label:
├── Text: "Đã nhớ"
├── Font: 20 px regular
└── Align right gần count badge

Count badge:
├── Text: "7"
├── Size: 42 x 45 px
├── Background: #D9D9D9
├── Radius: 8 px
├── Font: 20 px regular
└── Margin left từ label: 12 px
```

## 8. Flashcard chính

### 8.1 Container

```text
Flashcard
├── Width: khoảng 1150 px
├── Height: khoảng 630 px
├── Background: #F2F2F2
├── Border radius: 10 px
├── Overflow: hidden
├── Position: center
└── Có vùng footer "Nhấp vào thẻ để lật"
```

### 8.2 Front content

```text
FrontContent
├── Padding top: khoảng 40 px
├── Padding left: khoảng 48 px
├── Padding right: khoảng 48 px
├── Layout: 2 cột
│   ├── LeftColumn: từ vựng, phát âm, ví dụ
│   └── RightColumn: image placeholder
└── BookmarkButton nằm góc trên phải
```

### 8.3 Left column

```text
LeftColumn
├── Width: khoảng 470-500 px
├── WordRow
├── PronunciationAudioRow
└── ExampleAudioRow
```

#### Word row

```text
Word: "Lucky"
├── Font: 48-50 px, bold
├── Color: #000000
└── Baseline cùng dòng với part of speech

Part of speech: "(adj)"
├── Font: 32-34 px, regular
├── Color: #000000
└── Margin left từ word: khoảng 42 px
```

#### Pronunciation audio row

```text
Margin top từ word row: khoảng 48 px
Icon speaker:
├── Size: khoảng 48 x 48 px
├── Color: #000000
└── Click: phát audio phát âm

Flag:
├── US flag emoji/image
├── Size: khoảng 42 x 28 px
└── Margin left từ speaker: khoảng 20 px

Phonetic text:
├── Text: "/phiên âm/"
├── Font: 32-34 px regular
├── Color: #000000
└── Margin left từ flag: khoảng 14 px
```

#### Example audio row

```text
Margin top từ pronunciation row: khoảng 45 px
Icon speaker:
├── Size: khoảng 48 x 48 px
├── Color: #000000
└── Click: phát audio câu ví dụ

Example text:
├── Text: "She is very lucky"
├── Font: 32-34 px regular
├── Color: #000000
└── Margin left từ speaker: khoảng 42 px
```

### 8.4 Right image placeholder

```text
ImagePlaceholder
├── Width: khoảng 475 px
├── Height: khoảng 425 px
├── Background: #D9D9D9
├── Position: right column, top aligned với word area
├── Có 2 đường chéo tạo dấu X
│   ├── Stroke: #000000
│   └── Width: 1 px
└── Dùng làm vùng ảnh minh họa từ vựng
```

### 8.5 Bookmark button

```text
BookmarkButton
├── Icon: bookmark outline
├── Size icon: khoảng 44 x 44 px
├── Color: #000000
├── Position: góc phải trên trong card
├── Top: khoảng 32 px
├── Right: khoảng 24 px
└── Click: toggle lưu từ/thẻ
```

### 8.6 Flip hint bar

```text
FlipHintBar
├── Text: "Nhấp vào thẻ để lật"
├── Height: khoảng 68 px
├── Background: #D9D9D9
├── Position: dính đáy card
├── Font: 20-21 px regular
├── Text color: #000000
└── Align center
```

## 9. Card action bar

```text
CardActionBar
├── Width: bằng flashcard
├── Height: khoảng 70 px
├── Margin top từ card: 22 px
├── Layout: horizontal
├── Left action group: Đang học
├── Center: card counter
├── Right action group: Đã nhớ + utility actions
└── Không có background riêng
```

### 9.1 Mark learning action

```text
Icon: circle x / close
Text: "Đang học"
Font: 20 px regular
Icon size: khoảng 22 px
Gap icon-text: 12 px
Action: đánh dấu thẻ hiện tại là đang học
```

### 9.2 Card counter

```text
Text: "1/12"
Font: 24-25 px, bold
Color: #000000
Position: center của action bar
```

### 9.3 Mark remembered action

```text
Icon: circle check
Text: "Đã nhớ"
Font: 20 px regular
Icon size: khoảng 24 px
Gap icon-text: 12 px
Action: đánh dấu thẻ hiện tại là đã nhớ
```

### 9.4 Utility actions

| Icon | Ý nghĩa | Action |
|------|---------|--------|
| Undo arrow | Quay lại thao tác trước | hoàn tác trạng thái thẻ gần nhất |
| Gear | Cài đặt flashcard | mở cấu hình học |
| Fullscreen | Phóng to/toàn màn hình | bật chế độ học toàn màn hình |

```text
Utility icon size: 30-34 px
Gap giữa utility icons: khoảng 30 px
Align: bên phải action bar
```

## 10. Progress bar

```text
ProgressBar
├── Width: bằng flashcard
├── Height: 9-10 px
├── Margin top: khoảng 8 px
├── Background: #D9D9D9
├── Filled segment: #8E8989
├── Filled width: khoảng 23% tổng chiều rộng
└── Không bo góc rõ ràng
```

## 11. Màu sắc

| Token | Giá trị | Dùng cho |
|-------|---------|----------|
| `pageBackground` | `#FFFFFF` | nền toàn trang |
| `primaryText` | `#000000` | text chính, icon |
| `softPanel` | `#F2F2F2` | nền flashcard |
| `tabContainer` | `#F0F0F0` | tab bar, lesson badge |
| `neutralChip` | `#E5E5E5` | week/unit chip |
| `activeControl` | `#D9D9D9` | active tab, count badge, hint bar, avatar |
| `progressFilled` | `#8E8989` | phần đã học trên progress bar |

## 12. Typography

| Thành phần | Font size | Weight |
|------------|-----------|--------|
| Navigation active | 22 px | bold |
| Navigation default | 21-22 px | regular |
| Lesson badge | 25-26 px | bold |
| Lesson title | 25-26 px | bold |
| Meta chip | 16 px | regular |
| Tab label | 22 px | regular |
| Status row label | 20 px | regular |
| Word | 48-50 px | bold |
| Part of speech | 32-34 px | regular |
| Pronunciation/example text | 32-34 px | regular |
| Flip hint | 20-21 px | regular |
| Card counter | 24-25 px | bold |

## 13. Trạng thái

### 13.1 Tab

| State | Mô tả |
|-------|-------|
| default | nền trong suốt, text đen |
| active | nền `#D9D9D9`, radius 8 px |
| hover | có thể dùng nền `#E5E5E5` để báo có thể click |

### 13.2 Flashcard

| State | Mô tả |
|-------|-------|
| front | hiển thị từ, phát âm, ví dụ, ảnh minh họa |
| back | hiển thị nghĩa/giải thích của từ sau khi lật |
| remembered | thẻ được tính vào nhóm `Đã nhớ` |
| learning | thẻ được tính vào nhóm `Đang học` |
| bookmarked | bookmark icon chuyển sang trạng thái filled |

### 13.3 Audio

| State | Mô tả |
|-------|-------|
| idle | speaker icon màu đen |
| playing | có thể thêm trạng thái nhấn/active hoặc animation sóng âm |
| error | nếu audio lỗi, không đổi layout; hiển thị lỗi nhẹ hoặc tooltip |

## 14. Tương tác

| Trigger | Kết quả |
|---------|---------|
| Bấm `Video lesson` | chuyển sang màn video lesson |
| Bấm `Flashcard` | giữ màn hiện tại |
| Bấm `Pronunciation practice` | chuyển sang màn luyện phát âm |
| Bấm `Exercise` | chuyển sang màn bài tập |
| Bấm speaker phát âm | phát audio phát âm từ |
| Bấm speaker ví dụ | phát audio câu ví dụ |
| Bấm bookmark | lưu/bỏ lưu thẻ hiện tại |
| Bấm vùng flashcard hoặc hint bar | lật thẻ |
| Bấm `Đang học` | đánh dấu thẻ hiện tại là đang học |
| Bấm `Đã nhớ` | đánh dấu thẻ hiện tại là đã nhớ |
| Bấm undo | hoàn tác thao tác gần nhất |
| Bấm gear | mở cài đặt flashcard |
| Bấm fullscreen | bật/tắt toàn màn hình |

## 15. Dữ liệu cần hiển thị

```json
{
  "lesson": {
    "number": 1,
    "title": "Vocabulary and structure",
    "week": "Week 29",
    "unit": "Unit 1: Meal time"
  },
  "flashcardProgress": {
    "learningCount": 8,
    "rememberedCount": 7,
    "currentIndex": 1,
    "total": 12,
    "progressPercent": 0.23
  },
  "currentCard": {
    "word": "Lucky",
    "partOfSpeech": "adj",
    "accent": "US",
    "phonetic": "/phiên âm/",
    "example": "She is very lucky",
    "imageUrl": null,
    "isBookmarked": false,
    "status": "learning"
  },
  "user": {
    "name": "Lê Lung Linh",
    "avatarUrl": null
  }
}
```

## 16. Ghi chú implementation

- Nên tách page thành các component: `HeaderNavigation`, `LessonHeader`, `ActivityTabs`, `FlashcardStatusRow`, `FlashcardView`, `FlashcardActionBar`, `ProgressBar`.
- Toàn bộ icon trong ảnh là icon nét đen đơn sắc; nếu dùng icon library, chọn style outline nhất quán.
- Flashcard phải có vùng click lớn để lật thẻ, nhưng các nút con như speaker và bookmark cần chặn event lật thẻ khi click.
- Image placeholder trong wireframe là vùng ảnh minh họa; khi có ảnh thật, thay bằng image crop/fit cùng kích thước.
- Count `Đang học`, `Đã nhớ`, `1/12`, và progress bar phải cập nhật cùng nguồn dữ liệu để tránh lệch trạng thái.
- Cần có empty state nếu không có flashcard trong lesson: ẩn card controls và hiển thị thông báo chưa có từ vựng.
