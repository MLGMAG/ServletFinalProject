package ua.kpi.iasa.ServletWebMarket.exception;

public class DuplicateUsernameException extends RegistrationException {

    public DuplicateUsernameException() {
        super("User with that username exist!");
    }
}
