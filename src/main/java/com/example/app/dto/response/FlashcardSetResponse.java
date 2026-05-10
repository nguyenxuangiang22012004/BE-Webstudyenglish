package com.example.app.dto.response;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class FlashcardSetResponse {
    private UUID id;
    private String name;
    private String description;
    private String emoji;
    private Boolean isPublic;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private int totalCards;
    private List<FlashcardResponse> cards;

    public FlashcardSetResponse() {}

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getEmoji() { return emoji; }
    public void setEmoji(String emoji) { this.emoji = emoji; }

    public Boolean getIsPublic() { return isPublic; }
    public void setIsPublic(Boolean isPublic) { this.isPublic = isPublic; }

    public ZonedDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(ZonedDateTime createdAt) { this.createdAt = createdAt; }

    public ZonedDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(ZonedDateTime updatedAt) { this.updatedAt = updatedAt; }

    public int getTotalCards() { return totalCards; }
    public void setTotalCards(int totalCards) { this.totalCards = totalCards; }

    public List<FlashcardResponse> getCards() { return cards; }
    public void setCards(List<FlashcardResponse> cards) { this.cards = cards; }
}
