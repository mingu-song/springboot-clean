package mingu.spring.clean.infrastructure.annotation.validation.unique;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import mingu.spring.clean.infrastructure.config.db.repository.UserRepository;
import mingu.spring.clean.infrastructure.config.db.schema.UserSchema;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
    private final UserRepository userRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        if (userRepository != null) {
            Optional<UserSchema> userSchema = userRepository.findByUsername(username);
            return userSchema.isEmpty();
        }
        return true;
    }
}
