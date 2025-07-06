package com.library.aspect;

public class LoggingAspect {

    // Before advice
    public void logBefore() {
        System.out.println("[LOG] BookService method is about to run...");
    }

    // After advice
    public void logAfter() {
        System.out.println("[LOG] BookService method has completed.");
    }
}
