package com.example.app.service;

import com.example.app.dto.request.AddMessageRequest;
import com.example.app.dto.request.CreateConversationRequest;
import com.example.app.dto.response.ConversationResponse;
import com.example.app.dto.response.MessageResponse;
import com.example.app.entity.Conversation;
import com.example.app.entity.ConversationMessage;
import com.example.app.entity.User;
import com.example.app.repository.ConversationMessageRepository;
import com.example.app.repository.ConversationRepository;
import com.example.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ConversationService {

    @Autowired
    private ConversationRepository conversationRepository;

    @Autowired
    private ConversationMessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public Page<ConversationResponse> getUserConversations(UUID userId, Pageable pageable) {
        return conversationRepository.findByUserIdOrderByCreatedAtDesc(userId, pageable)
                .map(this::mapToResponseWithoutMessages);
    }

    @Transactional(readOnly = true)
    public ConversationResponse getConversationDetails(UUID conversationId, UUID userId) {
        Conversation conversation = conversationRepository.findById(conversationId)
                .orElseThrow(() -> new RuntimeException("Conversation not found"));
        
        if (!conversation.getUser().getId().equals(userId)) {
            throw new RuntimeException("Access denied");
        }

        ConversationResponse response = mapToResponseWithoutMessages(conversation);
        List<ConversationMessage> messages = messageRepository.findByConversationIdOrderByCreatedAtAsc(conversationId);
        response.setMessages(messages.stream().map(this::mapToMessageResponse).collect(Collectors.toList()));
        return response;
    }

    @Transactional
    public ConversationResponse createConversation(UUID userId, CreateConversationRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Conversation conversation = new Conversation();
        conversation.setUser(user);
        conversation.setTopic(request.getTopic());
        conversation.setModelId(request.getModelId() != null ? request.getModelId() : "gemini-1.5-pro");
        conversation.setLevel(request.getLevel() != null ? request.getLevel() : "B1");
        conversation.setVocabularyJson(request.getVocabularyJson());
        
        conversation = conversationRepository.save(conversation);
        return mapToResponseWithoutMessages(conversation);
    }

    @Transactional
    public MessageResponse addMessage(UUID conversationId, UUID userId, AddMessageRequest request) {
        Conversation conversation = conversationRepository.findById(conversationId)
                .orElseThrow(() -> new RuntimeException("Conversation not found"));
                
        if (!conversation.getUser().getId().equals(userId)) {
            throw new RuntimeException("Access denied");
        }

        ConversationMessage message = new ConversationMessage();
        message.setConversation(conversation);
        message.setRole(request.getRole());
        message.setText(request.getText());
        
        message = messageRepository.save(message);
        return mapToMessageResponse(message);
    }

    private ConversationResponse mapToResponseWithoutMessages(Conversation conversation) {
        ConversationResponse response = new ConversationResponse();
        response.setId(conversation.getId());
        response.setTopic(conversation.getTopic());
        response.setModelId(conversation.getModelId());
        response.setLevel(conversation.getLevel());
        response.setVocabularyJson(conversation.getVocabularyJson());
        response.setCreatedAt(conversation.getCreatedAt());
        return response;
    }

    @Transactional
    public ConversationResponse updateVocabulary(UUID conversationId, UUID userId, String vocabularyJson) {
        Conversation conversation = conversationRepository.findById(conversationId)
                .orElseThrow(() -> new RuntimeException("Conversation not found"));
                
        if (!conversation.getUser().getId().equals(userId)) {
            throw new RuntimeException("Access denied");
        }

        conversation.setVocabularyJson(vocabularyJson);
        conversation = conversationRepository.save(conversation);
        return mapToResponseWithoutMessages(conversation);
    }

    @Transactional
    public MessageResponse updateMessageFeedback(UUID conversationId, UUID messageId, UUID userId, String feedback, String suggestedAnswer) {
        Conversation conversation = conversationRepository.findById(conversationId)
                .orElseThrow(() -> new RuntimeException("Conversation not found"));
                
        if (!conversation.getUser().getId().equals(userId)) {
            throw new RuntimeException("Access denied");
        }

        ConversationMessage message = messageRepository.findById(messageId)
                .orElseThrow(() -> new RuntimeException("Message not found"));

        if (!message.getConversation().getId().equals(conversationId)) {
            throw new RuntimeException("Message does not belong to conversation");
        }

        message.setFeedback(feedback);
        message.setSuggestedAnswer(suggestedAnswer);
        message = messageRepository.save(message);
        
        return mapToMessageResponse(message);
    }

    private MessageResponse mapToMessageResponse(ConversationMessage message) {
        MessageResponse response = new MessageResponse();
        response.setId(message.getId());
        response.setRole(message.getRole());
        response.setText(message.getText());
        response.setFeedback(message.getFeedback());
        response.setSuggestedAnswer(message.getSuggestedAnswer());
        response.setCreatedAt(message.getCreatedAt());
        return response;
    }
}
