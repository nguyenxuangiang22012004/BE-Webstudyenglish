# Tài Liệu BA Chi Tiết: Progress Report và Ranking

Status: reviewed
Owner: BA/DEV
Last reviewed: 2026-09-16
Related:
  - docs/api/dashboards/study-report.md
  - docs/api/dashboards/report.md
  - docs/requirements/learning-materials/homework.md
  - docs/requirements/learning-materials/assessment.md
  - docs/test-cases/overview.md

Review note: Progress report/ranking đã được xác nhận. Ranking dùng phạm vi course. Tab exam có component nhưng đang tạm ẩn vì sản phẩm chưa dùng.

Business rule IDs:
  - RPT-BR-001: Học sinh xem tiến độ học tập và kết quả của chính mình.
  - RPT-BR-002: Ranking tổng hợp kết quả theo loại hoạt động học tập.
  - RPT-BR-003: Báo cáo chỉ hiển thị dữ liệu trong phạm vi user được phép xem.

## 1. Khái niệm

Progress report là khu vực học sinh theo dõi tiến độ và kết quả học tập.

Ranking là khu vực xếp hạng kết quả theo từng loại hoạt động học tập.

Trong code hiện tại:
- `/student/progress-report` có tab `homework` và `assessment`.
- `/student/ranking` có tab `homework` và `assessment`; tab `exam` có component nhưng trigger đang bị comment.

## 2. Phạm vi chức năng hiện có

Progress report:
- Xem kết quả homework.
- Xem kết quả assessment.
- Xem chi tiết study report theo id.

Ranking:
- Xem bảng xếp hạng homework.
- Xem bảng xếp hạng assessment.
- Có nền tảng component cho exam nhưng UI hiện chưa bật tab exam.

## 3. Quan hệ với các đối tượng khác

- Homework: nguồn dữ liệu điểm và trạng thái làm bài.
- Assessment: nguồn dữ liệu đánh giá theo tiêu chí.
- Study report: dữ liệu báo cáo chi tiết theo học sinh/course/assessment.
- Course: phạm vi học tập và lọc báo cáo.
- User/student: chủ thể của dữ liệu tiến độ.

## 4. Quy tắc nghiệp vụ chính

- Học sinh chỉ xem dữ liệu của chính mình, trừ khi backend cấp quyền khác.
- Ranking so sánh trong phạm vi course.
- Báo cáo cần phân biệt trạng thái chưa làm, đang làm, đã nộp, đã chấm và đã công bố nếu dữ liệu có.
- Tab phải đồng bộ với query string để người dùng refresh hoặc chia sẻ URL không mất ngữ cảnh.

## 5. Ghi chú

- Điều kiện học sinh nhìn thấy kết quả assessment/study report cần đối chiếu với API/luồng công bố khi viết test chi tiết.
- Tab exam trong ranking đang tạm ẩn vì sản phẩm chưa dùng.
