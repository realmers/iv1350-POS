package se.kth.iv1350.POS.tests;

import se.kth.iv1350.POS.model.Sale;
import se.kth.iv1350.POS.model.DTO.ItemDto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SaleTest {
    private Sale _sale;
    private ItemDto _item;

    @BeforeEach
    void setUp() {
        _sale = new Sale();
        _item = new ItemDto("123", 100.0, "Chocolate Bar", 0.25, 1);
    }

    @Test
    void RegisterSoldItem() {
        String expectedDescription = "Item name: Chocolate Bar\nItem cost: 100:00 SEK\nRunning total: 100:00 SEK\n";
        String result = _sale.RegisterSoldItem(_item, _item.GetQuantity());
        assertEquals(expectedDescription, result);
    }

    @Test
    void GetTotalPrice() {
        _sale.RegisterSoldItem(_item, _item.GetQuantity());
        double expectedTotalPrice = 125.0;
        assertEquals(expectedTotalPrice, _sale.GetTotalPrice());
    }

    @Test
    void TestException(){
        assertThrows(IllegalArgumentException.class, () -> _sale.RegisterSoldItem(null, 1));
        assertThrows(IllegalArgumentException.class, () -> _sale.RegisterSoldItem(_item, 0));
    }

    @Test
    void GetListOfCurrentItemsInSale() {
        _sale.RegisterSoldItem(_item, _item.GetQuantity());
        assertEquals(1, _sale.GetListOfCurrentItemsInSale().size());
        assertEquals(_item.GetItemId(), _sale.GetListOfCurrentItemsInSale().getFirst().GetItemId());
    }

    @Test
    void GetVatAmountInCurrency() {
        _sale.RegisterSoldItem(_item, _item.GetQuantity());
        double expectedVat = 25.0;
        assertEquals(expectedVat, _sale.GetVatAmountInCurrency());
    }
}