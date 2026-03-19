package org.howard.edu.lsp.midterm.strategy;

/**
 * Holiday customer pricing strategy (15% discount).
 */
public class HolidayPrice implements PriceStrategy {
    public double calculatePrice(double price) {
        return price * 0.85;
    }
}