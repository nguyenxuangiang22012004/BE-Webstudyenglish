package com.example.app.controller;

import com.example.app.dto.request.SaveLessonActivityRequest;
import com.example.app.dto.request.UpdateTopicProgressRequest;
import com.example.app.dto.response.ApiResponse;
import com.example.app.dto.response.CourseDetailResponse;
import com.example.app.dto.response.CourseProgressResponse;
import com.example.app.dto.response.TopicFinalScoreResponse;
import com.example.app.dto.response.TopicProgressResponse;
import com.example.app.entity.Course;
import com.example.app.entity.Lesson;
import com.example.app.entity.Topic;
import com.example.app.repository.CourseRepository;
import com.example.app.repository.LessonRepository;
import com.example.app.repository.TopicRepository;
import com.example.app.service.CourseProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/courses")
@CrossOrigin(origins = "*")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private CourseProgressService courseProgressService;

    // ─── Courses ────────────────────────────────────────────────────────────────

    @GetMapping
    public ResponseEntity<ApiResponse<Page<Course>>> getAllCourses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false, defaultValue = "") String search) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Course> coursesPage = courseRepository.findByNameContainingIgnoreCase(search, pageable);
        return ResponseEntity.ok(new ApiResponse<>(true, "Courses retrieved successfully", coursesPage));
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<ApiResponse<CourseDetailResponse>> getCourseDetail(@PathVariable UUID courseId) {
        Course course = courseRepository.findById(courseId).orElse(null);
        if (course == null) {
            return ResponseEntity.status(404).body(new ApiResponse<>(false, "Course not found", null));
        }
        List<Topic> topics = topicRepository.findByCourseIdOrderByOrderIndexAsc(courseId);
        return ResponseEntity.ok(new ApiResponse<>(true, "Course detail retrieved successfully", new CourseDetailResponse(course, topics)));
    }

    @GetMapping("/{courseId}/topics")
    public ResponseEntity<ApiResponse<List<Topic>>> getTopicsByCourse(@PathVariable UUID courseId) {
        List<Topic> topics = topicRepository.findByCourseIdOrderByOrderIndexAsc(courseId);
        return ResponseEntity.ok(new ApiResponse<>(true, "Topics retrieved successfully", topics));
    }

    @GetMapping("/topics/{topicId}/lessons")
    public ResponseEntity<ApiResponse<List<Lesson>>> getLessonsByTopic(@PathVariable UUID topicId) {
        List<Lesson> lessons = lessonRepository.findByTopicIdOrderByOrderIndexAsc(topicId);
        return ResponseEntity.ok(new ApiResponse<>(true, "Lessons retrieved successfully", lessons));
    }

    // ─── Progress ───────────────────────────────────────────────────────────────

    /**
     * Lấy tiến trình học của user cho toàn bộ course.
     * Trả về tất cả topics cùng trạng thái, bước hiện tại, danh sách lesson đã hoàn thành.
     */
    @GetMapping("/{courseId}/my-progress")
    public ResponseEntity<ApiResponse<CourseProgressResponse>> getCourseProgress(
            @PathVariable UUID courseId,
            Authentication auth) {
        CourseProgressResponse response = courseProgressService.getCourseProgress(courseId, auth.getName());
        return ResponseEntity.ok(new ApiResponse<>(true, "Course progress retrieved successfully", response));
    }

    /**
     * Lưu thao tác của user khi hoàn thành 1 lesson.
     * FE gọi mỗi khi user chuyển sang bước tiếp theo.
     */
    @PostMapping("/lessons/activity")
    public ResponseEntity<ApiResponse<Void>> saveLessonActivity(
            @RequestBody SaveLessonActivityRequest request,
            Authentication auth) {
        courseProgressService.saveLessonActivity(request, auth.getName());
        return ResponseEntity.ok(new ApiResponse<>(true, "Lesson activity saved successfully", null));
    }

    /**
     * Cập nhật tổng hợp tiến trình topic (upsert).
     * FE gọi song song với saveLessonActivity.
     */
    @PutMapping("/topics/{topicId}/progress")
    public ResponseEntity<ApiResponse<TopicProgressResponse>> updateTopicProgress(
            @PathVariable UUID topicId,
            @RequestBody UpdateTopicProgressRequest request,
            Authentication auth) {
        TopicProgressResponse response = courseProgressService.updateTopicProgress(topicId, request, auth.getName());
        return ResponseEntity.ok(new ApiResponse<>(true, "Topic progress updated successfully", response));
    }

    /**
     * Tính điểm tổng kết topic từ dữ liệu activity đã lưu.
     * Gọi khi user hoàn thành toàn bộ topic.
     * Chỉ tính trung bình các lesson có điểm (bỏ qua CONVERSATION, v.v.)
     */
    @GetMapping("/topics/{topicId}/final-score")
    public ResponseEntity<ApiResponse<TopicFinalScoreResponse>> getTopicFinalScore(
            @PathVariable UUID topicId,
            Authentication auth) {
        TopicFinalScoreResponse response = courseProgressService.calculateFinalScore(topicId, auth.getName());
        return ResponseEntity.ok(new ApiResponse<>(true, "Final score calculated successfully", response));
    }
    /**
     * Đặt lại tiến trình học của 1 topic (xóa lịch sử điểm, đưa về NOT_STARTED).
     */
    @DeleteMapping("/topics/{topicId}/progress")
    public ResponseEntity<ApiResponse<TopicProgressResponse>> resetTopicProgress(
            @PathVariable UUID topicId,
            Authentication auth) {
        TopicProgressResponse response = courseProgressService.resetTopicProgress(topicId, auth.getName());
        return ResponseEntity.ok(new ApiResponse<>(true, "Topic progress reset successfully", response));
    }
}


