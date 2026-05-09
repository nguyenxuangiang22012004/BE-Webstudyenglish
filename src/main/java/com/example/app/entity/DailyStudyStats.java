package com.example.app.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "daily_study_stats", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"user_id", "study_date"})
})
public class DailyStudyStats {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @org.hibernate.annotations.OnDelete(action = org.hibernate.annotations.OnDeleteAction.CASCADE)
    private User user;

    @Column(name = "study_date", nullable = false)
    private LocalDate studyDate;

    @Column(nullable = false)
    private Integer wordsLearnedCount = 0;

    @Column(nullable = false)
    private Integer wordsReviewedCount = 0;

    @Column(nullable = false)
    private Integer timeSpentSeconds = 0;

    public DailyStudyStats() {
    }

    public DailyStudyStats(User user, LocalDate studyDate) {
        this.user = user;
        this.studyDate = studyDate;
    }

    // Getters & Setters
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

    public LocalDate getStudyDate() {
        return studyDate;
    }

    public void setStudyDate(LocalDate studyDate) {
        this.studyDate = studyDate;
    }

    public Integer getWordsLearnedCount() {
        return wordsLearnedCount;
    }

    public void setWordsLearnedCount(Integer wordsLearnedCount) {
        this.wordsLearnedCount = wordsLearnedCount;
    }

    public Integer getWordsReviewedCount() {
        return wordsReviewedCount;
    }

    public void setWordsReviewedCount(Integer wordsReviewedCount) {
        this.wordsReviewedCount = wordsReviewedCount;
    }

    public Integer getTimeSpentSeconds() {
        return timeSpentSeconds;
    }

    public void setTimeSpentSeconds(Integer timeSpentSeconds) {
        this.timeSpentSeconds = timeSpentSeconds;
    }
}
