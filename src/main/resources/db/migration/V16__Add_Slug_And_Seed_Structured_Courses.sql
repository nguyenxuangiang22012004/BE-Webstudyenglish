-- V16__Add_Slug_And_Seed_Structured_Courses.sql

-- 1. Thêm cột slug vào bảng courses và topics nếu chưa có
ALTER TABLE courses ADD COLUMN IF NOT EXISTS slug VARCHAR(100) UNIQUE;
ALTER TABLE topics ADD COLUMN IF NOT EXISTS slug VARCHAR(100) UNIQUE;

-- Cập nhật slug cho khóa cũ nếu có
UPDATE courses SET slug = 'tieng-anh-giao-tiep' WHERE id = '11111111-1111-1111-1111-111111111111' AND slug IS NULL;
UPDATE topics SET slug = 'hello-and-goodbye' WHERE id = '22222222-2222-2222-2222-222222222221' AND slug IS NULL;
UPDATE topics SET slug = 'family-and-friends' WHERE id = '22222222-2222-2222-2222-222222222222' AND slug IS NULL;
UPDATE topics SET slug = 'travel-and-airport' WHERE id = '22222222-2222-2222-2222-222222222223' AND slug IS NULL;
UPDATE topics SET slug = 'food-and-drinks' WHERE id = '22222222-2222-2222-2222-222222222224' AND slug IS NULL;

-- 2. Chèn 3 Khóa học theo các Level chuẩn (Beginner, Intermediate, Advanced)
INSERT INTO courses (id, slug, name, description, level, image_url)
VALUES 
('c0000001-0000-0000-0000-000000000000', 'beginner', 'Tiếng Anh Giao Tiếp Cơ Bản', 'Lộ trình học bài bản giúp bạn tự tin giao tiếp trong các tình huống thường ngày.', 'Beginner', '/course-bg.jpg'),
('c0000002-0000-0000-0000-000000000000', 'intermediate', 'Tiếng Anh Đời Sống & Du Lịch', 'Phát triển phản xạ nghe nói linh hoạt khi đi du lịch, mua sắm và giao lưu quốc tế.', 'Intermediate', '/course-bg.jpg'),
('c0000003-0000-0000-0000-000000000000', 'advanced', 'Tiếng Anh Công Sở & Thương Mại', 'Nâng cao kỹ năng phỏng vấn, thuyết trình, họp hành và đàm phán thương mại chuyên nghiệp.', 'Advanced', '/course-bg.jpg')
ON CONFLICT (id) DO UPDATE SET 
    slug = EXCLUDED.slug,
    name = EXCLUDED.name,
    description = EXCLUDED.description,
    level = EXCLUDED.level,
    image_url = EXCLUDED.image_url;

-- 3. Chèn các Topics cho từng khóa học (Sử dụng hex UUID hợp lệ với tiền tố b)
INSERT INTO topics (id, course_id, slug, name, description, order_index, mascot_image_url, intro_message)
VALUES 
-- Khóa 1 (Beginner)
('b0000001-0000-0000-0000-000000000001', 'c0000001-0000-0000-0000-000000000000', 'hello-greetings', 'Hello & Greetings', 'Học cách chào hỏi, tạm biệt và làm quen cơ bản', 0, '/mascot.jpg', 'Chào bạn! Hãy cùng làm quen với những câu chào hỏi thông dụng nhất nhé.'),
('b0000001-0000-0000-0000-000000000002', 'c0000001-0000-0000-0000-000000000000', 'family-friends', 'Family & Friends', 'Giới thiệu gia đình và các mối quan hệ thân thiết', 1, '/mascot.jpg', 'Hôm nay chúng ta sẽ học cách giới thiệu về những người thân yêu trong gia đình.'),
('b0000001-0000-0000-0000-000000000003', 'c0000001-0000-0000-0000-000000000000', 'daily-routine', 'Daily Routine & Habits', 'Kể về thói quen và sinh hoạt hàng ngày', 2, '/mascot.jpg', 'Cùng khám phá cách kể về một ngày làm việc và giải trí của bạn bằng tiếng Anh nào!'),
('b0000001-0000-0000-0000-000000000004', 'c0000001-0000-0000-0000-000000000000', 'food-drinks', 'Food, Drinks & Ordering', 'Gọi món và giao tiếp lịch sự tại nhà hàng', 3, '/mascot.jpg', 'Bạn đói bụng chưa? Cùng học cách gọi những món ngon yêu thích tại nhà hàng nhé!'),

