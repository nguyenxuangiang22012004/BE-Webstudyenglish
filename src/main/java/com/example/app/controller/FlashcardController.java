package com.example.app.controller;

import com.example.app.dto.request.CreateFlashcardRequest;
import com.example.app.dto.request.CreateSetRequest;
import com.example.app.dto.response.ApiResponse;
import com.example.app.dto.response.FlashcardResponse;
import com.example.app.dto.response.FlashcardSetResponse;
import com.example.app.service.FlashcardService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/flashcards")
public class FlashcardController {

    private final FlashcardService flashcardService;

    public FlashcardController(FlashcardService flashcardService) {
        this.flashcardService = flashcardService;
    }

    // ============ FLASHCARD SETS ============

    @PostMapping("/sets")
    public ResponseEntity<ApiResponse<FlashcardSetResponse>> createSet(
            @Valid @RequestBody CreateSetRequest request,
            Authentication auth) {
        FlashcardSetResponse result = flashcardService.createSet(request, auth.getName());
        return ResponseEntity.ok(new ApiResponse<>(true, "Set created successfully", result));
    }

    @GetMapping("/sets")
    public ResponseEntity<ApiResponse<List<FlashcardSetResponse>>> getMySets(Authentication auth) {
        List<FlashcardSetResponse> sets = flashcardService.getMySets(auth.getName());
        return ResponseEntity.ok(new ApiResponse<>(true, "Sets retrieved successfully", sets));
    }

    @GetMapping("/sets/{setId}")
    public ResponseEntity<ApiResponse<FlashcardSetResponse>> getSetById(
            @PathVariable UUID setId,
            Authentication auth) {
        FlashcardSetResponse set = flashcardService.getSetById(setId, auth.getName());
        return ResponseEntity.ok(new ApiResponse<>(true, "Set retrieved successfully", set));
    }

    @DeleteMapping("/sets/{setId}")
    public ResponseEntity<ApiResponse<Object>> deleteSet(
            @PathVariable UUID setId,
            Authentication auth) {
        flashcardService.deleteSet(setId, auth.getName());
        return ResponseEntity.ok(new ApiResponse<>(true, "Set deleted successfully", null));
    }

    // ============ FLASHCARDS IN A SET ============

    @PostMapping("/sets/{setId}/cards")
    public ResponseEntity<ApiResponse<List<FlashcardResponse>>> addCards(
            @PathVariable UUID setId,
            @Valid @RequestBody List<@Valid CreateFlashcardRequest> cards,
            Authentication auth) {
        List<FlashcardResponse> result = flashcardService.addCardsToSet(setId, cards, auth.getName());
        return ResponseEntity.ok(new ApiResponse<>(true, "Cards added successfully", result));
    }

    @GetMapping("/sets/{setId}/cards")
    public ResponseEntity<ApiResponse<List<FlashcardResponse>>> getCards(
            @PathVariable UUID setId,
            Authentication auth) {
        List<FlashcardResponse> cards = flashcardService.getCardsInSet(setId, auth.getName());
        return ResponseEntity.ok(new ApiResponse<>(true, "Cards retrieved successfully", cards));
    }

    @DeleteMapping("/sets/{setId}/cards/{cardId}")
    public ResponseEntity<ApiResponse<Object>> deleteCard(
            @PathVariable UUID setId,
            @PathVariable UUID cardId,
            Authentication auth) {
        flashcardService.deleteCard(setId, cardId, auth.getName());
        return ResponseEntity.ok(new ApiResponse<>(true, "Card deleted successfully", null));
    }
}
