package com.example.app.service.impl;

import com.example.app.dto.DashboardResponseDTO;
import com.example.app.dto.UpdateGoalsRequestDTO;
import com.example.app.entity.User;
import com.example.app.repository.UserRepository;
import com.example.app.service.DashboardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final UserRepository userRepository;

    public DashboardServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public DashboardResponseDTO getDashboardData(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        DashboardResponseDTO response = new DashboardResponseDTO();

        // 1. Mock Stats (In real app, query from UserFlashcardProgressRepository & StudyGroupMemberRepository)
        DashboardResponseDTO.StatsDTO stats = new DashboardResponseDTO.StatsDTO();
        stats.setTotalWords(user.getTotalWordsGoal() > 0 ? 245 : 0); // Mock data
        stats.setMasteredWords(156);
        stats.setConsecutiveDays(user.getCurrentStreak());
        stats.setStudyGroups(5);
        response.setStats(stats);

        // 2. Mock Progress Chart
        DashboardResponseDTO.ProgressChartDTO progressChart = new DashboardResponseDTO.ProgressChartDTO();
        progressChart.setTotalWords(245);
        progressChart.setMastered(156);
        progressChart.setLearning(62);
        progressChart.setUnknown(27);
        
        List<DashboardResponseDTO.DailyStatDTO> weekStats = new ArrayList<>();
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE");
        for (int i = 6; i >= 0; i--) {
            weekStats.add(new DashboardResponseDTO.DailyStatDTO(
                today.minusDays(i).format(formatter), 
                20 + (int)(Math.random() * 15) // random mock
            ));
        }
        progressChart.setWeekStats(weekStats);
        response.setProgressChart(progressChart);

        // 3. Mock Achievements
        DashboardResponseDTO.AchievementsDTO achievements = new DashboardResponseDTO.AchievementsDTO();
        achievements.setConsecutiveDays(user.getCurrentStreak());
        achievements.setTotalWordsLearned(500);
        achievements.setQuickSearchAccuracy(64);
        response.setAchievements(achievements);

        // 4. Study Goals from User Entity
        DashboardResponseDTO.StudyGoalsDTO goals = new DashboardResponseDTO.StudyGoalsDTO();
        goals.setDailyWordsGoal(user.getDailyWordsGoal());
        goals.setDailyWordsLearned(8); // Mock actual learned today
        goals.setTotalWordsGoal(user.getTotalWordsGoal());
        goals.setTotalWordsLearned(156);
        goals.setStreakGoal(user.getStreakGoal());
        goals.setCurrentStreak(user.getCurrentStreak());
        response.setStudyGoals(goals);

        return response;
    }

    @Override
    @Transactional
    public DashboardResponseDTO updateStudyGoals(UUID userId, UpdateGoalsRequestDTO requestDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (requestDTO.getDailyWordsGoal() != null) {
            user.setDailyWordsGoal(requestDTO.getDailyWordsGoal());
        }
        if (requestDTO.getTotalWordsGoal() != null) {
            user.setTotalWordsGoal(requestDTO.getTotalWordsGoal());
        }
        if (requestDTO.getStreakGoal() != null) {
            user.setStreakGoal(requestDTO.getStreakGoal());
        }

        userRepository.save(user);

        return getDashboardData(userId);
    }
}
