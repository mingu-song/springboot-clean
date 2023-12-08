package mingu.spring.clean.entity.admin.gateway;

import mingu.spring.clean.entity.admin.model.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminGateway {
    Admin create(Admin admin);
    Admin update(Admin admin);
    void delete(Long id);

    Optional<Admin> findById(Long id);
    List<Admin> findAll();
}
