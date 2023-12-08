package mingu.spring.clean.usecase.admin;

import lombok.RequiredArgsConstructor;
import mingu.spring.clean.entity.admin.gateway.AdminGateway;
import mingu.spring.clean.entity.admin.model.Admin;
import mingu.spring.clean.usecase.admin.dto.IAdminRegistrationData;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAdminUseCase {
    private final AdminGateway adminGateway;

    public Admin execute(IAdminRegistrationData data) {
        Admin admin = new Admin(data.username(), data.password(), data.name(), data.email());
        return this.adminGateway.create(admin);
    }

}
