package se.kth.iv1350.POS.view;

import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.controller.RegistrationException;
import se.kth.iv1350.POS.model.DTO.ItemDto;
import se.kth.iv1350.POS.utils.ErrorHandler;
import se.kth.iv1350.POS.utils.FileLogger;
import se.kth.iv1350.POS.utils.TotalRevenueLogger;

/**
 * this class is a placeholder for the real view, it contains calls to all
 * system operations in the controller.
 */
public class View {
    private Controller _controller;
    private ErrorHandler _errorMsgHandler = ErrorHandler.GetErrorMessageHandler();
    private FileLogger _fileLogger = new FileLogger("Exceptions");
    private TotalRevenueLogger _totalRevenueLogger = new TotalRevenueLogger("TotalRevenue");
    private TotalRevenueView totalRevenueView;

    /**
     * creates a new instance of the view.
     * 
     * @param controller the controller that is used for all operations.
     */

    public View(Controller controller) {

        _controller = controller;
        totalRevenueView = new TotalRevenueView();

    }

    /**
     * preform a fake sale by calling all the system operation in the controller.
     */
    public void Execute() throws RegistrationException {
        startSale();
        AddFakeItems();
        concludeSale();
    }

    private void startSale() {
        _controller.InitSale();
        _controller.AddRegisterRevenueObserver(totalRevenueView);
        _controller.AddRegisterRevenueObserver(_totalRevenueLogger);
    }

    private void AddFakeItems() {
        try {
            System.out.println("itemID: 1");
            ItemDto item1 = _controller.RegisterItemByIdAndQuantity("1", 1);
            System.out.println("Item name: " + item1.GetDescription() + "\nItem cost: " + item1.GetCost() + " SEK\n");

            System.out.println("itemID: 1");
            ItemDto item2 = _controller.RegisterItemByIdAndQuantity("1", 1);
            System.out.println("Item name: " + item2.GetDescription() + "\nItem cost: " + item2.GetCost() + " SEK\n");

            System.out.println("itemID: 3");
            ItemDto item3 = _controller.RegisterItemByIdAndQuantity("3", 1);
            System.out.println("Item name: " + item3.GetDescription() + "\nItem cost: " + item3.GetCost() + " SEK\n");

        } catch (Exception exception) {
            _errorMsgHandler.PrintError(exception.getMessage());
            _fileLogger.Log(exception);
        }
    }

    private void concludeSale() {
        System.out.println("Cashier concludes sale.");
        try {
            System.out.println("Total is (incl VAT): " + _controller.GetTotalPrice() + " SEK.");
            System.out.println("VAT is: " + _controller.GetVatAmountInCurrency() + " SEK.\n");
            System.out.println("Customer pays: 6000.0 SEK");
            double currentTotal = _controller.concludeSaleAndReturnTotal(6000);
            System.out.println("Current total in register: " + currentTotal + " SEK\n");
            System.out.println(_controller.GetReceiptFromDbHandler());
            /*TEST TO SEE THAT TOTALREVENUEVIEW OBSERVES MULTIPLE SALES */
            // double currentTotal2 = _controller.concludeSaleAndReturnTotal(6000);
            // System.out.println("Current total in register: " + currentTotal2 + " SEK\n");
            // System.out.println(_controller.GetReceiptFromDbHandler());

        } catch (IllegalStateException exception) {
            _errorMsgHandler.PrintError("Sale have not started yet");
            _fileLogger.Log(exception);
        }

    }

}
