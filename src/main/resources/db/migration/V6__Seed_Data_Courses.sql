-- V6__Seed_Data_Courses.sql

-- Insert a Course
INSERT INTO courses (id, name, description, level, image_url)
VALUES ('11111111-1111-1111-1111-111111111111', 'Tiếng Anh Giao Tiếp', 'Lộ trình học bài bản giúp bạn tự tin giao tiếp trong mọi tình huống.', 'Beginner', '/course-bg.jpg')
ON CONFLICT DO NOTHING;

-- Insert Topics for the Course
INSERT INTO topics (id, course_id, name, description, order_index, mascot_image_url, intro_message)
VALUES 
('22222222-2222-2222-2222-222222222221', '11111111-1111-1111-1111-111111111111', 'Hello & Goodbye', 'Học cách chào hỏi cơ bản', 0, '/mascot.jpg', 'Chào bạn! Hôm nay chúng ta sẽ học chủ đề Hello & Goodbye. Chúng ta sẽ đi qua từng kỹ năng nhé!'),
('22222222-2222-2222-2222-222222222222', '11111111-1111-1111-1111-111111111111', 'Family & Friends', 'Giới thiệu gia đình', 1, '/mascot.jpg', 'Hôm nay chúng ta sẽ học cách giới thiệu về gia đình và bạn bè.'),
('22222222-2222-2222-2222-222222222223', '11111111-1111-1111-1111-111111111111', 'Travel & Airport', 'Tiếng Anh khi đi du lịch', 2, '/mascot.jpg', 'Chuẩn bị bay thôi! Hãy học từ vựng sân bay nào.'),
('22222222-2222-2222-2222-222222222224', '11111111-1111-1111-1111-111111111111', 'Food & Drinks', 'Gọi món tại nhà hàng', 3, '/mascot.jpg', 'Bạn đói chưa? Cùng học cách gọi món nhé.')
ON CONFLICT DO NOTHING;

-- Insert Lessons (Steps) for Topic 1: Hello & Goodbye
INSERT INTO lessons (id, topic_id, title, type, order_index, content_json)
VALUES 
(gen_random_uuid(), '22222222-2222-2222-2222-222222222221', 'Từ vựng & Phát âm', 'VOCABULARY', 0, '{"word": "Hello", "pronunciation": "/həˈloʊ/", "meaning": "Xin chào", "example": "Hello, how are you today?"}'),
(gen_random_uuid(), '22222222-2222-2222-2222-222222222221', 'Điền từ (Ngữ pháp & Chính tả)', 'FILL_BLANK', 1, '{"sentence": "_____, how are you today?", "answer": "Hello"}'),
(gen_random_uuid(), '22222222-2222-2222-2222-222222222221', 'Shadowing (Nghe & Lặp lại)', 'SHADOWING', 2, '{"audioText": "Nice to meet you, I am John."}'),
(gen_random_uuid(), '22222222-2222-2222-2222-222222222221', 'Tình huống thực tế', 'SITUATION', 3, '{"situation": "Bạn gặp một người bạn cũ tên là John tại siêu thị. Bạn sẽ chào anh ấy như thế nào?"}'),
(gen_random_uuid(), '22222222-2222-2222-2222-222222222221', 'Hội thoại tự do', 'CONVERSATION', 4, '{"messages": [{"text": "Hi there! It is been a long time.", "isAI": true}, {"text": "Hello John! Yes, it has.", "isAI": false}, {"text": "How have you been?", "isAI": true}]}')
ON CONFLICT DO NOTHING;

-- Insert Lessons (Steps) for Topic 2: Family & Friends
INSERT INTO lessons (id, topic_id, title, type, order_index, content_json)
VALUES 
(gen_random_uuid(), '22222222-2222-2222-2222-222222222222', 'Từ vựng & Phát âm', 'VOCABULARY', 0, '{"word": "Family", "pronunciation": "/ˈfæm.əl.i/", "meaning": "Gia đình", "example": "I love my family."}'),
(gen_random_uuid(), '22222222-2222-2222-2222-222222222222', 'Điền từ', 'FILL_BLANK', 1, '{"sentence": "I have a big _____.", "answer": "Family"}'),
(gen_random_uuid(), '22222222-2222-2222-2222-222222222222', 'Shadowing', 'SHADOWING', 2, '{"audioText": "This is my mother and father."}'),
(gen_random_uuid(), '22222222-2222-2222-2222-222222222222', 'Tình huống thực tế', 'SITUATION', 3, '{"situation": "Giới thiệu người bạn thân nhất của bạn."}'),
(gen_random_uuid(), '22222222-2222-2222-2222-222222222222', 'Hội thoại tự do', 'CONVERSATION', 4, '{"messages": [{"text": "Do you have any siblings?", "isAI": true}]}')
ON CONFLICT DO NOTHING;
