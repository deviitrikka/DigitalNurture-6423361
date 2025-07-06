package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import java.time.Duration;

public class PerformanceTesterTest {

    @Test
    void testPerformTaskWithinTimeLimit() {
        PerformanceTester tester = new PerformanceTester();

        // Ensure performTask completes within 1 second
        assertTimeout(Duration.ofSeconds(1), tester::performTask);
    }
}
