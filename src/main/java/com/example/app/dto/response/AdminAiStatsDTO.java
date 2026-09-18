package com.example.app.dto.response;

import java.util.Map;

public class AdminAiStatsDTO {

    private long totalAdminKeys;
    private long activeAdminKeys;
    private long totalTrialDevices;
    private long totalTrialPromptsUsed;
    private Map<String, Long> usageByFeature;

    public AdminAiStatsDTO() {
    }

    public AdminAiStatsDTO(long totalAdminKeys, long activeAdminKeys, long totalTrialDevices,
                           long totalTrialPromptsUsed, Map<String, Long> usageByFeature) {
        this.totalAdminKeys = totalAdminKeys;
        this.activeAdminKeys = activeAdminKeys;
        this.totalTrialDevices = totalTrialDevices;
        this.totalTrialPromptsUsed = totalTrialPromptsUsed;
        this.usageByFeature = usageByFeature;
    }

    public long getTotalAdminKeys() {
        return totalAdminKeys;
    }

    public void setTotalAdminKeys(long totalAdminKeys) {
        this.totalAdminKeys = totalAdminKeys;
    }

    public long getActiveAdminKeys() {
        return activeAdminKeys;
    }

    public void setActiveAdminKeys(long activeAdminKeys) {
        this.activeAdminKeys = activeAdminKeys;
    }

    public long getTotalTrialDevices() {
        return totalTrialDevices;
    }

    public void setTotalTrialDevices(long totalTrialDevices) {
        this.totalTrialDevices = totalTrialDevices;
    }

    public long getTotalTrialPromptsUsed() {
        return totalTrialPromptsUsed;
    }

    public void setTotalTrialPromptsUsed(long totalTrialPromptsUsed) {
        this.totalTrialPromptsUsed = totalTrialPromptsUsed;
    }

    public Map<String, Long> getUsageByFeature() {
        return usageByFeature;
    }

    public void setUsageByFeature(Map<String, Long> usageByFeature) {
        this.usageByFeature = usageByFeature;
    }
}
