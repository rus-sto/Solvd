package hw002.company.exception;

public class InvalidWallsException extends RuntimeException{

    public InvalidWallsException(String message) {
        super(message);
    }

    public InvalidWallsException(String message, Throwable cause) {
        super(message, cause);
    }
}
