package com.example.app.dto.response;

import java.time.ZonedDateTime;
import java.util.UUID;

public class AiListeningHistoryResponse {
    private UUID id;
    private String topic;
    private String level;
    private com.fasterxml.jackson.databind.JsonNode lessonData;
    private com.fasterxml.jackson.databind.JsonNode userAnswersData;
    private Integer score;
    private ZonedDateTime createdAt;

    public AiListeningHistoryResponse() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public com.fasterxml.jackson.databind.JsonNode getLessonData() {
        return lessonData;
    }

    public void setLessonData(com.fasterxml.jackson.databind.JsonNode lessonData) {
        this.lessonData = lessonData;
    }

    public com.fasterxml.jackson.databind.JsonNode getUserAnswersData() {
        return userAnswersData;
    }

    public void setUserAnswersData(com.fasterxml.jackson.databind.JsonNode userAnswersData) {
        this.userAnswersData = userAnswersData;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
