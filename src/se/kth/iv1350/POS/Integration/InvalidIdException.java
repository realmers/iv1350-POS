package se.kth.iv1350.POS.Integration;

public class InvalidIdException extends Exception {
    public InvalidIdException(String msg) {
        super(msg);
    }

    public InvalidIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
