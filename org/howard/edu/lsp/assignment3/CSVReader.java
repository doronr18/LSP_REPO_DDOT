/**
 * Name: Doron Reid
 */

package org.howard.edu.lsp.assignment3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    private int rowsRead = 0;
    private int rowsSkipped = 0;

    public List<Product> read(String filePath) {
        List<Product> products = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line = reader.readLine(); // skip header

            if (line == null) {
                return products; // empty file
            }

            while ((line = reader.readLine()) != null) {
                rowsRead++;

                if (line.trim().isEmpty()) {
                    rowsSkipped++;
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length != 4) {
                    rowsSkipped++;
                    continue;
                }

                try {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());
                    String category = parts[3].trim();

                    products.add(new Product(id, name, price, category));

                } catch (NumberFormatException e) {
                    rowsSkipped++;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }

    public int getRowsRead() { return rowsRead; }
    public int getRowsSkipped() { return rowsSkipped; }
}
