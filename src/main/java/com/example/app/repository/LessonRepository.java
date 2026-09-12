package com.example.app.repository;

import com.example.app.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, UUID> {
    List<Lesson> findByTopicIdOrderByOrderIndexAsc(UUID topicId);
    List<Lesson> findByTopicIdAndTypeOrderByOrderIndexAsc(UUID topicId, String type);
    List<Lesson> findByTypeOrderByOrderIndexAsc(String type);
    long countByTopicId(UUID topicId);
}

