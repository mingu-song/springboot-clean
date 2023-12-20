package mingu.spring.clean.infrastructure.admin.controller;

import lombok.RequiredArgsConstructor;
import mingu.spring.clean.infrastructure.admin.dto.AdminPublicData;
import mingu.spring.clean.usecase.admin.SearchAdminUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SearchAdminController {

    private final SearchAdminUseCase searchAdminUseCase;

    @GetMapping("/admins")
    @ResponseStatus(HttpStatus.OK)
    public List<AdminPublicData> searchAdmin() {
        return this.searchAdminUseCase.execute().stream().map(AdminPublicData::new).toList();
    }
}
