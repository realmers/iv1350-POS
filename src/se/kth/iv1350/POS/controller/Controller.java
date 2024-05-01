package se.kth.iv1350.POS.controller;

import se.kth.iv1350.POS.Integration.*;
import se.kth.iv1350.POS.model.Sale;
import se.kth.iv1350.POS.model.DTO.*;

/**
 * This is the application's only controller. All calls to the model pass through here.
 */

public class Controller {
    private Sale _sale;
    private final DbHandler _dbHandler;

    /**
     *
     * this method starts a new sale
     */
    public void InitSale() {
        _sale = new Sale();
    }

    /** 
     * this method registers an item
     * @param itemId the identifier of the item
     * @param quantity the quantity of the item
     * @return the item description
     * @throws InvalidIdException if the identifier is invalid
     */
    public String RegisterItemByIdAndQuantity(String itemId, int quantity) throws InvalidIdException {
        if (itemId == null || itemId.isEmpty()) {
            throw new InvalidIdException("Item ID cannot be null or empty.");
        }

        ItemDto item = _dbHandler.GetItemById(itemId);

        if (item == null) {
            throw new InvalidIdException("No item found with the provided ID.");
        }

        return _sale.RegisterSoldItem(item, quantity);
    }

    /**
     * this method gets the total price of the sale
     * @return the total price of the sale
     */
    public double GetTotalPrice() {
        return _sale.GetTotalPrice();
    }

    public double GetVatAmountInCurrency() {
        return _sale.GetVatAmountInCurrency();
    }

    /**
     * this method concludes the sale
     * @param paidAmount the amount paid by the customer
     */
    public void Conclude(double paidAmount) {
        _sale.SetMoneyPaid(paidAmount);
        SaleDto saleDto = new SaleDto(_sale);
        _dbHandler.FakeLogSale(saleDto);
        _dbHandler.PrintTheReceipt(saleDto);
    }

    /**
     *
     * @param dbHandler handles the data base calls
     */
    public Controller(DbHandler dbHandler) {

        _dbHandler = dbHandler;
    }
}
