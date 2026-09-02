package com.example.app.dto.request;

public class UpdateAiListeningHistoryRequest {
    private com.fasterxml.jackson.databind.JsonNode userAnswersData;
    private Integer score;

    public UpdateAiListeningHistoryRequest() {
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
