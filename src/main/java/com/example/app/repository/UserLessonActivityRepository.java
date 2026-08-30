package com.example.app.repository;

import com.example.app.entity.UserLessonActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserLessonActivityRepository extends JpaRepository<UserLessonActivity, UUID> {

    // Xóa tất cả activity của user trong 1 topic (dùng khi reset)
    @Modifying
    @Query("DELETE FROM UserLessonActivity a WHERE a.user.id = :userId AND a.topic.id = :topicId")
    void deleteByUserIdAndTopicId(UUID userId, UUID topicId);

    // Lấy tất cả activities của user trong 1 topic
    List<UserLessonActivity> findByUserIdAndTopicId(UUID userId, UUID topicId);

    // Lấy lần hoàn thành gần nhất của 1 lesson
    Optional<UserLessonActivity> findFirstByUserIdAndLessonIdOrderByCreatedAtDesc(UUID userId, UUID lessonId);

    // Lấy danh sách lessonId đã completed trong 1 topic (distinct lesson_id)
    @Query("SELECT DISTINCT a.lesson.id FROM UserLessonActivity a WHERE a.user.id = :userId AND a.topic.id = :topicId AND a.isCompleted = true")
    List<UUID> findCompletedLessonIdsByUserIdAndTopicId(UUID userId, UUID topicId);

    // Tính điểm trung bình các lesson có điểm (bỏ qua NULL - CONVERSATION, v.v.)
    @Query("SELECT AVG(a.score) FROM UserLessonActivity a " +
           "WHERE a.user.id = :userId AND a.topic.id = :topicId " +
           "AND a.isCompleted = true AND a.score IS NOT NULL")
    Double calculateAverageScoreByUserIdAndTopicId(UUID userId, UUID topicId);

    // Đếm số lesson distinct đã có điểm
    @Query("SELECT COUNT(DISTINCT a.lesson.id) FROM UserLessonActivity a " +
           "WHERE a.user.id = :userId AND a.topic.id = :topicId " +
           "AND a.isCompleted = true AND a.score IS NOT NULL")
    Long countScoredLessons(UUID userId, UUID topicId);
}

