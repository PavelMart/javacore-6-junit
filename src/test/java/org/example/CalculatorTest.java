package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    static Calculator calculator;
    @BeforeAll
    public static void initializeCalculator() {
        calculator = new Calculator();
    }
    @Test
    public void plusTest() {
        final Integer a = 3;
        final Integer b = 4;
        final Integer expected = 7;

        final Integer result = calculator.plus.apply(a, b);

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void minusTest() {
        final Integer a = 3;
        final Integer b = 4;
        final Integer expected = -1;

        final Integer result = calculator.minus.apply(a, b);

        Assertions.assertEquals(result, expected);
    }

    @ParameterizedTest
    @CsvSource({"3, 4, 12", "5, 0, 0", "0, 5, 0", "3, -3, -9"})
    public void multiplyTest(int a, int b, int expected) {
        final Integer result = calculator.multiply.apply(a, b);
        Assertions.assertEquals(result, expected);
    }

    @ParameterizedTest
    @CsvSource({"8, 4, 2", "2, 0, 0", "0, 5, 0", "3, -3, -1"})
    public void divideTest(int a, int b, int expected) {
        final Integer result = calculator.divide.apply(a, b);
        Assertions.assertEquals(result, expected);
    }

    @ParameterizedTest
    @CsvSource({"8", "4", "1"})
    public void isPositiveTest(int a) {
        Assertions.assertTrue(calculator.isPositive.test(a));
    }

    @ParameterizedTest
    @CsvSource({"-1", "0"})
    public void isNegativeTest(int a) {
        Assertions.assertFalse(calculator.isPositive.test(a));
    }


}