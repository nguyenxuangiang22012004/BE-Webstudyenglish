package com.example.app.dto.request;

import jakarta.validation.constraints.NotBlank;

public class ConsumeTrialRequest {

    @NotBlank(message = "Tên tính năng không được để trống")
    private String featureName;

    @NotBlank(message = "Device ID không được để trống")
    private String deviceId;

    public ConsumeTrialRequest() {
    }

    public ConsumeTrialRequest(String featureName, String deviceId) {
        this.featureName = featureName;
        this.deviceId = deviceId;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
