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
    private String status;
    private String partOfSpeech;

    public FlashcardResponse() {}

    public FlashcardResponse(UUID id, String word, String meaning, String pronunciation,
                             String example, ZonedDateTime createdAt, String status, String partOfSpeech) {
        this.id = id;
        this.word = word;
        this.meaning = meaning;
        this.pronunciation = pronunciation;
        this.example = example;
        this.createdAt = createdAt;
        this.status = status;
        this.partOfSpeech = partOfSpeech;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

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

    public String getPartOfSpeech() { return partOfSpeech; }
    public void setPartOfSpeech(String partOfSpeech) { this.partOfSpeech = partOfSpeech; }
}
