package com.example.app.service;

import com.example.app.dto.request.LoginRequest;
import com.example.app.dto.request.RefreshTokenRequest;
import com.example.app.dto.response.TokenResponse;

import com.example.app.dto.request.RegisterRequest;

public interface AuthService {
    void register(RegisterRequest request);
    TokenResponse login(LoginRequest request);
    TokenResponse refreshToken(RefreshTokenRequest request);
}
