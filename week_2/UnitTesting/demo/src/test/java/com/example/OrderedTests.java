package com.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(1)
    void testFirst() {
        System.out.println("Running testFirst");
        assertTrue(true);
    }

    @Test
    @Order(3)
    void testThird() {
        System.out.println("Running testThird");
        assertEquals(9, 3 * 3);
    }

    @Test
    @Order(2)
    void testSecond() {
        System.out.println("Running testSecond");
        assertNotNull("JUnit");
    }
}
