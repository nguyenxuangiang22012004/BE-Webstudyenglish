CREATE TABLE IF NOT EXISTS ai_lookup_history (
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL,
    word VARCHAR(255) NOT NULL,
    part_of_speech VARCHAR(50),
    pronunciation VARCHAR(100),
    meaning VARCHAR(255),
    example TEXT,
    created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_ai_lookup_history_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE INDEX idx_ai_lookup_history_user_created ON ai_lookup_history(user_id, created_at DESC);
