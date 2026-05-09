-- ==========================================
-- PostgreSQL Database Initialization Script
-- English Learning Application
-- ==========================================

-- 1. EXTENSIONS & ENUMS
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TYPE user_role AS ENUM ('USER', 'ADMIN', 'TEACHER');
CREATE TYPE flashcard_status AS ENUM ('UNKNOWN', 'LEARNING', 'MASTERED');
CREATE TYPE group_role AS ENUM ('MEMBER', 'ADMIN');
CREATE TYPE lesson_level AS ENUM ('BEGINNER', 'INTERMEDIATE', 'ADVANCED');

-- ==========================================
-- GROUP 1: USERS & AUTHENTICATION
-- ==========================================

CREATE TABLE users (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    email VARCHAR(255) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    name VARCHAR(100) NOT NULL,
    role user_role DEFAULT 'USER',
    avatar_url VARCHAR(500),
    
    -- Thống kê hiển thị ra UI (Streak, Goals)
    current_streak INT DEFAULT 0,
    longest_streak INT DEFAULT 0,
    last_study_date DATE,
    
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_users_email ON users(email);

-- ==========================================
-- GROUP 2: FLASHCARDS SYSTEM
-- ==========================================

CREATE TABLE flashcard_sets (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(255) NOT NULL,
    description TEXT,
    emoji VARCHAR(10),
    owner_id UUID REFERENCES users(id) ON DELETE CASCADE,
    is_public BOOLEAN DEFAULT false,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_flashcard_sets_owner ON flashcard_sets(owner_id);
CREATE INDEX idx_flashcard_sets_is_public ON flashcard_sets(is_public);

CREATE TABLE flashcards (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    set_id UUID REFERENCES flashcard_sets(id) ON DELETE CASCADE,
    word VARCHAR(255) NOT NULL,
    meaning VARCHAR(500) NOT NULL,
    pronunciation VARCHAR(255),
    example TEXT,
    image_url VARCHAR(500),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_flashcards_set ON flashcards(set_id);

-- Tách bảng Progress riêng để User clone bộ bài học mà không ảnh hưởng tới tiến trình người khác
CREATE TABLE user_flashcard_progress (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    user_id UUID REFERENCES users(id) ON DELETE CASCADE,
    flashcard_id UUID REFERENCES flashcards(id) ON DELETE CASCADE,
    
    -- Tương ứng với bộ lọc ['UNKNOWN', 'LEARNING', 'MASTERED']
    status flashcard_status DEFAULT 'UNKNOWN',
    is_favorite BOOLEAN DEFAULT false,
    
    -- Phục vụ Spaced Repetition sau này
    next_review_date TIMESTAMP WITH TIME ZONE,
    last_reviewed_at TIMESTAMP WITH TIME ZONE,
    
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    
    UNIQUE(user_id, flashcard_id) -- Mỗi user chỉ có 1 progress trên 1 flashcard
);

CREATE INDEX idx_user_flashcard_progress_user ON user_flashcard_progress(user_id);
CREATE INDEX idx_user_flashcard_progress_status ON user_flashcard_progress(user_id, status);

-- ==========================================
-- GROUP 3: STUDY GROUPS
-- ==========================================

CREATE TABLE study_groups (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(255) NOT NULL,
    description TEXT,
    join_code VARCHAR(50) UNIQUE,
    owner_id UUID REFERENCES users(id) ON DELETE SET NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_study_groups_owner ON study_groups(owner_id);
CREATE INDEX idx_study_groups_join_code ON study_groups(join_code);

CREATE TABLE study_group_members (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    group_id UUID REFERENCES study_groups(id) ON DELETE CASCADE,
    user_id UUID REFERENCES users(id) ON DELETE CASCADE,
    role group_role DEFAULT 'MEMBER',
    joined_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(group_id, user_id)
);

CREATE INDEX idx_study_group_members_group ON study_group_members(group_id);
CREATE INDEX idx_study_group_members_user ON study_group_members(user_id);

CREATE TABLE study_group_sets (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    group_id UUID REFERENCES study_groups(id) ON DELETE CASCADE,
    set_id UUID REFERENCES flashcard_sets(id) ON DELETE CASCADE,
    added_by UUID REFERENCES users(id) ON DELETE SET NULL,
    added_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(group_id, set_id)
);

CREATE INDEX idx_study_group_sets_group ON study_group_sets(group_id);
CREATE INDEX idx_study_group_sets_set ON study_group_sets(set_id);

-- ==========================================
-- GROUP 4: DAILY PROGRESS & STATS
-- ==========================================

-- Biểu đồ ProgressPage (Thứ 2, Thứ 3...)
CREATE TABLE daily_study_stats (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    user_id UUID REFERENCES users(id) ON DELETE CASCADE,
    study_date DATE NOT NULL,
    words_learned_count INT DEFAULT 0,
    words_reviewed_count INT DEFAULT 0,
    time_spent_seconds INT DEFAULT 0,
    
    UNIQUE(user_id, study_date)
);

CREATE INDEX idx_daily_study_stats_user ON daily_study_stats(user_id);

-- ==========================================
-- GROUP 5: FIXED LESSONS & QUIZZES
-- ==========================================

CREATE TABLE lessons (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    title VARCHAR(255) NOT NULL,
    description TEXT,
    category VARCHAR(100),
    level lesson_level,
    duration INT, -- Tính bằng phút
    content TEXT,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_lessons_category ON lessons(category);
CREATE INDEX idx_lessons_level ON lessons(level);

CREATE TABLE quizzes (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    title VARCHAR(255) NOT NULL,
    lesson_id UUID REFERENCES lessons(id) ON DELETE CASCADE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_quizzes_lesson ON quizzes(lesson_id);

CREATE TABLE questions (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    quiz_id UUID REFERENCES quizzes(id) ON DELETE CASCADE,
    question_text TEXT NOT NULL,
    options JSONB NOT NULL, -- Mảng 4 đáp án
    correct_answer_index INT NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_questions_quiz ON questions(quiz_id);
