package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {
    @Test
    public void testAssertions() {
        // Check if 2 + 3 is equal to 5
        assertEquals(5, 2 + 3);

        // Check if 5 is greater than 3
        assertTrue(5 > 3);

        // Check if 5 is NOT less than 3
        assertFalse(5 < 3);

        // Check if a null value is actually null
        assertNull(null);

        // Check if a new object is NOT null
        assertNotNull(new Object());
    }
}
