/**
 * Name: Doron Reid
 */

package org.howard.edu.lsp.assignment3;

import java.io.*;
import java.util.List;

public class CSVWriter {

    public void write(String filePath, List<TransformedProduct> products) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            // Always write header
            writer.write("ProductID,Name,Price,Category,PriceRange");
            writer.newLine();

            for (TransformedProduct product : products) {
                writer.write(product.toCSV());
                writer.newLine();
            }

            System.out.println("Output file written to: " + filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
