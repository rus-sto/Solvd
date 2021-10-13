package hw002.company.exception;

public class InvalidSizeException extends Exception{

    public InvalidSizeException(String message) {
        super(message);
    }

    public InvalidSizeException(String message, Throwable cause) {
        super(message, cause);
    }
}
