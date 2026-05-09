package com.example.app.repository;

import com.example.app.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, UUID> {
    List<Lesson> findByCategory(String category);
    List<Lesson> findByLevel(Lesson.LessonLevel level);
}
