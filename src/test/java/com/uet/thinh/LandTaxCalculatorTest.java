package com.uet.thinh;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LandTaxCalculatorTest {

    LandTaxCalculator calculator = new LandTaxCalculator();
    double delta = 0.001;
    @Test
    void testTC01_InvalidInput() {
        assertEquals(-2.0, calculator.calculateTotalTax(5.0, 1, 0.1, 1), delta);
    }

    @Test
    void testTC02_Rejected() {
        assertEquals(-1.0, calculator.calculateTotalTax(100.0, 5, 0.1, 1), delta);
    }

    @Test
    void testTC03_Case1() {
        assertEquals(33000000.0, calculator.calculateTotalTax(100.0, 1, 0.1, 1), delta);
    }

    @Test
    void testTC04_Case2() {
        assertEquals(21600000.0, calculator.calculateTotalTax(100.0, 2, 1.0, 2), delta);
    }

    @Test
    void testTC05_Case3() {
        assertEquals(15000000.0, calculator.calculateTotalTax(100.0, 3, 5.0, 2), delta);
    }

    @Test
    void testTC06_Default() {
        assertEquals(16500000.0, calculator.calculateTotalTax(100.0, 4, 0.1, 1), delta);
    }
}