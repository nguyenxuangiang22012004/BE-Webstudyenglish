package com.example.app.service;

import com.example.app.dto.request.CreateSetRequest;
import com.example.app.dto.request.CreateFlashcardRequest;
import com.example.app.dto.response.FlashcardResponse;
import com.example.app.dto.response.FlashcardSetResponse;

import java.util.List;
import java.util.UUID;

public interface FlashcardService {
    // Set operations
    FlashcardSetResponse createSet(CreateSetRequest request, String ownerEmail);
    List<FlashcardSetResponse> getMySets(String ownerEmail);
    FlashcardSetResponse getSetById(UUID setId, String ownerEmail, String status);
    void deleteSet(UUID setId, String ownerEmail);

    // Card operations
    List<FlashcardResponse> addCardsToSet(UUID setId, List<CreateFlashcardRequest> cards, String ownerEmail);
    List<FlashcardResponse> getCardsInSet(UUID setId, String ownerEmail);
    void deleteCard(UUID setId, UUID cardId, String ownerEmail);

    // Progress operations
    com.example.app.dto.response.FlashcardProgressResponse updateFlashcardProgress(UUID cardId, com.example.app.dto.request.UpdateFlashcardProgressRequest request, String ownerEmail);
}
