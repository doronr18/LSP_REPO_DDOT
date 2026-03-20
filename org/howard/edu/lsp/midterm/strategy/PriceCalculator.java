package org.howard.edu.lsp.midterm.strategy;

/**
 * Name: Doron Reid
 */
/**
 * PriceCalculator uses a PriceStrategy to calculate final price.
 */
public class PriceCalculator {

//PriceCalculator delegates the price calculation to whatever strategy it is given. Private ensures encapsulation, so only this class can access the field directly.
    private PriceStrategy strategy;

    //Takes a PriceStrategy object as a parameter. this.strategy = strategy; stores the passed strategy in the private field so the object knows which pricing algorithm to use
    public PriceCalculator(PriceStrategy strategy) {
        this.strategy = strategy;
    }

// Delegates the actual calculation to the strategy stored in strategy
    public double calculatePrice(double price) {
        return strategy.calculatePrice(price);
    }
}