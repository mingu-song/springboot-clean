package mingu.spring.clean.entity.rental.gateway;

import mingu.spring.clean.entity.customer.model.Customer;
import mingu.spring.clean.entity.rental.model.Rental;
import mingu.spring.clean.entity.rentalCompany.model.RentalCompany;

import java.util.List;
import java.util.Optional;

public interface RentalGateway {
    Rental create(Rental rental);
    void delete(Long id);

    Optional<Rental> findById(Long id);

    List<Rental> findAllByRentalCompany(RentalCompany rentalCompany);

    List<Rental> findAllByCustomer(Customer customer);

    List<Rental> findAll();
}
