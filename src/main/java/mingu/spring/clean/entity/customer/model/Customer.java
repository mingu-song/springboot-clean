package mingu.spring.clean.entity.customer.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mingu.spring.clean.entity.rental.model.Rental;
import mingu.spring.clean.entity.user.model.User;

import java.time.LocalDate;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class Customer extends User {
    private String cpf;
    private String phoneNumber;
    private Sex sex;
    private LocalDate birthdate;
    private List<Rental> rentals;

    public Customer(String username, String password, String name, String email, String cpf, String phoneNumber, Sex sex, LocalDate birthdate) {
        super(username, password, name, email);
        this.cpf = cpf;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.birthdate = birthdate;
    }

    public Customer() {
        this.role = "ROLE_CUSTOMER";
    }
}
