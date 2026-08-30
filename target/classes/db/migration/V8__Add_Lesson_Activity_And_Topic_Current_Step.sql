-- V8__Add_Lesson_Activity_And_Topic_Current_Step.sql

-- Tạo enum type flashcard_status nếu chưa tồn tại
-- (Hibernate DDL cần type này nhưng không tự tạo được sau khi schema reset)
DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'flashcard_status') THEN
        CREATE TYPE flashcard_status AS ENUM ('UNKNOWN', 'LEARNING', 'MASTERED');
    END IF;
END $$;

-- Bảng lưu từng thao tác của user trong 1 lesson
CREATE TABLE IF NOT EXISTS user_lesson_activity (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    lesson_id UUID NOT NULL REFERENCES lessons(id) ON DELETE CASCADE,
    topic_id UUID NOT NULL REFERENCES topics(id) ON DELETE CASCADE,
    score INTEGER,
    is_completed BOOLEAN NOT NULL DEFAULT false,
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX IF NOT EXISTS idx_lesson_activity_user_topic
    ON user_lesson_activity(user_id, topic_id);

CREATE INDEX IF NOT EXISTS idx_lesson_activity_user_lesson
    ON user_lesson_activity(user_id, lesson_id);

-- Thêm field current_step vào bảng user_topic_progress
ALTER TABLE user_topic_progress
    ADD COLUMN IF NOT EXISTS current_step INTEGER NOT NULL DEFAULT 0;
