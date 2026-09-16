package com.example.app.dto.response;

import com.fasterxml.jackson.databind.JsonNode;
import java.time.ZonedDateTime;
import java.util.UUID;

public class AiWritingHistoryResponse {
    private UUID id;
    private String topic;
    private String level;
    private String writingType;
    private String promptText;
    private String essayContent;
    private JsonNode outlineData;
    private JsonNode feedbackData;
    private Double score;
    private Integer wordCount;
    private ZonedDateTime createdAt;

    public AiWritingHistoryResponse() {
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

    public String getWritingType() {
        return writingType;
    }

    public void setWritingType(String writingType) {
        this.writingType = writingType;
    }

    public String getPromptText() {
        return promptText;
    }

    public void setPromptText(String promptText) {
        this.promptText = promptText;
    }

    public String getEssayContent() {
        return essayContent;
    }

    public void setEssayContent(String essayContent) {
        this.essayContent = essayContent;
    }

    public JsonNode getOutlineData() {
        return outlineData;
    }

    public void setOutlineData(JsonNode outlineData) {
        this.outlineData = outlineData;
    }

    public JsonNode getFeedbackData() {
        return feedbackData;
    }

    public void setFeedbackData(JsonNode feedbackData) {
        this.feedbackData = feedbackData;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getWordCount() {
        return wordCount;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
