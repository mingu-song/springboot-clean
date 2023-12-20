package mingu.spring.clean.infrastructure.admin.controller;

import lombok.RequiredArgsConstructor;
import mingu.spring.clean.entity.admin.exception.AdminNotFoundException;
import mingu.spring.clean.infrastructure.admin.dto.AdminPublicData;
import mingu.spring.clean.usecase.admin.GetAdminUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GetAdminController {

    private final GetAdminUseCase getAdminUseCase;

    @GetMapping("/admins/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AdminPublicData getAdmin(@PathVariable Long id) throws AdminNotFoundException {
        return new AdminPublicData(getAdminUseCase.execute(id));
    }
}
