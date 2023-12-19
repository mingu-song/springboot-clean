package mingu.spring.clean.entity.rental.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import mingu.spring.clean.entity.AbstractEntity;
import mingu.spring.clean.entity.customer.model.Customer;
import mingu.spring.clean.entity.rentalCompany.model.RentalCompany;

import java.time.LocalDate;
import java.time.LocalTime;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class Rental extends AbstractEntity<Long> {
    private LocalTime hour;
    private LocalDate date;
    private RentalCompany rentalCompany;
    private Customer customer;
}
