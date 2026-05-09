package com.example.app.repository;

import com.example.app.entity.DailyStudyStats;
import com.example.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DailyStudyStatsRepository extends JpaRepository<DailyStudyStats, UUID> {
    Optional<DailyStudyStats> findByUserAndStudyDate(User user, LocalDate studyDate);
    List<DailyStudyStats> findByUserOrderByStudyDateDesc(User user);
}
