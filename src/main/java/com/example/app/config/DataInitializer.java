package com.example.app.config;

import com.example.app.entity.User;
import com.example.app.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        String adminEmail = "giangadmin";
        if (!userRepository.existsByEmail(adminEmail)) {
            User admin = new User();
            admin.setEmail(adminEmail);
            admin.setPasswordHash(passwordEncoder.encode("giangadmin"));
            admin.setName("Admin Giang");
            admin.setRole(User.UserRole.ADMIN);
            admin.setCurrentStreak(0);
            admin.setLongestStreak(0);
            admin.setDailyWordsGoal(10);
            admin.setTotalWordsGoal(200);
            admin.setStreakGoal(30);
            
            userRepository.save(admin);
            System.out.println("Admin account 'giangadmin' seeded successfully!");
        } else {
            System.out.println("Admin account 'giangadmin' already exists.");
        }
    }
}
