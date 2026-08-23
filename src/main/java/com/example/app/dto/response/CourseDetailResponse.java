package com.example.app.dto.response;

import com.example.app.entity.Course;
import com.example.app.entity.Topic;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class CourseDetailResponse {

    private UUID id;
    private String name;
    private String description;
    private String level;
    private String imageUrl;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private List<Topic> topics;

    public CourseDetailResponse(Course course, List<Topic> topics) {
        this.id = course.getId();
        this.name = course.getName();
        this.description = course.getDescription();
        this.level = course.getLevel();
        this.imageUrl = course.getImageUrl();
        this.createdAt = course.getCreatedAt();
        this.updatedAt = course.getUpdatedAt();
        this.topics = topics;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }
}
