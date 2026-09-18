package com.example.app.service;

import com.example.app.dto.request.CreateAdminAiKeyRequest;
import com.example.app.dto.request.SaveUserAiKeyRequest;
import com.example.app.dto.request.UpdateAdminAiKeyRequest;
import com.example.app.dto.response.*;

import java.util.List;
import java.util.UUID;

public interface AiKeyManagementService {

    // Admin Key Management
    List<AdminAiKeyDTO> getAllAdminKeys();

    AdminAiKeyDTO createAdminKey(CreateAdminAiKeyRequest request);

    AdminAiKeyDTO updateAdminKey(UUID id, UpdateAdminAiKeyRequest request);

    void deleteAdminKey(UUID id);

    AdminAiKeyDTO toggleAdminKeyStatus(UUID id);

    AiKeyTestResponse testAiKey(String apiKey, String model);

    AiKeyTestResponse testAdminKeyById(UUID id, String model);

    AdminAiStatsDTO getAdminAiStats();

    // User Key Management
    UserAiSettingDTO getUserAiSetting(UUID userId);

    UserAiSettingDTO saveUserAiSetting(UUID userId, SaveUserAiKeyRequest request);

    void deleteUserAiSetting(UUID userId);

    // Trial Quota & Consumption
    TrialConsumeResponse consumeTrialPrompt(String featureName, String deviceId, String ipAddress, UUID userId);

    int getRemainingTrialCount(String featureName, String deviceId);
}
