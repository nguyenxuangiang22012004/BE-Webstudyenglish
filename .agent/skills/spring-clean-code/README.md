# Spring Clean Code Skill

This skill defines clean code practices.

## Rules

- Keep methods short
- Use meaningful variable names
- Avoid duplicate code
- Single responsibility principle
- Prefer composition over inheritance

## Naming

Bad:
getUsr()

Good:
getUserById()

## Method Rules

- One method should do one thing
- Avoid large service methods
- Extract reusable logic

## Clean Service Example

public UserResponse getUser(Long id) {

    User user = findUserById(id);

    return mapToResponse(user);
}

## Avoid

- God classes
- Massive controllers
- Business logic inside repository
- Hardcoded values

## Best Practices

- Use constants
- Use enums
- Use utility classes carefully
- Write readable code first