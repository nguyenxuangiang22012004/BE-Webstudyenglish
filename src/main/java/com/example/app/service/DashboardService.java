package com.example.app.service;

import com.example.app.dto.DashboardResponseDTO;
import com.example.app.dto.UpdateGoalsRequestDTO;
import java.util.UUID;

public interface DashboardService {
    DashboardResponseDTO getDashboardData(UUID userId);
    DashboardResponseDTO updateStudyGoals(UUID userId, UpdateGoalsRequestDTO requestDTO);
}
