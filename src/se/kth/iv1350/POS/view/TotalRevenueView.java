package se.kth.iv1350.POS.view;

import se.kth.iv1350.POS.model.RegisterRevenueObserver;

public class TotalRevenueView implements RegisterRevenueObserver{

    @Override
    public void UpdateTotalRevenue(double revenue) {
        System.out.println("Revenue:" + revenue);
    }
    
}
