package hw002.company.exception;

public class InvalidStageException extends Exception {

    public InvalidStageException(String message) {
        super(message);
    }

    public InvalidStageException(String message, Throwable cause) {
        super(message, cause);
    }
}
