package com.example.app.controller;

import com.example.app.dto.response.AdminStatsDTO;
import com.example.app.dto.response.AdminUserDTO;
import com.example.app.dto.response.ApiResponse;
import com.example.app.entity.User;
import com.example.app.service.AdminService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    /**
     * GET /v1/admin/stats
     * Thống kê tổng quan hệ thống
     */
    @GetMapping("/stats")
    public ResponseEntity<ApiResponse<AdminStatsDTO>> getSystemStats() {
        AdminStatsDTO stats = adminService.getSystemStats();
        return ResponseEntity.ok(new ApiResponse<>(true, "Thống kê hệ thống", stats));
    }

    /**
     * GET /v1/admin/users?search=&page=0&size=10
     * Danh sách người dùng với tìm kiếm và phân trang
     */
    @GetMapping("/users")
    public ResponseEntity<ApiResponse<Page<AdminUserDTO>>> getAllUsers(
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<AdminUserDTO> users = adminService.getAllUsers(search, pageable);
        return ResponseEntity.ok(new ApiResponse<>(true, "Danh sách người dùng", users));
    }

    /**
     * PUT /v1/admin/users/{id}/role
     * Body: { "role": "ADMIN" | "USER" | "TEACHER" }
     * Đổi role người dùng
     */
    @PutMapping("/users/{id}/role")
    public ResponseEntity<ApiResponse<AdminUserDTO>> updateUserRole(
            @PathVariable UUID id,
            @RequestBody UpdateRoleRequest request) {
        User.UserRole newRole = User.UserRole.valueOf(request.getRole().toUpperCase());
        AdminUserDTO updated = adminService.updateUserRole(id, newRole);
        return ResponseEntity.ok(new ApiResponse<>(true, "Cập nhật role thành công", updated));
    }

    /**
     * DELETE /v1/admin/users/{id}
     * Xóa người dùng
     */
    @DeleteMapping("/users/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable UUID id) {
        adminService.deleteUser(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Đã xóa người dùng", null));
    }

    // ─── Inner request DTO ──────────────────────────────────────────────────
    public static class UpdateRoleRequest {
        private String role;

        public String getRole() { return role; }
        public void setRole(String role) { this.role = role; }
    }
}
