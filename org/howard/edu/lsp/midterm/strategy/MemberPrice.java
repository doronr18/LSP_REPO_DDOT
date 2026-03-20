package org.howard.edu.lsp.midterm.strategy;

/**
 * Name: Doron Reid
 */
/**
 * Member customer pricing strategy (10% discount).
 */
public class MemberPrice implements PriceStrategy {
    public double calculatePrice(double price) {
        return price * 0.9;
    }
}