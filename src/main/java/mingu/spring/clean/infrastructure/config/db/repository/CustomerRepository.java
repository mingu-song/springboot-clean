package mingu.spring.clean.infrastructure.config.db.repository;

import mingu.spring.clean.infrastructure.config.db.schema.CustomerSchema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerSchema, Long> {
    Optional<CustomerSchema> findByCpf(String cpf);
}
