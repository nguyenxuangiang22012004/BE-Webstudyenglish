---
status: needs-review
owner: UX/DEV
last_reviewed: 2026-09-11
requirement: ../../../requirements/learning-materials/vocabulary.md
domain: vocabulary
page: study-maximized
type: page-design
related:
  - ../../../requirements/learning-materials/vocabulary.md
  - ../overview.md
---

# Trang chủ - Flashcard - Maximized

## Requirement liên quan

- `docs/requirements/learning-materials/vocabulary.md`

## 1. Mục đích

Màn hình này mô tả chế độ học flashcard phóng to. Người học vẫn ở trang chủ, nhưng vùng học được tối ưu để tập trung vào một thẻ lớn, giảm bớt metadata phụ như badge Lesson, Week và activity tab đầy đủ.

Chế độ này dùng khi người học bấm icon fullscreen/phóng to từ màn flashcard thường.

## 2. Kích thước frame

```text
Frame tham chiếu: 1462 x 1320 px
Nền trang: #FFFFFF
Vùng nội dung chính: căn giữa theo chiều ngang
Flashcard: khoảng 1150 x 630 px
```

## 3. Cấu trúc layout tổng thể

```text
TrangChuFlashcardMaximized
├── HeaderNavigation
│   ├── MainNav
│   └── UserArea
├── MaximizedLearningHeader
│   ├── ModeSelector
│   ├── LessonCenterInfo
│   └── CloseMaximizedButton
├── TopProgressBar
├── FlashcardStatusRow
├── Flashcard
│   ├── FrontContent
│   │   ├── Word + partOfSpeech
│   │   ├── PronunciationAudioRow
│   │   ├── ExampleAudioRow
│   │   └── ImagePlaceholder
│   └── FlipHintBar
└── MaximizedActionBar
    ├── MarkLearningIcon
    ├── MarkRememberedIcon
    └── SettingsIcon
```

## 4. Header navigation

Header navigation giống trạng thái flashcard thường, không bị làm mờ.

```text
HeaderNavigation
├── Height: khoảng 64 px
├── Padding left: 40 px
├── Padding right: 38 px
├── MainNav nằm bên trái
└── UserArea nằm bên phải
```

| Item | Text | State | Font |
|------|------|-------|------|
| 1 | Trang chủ | active | 22 px bold |
| 2 | Khóa học | default | 21-22 px regular |
| 3 | Báo cáo | default | 21-22 px regular |
| 4 | Leaderboard | default | 21-22 px regular |
| 5 | Phản hồi & góp ý | default | 21-22 px regular |

## 5. Maximized learning header

### 5.1 Layout

```text
MaximizedLearningHeader
├── Width: khoảng 1150 px
├── Height: khoảng 96 px
├── Margin top từ page header: khoảng 25 px
├── Layout: 3 vùng
│   ├── Left: ModeSelector
│   ├── Center: LessonCenterInfo
│   └── Right: CloseMaximizedButton
└── Align center theo vùng nội dung chính
```

### 5.2 Mode selector

```text
ModeSelector
├── Position: left aligned với progress/card
├── Icon: flashcard/document icon
├── Text: "Flashcard"
├── Chevron down
├── Font: 23-24 px regular
├── Icon size: khoảng 24 px
├── Gap icon-text: 12 px
├── Gap text-chevron: 12 px
└── Click: mở menu chọn mode học nếu có
```

### 5.3 Lesson center info

```text
LessonCenterInfo
├── Position: center header
├── Title: "Lesson 1 Vocabulary and structure"
├── Subtitle: "Unit 1: Meal time"
└── Align: center
```

```text
Title:
├── Font: 26-27 px bold
├── Color: #000000
└── Line height: khoảng 32 px

Subtitle:
├── Margin top: khoảng 10 px
├── Font: 16 px regular
├── Color: #000000
└── Line height: khoảng 20 px
```

### 5.4 Close maximized button

```text
CloseMaximizedButton
├── Icon: circle x / close
├── Size: khoảng 44 x 44 px
├── Stroke: #000000
├── Position: right aligned với page content
└── Click: thoát maximized, quay về flashcard collapsed
```

## 6. Top progress bar

```text
TopProgressBar
├── Width: khoảng 1150 px
├── Height: 9-10 px
├── Margin top từ learning header: khoảng 22 px
├── Background: #D9D9D9
├── Filled segment: #8E8989
├── Filled width: khoảng 23% tổng chiều rộng
└── Align center theo flashcard
```

Progress bar trong chế độ maximized nằm phía trên flashcard, không nằm dưới action bar như trạng thái collapsed.

## 7. Flashcard status row

```text
FlashcardStatusRow
├── Width: bằng flashcard
├── Height: khoảng 46 px
├── Margin top từ progress bar: khoảng 130 px
├── Left: Đang học count
└── Right: Đã nhớ count
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
├── Color: #000000
└── Margin left từ badge: 14 px
```

### 7.2 Đã nhớ

```text
Label:
├── Text: "Đã nhớ"
├── Font: 20 px regular
├── Color: #000000
└── Align right

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
└── Footer hint bar dính đáy
```

### 8.2 Front content

```text
FrontContent
├── Padding top: khoảng 40 px
├── Padding left: khoảng 48 px
├── Padding right: khoảng 48 px
├── Layout: 2 cột
│   ├── LeftColumn: text/audio
│   └── RightColumn: ảnh minh hoạ
└── Không hiển thị bookmark icon trong ảnh maximized
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
├── Font: 48-50 px bold
├── Color: #000000
└── Baseline cùng dòng với part of speech

Part of speech: "(adj)"
├── Font: 32-34 px regular
├── Color: #000000
└── Margin left từ word: khoảng 42 px
```

#### Pronunciation audio row

