package com.example.app.controller;

import com.example.app.dto.request.CreateAdminAiKeyRequest;
import com.example.app.dto.request.TestAiKeyRequest;
import com.example.app.dto.request.UpdateAdminAiKeyRequest;
import com.example.app.dto.response.AdminAiKeyDTO;
import com.example.app.dto.response.AdminAiStatsDTO;
import com.example.app.dto.response.AiKeyTestResponse;
import com.example.app.dto.response.ApiResponse;
import com.example.app.service.AiKeyManagementService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/admin/ai-settings")
@PreAuthorize("hasRole('ADMIN')")
public class AdminAiController {

    private final AiKeyManagementService aiKeyManagementService;

    public AdminAiController(AiKeyManagementService aiKeyManagementService) {
        this.aiKeyManagementService = aiKeyManagementService;
    }

    /**
     * GET /v1/admin/ai-settings/keys
     * Lấy toàn bộ danh sách Admin API Keys
     */
    @GetMapping("/keys")
    public ResponseEntity<ApiResponse<List<AdminAiKeyDTO>>> getAllKeys() {
        List<AdminAiKeyDTO> keys = aiKeyManagementService.getAllAdminKeys();
        return ResponseEntity.ok(new ApiResponse<>(true, "Lấy danh sách Admin API Keys thành công", keys));
    }

    /**
     * POST /v1/admin/ai-settings/keys
     * Thêm mới 1 Admin API Key
     */
    @PostMapping("/keys")
    public ResponseEntity<ApiResponse<AdminAiKeyDTO>> createKey(@Valid @RequestBody CreateAdminAiKeyRequest request) {
        AdminAiKeyDTO created = aiKeyManagementService.createAdminKey(request);
        return ResponseEntity.ok(new ApiResponse<>(true, "Thêm Admin API Key thành công", created));
    }

    /**
     * PUT /v1/admin/ai-settings/keys/{id}
     * Cập nhật thông tin Admin API Key
     */
    @PutMapping("/keys/{id}")
    public ResponseEntity<ApiResponse<AdminAiKeyDTO>> updateKey(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateAdminAiKeyRequest request) {
        AdminAiKeyDTO updated = aiKeyManagementService.updateAdminKey(id, request);
        return ResponseEntity.ok(new ApiResponse<>(true, "Cập nhật Admin API Key thành công", updated));
    }

    /**
     * DELETE /v1/admin/ai-settings/keys/{id}
     * Xóa 1 Admin API Key
     */
    @DeleteMapping("/keys/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteKey(@PathVariable UUID id) {
        aiKeyManagementService.deleteAdminKey(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Đã xóa Admin API Key", null));
    }

    /**
     * PATCH /v1/admin/ai-settings/keys/{id}/toggle
     * Bật/Tắt trạng thái hoạt động của key
     */
    @PatchMapping("/keys/{id}/toggle")
    public ResponseEntity<ApiResponse<AdminAiKeyDTO>> toggleKey(@PathVariable UUID id) {
        AdminAiKeyDTO toggled = aiKeyManagementService.toggleAdminKeyStatus(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Đã thay đổi trạng thái Admin API Key", toggled));
    }

    /**
     * POST /v1/admin/ai-settings/test-key
     * Kiểm tra tính hợp lệ và độ trễ của API Key truyền trực tiếp
     */
     @PostMapping("/test-key")
     public ResponseEntity<ApiResponse<AiKeyTestResponse>> testKey(
             @RequestBody TestAiKeyRequest request,
             @RequestParam(defaultValue = "gemini-2.5-flash") String model) {
         AiKeyTestResponse result = aiKeyManagementService.testAiKey(request.getApiKey(), model);
         return ResponseEntity.ok(new ApiResponse<>(result.isSuccess(), result.getMessage(), result));
     }

    /**
     * POST /v1/admin/ai-settings/keys/{id}/test
     * Kiểm tra tính hợp lệ và độ trễ của Admin API Key đã lưu
     */
    @PostMapping("/keys/{id}/test")
    public ResponseEntity<ApiResponse<AiKeyTestResponse>> testAdminKey(
            @PathVariable UUID id,
            @RequestParam(defaultValue = "gemini-2.5-flash") String model) {
        AiKeyTestResponse result = aiKeyManagementService.testAdminKeyById(id, model);
        return ResponseEntity.ok(new ApiResponse<>(result.isSuccess(), result.getMessage(), result));
    }

    /**
     * GET /v1/admin/ai-settings/stats
     * Lấy thống kê tổng quan AI và số lượt dùng thử theo từng tính năng
     */
    @GetMapping("/stats")
    public ResponseEntity<ApiResponse<AdminAiStatsDTO>> getStats() {
        AdminAiStatsDTO stats = aiKeyManagementService.getAdminAiStats();
        return ResponseEntity.ok(new ApiResponse<>(true, "Lấy thống kê AI thành công", stats));
    }
}
