package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
    import org.junit.jupiter.params.provider.ValueSource;

    public class EvenCheckerTest {
        EvenChecker ev = new EvenChecker();
        @ParameterizedTest
        @ValueSource(ints = {2,4,6,8})
        public void testEven(int number){
            assertTrue(ev.isEven(number));
        }
    }
