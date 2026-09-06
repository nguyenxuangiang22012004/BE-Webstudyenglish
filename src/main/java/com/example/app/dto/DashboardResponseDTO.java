package com.example.app.dto;

import java.util.List;

public class DashboardResponseDTO {
    private StatsDTO stats;
    private ProgressChartDTO progressChart;
    private AchievementsDTO achievements;
    private StudyGoalsDTO studyGoals;

    // Getters and Setters
    public StatsDTO getStats() { return stats; }
    public void setStats(StatsDTO stats) { this.stats = stats; }

    public ProgressChartDTO getProgressChart() { return progressChart; }
    public void setProgressChart(ProgressChartDTO progressChart) { this.progressChart = progressChart; }

    public AchievementsDTO getAchievements() { return achievements; }
    public void setAchievements(AchievementsDTO achievements) { this.achievements = achievements; }

    public StudyGoalsDTO getStudyGoals() { return studyGoals; }
    public void setStudyGoals(StudyGoalsDTO studyGoals) { this.studyGoals = studyGoals; }

    public static class StatsDTO {
        private int totalWords;
        private int masteredWords;
        private int consecutiveDays;
        private int studyGroups;

        // Getters and Setters
        public int getTotalWords() { return totalWords; }
        public void setTotalWords(int totalWords) { this.totalWords = totalWords; }

        public int getMasteredWords() { return masteredWords; }
        public void setMasteredWords(int masteredWords) { this.masteredWords = masteredWords; }

        public int getConsecutiveDays() { return consecutiveDays; }
        public void setConsecutiveDays(int consecutiveDays) { this.consecutiveDays = consecutiveDays; }

        public int getStudyGroups() { return studyGroups; }
        public void setStudyGroups(int studyGroups) { this.studyGroups = studyGroups; }
    }

    public static class ProgressChartDTO {
        private int totalWords;
        private int mastered;
        private int learning;
        private int unknown;
        private List<DailyStatDTO> weekStats;

        // Getters and Setters
        public int getTotalWords() { return totalWords; }
        public void setTotalWords(int totalWords) { this.totalWords = totalWords; }

        public int getMastered() { return mastered; }
        public void setMastered(int mastered) { this.mastered = mastered; }

        public int getLearning() { return learning; }
        public void setLearning(int learning) { this.learning = learning; }

        public int getUnknown() { return unknown; }
        public void setUnknown(int unknown) { this.unknown = unknown; }

        public List<DailyStatDTO> getWeekStats() { return weekStats; }
        public void setWeekStats(List<DailyStatDTO> weekStats) { this.weekStats = weekStats; }
    }

    public static class DailyStatDTO {
        private String day;
        private int count;

        public DailyStatDTO(String day, int count) {
            this.day = day;
            this.count = count;
        }

        public String getDay() { return day; }
        public void setDay(String day) { this.day = day; }

        public int getCount() { return count; }
        public void setCount(int count) { this.count = count; }
    }

    public static class AchievementsDTO {
        private int consecutiveDays;
        private int totalWordsLearned;
        private int quickSearchAccuracy;

        // Getters and Setters
        public int getConsecutiveDays() { return consecutiveDays; }
        public void setConsecutiveDays(int consecutiveDays) { this.consecutiveDays = consecutiveDays; }

        public int getTotalWordsLearned() { return totalWordsLearned; }
        public void setTotalWordsLearned(int totalWordsLearned) { this.totalWordsLearned = totalWordsLearned; }

        public int getQuickSearchAccuracy() { return quickSearchAccuracy; }
        public void setQuickSearchAccuracy(int quickSearchAccuracy) { this.quickSearchAccuracy = quickSearchAccuracy; }
    }

    public static class StudyGoalsDTO {
        private int dailyWordsGoal;
        private int dailyWordsLearned;
        private int totalWordsGoal;
        private int totalWordsLearned;
        private int streakGoal;
        private int currentStreak;

        // Getters and Setters
        public int getDailyWordsGoal() { return dailyWordsGoal; }
        public void setDailyWordsGoal(int dailyWordsGoal) { this.dailyWordsGoal = dailyWordsGoal; }

        public int getDailyWordsLearned() { return dailyWordsLearned; }
        public void setDailyWordsLearned(int dailyWordsLearned) { this.dailyWordsLearned = dailyWordsLearned; }

        public int getTotalWordsGoal() { return totalWordsGoal; }
        public void setTotalWordsGoal(int totalWordsGoal) { this.totalWordsGoal = totalWordsGoal; }

        public int getTotalWordsLearned() { return totalWordsLearned; }
        public void setTotalWordsLearned(int totalWordsLearned) { this.totalWordsLearned = totalWordsLearned; }

        public int getStreakGoal() { return streakGoal; }
        public void setStreakGoal(int streakGoal) { this.streakGoal = streakGoal; }

        public int getCurrentStreak() { return currentStreak; }
        public void setCurrentStreak(int currentStreak) { this.currentStreak = currentStreak; }
    }
}
