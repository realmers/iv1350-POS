package se.kth.iv1350.POS.controller;

import se.kth.iv1350.POS.Integration.*;
import se.kth.iv1350.POS.model.RegisterRevenueObserver;
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
    public ItemDto RegisterItemByIdAndQuantity(String itemId, int quantity) throws InvalidIdException, DatabaseFailedException {
        if (itemId == null || itemId.isEmpty()) {
            throw new InvalidIdException("Item ID cannot be null or empty.");
        }

        if(itemId == "1350"){
            throw new DatabaseFailedException("Database connection failed", new Throwable("Database connection failed"));
        }

        ItemDto item = _dbHandler.GetItemById(itemId);

        if (item == null) {
            throw new InvalidIdException("No item found with the provided ID.");
        }
        _sale.RegisterSoldItem(item, quantity);

        return item;
    }

    /**
     * this method gets the total price of the sale
     * @return the total price of the sale
     */
    public double GetTotalPrice() {
        return _sale.GetTotalPrice();
    }

    /**
     * this method gets the total price of the sale in a specific currency
     * @return the total price of the sale in a specific currency
     */
    public double GetVatAmountInCurrency() {
        return _sale.GetVatAmountInCurrency();
    }

    /**
     * this method concludes the sale
     * @param paidAmount the amount paid by the customer
     */
    public double concludeSaleAndReturnTotal(double paidAmount) {
        _sale.SetMoneyPaid(paidAmount);
        SaleDto saleDto = new SaleDto(_sale);
        double currentTotal = _dbHandler.FakeLogSale(saleDto);
        return currentTotal;
    }

    /**
     * this method gets the receipt from the database handler
     * @return the receipt
     */
    public String GetReceiptFromDbHandler(){
        SaleDto saleDto = new SaleDto(_sale);
        
        return _dbHandler.PrintTheReceipt(saleDto);
    }

    /**
     * this method adds a register revenue observer
     * @param observer the observer to be added
     */
    public void AddRegisterRevenueObserver(RegisterRevenueObserver observer) {
        _sale.AddRegisterRevenueObserver(observer);
    }

    /**
     *
     * @param dbHandler handles the data base calls
     */
    public Controller(DbHandler dbHandler) {

        _dbHandler = dbHandler;
    }
}
