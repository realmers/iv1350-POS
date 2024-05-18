package se.kth.iv1350.POS.Integration;

import se.kth.iv1350.POS.model.DTO.SaleDto;

public class Printer {
    /**
     * Prints out the receipt.
     *
     * @param saleDTO The sale data transfer object.
     * @return The receipt.
     */
    public String PrintOut(SaleDto saleDTO) {
        return saleDTO.GetReceipt();
    }
}
