package se.kth.iv1350.POS.startup;

import se.kth.iv1350.POS.Integration.DbHandler;
import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.controller.RegistrationException;
import se.kth.iv1350.POS.view.View;

/**
 * this class contains the main method that starts the entire application.
 */

public class Main {
    /**
     *
     * @param args no command line parameters are received by this method.
     */
    public static void main(String[] args) throws RegistrationException {
        DbHandler DbHandler = new DbHandler();
        Controller controller = new Controller(DbHandler);
        View view = new View(controller);
        view.Execute();
    }
}