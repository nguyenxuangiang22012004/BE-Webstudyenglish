# Spring JPA Skill

This skill defines database access using Spring Data JPA.

## Rules

- Use JpaRepository
- Use lazy loading by default
- Avoid N+1 query problem
- Use pagination for large data
- Use DTO projection when needed

## Entity Rules

- Use @Entity
- Use @Table
- Use @Id and @GeneratedValue
- Use LocalDateTime for timestamps

## Example

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}

## Repository Example

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}

## Relationships

@OneToMany
@ManyToOne
@OneToOne
@ManyToMany

Use FetchType.LAZY unless necessary.