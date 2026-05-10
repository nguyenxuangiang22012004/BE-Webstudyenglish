package com.example.app.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "user_flashcard_progress", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"user_id", "flashcard_id"})
})
public class UserFlashcardProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @org.hibernate.annotations.OnDelete(action = org.hibernate.annotations.OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flashcard_id", nullable = false)
    @org.hibernate.annotations.OnDelete(action = org.hibernate.annotations.OnDeleteAction.CASCADE)
    private Flashcard flashcard;

    @Enumerated(EnumType.STRING)
    @org.hibernate.annotations.JdbcTypeCode(org.hibernate.type.SqlTypes.NAMED_ENUM)
    @Column(nullable = false, columnDefinition = "flashcard_status")
    private FlashcardStatus status = FlashcardStatus.UNKNOWN;


    @Column(name = "next_review_date")
    private ZonedDateTime nextReviewDate;

    @Column(name = "last_reviewed_at")
    private ZonedDateTime lastReviewedAt;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private ZonedDateTime createdAt;

    public UserFlashcardProgress() {
    }

    public UserFlashcardProgress(User user, Flashcard flashcard) {
        this.user = user;
        this.flashcard = flashcard;
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

    public Flashcard getFlashcard() {
        return flashcard;
    }

    public void setFlashcard(Flashcard flashcard) {
        this.flashcard = flashcard;
    }

    public FlashcardStatus getStatus() {
        return status;
    }

    public void setStatus(FlashcardStatus status) {
        this.status = status;
    }

    public ZonedDateTime getNextReviewDate() {
        return nextReviewDate;
    }

    public void setNextReviewDate(ZonedDateTime nextReviewDate) {
        this.nextReviewDate = nextReviewDate;
    }

    public ZonedDateTime getLastReviewedAt() {
        return lastReviewedAt;
    }

    public void setLastReviewedAt(ZonedDateTime lastReviewedAt) {
        this.lastReviewedAt = lastReviewedAt;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public enum FlashcardStatus {
        UNKNOWN, LEARNING, MASTERED
    }
}
