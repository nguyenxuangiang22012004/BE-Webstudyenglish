package com.example.app.dto.response;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class AiWritingAnalyticsResponse {
    private int totalEssays;
    private double averageScore;
    private int totalWords;
    private Map<String, Double> criteriaAverages;
    private List<TopMistakeDto> topMistakes;
    private List<ScoreHistoryItemDto> recentScores;

    public AiWritingAnalyticsResponse() {
    }

    public static class TopMistakeDto {
        private String errorType;
        private int count;
        private String advice;
        private List<String> sampleCorrections;

        public TopMistakeDto() {
        }

        public TopMistakeDto(String errorType, int count, String advice, List<String> sampleCorrections) {
            this.errorType = errorType;
            this.count = count;
            this.advice = advice;
            this.sampleCorrections = sampleCorrections;
        }

        public String getErrorType() {
            return errorType;
        }

        public void setErrorType(String errorType) {
            this.errorType = errorType;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getAdvice() {
            return advice;
        }

        public void setAdvice(String advice) {
            this.advice = advice;
        }

        public List<String> getSampleCorrections() {
            return sampleCorrections;
        }

        public void setSampleCorrections(List<String> sampleCorrections) {
            this.sampleCorrections = sampleCorrections;
        }
    }

    public static class ScoreHistoryItemDto {
        private UUID id;
        private String topic;
        private Double score;
        private Integer wordCount;
        private ZonedDateTime createdAt;

        public ScoreHistoryItemDto() {
        }

        public ScoreHistoryItemDto(UUID id, String topic, Double score, Integer wordCount, ZonedDateTime createdAt) {
            this.id = id;
            this.topic = topic;
            this.score = score;
            this.wordCount = wordCount;
            this.createdAt = createdAt;
        }

        public UUID getId() {
            return id;
        }

        public void setId(UUID id) {
            this.id = id;
        }

        public String getTopic() {
            return topic;
        }

        public void setTopic(String topic) {
            this.topic = topic;
        }

        public Double getScore() {
            return score;
        }

        public void setScore(Double score) {
            this.score = score;
        }

        public Integer getWordCount() {
            return wordCount;
        }

        public void setWordCount(Integer wordCount) {
            this.wordCount = wordCount;
        }

        public ZonedDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(ZonedDateTime createdAt) {
            this.createdAt = createdAt;
        }
    }

    public int getTotalEssays() {
        return totalEssays;
    }

    public void setTotalEssays(int totalEssays) {
        this.totalEssays = totalEssays;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public int getTotalWords() {
        return totalWords;
    }

    public void setTotalWords(int totalWords) {
        this.totalWords = totalWords;
    }

    public Map<String, Double> getCriteriaAverages() {
        return criteriaAverages;
    }

    public void setCriteriaAverages(Map<String, Double> criteriaAverages) {
        this.criteriaAverages = criteriaAverages;
    }

    public List<TopMistakeDto> getTopMistakes() {
        return topMistakes;
    }

    public void setTopMistakes(List<TopMistakeDto> topMistakes) {
        this.topMistakes = topMistakes;
    }

    public List<ScoreHistoryItemDto> getRecentScores() {
        return recentScores;
    }

    public void setRecentScores(List<ScoreHistoryItemDto> recentScores) {
        this.recentScores = recentScores;
    }
}
