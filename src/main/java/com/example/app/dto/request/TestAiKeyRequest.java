package com.example.app.dto.request;

public class TestAiKeyRequest {

    private String apiKey;

    public TestAiKeyRequest() {
    }

    public TestAiKeyRequest(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
