package se.kth.iv1350.POS.Integration;

import se.kth.iv1350.POS.model.Sale;
import se.kth.iv1350.POS.model.DTO.SaleDto;


public class ExternalAccountingSystem {
    // store the sale information in the external accounting system
    public void FakeStoringSaleInformation(Sale sale) {
        // System.out.println("Storing sale information");
    }
    // log the sale in the external accounting system
    public void FakeLogSale(SaleDto saleDto) {
        // System.out.println("Logging sale information");
    }
}
