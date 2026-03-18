package com.uet.thinh;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LandTaxTest {

    private final LandTaxCalculator calculator = new LandTaxCalculator();

    @Nested
    @DisplayName("Kiểm thử giá trị biên mạnh (49 Test Cases)")
    class BoundaryValueTests {

        @ParameterizedTest(name = "BVA TC{index}: area={0}, dist={1}, type={2}, zone={3} => Expected={4}")
        @CsvSource({
                // area, distance, landType, zone, expected
                "9.9, -0.1, 1, 1, -2.0", "9.9, 0.0, 1, 2, -2.0", "9.9, 0.1, 1, 3, -2.0",
                "9.9, 10.0, 2, 1, -2.0", "9.9, 19.9, 2, 2, -2.0", "9.9, 20.0, 2, 3, -2.0", "9.9, 20.1, 3, 1, -2.0",
                "10.0, -0.1, 3, 2, -2.0", "10.0, 0.0, 3, 3, -1.0", "10.0, 0.1, 4, 1, 1650000.0",
                "10.0, 10.0, 4, 2, 1000000.0", "10.0, 19.9, 4, 3, -1.0", "10.0, 20.0, 5, 1, -1.0", "10.0, 20.1, 5, 2, -2.0",
                "10.1, -0.1, 5, 3, -2.0", "10.1, 0.0, 1, 1, 3333000.0", "10.1, 0.1, 1, 2, 3030000.0",
                "10.1, 10.0, 1, 3, -1.0", "10.1, 19.9, 2, 1, 1999800.0", "10.1, 20.0, 2, 2, 1818000.0", "10.1, 20.1, 2, 3, -2.0",
                "2450.0, -0.1, 3, 1, -2.0", "2450.0, 0.0, 3, 2, 551250000.0", "2450.0, 0.1, 3, 3, -1.0",
                "2450.0, 10.0, 4, 1, 269500000.0", "2450.0, 19.9, 4, 2, 245000000.0", "2450.0, 20.0, 4, 3, -1.0", "2450.0, 20.1, 5, 1, -2.0",
                "4999.9, -0.1, 5, 2, -2.0", "4999.9, 0.0, 5, 3, -1.0", "4999.9, 0.1, 1, 1, 1649967000.0",
                "4999.9, 10.0, 1, 2, 999980000.0", "4999.9, 19.9, 1, 3, -1.0", "4999.9, 20.0, 2, 1, 989980200.0", "4999.9, 20.1, 2, 2, -2.0",
                "5000.0, -0.1, 2, 3, -2.0", "5000.0, 0.0, 3, 1, 1237500000.0", "5000.0, 0.1, 3, 2, 1125000000.0",
                "5000.0, 10.0, 3, 3, -1.0", "5000.0, 19.9, 4, 1, 550000000.0", "5000.0, 20.0, 4, 2, 500000000.0", "5000.0, 20.1, 4, 3, -2.0",
                "5000.1, -0.1, 5, 1, -2.0", "5000.1, 0.0, 5, 2, -2.0", "5000.1, 0.1, 5, 3, -2.0",
                "5000.1, 10.0, 1, 1, -2.0", "5000.1, 19.9, 1, 2, -2.0", "5000.1, 20.0, 1, 3, -2.0", "5000.1, 20.1, 2, 1, -2.0"
        })
        void bvaTests(double area, double distance, int landType, int zone, double expected) {
            assertEquals(expected, calculator.calculateTotalTax(area, landType, distance, zone), 0.001);
        }
    }

    @Nested
    @DisplayName("Kiểm thử Bảng quyết định (15 Test Cases)")
    class DecisionTableTests {

        @ParameterizedTest(name = "{0}: area={1}, type={2}, dist={3}, zone={4} => Expected={5}")
        @CsvSource({
                // ID, area, landType, distance, zone, expected
                "TC01, 5.0, 1, 0.1, 1, -2.0",
                "TC02, 100.0, 5, 0.1, 1, -1.0",
                "TC03, 100.0, 1, 0.2, 1, 33000000.0",
                "TC04, 200.0, 1, 5.0, 2, 40000000.0",
                "TC05, 150.0, 2, 1.0, 2, 32400000.0",
                "TC06, 300.0, 3, 10.0, 1, 49500000.0",
                "TC07, 500.0, 4, 0.3, 2, 75000000.0",
                "TC08, 6000.0, 2, 1.0, 2, -2.0",
                "TC09, 100.0, 0, 1.0, 1, -2.0",
                "TC10, 100.0, 3, 25.0, 2, -2.0",
                "TC11, 100.0, 2, 1.0, 3, -1.0",
                "TC12, 400.0, 2, 15.0, 1, 79200000.0",
                "TC13, 1000.0, 4, 1.5, 1, 132000000.0",
                "TC14, 50.0, 3, 1.8, 2, 9000000.0",
                "TC15, 100.0, 6, 1.0, 2, -2.0"
        })
        void decisionTableTests(String id, double area, int landType, double distance, int zone, double expected) {
            assertEquals(expected, calculator.calculateTotalTax(area, landType, distance, zone), 0.001);
        }
    }
}