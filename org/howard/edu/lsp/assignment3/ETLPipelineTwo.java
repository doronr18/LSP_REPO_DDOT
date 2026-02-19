/**
 * Name: Doron Reid
 */

package org.howard.edu.lsp.assignment3;

import java.util.ArrayList;
import java.util.List;

public class ETLPipelineTwo {

    public static void main(String[] args) {

        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";

        CSVReader reader = new CSVReader();
        CSVWriter writer = new CSVWriter();
        ProductTransformer transformer = new ProductTransformer();

        List<Product> products = reader.read(inputPath);
        List<TransformedProduct> transformed = new ArrayList<>();

        for (Product product : products) {
            transformed.add(transformer.transform(product));
        }

        writer.write(outputPath, transformed);

        System.out.println("Rows read: " + reader.getRowsRead());
        System.out.println("Rows transformed: " + transformed.size());
        System.out.println("Rows skipped: " + reader.getRowsSkipped());
    }
}