-- Khóa 2 (Intermediate)
('b0000002-0000-0000-0000-000000000001', 'c0000002-0000-0000-0000-000000000000', 'travel-airport', 'Travel & Airport Navigation', 'Thủ tục sân bay, hải quan và chuyến bay quốc tế', 0, '/mascot.jpg', 'Chuẩn bị cất cánh thôi! Cùng nắm vững các mẫu câu tại sân bay quốc tế nào.'),
('b0000002-0000-0000-0000-000000000002', 'c0000002-0000-0000-0000-000000000000', 'hotel-stay', 'Hotel & Accommodation', 'Đặt phòng, yêu cầu dịch vụ và thanh toán khách sạn', 1, '/mascot.jpg', 'Hôm nay chúng ta sẽ đóng vai khách du lịch giao tiếp với lễ tân khách sạn.'),
('b0000002-0000-0000-0000-000000000003', 'c0000002-0000-0000-0000-000000000000', 'shopping', 'Shopping & Bargaining', 'Mua sắm, hỏi giá, thử size và chính sách đổi trả', 2, '/mascot.jpg', 'Cùng dạo phố mua sắm và học cách hỏi size, mặc cả và thanh toán nhé!'),
('b0000002-0000-0000-0000-000000000004', 'c0000002-0000-0000-0000-000000000000', 'health-doctor', 'Health & Doctor Visit', 'Mô tả triệu chứng bệnh và mua thuốc ở hiệu thuốc', 3, '/mascot.jpg', 'Khi gặp vấn đề sức khỏe ở nước ngoài, bạn sẽ diễn đạt triệu chứng như thế nào?'),

-- Khóa 3 (Advanced)
('b0000003-0000-0000-0000-000000000001', 'c0000003-0000-0000-0000-000000000000', 'job-interview', 'Job Interview & Career', 'Kỹ năng trả lời phỏng vấn tuyển dụng chuyên nghiệp', 0, '/mascot.jpg', 'Chào bạn! Hãy chuẩn bị cho buổi phỏng vấn xin việc mơ ước với những câu trả lời ấn tượng.'),
('b0000003-0000-0000-0000-000000000002', 'c0000003-0000-0000-0000-000000000000', 'office-meetings', 'Office Meetings & Collaboration', 'Thảo luận, phản biện và đóng góp ý kiến trong cuộc họp', 1, '/mascot.jpg', 'Cùng học cách trình bày ý kiến và thảo luận công việc chuyên nghiệp cùng đồng nghiệp.'),
('b0000003-0000-0000-0000-000000000003', 'c0000003-0000-0000-0000-000000000000', 'business-emails', 'Business Emails & Communication', 'Soạn thảo email trang trọng và thư tín thương mại', 2, '/mascot.jpg', 'Nắm vững nghệ thuật viết thư tín thương mại và email đối ngoại chuẩn quốc tế.'),
('b0000003-0000-0000-0000-000000000004', 'c0000003-0000-0000-0000-000000000000', 'pitching-presentation', 'Pitching & Presentation', 'Thuyết trình dự án, chốt hợp đồng và đàm phán', 3, '/mascot.jpg', 'Hôm nay bạn sẽ thực hành kỹ năng pitching ý tưởng và đàm phán với đối tác!')
ON CONFLICT (id) DO UPDATE SET 
    slug = EXCLUDED.slug,
    name = EXCLUDED.name,
    description = EXCLUDED.description,
    order_index = EXCLUDED.order_index,
    mascot_image_url = EXCLUDED.mascot_image_url,
    intro_message = EXCLUDED.intro_message;

