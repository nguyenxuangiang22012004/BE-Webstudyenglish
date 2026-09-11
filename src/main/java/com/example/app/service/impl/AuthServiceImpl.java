package com.example.app.service.impl;

import com.example.app.dto.request.GoogleTokenRequest;
import com.example.app.dto.request.LoginRequest;
import com.example.app.dto.request.RefreshTokenRequest;
import com.example.app.dto.response.TokenResponse;
import com.example.app.dto.request.RegisterRequest;
import com.example.app.entity.User;
import com.example.app.repository.UserRepository;
import com.example.app.security.CustomUserDetailsService;
import com.example.app.security.jwt.JwtUtil;
import com.example.app.service.AuthService;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${google.client.id}")
    private String googleClientId;

    public AuthServiceImpl(AuthenticationManager authenticationManager, 
                           CustomUserDetailsService userDetailsService, 
                           JwtUtil jwtUtil,
                           UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(RegisterRequest request) {
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            throw new IllegalArgumentException("Passwords do not match");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        
        userRepository.save(user);
    }

    @Override
    public TokenResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());

        final String accessToken = jwtUtil.generateAccessToken(userDetails);
        final String refreshToken = jwtUtil.generateRefreshToken(userDetails);

        return new TokenResponse(accessToken, refreshToken);
    }

    @Override
    public TokenResponse refreshToken(RefreshTokenRequest request) {
        String token = request.getRefreshToken();
        
        try {
            String username = jwtUtil.extractUsername(token);
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            if (jwtUtil.validateToken(token, userDetails)) {
                String newAccessToken = jwtUtil.generateAccessToken(userDetails);
                return new TokenResponse(newAccessToken, token);
            } else {
                throw new BadCredentialsException("Invalid refresh token");
            }
        } catch (Exception e) {
            throw new BadCredentialsException("Invalid or expired refresh token");
        }
    }

    @Override
    public TokenResponse loginWithGoogle(GoogleTokenRequest request) {
        try {
            // 1. Xác thực Google ID Token với Google servers
            GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(
                    new NetHttpTransport(), GsonFactory.getDefaultInstance())
                    .setAudience(Collections.singletonList(googleClientId))
                    .build();

            GoogleIdToken idToken = verifier.verify(request.getIdToken());
            if (idToken == null) {
                throw new BadCredentialsException("Invalid Google ID token");
            }

            // 2. Lấy thông tin user từ Google payload
            GoogleIdToken.Payload payload = idToken.getPayload();
            String email = payload.getEmail();
            String name = (String) payload.get("name");
            String pictureUrl = (String) payload.get("picture");
            String googleSub = payload.getSubject(); // Google UID

            if (name == null || name.isBlank()) {
                name = email.split("@")[0];
            }

            // 3. Tìm user theo email hoặc tạo mới
            Optional<User> existingUser = userRepository.findByEmail(email);
            User user;

            if (existingUser.isPresent()) {
                // User đã tồn tại → cập nhật thông tin Google nếu cần
                user = existingUser.get();
                if (user.getAvatarUrl() == null && pictureUrl != null) {
                    user.setAvatarUrl(pictureUrl);
                }
                // Liên kết với Google nếu chưa có provider_id
                if (user.getProviderId() == null) {
                    user.setProviderId(googleSub);
                }
                userRepository.save(user);
            } else {
                // Tạo user mới từ Google
                user = new User(email, name, "GOOGLE", googleSub);
                user.setAvatarUrl(pictureUrl);
                userRepository.save(user);
            }

            // 4. Tạo JWT nội bộ
            UserDetails userDetails = userDetailsService.loadUserByUsername(email);
            String accessToken = jwtUtil.generateAccessToken(userDetails);
            String refreshToken = jwtUtil.generateRefreshToken(userDetails);

            return new TokenResponse(accessToken, refreshToken);

        } catch (BadCredentialsException e) {
            throw e;
        } catch (Exception e) {
            throw new BadCredentialsException("Google authentication failed: " + e.getMessage());
        }
    }
}
