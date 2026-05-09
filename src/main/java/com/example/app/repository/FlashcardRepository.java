package com.example.app.repository;

import com.example.app.entity.Flashcard;
import com.example.app.entity.FlashcardSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FlashcardRepository extends JpaRepository<Flashcard, UUID> {
    List<Flashcard> findBySet(FlashcardSet set);
}
