package mingu.spring.clean.usecase.admin;

import mingu.spring.clean.entity.admin.exception.AdminNotFoundException;
import mingu.spring.clean.entity.admin.gateway.AdminGateway;
import mingu.spring.clean.entity.admin.model.Admin;

public class GetAdminUseCase {
    private final AdminGateway adminGateway;

    public GetAdminUseCase(AdminGateway adminGateway) {
        this.adminGateway = adminGateway;
    }

    public Admin execute(Long id) throws AdminNotFoundException {
        return this.adminGateway.findById(id).orElseThrow(AdminNotFoundException::new);
    }
}
