package se.kth.iv1350.POS.Integration;

import se.kth.iv1350.POS.controller.DatabaseFailedException;
import se.kth.iv1350.POS.model.DTO.ItemDto;


public class ExternalInventorySystem {

    private ItemDto[] _inventory = new ItemDto[5];
    private void PopulateInventory() {
        _inventory[0] = new ItemDto("1", 1200, "Bregott", 0.25F, 0);
        _inventory[1] = new ItemDto("2", 50, "Bread", 0.25F, 0);
        _inventory[2] = new ItemDto("3", 600, "Some book", 0.25F, 0);
        _inventory[3] = new ItemDto("4", 12, "Wheat", 0.25F, 0);
        _inventory[4] = new ItemDto("5", 10, "Arla milk", 0.25F, 0);
    }

    /**
     * Constructor for the ExternalInventorySystem class
     */
    public ExternalInventorySystem() {
        PopulateInventory();
    }

    /**
     * This method is used to retrieve an item from the inventory based on its
     * identifier.
     *
     * @param itemId A String that represents the unique identifier of the item.
     * @return ItemDTO An object that represents the item data.
     * @throws InvalidIdException If the item identifier does not exist in the inventory.
     * @throws DatabaseFailedException If the system could not reach the database.
     */
    public ItemDto GetItemById(String itemId) throws InvalidIdException, DatabaseFailedException {
        if (itemId == null || itemId.equals("")) {
            throw new InvalidIdException("Invalid item identifier");
        }

        // Simulate database connectivity issue
        if (Math.random() < 0.001) { // 0.1% chance to simulate a database failure
            throw new DatabaseFailedException("Database connectivity issue occurred while retrieving item.", new Throwable("Database connectivity issue occurred while retrieving item."));
        }

        for (int i = 0; i < _inventory.length; i++) {
            if (_inventory[i].GetItemId().equals(itemId)) {
                return _inventory[i];
            }
        }

        throw new InvalidIdException("The item Identifier: " + itemId + " does not exist in the inventory");
    }

    /**
     * This method is used to retrieve the entire inventory as an array of ItemDTO
     * objects.
     *
     * @return ItemDto[] An array that represents the entire inventory.
     * @throws DatabaseFailedException If the system could not reach the database.
     */
    public ItemDto[] GetInventoryArray() throws DatabaseFailedException {
        // Simulate database connectivity issue
        if (Math.random() < 0.001) { // 0.1% chance to simulate a database failure
            throw new DatabaseFailedException("Database connectivity issue occurred while retrieving inventory.", new Throwable("Database connectivity issue occurred while retrieving inventory."));
        }
        return _inventory;
    }
}
