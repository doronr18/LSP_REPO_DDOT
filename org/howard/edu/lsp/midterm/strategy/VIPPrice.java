package org.howard.edu.lsp.midterm.strategy;

/**
 * Name: Doron Reid
 */
/**
 * VIP customer pricing strategy (20% discount).
 */
public class VIPPrice implements PriceStrategy {
    public double calculatePrice(double price) {
        return price * 0.8;
    }
}