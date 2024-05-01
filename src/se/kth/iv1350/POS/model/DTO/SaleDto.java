package se.kth.iv1350.POS.model.DTO;

import java.util.ArrayList;

import se.kth.iv1350.POS.model.Item;
import se.kth.iv1350.POS.model.Receipt;
import se.kth.iv1350.POS.model.Sale;

public class SaleDto {
    private Receipt _receipt;
    private ArrayList<Item> _itemList;
    private String _formattedDate;
    private double _vatAmountInCurrency;
    private double _currentTotal;
    private double _moneyPaid;

    /**
     * Creates a new instance of SaleDto
     *
     * @param sale the sale to be converted to a SaleDto
     */
    public SaleDto(Sale sale) {
        _itemList = sale.GetListOfCurrentItemsInSale();
        _formattedDate = sale.GetSalesLocalDateTime();
        _receipt = sale.GetReceipt();
        _currentTotal = sale.GetCurrentTotal();
        _moneyPaid = sale.GetMoneyPaid();
        _vatAmountInCurrency = sale.GetVatAmountInCurrency();
    }

    /**
     * @return the total cost of the sale
     */
    public double GetTotalPrice() {
        return _currentTotal + _vatAmountInCurrency;
    }

    /**
     * @return the list of items
     */
    public ArrayList<Item> GetListOfCurrentItemsInSale() {
        return _itemList;
    }

    /**
     * @return the date and time of the sale
     */
    public String GetSalesLocalDateTime() {
        return _formattedDate;
    }

    /**
     * @return the receipt
     */
    public String GetReceipt() {
        return _receipt.PrintReceipt();
    }

    /**
     * @return the running total
     */
    public double GetCurrentTotal() {
        return _currentTotal;
    }

    /**
     * @return the amount customer pays
     */
    public double GetMoneyPaid() {
        return _moneyPaid;
    }

    /**
     * @return the vat amount in currency
     */
    public double GetVatAmountInCurrency() {
        return _vatAmountInCurrency;
    }

    /**
     * Sets the amount paid by the customer
     *
     * @param moneyPaid the amount paid
     */
    public void SetMoneyPaid(double moneyPaid) {
        _moneyPaid = moneyPaid;
    }
}
