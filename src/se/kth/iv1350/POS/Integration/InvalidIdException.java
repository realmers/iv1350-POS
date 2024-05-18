package se.kth.iv1350.POS.Integration;

public class InvalidIdException extends Exception {

    /**
     * Constructs a new InvalidIdException with the specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidIdException(String msg) {
        super(msg);
    }

    /**
     * Constructs a new InvalidIdException with the specified detail message and cause.
     *
     * @param message the detail message.
     * @param cause   the cause of the exception.
     */
    public InvalidIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
