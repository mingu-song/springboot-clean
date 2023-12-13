package mingu.spring.clean.infrastructure.admin.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

@RestControllerAdvice
public class ErrorsHandler {

    private record ValidationErrorData(String field, List<String> messages) {
        public ValidationErrorData(FieldError errors) {
            this(errors.getField(), new ArrayList<>(Collections.singletonList(errors.getDefaultMessage())));
        }
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleError404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleError400(MethodArgumentNotValidException ex) {
        List<FieldError> errors = ex.getFieldErrors();

        List<ValidationErrorData> messages = new ArrayList<>(errors.size());

        errors.forEach(error -> {
            if (messages.stream().anyMatch(message -> Objects.equals(message.field(), error.getField()))) {
                ValidationErrorData errorData = messages.stream().filter(message ->
                        Objects.equals(message.field(), error.getField())).findFirst().get();

                messages.remove(errorData);
                List<String> messageList = errorData.messages();
                messageList.add(error.getDefaultMessage());
                messages.add(new ValidationErrorData(error.getField(), messageList));
            } else {
                messages.add(new ValidationErrorData(error));
            }
        });

        return ResponseEntity.badRequest().body(messages);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleError400(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleValidationError(ConstraintViolationException ex) {

        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();

        List<ValidationErrorData> messages = new ArrayList<>(constraintViolations.size());

        constraintViolations.forEach(constraintViolation -> {
            if (messages.stream().anyMatch(message -> Objects.equals(message.field(), constraintViolation.getPropertyPath().toString()))) {
                ValidationErrorData errorData = messages.stream().filter(message ->
                        Objects.equals(message.field(), constraintViolation.getPropertyPath().toString())).findFirst().get();

                messages.remove(errorData);
                List<String> messageList = errorData.messages();
                messageList.add(constraintViolation.getMessage());
                messages.add(new ValidationErrorData(constraintViolation.getPropertyPath().toString(), messageList));
            } else {
                messages.add(new ValidationErrorData(constraintViolation.getPropertyPath().toString(),
                        Collections.singletonList(constraintViolation.getMessage())));
            }
        });

        return ResponseEntity.badRequest().body(messages);
    }

    @ExceptionHandler(JpaSystemException.class)
    public ResponseEntity<?> handleError500(JpaSystemException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + ex.getLocalizedMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleError500(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error : " + ex.getLocalizedMessage());
    }
}
