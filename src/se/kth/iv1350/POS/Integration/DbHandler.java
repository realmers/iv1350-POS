package se.kth.iv1350.POS.Integration;

import se.kth.iv1350.POS.model.DTO.ItemDto;
import se.kth.iv1350.POS.model.DTO.SaleDto;

public class DbHandler {
    private ExternalInventorySystem _externalInventorySystem;
    private ExternalAccountingSystem _externalAccountingSystem;
    private Register _register;
    private Printer _printer;

    /**
     * Constructor for the DbHandler class
     */
    public DbHandler() {
        _printer = new Printer();
        _externalInventorySystem = new ExternalInventorySystem();
        _register = new Register();
        _externalAccountingSystem = new ExternalAccountingSystem();
    }

    /**
     * This method is used to retrieve an item from the inventory based on its
     * identifier.
     *
     * @param itemId A String that represents the unique identifier of the
     *               item.
     * @return ItemDTO An object that represents the item data.
     * @throws InvalidIdException If the item identifier does not exist in
     *                            the inventory.
     */
    public ItemDto GetItemById(String itemId) throws InvalidIdException {
        return _externalInventorySystem.GetItemById(itemId);
    }

    /**
     * This method is used to log a sale in the external accounting system.
     *
     * @param saleDto A Dto of class Sale
     */
    public void FakeLogSale(SaleDto saleDto) {
        _externalAccountingSystem.FakeLogSale(saleDto);
        _register.UpdateRegister(saleDto);

    }

    /**
     * This method is used to print out a receipt.
     *
     * @param saleDTO A Dto of class Sale
     */
    public void PrintTheReceipt(SaleDto saleDTO) {
        _printer.PrintOut(saleDTO);
    }
}
