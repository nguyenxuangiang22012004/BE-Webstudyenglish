package com.example.app.service.impl;

import com.example.app.dto.request.AiLookupHistoryRequest;
import com.example.app.dto.response.AiLookupHistoryResponse;
import com.example.app.entity.AiLookupHistory;
import com.example.app.entity.User;
import com.example.app.repository.AiLookupHistoryRepository;
import com.example.app.repository.UserRepository;
import com.example.app.service.AiLookupHistoryService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AiLookupHistoryServiceImpl implements AiLookupHistoryService {

    private final AiLookupHistoryRepository aiLookupHistoryRepository;
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    @Override
    @Transactional
    public AiLookupHistoryResponse saveHistory(UUID userId, AiLookupHistoryRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        String fullDataJson = request.getFullData();
        if (fullDataJson == null || fullDataJson.trim().isEmpty()) {
            try {
                fullDataJson = objectMapper.writeValueAsString(request);
            } catch (Exception e) {
                log.warn("Failed to serialize lookup request to JSON: {}", e.getMessage());
            }
        }

        String sourceUrl = request.getSourceUrl();
        if (sourceUrl == null && request.getSource() != null && request.getSource().has("url")) {
            sourceUrl = request.getSource().get("url").asText();
        }

        AiLookupHistory history = AiLookupHistory.builder()
                .user(user)
                .word(request.getWord())
                .partOfSpeech(request.getPartOfSpeech())
                .pronunciation(request.getPronunciation())
                .meaning(request.getMeaning())
                .example(request.getExample())
                .fullData(fullDataJson)
                .sourceUrl(sourceUrl)
                .build();

        history = aiLookupHistoryRepository.save(history);

        return mapToResponse(history);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AiLookupHistoryResponse> getRecentHistory(UUID userId) {
        List<AiLookupHistory> histories = aiLookupHistoryRepository.findTop4ByUserIdOrderByCreatedAtDesc(userId);
        return histories.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private AiLookupHistoryResponse mapToResponse(AiLookupHistory history) {
        AiLookupHistoryResponse.AiLookupHistoryResponseBuilder builder = AiLookupHistoryResponse.builder()
                .id(history.getId())
                .word(history.getWord())
                .partOfSpeech(history.getPartOfSpeech())
                .pronunciation(history.getPronunciation())
                .meaning(history.getMeaning())
                .example(history.getExample())
                .sourceUrl(history.getSourceUrl())
                .fullData(history.getFullData())
                .createdAt(history.getCreatedAt());

        if (history.getFullData() != null && !history.getFullData().trim().isEmpty()) {
            try {
                JsonNode root = objectMapper.readTree(history.getFullData());
                if (root.has("entries")) {
                    builder.entries(root.get("entries"));
                }
                if (root.has("source")) {
                    builder.source(root.get("source"));
                }
                if (root.has("pronunciationsList")) {
                    builder.pronunciationsList(root.get("pronunciationsList"));
                }
                if (root.has("synonyms") && root.get("synonyms").isArray()) {
                    List<String> synonyms = objectMapper.convertValue(root.get("synonyms"), List.class);
                    builder.synonyms(synonyms);
                }
                if (root.has("antonyms") && root.get("antonyms").isArray()) {
                    List<String> antonyms = objectMapper.convertValue(root.get("antonyms"), List.class);
                    builder.antonyms(antonyms);
                }
            } catch (Exception e) {
                log.warn("Failed to parse fullData JSON for lookup history {}: {}", history.getId(), e.getMessage());
            }
        }

        return builder.build();
    }
}
