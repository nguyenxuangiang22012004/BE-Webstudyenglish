package com.example.app.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateFlashcardRequest {

    @NotBlank(message = "Word is required")
    @Size(max = 255, message = "Word must be less than 255 characters")
    private String word;

    @NotBlank(message = "Meaning is required")
    @Size(max = 500, message = "Meaning must be less than 500 characters")
    private String meaning;

    @Size(max = 255)
    private String pronunciation;

    private String example;

    @Size(max = 50)
    private String partOfSpeech;


    public String getWord() { return word; }
    public void setWord(String word) { this.word = word; }

    public String getMeaning() { return meaning; }
    public void setMeaning(String meaning) { this.meaning = meaning; }

    public String getPronunciation() { return pronunciation; }
    public void setPronunciation(String pronunciation) { this.pronunciation = pronunciation; }

    public String getExample() { return example; }
    public void setExample(String example) { this.example = example; }

    public String getPartOfSpeech() { return partOfSpeech; }
    public void setPartOfSpeech(String partOfSpeech) { this.partOfSpeech = partOfSpeech; }

}
