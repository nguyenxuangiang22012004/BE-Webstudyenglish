package com.example.app.repository;

import com.example.app.entity.AiListeningHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AiListeningHistoryRepository extends JpaRepository<AiListeningHistory, UUID> {
    Page<AiListeningHistory> findByUserIdOrderByCreatedAtDesc(UUID userId, Pageable pageable);
}
