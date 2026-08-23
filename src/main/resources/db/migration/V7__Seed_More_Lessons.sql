-- V7__Seed_More_Lessons.sql

-- Clear existing lessons for Topic 1 to avoid duplication if running again
DELETE FROM lessons WHERE topic_id = '22222222-2222-2222-2222-222222222221';

-- Re-insert richer Lessons (Steps) for Topic 1: Hello & Goodbye
INSERT INTO lessons (id, topic_id, title, type, order_index, content_json)
VALUES 
-- 1. Vocabulary
(gen_random_uuid(), '22222222-2222-2222-2222-222222222221', 'Từ vựng: Hello', 'VOCABULARY', 0, '{"word": "Hello", "pronunciation": "/həˈloʊ/", "meaning": "Xin chào", "example": "Hello, how are you today?"}'),
(gen_random_uuid(), '22222222-2222-2222-2222-222222222221', 'Từ vựng: Goodbye', 'VOCABULARY', 1, '{"word": "Goodbye", "pronunciation": "/ɡʊdˈbaɪ/", "meaning": "Tạm biệt", "example": "Goodbye, see you tomorrow."}'),
(gen_random_uuid(), '22222222-2222-2222-2222-222222222221', 'Từ vựng: Morning', 'VOCABULARY', 2, '{"word": "Morning", "pronunciation": "/ˈmɔːrnɪŋ/", "meaning": "Buổi sáng", "example": "Good morning!"}'),
(gen_random_uuid(), '22222222-2222-2222-2222-222222222221', 'Từ vựng: Evening', 'VOCABULARY', 3, '{"word": "Evening", "pronunciation": "/ˈiːvnɪŋ/", "meaning": "Buổi tối", "example": "Good evening, everyone."}'),

-- 2. Fill in the Blank
(gen_random_uuid(), '22222222-2222-2222-2222-222222222221', 'Điền từ 1', 'FILL_BLANK', 4, '{"sentence": "_____, how are you today?", "answer": "Hello"}'),
(gen_random_uuid(), '22222222-2222-2222-2222-222222222221', 'Điền từ 2', 'FILL_BLANK', 5, '{"sentence": "Good _____, see you tomorrow.", "answer": "bye"}'),
(gen_random_uuid(), '22222222-2222-2222-2222-222222222221', 'Điền từ 3', 'FILL_BLANK', 6, '{"sentence": "Good _____, it is 8 AM.", "answer": "morning"}'),

-- 3. Shadowing
(gen_random_uuid(), '22222222-2222-2222-2222-222222222221', 'Shadowing 1', 'SHADOWING', 7, '{"audioText": "Hello, it is nice to meet you."}'),
(gen_random_uuid(), '22222222-2222-2222-2222-222222222221', 'Shadowing 2', 'SHADOWING', 8, '{"audioText": "Good morning! Have a great day."}'),

-- 4. Situations
(gen_random_uuid(), '22222222-2222-2222-2222-222222222221', 'Tình huống 1', 'SITUATION', 9, '{"situation": "Bạn gặp một người bạn cũ tên là John tại siêu thị. Bạn sẽ chào anh ấy như thế nào?"}'),
(gen_random_uuid(), '22222222-2222-2222-2222-222222222221', 'Tình huống 2', 'SITUATION', 10, '{"situation": "Đã đến giờ về nhà sau giờ làm việc. Bạn tạm biệt đồng nghiệp thế nào?"}'),

-- 5. Conversations
(gen_random_uuid(), '22222222-2222-2222-2222-222222222221', 'Hội thoại tự do', 'CONVERSATION', 11, '{"messages": [{"text": "Good morning! It is a beautiful day, isn''t it?", "isAI": true}, {"text": "Yes, good morning! It really is.", "isAI": false}, {"text": "How are you doing today?", "isAI": true}]}');
