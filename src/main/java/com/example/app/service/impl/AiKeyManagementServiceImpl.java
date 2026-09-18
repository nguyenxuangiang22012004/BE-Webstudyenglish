package com.example.app.service.impl;

import com.example.app.dto.request.CreateAdminAiKeyRequest;
import com.example.app.dto.request.SaveUserAiKeyRequest;
import com.example.app.dto.request.UpdateAdminAiKeyRequest;
import com.example.app.dto.response.*;
import com.example.app.entity.AdminAiKey;
import com.example.app.entity.DeviceTrialUsage;
import com.example.app.entity.User;
import com.example.app.entity.UserAiSetting;
import com.example.app.repository.AdminAiKeyRepository;
import com.example.app.repository.DeviceTrialUsageRepository;
import com.example.app.repository.UserAiSettingRepository;
import com.example.app.repository.UserRepository;
import com.example.app.security.crypto.AesEncryptionUtil;
import com.example.app.service.AiKeyManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.*;

@Service
public class AiKeyManagementServiceImpl implements AiKeyManagementService {

    private static final Logger log = LoggerFactory.getLogger(AiKeyManagementServiceImpl.class);
    private static final int MAX_TRIAL_PER_FEATURE = 2;

    private final AdminAiKeyRepository adminAiKeyRepository;
    private final UserAiSettingRepository userAiSettingRepository;
    private final DeviceTrialUsageRepository deviceTrialUsageRepository;
    private final UserRepository userRepository;
    private final AesEncryptionUtil encryptionUtil;
    private final HttpClient httpClient;

    public AiKeyManagementServiceImpl(
            AdminAiKeyRepository adminAiKeyRepository,
            UserAiSettingRepository userAiSettingRepository,
            DeviceTrialUsageRepository deviceTrialUsageRepository,
            UserRepository userRepository,
            AesEncryptionUtil encryptionUtil) {
        this.adminAiKeyRepository = adminAiKeyRepository;
        this.userAiSettingRepository = userAiSettingRepository;
        this.deviceTrialUsageRepository = deviceTrialUsageRepository;
        this.userRepository = userRepository;
        this.encryptionUtil = encryptionUtil;
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();
    }

    // ─── ADMIN AI KEY MANAGEMENT ──────────────────────────────────────────────

    @Override
    @Transactional(readOnly = true)
    public List<AdminAiKeyDTO> getAllAdminKeys() {
        return adminAiKeyRepository.findAllByOrderByCreatedAtDesc().stream()
                .map(this::mapToAdminAiKeyDTO)
                .toList();
    }

    @Override
    @Transactional
    public AdminAiKeyDTO createAdminKey(CreateAdminAiKeyRequest request) {
        String encryptedKey = encryptionUtil.encrypt(request.getApiKey().trim());
        AdminAiKey key = new AdminAiKey(request.getKeyName().trim(), encryptedKey);
        if (request.getIsActive() != null) {
            key.setActive(request.getIsActive());
        }
        AdminAiKey saved = adminAiKeyRepository.save(key);
        return mapToAdminAiKeyDTO(saved);
    }

    @Override
    @Transactional
    public AdminAiKeyDTO updateAdminKey(UUID id, UpdateAdminAiKeyRequest request) {
        AdminAiKey key = adminAiKeyRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Không tìm thấy Admin API Key với ID: " + id));

        if (request.getKeyName() != null && !request.getKeyName().isBlank()) {
            key.setKeyName(request.getKeyName().trim());
        }
        if (request.getApiKey() != null && !request.getApiKey().isBlank()) {
            key.setEncryptedKey(encryptionUtil.encrypt(request.getApiKey().trim()));
        }
        if (request.getIsActive() != null) {
            key.setActive(request.getIsActive());
        }

        AdminAiKey updated = adminAiKeyRepository.save(key);
        return mapToAdminAiKeyDTO(updated);
    }

    @Override
    @Transactional
    public void deleteAdminKey(UUID id) {
        if (!adminAiKeyRepository.existsById(id)) {
            throw new NoSuchElementException("Không tìm thấy Admin API Key với ID: " + id);
        }
        adminAiKeyRepository.deleteById(id);
    }

    @Override
    @Transactional
    public AdminAiKeyDTO toggleAdminKeyStatus(UUID id) {
        AdminAiKey key = adminAiKeyRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Không tìm thấy Admin API Key với ID: " + id));
        key.setActive(!key.isActive());
        AdminAiKey updated = adminAiKeyRepository.save(key);
        return mapToAdminAiKeyDTO(updated);
    }

