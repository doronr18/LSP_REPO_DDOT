/**
 * Name: Doron Reid
 */
package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class ETLPipeline {
    static class TransformedRow {
    int productId;
    String name;
    double price;
    String category;
    String priceRange;

    TransformedRow(int productId, String name, double price, String category, String priceRange) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
        this.priceRange = priceRange;
    }
}

    public static void main(String[] args) {
        List<TransformedRow> transformedRows = new ArrayList<>();
        String inputFile = "data/products.csv";
        int rowsRead = 0;
        int rowsTransformed = 0;
        int rowsSkipped = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line = br.readLine(); // read header
            if (line == null) {
                System.out.println("Input file is empty. Only header will be written.");
                return;
            }


            while ((line = br.readLine()) != null) {
                rowsRead++;

                // Skip blank lines
                if (line.trim().isEmpty()) {
                    rowsSkipped++;
                    continue;
                }

                // Split row
                String[] fields = line.split(",");
                if (fields.length != 4) {
                    rowsSkipped++;
                    continue;
                }

                // Trim whitespace
                for (int i = 0; i < fields.length; i++) {
                    fields[i] = fields[i].trim();
                }

                //  Parsing ProductID and Price
                int productId;
                double price;
                try {
                    productId = Integer.parseInt(fields[0]);
                    price = Double.parseDouble(fields[2]);
                    rowsTransformed++;

                } catch (NumberFormatException e) {
                    rowsSkipped++;
                    continue;
                }

                String name = fields[1].toUpperCase();
                String category = fields[3];

                

                if (category.equalsIgnoreCase("Electronics")) {
                    price = price * 0.9; // Apply 10% discount
                    if(price > 500.00){
                        category = "Premium Electronics";
                    }
                }

                BigDecimal bdPrice = new BigDecimal(price).setScale(2, RoundingMode.HALF_UP);
                price = bdPrice.doubleValue();

                String priceRange;
                if (price <= 10.00) {
                     priceRange = "Low";
                } else if (price <= 100.00) {
                    priceRange = "Medium";
                } else if (price <= 500.00) {
                    priceRange = "High";
                } else {
                    priceRange = "Premium";
                }

                transformedRows.add(new TransformedRow(productId, name, price, category, priceRange));
                
            }

            String outputFile = "data/transformed_products.csv";

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
                // Write header
                bw.write("ProductID,Name,Price,Category,PriceRange");
                bw.newLine();

                // Write each transformed row
                for (TransformedRow row : transformedRows) {
                    String lineOut = row.productId + "," + row.name + "," 
                                    + String.format("%.2f", row.price) + "," 
                                    + row.category + "," + row.priceRange;
                    bw.write(lineOut);
                    bw.newLine();
                }

                System.out.println("Output file written to: " + outputFile);

            } catch (IOException e) {
                e.printStackTrace();
            }


            // Print summary AFTER reading all rows
            System.out.println("Rows read: " + rowsRead);
            System.out.println("Rows transformed: " + rowsTransformed);
            System.out.println("Rows skipped: " + rowsSkipped);

        } catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
