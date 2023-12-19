package mingu.spring.clean.infrastructure.admin.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import mingu.spring.clean.infrastructure.annotation.validation.formats.Name;
import mingu.spring.clean.infrastructure.annotation.validation.unique.UniqueEmail;
import mingu.spring.clean.infrastructure.annotation.validation.unique.UniqueUsername;
import mingu.spring.clean.usecase.admin.dto.IAdminRegistrationData;

public record AdminRegistrationData(
        @UniqueUsername(message = "{Unique.user.username}")
        @NotBlank
        String username,
        @NotBlank
        String password,
        @NotBlank
        @Name(message = "{Name.user.name}")
        String name,
        @UniqueEmail(message = "{Unique.user.email}")
        @NotBlank
        @Email
        String email
) implements IAdminRegistrationData { }
