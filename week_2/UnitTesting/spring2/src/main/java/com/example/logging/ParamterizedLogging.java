package com.example.logging;

import org.slf4j.LoggerFactory;
import org.slf4j.*;

public class ParamterizedLogging {
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);
    

    public static void main(String[] args) {
        String user = "Alice";
        int orders = 5;

        logger.info("User {} has placed {} orders", user, orders);
        logger.debug("Debug: Processing data for user {}", user);
        logger.warn("Warning: Orders for {} nearing the threshold", user);
        logger.error("Error: Failed to process orders for {}", user);
    }
}
