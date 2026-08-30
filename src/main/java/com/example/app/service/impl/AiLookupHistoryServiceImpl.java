package com.example.app.service.impl;

import com.example.app.dto.request.AiLookupHistoryRequest;
import com.example.app.dto.response.AiLookupHistoryResponse;
import com.example.app.entity.AiLookupHistory;
import com.example.app.entity.User;
import com.example.app.repository.AiLookupHistoryRepository;
import com.example.app.repository.UserRepository;
import com.example.app.service.AiLookupHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AiLookupHistoryServiceImpl implements AiLookupHistoryService {

    private final AiLookupHistoryRepository aiLookupHistoryRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public AiLookupHistoryResponse saveHistory(UUID userId, AiLookupHistoryRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        AiLookupHistory history = AiLookupHistory.builder()
                .user(user)
                .word(request.getWord())
                .partOfSpeech(request.getPartOfSpeech())
                .pronunciation(request.getPronunciation())
                .meaning(request.getMeaning())
                .example(request.getExample())
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
        return AiLookupHistoryResponse.builder()
                .id(history.getId())
                .word(history.getWord())
                .partOfSpeech(history.getPartOfSpeech())
                .pronunciation(history.getPronunciation())
                .meaning(history.getMeaning())
                .example(history.getExample())
                .createdAt(history.getCreatedAt())
                .build();
    }
}
