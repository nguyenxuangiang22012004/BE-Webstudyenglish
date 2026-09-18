package com.example.app.controller;

import com.example.app.dto.request.ConsumeTrialRequest;
import com.example.app.dto.request.SaveUserAiKeyRequest;
import com.example.app.dto.response.ApiResponse;
import com.example.app.dto.response.TrialConsumeResponse;
import com.example.app.dto.response.UserAiSettingDTO;
import com.example.app.entity.User;
import com.example.app.repository.UserRepository;
import com.example.app.service.AiKeyManagementService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/ai-config")
public class UserAiController {

    private final AiKeyManagementService aiKeyManagementService;
    private final UserRepository userRepository;

    public UserAiController(AiKeyManagementService aiKeyManagementService, UserRepository userRepository) {
        this.aiKeyManagementService = aiKeyManagementService;
        this.userRepository = userRepository;
    }

    private User getCurrentUserOrNull() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
            return null;
        }
        String email = authentication.getName();
        return userRepository.findByEmail(email).orElse(null);
    }

    /**
     * GET /v1/ai-config/my-key
     * Lấy trạng thái và API Key của người dùng đã đăng nhập
     */
    @GetMapping("/my-key")
    public ResponseEntity<ApiResponse<UserAiSettingDTO>> getMyAiSetting() {
        User user = getCurrentUserOrNull();
        if (user == null) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Chưa đăng nhập", new UserAiSettingDTO(false, null, "gemini-2.5-flash", null, null)));
        }
        UserAiSettingDTO setting = aiKeyManagementService.getUserAiSetting(user.getId());
        return ResponseEntity.ok(new ApiResponse<>(true, "Lấy cài đặt AI thành công", setting));
    }

    /**
     * POST /v1/ai-config/my-key
     * Lưu hoặc cập nhật API Key cá nhân của người dùng
     */
    @PostMapping("/my-key")
    public ResponseEntity<ApiResponse<UserAiSettingDTO>> saveMyAiSetting(@Valid @RequestBody SaveUserAiKeyRequest request) {
        User user = getCurrentUserOrNull();
        if (user == null) {
            return ResponseEntity.status(401).body(new ApiResponse<>(false, "Vui lòng đăng nhập để lưu API Key lên tài khoản", null));
        }
        UserAiSettingDTO saved = aiKeyManagementService.saveUserAiSetting(user.getId(), request);
        return ResponseEntity.ok(new ApiResponse<>(true, "Lưu API Key cá nhân thành công", saved));
    }

    /**
     * DELETE /v1/ai-config/my-key
     * Xóa API Key cá nhân của người dùng
     */
    @DeleteMapping("/my-key")
    public ResponseEntity<ApiResponse<Void>> deleteMyAiSetting() {
        User user = getCurrentUserOrNull();
        if (user != null) {
            aiKeyManagementService.deleteUserAiSetting(user.getId());
        }
        return ResponseEntity.ok(new ApiResponse<>(true, "Đã xóa API Key cá nhân", null));
    }

    /**
     * POST /v1/ai-config/trial/consume
     * Tiêu thụ 1 lượt prompt dùng thử cho tính năng (chặn tối đa 2 lần)
     */
    @PostMapping("/trial/consume")
    public ResponseEntity<ApiResponse<TrialConsumeResponse>> consumeTrial(
            @Valid @RequestBody ConsumeTrialRequest request,
            HttpServletRequest httpServletRequest) {

        User user = getCurrentUserOrNull();
        UUID userId = user != null ? user.getId() : null;

        // Lấy IP client
        String clientIp = httpServletRequest.getHeader("X-Forwarded-For");
        if (clientIp == null || clientIp.isBlank()) {
            clientIp = httpServletRequest.getRemoteAddr();
        } else if (clientIp.contains(",")) {
            clientIp = clientIp.split(",")[0].trim();
        }

        TrialConsumeResponse response = aiKeyManagementService.consumeTrialPrompt(
                request.getFeatureName(),
                request.getDeviceId(),
                clientIp,
                userId
        );

        if (!response.isAllowed()) {
            return ResponseEntity.status(403).body(new ApiResponse<>(false, response.getMessage(), response));
        }

        return ResponseEntity.ok(new ApiResponse<>(true, response.getMessage(), response));
    }

    /**
     * GET /v1/ai-config/trial/remaining
     * Kiểm tra số lượt dùng thử còn lại
     */
    @GetMapping("/trial/remaining")
    public ResponseEntity<ApiResponse<Integer>> getRemainingTrial(
            @RequestParam String featureName,
            @RequestParam String deviceId) {
        int remaining = aiKeyManagementService.getRemainingTrialCount(featureName, deviceId);
        return ResponseEntity.ok(new ApiResponse<>(true, "Số lượt dùng thử còn lại", remaining));
    }
}
