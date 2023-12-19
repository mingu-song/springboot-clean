package mingu.spring.clean.entity.rentalCompany.exception;

public class RentalCompanyNotFoundException extends Exception {
    public RentalCompanyNotFoundException() {
        super("Rental company not found!!");
    }
}
