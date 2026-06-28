package com.example.app.controller;

import com.example.app.dto.request.SaveAiListeningHistoryRequest;
import com.example.app.dto.response.AiListeningHistoryResponse;
import com.example.app.dto.response.ApiResponse;
import com.example.app.entity.User;
import com.example.app.service.AiListeningHistoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai-listening")
public class AiListeningHistoryController {

    private final AiListeningHistoryService aiListeningHistoryService;

    public AiListeningHistoryController(AiListeningHistoryService aiListeningHistoryService) {
        this.aiListeningHistoryService = aiListeningHistoryService;
    }

    @PostMapping("/history")
    public ResponseEntity<ApiResponse<AiListeningHistoryResponse>> saveHistory(
            @AuthenticationPrincipal User user,
            @RequestBody SaveAiListeningHistoryRequest request) {
        AiListeningHistoryResponse response = aiListeningHistoryService.saveHistory(user, request);
        return ResponseEntity.ok(ApiResponse.success(response, "Lưu lịch sử bài nghe thành công"));
    }

    @GetMapping("/history")
    public ResponseEntity<ApiResponse<Page<AiListeningHistoryResponse>>> getHistory(
            @AuthenticationPrincipal User user,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<AiListeningHistoryResponse> response = aiListeningHistoryService.getHistory(user, pageable);
        return ResponseEntity.ok(ApiResponse.success(response, "Lấy danh sách lịch sử thành công"));
    }
}
