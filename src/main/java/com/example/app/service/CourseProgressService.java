package com.example.app.service;

import com.example.app.dto.request.SaveLessonActivityRequest;
import com.example.app.dto.request.UpdateTopicProgressRequest;
import com.example.app.dto.response.CourseProgressResponse;
import com.example.app.dto.response.TopicFinalScoreResponse;
import com.example.app.dto.response.TopicProgressResponse;

import java.util.UUID;

public interface CourseProgressService {

    /**
     * Lưu thao tác người dùng trong 1 lesson (ghi lịch sử, có thể nhiều lần).
     */
    void saveLessonActivity(SaveLessonActivityRequest request, String userEmail);

    /**
     * Cập nhật (upsert) tổng hợp tiến trình của user trong 1 topic.
     */
    TopicProgressResponse updateTopicProgress(UUID topicId, UpdateTopicProgressRequest request, String userEmail);

    /**
     * Lấy tiến trình toàn bộ course: tất cả topics với status, currentStep, completedLessonIds.
     */
    CourseProgressResponse getCourseProgress(UUID courseId, String userEmail);

    /**
     * Đặt lại tiến trình học của 1 topic (xóa lịch sử điểm, đưa về NOT_STARTED).
     */
    TopicProgressResponse resetTopicProgress(UUID topicId, String userEmail);

    /**
     * Tính điểm tổng kết của topic từ các activity đã lưu.
     * Chỉ tính trung bình các lesson có điểm (score IS NOT NULL).
     * Đồng thời lưu finalScore vào user_topic_progress.
     */
    TopicFinalScoreResponse calculateFinalScore(UUID topicId, String userEmail);
}

