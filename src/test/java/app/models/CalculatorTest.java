package app.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

   int a = 6;
    int b= 4;

    Calculator calculator;

    @BeforeEach
    void setUp() {

        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {

        calculator = null;

    }

    @Test
    void add() {

        assertEquals((double) a + b, calculator.add(a, b));
        assertEquals((int)0, calculator.add(-a, a));
        assertEquals((int)-10, calculator.add(-a, -b));
    }

    @Test
    void subtract() {

        assertEquals(a - b, calculator.subtract(a, b));
        assertEquals((int)-12, calculator.subtract(-a, a));
        assertEquals((double) -2, calculator.subtract(-a, -b));
    }

    @Test
    void multiply() {

        assertEquals((int ) a * b, calculator.multiply(a, b));
        assertEquals((int) -36, calculator.multiply(-a, a));
        assertEquals((double)a, calculator.multiply(-2, -3));

    }

    @Test
    void divide() {

        assertEquals((double)a, calculator.divide(24, b));
        assertEquals(-1, calculator.divide(-a, a));
        assertEquals(a, calculator.divide(-18, -3));

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(a, 0);
        });

    }
}