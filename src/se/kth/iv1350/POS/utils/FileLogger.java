package se.kth.iv1350.POS.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class FileLogger {
    LocalDateTime _localDateTimeNow = LocalDateTime.now();
    private PrintWriter _fileWriter;
    private String _fileName;

    /**
     * Creates a new instance of the FileLogger
     * 
     * @param fileName the name of the file to log to
     */
    public FileLogger(String fileName) {
        _fileName = fileName;
        try {
            _fileWriter = new PrintWriter(new FileWriter(_fileName + ".log"), true);
        } catch (IOException exception) {
            System.out.println("Could not create log file");
            exception.printStackTrace();
        }
    } 

    /**
     * Logs an exception
     * 
     * @param exception the exception to log
     */
    public void Log(Exception exception) {
        StringBuilder logBuilder = new StringBuilder();
        logBuilder.append(exception.getMessage()).append("was thrown at: ").append(_localDateTimeNow);
        _fileWriter.println(logBuilder);
        exception.printStackTrace(_fileWriter);
    }

    /**
     * Logs a string
     * 
     * @param input the string to log
     */
    public void log(String input) {
        _fileWriter.println(input);
    }
}
