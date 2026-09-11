-- V13__Add_Google_OAuth_Fields.sql
-- Thêm hỗ trợ đăng nhập bằng Google OAuth2

-- 1. Cho phép password_hash là NULL (dành cho tài khoản Google)
ALTER TABLE users ALTER COLUMN password_hash DROP NOT NULL;

-- 2. Thêm cột provider để phân biệt LOCAL và GOOGLE
ALTER TABLE users ADD COLUMN IF NOT EXISTS provider VARCHAR(50) NOT NULL DEFAULT 'LOCAL';

-- 3. Thêm cột provider_id để lưu Google UID (sub)
ALTER TABLE users ADD COLUMN IF NOT EXISTS provider_id VARCHAR(255);

-- 4. Index để tìm nhanh theo provider + provider_id
CREATE INDEX IF NOT EXISTS idx_users_provider_provider_id ON users(provider, provider_id);
