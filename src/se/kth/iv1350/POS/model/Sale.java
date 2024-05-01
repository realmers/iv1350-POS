package se.kth.iv1350.POS.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import se.kth.iv1350.POS.model.DTO.ItemDto;

/**
 * represents one sale.
 */
public class Sale {
    private final Receipt _receipt;
    private final String _formattedDate;
    private final ArrayList<Item> _itemList = new ArrayList<>();
    private double _vatAmountInCurrency = 0;
    private double _currentTotal = 0;
    private double _moneyPaid = 0;

    /**
     * creates a new instance
     */
    public Sale() {
        LocalDateTime _salesLocalDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        _formattedDate = _salesLocalDateTime.format(formatter);
        _receipt = new Receipt(this);
    }

    /**
     * Registers a sold item
     *
     * @param item     the item to be added
     * @param quantity the amount of the item
     * @return the item description
     */
    public String RegisterSoldItem(ItemDto item, int quantity) {
        if (item == null || quantity <= 0) {
            throw new IllegalArgumentException("Item cannot be null and quantity must be greater than zero.");
        }

        if (DoesItemExist(item)) {
            // add quantity
            for (int i = 0; i < _itemList.size(); i++) {
                Item value = _itemList.get(i);
                if (value.GetItemId().equals(item.GetItemId())) {
                    value.SetCurrentQuantity(value.GetQuantity() + quantity);
                }
            }
        } else {
            _itemList.add(new Item(item, quantity));
        }

        double itemTotalPrice = item.GetCost() * quantity;
        _currentTotal += itemTotalPrice;
        _vatAmountInCurrency += itemTotalPrice * item.GetVatInPercentage();

        return ConsoleOutput(item);
    }

    /**
     * @return the total cost of the sale
     */
    public double GetTotalPrice() {
        return _currentTotal + _vatAmountInCurrency;
    }

    /**
     * @return the list of items formatted to string
     */ 
    public String GetAllItemsFormatted() {
        StringBuilder sb = new StringBuilder();
        for (Item item : _itemList) {
            sb.append(item.FormattedOutput());
        }
        return sb.toString();
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
    public Receipt GetReceipt() {
        return _receipt;
    }

    /**
     * @return the running total
     */
    public double GetCurrentTotal() {
        return _currentTotal;
    }

    /**
     * @return the running total formatted
     */
    public String GetRunningTotalFormatted() {
        int wholePart = (int) _currentTotal;
        int decimalPart = (int) ((_currentTotal - wholePart) * 100);
        return String.format("%02d:%02d", wholePart, decimalPart);
    }

    /**
     * @return the amount customer pays
     */
    public double GetMoneyPaid() {
        return _moneyPaid;
    }

    /**
     * Sets the amount paid by the customer
     *
     * @param moneyPaid the amount paid
     */
    public void SetMoneyPaid(double moneyPaid) {
        this._moneyPaid = moneyPaid;
    }

    /**
     * @return the vat amount in currency
     */
    public double GetVatAmountInCurrency() {
        return _vatAmountInCurrency;
    }

    /**
     * @return the change
     */
    public double GetChange() {
        return _moneyPaid - (_currentTotal + _vatAmountInCurrency);
    }

    /**
     * @return the item formatted
     */
    private String ConsoleOutput(ItemDto item) {
        return "Item name: " + item.GetDescription() + "\nItem cost: " + item.GetFormattedPrice() + " SEK\n"
                + "Running total: " + GetRunningTotalFormatted() + " SEK\n";

    }

    /**
     * Checks if the item exists
     *
     * @param item the item to be checked
     * @return true if the item exists
     */
    private boolean DoesItemExist(ItemDto item) {
        for (int i = 0; i < _itemList.size(); i++) {
            if (_itemList.get(i).GetItemId().equals(item.GetItemId())) {
                return true;
            }
        }
        return false;
    }

}
