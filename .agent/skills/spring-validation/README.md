# Spring Validation Skill

This skill defines request validation rules.

## Rules

- Always validate request body
- Use @Valid in controller
- Never trust client input
- Return readable validation errors

## Common Validation

@NotBlank
@NotNull
@Email
@Size
@Min
@Max
@Pattern

## Example DTO

@Getter
@Setter
public class RegisterRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email")
    private String email;

    @Size(min = 6)
    private String password;
}

## Controller Example

@PostMapping
public ResponseEntity<?> register(
    @Valid @RequestBody RegisterRequest request
) {

}