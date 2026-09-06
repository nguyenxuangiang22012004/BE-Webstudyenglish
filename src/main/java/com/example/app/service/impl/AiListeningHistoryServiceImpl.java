package com.example.app.service.impl;

import com.example.app.dto.request.SaveAiListeningHistoryRequest;
import com.example.app.dto.response.AiListeningHistoryResponse;
import com.example.app.entity.AiListeningHistory;
import com.example.app.entity.User;
import com.example.app.repository.AiListeningHistoryRepository;
import com.example.app.service.AiListeningHistoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AiListeningHistoryServiceImpl implements AiListeningHistoryService {

    private final AiListeningHistoryRepository aiListeningHistoryRepository;
    private final com.example.app.repository.UserRepository userRepository;

    public AiListeningHistoryServiceImpl(AiListeningHistoryRepository aiListeningHistoryRepository,
                                         com.example.app.repository.UserRepository userRepository) {
        this.aiListeningHistoryRepository = aiListeningHistoryRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public AiListeningHistoryResponse saveHistory(User currentUser, SaveAiListeningHistoryRequest request) {
        User user = userRepository.findById(currentUser.getId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        AiListeningHistory history = new AiListeningHistory();
        history.setUser(user);
        history.setTopic(request.getTopic());
        history.setLevel(request.getLevel());
        history.setLessonData(request.getLessonData() != null ? request.getLessonData() : com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode());
        history.setUserAnswersData(request.getUserAnswersData() != null ? request.getUserAnswersData() : com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode());
        history.setScore(request.getScore() != null ? request.getScore() : 0);

        history = aiListeningHistoryRepository.save(history);
        return mapToResponse(history);
    }

    @Override
    @Transactional
    public AiListeningHistoryResponse updateHistory(User currentUser, java.util.UUID id, com.example.app.dto.request.UpdateAiListeningHistoryRequest request) {
        AiListeningHistory history = aiListeningHistoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy lịch sử bài nghe"));
        
        if (!history.getUser().getId().equals(currentUser.getId())) {
            throw new IllegalArgumentException("Bạn không có quyền cập nhật lịch sử này");
        }

        if (request.getUserAnswersData() != null) {
            history.setUserAnswersData(request.getUserAnswersData());
        }
        if (request.getScore() != null) {
            history.setScore(request.getScore());
        }

        history = aiListeningHistoryRepository.save(history);
        return mapToResponse(history);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<AiListeningHistoryResponse> getHistory(User user, Pageable pageable) {
        return aiListeningHistoryRepository.findByUserIdOrderByCreatedAtDesc(user.getId(), pageable)
                .map(this::mapToResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public AiListeningHistoryResponse getHistoryById(User currentUser, java.util.UUID id) {
        AiListeningHistory history = aiListeningHistoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy lịch sử bài nghe"));

        if (!history.getUser().getId().equals(currentUser.getId())) {
            throw new IllegalArgumentException("Bạn không có quyền truy cập lịch sử này");
        }

        return mapToResponse(history);
    }

    private AiListeningHistoryResponse mapToResponse(AiListeningHistory history) {
        AiListeningHistoryResponse response = new AiListeningHistoryResponse();
        response.setId(history.getId());
        response.setTopic(history.getTopic());
        response.setLevel(history.getLevel());
        response.setLessonData(history.getLessonData());
        response.setUserAnswersData(history.getUserAnswersData());
        response.setScore(history.getScore());
        response.setCreatedAt(history.getCreatedAt());
        return response;
    }
}
