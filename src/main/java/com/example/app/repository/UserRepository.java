package com.example.app.repository;

import com.example.app.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);

    /** Tìm kiếm user theo tên hoặc email (case-insensitive) với phân trang */
    Page<User> findByNameContainingOrEmailContaining(String name, String email, Pageable pageable);
}
