package org.howard.edu.lsp.midterm.strategy;

/**
 * Name: Doron Reid
 */
/**
 * Regular customer pricing strategy.
 */
public class RegularPrice implements PriceStrategy {
    public double calculatePrice(double price) {
        return price;
    }
}