package se.kth.iv1350.POS.model;

/**
 * An interface for classes that want to be notified when the total revenue
 * changes.
 */
public interface RegisterRevenueObserver {
    void UpdateTotalRevenue(double totalRevenue);
}
