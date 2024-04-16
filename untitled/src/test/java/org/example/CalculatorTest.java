package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void getFactorial() {
Calculator calculator = new Calculator();
int a = calculator.getFactorial(3);
        Assertions.assertEquals(6, a);
    }
}
