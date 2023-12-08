package mingu.spring.clean.infrastructure.admin.gateway;

import lombok.RequiredArgsConstructor;
import mingu.spring.clean.entity.admin.gateway.AdminGateway;
import mingu.spring.clean.entity.admin.model.Admin;
import mingu.spring.clean.infrastructure.config.db.repository.AdminRepository;
import mingu.spring.clean.infrastructure.config.db.schema.AdminSchema;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminDatabaseGateway implements AdminGateway {

    private final AdminRepository adminRepository;

    @Override
    public Admin create(Admin admin) {
        return this.adminRepository.save(new AdminSchema(admin)).toAdmin();
    }

    @Override
    public Admin update(Admin admin) {
        return this.adminRepository.save(new AdminSchema(admin)).toAdmin();
    }

    @Override
    public void delete(Long id) {
        this.adminRepository.deleteById(id);
    }

    @Override
    public Optional<Admin> findById(Long id) {
        return adminRepository.findById(id).map(AdminSchema::toAdmin);
    }

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll().stream().map(AdminSchema::toAdmin).toList();
    }
}
