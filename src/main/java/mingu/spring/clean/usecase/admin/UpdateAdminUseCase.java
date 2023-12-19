package mingu.spring.clean.usecase.admin;

import mingu.spring.clean.entity.admin.exception.AdminNotFoundException;
import mingu.spring.clean.entity.admin.gateway.AdminGateway;
import mingu.spring.clean.entity.admin.model.Admin;
import mingu.spring.clean.usecase.admin.dto.IAdminUpdateData;
import org.springframework.util.StringUtils;

public class UpdateAdminUseCase {
    private final AdminGateway adminGateway;

    public UpdateAdminUseCase(AdminGateway adminGateway) {
        this.adminGateway = adminGateway;
    }

    public Admin execute(Long id, IAdminUpdateData data) throws AdminNotFoundException {
        Admin admin = this.adminGateway.findById(id).orElseThrow(AdminNotFoundException::new);

        if (StringUtils.hasText(data.username())) admin.setUsername(data.username());
        if (StringUtils.hasText(data.password())) admin.setPassword(data.password());
        if (StringUtils.hasText(data.name())) admin.setName(data.name());
        if (StringUtils.hasText(data.email())) admin.setEmail(data.email());

        return this.adminGateway.update(admin);
    }
}
