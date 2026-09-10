package com.example.app.service.impl;

import com.example.app.dto.response.AdminStatsDTO;
import com.example.app.dto.response.AdminUserDTO;
import com.example.app.entity.User;
import com.example.app.repository.CourseRepository;
import com.example.app.repository.DailyStudyStatsRepository;
import com.example.app.repository.FlashcardSetRepository;
import com.example.app.repository.UserRepository;
import com.example.app.service.AdminService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final FlashcardSetRepository flashcardSetRepository;
    private final DailyStudyStatsRepository dailyStudyStatsRepository;

    public AdminServiceImpl(UserRepository userRepository,
                            CourseRepository courseRepository,
                            FlashcardSetRepository flashcardSetRepository,
                            DailyStudyStatsRepository dailyStudyStatsRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.flashcardSetRepository = flashcardSetRepository;
        this.dailyStudyStatsRepository = dailyStudyStatsRepository;
    }

    @Override
    public AdminStatsDTO getSystemStats() {
        AdminStatsDTO stats = new AdminStatsDTO();

        // Tổng người dùng
        stats.setTotalUsers(userRepository.count());

        // Tổng khóa học
        stats.setTotalCourses(courseRepository.count());

        // Tổng flashcard set
        stats.setTotalFlashcardSets(flashcardSetRepository.count());

        // Người dùng mới hôm nay (đăng ký trong ngày)
        ZonedDateTime startOfDay = LocalDate.now().atStartOfDay(ZoneId.systemDefault());
        ZonedDateTime endOfDay = startOfDay.plusDays(1);
        long newUsersToday = userRepository.findAll().stream()
                .filter(u -> u.getCreatedAt() != null
                        && !u.getCreatedAt().isBefore(startOfDay)
                        && u.getCreatedAt().isBefore(endOfDay))
                .count();
        stats.setNewUsersToday(newUsersToday);

        // Người dùng hoạt động hôm nay (có daily_study_stats hôm nay)
        long activeUsersToday = dailyStudyStatsRepository.findAll().stream()
                .filter(ds -> LocalDate.now().equals(ds.getStudyDate()))
                .map(ds -> ds.getUser().getId())
                .distinct()
                .count();
        stats.setActiveUsersToday(activeUsersToday);

        // 10 user đăng ký gần nhất
        List<AdminStatsDTO.UserSummary> recentUsers = userRepository.findAll().stream()
                .filter(u -> u.getCreatedAt() != null)
                .sorted((a, b) -> b.getCreatedAt().compareTo(a.getCreatedAt()))
                .limit(10)
                .map(u -> new AdminStatsDTO.UserSummary(
                        u.getId(), u.getName(), u.getEmail(),
                        u.getRole().name(), u.getAvatarUrl(), u.getCreatedAt()))
                .collect(Collectors.toList());
        stats.setRecentUsers(recentUsers);

        return stats;
    }

    @Override
    public Page<AdminUserDTO> getAllUsers(String search, Pageable pageable) {
        if (search != null && !search.isBlank()) {
            // Tìm kiếm theo tên hoặc email
            return userRepository.findByNameContainingOrEmailContaining(search, search, pageable)
                    .map(this::toAdminUserDTO);
        }
        return userRepository.findAll(pageable).map(this::toAdminUserDTO);
    }

    @Override
    @Transactional
    public AdminUserDTO updateUserRole(UUID userId, User.UserRole newRole) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found: " + userId));
        user.setRole(newRole);
        user = userRepository.save(user);
        return toAdminUserDTO(user);
    }

    @Override
    @Transactional
    public void deleteUser(UUID userId) {
        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found: " + userId);
        }
        userRepository.deleteById(userId);
    }

    // ─── Helper ────────────────────────────────────────────────────────────
    private AdminUserDTO toAdminUserDTO(User user) {
        return new AdminUserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole().name(),
                user.getAvatarUrl(),
                user.getCurrentStreak(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}
