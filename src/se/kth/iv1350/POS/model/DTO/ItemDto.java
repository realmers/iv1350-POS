package se.kth.iv1350.POS.model.DTO;

public class ItemDto {

    private final String _itemId;
    private final double _cost;
    private final String _description;
    private final double _vatInPercentage;
    private final int _quantity;

    /**
     * Creates a new instance of ItemDto
     *
     * @param itemId        the unique itemIdentifier
     * @param cost          the specific price of the product
     * @param description   the itemDescription
     * @param vatInPercentage the VAT-rate for the item
     * @param quantity      the quantity sold
     */
    public ItemDto(String itemId, double cost, String description, double vatInPercentage, int quantity) {
        _itemId = itemId;
        _cost = cost;
        _description = description;
        _vatInPercentage = vatInPercentage;
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

}
