package se.kth.iv1350.POS.view;

import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.controller.RegistrationException;

/**
 * this class is a placeholder for the real view, it contains calls to all
 * system operations in the controller.
 */
public class View {
    private Controller _controller;
    private ErrorHandler _errorMsgHandler = ErrorHandler.GetErrorMessageHandler();

    /**
     * creates a new instance of the view.
     * 
     * @param controller the controller that is used for all operations.
     */
    public View(Controller controller) {
        _controller = controller;
    }

    public void Execute() throws RegistrationException {
        Start();
        AddFakeItems();
        Conclude();
    }

    private void Start() {
        _controller.InitSale();
    }

    private void AddFakeItems() {
        try {
            System.out.println("itemID: 1");
            System.out.println(_controller.RegisterItemByIdAndQuantity("1", 1));

            System.out.println("itemID: 1");
            System.out.println(_controller.RegisterItemByIdAndQuantity("1", 1));

            System.out.println("itemID: 3");
            System.out.println(_controller.RegisterItemByIdAndQuantity("3", 1));
        } catch (Exception exception) {
            _errorMsgHandler.PrintError(exception.getMessage());
        }
    }

    private void Conclude() {
        System.out.println("Cashier concludes sale.");
        try {

            System.out.println("Total is (incl VAT): " + _controller.GetTotalPrice() + " SEK.");
            System.out.println("Total with VAT is: " + _controller.GetVatAmountInCurrency() + " SEK.\n");
            System.out.println("Customer pays: 6000.0 SEK");
            _controller.Conclude(6000);
        } catch (IllegalStateException exception) {
            _errorMsgHandler.PrintError("Sale have not started yet");
        }

    }

}
