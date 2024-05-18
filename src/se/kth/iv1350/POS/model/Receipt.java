package se.kth.iv1350.POS.model;


/**
 * Represents a receipt for sale.
 */
public class Receipt {

     private final Sale _currentSale;

     /**
      * Creates a new Receipt instance.
      *
      * @param currentSale The Sale object for this receipt.
      */
     public Receipt(Sale currentSale) {
          _currentSale = currentSale;
     }

     /**
      * Prints the receipt.
      * The receipt includes the date and time of the sale, the list of items,
      * the total cost, the VAT, the amount paid by the customer, and the change.
      *
      * @return A string representing the receipt.
      */
     public String PrintReceipt() {
          return "Begin receipt" +
                    "\nTime of Sale: " + _currentSale.GetSalesLocalDateTime() + "\n" +
                    "\nItems: " + _currentSale.GetAllItemsFormatted() + "`\n" +
                    "\nTotal: " + _currentSale.GetCurrentTotal() + "SEK + " + _currentSale.GetVatAmountInCurrency() + "SEK VAT" + " = " + _currentSale.GetTotalPrice() + "SEK \n" +
                    "\nCustomer payment total " + _currentSale.GetMoneyPaid() + "SEK \n" +
                    "\nChange to give to customer: " + _currentSale.GetChange() + "SEK";
     }
}
