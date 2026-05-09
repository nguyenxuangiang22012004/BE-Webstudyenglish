package com.example.app.repository;

import com.example.app.entity.StudyGroup;
import com.example.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudyGroupRepository extends JpaRepository<StudyGroup, UUID> {
    List<StudyGroup> findByOwner(User owner);
    Optional<StudyGroup> findByJoinCode(String joinCode);
}
