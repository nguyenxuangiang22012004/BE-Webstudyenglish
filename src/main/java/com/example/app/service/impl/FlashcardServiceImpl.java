package com.example.app.service.impl;

import com.example.app.dto.request.CreateFlashcardRequest;
import com.example.app.dto.request.CreateSetRequest;
import com.example.app.dto.response.FlashcardResponse;
import com.example.app.dto.response.FlashcardSetResponse;
import com.example.app.entity.Flashcard;
import com.example.app.entity.FlashcardSet;
import com.example.app.entity.User;
import com.example.app.entity.UserFlashcardProgress;
import com.example.app.repository.FlashcardRepository;
import com.example.app.repository.FlashcardSetRepository;
import com.example.app.repository.UserFlashcardProgressRepository;
import com.example.app.repository.UserRepository;
import com.example.app.service.FlashcardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class FlashcardServiceImpl implements FlashcardService {

    private final FlashcardSetRepository setRepository;
    private final FlashcardRepository flashcardRepository;
    private final UserRepository userRepository;
    private final UserFlashcardProgressRepository progressRepository;

    public FlashcardServiceImpl(FlashcardSetRepository setRepository,
                                 FlashcardRepository flashcardRepository,
                                 UserRepository userRepository,
                                 UserFlashcardProgressRepository progressRepository) {
        this.setRepository = setRepository;
        this.flashcardRepository = flashcardRepository;
        this.userRepository = userRepository;
        this.progressRepository = progressRepository;
    }

    private User getUser(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + email));
    }

    private FlashcardSet getSetAndVerifyOwner(UUID setId, String ownerEmail) {
        FlashcardSet set = setRepository.findById(setId)
                .orElseThrow(() -> new IllegalArgumentException("Flashcard set not found"));
        if (!set.getOwner().getEmail().equals(ownerEmail)) {
            throw new SecurityException("You do not have permission to access this set");
        }
        return set;
    }

    private FlashcardResponse toFlashcardResponse(Flashcard card, Map<UUID, String> statusMap) {
        FlashcardResponse res = new FlashcardResponse();
        res.setId(card.getId());
        res.setWord(card.getWord());
        res.setMeaning(card.getMeaning());
        res.setPronunciation(card.getPronunciation());
        res.setExample(card.getExample());
        res.setPartOfSpeech(card.getPartOfSpeech());
        res.setCreatedAt(card.getCreatedAt());
        res.setStatus(statusMap.getOrDefault(card.getId(), "UNKNOWN"));
        return res;
    }

    private FlashcardSetResponse toSetResponse(FlashcardSet set, List<Flashcard> cards, User user) {
        FlashcardSetResponse res = new FlashcardSetResponse();
        res.setId(set.getId());
        res.setName(set.getName());
        res.setDescription(set.getDescription());
        res.setEmoji(set.getEmoji());
        res.setIsPublic(set.getIsPublic());
        res.setCreatedAt(set.getCreatedAt());
        res.setUpdatedAt(set.getUpdatedAt());
        res.setTotalCards(cards.size());

        Map<UUID, String> statusMap = progressRepository.findByUser(user).stream()
                .filter(p -> p.getFlashcard() != null)
                .collect(Collectors.toMap(p -> p.getFlashcard().getId(), p -> p.getStatus().name(), (a, b) -> a));

        res.setCards(cards.stream().map(c -> toFlashcardResponse(c, statusMap)).collect(Collectors.toList()));
        return res;
    }

    @Override
    public FlashcardSetResponse createSet(CreateSetRequest request, String ownerEmail) {
        User owner = getUser(ownerEmail);
        FlashcardSet set = new FlashcardSet();
        set.setName(request.getName());
        set.setDescription(request.getDescription());
        set.setEmoji(request.getEmoji());
        set.setOwner(owner);
        set.setIsPublic(request.getIsPublic() != null ? request.getIsPublic() : false);
        FlashcardSet saved = setRepository.save(set);
        return toSetResponse(saved, List.of(), owner);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FlashcardSetResponse> getMySets(String ownerEmail) {
        User owner = getUser(ownerEmail);
        return setRepository.findByOwner(owner).stream()
                .map(set -> {
                    List<Flashcard> cards = flashcardRepository.findBySet(set);
                    return toSetResponse(set, cards, owner);
                })
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public FlashcardSetResponse getSetById(UUID setId, String ownerEmail, String status) {
        User user = getUser(ownerEmail);
        FlashcardSet set = getSetAndVerifyOwner(setId, ownerEmail);
        List<Flashcard> cards = flashcardRepository.findBySet(set);
        
        FlashcardSetResponse res = toSetResponse(set, cards, user);

        if (status != null && !status.equalsIgnoreCase("all")) {
            List<FlashcardResponse> filteredCards = res.getCards().stream()
                    .filter(c -> c.getStatus().equalsIgnoreCase(status))
                    .collect(Collectors.toList());
            res.setCards(filteredCards);
            // Optionally, we keep totalCards as the total number in the set, not the filtered number
        }

        return res;
    }

    @Override
    public FlashcardSetResponse updateSet(UUID setId, CreateSetRequest request, String ownerEmail) {
        User user = getUser(ownerEmail);
        FlashcardSet set = setRepository.findById(setId)
                .orElseThrow(() -> new IllegalArgumentException("Flashcard set not found"));

        if (!set.getOwner().getEmail().equals(ownerEmail)) {
            throw new org.springframework.security.access.AccessDeniedException("You do not have permission to modify this set");
        }
        
        if (request.getName() != null) set.setName(request.getName());
        if (request.getDescription() != null) set.setDescription(request.getDescription());
        if (request.getEmoji() != null) set.setEmoji(request.getEmoji());
        if (request.getIsPublic() != null) {
            set.setIsPublic(request.getIsPublic());
        }
        
        FlashcardSet saved = setRepository.saveAndFlush(set);
        List<Flashcard> cards = flashcardRepository.findBySet(saved);
        return toSetResponse(saved, cards, user);
    }

    @Override
    public void deleteSet(UUID setId, String ownerEmail) {
        FlashcardSet set = getSetAndVerifyOwner(setId, ownerEmail);
        setRepository.delete(set);
    }

    @Override
    public List<FlashcardResponse> addCardsToSet(UUID setId, List<CreateFlashcardRequest> cardRequests, String ownerEmail) {
        FlashcardSet set = getSetAndVerifyOwner(setId, ownerEmail);
        List<Flashcard> cards = cardRequests.stream().map(req -> {
            Flashcard card = new Flashcard();
            card.setSet(set);
            card.setWord(req.getWord());
            card.setMeaning(req.getMeaning());
            card.setPronunciation(req.getPronunciation());
            card.setExample(req.getExample());
            card.setPartOfSpeech(req.getPartOfSpeech());
            return card;
        }).collect(Collectors.toList());

        List<Flashcard> saved = flashcardRepository.saveAll(cards);
        User user = getUser(ownerEmail);
        Map<UUID, String> statusMap = progressRepository.findByUser(user).stream()
                .collect(Collectors.toMap(p -> p.getFlashcard().getId(), p -> p.getStatus().name(), (a, b) -> a));
        return saved.stream().map(c -> toFlashcardResponse(c, statusMap)).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<FlashcardResponse> getCardsInSet(UUID setId, String ownerEmail) {
        User user = getUser(ownerEmail);
        FlashcardSet set = getSetAndVerifyOwner(setId, ownerEmail);
        List<Flashcard> cards = flashcardRepository.findBySet(set);
        Map<UUID, String> statusMap = progressRepository.findByUser(user).stream()
                .collect(Collectors.toMap(p -> p.getFlashcard().getId(), p -> p.getStatus().name(), (a, b) -> a));
        return cards.stream()
                .map(c -> toFlashcardResponse(c, statusMap))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCard(UUID setId, UUID cardId, String ownerEmail) {
        getSetAndVerifyOwner(setId, ownerEmail);
        Flashcard card = flashcardRepository.findById(cardId)
                .orElseThrow(() -> new IllegalArgumentException("Flashcard not found"));
        if (!card.getSet().getId().equals(setId)) {
            throw new IllegalArgumentException("Card does not belong to this set");
        }
        flashcardRepository.delete(card);
    }

    @Override
    public com.example.app.dto.response.FlashcardProgressResponse updateFlashcardProgress(UUID cardId, com.example.app.dto.request.UpdateFlashcardProgressRequest request, String ownerEmail) {
        User user = getUser(ownerEmail);
        Flashcard card = flashcardRepository.findById(cardId)
                .orElseThrow(() -> new IllegalArgumentException("Flashcard not found"));

        com.example.app.entity.UserFlashcardProgress progress = progressRepository.findByUserAndFlashcard(user, card)
                .orElse(new com.example.app.entity.UserFlashcardProgress(user, card));

        if (request.getStatus() != null) {
            progress.setStatus(request.getStatus());
        }
        
        progress.setLastReviewedAt(ZonedDateTime.now());
        
        // Simple spaced repetition logic for nextReviewDate could be added here
        if (progress.getStatus() == com.example.app.entity.UserFlashcardProgress.FlashcardStatus.MASTERED) {
            progress.setNextReviewDate(ZonedDateTime.now().plusDays(7));
        } else if (progress.getStatus() == com.example.app.entity.UserFlashcardProgress.FlashcardStatus.LEARNING) {
            progress.setNextReviewDate(ZonedDateTime.now().plusDays(1));
        }

        com.example.app.entity.UserFlashcardProgress saved = progressRepository.save(progress);

        return new com.example.app.dto.response.FlashcardProgressResponse(
                saved.getFlashcard().getId(),
                saved.getStatus(),
                saved.getLastReviewedAt(),
                saved.getNextReviewDate()
        );
    }
}
