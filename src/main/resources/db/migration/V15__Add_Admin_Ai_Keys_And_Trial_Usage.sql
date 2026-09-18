-- V15: Add Admin AI Keys, User AI Settings, and Device Trial Usage tables

-- 1. Admin AI Keys (Hệ thống khóa API của Admin dùng cho chế độ dùng thử)
CREATE TABLE IF NOT EXISTS admin_ai_keys (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    key_name VARCHAR(100) NOT NULL,
    encrypted_key TEXT NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    usage_count BIGINT NOT NULL DEFAULT 0,
    last_used_at TIMESTAMP WITH TIME ZONE,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- 2. User AI Settings (Khóa API cá nhân của người dùng được mã hóa)
CREATE TABLE IF NOT EXISTS user_ai_settings (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID NOT NULL UNIQUE REFERENCES users(id) ON DELETE CASCADE,
    encrypted_api_key TEXT,
    preferred_model VARCHAR(100) DEFAULT 'gemini-2.5-flash',
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- 3. Device Trial Usage (Quản lý và chống gian lận lượt dùng thử theo Thiết bị / Cookie / IP)
CREATE TABLE IF NOT EXISTS device_trial_usage (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    device_id VARCHAR(255) NOT NULL,
    feature_name VARCHAR(100) NOT NULL,
    usage_count INT NOT NULL DEFAULT 0,
    user_id UUID REFERENCES users(id) ON DELETE SET NULL,
    ip_address VARCHAR(100),
    last_used_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT uq_device_feature UNIQUE (device_id, feature_name)
);

CREATE INDEX IF NOT EXISTS idx_device_trial_device_id ON device_trial_usage(device_id);
CREATE INDEX IF NOT EXISTS idx_device_trial_feature ON device_trial_usage(feature_name);
