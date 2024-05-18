package se.kth.iv1350.POS.Integration;

import se.kth.iv1350.POS.model.DTO.SaleDto;

public class Register {

    private double _cashInRegister = 0;

    /**
     * This method is used to update the register with the total price of the sale.
     *
     * @param saleDto A Dto of class Sale
     * @return double The total amount of cash in the register
     */
    public double UpdateRegister(SaleDto saleDto) {

        _cashInRegister += saleDto.GetTotalPrice();
        return _cashInRegister;
    }

}
