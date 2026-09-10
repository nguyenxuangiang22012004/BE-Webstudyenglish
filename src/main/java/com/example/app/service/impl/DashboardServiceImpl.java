package com.example.app.service.impl;

import com.example.app.dto.DashboardResponseDTO;
import com.example.app.dto.UpdateGoalsRequestDTO;
import com.example.app.entity.DailyStudyStats;
import com.example.app.entity.User;
import com.example.app.entity.UserFlashcardProgress;
import com.example.app.repository.DailyStudyStatsRepository;
import com.example.app.repository.StudyGroupMemberRepository;
import com.example.app.repository.UserFlashcardProgressRepository;
import com.example.app.repository.UserRepository;
import com.example.app.service.DashboardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final UserRepository userRepository;
    private final UserFlashcardProgressRepository progressRepository;
    private final StudyGroupMemberRepository groupMemberRepository;
    private final DailyStudyStatsRepository dailyStudyStatsRepository;

    public DashboardServiceImpl(
            UserRepository userRepository,
            UserFlashcardProgressRepository progressRepository,
            StudyGroupMemberRepository groupMemberRepository,
            DailyStudyStatsRepository dailyStudyStatsRepository) {
        this.userRepository = userRepository;
        this.progressRepository = progressRepository;
        this.groupMemberRepository = groupMemberRepository;
        this.dailyStudyStatsRepository = dailyStudyStatsRepository;
    }

    @Override
    public DashboardResponseDTO getDashboardData(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // ── Đếm flashcard theo status ──────────────────────────────────────
        int totalWords    = progressRepository.countByUser(user);
        int masteredWords = progressRepository.countByUserAndStatus(user, UserFlashcardProgress.FlashcardStatus.MASTERED);
        int learningWords = progressRepository.countByUserAndStatus(user, UserFlashcardProgress.FlashcardStatus.LEARNING);
        int unknownWords  = progressRepository.countByUserAndStatus(user, UserFlashcardProgress.FlashcardStatus.UNKNOWN);

        // ── Đếm số nhóm học ────────────────────────────────────────────────
        int studyGroups = groupMemberRepository.countByUser(user);

        // ── 1. Stats ───────────────────────────────────────────────────────
        DashboardResponseDTO response = new DashboardResponseDTO();

        DashboardResponseDTO.StatsDTO stats = new DashboardResponseDTO.StatsDTO();
        stats.setTotalWords(totalWords);
        stats.setMasteredWords(masteredWords);
        stats.setConsecutiveDays(user.getCurrentStreak());
        stats.setStudyGroups(studyGroups);
        response.setStats(stats);

        // ── 2. ProgressChart ───────────────────────────────────────────────
        DashboardResponseDTO.ProgressChartDTO progressChart = new DashboardResponseDTO.ProgressChartDTO();
        progressChart.setTotalWords(totalWords);
        progressChart.setMastered(masteredWords);
        progressChart.setLearning(learningWords);
        progressChart.setUnknown(unknownWords);

        // WeekStats: lấy 7 ngày gần nhất từ daily_study_stats
        LocalDate today = LocalDate.now();
        LocalDate weekAgo = today.minusDays(6);
        DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("EEEE");

        List<DailyStudyStats> weekData = dailyStudyStatsRepository
                .findByUserAndStudyDateBetweenOrderByStudyDateAsc(user, weekAgo, today);

        Map<LocalDate, Integer> dayCountMap = weekData.stream()
                .collect(Collectors.toMap(
                        DailyStudyStats::getStudyDate,
                        DailyStudyStats::getWordsLearnedCount,
                        Integer::sum
                ));

        List<DashboardResponseDTO.DailyStatDTO> weekStats = new ArrayList<>();
        for (int i = 6; i >= 0; i--) {
            LocalDate date = today.minusDays(i);
            int count = dayCountMap.getOrDefault(date, 0);
            weekStats.add(new DashboardResponseDTO.DailyStatDTO(date.format(dayFormatter), count));
        }
        progressChart.setWeekStats(weekStats);
        response.setProgressChart(progressChart);

        // ── 3. Achievements ────────────────────────────────────────────────
        DashboardResponseDTO.AchievementsDTO achievements = new DashboardResponseDTO.AchievementsDTO();
        achievements.setConsecutiveDays(user.getCurrentStreak());

        // Tổng số từ đã học tích lũy qua daily_study_stats
        int totalWordsLearned = dailyStudyStatsRepository
                .findByUserOrderByStudyDateDesc(user)
                .stream()
                .mapToInt(DailyStudyStats::getWordsLearnedCount)
                .sum();
        achievements.setTotalWordsLearned(totalWordsLearned);

        // Độ chính xác = % từ đã thuộc / tổng từ đã học
        int accuracy = (totalWords > 0) ? (masteredWords * 100 / totalWords) : 0;
        achievements.setQuickSearchAccuracy(accuracy);
        response.setAchievements(achievements);

        // ── 4. StudyGoals ──────────────────────────────────────────────────
        DashboardResponseDTO.StudyGoalsDTO goals = new DashboardResponseDTO.StudyGoalsDTO();
        goals.setDailyWordsGoal(user.getDailyWordsGoal());
        goals.setTotalWordsGoal(user.getTotalWordsGoal());
        goals.setStreakGoal(user.getStreakGoal());
        goals.setCurrentStreak(user.getCurrentStreak());
        goals.setTotalWordsLearned(masteredWords);

        // Từ học được hôm nay
        Optional<DailyStudyStats> todayStats = dailyStudyStatsRepository
                .findByUserAndStudyDate(user, today);
        goals.setDailyWordsLearned(todayStats.map(DailyStudyStats::getWordsLearnedCount).orElse(0));

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

