package mingu.spring.clean.entity.rentalCompany.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mingu.spring.clean.entity.rental.model.Rental;
import mingu.spring.clean.entity.user.model.User;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
public class RentalCompany extends User {
    private String cnpj;
    private String city;
    private List<Rental> rentals;

    public RentalCompany() {
        this.role = "ROLE_RENTALCOMPANY";
    }

    public RentalCompany(String username, String password, String name, String email, String cnpj, String city) {
        super(username, password, name, email);
        this.city = city;
        this.cnpj = cnpj;
        this.role = "ROLE_RENTALCOMPANY";
    }
}
