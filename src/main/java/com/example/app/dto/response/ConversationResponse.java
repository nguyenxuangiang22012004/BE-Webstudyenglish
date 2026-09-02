package com.example.app.dto.response;

import java.time.ZonedDateTime;
import java.util.UUID;
import java.util.List;

public class ConversationResponse {
    private UUID id;
    private String topic;
    private String modelId;
    private String vocabularyJson;
    private String level;
    private ZonedDateTime createdAt;
    private List<MessageResponse> messages;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getTopic() { return topic; }
    public void setTopic(String topic) { this.topic = topic; }

    public String getModelId() { return modelId; }
    public void setModelId(String modelId) { this.modelId = modelId; }

    public String getVocabularyJson() { return vocabularyJson; }
    public void setVocabularyJson(String vocabularyJson) { this.vocabularyJson = vocabularyJson; }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }

    public ZonedDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(ZonedDateTime createdAt) { this.createdAt = createdAt; }

    public List<MessageResponse> getMessages() { return messages; }
    public void setMessages(List<MessageResponse> messages) { this.messages = messages; }
}
