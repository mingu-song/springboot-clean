package mingu.spring.clean.entity.rental.exception;

public class RentalNotFoundException extends Exception {
    public RentalNotFoundException() {
        super("Rental not found!");
    }
}
