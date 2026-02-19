/**
 * Name: Doron Reid
 */


package org.howard.edu.lsp.assignment3;


public class Product {

    private int productId;
    private String name;
    private double price;
    private String category;

    /**
     * Constructs a Product object.
     *
     * @param productId unique product identifier
     * @param name product name
     * @param price product price
     * @param category product category
     */
    public Product(int productId, String name, double price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    
    public int getProductId() {
        return productId;
    }


    public String getName() {
        return name;
    }

 
    public double getPrice() {
        return price;
    }


    public String getCategory() {
        return category;
    }
}
