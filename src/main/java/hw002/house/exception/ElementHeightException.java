package hw002.house.exception;

public class ElementHeightException extends RuntimeException{

    public ElementHeightException(String message) {
        super(message);
    }

    public ElementHeightException(String message, Throwable cause) {
        super(message, cause);
    }
}
