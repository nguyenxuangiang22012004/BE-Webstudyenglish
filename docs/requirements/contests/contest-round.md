# Tài Liệu BA Chi Tiết: Contest Round

Status: reviewed
Owner: BA/DEV
Last reviewed: 2026-09-16
Related:
  - docs/api/other/contest-round.md
  - docs/security/resources/contest-rounds.md
  - docs/requirements/contests/contest.md
  - docs/test-cases/overview.md

Business rule IDs:
  - CRD-BR-001: Contest round là vòng thi thuộc một contest.
  - CRD-BR-002: Contest round xác định nội dung/điều kiện tham gia theo từng vòng.

Product note: Tương tự Contest, Contest Round có hoạt động trong code nhưng hiện đang bị ẩn vì sản phẩm chưa dùng. Khi sản phẩm bật lại module Contest, PM/BA cần review lại nghiệp vụ Contest Round trước khi dùng tài liệu này làm source of truth cuối cùng.

## 1. Khái niệm contest round

Contest round là vòng thi nằm trong một contest, dùng để chia cuộc thi thành các giai đoạn.

## 2. Phạm vi chức năng hiện có

API hiện có:
- `GET /v1/contest-rounds`
- `POST /v1/contest-rounds`
- `GET /v1/contest-rounds/{id}`
- `PUT /v1/contest-rounds/{id}`
- `DELETE /v1/contest-rounds/{id}`

Swagger ghi nhận 12 operation cho `ContestRoundService`; cần đối chiếu file API đầy đủ khi triển khai test chi tiết.

## 3. Quy tắc nghiệp vụ chính

- Contest round cần thuộc một contest hợp lệ.
- Thứ tự, thời gian và trạng thái vòng thi cần nhất quán nếu backend có field tương ứng.
- Xóa round đã có lượt thi/kết quả cần kiểm tra ràng buộc backend.

## 4. Ghi chú kiểm thử

- Chức năng Contest Round hiện có hoạt động trong code nhưng đang bị ẩn cùng module Contest vì sản phẩm chưa dùng.
- Khi bật lại Contest, PM/BA cần review lại nghiệp vụ Contest Round, bao gồm việc round có gắn question/exam riêng không, quy tắc chuyển vòng và quy tắc tính điểm.
