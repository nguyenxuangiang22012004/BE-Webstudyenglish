package com.example.app.dto;

public class UpdateGoalsRequestDTO {
    private Integer dailyWordsGoal;
    private Integer totalWordsGoal;
    private Integer streakGoal;

    public Integer getDailyWordsGoal() {
        return dailyWordsGoal;
    }

    public void setDailyWordsGoal(Integer dailyWordsGoal) {
        this.dailyWordsGoal = dailyWordsGoal;
    }

    public Integer getTotalWordsGoal() {
        return totalWordsGoal;
    }

    public void setTotalWordsGoal(Integer totalWordsGoal) {
        this.totalWordsGoal = totalWordsGoal;
    }

    public Integer getStreakGoal() {
        return streakGoal;
    }

    public void setStreakGoal(Integer streakGoal) {
        this.streakGoal = streakGoal;
    }
}
