package com.example.app.entity;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "ai_writing_history")
public class AiWritingHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, length = 255)
    private String topic;

    @Column(length = 50)
    private String level;

    @Column(name = "writing_type", length = 50)
    private String writingType; // TOPIC_WRITING or ESSAY_REVIEW

    @Column(name = "prompt_text", columnDefinition = "TEXT")
    private String promptText;

    @Column(name = "essay_content", columnDefinition = "TEXT", nullable = false)
    private String essayContent;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "outline_data", columnDefinition = "jsonb")
    private JsonNode outlineData;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "feedback_data", columnDefinition = "jsonb", nullable = false)
    private JsonNode feedbackData;

    @Column
    private Double score;

    @Column(name = "word_count")
    private Integer wordCount;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private ZonedDateTime createdAt;

    public AiWritingHistory() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
