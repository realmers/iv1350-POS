package se.kth.iv1350.POS.tests;

import se.kth.iv1350.POS.model.Sale;
import se.kth.iv1350.POS.model.DTO.ItemDto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SaleTest {
    private Sale _sale;
    private ItemDto _itemDto;

    @BeforeEach
    void setUp() {
        _sale = new Sale();
        _itemDto = new ItemDto("123", 100.0, "Chocolate Bar", 0.25, 1);
    }

    @Test
    void registerSoldItem() {
        String expectedDescription = "Item name: Chocolate Bar\nItem cost: 100:00 SEK\nRunning total: 100:00 SEK\n";
        String result = _sale.RegisterSoldItem(_itemDto, _itemDto.GetQuantity());
        assertEquals(expectedDescription, result);
    }

    @Test
    void getTotalPrice() {
        _sale.RegisterSoldItem(_itemDto, _itemDto.GetQuantity());
        double expectedTotalPrice = 125.0;
        assertEquals(expectedTotalPrice, _sale.GetTotalPrice());
    }

    @Test
    void getListOfCurrentItemsInSale() {
        _sale.RegisterSoldItem(_itemDto, _itemDto.GetQuantity());
        assertEquals(1, _sale.GetListOfCurrentItemsInSale().size());
        assertEquals(_itemDto.GetItemId(), _sale.GetListOfCurrentItemsInSale().getFirst().GetItemId());
    }

    @Test
    void getVatAmountInCurrency() {
        _sale.RegisterSoldItem(_itemDto, _itemDto.GetQuantity());
        double expectedVat = 25.0;
        assertEquals(expectedVat, _sale.GetVatAmountInCurrency());
    }
}