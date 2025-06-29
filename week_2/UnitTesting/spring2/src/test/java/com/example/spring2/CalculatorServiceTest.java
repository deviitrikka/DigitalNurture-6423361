package com.example.spring2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @CsvSource({
        "1, 2, 3",
        "0, 0, 0",
        "-1, -2, -3",
        "100, 200, 300",
        "-5, 5, 0"
    })
    public void testAdd(int a, int b, int expected) {
        int result = calculatorService.add(a, b);
        assertEquals(expected, result, "Sum should be correct");
    }
}
