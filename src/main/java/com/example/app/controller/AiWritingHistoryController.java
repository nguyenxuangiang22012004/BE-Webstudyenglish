package com.example.app.controller;

import com.example.app.dto.request.SaveAiWritingHistoryRequest;
import com.example.app.dto.response.AiWritingHistoryResponse;
import com.example.app.dto.response.ApiResponse;
import com.example.app.security.CustomUserDetails;
import com.example.app.service.AiWritingHistoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/ai-writing")
public class AiWritingHistoryController {

    private final AiWritingHistoryService aiWritingHistoryService;

    public AiWritingHistoryController(AiWritingHistoryService aiWritingHistoryService) {
        this.aiWritingHistoryService = aiWritingHistoryService;
    }

    @PostMapping("/history")
    public ResponseEntity<ApiResponse<AiWritingHistoryResponse>> saveHistory(
            @AuthenticationPrincipal CustomUserDetails currentUser,
            @RequestBody SaveAiWritingHistoryRequest request) {
        AiWritingHistoryResponse response = aiWritingHistoryService.saveHistory(currentUser.getUser(), request);
        return ResponseEntity.ok(new ApiResponse<>(true, "Lưu lịch sử bài viết thành công", response));
    }

    @GetMapping("/history")
    public ResponseEntity<ApiResponse<Page<AiWritingHistoryResponse>>> getHistory(
            @AuthenticationPrincipal CustomUserDetails currentUser,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<AiWritingHistoryResponse> response = aiWritingHistoryService.getHistory(currentUser.getUser(), pageable);
        return ResponseEntity.ok(new ApiResponse<>(true, "Lấy danh sách lịch sử bài viết thành công", response));
    }

    @GetMapping("/history/{id}")
    public ResponseEntity<ApiResponse<AiWritingHistoryResponse>> getHistoryById(
            @AuthenticationPrincipal CustomUserDetails currentUser,
            @PathVariable UUID id) {
        AiWritingHistoryResponse response = aiWritingHistoryService.getHistoryById(currentUser.getUser(), id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Lấy chi tiết bài viết thành công", response));
    }

    @GetMapping("/analytics")
    public ResponseEntity<ApiResponse<com.example.app.dto.response.AiWritingAnalyticsResponse>> getAnalytics(
            @AuthenticationPrincipal CustomUserDetails currentUser) {
        com.example.app.dto.response.AiWritingAnalyticsResponse response = aiWritingHistoryService.getWritingAnalytics(currentUser.getUser());
        return ResponseEntity.ok(new ApiResponse<>(true, "Lấy dữ liệu phân tích tiến độ thành công", response));
    }

    @DeleteMapping("/history/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteHistory(
            @AuthenticationPrincipal CustomUserDetails currentUser,
            @PathVariable UUID id) {
        aiWritingHistoryService.deleteHistory(currentUser.getUser(), id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Xóa lịch sử bài viết thành công", null));
    }
}
