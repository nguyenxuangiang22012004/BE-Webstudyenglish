package com.example.app.dto.response;

import java.time.ZonedDateTime;

public class UserAiSettingDTO {

    private boolean hasApiKey;
    private String maskedApiKey;
    private String preferredModel;
    private String apiKey; // Trả về raw API key cho chính user đã xác thực để FE gọi AI client
    private ZonedDateTime updatedAt;

    public UserAiSettingDTO() {
    }

    public UserAiSettingDTO(boolean hasApiKey, String maskedApiKey, String preferredModel, String apiKey, ZonedDateTime updatedAt) {
        this.hasApiKey = hasApiKey;
        this.maskedApiKey = maskedApiKey;
        this.preferredModel = preferredModel;
        this.apiKey = apiKey;
        this.updatedAt = updatedAt;
    }

    public boolean isHasApiKey() {
        return hasApiKey;
    }

    public void setHasApiKey(boolean hasApiKey) {
        this.hasApiKey = hasApiKey;
    }

    public String getMaskedApiKey() {
        return maskedApiKey;
    }

    public void setMaskedApiKey(String maskedApiKey) {
        this.maskedApiKey = maskedApiKey;
    }

    public String getPreferredModel() {
        return preferredModel;
    }

    public void setPreferredModel(String preferredModel) {
        this.preferredModel = preferredModel;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
