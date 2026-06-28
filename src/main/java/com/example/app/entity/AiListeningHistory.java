package com.example.app.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "ai_listening_history")
public class AiListeningHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, length = 255)
    private String topic;

    @Column(nullable = false, length = 50)
    private String level;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "lesson_data", columnDefinition = "jsonb", nullable = false)
    private Object lessonData;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "user_answers_data", columnDefinition = "jsonb", nullable = false)
    private Object userAnswersData;

    @Column(nullable = false)
    private Integer score;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private ZonedDateTime createdAt;

    public AiListeningHistory() {
    }

    public AiListeningHistory(User user, String topic, String level, Object lessonData, Object userAnswersData, Integer score) {
        this.user = user;
        this.topic = topic;
        this.level = level;
        this.lessonData = lessonData;
        this.userAnswersData = userAnswersData;
        this.score = score;
    }

    // Getters and Setters
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

    public Object getLessonData() {
        return lessonData;
    }

    public void setLessonData(Object lessonData) {
        this.lessonData = lessonData;
    }

    public Object getUserAnswersData() {
        return userAnswersData;
    }

    public void setUserAnswersData(Object userAnswersData) {
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
