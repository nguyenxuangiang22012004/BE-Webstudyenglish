package com.example.app.dto.request;

public class AddMessageRequest {
    private String role;
    private String text;

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
}
