package mingu.spring.clean.entity.customer.exception;

public class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException() {
        super("Customer not found!!");
    }
}
