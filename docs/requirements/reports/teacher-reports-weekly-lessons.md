# Tài Liệu BA Chi Tiết: Teacher Reports và Weekly Lessons

Status: reviewed
Owner: BA/DEV
Last reviewed: 2026-09-16
Related:
  - docs/api/dashboards/report.md
  - docs/api/dashboards/study-report.md
  - docs/requirements/programs/course.md
  - docs/requirements/learning-materials/lesson.md
  - docs/test-cases/overview.md

Review note: Teacher reports/weekly lessons đã được xác nhận. Tab exam đang tạm ẩn vì sản phẩm chưa dùng; tab chấm bài/grading đang dùng. Weekly lessons tính tuần hiện tại theo server time.

Business rule IDs:
  - TRP-BR-001: Giáo viên xem báo cáo học tập trong phạm vi khóa/lớp được phân công.
  - TRP-BR-002: Weekly lessons giúp giáo viên theo dõi bài học và bài cần chấm theo tuần.
  - TRP-BR-003: Dữ liệu báo cáo cần hỗ trợ lọc theo khóa học, học sinh và khoảng thời gian nếu API có.

## 1. Khái niệm

Teacher reports là khu vực giáo viên xem dữ liệu homework, assessment và export báo cáo.

Weekly lessons là khu vực giáo viên theo dõi bài học theo tuần và xử lý bài cần chấm.

Trong code hiện tại:
- `/teacher/reports` có tab `homework`, `assessment`, `export`; tab `exam` có component nhưng trigger đang bị comment vì sản phẩm chưa dùng.
- `/teacher/weekly-lessons` có tab `lessons` và tab chấm bài `homework-grading` đang hiển thị.

## 2. Phạm vi chức năng hiện có

Teacher reports:
- Xem báo cáo homework theo course.
- Xem báo cáo assessment theo course.
- Export dữ liệu báo cáo.

Weekly lessons:
- Xem danh sách bài học theo tuần.
- Xem danh sách homework cần chấm.
- Mở các màn hình chi tiết/chấm bài liên quan.

## 3. Quan hệ với các đối tượng khác

- Course: phạm vi lọc và phân quyền chính.
- Lesson: đơn vị hiển thị trong weekly lessons.
- Homework/assessment: nguồn dữ liệu báo cáo và chấm.
- Student: đối tượng được xem kết quả/chấm điểm.

## 4. Quy tắc nghiệp vụ chính

- Giáo viên chỉ xem dữ liệu thuộc course/lớp được phân công hoặc được cấp quyền.
- Các tab phải đồng bộ query string để giữ ngữ cảnh khi reload.
- Báo cáo cần phân biệt dữ liệu chưa có, đang tải và lỗi API.
- Export phải tôn trọng filter và phạm vi dữ liệu hiện tại.

## 5. Ghi chú

- Tab `exam` trong teacher reports đang tạm ẩn vì sản phẩm chưa dùng, không coi là lỗi nghiệp vụ.
- Tab chấm bài/grading đang dùng trong weekly lessons.
- Weekly lessons lấy tuần hiện tại theo server time.
