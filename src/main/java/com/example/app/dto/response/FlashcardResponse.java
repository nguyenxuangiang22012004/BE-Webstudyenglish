package com.example.app.dto.response;

import java.time.ZonedDateTime;
import java.util.UUID;

public class FlashcardResponse {
    private UUID id;
    private String word;
    private String meaning;
    private String pronunciation;
    private String example;
    private ZonedDateTime createdAt;

    public FlashcardResponse() {}

    public FlashcardResponse(UUID id, String word, String meaning, String pronunciation,
                             String example, ZonedDateTime createdAt) {
        this.id = id;
        this.word = word;
        this.meaning = meaning;
        this.pronunciation = pronunciation;
        this.example = example;
        this.createdAt = createdAt;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getWord() { return word; }
    public void setWord(String word) { this.word = word; }

    public String getMeaning() { return meaning; }
    public void setMeaning(String meaning) { this.meaning = meaning; }

    public String getPronunciation() { return pronunciation; }
    public void setPronunciation(String pronunciation) { this.pronunciation = pronunciation; }

    public String getExample() { return example; }
    public void setExample(String example) { this.example = example; }


    public ZonedDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(ZonedDateTime createdAt) { this.createdAt = createdAt; }
}
