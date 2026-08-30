package com.example.app.service;

import com.example.app.dto.request.AiLookupHistoryRequest;
import com.example.app.dto.response.AiLookupHistoryResponse;

import java.util.List;
import java.util.UUID;

public interface AiLookupHistoryService {
    AiLookupHistoryResponse saveHistory(UUID userId, AiLookupHistoryRequest request);
    List<AiLookupHistoryResponse> getRecentHistory(UUID userId);
}
