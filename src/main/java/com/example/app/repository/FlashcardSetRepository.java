package com.example.app.repository;

import com.example.app.entity.FlashcardSet;
import com.example.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FlashcardSetRepository extends JpaRepository<FlashcardSet, UUID> {
    List<FlashcardSet> findByOwner(User owner);
    List<FlashcardSet> findByIsPublicTrue();
}
