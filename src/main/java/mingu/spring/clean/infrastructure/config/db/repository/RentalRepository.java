package mingu.spring.clean.infrastructure.config.db.repository;

import jakarta.validation.constraints.NotNull;
import mingu.spring.clean.infrastructure.config.db.schema.CustomerSchema;
import mingu.spring.clean.infrastructure.config.db.schema.RentalCompanySchema;
import mingu.spring.clean.infrastructure.config.db.schema.RentalSchema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<RentalSchema, Long> {
    List<RentalSchema> findAllByRentalCompany(@NotNull(message = "{NotNull.rental.rentalCompany}") RentalCompanySchema rentalCompany);

    List<RentalSchema> findAllByCustomer(@NotNull CustomerSchema customer);
}
