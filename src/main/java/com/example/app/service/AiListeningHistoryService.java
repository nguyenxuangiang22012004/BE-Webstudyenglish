package com.example.app.service;

import com.example.app.dto.request.SaveAiListeningHistoryRequest;
import com.example.app.dto.response.AiListeningHistoryResponse;
import com.example.app.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AiListeningHistoryService {
    AiListeningHistoryResponse saveHistory(User user, SaveAiListeningHistoryRequest request);
    Page<AiListeningHistoryResponse> getHistory(User user, Pageable pageable);
}
