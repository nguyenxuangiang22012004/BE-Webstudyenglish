package com.example.app.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateSetRequest {

    @NotBlank(message = "Set name is required")
    @Size(max = 255, message = "Set name must be less than 255 characters")
    private String name;

    private String description;

    @Size(max = 10, message = "Emoji too long")
    private String emoji;

    private Boolean isPublic = false;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getEmoji() { return emoji; }
    public void setEmoji(String emoji) { this.emoji = emoji; }

    public Boolean getIsPublic() { return isPublic; }
    public void setIsPublic(Boolean isPublic) { this.isPublic = isPublic; }
}
