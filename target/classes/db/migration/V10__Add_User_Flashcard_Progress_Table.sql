DO $$ 
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'flashcard_status') THEN
        CREATE TYPE flashcard_status AS ENUM ('UNKNOWN', 'LEARNING', 'MASTERED');
    END IF;
END $$;

CREATE TABLE IF NOT EXISTS user_flashcard_progress (
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    flashcard_id UUID NOT NULL REFERENCES flashcards(id) ON DELETE CASCADE,
    status flashcard_status NOT NULL DEFAULT 'UNKNOWN',
    next_review_date TIMESTAMPTZ,
    last_reviewed_at TIMESTAMPTZ,
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(user_id, flashcard_id)
);

CREATE INDEX IF NOT EXISTS idx_user_flashcard_progress_user ON user_flashcard_progress(user_id);
