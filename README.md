# English Learning Backend

A Spring Boot backend application for an English learning platform with PostgreSQL database support.

## Prerequisites

- Java 21 or higher
- Maven 3.6+
- PostgreSQL 12 or higher

## Project Structure

```
src/
├── main/
│   ├── java/com/example/app/
│   │   ├── Application.java           # Main Spring Boot entry point
│   │   ├── controller/                # REST Controllers
│   │   ├── entity/                    # JPA Entities (11 tables)
│   │   ├── repository/                # Data Access Layer
│   │   ├── service/                   # Business Logic
│   │   └── dto/                       # Data Transfer Objects
│   └── resources/
│       ├── application.properties     # Configuration
│       └── db/
│           └── init.sql              # Database initialization script
└── test/
    └── java/com/example/app/          # Unit tests
```

## Database Schema

The application uses 11 PostgreSQL tables for complete functionality:

### User Management
- `users` - User authentication and profile

### Flashcard System
- `flashcard_sets` - Collections of flashcards
- `flashcards` - Individual word flashcards
- `user_flashcard_progress` - User learning progress tracking

### Study Groups
- `study_groups` - Group management
- `study_group_members` - Group membership
- `study_group_sets` - Flashcard sets shared in groups

### Learning Analytics
- `daily_study_stats` - Daily study statistics and progress tracking

### Lessons & Quizzes
- `lessons` - Course lessons
- `quizzes` - Quiz management
- `questions` - Quiz questions with JSONB options

## Getting Started

### 1. Database Setup

Create a PostgreSQL database:

```sql
CREATE DATABASE english_learning_db;
```

Then run the initialization script:

```bash
psql -U postgres -d english_learning_db -f src/main/resources/db/init.sql
```

Or execute the SQL commands directly in PostgreSQL client.

### 2. Configure Database Connection

Update `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/english_learning_db
spring.datasource.username=postgres
spring.datasource.password=your_password
```

### 3. Build the Project

```bash
mvn clean install
```

### 4. Run the Application

```bash
mvn spring-boot:run
```

The application will start at `http://localhost:8080/api`

### 5. Test the Health Endpoint

```bash
curl http://localhost:8080/api/health
```

Expected response:
```json
{
  "status": "UP",
  "message": "English Learning Backend is running"
}
```

## Dependencies

- **Spring Boot Web** - REST API support
- **Spring Data JPA** - ORM and database access
- **PostgreSQL JDBC Driver** - PostgreSQL connectivity
- **Lombok** - Code generation (optional)
- **Spring Boot DevTools** - Hot reload during development
- **Jackson** - JSON processing for JSONB support

## API Endpoints

### Health Check
- `GET /api/health` - Application health status

## Entity Overview

### User
Manages user authentication, roles (USER, ADMIN, TEACHER), and streak tracking.

### FlashcardSet
Groups related flashcards with ownership and public/private visibility.

### Flashcard
Individual vocabulary items with word, meaning, pronunciation, examples, and images.

### UserFlashcardProgress
Tracks learning status (UNKNOWN, LEARNING, MASTERED), favorites, and spaced repetition dates.

### StudyGroup
Collaborative learning groups with join codes and member management.

### DailyStudyStats
Records daily learning metrics: words learned, words reviewed, and time spent.

### Lesson
Pre-designed learning courses with categories and difficulty levels.

### Quiz
Quiz collections linked to lessons with multiple-choice questions.

## Development

### Adding New Features

1. **Create an Entity** in `entity/` folder
2. **Create a Repository** extending `JpaRepository` in `repository/`
3. **Create a Service** for business logic in `service/`
4. **Create a Controller** to expose REST endpoints in `controller/`

### Hot Reload

DevTools is included for automatic restart on file changes. Simply save your files during development.

### Data Access Pattern

```java
// Service layer
@Service
public class FlashcardSetService {
    
    @Autowired
    private FlashcardSetRepository repository;
    
    public List<FlashcardSet> getUserSets(UUID userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        return repository.findByOwner(user);
    }
}
```

## PostgreSQL Specific Features

The application leverages PostgreSQL capabilities:

- **JSONB Type** - Used in questions table for flexible quiz options storage
- **UUID Type** - Native UUID support for all IDs
- **Enums** - PostgreSQL ENUM types for role, status, and level fields
- **Timestamp with Time Zone** - Timezone-aware timestamps for global applications
- **Indexes** - Optimized queries with strategic indexing

## Building for Production

```bash
mvn clean package
java -jar target/english-learning-app-1.0.0.jar --spring.profiles.active=prod
```

## Environment Variables

For production, you can use environment variables:

```bash
export DB_URL=jdbc:postgresql://prod-db:5432/english_learning
export DB_USERNAME=prod_user
export DB_PASSWORD=secure_password
java -jar target/english-learning-app-1.0.0.jar
```

## Database Migrations

For managing schema migrations in production, consider using Flyway or Liquibase:

```xml
<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-core</artifactId>
    <version>9.20.0</version>
</dependency>
```

## Troubleshooting

### Connection refused
- Ensure PostgreSQL is running on localhost:5432
- Check database credentials in application.properties

### DDL Script Errors
- Verify PostgreSQL version supports required features
- Check for pre-existing tables if running script multiple times

### JSONB Errors
- Ensure you're using PostgreSQL 9.4+
- Spring Boot 3.1+ is required for native JSONB support

## License

This project is licensed under the MIT License.
