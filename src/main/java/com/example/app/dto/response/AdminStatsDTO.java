package com.example.app.dto.response;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class AdminStatsDTO {

    private long totalUsers;
    private long totalCourses;
    private long totalFlashcardSets;
    private long newUsersToday;
    private long activeUsersToday;
    private List<UserSummary> recentUsers;

    public AdminStatsDTO() {}

    public long getTotalUsers() { return totalUsers; }
    public void setTotalUsers(long totalUsers) { this.totalUsers = totalUsers; }

    public long getTotalCourses() { return totalCourses; }
    public void setTotalCourses(long totalCourses) { this.totalCourses = totalCourses; }

    public long getTotalFlashcardSets() { return totalFlashcardSets; }
    public void setTotalFlashcardSets(long totalFlashcardSets) { this.totalFlashcardSets = totalFlashcardSets; }

    public long getNewUsersToday() { return newUsersToday; }
    public void setNewUsersToday(long newUsersToday) { this.newUsersToday = newUsersToday; }

    public long getActiveUsersToday() { return activeUsersToday; }
    public void setActiveUsersToday(long activeUsersToday) { this.activeUsersToday = activeUsersToday; }

    public List<UserSummary> getRecentUsers() { return recentUsers; }
    public void setRecentUsers(List<UserSummary> recentUsers) { this.recentUsers = recentUsers; }

    // ─── Inner DTO: UserSummary ────────────────────────────────────────────
    public static class UserSummary {
        private UUID id;
        private String name;
        private String email;
        private String role;
        private String avatarUrl;
        private ZonedDateTime createdAt;

        public UserSummary() {}

        public UserSummary(UUID id, String name, String email, String role,
                           String avatarUrl, ZonedDateTime createdAt) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.role = role;
            this.avatarUrl = avatarUrl;
            this.createdAt = createdAt;
        }

        public UUID getId() { return id; }
        public void setId(UUID id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getRole() { return role; }
        public void setRole(String role) { this.role = role; }

        public String getAvatarUrl() { return avatarUrl; }
        public void setAvatarUrl(String avatarUrl) { this.avatarUrl = avatarUrl; }

        public ZonedDateTime getCreatedAt() { return createdAt; }
        public void setCreatedAt(ZonedDateTime createdAt) { this.createdAt = createdAt; }
    }
}
