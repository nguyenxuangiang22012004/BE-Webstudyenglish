package com.example.app.service.impl;

import com.example.app.dto.request.CreateFlashcardRequest;
import com.example.app.dto.request.CreateSetRequest;
import com.example.app.dto.response.FlashcardResponse;
import com.example.app.dto.response.FlashcardSetResponse;
import com.example.app.entity.Flashcard;
import com.example.app.entity.FlashcardSet;
import com.example.app.entity.User;
import com.example.app.repository.FlashcardRepository;
import com.example.app.repository.FlashcardSetRepository;
import com.example.app.repository.UserRepository;
import com.example.app.service.FlashcardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class FlashcardServiceImpl implements FlashcardService {

    private final FlashcardSetRepository setRepository;
    private final FlashcardRepository flashcardRepository;
    private final UserRepository userRepository;

    public FlashcardServiceImpl(FlashcardSetRepository setRepository,
                                 FlashcardRepository flashcardRepository,
                                 UserRepository userRepository) {
        this.setRepository = setRepository;
        this.flashcardRepository = flashcardRepository;
        this.userRepository = userRepository;
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

    private FlashcardResponse toFlashcardResponse(Flashcard card) {
        FlashcardResponse res = new FlashcardResponse();
        res.setId(card.getId());
        res.setWord(card.getWord());
        res.setMeaning(card.getMeaning());
        res.setPronunciation(card.getPronunciation());
        res.setExample(card.getExample());
        res.setCreatedAt(card.getCreatedAt());
        return res;
    }

    private FlashcardSetResponse toSetResponse(FlashcardSet set, List<Flashcard> cards) {
        FlashcardSetResponse res = new FlashcardSetResponse();
        res.setId(set.getId());
        res.setName(set.getName());
        res.setDescription(set.getDescription());
        res.setEmoji(set.getEmoji());
        res.setIsPublic(set.getIsPublic());
        res.setCreatedAt(set.getCreatedAt());
        res.setUpdatedAt(set.getUpdatedAt());
        res.setTotalCards(cards.size());
        res.setCards(cards.stream().map(this::toFlashcardResponse).collect(Collectors.toList()));
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
        return toSetResponse(saved, List.of());
    }

    @Override
    @Transactional(readOnly = true)
    public List<FlashcardSetResponse> getMySets(String ownerEmail) {
        User owner = getUser(ownerEmail);
        return setRepository.findByOwner(owner).stream()
                .map(set -> {
                    List<Flashcard> cards = flashcardRepository.findBySet(set);
                    return toSetResponse(set, cards);
                })
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public FlashcardSetResponse getSetById(UUID setId, String ownerEmail) {
        FlashcardSet set = getSetAndVerifyOwner(setId, ownerEmail);
        List<Flashcard> cards = flashcardRepository.findBySet(set);
        return toSetResponse(set, cards);
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
            return card;
        }).collect(Collectors.toList());

        List<Flashcard> saved = flashcardRepository.saveAll(cards);
        return saved.stream().map(this::toFlashcardResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<FlashcardResponse> getCardsInSet(UUID setId, String ownerEmail) {
        FlashcardSet set = getSetAndVerifyOwner(setId, ownerEmail);
        return flashcardRepository.findBySet(set).stream()
                .map(this::toFlashcardResponse)
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
}
