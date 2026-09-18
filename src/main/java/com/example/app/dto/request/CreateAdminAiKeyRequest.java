package com.example.app.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateAdminAiKeyRequest {

    @NotBlank(message = "Tên khóa API không được để trống")
    @Size(max = 100, message = "Tên khóa tối đa 100 ký tự")
    private String keyName;

    @NotBlank(message = "API Key không được để trống")
    private String apiKey;

    private Boolean isActive = true;

    public CreateAdminAiKeyRequest() {
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
