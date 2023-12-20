package mingu.spring.clean.infrastructure.admin.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mingu.spring.clean.entity.admin.exception.AdminNotFoundException;
import mingu.spring.clean.infrastructure.admin.dto.AdminPublicData;
import mingu.spring.clean.infrastructure.admin.dto.AdminUpdateData;
import mingu.spring.clean.usecase.admin.UpdateAdminUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UpdateAdminController {

    private final UpdateAdminUseCase updateAdminUseCase;

    @PutMapping("/admins/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AdminPublicData updateAdmin(@PathVariable Long id, @Valid @RequestBody AdminUpdateData data) throws AdminNotFoundException {
        return new AdminPublicData(updateAdminUseCase.execute(id, data));
    }
}
