# Spring Exception Handler Skill

This skill defines global exception handling.

## Rules

- Use @RestControllerAdvice
- Never expose stack trace to client
- Return consistent error response
- Handle validation exceptions

## Standard Error Response

{
  "success": false,
  "message": "Email already exists"
}

## Global Exception Handler

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {

        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("Something went wrong");
    }

}

## Handle Validation Errors

MethodArgumentNotValidException

## Custom Exceptions

- ResourceNotFoundException
- BadRequestException
- UnauthorizedException