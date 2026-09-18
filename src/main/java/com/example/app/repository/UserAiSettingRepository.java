package com.example.app.repository;

import com.example.app.entity.User;
import com.example.app.entity.UserAiSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserAiSettingRepository extends JpaRepository<UserAiSetting, UUID> {

    Optional<UserAiSetting> findByUser(User user);

    Optional<UserAiSetting> findByUserId(UUID userId);

    boolean existsByUserId(UUID userId);
}
