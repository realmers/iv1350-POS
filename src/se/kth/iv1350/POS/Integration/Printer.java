package se.kth.iv1350.POS.Integration;

import se.kth.iv1350.POS.model.DTO.SaleDto;

public class Printer {
    public void PrintOut(SaleDto saleDTO) {
        System.out.println(saleDTO.GetReceipt());
    }
}
