package mingu.spring.clean.infrastructure.admin.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mingu.spring.clean.infrastructure.admin.dto.AdminPublicData;
import mingu.spring.clean.infrastructure.admin.dto.AdminRegistrationData;
import mingu.spring.clean.usecase.admin.CreateAdminUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CreateAdminController {

    private final CreateAdminUseCase createAdminUseCase;

    @PostMapping("/admins")
    @ResponseStatus(HttpStatus.CREATED)
    public AdminPublicData createAdmin(@Valid @RequestBody AdminRegistrationData data) {
        return new AdminPublicData(createAdminUseCase.execute(data));
    }
}
