package com.example.app.dto.request;

import java.util.UUID;

public class SaveLessonActivityRequest {

    private UUID lessonId;
    private UUID topicId;
    private Integer score;
    private Boolean isCompleted = false;

    public SaveLessonActivityRequest() {}

    public UUID getLessonId() {
        return lessonId;
    }

    public void setLessonId(UUID lessonId) {
        this.lessonId = lessonId;
    }

    public UUID getTopicId() {
        return topicId;
    }

    public void setTopicId(UUID topicId) {
        this.topicId = topicId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
}