-- 4. Xóa các lessons cũ của các Topic này (nếu có) để re-seed sạch sẽ
DELETE FROM lessons WHERE topic_id IN (
    'b0000001-0000-0000-0000-000000000001',
    'b0000001-0000-0000-0000-000000000002',
    'b0000001-0000-0000-0000-000000000003',
    'b0000001-0000-0000-0000-000000000004',
    'b0000002-0000-0000-0000-000000000001',
    'b0000002-0000-0000-0000-000000000002',
    'b0000002-0000-0000-0000-000000000003',
    'b0000002-0000-0000-0000-000000000004',
    'b0000003-0000-0000-0000-000000000001',
    'b0000003-0000-0000-0000-000000000002',
    'b0000003-0000-0000-0000-000000000003',
    'b0000003-0000-0000-0000-000000000004'
);

-- ==========================================
-- 5. CHÈN BÀI HỌC (LESSONS) CHO TỪNG TOPIC (Tiền tố hex f)
-- ==========================================

-- KHÓA 1 - TOPIC 1: Hello & Greetings
INSERT INTO lessons (id, topic_id, title, type, order_index, content_json) VALUES
('f0000101-0000-0000-0000-000000000001', 'b0000001-0000-0000-0000-000000000001', 'Từ vựng: Hello', 'VOCABULARY', 0, '{"word": "Hello", "pronunciation": "/həˈloʊ/", "meaning": "Xin chào", "example": "Hello, how are you today?"}'),
('f0000101-0000-0000-0000-000000000002', 'b0000001-0000-0000-0000-000000000001', 'Từ vựng: Goodbye', 'VOCABULARY', 1, '{"word": "Goodbye", "pronunciation": "/ɡʊdˈbaɪ/", "meaning": "Tạm biệt", "example": "Goodbye, see you tomorrow!"}'),
('f0000101-0000-0000-0000-000000000003', 'b0000001-0000-0000-0000-000000000001', 'Từ vựng: Morning', 'VOCABULARY', 2, '{"word": "Morning", "pronunciation": "/ˈmɔːrnɪŋ/", "meaning": "Buổi sáng", "example": "Good morning! Have a great day."}'),
('f0000101-0000-0000-0000-000000000004', 'b0000001-0000-0000-0000-000000000001', 'Điền từ 1', 'FILL_BLANK', 3, '{"sentence": "_____, nice to meet you!", "answer": "Hello"}'),
('f0000101-0000-0000-0000-000000000005', 'b0000001-0000-0000-0000-000000000001', 'Điền từ 2', 'FILL_BLANK', 4, '{"sentence": "Good _____, everyone!", "answer": "morning"}'),
('f0000101-0000-0000-0000-000000000006', 'b0000001-0000-0000-0000-000000000001', 'Shadowing 1', 'SHADOWING', 5, '{"audioText": "Hello! It is wonderful to meet you."}'),
('f0000101-0000-0000-0000-000000000007', 'b0000001-0000-0000-0000-000000000001', 'Tình huống: Gặp bạn mới', 'SITUATION', 6, '{"situation": "Bạn gặp một người bạn quốc tế mới chuyển đến lớp học. Hãy gửi lời chào và hỏi thăm sức khỏe của họ."}'),
('f0000101-0000-0000-0000-000000000008', 'b0000001-0000-0000-0000-000000000001', 'Hội thoại mẫu', 'CONVERSATION', 7, '{"messages": [{"text": "Hello! Welcome to our school.", "isAI": true}, {"text": "Hi! Thank you very much.", "isAI": false}, {"text": "How is your first day going?", "isAI": true}]}');

