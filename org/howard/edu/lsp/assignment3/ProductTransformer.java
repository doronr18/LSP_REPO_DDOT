/**
 * Name: Doron Reid
 */

package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProductTransformer {

    public TransformedProduct transform(Product product) {

        int id = product.getProductId();
        String name = product.getName().toUpperCase();
        double price = product.getPrice();
        String category = product.getCategory();

        if (category.equalsIgnoreCase("Electronics")) {
            price *= 0.9;

            if (price > 500) {
                category = "Premium Electronics";
            }
        }

        price = new BigDecimal(price)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();

        String priceRange;

        if (price <= 10) {
            priceRange = "Low";
        } else if (price <= 100) {
            priceRange = "Medium";
        } else if (price <= 500) {
            priceRange = "High";
        } else {
            priceRange = "Premium";
        }

        return new TransformedProduct(id, name, price, category, priceRange);
    }
}
