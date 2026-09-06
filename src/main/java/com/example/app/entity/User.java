package com.example.app.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false, length = 255)
    private String email;

    @Column(nullable = false, length = 255)
    private String passwordHash;

    @Column(nullable = false, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private UserRole role = UserRole.USER;

    @Column(length = 500)
    private String avatarUrl;

    // Thống kê (Streak, Goals)
    @Column(nullable = false)
    private Integer currentStreak = 0;

    @Column(nullable = false)
    private Integer longestStreak = 0;

    @Column(name = "last_study_date")
    private LocalDate lastStudyDate;

    // Custom study goals
    @Column(nullable = false)
    private Integer dailyWordsGoal = 10;

    @Column(nullable = false)
    private Integer totalWordsGoal = 200;

    @Column(nullable = false)
    private Integer streakGoal = 30;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private ZonedDateTime updatedAt;

    public User() {
    }

    public User(String email, String passwordHash, String name) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.name = name;
    }

    // Getters & Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Integer getCurrentStreak() {
        return currentStreak;
    }

    public void setCurrentStreak(Integer currentStreak) {
        this.currentStreak = currentStreak;
    }

    public Integer getLongestStreak() {
        return longestStreak;
    }

    public void setLongestStreak(Integer longestStreak) {
        this.longestStreak = longestStreak;
    }

    public LocalDate getLastStudyDate() {
        return lastStudyDate;
    }

    public void setLastStudyDate(LocalDate lastStudyDate) {
        this.lastStudyDate = lastStudyDate;
    }

    public Integer getDailyWordsGoal() {
        return dailyWordsGoal;
    }

    public void setDailyWordsGoal(Integer dailyWordsGoal) {
        this.dailyWordsGoal = dailyWordsGoal;
    }

    public Integer getTotalWordsGoal() {
        return totalWordsGoal;
    }

    public void setTotalWordsGoal(Integer totalWordsGoal) {
        this.totalWordsGoal = totalWordsGoal;
    }

    public Integer getStreakGoal() {
        return streakGoal;
    }

    public void setStreakGoal(Integer streakGoal) {
        this.streakGoal = streakGoal;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public enum UserRole {
        USER, ADMIN, TEACHER
    }
}
