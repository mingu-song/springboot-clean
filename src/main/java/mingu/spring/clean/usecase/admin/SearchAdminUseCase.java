package mingu.spring.clean.usecase.admin;

import mingu.spring.clean.entity.admin.gateway.AdminGateway;
import mingu.spring.clean.entity.admin.model.Admin;

import java.util.List;

public class SearchAdminUseCase {
    private final AdminGateway adminGateway;

    public SearchAdminUseCase(AdminGateway adminGateway) {
        this.adminGateway = adminGateway;
    }

    public List<Admin> execute() {
        return adminGateway.findAll();
    }
}
