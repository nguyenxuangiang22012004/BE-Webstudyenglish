package com.example.app.dto.request;

public class SaveAiListeningHistoryRequest {
    private String topic;
    private String level;
    private Object lessonData;
    private Object userAnswersData;
    private Integer score;

    public SaveAiListeningHistoryRequest() {
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Object getLessonData() {
        return lessonData;
    }

    public void setLessonData(Object lessonData) {
        this.lessonData = lessonData;
    }

    public Object getUserAnswersData() {
        return userAnswersData;
    }

    public void setUserAnswersData(Object userAnswersData) {
        this.userAnswersData = userAnswersData;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
