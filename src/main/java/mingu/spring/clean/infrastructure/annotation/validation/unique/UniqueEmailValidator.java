package mingu.spring.clean.infrastructure.annotation.validation.unique;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import mingu.spring.clean.infrastructure.config.db.repository.UserRepository;
import mingu.spring.clean.infrastructure.config.db.schema.UserSchema;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final UserRepository userRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        if (userRepository != null) {
            Optional<UserSchema> userSchema = userRepository.findByEmail(email);
            return userSchema.isEmpty();
        }
        return true;
    }
}
