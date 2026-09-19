package com.example.app.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateTopicRequest {

    @NotBlank(message = "Tên chủ đề không được để trống")
    @Size(max = 255, message = "Tên chủ đề không được quá 255 ký tự")
    private String name;

    @Size(max = 100, message = "Slug không được quá 100 ký tự")
    private String slug;

    private String description;

    private Integer orderIndex = 0;

    @Size(max = 500, message = "Đường dẫn ảnh mascot không được quá 500 ký tự")
    private String mascotImageUrl;

    private String introMessage;

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getMascotImageUrl() {
        return mascotImageUrl;
    }

    public void setMascotImageUrl(String mascotImageUrl) {
        this.mascotImageUrl = mascotImageUrl;
    }

    public String getIntroMessage() {
        return introMessage;
    }

    public void setIntroMessage(String introMessage) {
        this.introMessage = introMessage;
    }
}
