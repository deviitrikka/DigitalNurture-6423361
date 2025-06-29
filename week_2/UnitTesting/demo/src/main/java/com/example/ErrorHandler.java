package com.example;

public class ErrorHandler {
    private Logger logger;

    public ErrorHandler(Logger logger) {
        this.logger = logger;
    }

    public void handle(String message) {
        try {
            logger.logError(message);
        } catch (RuntimeException ex) {
            System.out.println("Logging failed: " + ex.getMessage());
        }
    }
}
