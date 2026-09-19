package com.example.app.repository;

import com.example.app.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TopicRepository extends JpaRepository<Topic, UUID> {
    List<Topic> findByCourseIdOrderByOrderIndexAsc(UUID courseId);
    Optional<Topic> findBySlug(String slug);
    Optional<Topic> findByCourseIdAndSlug(UUID courseId, String slug);
    boolean existsBySlug(String slug);
}
