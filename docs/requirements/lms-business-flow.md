# LMS Business Flow Overview

Status: reviewed
Owner: BA/DEV
Last reviewed: 2026-09-16
Source: Tổng hợp từ `docs/requirements/overview.md` và các tài liệu domain liên quan.
Related:
  - docs/requirements/overview.md
  - docs/requirements/auth/auth.md
  - docs/requirements/programs/program.md
  - docs/requirements/programs/course.md
  - docs/requirements/learning-materials/homework.md
  - docs/requirements/learning-materials/exam.md
  - docs/requirements/learning-materials/assessment.md
  - docs/requirements/reports/student-progress-ranking.md
  - docs/security/overview.md
  - docs/api/overview.md

Review note: Flow tổng quan đã được xác nhận đúng. Hiện không có module nào trong flow này cần ghi là tạm ẩn hoặc không sử dụng, ngoài các chức năng đã được ghi riêng ở tài liệu domain như Chat/Contest. Ranking chính thức dùng phạm vi course.

Tài liệu này mô tả flow nghiệp vụ tổng quan của LMS ở mức hệ thống. Flow này dùng để định hướng BA/DEV/TEST/AI khi cần hiểu chuỗi nghiệp vụ chính, không thay thế tài liệu chi tiết của từng domain.

## 1. Flow tổng quan theo vai trò

```mermaid
flowchart LR
  A[Người dùng truy cập hệ thống] --> B[Xác thực và xác định vai trò]

  B --> C1[Admin]
  B --> C2[Nhà trường]
  B --> C3[Giáo viên]
  B --> C4[Học sinh]
  B --> C5[Phụ huynh]

  C1 --> D1[Quản trị dữ liệu nền toàn hệ thống]
  C2 --> D2[Quản trị dữ liệu trong phạm vi trường]
  C3 --> D3[Tổ chức giảng dạy và theo dõi học sinh]
  C4 --> D4[Tham gia học tập và làm bài]
  C5 --> D5[Xem tài khoản con và chuyển vào tài khoản học sinh]

  D1 --> E[Thiết lập tổ chức học tập]
  D2 --> E
  D3 --> E

  E --> E1[Năm học / học kỳ / tuần học]
  E --> E2[Trường / khối / lớp]
  E1 --> F[Chương trình học]
  E2 --> F
  F --> G[Khóa học triển khai thực tế]
  G --> H[Chương học và bài học]

  H --> I[Học liệu và hoạt động học tập]
  I --> I1[Lecture / Video / Vocabulary / Flipbook]
  I --> I2[Homework]
  I --> I3[Exam]
  I --> I4[Assessment]

  I1 --> J[Học sinh học nội dung]
  I2 --> K[Học sinh làm bài]
  I3 --> K
  I4 --> L[Học sinh nộp minh chứng hoặc được đánh giá]

  K --> M[Chấm điểm tự động hoặc thủ công]
  L --> M

  M --> N[Công bố / ghi nhận kết quả]
  N --> O[Báo cáo tiến độ, kết quả, ranking]
  O --> P[Admin / Nhà trường / Giáo viên theo dõi]
  O --> Q[Học sinh xem kết quả của mình]
  O --> Q2[Phụ huynh theo dõi qua tài khoản con]

  P --> R[Điều chỉnh chương trình, khóa học, bài học hoặc hoạt động]
  Q --> S[Tiếp tục học tập / làm lại / cải thiện kết quả]
  R --> E
  S --> J
```

## 2. Chuỗi nghiệp vụ lõi

```mermaid
flowchart TD
  A[Quản trị hệ thống] --> B[Thiết lập trường, khối, lớp, vai trò, quyền]
  B --> C[Thiết lập năm học, học kỳ, tuần học, môn học, chương trình]
  C --> D[Xây dựng học liệu gốc]
  D --> D1[Chương học]
  D --> D2[Bài học]
  D --> D3[Ngân hàng câu hỏi]
  D --> D4[Tiêu chí đánh giá]

  D1 --> E[Tạo khóa học thực tế]
  D2 --> E
  D3 --> E
  D4 --> E

  E --> F[Gắn giáo viên, học sinh, lịch học]
  F --> G[Triển khai bài học]
  G --> H[Giao hoạt động học tập]

  H --> H1[Homework]
  H --> H2[Exam]
  H --> H3[Assessment]
  H --> H4[VSTEP / Vocabulary / Interactive content]

  H1 --> I[Học sinh thực hiện]
  H2 --> I
  H3 --> I
  H4 --> I

  I --> J[Lưu tiến độ, câu trả lời, file nộp]
  J --> K[Chấm điểm / đánh giá]
  K --> L[Ghi nhận kết quả]
  L --> M[Báo cáo học tập]
  M --> N[Theo dõi và ra quyết định vận hành]
  N --> O[Cập nhật dữ liệu học tập nếu cần]
  O --> C
```

