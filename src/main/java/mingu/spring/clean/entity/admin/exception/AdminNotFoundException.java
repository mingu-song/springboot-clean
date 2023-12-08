package mingu.spring.clean.entity.admin.exception;

public class AdminNotFoundException extends Exception {
    public AdminNotFoundException() {
        super("Admin is not found!");
    }
}
