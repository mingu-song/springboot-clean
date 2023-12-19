package mingu.spring.clean.usecase.admin;

import mingu.spring.clean.entity.admin.exception.AdminNotFoundException;
import mingu.spring.clean.entity.admin.gateway.AdminGateway;
import mingu.spring.clean.entity.admin.model.Admin;

public class DeleteAdminUseCase {
    private final AdminGateway adminGateway;

    public DeleteAdminUseCase(AdminGateway adminGateway) {
        this.adminGateway = adminGateway;
    }

    public Admin execute(Long id) throws AdminNotFoundException {
        Admin admin = adminGateway.findById(id).orElseThrow(AdminNotFoundException::new);
        adminGateway.delete(admin.getId());
        return admin;
    }
}
