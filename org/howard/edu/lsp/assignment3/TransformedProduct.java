/**
 * Name: Doron Reid
 */

package org.howard.edu.lsp.assignment3;

public class TransformedProduct {
    private int productId;
    private String name;
    private double price;
    private String category;
    private String priceRange;

    public TransformedProduct(int productId, String name, double price,
                              String category, String priceRange) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
        this.priceRange = priceRange;
    }

    public String toCSV() {
        return productId + "," +
               name + "," +
               String.format("%.2f", price) + "," +
               category + "," +
               priceRange;
    }
}
