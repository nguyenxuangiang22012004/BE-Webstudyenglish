# Tài Liệu BA Chi Tiết: Skills

Status: needs-review
Owner: BA/DEV
Last reviewed: 2026-06-12
Related:
  - docs/api/learning-materials/skill.md
  - docs/security/resources/skills.md
  - docs/requirements/learning-materials/question-bank.md
  - docs/test-cases/overview.md

Business rule IDs:
  - SKL-BR-001: Skill là danh mục kỹ năng dùng để phân loại câu hỏi, học liệu hoặc kết quả học tập.
  - SKL-BR-002: Skill có thể có quan hệ cha/con nếu API dùng `parent_id`.
  - SKL-BR-003: Skill hỗ trợ lọc và báo cáo theo năng lực/kỹ năng.

## 1. Khái niệm skill

Skill là kỹ năng học tập hoặc năng lực được dùng để phân loại nội dung.

Ví dụ trong hệ thống học ngoại ngữ, skill có thể liên quan tới nghe, nói, đọc, viết hoặc các năng lực nhỏ hơn.

## 2. Phạm vi chức năng hiện có

API hiện có:
- `GET /v1/skills`
- `POST /v1/skills`
- `GET /v1/skills/{id}`
- `PUT /v1/skills/{id}`
- `DELETE /v1/skills/{id}`

Danh sách hỗ trợ lọc theo `keyword`, `status`, `type`, `parent_id` và sort nếu API nhận.

## 3. Quan hệ với đối tượng khác

- Question: câu hỏi có thể được phân loại theo skill.
- Assessment/report: skill có thể tham gia vào báo cáo hoặc tiêu chí đánh giá.
- Topic/tag: skill phối hợp với các nhãn phân loại khác để lọc dữ liệu.

## 4. Quy tắc nghiệp vụ chính

- Skill cần có tên rõ ràng và nhất quán.
- Nếu skill có cấu trúc cây, cần tránh quan hệ cha/con không hợp lệ.
- Skill đã được dùng trong câu hỏi hoặc báo cáo cần kiểm soát khi xóa.

## 5. Ghi chú và điểm cần xác nhận

- Cần xác nhận danh sách skill mặc định có được cấu hình sẵn hay do người dùng tạo.
- Cần xác nhận skill có gắn subject/training level không.
- Cần xác nhận rule inactive skill trong các bộ lọc.
