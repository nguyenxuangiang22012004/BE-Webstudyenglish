# Spring REST API Skill

This skill defines REST API best practices.

## Rules

- Use RESTful naming
- Use ResponseEntity
- Use proper HTTP status codes
- Validate request body using @Valid
- Return DTO instead of Entity

## REST Naming

GET    /api/users
GET    /api/users/{id}
POST   /api/users
PUT    /api/users/{id}
DELETE /api/users/{id}

## HTTP Status

200 OK
201 CREATED
400 BAD REQUEST
401 UNAUTHORIZED
403 FORBIDDEN
404 NOT FOUND
500 INTERNAL SERVER ERROR

## Controller Example

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

}

## Rules

- Controller only handles request/response
- No business logic in controller
- Keep controller methods clean