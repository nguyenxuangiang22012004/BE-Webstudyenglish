package com.example.app.repository;

import com.example.app.entity.AiWritingHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AiWritingHistoryRepository extends JpaRepository<AiWritingHistory, UUID> {
    Page<AiWritingHistory> findByUserIdOrderByCreatedAtDesc(UUID userId, Pageable pageable);
    java.util.List<AiWritingHistory> findByUserIdOrderByCreatedAtAsc(UUID userId);
    Optional<AiWritingHistory> findByIdAndUserId(UUID id, UUID userId);
    void deleteByIdAndUserId(UUID id, UUID userId);
}
