package com.example.app.service;

import com.example.app.dto.request.CreateAdminAiKeyRequest;
import com.example.app.dto.response.AdminAiKeyDTO;
import com.example.app.dto.response.TrialConsumeResponse;
import com.example.app.entity.AdminAiKey;
import com.example.app.entity.DeviceTrialUsage;
import com.example.app.repository.AdminAiKeyRepository;
import com.example.app.repository.DeviceTrialUsageRepository;
import com.example.app.repository.UserAiSettingRepository;
import com.example.app.repository.UserRepository;
import com.example.app.security.crypto.AesEncryptionUtil;
import com.example.app.service.impl.AiKeyManagementServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AiKeyManagementServiceTest {

    @Mock
    private AdminAiKeyRepository adminAiKeyRepository;

    @Mock
    private UserAiSettingRepository userAiSettingRepository;

    @Mock
    private DeviceTrialUsageRepository deviceTrialUsageRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private AesEncryptionUtil encryptionUtil;

    @InjectMocks
    private AiKeyManagementServiceImpl aiKeyManagementService;

    @Test
    @DisplayName("Admin thêm API Key mới thành công và mã hóa key")
    void testCreateAdminKey() {
        CreateAdminAiKeyRequest request = new CreateAdminAiKeyRequest();
        request.setKeyName("Primary Admin Key");
        request.setApiKey("AIzaSyD_RealKeySample12345");
        request.setIsActive(true);

        when(encryptionUtil.encrypt("AIzaSyD_RealKeySample12345")).thenReturn("ENCRYPTED_STRING");
        when(encryptionUtil.decrypt("ENCRYPTED_STRING")).thenReturn("AIzaSyD_RealKeySample12345");
        when(encryptionUtil.maskKey("AIzaSyD_RealKeySample12345")).thenReturn("AIzaSy...2345");

        AdminAiKey savedKey = new AdminAiKey("Primary Admin Key", "ENCRYPTED_STRING");
        savedKey.setId(UUID.randomUUID());
        savedKey.setActive(true);

        when(adminAiKeyRepository.save(any(AdminAiKey.class))).thenReturn(savedKey);

        AdminAiKeyDTO dto = aiKeyManagementService.createAdminKey(request);

        assertNotNull(dto);
        assertEquals("Primary Admin Key", dto.getKeyName());
        assertEquals("AIzaSy...2345", dto.getMaskedKey());
        assertTrue(dto.isActive());
    }

    @Test
    @DisplayName("Cơ chế Dùng thử: Cho phép gọi 2 lần và chặn lần thứ 3 (Chống gian lận Device)")
    void testConsumeTrialPromptLimit() {
        String deviceId = "dev_browser_test_fingerprint_001";
        String feature = "ai-listening";

        AdminAiKey activeKey = new AdminAiKey("Admin Key 1", "ENCRYPTED_ADMIN_KEY");
        activeKey.setId(UUID.randomUUID());
        activeKey.setActive(true);

        when(adminAiKeyRepository.findByIsActiveTrueOrderByUsageCountAsc()).thenReturn(List.of(activeKey));
        when(encryptionUtil.decrypt("ENCRYPTED_ADMIN_KEY")).thenReturn("AIzaSy_TrialKey");

        // Lần 1: usage = 0 -> cho phép
        when(deviceTrialUsageRepository.findByDeviceIdAndFeatureName(deviceId, feature))
                .thenReturn(Optional.empty());

        TrialConsumeResponse res1 = aiKeyManagementService.consumeTrialPrompt(feature, deviceId, "127.0.0.1", null);
        assertTrue(res1.isAllowed());
        assertEquals(1, res1.getRemainingTrialCount());
        assertEquals("AIzaSy_TrialKey", res1.getTrialApiKey());

        // Lần 2: usage = 1 -> cho phép, còn 0 lượt
        DeviceTrialUsage usageAfter1 = new DeviceTrialUsage(deviceId, feature, 1, null, "127.0.0.1");
        when(deviceTrialUsageRepository.findByDeviceIdAndFeatureName(deviceId, feature))
                .thenReturn(Optional.of(usageAfter1));

        TrialConsumeResponse res2 = aiKeyManagementService.consumeTrialPrompt(feature, deviceId, "127.0.0.1", null);
        assertTrue(res2.isAllowed());
        assertEquals(0, res2.getRemainingTrialCount());

        // Lần 3: usage = 2 -> CHẶN
        DeviceTrialUsage usageAfter2 = new DeviceTrialUsage(deviceId, feature, 2, null, "127.0.0.1");
        when(deviceTrialUsageRepository.findByDeviceIdAndFeatureName(deviceId, feature))
                .thenReturn(Optional.of(usageAfter2));

        TrialConsumeResponse res3 = aiKeyManagementService.consumeTrialPrompt(feature, deviceId, "127.0.0.1", null);
        assertFalse(res3.isAllowed());
        assertEquals(0, res3.getRemainingTrialCount());
        assertNull(res3.getTrialApiKey());
        assertTrue(res3.getMessage().contains("dùng hết 2 lượt dùng thử"));
    }
}
