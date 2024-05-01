package se.kth.iv1350.POS.tests;

import se.kth.iv1350.POS.model.Item;
import se.kth.iv1350.POS.model.DTO.ItemDto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    private Item _item;

    @BeforeEach
    void setUp() {
        ItemDto itemDto = new ItemDto("001", 150.0, "Milk", 0.12, 2);
        _item = new Item(itemDto, itemDto.GetQuantity());
    }

    @Test
    void getItemId() {
        assertEquals("001", _item.GetItemId());
    }

    @Test
    void getCost() {
        assertEquals(150.0, _item.GetCost());
    }

    @Test
    void getVatInPercentage() {
        assertEquals(0.12, _item.GetVatInPercentage());
    }

    @Test
    void getQuantity() {
        assertEquals(2, _item.GetQuantity());
    }
}