-- KHÓA 1 - TOPIC 2: Family & Friends
INSERT INTO lessons (id, topic_id, title, type, order_index, content_json) VALUES
('f0000102-0000-0000-0000-000000000001', 'b0000001-0000-0000-0000-000000000002', 'Từ vựng: Family', 'VOCABULARY', 0, '{"word": "Family", "pronunciation": "/ˈfæm.əl.i/", "meaning": "Gia đình", "example": "I love spending time with my family."}'),
('f0000102-0000-0000-0000-000000000002', 'b0000001-0000-0000-0000-000000000002', 'Từ vựng: Parent', 'VOCABULARY', 1, '{"word": "Parent", "pronunciation": "/ˈper.ənt/", "meaning": "Bố/Mẹ (phụ huynh)", "example": "My parents live in Da Nang."}'),
('f0000102-0000-0000-0000-000000000003', 'b0000001-0000-0000-0000-000000000002', 'Từ vựng: Friend', 'VOCABULARY', 2, '{"word": "Friend", "pronunciation": "/frend/", "meaning": "Bạn bè", "example": "He is my best friend from high school."}'),
('f0000102-0000-0000-0000-000000000004', 'b0000001-0000-0000-0000-000000000002', 'Điền từ 1', 'FILL_BLANK', 3, '{"sentence": "I have a very supportive _____.", "answer": "family"}'),
('f0000102-0000-0000-0000-000000000005', 'b0000001-0000-0000-0000-000000000002', 'Shadowing', 'SHADOWING', 4, '{"audioText": "This is my best friend, Alex."}'),
('f0000102-0000-0000-0000-000000000006', 'b0000001-0000-0000-0000-000000000002', 'Tình huống: Giới thiệu bạn thân', 'SITUATION', 5, '{"situation": "Bạn đang đi chơi cùng bạn thân và vô tình gặp thầy giáo. Hãy giới thiệu bạn thân của mình với thầy."}'),
('f0000102-0000-0000-0000-000000000007', 'b0000001-0000-0000-0000-000000000002', 'Hội thoại mẫu', 'CONVERSATION', 6, '{"messages": [{"text": "Do you have any brothers or sisters?", "isAI": true}, {"text": "Yes, I have one older sister.", "isAI": false}]}');

-- KHÓA 1 - TOPIC 3: Daily Routine & Habits
INSERT INTO lessons (id, topic_id, title, type, order_index, content_json) VALUES
('f0000103-0000-0000-0000-000000000001', 'b0000001-0000-0000-0000-000000000003', 'Từ vựng: Breakfast', 'VOCABULARY', 0, '{"word": "Breakfast", "pronunciation": "/ˈbrek.fəst/", "meaning": "Bữa sáng", "example": "I usually have breakfast at 7 AM."}'),
('f0000103-0000-0000-0000-000000000002', 'b0000001-0000-0000-0000-000000000003', 'Từ vựng: Exercise', 'VOCABULARY', 1, '{"word": "Exercise", "pronunciation": "/ˈek.sɚ.saɪz/", "meaning": "Tập thể dục", "example": "I exercise thirty minutes every day."}'),
('f0000103-0000-0000-0000-000000000003', 'b0000001-0000-0000-0000-000000000003', 'Điền từ', 'FILL_BLANK', 2, '{"sentence": "Healthy people eat _____ every morning.", "answer": "breakfast"}'),
('f0000103-0000-0000-0000-000000000004', 'b0000001-0000-0000-0000-000000000003', 'Shadowing', 'SHADOWING', 3, '{"audioText": "I wake up early and go jogging in the park."}'),
('f0000103-0000-0000-0000-000000000005', 'b0000001-0000-0000-0000-000000000003', 'Tình huống: Lịch trình hàng ngày', 'SITUATION', 4, '{"situation": "Đồng nghiệp hỏi bạn thường làm gì vào các buổi sáng trước khi đi làm. Hãy trả lời ngắn gọn."}');

