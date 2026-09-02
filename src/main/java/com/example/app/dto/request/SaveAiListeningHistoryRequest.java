package com.example.app.dto.request;

public class SaveAiListeningHistoryRequest {
    private String topic;
    private String level;
    private com.fasterxml.jackson.databind.JsonNode lessonData;
    private com.fasterxml.jackson.databind.JsonNode userAnswersData;
    private Integer score;

    public SaveAiListeningHistoryRequest() {
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
}
