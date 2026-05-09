package com.example.app.controller;

import com.example.app.dto.request.LoginRequest;
import com.example.app.dto.request.RefreshTokenRequest;
import com.example.app.dto.request.RegisterRequest;
import com.example.app.dto.response.ApiResponse;
import com.example.app.dto.response.TokenResponse;
import com.example.app.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<Object>> register(@Valid @RequestBody RegisterRequest request) {
        authService.register(request);
        ApiResponse<Object> response = new ApiResponse<>(true, "User registered successfully", null);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<TokenResponse>> login(@Valid @RequestBody LoginRequest request) {
        TokenResponse tokenResponse = authService.login(request);
        ApiResponse<TokenResponse> response = new ApiResponse<>(true, "Login successful", tokenResponse);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/refresh")
    public ResponseEntity<ApiResponse<TokenResponse>> refreshToken(@Valid @RequestBody RefreshTokenRequest request) {
        TokenResponse tokenResponse = authService.refreshToken(request);
        ApiResponse<TokenResponse> response = new ApiResponse<>(true, "Token refreshed successfully", tokenResponse);
        return ResponseEntity.ok(response);
    }
}
