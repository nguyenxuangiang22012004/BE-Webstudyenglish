package com.example.app.dto.response;

import java.util.List;
import java.util.UUID;

public class CourseProgressResponse {

    private UUID courseId;
    private List<TopicProgressResponse> topicProgresses;

    public CourseProgressResponse() {}

    public CourseProgressResponse(UUID courseId, List<TopicProgressResponse> topicProgresses) {
        this.courseId = courseId;
        this.topicProgresses = topicProgresses;
    }

    public UUID getCourseId() {
        return courseId;
    }

    public void setCourseId(UUID courseId) {
        this.courseId = courseId;
    }

    public List<TopicProgressResponse> getTopicProgresses() {
        return topicProgresses;
    }

    public void setTopicProgresses(List<TopicProgressResponse> topicProgresses) {
        this.topicProgresses = topicProgresses;
    }
}
