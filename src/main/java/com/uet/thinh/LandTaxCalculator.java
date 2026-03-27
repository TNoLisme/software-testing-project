package com.uet.thinh;

public class LandTaxCalculator {
    public double calculateTotalTax(double area, int landType, double distance, int zone) {
        if (area < 10.0 || area > 5000.0 || landType < 1 || landType > 5 ||
                distance < 0.0 || distance > 20.0 || zone < 1 || zone > 3) {
            return -2.0;
        }

        if (landType == 5 || zone == 3) {
            return -1.0;
        }

        double unitPrice = switch (landType) {
            case 1 -> 2000000;
            case 2 -> 1800000;
            case 3 -> 1500000;
            default -> 1000000;
        };

        double taxRate;
        if (distance <= 0.5) taxRate = 0.15;
        else if (distance <= 2.0) taxRate = 0.12;
        else taxRate = 0.1;

        double multiplier = (zone == 1) ? 1.1 : 1.0;

        return (area * unitPrice * taxRate) * multiplier;
    }
}