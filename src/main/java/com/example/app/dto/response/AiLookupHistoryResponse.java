package com.example.app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AiLookupHistoryResponse {
    private UUID id;
    private String word;
    private String partOfSpeech;
    private String pronunciation;
    private String meaning;
    private String example;
    private LocalDateTime createdAt;
}
