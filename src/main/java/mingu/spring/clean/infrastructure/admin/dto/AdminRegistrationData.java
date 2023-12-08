package mingu.spring.clean.infrastructure.admin.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import mingu.spring.clean.usecase.admin.dto.IAdminRegistrationData;

public record AdminRegistrationData(
        @NotBlank
        String username,
        @NotBlank
        String password,
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email
) implements IAdminRegistrationData { }
