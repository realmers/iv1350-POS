package se.kth.iv1350.POS.view;

import se.kth.iv1350.POS.model.RegisterRevenueObserver;

public class TotalRevenueView implements RegisterRevenueObserver {
    private double totalRevenue;

    @Override
    public void UpdateTotalRevenue(double revenue) {
        totalRevenue += revenue;
        System.out.println("Total Revenue: " + totalRevenue);
    }
}