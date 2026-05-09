package com.example.app.repository;

import com.example.app.entity.StudyGroup;
import com.example.app.entity.StudyGroupMember;
import com.example.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudyGroupMemberRepository extends JpaRepository<StudyGroupMember, UUID> {
    List<StudyGroupMember> findByGroup(StudyGroup group);
    List<StudyGroupMember> findByUser(User user);
    Optional<StudyGroupMember> findByGroupAndUser(StudyGroup group, User user);
}
