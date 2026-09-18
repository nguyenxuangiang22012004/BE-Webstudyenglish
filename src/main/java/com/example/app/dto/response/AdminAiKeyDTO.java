package com.example.app.dto.response;

import java.time.ZonedDateTime;
import java.util.UUID;

public class AdminAiKeyDTO {

    private UUID id;
    private String keyName;
    private String maskedKey;
    private boolean isActive;
    private Long usageCount;
    private ZonedDateTime lastUsedAt;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public AdminAiKeyDTO() {
    }

    public AdminAiKeyDTO(UUID id, String keyName, String maskedKey, boolean isActive, Long usageCount,
                         ZonedDateTime lastUsedAt, ZonedDateTime createdAt, ZonedDateTime updatedAt) {
        this.id = id;
        this.keyName = keyName;
        this.maskedKey = maskedKey;
        this.isActive = isActive;
        this.usageCount = usageCount;
        this.lastUsedAt = lastUsedAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getMaskedKey() {
        return maskedKey;
    }

    public void setMaskedKey(String maskedKey) {
        this.maskedKey = maskedKey;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Long getUsageCount() {
        return usageCount;
    }

    public void setUsageCount(Long usageCount) {
        this.usageCount = usageCount;
    }

    public ZonedDateTime getLastUsedAt() {
        return lastUsedAt;
    }

    public void setLastUsedAt(ZonedDateTime lastUsedAt) {
        this.lastUsedAt = lastUsedAt;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
