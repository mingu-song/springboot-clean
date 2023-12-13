package mingu.spring.clean.infrastructure.admin.usecase;

import mingu.spring.clean.entity.admin.gateway.AdminGateway;
import mingu.spring.clean.infrastructure.admin.gateway.AdminDatabaseGateway;
import mingu.spring.clean.infrastructure.config.db.repository.AdminRepository;
import mingu.spring.clean.usecase.admin.CreateAdminUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminUseCase {

    @Bean
    public CreateAdminUseCase createAdminUseCase(AdminRepository adminRepository) {
        AdminGateway adminGateway = new AdminDatabaseGateway(adminRepository);
        return new CreateAdminUseCase(adminGateway);
    }
}
