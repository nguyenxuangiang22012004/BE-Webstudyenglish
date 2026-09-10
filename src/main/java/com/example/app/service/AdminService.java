package com.example.app.service;

import com.example.app.dto.response.AdminStatsDTO;
import com.example.app.dto.response.AdminUserDTO;
import com.example.app.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface AdminService {

    /** Thống kê tổng quan hệ thống */
    AdminStatsDTO getSystemStats();

    /** Danh sách người dùng (có phân trang + tìm kiếm) */
    Page<AdminUserDTO> getAllUsers(String search, Pageable pageable);

    /** Đổi role người dùng */
    AdminUserDTO updateUserRole(UUID userId, User.UserRole newRole);

    /** Xóa người dùng */
    void deleteUser(UUID userId);
}
