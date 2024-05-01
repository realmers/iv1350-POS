package se.kth.iv1350.POS.Integration;

import se.kth.iv1350.POS.model.DTO.SaleDto;


public class Register {

    private double _cashInRegister = 0;

    public void UpdateRegister(SaleDto saleDto) {

        _cashInRegister += saleDto.GetTotalPrice();
        System.out.println("Current total in register: " + _cashInRegister + " SEK");
    }

}