## 3. Flow làm bài và đánh giá

```mermaid
flowchart TD
  A[Giáo viên / Admin / Nhà trường tạo hoạt động] --> B{Loại hoạt động}

  B --> C[Homework]
  B --> D[Exam]
  B --> E[Assessment]

  C --> F[Gắn câu hỏi, điểm, hạn nộp nếu có]
  D --> G[Gắn câu hỏi, cấu hình bài kiểm tra]
  E --> H[Gắn tiêu chí đánh giá, file hoặc yêu cầu nộp]

  F --> I[Giao cho học sinh trong khóa học/bài học]
  G --> I
  H --> I

  I --> J[Học sinh mở hoạt động]
  J --> K[Làm bài / trả lời câu hỏi / nộp file]
  K --> L[Lưu tiến độ và trạng thái]
  L --> M[Học sinh nộp bài]

  M --> N{Cách chấm}
  N --> O[Tự động chấm dạng câu hỏi phù hợp]
  N --> P[Giáo viên chấm thủ công]
  N --> Q[Đánh giá theo tiêu chí]

  O --> R[Ghi nhận điểm và trạng thái]
  P --> R
  Q --> R

  R --> S{Công bố kết quả?}
  S -->|Có| T[Học sinh xem kết quả, review, ranking]
  S -->|Chưa| U[Giáo viên/Admin tiếp tục xử lý]
  T --> V[Báo cáo học tập]
  U --> R
```

## 4. Flow báo cáo và phản hồi vận hành

```mermaid
flowchart LR
  A[Dữ liệu khóa học] --> E[Báo cáo học tập]
  B[Dữ liệu làm bài] --> E
  C[Dữ liệu điểm / đánh giá] --> E
  D[Dữ liệu người dùng / lớp / trường] --> E

  E --> F[Dashboard quản trị]
  E --> G[Báo cáo giáo viên]
  E --> H[Progress report học sinh]
  E --> I[Ranking]

  F --> J[Admin theo dõi toàn hệ thống]
  G --> K[Giáo viên theo dõi lớp/khóa học]
  H --> L[Học sinh xem tiến độ cá nhân]
  I --> L

  J --> M[Điều chỉnh vận hành]
  K --> N[Điều chỉnh giảng dạy / chấm điểm / giao bài]
  L --> O[Tiếp tục học hoặc cải thiện kết quả]

  M --> P[Cập nhật chương trình, khóa học, người dùng, phân quyền]
  N --> Q[Cập nhật bài học, homework, exam, assessment]
  O --> R[Thực hiện hoạt động học tập tiếp theo]
```

## 5. Ghi chú đọc flow

- Admin có phạm vi toàn hệ thống; Nhà trường thao tác trong phạm vi dữ liệu của trường.
- Giáo viên là vai trò vận hành giảng dạy: tổ chức bài học, giao/chấm bài và theo dõi kết quả.
- Học sinh là vai trò thực hiện học tập: học nội dung, làm bài, nộp bài và xem kết quả.
- Phụ huynh là vai trò hiện có trong code, có thể xem danh sách tài khoản con và chuyển phiên sang tài khoản học sinh.
- Hệ thống hiện đã có quản lý năm học, học kỳ, tuần học, khối và lớp học; các dữ liệu này là nền vận hành cho khóa học/lịch học/báo cáo.
- Course là lớp triển khai thực tế của program, gắn giáo viên, học sinh, học kỳ/năm học và lịch học.
- Homework, Exam và Assessment là các hoạt động chính tạo dữ liệu tiến độ, điểm và báo cáo trong flow hiện tại.
- Báo cáo là đầu ra của toàn bộ chuỗi học tập, đồng thời là đầu vào để điều chỉnh vận hành.

## 6. Điểm cần theo dõi khi viết đặc tả/test chi tiết

- Phạm vi ranking chính thức hiện tại là theo course.
- Điều kiện công bố kết quả assessment/study report cho học sinh cần đối chiếu ở tài liệu report/assessment chi tiết khi viết test.
- Ranh giới thao tác giữa Admin và Nhà trường ở các module có quyền giống nhau nhưng khác phạm vi dữ liệu cần kiểm tra theo permission/API thực tế.
- Flow chi tiết cho các tích hợp ngoài như PHX, SpeechAce, ELSA, Google hoặc AI grading chỉ cần đưa vào sơ đồ cấp hệ thống khi có yêu cầu triển khai/test các tích hợp đó.
