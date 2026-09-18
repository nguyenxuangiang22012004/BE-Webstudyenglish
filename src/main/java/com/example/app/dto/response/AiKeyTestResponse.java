package com.example.app.dto.response;

public class AiKeyTestResponse {

    private boolean success;
    private String message;
    private String testedModel;
    private Long latencyMs;

    public AiKeyTestResponse() {
    }

    public AiKeyTestResponse(boolean success, String message, String testedModel, Long latencyMs) {
        this.success = success;
        this.message = message;
        this.testedModel = testedModel;
        this.latencyMs = latencyMs;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTestedModel() {
        return testedModel;
    }

    public void setTestedModel(String testedModel) {
        this.testedModel = testedModel;
    }

    public Long getLatencyMs() {
        return latencyMs;
    }

    public void setLatencyMs(Long latencyMs) {
        this.latencyMs = latencyMs;
    }
}
