package com.example;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    CalculatorTest.class,
    AssertionsTest.class,
    AppTest.class,
    ExceptionThrowerTest.class
})
public class AllTests {
    // No code needed inside – annotations handle everything
}
