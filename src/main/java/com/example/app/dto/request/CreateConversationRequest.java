package com.example.app.dto.request;

public class CreateConversationRequest {
    private String topic;
    private String modelId;
    private String vocabularyJson;
    private String level;

    public String getTopic() { return topic; }
    public void setTopic(String topic) { this.topic = topic; }

    public String getModelId() { return modelId; }
    public void setModelId(String modelId) { this.modelId = modelId; }

    public String getVocabularyJson() { return vocabularyJson; }
    public void setVocabularyJson(String vocabularyJson) { this.vocabularyJson = vocabularyJson; }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }
}
