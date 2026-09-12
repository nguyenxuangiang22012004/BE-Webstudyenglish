package com.example.app.dto.request;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    private JsonNode entries;
    private JsonNode source;
    private JsonNode pronunciationsList;
    private List<String> synonyms;
    private List<String> antonyms;
    private String sourceUrl;
    private String fullData;
}
