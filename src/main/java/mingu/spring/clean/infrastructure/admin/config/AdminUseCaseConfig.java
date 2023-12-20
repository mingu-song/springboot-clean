package mingu.spring.clean.infrastructure.admin.config;

import mingu.spring.clean.entity.admin.gateway.AdminGateway;
import mingu.spring.clean.infrastructure.admin.gateway.AdminDatabaseGateway;
import mingu.spring.clean.infrastructure.config.db.repository.AdminRepository;
import mingu.spring.clean.usecase.admin.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminUseCaseConfig {

    @Bean
    public AdminGateway adminGateway(AdminRepository adminRepository) {
        return new AdminDatabaseGateway(adminRepository);
    }

    @Bean
    public CreateAdminUseCase createAdminUseCase(AdminGateway adminGateway) {
        return new CreateAdminUseCase(adminGateway);
    }

    @Bean
    public GetAdminUseCase getAdminUseCase(AdminGateway adminGateway) {
        return new GetAdminUseCase(adminGateway);
    }

    @Bean
    public SearchAdminUseCase searchAdminUseCase(AdminGateway adminGateway) {
        return new SearchAdminUseCase(adminGateway);
    }

    @Bean
    public UpdateAdminUseCase updateAdminUseCase(AdminGateway adminGateway) {
        return new UpdateAdminUseCase(adminGateway);
    }

    @Bean
    public DeleteAdminUseCase deleteAdminUseCase(AdminGateway adminGateway) {
        return new DeleteAdminUseCase(adminGateway);
    }
}
