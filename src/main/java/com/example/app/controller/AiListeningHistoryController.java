package com.example.app.controller;

import com.example.app.dto.request.SaveAiListeningHistoryRequest;
import com.example.app.dto.response.AiListeningHistoryResponse;
import com.example.app.dto.response.ApiResponse;
import com.example.app.entity.User;
import com.example.app.security.CustomUserDetails;
import com.example.app.service.AiListeningHistoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/ai-listening")
public class AiListeningHistoryController {

    private final AiListeningHistoryService aiListeningHistoryService;

    public AiListeningHistoryController(AiListeningHistoryService aiListeningHistoryService) {
        this.aiListeningHistoryService = aiListeningHistoryService;
    }

    @PostMapping("/history")
    public ResponseEntity<ApiResponse<AiListeningHistoryResponse>> saveHistory(
            @AuthenticationPrincipal CustomUserDetails currentUser,
            @RequestBody SaveAiListeningHistoryRequest request) {
        AiListeningHistoryResponse response = aiListeningHistoryService.saveHistory(currentUser.getUser(), request);
        return ResponseEntity.ok(new ApiResponse<>(true, "Lưu lịch sử bài nghe thành công", response));
    }

    @PutMapping("/history/{id}")
    public ResponseEntity<ApiResponse<AiListeningHistoryResponse>> updateHistory(
            @AuthenticationPrincipal CustomUserDetails currentUser,
            @PathVariable java.util.UUID id,
            @RequestBody com.example.app.dto.request.UpdateAiListeningHistoryRequest request) {
        AiListeningHistoryResponse response = aiListeningHistoryService.updateHistory(currentUser.getUser(), id, request);
        return ResponseEntity.ok(new ApiResponse<>(true, "Cập nhật lịch sử bài nghe thành công", response));
    }

    @GetMapping("/history")
    public ResponseEntity<ApiResponse<Page<AiListeningHistoryResponse>>> getHistory(
            @AuthenticationPrincipal CustomUserDetails currentUser,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<AiListeningHistoryResponse> response = aiListeningHistoryService.getHistory(currentUser.getUser(), pageable);
        return ResponseEntity.ok(new ApiResponse<>(true, "Lấy danh sách lịch sử thành công", response));
    }

    @GetMapping("/history/{id}")
    public ResponseEntity<ApiResponse<AiListeningHistoryResponse>> getHistoryById(
            @AuthenticationPrincipal CustomUserDetails currentUser,
            @PathVariable java.util.UUID id) {
        AiListeningHistoryResponse response = aiListeningHistoryService.getHistoryById(currentUser.getUser(), id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Lấy chi tiết bài nghe thành công", response));
    }
}
