package com.example.app.repository;

import com.example.app.entity.UserTopicProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserTopicProgressRepository extends JpaRepository<UserTopicProgress, UUID> {
    Optional<UserTopicProgress> findByUserIdAndTopicId(UUID userId, UUID topicId);
}
