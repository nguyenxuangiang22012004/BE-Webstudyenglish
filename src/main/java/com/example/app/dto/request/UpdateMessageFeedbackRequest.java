package com.example.app.dto.request;

public class UpdateMessageFeedbackRequest {
    private String feedback;
    private String suggestedAnswer;

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getSuggestedAnswer() {
        return suggestedAnswer;
    }

    public void setSuggestedAnswer(String suggestedAnswer) {
        this.suggestedAnswer = suggestedAnswer;
    }
}
