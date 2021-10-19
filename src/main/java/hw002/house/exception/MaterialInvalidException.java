package hw002.house.exception;

public class MaterialInvalidException extends RuntimeException {

    public MaterialInvalidException(String message) {
        super(message);
    }

    public MaterialInvalidException(String message, Throwable cause) {
        super(message, cause);
    }
}
