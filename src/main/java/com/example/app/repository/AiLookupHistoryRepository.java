package com.example.app.repository;

import com.example.app.entity.AiLookupHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AiLookupHistoryRepository extends JpaRepository<AiLookupHistory, UUID> {
    List<AiLookupHistory> findTop4ByUserIdOrderByCreatedAtDesc(UUID userId);
}
