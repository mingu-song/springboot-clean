package mingu.spring.clean.infrastructure.admin.dto;

import jakarta.validation.constraints.Email;
import mingu.spring.clean.infrastructure.user.validation.formats.Name;
import mingu.spring.clean.infrastructure.user.validation.unique.UniqueEmail;
import mingu.spring.clean.infrastructure.user.validation.unique.UniqueUsername;
import mingu.spring.clean.usecase.admin.dto.IAdminUpdateData;

public record AdminUpdateData(
        @UniqueUsername(message = "{Unique.user.username}")
        String username,

        String password,

        @Name(message = "{Name.user.name}")
        String name,

        @UniqueEmail(message = "{Unique.user.email}")
        @Email
        String email
) implements IAdminUpdateData { }
