package hw002.company.exception;

public class InvalidHighException extends Exception{

    public InvalidHighException(String message) {
    }

    public InvalidHighException(String message, Throwable cause) {
        super(message, cause);
    }
}
