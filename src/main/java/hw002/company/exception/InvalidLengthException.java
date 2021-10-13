package hw002.company.exception;

public class InvalidLengthException extends Exception {

    public InvalidLengthException(String message) {
        super(message);
    }

    public InvalidLengthException(String message, Throwable cause) {
        super(message, cause);
    }
}
