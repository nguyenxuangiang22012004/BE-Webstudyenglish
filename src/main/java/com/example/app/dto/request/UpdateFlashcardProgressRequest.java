package com.example.app.dto.request;

import com.example.app.entity.UserFlashcardProgress.FlashcardStatus;

public class UpdateFlashcardProgressRequest {
    private FlashcardStatus status;

    public UpdateFlashcardProgressRequest() {}

    public FlashcardStatus getStatus() {
        return status;
    }

    public void setStatus(FlashcardStatus status) {
        this.status = status;
    }
}
