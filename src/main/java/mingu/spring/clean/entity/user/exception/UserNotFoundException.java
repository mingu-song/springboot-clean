package mingu.spring.clean.entity.user.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("User is not found!");
    }
}
