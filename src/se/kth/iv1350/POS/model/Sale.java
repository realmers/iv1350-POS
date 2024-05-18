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
    private double _revenue = 0;
    private double _moneyPaid = 0;

    private ArrayList<RegisterRevenueObserver> _registerRevenueObservers = new ArrayList<>();

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
     * @return Return a copy of the list of items and not the actual list!!!
     */
    public ArrayList<Item> GetListOfCurrentItemsInSale() {
        return new ArrayList<>(_itemList);
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
        _moneyPaid = moneyPaid;
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
        _revenue = _moneyPaid - (_currentTotal + _vatAmountInCurrency);
        NotifyObservers();
        return _revenue;
    }

    /**
     * @return the item formatted
     */
    private String ConsoleOutput(ItemDto item) {
        return "Item name: " + item.GetDescription() + "\nItem cost: " + item.GetCost() + " SEK\n"
                + "Running total: " + GetCurrentTotal() + " SEK\n";
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

    /**
     * Adds an observer to the list of observers
     *
     * @param observer the observer to be added
     */
    public void AddRegisterRevenueObserver(RegisterRevenueObserver observer) {
        _registerRevenueObservers.add(observer);
    }

    private void NotifyObservers() {
        for (int i = 0; i < _registerRevenueObservers.size(); i++) {
            _registerRevenueObservers.get(i).UpdateTotalRevenue(_revenue);
        }
    }
}
