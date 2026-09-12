-- Add full_data and source_url to ai_lookup_history table
ALTER TABLE ai_lookup_history 
ADD COLUMN IF NOT EXISTS full_data TEXT,
ADD COLUMN IF NOT EXISTS source_url VARCHAR(500);