-- KHÓA 1 - TOPIC 4: Food & Drinks
INSERT INTO lessons (id, topic_id, title, type, order_index, content_json) VALUES
('f0000104-0000-0000-0000-000000000001', 'b0000001-0000-0000-0000-000000000004', 'Từ vựng: Delicious', 'VOCABULARY', 0, '{"word": "Delicious", "pronunciation": "/dɪˈlɪʃ.əs/", "meaning": "Ngon miệng", "example": "This pasta is very delicious."}'),
('f0000104-0000-0000-0000-000000000002', 'b0000001-0000-0000-0000-000000000004', 'Từ vựng: Menu', 'VOCABULARY', 1, '{"word": "Menu", "pronunciation": "/ˈmen.juː/", "meaning": "Thực đơn", "example": "Could we please see the dessert menu?"}'),
('f0000104-0000-0000-0000-000000000003', 'b0000001-0000-0000-0000-000000000004', 'Điền từ', 'FILL_BLANK', 2, '{"sentence": "Excuse me, can I have the _____?", "answer": "menu"}'),
('f0000104-0000-0000-0000-000000000004', 'b0000001-0000-0000-0000-000000000004', 'Shadowing', 'SHADOWING', 3, '{"audioText": "Could I have a cup of coffee with milk, please?"}'),
('f0000104-0000-0000-0000-000000000005', 'b0000001-0000-0000-0000-000000000004', 'Tình huống: Gọi món nhà hàng', 'SITUATION', 4, '{"situation": "Bạn đang ở một nhà hàng Ý. Hãy gọi 1 đĩa Pizza hải sản và 1 ly nước cam ép."}');

-- KHÓA 2 - TOPIC 1: Travel & Airport Navigation
INSERT INTO lessons (id, topic_id, title, type, order_index, content_json) VALUES
('f0000201-0000-0000-0000-000000000001', 'b0000002-0000-0000-0000-000000000001', 'Từ vựng: Passport', 'VOCABULARY', 0, '{"word": "Passport", "pronunciation": "/ˈpæs.pɔːrt/", "meaning": "Hộ chiếu", "example": "Please show your passport and ticket."}'),
('f0000201-0000-0000-0000-000000000002', 'b0000002-0000-0000-0000-000000000001', 'Từ vựng: Boarding Pass', 'VOCABULARY', 1, '{"word": "Boarding", "pronunciation": "/ˈbɔːr.dɪŋ/", "meaning": "Lên máy bay", "example": "Boarding will begin in ten minutes at gate 4."}'),
('f0000201-0000-0000-0000-000000000003', 'b0000002-0000-0000-0000-000000000001', 'Từ vựng: Luggage', 'VOCABULARY', 2, '{"word": "Luggage", "pronunciation": "/ˈlʌɡ.ɪdʒ/", "meaning": "Hành lý", "example": "How many pieces of luggage do you have?"}'),
('f0000201-0000-0000-0000-000000000004', 'b0000002-0000-0000-0000-000000000001', 'Điền từ', 'FILL_BLANK', 3, '{"sentence": "Please keep your _____ with you at all times.", "answer": "passport"}'),
('f0000201-0000-0000-0000-000000000005', 'b0000002-0000-0000-0000-000000000001', 'Shadowing', 'SHADOWING', 4, '{"audioText": "Where can I find the baggage claim area?"}'),
('f0000201-0000-0000-0000-000000000006', 'b0000002-0000-0000-0000-000000000001', 'Tình huống: Quầy Check-in', 'SITUATION', 5, '{"situation": "Bạn đang ở quầy check-in sân bay. Nhân viên hỏi bạn muốn ghế ngồi cạnh cửa sổ hay lối đi. Hãy trả lời họ."}');

