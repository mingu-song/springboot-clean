package mingu.spring.clean.infrastructure.annotation.validation.formats;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class NameValidator implements ConstraintValidator<Name, String> {
    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        /*
         * ^ - start of string
         * [a-zA-Z]{4,} - 4 or more ASCII letters
         * (?: [a-zA-Z]+){0,2} - 0 to 2 occurrences of a space followed with one or more ASCII letters
         * $ - end of string.
         */
        if (!StringUtils.hasText(name)) return true;
        return name.matches("^[a-zA-Z]{3,}(?: [a-zA-Z]+)+$");
    }
}
