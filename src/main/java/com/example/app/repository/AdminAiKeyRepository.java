package com.example.app.repository;

import com.example.app.entity.AdminAiKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AdminAiKeyRepository extends JpaRepository<AdminAiKey, UUID> {

    List<AdminAiKey> findByIsActiveTrueOrderByUsageCountAsc();

    @Query("SELECT k FROM AdminAiKey k WHERE k.isActive = true ORDER BY k.usageCount ASC LIMIT 1")
    Optional<AdminAiKey> findBestActiveKey();

    List<AdminAiKey> findAllByOrderByCreatedAtDesc();
}