-- KHÓA 2 - TOPIC 2: Hotel & Accommodation
INSERT INTO lessons (id, topic_id, title, type, order_index, content_json) VALUES
('f0000202-0000-0000-0000-000000000001', 'b0000002-0000-0000-0000-000000000002', 'Từ vựng: Reservation', 'VOCABULARY', 0, '{"word": "Reservation", "pronunciation": "/ˌrez.ɚˈveɪ.ʃən/", "meaning": "Sự đặt phòng trước", "example": "I have a reservation for two nights."}'),
('f0000202-0000-0000-0000-000000000002', 'b0000002-0000-0000-0000-000000000002', 'Từ vựng: Reception', 'VOCABULARY', 1, '{"word": "Reception", "pronunciation": "/rɪˈsep.ʃən/", "meaning": "Quầy lễ tân", "example": "You can leave your key at the reception."}'),
('f0000202-0000-0000-0000-000000000003', 'b0000002-0000-0000-0000-000000000002', 'Điền từ', 'FILL_BLANK', 2, '{"sentence": "I would like to make a hotel _____.", "answer": "reservation"}'),
('f0000202-0000-0000-0000-000000000004', 'b0000002-0000-0000-0000-000000000002', 'Shadowing', 'SHADOWING', 3, '{"audioText": "What time is checkout tomorrow morning?"}'),
('f0000202-0000-0000-0000-000000000005', 'b0000002-0000-0000-0000-000000000002', 'Tình huống: Check-in Khách sạn', 'SITUATION', 4, '{"situation": "Bạn đến khách sạn và muốn làm thủ tục nhận phòng theo tên đặt là Nguyen Van A."}');

-- KHÓA 2 - TOPIC 3: Shopping & Bargaining
INSERT INTO lessons (id, topic_id, title, type, order_index, content_json) VALUES
('f0000203-0000-0000-0000-000000000001', 'b0000002-0000-0000-0000-000000000003', 'Từ vựng: Discount', 'VOCABULARY', 0, '{"word": "Discount", "pronunciation": "/ˈdɪs.kaʊnt/", "meaning": "Chiết khấu, giảm giá", "example": "Can you give me a ten percent discount?"}'),
('f0000203-0000-0000-0000-000000000002', 'b0000002-0000-0000-0000-000000000003', 'Từ vựng: Receipt', 'VOCABULARY', 1, '{"word": "Receipt", "pronunciation": "/rɪˈsiːt/", "meaning": "Hóa đơn mua hàng", "example": "Please keep your receipt for returns."}'),
('f0000203-0000-0000-0000-000000000003', 'b0000002-0000-0000-0000-000000000003', 'Điền từ', 'FILL_BLANK', 2, '{"sentence": "Is there any special _____ on these shoes today?", "answer": "discount"}'),
('f0000203-0000-0000-0000-000000000004', 'b0000002-0000-0000-0000-000000000003', 'Shadowing', 'SHADOWING', 3, '{"audioText": "Could I try this blue shirt on in the fitting room?"}'),
('f0000203-0000-0000-0000-000000000005', 'b0000002-0000-0000-0000-000000000003', 'Tình huống: Hỏi size áo', 'SITUATION', 4, '{"situation": "Bạn thấy một chiếc áo khoác rất đẹp nhưng size hiện tại là M. Hãy hỏi nhân viên bán hàng xem còn size L không."}');

