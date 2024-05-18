package se.kth.iv1350.POS.tests;

import se.kth.iv1350.POS.Integration.DbHandler;
import se.kth.iv1350.POS.Integration.InvalidIdException;
import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.controller.DatabaseFailedException;
import se.kth.iv1350.POS.model.Sale;
import se.kth.iv1350.POS.model.DTO.ItemDto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {
    DbHandler DbHandler = new DbHandler();
    Controller _controller = new Controller(DbHandler);

    @BeforeEach
    void setUp() {
        _controller.InitSale();
    }

    @Test
    void RegisterItemByIdAndQuantityInvalidIdException() {
        assertThrows(InvalidIdException.class, () -> _controller.RegisterItemByIdAndQuantity(null, 1));
        assertThrows(InvalidIdException.class, () -> _controller.RegisterItemByIdAndQuantity("", 1));
    }
    @Test
    void RegisterItemByIdAndQuantityDatabaseFailedException() {
        assertThrows(DatabaseFailedException.class, () -> _controller.RegisterItemByIdAndQuantity("1350", 1));
    }

}
