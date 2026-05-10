package com.example.app.dto.response;

import com.example.app.entity.UserFlashcardProgress.FlashcardStatus;
import java.time.ZonedDateTime;
import java.util.UUID;

public class FlashcardProgressResponse {
    private UUID flashcardId;
    private FlashcardStatus status;
    private ZonedDateTime lastReviewedAt;
    private ZonedDateTime nextReviewDate;

    public FlashcardProgressResponse() {}

    public FlashcardProgressResponse(UUID flashcardId, FlashcardStatus status, ZonedDateTime lastReviewedAt, ZonedDateTime nextReviewDate) {
        this.flashcardId = flashcardId;
        this.status = status;
        this.lastReviewedAt = lastReviewedAt;
        this.nextReviewDate = nextReviewDate;
    }

    public UUID getFlashcardId() {
        return flashcardId;
    }

    public void setFlashcardId(UUID flashcardId) {
        this.flashcardId = flashcardId;
    }

    public FlashcardStatus getStatus() {
        return status;
    }

    public void setStatus(FlashcardStatus status) {
        this.status = status;
    }

    public ZonedDateTime getLastReviewedAt() {
        return lastReviewedAt;
    }

    public void setLastReviewedAt(ZonedDateTime lastReviewedAt) {
        this.lastReviewedAt = lastReviewedAt;
    }

    public ZonedDateTime getNextReviewDate() {
        return nextReviewDate;
    }

    public void setNextReviewDate(ZonedDateTime nextReviewDate) {
        this.nextReviewDate = nextReviewDate;
    }
}