-- KHÓA 2 - TOPIC 4: Health & Doctor Visit
INSERT INTO lessons (id, topic_id, title, type, order_index, content_json) VALUES
('f0000204-0000-0000-0000-000000000001', 'b0000002-0000-0000-0000-000000000004', 'Từ vựng: Headache', 'VOCABULARY', 0, '{"word": "Headache", "pronunciation": "/ˈhed.eɪk/", "meaning": "Đau đầu", "example": "I have had a terrible headache all day."}'),
('f0000204-0000-0000-0000-000000000002', 'b0000002-0000-0000-0000-000000000004', 'Từ vựng: Pharmacy', 'VOCABULARY', 1, '{"word": "Pharmacy", "pronunciation": "/ˈfɑːr.mə.si/", "meaning": "Hiệu thuốc", "example": "Where is the nearest 24-hour pharmacy?"}'),
('f0000204-0000-0000-0000-000000000003', 'b0000002-0000-0000-0000-000000000004', 'Điền từ', 'FILL_BLANK', 2, '{"sentence": "I bought some pain medicine at the _____.", "answer": "pharmacy"}'),
('f0000204-0000-0000-0000-000000000004', 'b0000002-0000-0000-0000-000000000004', 'Shadowing', 'SHADOWING', 3, '{"audioText": "Take this medicine twice a day after meals."}'),
('f0000204-0000-0000-0000-000000000005', 'b0000002-0000-0000-0000-000000000004', 'Tình huống: Gặp Bác sĩ', 'SITUATION', 4, '{"situation": "Bạn đang gặp bác sĩ. Hãy nói rằng bạn bị sốt và ho liên tục từ tối hôm qua."}');

-- KHÓA 3 - TOPIC 1: Job Interview & Career
INSERT INTO lessons (id, topic_id, title, type, order_index, content_json) VALUES
('f0000301-0000-0000-0000-000000000001', 'b0000003-0000-0000-0000-000000000001', 'Từ vựng: Experience', 'VOCABULARY', 0, '{"word": "Experience", "pronunciation": "/ɪkˈspɪr.i.əns/", "meaning": "Kinh nghiệm làm việc", "example": "I have over five years of experience in software development."}'),
('f0000301-0000-0000-0000-000000000002', 'b0000003-0000-0000-0000-000000000001', 'Từ vựng: Strength', 'VOCABULARY', 1, '{"word": "Strength", "pronunciation": "/streŋθ/", "meaning": "Thế mạnh, điểm mạnh", "example": "My key strength is clear communication with clients."}'),
('f0000301-0000-0000-0000-000000000003', 'b0000003-0000-0000-0000-000000000001', 'Điền từ', 'FILL_BLANK', 2, '{"sentence": "Problem solving is my greatest professional _____.", "answer": "strength"}'),
('f0000301-0000-0000-0000-000000000004', 'b0000003-0000-0000-0000-000000000001', 'Shadowing', 'SHADOWING', 3, '{"audioText": "I am passionate about building scalable and user-friendly products."}'),
('f0000301-0000-0000-0000-000000000005', 'b0000003-0000-0000-0000-000000000001', 'Tình huống: Phỏng vấn xin việc', 'SITUATION', 4, '{"situation": "Nhà tuyển dụng hỏi: Why should we hire you? Hãy trả lời nêu bật kinh nghiệm và tinh thần trách nhiệm của bạn."}');

-- KHÓA 3 - TOPIC 2: Office Meetings
INSERT INTO lessons (id, topic_id, title, type, order_index, content_json) VALUES
('f0000302-0000-0000-0000-000000000001', 'b0000003-0000-0000-0000-000000000002', 'Từ vựng: Agenda', 'VOCABULARY', 0, '{"word": "Agenda", "pronunciation": "/əˈdʒen.də/", "meaning": "Chương trình nghị sự / nội dung cuộc họp", "example": "Let us review the main agenda for today meeting."}'),
('f0000302-0000-0000-0000-000000000002', 'b0000003-0000-0000-0000-000000000002', 'Từ vựng: Deadline', 'VOCABULARY', 1, '{"word": "Deadline", "pronunciation": "/ˈded.laɪn/", "meaning": "Hạn chót công việc", "example": "We must complete this sprint before Friday deadline."}'),
('f0000302-0000-0000-0000-000000000003', 'b0000003-0000-0000-0000-000000000002', 'Điền từ', 'FILL_BLANK', 2, '{"sentence": "The project _____ is set for the end of this month.", "answer": "deadline"}'),
('f0000302-0000-0000-0000-000000000004', 'b0000003-0000-0000-0000-000000000002', 'Shadowing', 'SHADOWING', 3, '{"audioText": "I agree with your suggestion, but let us also consider the budget constraints."}'),
('f0000302-0000-0000-0000-000000000005', 'b0000003-0000-0000-0000-000000000002', 'Tình huống: Ý kiến trong cuộc họp', 'SITUATION', 4, '{"situation": "Trong cuộc họp công ty, bạn muốn đề xuất dời ngày ra mắt sản phẩm thêm 1 tuần để kiểm thử bảo mật. Hãy trình bày ý kiến lịch sự."}');

