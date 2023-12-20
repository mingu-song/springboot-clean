package mingu.spring.clean.infrastructure.admin.controller;

import lombok.RequiredArgsConstructor;
import mingu.spring.clean.entity.admin.exception.AdminNotFoundException;
import mingu.spring.clean.infrastructure.admin.dto.AdminPublicData;
import mingu.spring.clean.usecase.admin.DeleteAdminUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class DeleteAdminController {

    private final DeleteAdminUseCase deleteAdminUseCase;

    @DeleteMapping("/admins/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AdminPublicData deleteAdmin(@PathVariable Long id) throws AdminNotFoundException {
        return new AdminPublicData(deleteAdminUseCase.execute(id));
    }
}
