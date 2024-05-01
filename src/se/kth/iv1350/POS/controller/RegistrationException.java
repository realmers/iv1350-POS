package se.kth.iv1350.POS.controller;


/**
 * This exception is thrown when there is an error during the registration process.
 */
public class RegistrationException extends Exception {

    /**
     * Constructs a new RegistrationException with the specified detail message and cause.
     *
     * @param msg   the detail message.
     * @param cause the cause of the exception.
     */
    public RegistrationException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
