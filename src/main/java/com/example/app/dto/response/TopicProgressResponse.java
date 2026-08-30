package com.example.app.dto.response;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class TopicProgressResponse {

    private UUID topicId;
    private String status; // NOT_STARTED | IN_PROGRESS | COMPLETED
    private UUID currentLessonId;
    private Integer currentStep;
    private Integer score;
    private boolean isPassed;
    private List<UUID> completedLessonIds;
    private ZonedDateTime updatedAt;

    public TopicProgressResponse() {}

    public UUID getTopicId() {
        return topicId;
    }

    public void setTopicId(UUID topicId) {
        this.topicId = topicId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UUID getCurrentLessonId() {
        return currentLessonId;
    }

    public void setCurrentLessonId(UUID currentLessonId) {
        this.currentLessonId = currentLessonId;
    }

    public Integer getCurrentStep() {
        return currentStep;
    }

    public void setCurrentStep(Integer currentStep) {
        this.currentStep = currentStep;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }

    public List<UUID> getCompletedLessonIds() {
        return completedLessonIds;
    }

    public void setCompletedLessonIds(List<UUID> completedLessonIds) {
        this.completedLessonIds = completedLessonIds;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