-- KHÓA 3 - TOPIC 3: Business Emails
INSERT INTO lessons (id, topic_id, title, type, order_index, content_json) VALUES
('f0000303-0000-0000-0000-000000000001', 'b0000003-0000-0000-0000-000000000003', 'Từ vựng: Attachment', 'VOCABULARY', 0, '{"word": "Attachment", "pronunciation": "/əˈtætʃ.mənt/", "meaning": "Tệp tin đính kèm", "example": "Please see the contract in the email attachment."}'),
('f0000303-0000-0000-0000-000000000002', 'b0000003-0000-0000-0000-000000000003', 'Từ vựng: Confirmation', 'VOCABULARY', 1, '{"word": "Confirmation", "pronunciation": "/ˌkɑːn.fɚˈmeɪ.ʃən/", "meaning": "Sự xác nhận", "example": "We are waiting for your written confirmation."}'),
('f0000303-0000-0000-0000-000000000003', 'b0000003-0000-0000-0000-000000000003', 'Điền từ', 'FILL_BLANK', 2, '{"sentence": "Please find the requested report in the _____.", "answer": "attachment"}'),
('f0000303-0000-0000-0000-000000000004', 'b0000003-0000-0000-0000-000000000003', 'Shadowing', 'SHADOWING', 3, '{"audioText": "Thank you for reaching out, I look forward to working with your team."}'),
('f0000303-0000-0000-0000-000000000005', 'b0000003-0000-0000-0000-000000000003', 'Tình huống: Gửi Email Đối tác', 'SITUATION', 4, '{"situation": "Hãy viết/đọc câu kết email trang trọng gửi cho đối tác cảm ơn vì buổi gặp gỡ hôm nay và mong sớm nhận được phản hồi."}');

-- KHÓA 3 - TOPIC 4: Pitching & Presentation
INSERT INTO lessons (id, topic_id, title, type, order_index, content_json) VALUES
('f0000304-0000-0000-0000-000000000001', 'b0000003-0000-0000-0000-000000000004', 'Từ vựng: Strategy', 'VOCABULARY', 0, '{"word": "Strategy", "pronunciation": "/ˈstræt̬.ə.dʒi/", "meaning": "Chiến lược", "example": "Our marketing strategy focuses on organic social media growth."}'),
('f0000304-0000-0000-0000-000000000002', 'b0000003-0000-0000-0000-000000000004', 'Từ vựng: Investment', 'VOCABULARY', 1, '{"word": "Investment", "pronunciation": "/ɪnˈvest.mənt/", "meaning": "Khoản đầu tư", "example": "This product represents our most valuable technological investment."}'),
('f0000304-0000-0000-0000-000000000003', 'b0000003-0000-0000-0000-000000000004', 'Điền từ', 'FILL_BLANK', 2, '{"sentence": "We need a clear long-term _____ to expand globally.", "answer": "strategy"}'),
('f0000304-0000-0000-0000-000000000004', 'b0000003-0000-0000-0000-000000000004', 'Shadowing', 'SHADOWING', 3, '{"audioText": "In conclusion, our solution delivers thirty percent higher efficiency."}'),
('f0000304-0000-0000-0000-000000000005', 'b0000003-0000-0000-0000-000000000004', 'Tình huống: Mở đầu bài thuyết trình', 'SITUATION', 4, '{"situation": "Bạn chuẩn bị bắt đầu bài thuyết trình trước hội đồng ban giám đốc. Hãy gửi lời chào và giới thiệu chủ đề của bạn."}');
