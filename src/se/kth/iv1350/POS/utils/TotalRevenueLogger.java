package se.kth.iv1350.POS.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import se.kth.iv1350.POS.model.RegisterRevenueObserver;

public class TotalRevenueLogger implements RegisterRevenueObserver {
    LocalDateTime _localDateTimeNow = LocalDateTime.now();
    private PrintWriter _fileWriter;
    private String _fileName;

    /**
     * Creates a new instance of the TotalRevenueLogger
     * 
     * @param fileName the name of the file to log to
     */
    public TotalRevenueLogger(String fileName) {
        _fileName = fileName;
        try {
            _fileWriter = new PrintWriter(new FileWriter(_fileName + ".log"), true);
        } catch (IOException exception) {
            System.out.println("Could not create log file");
            exception.printStackTrace();
        }
    }

    /**
     * Logs the total revenue
     * 
     * @param revenue the total revenue to log
     */

    @Override
    public void UpdateTotalRevenue(double revenue) {
        _fileWriter.println("Revenue:" + revenue);
    }
}