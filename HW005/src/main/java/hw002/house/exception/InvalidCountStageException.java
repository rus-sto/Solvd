package hw002.house.exception;

public class InvalidCountStageException extends Exception {

    public InvalidCountStageException(String message) {
        super(message);
    }

    public InvalidCountStageException(String message, Throwable cause) {
        super(message, cause);
    }
}