```text
Margin top từ word row: khoảng 48 px
Speaker icon:
├── Size: khoảng 48 x 48 px
├── Color: #000000
└── Click: phát âm từ

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
Speaker icon:
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
├── Có 2 đường chéo tạo dấu X
│   ├── Stroke: #000000
│   └── Width: 1 px
└── Dùng cho ảnh minh hoạ từ vựng
```

### 8.5 Flip hint bar

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

## 9. Maximized action bar

```text
MaximizedActionBar
├── Width: khoảng 1150 px
├── Height: khoảng 72 px
├── Margin top từ flashcard: khoảng 24 px
├── Không hiển thị label text
├── Không hiển thị counter "1/12" trong action bar
└── Chỉ dùng icon để giảm nhiễu khi học
```

### 9.1 Icon layout

```text
CenterIconGroup
├── MarkLearningIcon ở gần center-left
├── MarkRememberedIcon ở gần center-right
└── Gap giữa 2 icon: khoảng 80-90 px

RightIconGroup
└── SettingsIcon nằm sát phải theo mép flashcard
```

| Icon | Size | Action |
|------|------|--------|
| Circle x | khoảng 24 px | đánh dấu đang học |
| Circle check | khoảng 28 px | đánh dấu đã nhớ |
| Gear | khoảng 34 px | mở cài đặt flashcard |

## 10. Khác biệt so với trạng thái collapsed

| Khu vực | Collapsed | Maximized |
|---------|-----------|-----------|
| Lesson header | có badge Lesson, title, Week, Unit | gom vào center header |
| Activity tabs | tab bar lớn nhiều mục | chỉ còn mode selector "Flashcard" |
| Progress bar | nằm dưới action bar | nằm phía trên flashcard |
| Action bar | có text, counter, undo, settings, fullscreen | icon-only, ít control hơn |
| Close/fullscreen | fullscreen icon ở dưới | close icon ở header phải |
| Bookmark | hiện trên flashcard | không thấy trong wireframe maximized |

## 11. Màu sắc

| Token | Giá trị | Dùng cho |
|-------|---------|----------|
| `pageBackground` | `#FFFFFF` | nền toàn trang |
| `primaryText` | `#000000` | text chính, icon |
| `softPanel` | `#F2F2F2` | nền flashcard |
| `activeControl` | `#D9D9D9` | badge, hint bar, image placeholder |
| `progressBackground` | `#D9D9D9` | progress track |
| `progressFilled` | `#8E8989` | phần progress đã học |

## 12. Typography

| Thành phần | Font size | Weight |
|------------|-----------|--------|
| Header nav active | 22 px | bold |
| Header nav default | 21-22 px | regular |
| Mode selector | 23-24 px | regular |
| Lesson center title | 26-27 px | bold |
| Lesson center subtitle | 16 px | regular |
| Status row label | 20 px | regular |
| Word | 48-50 px | bold |
| Part of speech | 32-34 px | regular |
| Pronunciation/example text | 32-34 px | regular |
| Flip hint | 20-21 px | regular |

## 13. Trạng thái

### 13.1 Maximized mode

| State | Mô tả |
|-------|-------|
| off | dùng layout flashcard collapsed |
| on | dùng layout maximized trong file này |

### 13.2 Flashcard

| State | Mô tả |
|-------|-------|
| front | hiển thị từ, phát âm, ví dụ, ảnh minh hoạ |
| back | hiển thị nghĩa/giải thích sau khi lật |
| learning | thẻ thuộc nhóm đang học |
| remembered | thẻ thuộc nhóm đã nhớ |

### 13.3 Mode selector

| State | Mô tả |
|-------|-------|
| closed | chỉ hiển thị "Flashcard" và chevron |
| open | mở dropdown chọn hoạt động học khác nếu product hỗ trợ |

## 14. Tương tác

| Trigger | Kết quả |
|---------|---------|
| Bấm close icon góc phải | thoát maximized, quay về flashcard collapsed |
| Bấm mode selector `Flashcard` | mở dropdown chọn mode học |
| Bấm vùng flashcard hoặc hint bar | lật thẻ |
| Bấm speaker phát âm | phát audio phát âm từ |
| Bấm speaker ví dụ | phát audio câu ví dụ |
| Bấm circle x | đánh dấu thẻ hiện tại là đang học |
| Bấm circle check | đánh dấu thẻ hiện tại là đã nhớ |
| Bấm gear | mở modal cài đặt flashcard |

## 15. Dữ liệu cần hiển thị

```json
{
  "mode": {
    "type": "flashcard",
    "isMaximized": true
  },
  "lesson": {
    "number": 1,
    "title": "Vocabulary and structure",
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
    "status": "learning"
  },
  "user": {
    "name": "Lê Lung Linh",
    "avatarUrl": null
  }
}
```

## 16. Ghi chú implementation

- Chế độ maximized nên dùng cùng data source với flashcard collapsed để tránh lệch `learningCount`, `rememberedCount`, `currentIndex`, `progressPercent`.
- Nên tách phần học phóng to thành component riêng: `FlashcardMaximizedView`.
- Khi thoát maximized, giữ nguyên thẻ hiện tại và trạng thái mặt trước/mặt sau nếu product yêu cầu tiếp nối liền mạch.
- Progress bar chuyển vị trí từ dưới lên trên; dùng cùng component progress nhưng cho phép truyền vị trí/layout khác nhau.
- Action bar ở maximized dùng icon-only; cần tooltip hoặc accessible label cho từng icon.
- Nếu mode selector mở dropdown, cần khóa interaction flashcard phía dưới cho đến khi menu đóng.
- Nếu cài đặt mở từ gear trong maximized, modal settings nên hiển thị trên layout maximized và vẫn giữ trạng thái `isMaximized = true` sau khi đóng modal.
