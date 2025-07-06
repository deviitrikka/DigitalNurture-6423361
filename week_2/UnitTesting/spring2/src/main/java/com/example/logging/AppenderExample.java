package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderExample {

    private static final Logger logger = LoggerFactory.getLogger(AppenderExample.class);

    public static void main(String[] args) {
        logger.info("This is an info log message.");
        logger.debug("This is a debug message.");
        logger.warn("This is a warning.");
        logger.error("This is an error message.");
    }
}
