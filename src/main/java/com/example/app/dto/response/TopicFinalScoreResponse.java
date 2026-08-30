package com.example.app.dto.response;

import java.util.UUID;

public class TopicFinalScoreResponse {

    private UUID topicId;
    private Integer finalScore;        // null nếu không có lesson nào có điểm
    private long scoredLessonsCount;   // số lesson đã được tính điểm
    private long totalLessonsCount;    // tổng số lesson trong topic

    public TopicFinalScoreResponse() {}

    public TopicFinalScoreResponse(UUID topicId, Integer finalScore, long scoredLessonsCount, long totalLessonsCount) {
        this.topicId = topicId;
        this.finalScore = finalScore;
        this.scoredLessonsCount = scoredLessonsCount;
        this.totalLessonsCount = totalLessonsCount;
    }

    public UUID getTopicId() {
        return topicId;
    }

    public void setTopicId(UUID topicId) {
        this.topicId = topicId;
    }

    public Integer getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Integer finalScore) {
        this.finalScore = finalScore;
    }

    public long getScoredLessonsCount() {
        return scoredLessonsCount;
    }

    public void setScoredLessonsCount(long scoredLessonsCount) {
        this.scoredLessonsCount = scoredLessonsCount;
    }

    public long getTotalLessonsCount() {
        return totalLessonsCount;
    }

    public void setTotalLessonsCount(long totalLessonsCount) {
        this.totalLessonsCount = totalLessonsCount;
    }
}
