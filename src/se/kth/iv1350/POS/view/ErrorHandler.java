package se.kth.iv1350.POS.view;
import java.time.LocalDateTime;


/** 
 * This class is responsible for handling error messages.
 */
public class ErrorHandler {
    // singleton
    private static ErrorHandler s_errorMessageHandler = new ErrorHandler();
    LocalDateTime _localDateTimeNow = LocalDateTime.now();

    /**
     * @return the only instance of the class
     */
    public static ErrorHandler GetErrorMessageHandler() {
        return s_errorMessageHandler;
    }

    /**
     * @return the current local date and time
     */
    public String GetLocalDateTimeNow() {
        return _localDateTimeNow.toString();
    }

    /**
     * Prints the specified error message.
     * 
     * @param error the error message that will be printed.
     */
    public void PrintError(String error) {
        System.err.println(error);
    }
}
