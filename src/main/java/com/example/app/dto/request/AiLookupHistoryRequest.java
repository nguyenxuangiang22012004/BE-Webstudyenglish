package com.example.app.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AiLookupHistoryRequest {
    @NotBlank(message = "Word is required")
    private String word;

    private String partOfSpeech;
    private String pronunciation;
    private String meaning;
    private String example;
}
