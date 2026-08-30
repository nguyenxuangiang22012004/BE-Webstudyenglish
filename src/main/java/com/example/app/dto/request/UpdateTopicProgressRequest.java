package com.example.app.dto.request;

import java.util.UUID;

public class UpdateTopicProgressRequest {

    private UUID currentLessonId;
    private Integer currentStep = 0;
    private String status; // NOT_STARTED | IN_PROGRESS | COMPLETED
    private Integer score;

    public UpdateTopicProgressRequest() {}

    public UUID getCurrentLessonId() {
        return currentLessonId;
    }

    public void setCurrentLessonId(UUID currentLessonId) {
        this.currentLessonId = currentLessonId;
    }

    public Integer getCurrentStep() {
        return currentStep;
    }

    public void setCurrentStep(Integer currentStep) {
        this.currentStep = currentStep;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
