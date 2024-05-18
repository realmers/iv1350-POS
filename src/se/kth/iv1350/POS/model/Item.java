package se.kth.iv1350.POS.model;


public class Item {

    private final String _itemId;
    private final double _cost;
    private final String _description;
    private final double _vatInPercentage;
    private int _quantity;

    /**
     * Creates a new instance of Item
     *
     * @param itemDto  the item to be converted to an Item
     * @param quantity the quantity of the item
     */
    public Item(se.kth.iv1350.POS.model.DTO.ItemDto itemDto, int quantity) {
        _itemId = itemDto.GetItemId();
        _cost = itemDto.GetCost();
        _description = itemDto.GetDescription();
        _vatInPercentage = itemDto.GetVatInPercentage();
        _quantity = quantity;
    }

    /**
     * @return the unique itemIdentifier
     */
    public String GetItemId() {
        return _itemId;
    }

    /**
     * @return the specific price of the product
     */
    public double GetCost() {
        return _cost;
    }

    /**
     * @return the itemDescription
     */
    public String GetDescription() {
        return _description;
    }

    /**
     * @return the VAT-rate for the item
     */
    public double GetVatInPercentage() {
        return _vatInPercentage;
    }

    /**
     * @return the quantity of the item
     */
    public int GetQuantity() {
        return _quantity;
    }

    /**
     * Sets the quantity of the item
     *
     * @param quantity the quantity of the item
     */
    public void SetCurrentQuantity(int quantity) {
        this._quantity = quantity;
    }

    public String FormattedOutput() {
        return "Products, " +
                "Price: " + _cost + "SEK" +
                ", Description: '" + _description + '\'' +
                ", VAT: " + _vatInPercentage +
                ", Quantity: " + _quantity + " ";
    }
}
