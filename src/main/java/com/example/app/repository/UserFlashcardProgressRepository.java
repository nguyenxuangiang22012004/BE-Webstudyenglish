package com.example.app.repository;

import com.example.app.entity.Flashcard;
import com.example.app.entity.User;
import com.example.app.entity.UserFlashcardProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserFlashcardProgressRepository extends JpaRepository<UserFlashcardProgress, UUID> {
    Optional<UserFlashcardProgress> findByUserAndFlashcard(User user, Flashcard flashcard);
    List<UserFlashcardProgress> findByUser(User user);
    List<UserFlashcardProgress> findByUserAndStatus(User user, UserFlashcardProgress.FlashcardStatus status);
}
