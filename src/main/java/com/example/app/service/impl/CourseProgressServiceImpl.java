package com.example.app.service.impl;

import com.example.app.dto.request.SaveLessonActivityRequest;
import com.example.app.dto.request.UpdateTopicProgressRequest;
import com.example.app.dto.response.CourseProgressResponse;
import com.example.app.dto.response.TopicFinalScoreResponse;
import com.example.app.dto.response.TopicProgressResponse;
import com.example.app.entity.*;
import com.example.app.repository.*;
import com.example.app.service.CourseProgressService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CourseProgressServiceImpl implements CourseProgressService {

    private final UserLessonActivityRepository activityRepository;
    private final UserTopicProgressRepository topicProgressRepository;
    private final UserRepository userRepository;
    private final LessonRepository lessonRepository;
    private final TopicRepository topicRepository;

    public CourseProgressServiceImpl(
            UserLessonActivityRepository activityRepository,
            UserTopicProgressRepository topicProgressRepository,
            UserRepository userRepository,
            LessonRepository lessonRepository,
            TopicRepository topicRepository) {
        this.activityRepository = activityRepository;
        this.topicProgressRepository = topicProgressRepository;
        this.userRepository = userRepository;
        this.lessonRepository = lessonRepository;
        this.topicRepository = topicRepository;
    }

    // ─── 1. Lưu thao tác 1 lesson ───────────────────────────────────────────────
    @Override
    @Transactional
    public void saveLessonActivity(SaveLessonActivityRequest request, String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found: " + userEmail));

        Lesson lesson = lessonRepository.findById(request.getLessonId())
                .orElseThrow(() -> new RuntimeException("Lesson not found: " + request.getLessonId()));

        Topic topic = topicRepository.findById(request.getTopicId())
                .orElseThrow(() -> new RuntimeException("Topic not found: " + request.getTopicId()));

        UserLessonActivity activity = new UserLessonActivity();
        activity.setUser(user);
        activity.setLesson(lesson);
        activity.setTopic(topic);
        activity.setScore(request.getScore());
        activity.setIsCompleted(request.getIsCompleted() != null && request.getIsCompleted());

        activityRepository.save(activity);
    }

    // ─── 2. Cập nhật tổng hợp tiến trình topic (upsert) ─────────────────────────
    @Override
    @Transactional
    public TopicProgressResponse updateTopicProgress(UUID topicId, UpdateTopicProgressRequest request, String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found: " + userEmail));

        Topic topic = topicRepository.findById(topicId)
                .orElseThrow(() -> new RuntimeException("Topic not found: " + topicId));

        // Upsert: tìm hoặc tạo mới
        UserTopicProgress progress = topicProgressRepository
                .findByUserIdAndTopicId(user.getId(), topicId)
                .orElseGet(() -> {
                    UserTopicProgress p = new UserTopicProgress();
                    p.setUser(user);
                    p.setTopic(topic);
                    return p;
                });

        // Cập nhật các trường
        if (request.getStatus() != null) {
            progress.setStatus(request.getStatus());
            if ("COMPLETED".equals(request.getStatus())) {
                progress.setPassed(true);
            }
        }
        if (request.getCurrentStep() != null) {
            progress.setCurrentStep(request.getCurrentStep());
        }
        if (request.getScore() != null) {
            progress.setScore(request.getScore());
        }

        // Cập nhật currentLesson nếu có
        if (request.getCurrentLessonId() != null) {
            lessonRepository.findById(request.getCurrentLessonId())
                    .ifPresent(progress::setCurrentLesson);
        } else {
            progress.setCurrentLesson(null);
        }

        progress = topicProgressRepository.save(progress);

        // Build response kèm completedLessonIds
        List<UUID> completedIds = activityRepository
                .findCompletedLessonIdsByUserIdAndTopicId(user.getId(), topicId);

        return buildTopicProgressResponse(progress, completedIds);
    }

    // ─── 3. Lấy tiến trình toàn bộ course ───────────────────────────────────────
    @Override
    @Transactional(readOnly = true)
    public CourseProgressResponse getCourseProgress(UUID courseId, String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found: " + userEmail));

        // Lấy tất cả topics của course
        List<Topic> topics = topicRepository.findByCourseIdOrderByOrderIndexAsc(courseId);

        // Lấy tất cả progress đã có của user trong course này
        List<UserTopicProgress> existingProgresses =
                topicProgressRepository.findByUserIdAndTopicCourseId(user.getId(), courseId);

        // Map topicId → progress
        Map<UUID, UserTopicProgress> progressMap = existingProgresses.stream()
                .collect(Collectors.toMap(
                        p -> p.getTopic().getId(),
                        p -> p
                ));

        // Build response cho mỗi topic
        List<TopicProgressResponse> responses = topics.stream().map(topic -> {
            UserTopicProgress progress = progressMap.get(topic.getId());

            if (progress == null) {
                // Chưa bắt đầu topic này
                TopicProgressResponse resp = new TopicProgressResponse();
                resp.setTopicId(topic.getId());
                resp.setStatus("NOT_STARTED");
                resp.setCurrentStep(0);
                resp.setScore(null);
                resp.setPassed(false);
                resp.setCurrentLessonId(null);
                resp.setCompletedLessonIds(Collections.emptyList());
                resp.setUpdatedAt(null);
                return resp;
            }

            // Lấy danh sách lesson đã hoàn thành trong topic này
            List<UUID> completedIds = activityRepository
                    .findCompletedLessonIdsByUserIdAndTopicId(user.getId(), topic.getId());

            return buildTopicProgressResponse(progress, completedIds);
        }).collect(Collectors.toList());

        return new CourseProgressResponse(courseId, responses);
    }

    // ─── 4. Đặt lại tiến trình topic ──────────────────────────────────────────────────
    @Override
    @Transactional
    public TopicProgressResponse resetTopicProgress(UUID topicId, String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found: " + userEmail));

        Topic topic = topicRepository.findById(topicId)
                .orElseThrow(() -> new RuntimeException("Topic not found: " + topicId));

        // 1. Xóa toàn bộ UserLessonActivity của user cho topic này
        activityRepository.deleteByUserIdAndTopicId(user.getId(), topicId);

        // 2. Reset UserTopicProgress
        UserTopicProgress progress = topicProgressRepository
                .findByUserIdAndTopicId(user.getId(), topicId)
                .orElse(null);

        if (progress != null) {
            progress.setStatus("NOT_STARTED");
            progress.setCurrentStep(0);
            progress.setCurrentLesson(null);
            progress.setScore(null);
            topicProgressRepository.save(progress);
        } else {
            // Nếu chưa có (hiếm khi xảy ra ở bước này, nhưng fallback)
            progress = new UserTopicProgress();
            progress.setUser(user);
            progress.setTopic(topic);
            progress.setStatus("NOT_STARTED");
            progress.setCurrentStep(0);
            progress.setScore(null);
            topicProgressRepository.save(progress);
        }

        return buildTopicProgressResponse(progress, List.of());
    }

    // ─── 5. Tính điểm tổng kết topic từ activity đã lưu ───────────────────────────────
    @Override
    @Transactional
    public TopicFinalScoreResponse calculateFinalScore(UUID topicId, String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found: " + userEmail));

        Topic topic = topicRepository.findById(topicId)
                .orElseThrow(() -> new RuntimeException("Topic not found: " + topicId));

        // Tính trung bình điểm từ activity (chỉ các lesson có điểm, bỏ qua NULL)
        Double avgDouble = activityRepository.calculateAverageScoreByUserIdAndTopicId(user.getId(), topicId);
        Long scoredCount = activityRepository.countScoredLessons(user.getId(), topicId);
        long totalCount = lessonRepository.countByTopicId(topicId);

        Integer finalScore = (avgDouble != null) ? (int) Math.round(avgDouble) : null;

        // Cập nhật điểm vào user_topic_progress nếu tìm thấy
        topicProgressRepository.findByUserIdAndTopicId(user.getId(), topicId).ifPresent(progress -> {
            progress.setScore(finalScore);
            topicProgressRepository.save(progress);
        });

        return new TopicFinalScoreResponse(
                topicId,
                finalScore,
                scoredCount != null ? scoredCount : 0L,
                totalCount
        );
    }

    // ─── Helper ──────────────────────────────────────────────────────────────────
    private TopicProgressResponse buildTopicProgressResponse(UserTopicProgress progress, List<UUID> completedLessonIds) {
        TopicProgressResponse resp = new TopicProgressResponse();
        resp.setTopicId(progress.getTopic().getId());
        resp.setStatus(progress.getStatus());
        resp.setCurrentStep(progress.getCurrentStep());
        resp.setScore(progress.getScore());
        resp.setPassed(progress.getPassed());
        resp.setCompletedLessonIds(completedLessonIds);
        resp.setUpdatedAt(progress.getUpdatedAt());

        if (progress.getCurrentLesson() != null) {
            resp.setCurrentLessonId(progress.getCurrentLesson().getId());
        }

        return resp;
    }
}
