package com.example.app.controller;

import com.example.app.entity.Course;
import com.example.app.entity.Topic;
import com.example.app.entity.Lesson;
import com.example.app.repository.CourseRepository;
import com.example.app.repository.TopicRepository;
import com.example.app.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import com.example.app.dto.response.ApiResponse;
import com.example.app.dto.response.CourseDetailResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/v1/courses")
@CrossOrigin(origins = "*") // For FE connection
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private LessonRepository lessonRepository;

    // Get all courses (with pagination and search)
    @GetMapping
    public ResponseEntity<ApiResponse<Page<Course>>> getAllCourses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false, defaultValue = "") String search) {
        
        Pageable pageable = PageRequest.of(page, size);
        Page<Course> coursesPage = courseRepository.findByNameContainingIgnoreCase(search, pageable);
        
        return ResponseEntity.ok(new ApiResponse<>(true, "Courses retrieved successfully", coursesPage));
    }

    // Get course detail with topics
    @GetMapping("/{courseId}")
    public ResponseEntity<ApiResponse<CourseDetailResponse>> getCourseDetail(@PathVariable UUID courseId) {
        Course course = courseRepository.findById(courseId)
                .orElse(null);
        if (course == null) {
            return ResponseEntity.status(404).body(new ApiResponse<>(false, "Course not found", null));
        }

        List<Topic> topics = topicRepository.findByCourseIdOrderByOrderIndexAsc(courseId);
        CourseDetailResponse response = new CourseDetailResponse(course, topics);

        return ResponseEntity.ok(new ApiResponse<>(true, "Course detail retrieved successfully", response));
    }

    // Get topics by course
    @GetMapping("/{courseId}/topics")
    public ResponseEntity<ApiResponse<List<Topic>>> getTopicsByCourse(@PathVariable UUID courseId) {
        List<Topic> topics = topicRepository.findByCourseIdOrderByOrderIndexAsc(courseId);
        return ResponseEntity.ok(new ApiResponse<>(true, "Topics retrieved successfully", topics));
    }

    // Get lessons by topic
    @GetMapping("/topics/{topicId}/lessons")
    public ResponseEntity<ApiResponse<List<Lesson>>> getLessonsByTopic(@PathVariable UUID topicId) {
        List<Lesson> lessons = lessonRepository.findByTopicIdOrderByOrderIndexAsc(topicId);
        return ResponseEntity.ok(new ApiResponse<>(true, "Lessons retrieved successfully", lessons));
    }
}
