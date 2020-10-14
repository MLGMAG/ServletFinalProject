package ua.kpi.iasa.ServletWebMarket.exception;

public class PasswordsMatchException extends RegistrationException {
    public PasswordsMatchException() {
        super("Passwords not match!");
    }
}
