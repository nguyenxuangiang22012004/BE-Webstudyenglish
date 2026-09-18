package com.example.app.dto.request;

import jakarta.validation.constraints.Size;

public class SaveUserAiKeyRequest {

    private String apiKey;

    @Size(max = 100, message = "Model tối đa 100 ký tự")
    private String preferredModel = "gemini-2.5-flash";

    public SaveUserAiKeyRequest() {
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getPreferredModel() {
        return preferredModel;
    }

    public void setPreferredModel(String preferredModel) {
        this.preferredModel = preferredModel;
    }
}