    @Override
    public AiKeyTestResponse testAiKey(String apiKey, String model) {
        String testModel = (model != null && !model.isBlank()) ? model : "gemini-2.5-flash";
        String testKey = apiKey != null ? apiKey.trim() : "";

        if (testKey.isBlank()) {
            return new AiKeyTestResponse(false, "API Key không được để trống", testModel, 0L);
        }

        long start = System.currentTimeMillis();
        try {
            String url = String.format("https://generativelanguage.googleapis.com/v1beta/models/%s:generateContent?key=%s",
                    testModel, testKey);

            String requestBody = "{\"contents\":[{\"parts\":[{\"text\":\"ping\"}]}],\"generationConfig\":{\"maxOutputTokens\":5}}";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .timeout(Duration.ofSeconds(15))
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            long latency = System.currentTimeMillis() - start;

            if (response.statusCode() == 200) {
                return new AiKeyTestResponse(true, "Kết nối Gemini API thành công! Mô hình phản hồi bình thường.", testModel, latency);
            } else {
                String body = response.body();
                String errorSnippet = body.length() > 200 ? body.substring(0, 200) + "..." : body;
                return new AiKeyTestResponse(false, "Lỗi từ Gemini (HTTP " + response.statusCode() + "): " + errorSnippet, testModel, latency);
            }
        } catch (Exception e) {
            long latency = System.currentTimeMillis() - start;
            log.error("Test AI Key thất bại: {}", e.getMessage());
            return new AiKeyTestResponse(false, "Không thể kết nối đến Google Gemini: " + e.getMessage(), testModel, latency);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public AiKeyTestResponse testAdminKeyById(UUID id, String model) {
        AdminAiKey key = adminAiKeyRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Không tìm thấy Admin API Key với ID: " + id));
        try {
            String plainKey = encryptionUtil.decrypt(key.getEncryptedKey());
            return testAiKey(plainKey, model);
        } catch (Exception e) {
            log.error("Không thể giải mã Admin API Key ID {}: {}", id, e.getMessage());
            return new AiKeyTestResponse(false, "Không thể giải mã Admin API Key: " + e.getMessage(), model, 0L);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public AdminAiStatsDTO getAdminAiStats() {
        List<AdminAiKey> allKeys = adminAiKeyRepository.findAll();
        long totalAdminKeys = allKeys.size();
        long activeAdminKeys = allKeys.stream().filter(AdminAiKey::isActive).count();

        long totalDevices = deviceTrialUsageRepository.countDistinctDevices();

        List<Object[]> rawUsage = deviceTrialUsageRepository.getUsageCountByFeature();
        Map<String, Long> usageByFeature = new HashMap<>();
        long totalPromptsUsed = 0;

        for (Object[] row : rawUsage) {
            String feature = (String) row[0];
            Long count = row[1] != null ? ((Number) row[1]).longValue() : 0L;
            usageByFeature.put(feature, count);
            totalPromptsUsed += count;
        }

        return new AdminAiStatsDTO(totalAdminKeys, activeAdminKeys, totalDevices, totalPromptsUsed, usageByFeature);
    }

    // ─── USER AI SETTING MANAGEMENT ───────────────────────────────────────────

    @Override
    @Transactional(readOnly = true)
    public UserAiSettingDTO getUserAiSetting(UUID userId) {
        return userAiSettingRepository.findByUserId(userId)
                .map(setting -> {
                    String rawKey = encryptionUtil.decrypt(setting.getEncryptedApiKey());
                    String maskedKey = encryptionUtil.maskKey(rawKey);
                    return new UserAiSettingDTO(
                            rawKey != null && !rawKey.isBlank(),
                            maskedKey,
                            setting.getPreferredModel(),
                            rawKey,
                            setting.getUpdatedAt()
                    );
                })
                .orElseGet(() -> new UserAiSettingDTO(false, null, "gemini-2.5-flash", null, null));
    }

    @Override
    @Transactional
    public UserAiSettingDTO saveUserAiSetting(UUID userId, SaveUserAiKeyRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("Không tìm thấy người dùng với ID: " + userId));

        UserAiSetting setting = userAiSettingRepository.findByUser(user)
                .orElseGet(() -> new UserAiSetting(user, null, "gemini-2.5-flash"));

        String rawKey = request.getApiKey() != null ? request.getApiKey().trim() : null;
        if (rawKey != null && !rawKey.isBlank()) {
            setting.setEncryptedApiKey(encryptionUtil.encrypt(rawKey));
        } else if (rawKey != null && rawKey.isBlank()) {
            setting.setEncryptedApiKey(null); // Clear key
        }

        if (request.getPreferredModel() != null && !request.getPreferredModel().isBlank()) {
            setting.setPreferredModel(request.getPreferredModel().trim());
        }

        UserAiSetting saved = userAiSettingRepository.save(setting);
        String decryptedKey = encryptionUtil.decrypt(saved.getEncryptedApiKey());
        String masked = encryptionUtil.maskKey(decryptedKey);

        return new UserAiSettingDTO(
                decryptedKey != null && !decryptedKey.isBlank(),
                masked,
                saved.getPreferredModel(),
                decryptedKey,
                saved.getUpdatedAt()
        );
    }

    @Override
    @Transactional
    public void deleteUserAiSetting(UUID userId) {
        userAiSettingRepository.findByUserId(userId).ifPresent(userAiSettingRepository::delete);
    }

    // ─── TRIAL QUOTA & CONSUMPTION ───────────────────────────────────────────

    @Override
    @Transactional
    public TrialConsumeResponse consumeTrialPrompt(String featureName, String deviceId, String ipAddress, UUID userId) {
        if (featureName == null || featureName.isBlank() || deviceId == null || deviceId.isBlank()) {
            return new TrialConsumeResponse(false, 0, MAX_TRIAL_PER_FEATURE, null, null, "Thiếu thông tin featureName hoặc deviceId.");
        }

        String sanitizedFeature = featureName.trim().toLowerCase();
        String sanitizedDevice = deviceId.trim();

        User user = userId != null ? userRepository.findById(userId).orElse(null) : null;

        DeviceTrialUsage usage = deviceTrialUsageRepository
                .findByDeviceIdAndFeatureName(sanitizedDevice, sanitizedFeature)
                .orElseGet(() -> new DeviceTrialUsage(sanitizedDevice, sanitizedFeature, 0, user, ipAddress));

        if (user != null && usage.getUser() == null) {
            usage.setUser(user);
        }
        if (ipAddress != null) {
            usage.setIpAddress(ipAddress);
        }

        // Kiểm tra xem đã vượt quá số lần cho phép chưa
        if (usage.getUsageCount() >= MAX_TRIAL_PER_FEATURE) {
            return new TrialConsumeResponse(
                    false,
                    0,
                    MAX_TRIAL_PER_FEATURE,
                    null,
                    null,
                    "Bạn đã dùng hết 2 lượt dùng thử cho tính năng này. Vui lòng thêm Gemini API Key cá nhân trong Cài đặt (⚙️) để tiếp tục không giới hạn!"
            );
        }

        // Lấy Admin API Key khả dụng
        List<AdminAiKey> activeKeys = adminAiKeyRepository.findByIsActiveTrueOrderByUsageCountAsc();
        if (activeKeys.isEmpty()) {
            return new TrialConsumeResponse(
                    false,
                    MAX_TRIAL_PER_FEATURE - usage.getUsageCount(),
                    MAX_TRIAL_PER_FEATURE,
                    null,
                    null,
                    "Hệ thống dùng thử tạm thời bận do chưa có Admin API Key khả dụng. Vui lòng nhập API Key cá nhân hoặc thử lại sau."
            );
        }

        AdminAiKey selectedKey = activeKeys.get(0);
        String decryptedKey = encryptionUtil.decrypt(selectedKey.getEncryptedKey());

        // Cập nhật lượt sử dụng của thiết bị
        usage.setUsageCount(usage.getUsageCount() + 1);
        usage.setLastUsedAt(ZonedDateTime.now());
        deviceTrialUsageRepository.save(usage);

        // Cập nhật lượt sử dụng của Admin Key
        selectedKey.setUsageCount(selectedKey.getUsageCount() + 1);
        selectedKey.setLastUsedAt(ZonedDateTime.now());
        adminAiKeyRepository.save(selectedKey);

        int remaining = MAX_TRIAL_PER_FEATURE - usage.getUsageCount();

        return new TrialConsumeResponse(
                true,
                remaining,
                MAX_TRIAL_PER_FEATURE,
                decryptedKey,
                "gemini-2.5-flash",
                String.format("Bạn đang sử dụng lượt dùng thử miễn phí (Còn %d/%d lượt)", remaining, MAX_TRIAL_PER_FEATURE)
        );
    }

    @Override
    @Transactional(readOnly = true)
    public int getRemainingTrialCount(String featureName, String deviceId) {
        if (featureName == null || deviceId == null) return 0;
        return deviceTrialUsageRepository.findByDeviceIdAndFeatureName(deviceId.trim(), featureName.trim().toLowerCase())
                .map(u -> Math.max(0, MAX_TRIAL_PER_FEATURE - u.getUsageCount()))
                .orElse(MAX_TRIAL_PER_FEATURE);
    }

    // ─── HELPER ───────────────────────────────────────────────────────────────

    private AdminAiKeyDTO mapToAdminAiKeyDTO(AdminAiKey key) {
        String rawKey = encryptionUtil.decrypt(key.getEncryptedKey());
        String maskedKey = encryptionUtil.maskKey(rawKey);
        return new AdminAiKeyDTO(
                key.getId(),
                key.getKeyName(),
                maskedKey,
                key.isActive(),
                key.getUsageCount(),
                key.getLastUsedAt(),
                key.getCreatedAt(),
                key.getUpdatedAt()
        );
    }
}
