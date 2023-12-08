package mingu.spring.clean.infrastructure.config.db.repository;

import mingu.spring.clean.infrastructure.config.db.schema.AdminSchema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminSchema, Long> {
}
