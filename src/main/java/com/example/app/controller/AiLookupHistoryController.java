package com.example.app.controller;

import com.example.app.dto.request.AiLookupHistoryRequest;
import com.example.app.dto.response.AiLookupHistoryResponse;
import com.example.app.security.CustomUserDetails;
import com.example.app.service.AiLookupHistoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/ai-lookup/history")
@RequiredArgsConstructor
public class AiLookupHistoryController {

    private final AiLookupHistoryService aiLookupHistoryService;

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<AiLookupHistoryResponse> saveHistory(
            @AuthenticationPrincipal CustomUserDetails currentUser,
            @Valid @RequestBody AiLookupHistoryRequest request) {
        return ResponseEntity.ok(aiLookupHistoryService.saveHistory(currentUser.getId(), request));
    }

    @GetMapping("/recent")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<AiLookupHistoryResponse>> getRecentHistory(
            @AuthenticationPrincipal CustomUserDetails currentUser) {
        return ResponseEntity.ok(aiLookupHistoryService.getRecentHistory(currentUser.getId()));
    }
}
