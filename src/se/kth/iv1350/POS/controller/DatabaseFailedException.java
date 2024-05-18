package se.kth.iv1350.POS.controller;

/**
 * Throws exception when controller can't connect to fake database.
 */
public class DatabaseFailedException extends Exception {
    /**
     * Constructs a new DatabaseFailedException with the specified detail message
     * and cause.
     *
     * @param msg   the detail message.
     * @param cause the cause of the exception.
     */
    public DatabaseFailedException(String msg, Throwable cause) {
        super(msg, cause);
    }
}