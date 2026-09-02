package com.example.app.controller;

import java.util.UUID;

import com.example.app.dto.request.AddMessageRequest;
import com.example.app.dto.request.CreateConversationRequest;
import com.example.app.dto.request.UpdateVocabularyRequest;
import com.example.app.dto.response.ConversationResponse;
import com.example.app.dto.response.MessageResponse;
import com.example.app.security.CustomUserDetails;
import com.example.app.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/conversations")
public class ConversationController {

    @Autowired
    private ConversationService conversationService;

    @GetMapping
    public ResponseEntity<Page<ConversationResponse>> getConversations(
            @AuthenticationPrincipal CustomUserDetails currentUser,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(conversationService.getUserConversations(currentUser.getId(), PageRequest.of(page, size)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConversationResponse> getConversation(
            @AuthenticationPrincipal CustomUserDetails currentUser,
            @PathVariable UUID id) {
        return ResponseEntity.ok(conversationService.getConversationDetails(id, currentUser.getId()));
    }

    @PostMapping
    public ResponseEntity<ConversationResponse> createConversation(
            @AuthenticationPrincipal CustomUserDetails currentUser,
            @RequestBody CreateConversationRequest request) {
        return ResponseEntity.ok(conversationService.createConversation(currentUser.getId(), request));
    }

    @PostMapping("/{id}/messages")
    public ResponseEntity<MessageResponse> addMessage(
            @AuthenticationPrincipal CustomUserDetails currentUser,
            @PathVariable UUID id,
            @RequestBody AddMessageRequest request) {
        return ResponseEntity.ok(conversationService.addMessage(id, currentUser.getId(), request));
    }

    @PutMapping("/{id}/vocabulary")
    public ResponseEntity<ConversationResponse> updateVocabulary(
            @AuthenticationPrincipal CustomUserDetails currentUser,
            @PathVariable UUID id,
            @RequestBody UpdateVocabularyRequest request) {
        return ResponseEntity.ok(conversationService.updateVocabulary(id, currentUser.getId(), request.getVocabularyJson()));
    }

    @PutMapping("/{id}/messages/{messageId}/feedback")
    public ResponseEntity<MessageResponse> updateMessageFeedback(
            @AuthenticationPrincipal CustomUserDetails currentUser,
            @PathVariable UUID id,
            @PathVariable UUID messageId,
            @RequestBody com.example.app.dto.request.UpdateMessageFeedbackRequest request) {
        return ResponseEntity.ok(conversationService.updateMessageFeedback(
                id, messageId, currentUser.getId(), request.getFeedback(), request.getSuggestedAnswer()));
    }
}
