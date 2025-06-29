package com.example;

public class PerformanceTester {

    public void performTask() {
        // Simulating a task that takes time, e.g., sleeping for 500ms
        try {
            Thread.sleep(500); // within time limit
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
