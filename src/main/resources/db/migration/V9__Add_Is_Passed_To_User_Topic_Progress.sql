ALTER TABLE user_topic_progress 
ADD COLUMN is_passed BOOLEAN DEFAULT FALSE NOT NULL;

-- Cập nhật dữ liệu cũ: ai đang COMPLETED thì is_passed = true
UPDATE user_topic_progress 
SET is_passed = TRUE 
WHERE status = 'COMPLETED';
