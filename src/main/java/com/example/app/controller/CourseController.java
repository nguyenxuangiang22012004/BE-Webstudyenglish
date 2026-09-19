package com.example.app.controller;

import com.example.app.dto.request.CreateCourseRequest;
import com.example.app.dto.request.CreateLessonRequest;
import com.example.app.dto.request.CreateTopicRequest;
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
import com.example.app.repository.UserLessonActivityRepository;
import com.example.app.repository.UserTopicProgressRepository;
import com.example.app.service.CourseProgressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
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
    private UserTopicProgressRepository userTopicProgressRepository;

    @Autowired
    private UserLessonActivityRepository userLessonActivityRepository;

    @Autowired
    private CourseProgressService courseProgressService;

    private Course resolveCourse(String identifier) {
        if (identifier == null || identifier.isBlank()) return null;
        try {
            UUID id = UUID.fromString(identifier);
            return courseRepository.findById(id).orElseGet(() -> courseRepository.findBySlug(identifier).orElse(null));
        } catch (IllegalArgumentException e) {
            return courseRepository.findBySlug(identifier).orElse(null);
        }
    }

    private Topic resolveTopic(String identifier) {
        if (identifier == null || identifier.isBlank()) return null;
        try {
            UUID id = UUID.fromString(identifier);
            return topicRepository.findById(id).orElseGet(() -> topicRepository.findBySlug(identifier).orElse(null));
        } catch (IllegalArgumentException e) {
            return topicRepository.findBySlug(identifier).orElse(null);
        }
    }

    // ─── Courses (Read) ─────────────────────────────────────────────────────────

    @GetMapping
    public ResponseEntity<ApiResponse<com.example.app.dto.response.PageResponse<Course>>> getAllCourses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false) Integer limit,
            @RequestParam(required = false, defaultValue = "") String search) {

        int pageSize = limit != null ? limit : (size != null ? size : 10);
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Course> coursesPage = courseRepository.findByNameContainingIgnoreCase(search, pageable);
        return ResponseEntity.ok(new ApiResponse<>(true, "Courses retrieved successfully", com.example.app.dto.response.PageResponse.of(coursesPage)));
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<ApiResponse<CourseDetailResponse>> getCourseDetail(@PathVariable String courseId) {
        Course course = resolveCourse(courseId);
        if (course == null) {
            return ResponseEntity.status(404).body(new ApiResponse<>(false, "Course not found", null));
        }
        List<Topic> topics = topicRepository.findByCourseIdOrderByOrderIndexAsc(course.getId());
        return ResponseEntity.ok(new ApiResponse<>(true, "Course detail retrieved successfully", new CourseDetailResponse(course, topics)));
    }

    private String sanitizeSlug(String slug) {
        if (slug == null || slug.isBlank()) return null;
        return slug.trim().toLowerCase()
                .replaceAll("[^a-z0-9\\-]", "-")
                .replaceAll("-+", "-")
                .replaceAll("^-|-$", "");
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<Course>> createCourse(@Valid @RequestBody CreateCourseRequest request) {
        Course course = new Course();
        course.setName(request.getName());
        course.setSlug(sanitizeSlug(request.getSlug()));
        course.setDescription(request.getDescription());
        course.setLevel(request.getLevel());
        course.setImageUrl(request.getImageUrl());
        Course saved = courseRepository.save(course);
        return ResponseEntity.ok(new ApiResponse<>(true, "Tạo khóa học thành công", saved));
    }

    @PutMapping("/{courseId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<Course>> updateCourse(
            @PathVariable UUID courseId,
            @Valid @RequestBody CreateCourseRequest request) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found: " + courseId));
        course.setName(request.getName());
        if (request.getSlug() != null) {
            course.setSlug(sanitizeSlug(request.getSlug()));
        }
        course.setDescription(request.getDescription());
        course.setLevel(request.getLevel());
        course.setImageUrl(request.getImageUrl());
        Course saved = courseRepository.save(course);
        return ResponseEntity.ok(new ApiResponse<>(true, "Cập nhật khóa học thành công", saved));
    }

    @DeleteMapping("/{courseId}")
    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    public ResponseEntity<ApiResponse<Void>> deleteCourse(@PathVariable UUID courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found: " + courseId));

        List<Topic> topics = topicRepository.findByCourseIdOrderByOrderIndexAsc(courseId);
        for (Topic topic : topics) {
            deleteTopicInternal(topic.getId());
        }

        courseRepository.delete(course);
        return ResponseEntity.ok(new ApiResponse<>(true, "Đã xóa khóa học thành công", null));
    }

    // ─── Topics (Read & Admin CRUD) ─────────────────────────────────────────────

    @GetMapping("/topics")
    public ResponseEntity<ApiResponse<List<Topic>>> getAllTopics() {
        List<Topic> topics = topicRepository.findAll();
        return ResponseEntity.ok(new ApiResponse<>(true, "All topics retrieved successfully", topics));
    }

    @GetMapping("/{courseId}/topics")
    public ResponseEntity<ApiResponse<List<Topic>>> getTopicsByCourse(@PathVariable String courseId) {
        Course course = resolveCourse(courseId);
        if (course == null) {
            return ResponseEntity.status(404).body(new ApiResponse<>(false, "Course not found", null));
        }
        List<Topic> topics = topicRepository.findByCourseIdOrderByOrderIndexAsc(course.getId());
        return ResponseEntity.ok(new ApiResponse<>(true, "Topics retrieved successfully", topics));
    }

    @GetMapping("/topics/{topicId}")
    public ResponseEntity<ApiResponse<Topic>> getTopicById(@PathVariable String topicId) {
        Topic topic = resolveTopic(topicId);
        if (topic == null) {
            return ResponseEntity.status(404).body(new ApiResponse<>(false, "Topic not found", null));
        }
        return ResponseEntity.ok(new ApiResponse<>(true, "Topic retrieved successfully", topic));
    }

    @PostMapping("/{courseId}/topics")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<Topic>> createTopic(
            @PathVariable String courseId,
            @Valid @RequestBody CreateTopicRequest request) {
        Course course = resolveCourse(courseId);
        if (course == null) {
            return ResponseEntity.status(404).body(new ApiResponse<>(false, "Course not found", null));
        }

        Topic topic = new Topic();
        topic.setCourse(course);
        topic.setName(request.getName());
        topic.setSlug(sanitizeSlug(request.getSlug()));
        topic.setDescription(request.getDescription());
        topic.setOrderIndex(request.getOrderIndex() != null ? request.getOrderIndex() : 0);
        topic.setMascotImageUrl(request.getMascotImageUrl());
        topic.setIntroMessage(request.getIntroMessage());

        Topic saved = topicRepository.save(topic);
        return ResponseEntity.ok(new ApiResponse<>(true, "Tạo chủ đề thành công", saved));
    }

    @PutMapping("/topics/{topicId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<Topic>> updateTopic(
            @PathVariable String topicId,
            @Valid @RequestBody CreateTopicRequest request) {
        Topic topic = resolveTopic(topicId);
        if (topic == null) {
            return ResponseEntity.status(404).body(new ApiResponse<>(false, "Topic not found", null));
        }

        topic.setName(request.getName());
        if (request.getSlug() != null) {
            topic.setSlug(sanitizeSlug(request.getSlug()));
        }
        topic.setDescription(request.getDescription());
        if (request.getOrderIndex() != null) {
            topic.setOrderIndex(request.getOrderIndex());
        }
        topic.setMascotImageUrl(request.getMascotImageUrl());
        topic.setIntroMessage(request.getIntroMessage());

        Topic saved = topicRepository.save(topic);
        return ResponseEntity.ok(new ApiResponse<>(true, "Cập nhật chủ đề thành công", saved));
    }

    @DeleteMapping("/topics/{topicId}")
    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    public ResponseEntity<ApiResponse<Void>> deleteTopic(@PathVariable String topicId) {
        Topic topic = resolveTopic(topicId);
        if (topic == null) {
            return ResponseEntity.status(404).body(new ApiResponse<>(false, "Topic not found", null));
        }
        deleteTopicInternal(topic.getId());
        return ResponseEntity.ok(new ApiResponse<>(true, "Đã xóa chủ đề thành công", null));
    }

    private void deleteTopicInternal(UUID topicId) {
        Topic topic = topicRepository.findById(topicId)
                .orElseThrow(() -> new RuntimeException("Topic not found: " + topicId));

        List<Lesson> lessons = lessonRepository.findByTopicIdOrderByOrderIndexAsc(topicId);
        for (Lesson lesson : lessons) {
            deleteLessonInternal(lesson.getId());
        }

        // Xóa tiến trình học của topic này
        userTopicProgressRepository.findAll().stream()
                .filter(p -> p.getTopic() != null && p.getTopic().getId().equals(topicId))
                .forEach(userTopicProgressRepository::delete);

        topicRepository.delete(topic);
    }

    // ─── Lessons (Read & Admin CRUD) ────────────────────────────────────────────

    @GetMapping("/lessons")
    public ResponseEntity<ApiResponse<List<Lesson>>> getAllLessons(
            @RequestParam(required = false) String topicId,
            @RequestParam(required = false) String type) {
        List<Lesson> lessons;
        boolean hasType = type != null && !type.isBlank() && !type.equalsIgnoreCase("ALL");

        if (topicId != null && !topicId.isBlank()) {
            Topic topic = resolveTopic(topicId);
            if (topic == null) {
                return ResponseEntity.ok(new ApiResponse<>(true, "All lessons retrieved successfully", List.of()));
            }
            if (hasType) {
                lessons = lessonRepository.findByTopicIdAndTypeOrderByOrderIndexAsc(topic.getId(), type.toUpperCase());
            } else {
                lessons = lessonRepository.findByTopicIdOrderByOrderIndexAsc(topic.getId());
            }
        } else if (hasType) {
            lessons = lessonRepository.findByTypeOrderByOrderIndexAsc(type.toUpperCase());
        } else {
            lessons = lessonRepository.findAll();
        }
        return ResponseEntity.ok(new ApiResponse<>(true, "All lessons retrieved successfully", lessons));
    }

    @GetMapping("/lessons/{lessonId}")
    public ResponseEntity<ApiResponse<Lesson>> getLessonById(@PathVariable UUID lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson not found: " + lessonId));
        return ResponseEntity.ok(new ApiResponse<>(true, "Lesson retrieved successfully", lesson));
    }

    @GetMapping("/topics/{topicId}/lessons")
    public ResponseEntity<ApiResponse<List<Lesson>>> getLessonsByTopic(
            @PathVariable String topicId,
            @RequestParam(required = false) String type) {
        Topic topic = resolveTopic(topicId);
        if (topic == null) {
            return ResponseEntity.status(404).body(new ApiResponse<>(false, "Topic not found", List.of()));
        }
        List<Lesson> lessons;
        if (type != null && !type.isBlank() && !type.equalsIgnoreCase("ALL")) {
            lessons = lessonRepository.findByTopicIdAndTypeOrderByOrderIndexAsc(topic.getId(), type.toUpperCase());
        } else {
            lessons = lessonRepository.findByTopicIdOrderByOrderIndexAsc(topic.getId());
        }
        return ResponseEntity.ok(new ApiResponse<>(true, "Lessons retrieved successfully", lessons));
    }

    @PostMapping("/topics/{topicId}/lessons")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<Lesson>> createLesson(
            @PathVariable UUID topicId,
            @Valid @RequestBody CreateLessonRequest request) {
        Topic topic = topicRepository.findById(topicId)
                .orElseThrow(() -> new RuntimeException("Topic not found: " + topicId));

        Lesson lesson = new Lesson();
        lesson.setTopic(topic);
        lesson.setTitle(request.getTitle());
        lesson.setType(request.getType().toUpperCase());
        lesson.setOrderIndex(request.getOrderIndex() != null ? request.getOrderIndex() : 0);
        lesson.setContentJson(request.getContentJson());

        Lesson saved = lessonRepository.save(lesson);
        return ResponseEntity.ok(new ApiResponse<>(true, "Tạo bài học thành công", saved));
    }

    @PutMapping("/lessons/{lessonId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<Lesson>> updateLesson(
            @PathVariable UUID lessonId,
            @Valid @RequestBody CreateLessonRequest request) {
        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson not found: " + lessonId));

        lesson.setTitle(request.getTitle());
        lesson.setType(request.getType().toUpperCase());
        if (request.getOrderIndex() != null) {
            lesson.setOrderIndex(request.getOrderIndex());
        }
        lesson.setContentJson(request.getContentJson());

        Lesson saved = lessonRepository.save(lesson);
        return ResponseEntity.ok(new ApiResponse<>(true, "Cập nhật bài học thành công", saved));
    }

    @DeleteMapping("/lessons/{lessonId}")
    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    public ResponseEntity<ApiResponse<Void>> deleteLesson(@PathVariable UUID lessonId) {
        deleteLessonInternal(lessonId);
        return ResponseEntity.ok(new ApiResponse<>(true, "Đã xóa bài học thành công", null));
    }

    private void deleteLessonInternal(UUID lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson not found: " + lessonId));

        // Xóa các user lesson activities liên quan
        userLessonActivityRepository.findAll().stream()
                .filter(a -> a.getLesson() != null && a.getLesson().getId().equals(lessonId))
                .forEach(userLessonActivityRepository::delete);

        // Reset currentLesson trong UserTopicProgress nếu trỏ tới lesson này
        userTopicProgressRepository.findAll().stream()
                .filter(p -> p.getCurrentLesson() != null && p.getCurrentLesson().getId().equals(lessonId))
                .forEach(p -> {
                    p.setCurrentLesson(null);
                    userTopicProgressRepository.save(p);
                });

        lessonRepository.delete(lesson);
    }

    // ─── Progress ───────────────────────────────────────────────────────────────

    /**
     * Lấy tiến trình học của user cho toàn bộ course.
     * Trả về tất cả topics cùng trạng thái, bước hiện tại, danh sách lesson đã hoàn thành.
     */
    @GetMapping("/{courseId}/my-progress")
    public ResponseEntity<ApiResponse<CourseProgressResponse>> getCourseProgress(
            @PathVariable String courseId,
            Authentication auth) {
        Course course = resolveCourse(courseId);
        if (course == null) {
            return ResponseEntity.status(404).body(new ApiResponse<>(false, "Course not found", null));
        }
        CourseProgressResponse response = courseProgressService.getCourseProgress(course.getId(), auth.getName());
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
            @PathVariable String topicId,
            @RequestBody UpdateTopicProgressRequest request,
            Authentication auth) {
        Topic topic = resolveTopic(topicId);
        if (topic == null) {
            return ResponseEntity.status(404).body(new ApiResponse<>(false, "Topic not found", null));
        }
        TopicProgressResponse response = courseProgressService.updateTopicProgress(topic.getId(), request, auth.getName());
        return ResponseEntity.ok(new ApiResponse<>(true, "Topic progress updated successfully", response));
    }

    /**
     * Tính điểm tổng kết topic từ dữ liệu activity đã lưu.
     * Gọi khi user hoàn thành toàn bộ topic.
     * Chỉ tính trung bình các lesson có điểm (bỏ qua CONVERSATION, v.v.)
     */
    @GetMapping("/topics/{topicId}/final-score")
    public ResponseEntity<ApiResponse<TopicFinalScoreResponse>> getTopicFinalScore(
            @PathVariable String topicId,
            Authentication auth) {
        Topic topic = resolveTopic(topicId);
        if (topic == null) {
            return ResponseEntity.status(404).body(new ApiResponse<>(false, "Topic not found", null));
        }
        TopicFinalScoreResponse response = courseProgressService.calculateFinalScore(topic.getId(), auth.getName());
        return ResponseEntity.ok(new ApiResponse<>(true, "Final score calculated successfully", response));
    }

    /**
     * Đặt lại tiến trình học của 1 topic (xóa lịch sử điểm, đưa về NOT_STARTED).
     */
    @DeleteMapping("/topics/{topicId}/progress")
    public ResponseEntity<ApiResponse<TopicProgressResponse>> resetTopicProgress(
            @PathVariable String topicId,
            Authentication auth) {
        Topic topic = resolveTopic(topicId);
        if (topic == null) {
            return ResponseEntity.status(404).body(new ApiResponse<>(false, "Topic not found", null));
        }
        TopicProgressResponse response = courseProgressService.resetTopicProgress(topic.getId(), auth.getName());
        return ResponseEntity.ok(new ApiResponse<>(true, "Topic progress reset successfully", response));
    }
}
