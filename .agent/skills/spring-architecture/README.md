# Spring Architecture Skill

This skill defines the standard architecture and folder structure for all Spring Boot projects.

## Architecture Style

Use Layered Architecture:

Controller
→ Service
→ Repository
→ Database

## Folder Structure

src/main/java/com/project

- controller
- service
- service/impl
- repository
- entity
- dto
- mapper
- config
- security
- exception
- utils

## Rules

- Never write business logic inside Controller
- Always use DTO for request/response
- Service handles business logic
- Repository only handles database access
- Use constructor injection
- Use Lombok to reduce boilerplate
- Keep methods small and readable
- Use package-by-feature if project becomes large

## Naming Convention

- UserController
- UserService
- UserServiceImpl
- UserRepository
- UserRequestDTO
- UserResponseDTO

## Response Format

Always use standard API response:

{
  "success": true,
  "message": "Success",
  "data": {}
}