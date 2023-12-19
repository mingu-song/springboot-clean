package mingu.spring.clean.infrastructure.config.db.schema;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mingu.spring.clean.entity.rental.model.Rental;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Rental", uniqueConstraints = @UniqueConstraint(columnNames = {"hour", "date", "customer_id"}))
public class RentalSchema extends AbstractEntitySchema<Long> {
    @NotNull
    @Column(nullable = false, columnDefinition = "Time", name = "hour")
    private LocalTime hour;

    @NotNull
    @Column(nullable = false, columnDefinition = "Date", name = "date")
    private LocalDate date;

    @NotNull(message = "{NotNull.rental.rentaCompany}")
    @ManyToOne
    @JoinColumn(name = "rentalCompany_id")
    private RentalCompanySchema rentalCompany;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerSchema customer;

    public RentalSchema(Rental rental) {
        this.hour = rental.getHour();
        this.date = rental.getDate();
        this.rentalCompany = new RentalCompanySchema(rental.getRentalCompany());
        this.customer = new CustomerSchema(rental.getCustomer());
    }

    public Rental toRental() {
        Rental rental = new Rental(this.hour, this.date, this.rentalCompany.toRentalCompany(), this.customer.toCustomer());
        rental.setId(this.getId());
        return rental;
    }
}
