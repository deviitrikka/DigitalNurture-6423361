package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;

    // Setup method (runs before each test)
    @BeforeEach
    public void setUp() {
        calculator = new Calculator();  // Arrange
        System.out.println("Setup: Calculator created");
    }

    // Teardown method (runs after each test)
    @AfterEach
    public void tearDown() {
        calculator = null;
        System.out.println("Teardown: Calculator cleaned up");
    }

    @Test
    public void testAddition() {
        // Arrange
        int a = 5, b = 3;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(8, result);
    }

    @Test
    public void testMultiplication() {
        // Arrange
        int a = 3, b = 4;

        // Act
        int result = calculator.multiply(a, b);

        // Assert
        assertEquals(12, result);
    }
}
