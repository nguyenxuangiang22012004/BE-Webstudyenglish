package com.example.app.controller;

import com.example.app.entity.User;
import com.example.app.repository.UserRepository;
import com.example.app.dto.DashboardResponseDTO;
import com.example.app.dto.UpdateGoalsRequestDTO;
import com.example.app.service.DashboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;
    private final UserRepository userRepository;

    public DashboardController(DashboardService dashboardService, UserRepository userRepository) {
        this.dashboardService = dashboardService;
        this.userRepository = userRepository;
    }

    private UUID getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
            throw new RuntimeException("Unauthorized");
        }
        
        String email = authentication.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return user.getId();
    }

    @GetMapping
    public ResponseEntity<DashboardResponseDTO> getDashboardData() {
        UUID userId = getUserId();
        return ResponseEntity.ok(dashboardService.getDashboardData(userId));
    }

    @PutMapping("/goals")
    public ResponseEntity<DashboardResponseDTO> updateStudyGoals(@RequestBody UpdateGoalsRequestDTO requestDTO) {
        UUID userId = getUserId();
        return ResponseEntity.ok(dashboardService.updateStudyGoals(userId, requestDTO));
    }
}
