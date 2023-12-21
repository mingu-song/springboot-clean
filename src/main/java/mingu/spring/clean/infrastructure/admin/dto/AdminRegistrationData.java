package mingu.spring.clean.infrastructure.admin.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import mingu.spring.clean.infrastructure.user.validation.formats.Name;
import mingu.spring.clean.infrastructure.user.validation.unique.UniqueEmail;
import mingu.spring.clean.infrastructure.user.validation.unique.UniqueUsername;
import mingu.spring.clean.usecase.admin.dto.IAdminRegistrationData;

public record AdminRegistrationData(
        @UniqueUsername(message = "{Unique.user.username}")
        @NotBlank
        String username,
        @NotBlank
        String password,
        @NotBlank
        @Name(message = "{USER_VALID_NAME}")
        String name,
        @UniqueEmail(message = "{Unique.user.email}")
        @NotBlank
        @Email(message = "{USER_VALID_EMAIL}")
        String email
) implements IAdminRegistrationData { }
