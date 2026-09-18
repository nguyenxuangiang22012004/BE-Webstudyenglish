package com.example.app.dto.response;

public class TrialConsumeResponse {

    private boolean allowed;
    private int remainingTrialCount;
    private int maxTrialCount = 2;
    private String trialApiKey; // Khóa Admin cung cấp tạm thời cho phiên gọi prompt dùng thử
    private String preferredModel = "gemini-2.5-flash";
    private String message;

    public TrialConsumeResponse() {
    }

    public TrialConsumeResponse(boolean allowed, int remainingTrialCount, int maxTrialCount, String trialApiKey, String preferredModel, String message) {
        this.allowed = allowed;
        this.remainingTrialCount = remainingTrialCount;
        this.maxTrialCount = maxTrialCount;
        this.trialApiKey = trialApiKey;
        this.preferredModel = preferredModel;
        this.message = message;
    }

    public boolean isAllowed() {
        return allowed;
    }

    public void setAllowed(boolean allowed) {
        this.allowed = allowed;
    }

    public int getRemainingTrialCount() {
        return remainingTrialCount;
    }

    public void setRemainingTrialCount(int remainingTrialCount) {
        this.remainingTrialCount = remainingTrialCount;
    }

    public int getMaxTrialCount() {
        return maxTrialCount;
    }

    public void setMaxTrialCount(int maxTrialCount) {
        this.maxTrialCount = maxTrialCount;
    }

    public String getTrialApiKey() {
        return trialApiKey;
    }

    public void setTrialApiKey(String trialApiKey) {
        this.trialApiKey = trialApiKey;
    }

    public String getPreferredModel() {
        return preferredModel;
    }

    public void setPreferredModel(String preferredModel) {
        this.preferredModel = preferredModel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
