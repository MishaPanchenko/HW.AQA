package org.example;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class CalculatorTest {
    private AssertJUnit Assertions;

    @Test
    void getFactorial() {
        Calculator calculator = new Calculator();
        int a = calculator.getFactorial(3);
        Assertions.assertEquals(6, a);
    }
}

