package com.example.app.service;

import com.example.app.dto.request.SaveAiWritingHistoryRequest;
import com.example.app.dto.response.AiWritingHistoryResponse;
import com.example.app.entity.AiWritingHistory;
import com.example.app.entity.User;
import com.example.app.repository.AiWritingHistoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class AiWritingHistoryService {

    private final AiWritingHistoryRepository aiWritingHistoryRepository;

    public AiWritingHistoryService(AiWritingHistoryRepository aiWritingHistoryRepository) {
        this.aiWritingHistoryRepository = aiWritingHistoryRepository;
    }

    @Transactional
    public AiWritingHistoryResponse saveHistory(User user, SaveAiWritingHistoryRequest request) {
        AiWritingHistory history = new AiWritingHistory();
        history.setUser(user);
        history.setTopic(request.getTopic());
        history.setLevel(request.getLevel());
        history.setWritingType(request.getWritingType());
        history.setPromptText(request.getPromptText());
        history.setEssayContent(request.getEssayContent());
        history.setOutlineData(request.getOutlineData());
        history.setFeedbackData(request.getFeedbackData());
        history.setScore(request.getScore());
        history.setWordCount(request.getWordCount());

        AiWritingHistory saved = aiWritingHistoryRepository.save(history);
        return mapToResponse(saved);
    }

    @Transactional(readOnly = true)
    public Page<AiWritingHistoryResponse> getHistory(User user, Pageable pageable) {
        return aiWritingHistoryRepository.findByUserIdOrderByCreatedAtDesc(user.getId(), pageable)
                .map(this::mapToResponse);
    }

    @Transactional(readOnly = true)
    public AiWritingHistoryResponse getHistoryById(User user, UUID id) {
        AiWritingHistory history = aiWritingHistoryRepository.findByIdAndUserId(id, user.getId())
                .orElseThrow(() -> new RuntimeException("Writing history not found"));
        return mapToResponse(history);
    }

    @Transactional(readOnly = true)
    public com.example.app.dto.response.AiWritingAnalyticsResponse getWritingAnalytics(User user) {
        java.util.List<AiWritingHistory> histories = aiWritingHistoryRepository.findByUserIdOrderByCreatedAtAsc(user.getId());
        
        com.example.app.dto.response.AiWritingAnalyticsResponse response = new com.example.app.dto.response.AiWritingAnalyticsResponse();
        int totalEssays = histories.size();
        response.setTotalEssays(totalEssays);

        if (totalEssays == 0) {
            response.setAverageScore(0.0);
            response.setTotalWords(0);
            response.setCriteriaAverages(java.util.Map.of("grammar", 0.0, "vocabulary", 0.0, "coherence", 0.0, "taskResponse", 0.0));
            response.setTopMistakes(java.util.Collections.emptyList());
            response.setRecentScores(java.util.Collections.emptyList());
            return response;
        }

        int totalWords = 0;
        double sumScore = 0.0;
        int scoredCount = 0;

        double sumGrammar = 0, sumVocab = 0, sumCoherence = 0, sumTask = 0;
        int countGrammar = 0, countVocab = 0, countCoherence = 0, countTask = 0;

        java.util.Map<String, Integer> mistakeCounts = new java.util.HashMap<>();
        java.util.Map<String, java.util.List<String>> mistakeSamples = new java.util.HashMap<>();

        java.util.List<com.example.app.dto.response.AiWritingAnalyticsResponse.ScoreHistoryItemDto> recentScores = new java.util.ArrayList<>();

        for (AiWritingHistory h : histories) {
            if (h.getWordCount() != null) {
                totalWords += h.getWordCount();
            }
            if (h.getScore() != null) {
                sumScore += h.getScore();
                scoredCount++;
            }

            recentScores.add(new com.example.app.dto.response.AiWritingAnalyticsResponse.ScoreHistoryItemDto(
                    h.getId(), h.getTopic(), h.getScore(), h.getWordCount(), h.getCreatedAt()
            ));

            // Parse feedbackData for mistakes and criteria scores
            com.fasterxml.jackson.databind.JsonNode fb = h.getFeedbackData();
            if (fb != null && fb.isObject()) {
                // Criteria scores
                com.fasterxml.jackson.databind.JsonNode criteriaNode = fb.get("criteriaScores");
                if (criteriaNode != null && criteriaNode.isObject()) {
                    if (criteriaNode.has("grammar") && criteriaNode.get("grammar").has("score")) {
                        sumGrammar += criteriaNode.get("grammar").get("score").asDouble();
                        countGrammar++;
                    }
                    if (criteriaNode.has("vocabulary") && criteriaNode.get("vocabulary").has("score")) {
                        sumVocab += criteriaNode.get("vocabulary").get("score").asDouble();
                        countVocab++;
                    }
                    if (criteriaNode.has("coherence") && criteriaNode.get("coherence").has("score")) {
                        sumCoherence += criteriaNode.get("coherence").get("score").asDouble();
                        countCoherence++;
                    }
                    if (criteriaNode.has("taskResponse") && criteriaNode.get("taskResponse").has("score")) {
                        sumTask += criteriaNode.get("taskResponse").get("score").asDouble();
                        countTask++;
                    }
                }

                // Grammar errors
                com.fasterxml.jackson.databind.JsonNode gErrors = fb.get("grammarErrors");
                if (gErrors != null && gErrors.isArray()) {
                    for (com.fasterxml.jackson.databind.JsonNode item : gErrors) {
                        String type = item.has("errorType") ? item.get("errorType").asText("Lỗi ngữ pháp") : "Lỗi ngữ pháp";
                        type = cleanErrorType(type);
                        mistakeCounts.put(type, mistakeCounts.getOrDefault(type, 0) + 1);

                        if (item.has("correctedSentence")) {
                            mistakeSamples.computeIfAbsent(type, k -> new java.util.ArrayList<>()).add(item.get("correctedSentence").asText());
                        }
                    }
                }

                // Spelling errors
                com.fasterxml.jackson.databind.JsonNode sErrors = fb.get("spellingErrors");
                if (sErrors != null && sErrors.isArray() && sErrors.size() > 0) {
                    String type = "Chính tả (Spelling)";
                    mistakeCounts.put(type, mistakeCounts.getOrDefault(type, 0) + sErrors.size());
                    for (com.fasterxml.jackson.databind.JsonNode item : sErrors) {
                        if (item.has("correction")) {
                            mistakeSamples.computeIfAbsent(type, k -> new java.util.ArrayList<>()).add(item.get("correction").asText());
                        }
                    }
                }
            }
        }

        response.setTotalWords(totalWords);
        response.setAverageScore(scoredCount > 0 ? Math.round((sumScore / scoredCount) * 10.0) / 10.0 : 0.0);

        java.util.Map<String, Double> criteriaMap = new java.util.HashMap<>();
        criteriaMap.put("grammar", countGrammar > 0 ? Math.round((sumGrammar / countGrammar) * 10.0) / 10.0 : (scoredCount > 0 ? response.getAverageScore() : 0.0));
        criteriaMap.put("vocabulary", countVocab > 0 ? Math.round((sumVocab / countVocab) * 10.0) / 10.0 : (scoredCount > 0 ? response.getAverageScore() : 0.0));
        criteriaMap.put("coherence", countCoherence > 0 ? Math.round((sumCoherence / countCoherence) * 10.0) / 10.0 : (scoredCount > 0 ? response.getAverageScore() : 0.0));
        criteriaMap.put("taskResponse", countTask > 0 ? Math.round((sumTask / countTask) * 10.0) / 10.0 : (scoredCount > 0 ? response.getAverageScore() : 0.0));
        response.setCriteriaAverages(criteriaMap);

        // Sort mistakes descending
        java.util.List<com.example.app.dto.response.AiWritingAnalyticsResponse.TopMistakeDto> topMistakesList = mistakeCounts.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(6)
                .map(e -> {
                    String key = e.getKey();
                    int count = e.getValue();
                    String advice = getAdviceForErrorType(key);
                    java.util.List<String> samples = mistakeSamples.getOrDefault(key, java.util.Collections.emptyList());
                    if (samples.size() > 3) samples = samples.subList(0, 3);
                    return new com.example.app.dto.response.AiWritingAnalyticsResponse.TopMistakeDto(key, count, advice, samples);
                })
                .collect(java.util.stream.Collectors.toList());

        response.setTopMistakes(topMistakesList);
        response.setRecentScores(recentScores);

        return response;
    }

    private String cleanErrorType(String raw) {
        String lower = raw.toLowerCase();
        if (lower.contains("article") || lower.contains("mạo từ") || lower.contains("a/an") || lower.contains("the")) {
            return "Mạo từ (Articles a/an/the)";
        }
        if (lower.contains("tense") || lower.contains("thì") || lower.contains("past") || lower.contains("present")) {
            return "Sử dụng thì (Verb Tenses)";
        }
        if (lower.contains("subject") || lower.contains("verb agreement") || lower.contains("hòa hợp")) {
            return "Hòa hợp chủ - vị (Subject-Verb Agreement)";
        }
        if (lower.contains("preposition") || lower.contains("giới từ") || lower.contains("in/on/at")) {
            return "Giới từ (Prepositions)";
        }
        if (lower.contains("plural") || lower.contains("singular") || lower.contains("số ít") || lower.contains("số nhiều")) {
            return "Danh từ số ít / số nhiều (Noun Forms)";
        }
        if (lower.contains("punctuation") || lower.contains("dấu câu") || lower.contains("comma")) {
            return "Dấu câu & Dạng câu (Punctuation)";
        }
        if (lower.contains("word choice") || lower.contains("collocation") || lower.contains("từ ngữ")) {
            return "Cách dùng từ & Collocation (Word Choice)";
        }
        return raw;
    }

    private String getAdviceForErrorType(String errorType) {
        if (errorType.contains("Mạo từ")) {
            return "Hãy chú ý kiểm tra danh từ đếm được số ít (cần có 'a/an') và danh từ đã xác định (dùng 'the').";
        }
        if (errorType.contains("Sử dụng thì")) {
            return "Luôn giữ sự nhất quán về thì trong toàn đoạn văn và chú ý các trạng từ chỉ thời gian (yesterday, since, currently).";
        }
        if (errorType.contains("Hòa hợp")) {
            return "Xác định rõ chủ ngữ chính của câu để chia động từ số ít (thêm s/es ở hiện tại) hoặc số nhiều tương ứng.";
        }
        if (errorType.contains("Giới từ")) {
            return "Học giới từ theo cụm cố định (dependent prepositions) như 'depend on', 'interested in', 'good at'.";
        }
        if (errorType.contains("Chính tả")) {
            return "Đọc lại bài viết một lượt trước khi nộp để phát hiện các lỗi gõ phím nhầm hoặc sai phụ âm đôi.";
        }
        return "Xem lại cấu trúc ngữ pháp và luyện tập viết lại các câu tương tự để ghi nhớ lâu hơn.";
    }

    @Transactional
    public void deleteHistory(User user, UUID id) {
        aiWritingHistoryRepository.deleteByIdAndUserId(id, user.getId());
    }

    private AiWritingHistoryResponse mapToResponse(AiWritingHistory history) {
        AiWritingHistoryResponse response = new AiWritingHistoryResponse();
        response.setId(history.getId());
        response.setTopic(history.getTopic());
        response.setLevel(history.getLevel());
        response.setWritingType(history.getWritingType());
        response.setPromptText(history.getPromptText());
        response.setEssayContent(history.getEssayContent());
        response.setOutlineData(history.getOutlineData());
        response.setFeedbackData(history.getFeedbackData());
        response.setScore(history.getScore());
        response.setWordCount(history.getWordCount());
        response.setCreatedAt(history.getCreatedAt());
        return response;
    }
}
