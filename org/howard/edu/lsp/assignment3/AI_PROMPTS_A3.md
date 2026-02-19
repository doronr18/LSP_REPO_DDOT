**AI Prompts**

**\#\#Prompt** 

In Assignment 2, I built an ETL pipeline in Java. In this new assignment, I will redesign my solution to be more object-oriented. The goal is to practice object-oriented decomposition, not perfection. I must also use a generative AI assistant (you) to help with the redesign and explain how I used or adapted its suggestions. Apply object-oriented decomposition to requirements. Use OO concepts: object, class, encapsulation, inheritance, polymorphism. Use generative AI as a helper and reflect on your choices. This is my assignment 2 solution: // Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA). package org.howard.edu.lsp.assignment2; import java.io.BufferedReader; import java.io.BufferedWriter; import java.io.FileNotFoundException; import java.io.FileReader; import java.io.FileWriter; import java.io.IOException; import java.math.BigDecimal; import java.math.RoundingMode; import java.util.ArrayList; import java.util.Iterator; public class ETLPipeline { public ETLPipeline() { } public static void main(String\[\] var0) { ArrayList var1 \= new ArrayList(); String var2 \= "data/products.csv"; int var3 \= 0; int var4 \= 0; int var5 \= 0; try { BufferedReader var6 \= new BufferedReader(new FileReader(var2)); label137: { try { String var7 \= var6.readLine(); if (var7 \== null) { System.out.println("Input file is empty. Only header will be written."); break label137; } while(true) { String var12; if ((var7 \= var6.readLine()) \== null) { String var24 \= "data/transformed\_products.csv"; try { BufferedWriter var25 \= new BufferedWriter(new FileWriter(var24)); try { var25.write("ProductID,Name,Price,Category,PriceRange"); var25.newLine(); Iterator var26 \= var1.iterator(); while(true) { if (\!var26.hasNext()) { System.out.println("Output file written to: " \+ var24); break; } TransformedRow var11 \= (TransformedRow)var26.next(); int var10000 \= var11.productId; var12 \= "" \+ var10000 \+ "," \+ var11.name \+ "," \+ String.format("%.2f", var11.price) \+ "," \+ var11.category \+ "," \+ var11.priceRange; var25.write(var12); var25.newLine(); } } catch (Throwable var18) { try { var25.close(); } catch (Throwable var17) { var18.addSuppressed(var17); } throw var18; } var25.close(); } catch (IOException var19) { var19.printStackTrace(); } System.out.println("Rows read: " \+ var3); System.out.println("Rows transformed: " \+ var4); System.out.println("Rows skipped: " \+ var5); break; } \++var3; if (var7.trim().isEmpty()) { \++var5; } else { String\[\] var8 \= var7.split(","); if (var8.length \!= 4\) { \++var5; } else { int var9; for(var9 \= 0; var9 \< var8.length; \++var9) { var8\[var9\] \= var8\[var9\].trim(); } double var10; try { var9 \= Integer.parseInt(var8\[0\]); var10 \= Double.parseDouble(var8\[2\]); \++var4; } catch (NumberFormatException var20) { \++var5; continue; } var12 \= var8\[1\].toUpperCase(); String var13 \= var8\[3\]; if (var13.equalsIgnoreCase("Electronics")) { var10 \*= 0.9; if (var10 \> 500.0) { var13 \= "Premium Electronics"; } } BigDecimal var14 \= (new BigDecimal(var10)).setScale(2, RoundingMode.HALF\_UP); var10 \= var14.doubleValue(); String var15; if (var10 \<= 10.0) { var15 \= "Low"; } else if (var10 \<= 100.0) { var15 \= "Medium"; } else if (var10 \<= 500.0) { var15 \= "High"; } else { var15 \= "Premium"; } var1.add(new TransformedRow(var9, var12, var10, var13, var15)); } } } } catch (Throwable var21) { try { var6.close(); } catch (Throwable var16) { var21.addSuppressed(var16); } throw var21; } var6.close(); return; } var6.close(); return; } catch (FileNotFoundException var22) { System.out.println("Input file not found: " \+ var2); } catch (IOException var23) { var23.printStackTrace(); } } static class TransformedRow { int productId; String name; double price; String category; String priceRange; TransformedRow(int var1, String var2, double var3, String var5, String var6) { this.productId \= var1; this.name \= var2; this.price \= var3; this.category \= var5; this.priceRange \= var6; } } }. This solution worked, but I got these comments on my last assignment: Rubric (from assignment requirements) Program Compiles in Instructor Eclipse (no modification) — Required Robust Sample Output — 60 Case B: Empty Input — 10 Case C: Missing Input — 10 Correct Package Structure (org.howard.edu.lsp.assignment2) — 10 Clean Repository — 10 Evaluation Results Program Compiles ⚠️ Compiles only after instructor modification The package declaration was incorrect (src.org.howard.edu.lsp.assignment2). The instructor had to modify the source code for it to compile. Per the assignment requirements, submissions are expected to compile without modification. Robust Sample Output (60 pts) Score: 60 / 60 After correcting the package declaration, the program: Correctly skips invalid rows Applies all required transformations Produces output that matches the expected robust sample exactly Case B: Empty Input (10 pts) Score: 0 / 10 ❌ If the input file contains only the header row, your program prints a message and exits without creating data/transformed\_products.csv. The specification requires that a header-only output file still be created. Case C: Missing Input File (10 pts) Score: 10 / 10 ✅ If data/products.csv is missing, the program prints a clear error message and exits cleanly (no stack trace). This meets the requirement. Correct Package Structure (10 pts) Score: 0 / 10 ❌ The package declaration did not match the required structure. Because the instructor had to modify the source code, this rubric item is not satisfied. Clean Repository (10 pts) Score: 10 / 10 ✅ Repository contains only source files; no IDE, binary, or build artifacts. Final Grade: 80 / 100\. So to help me brainstorm ways to make it more object-oriented

**\#\#AI Response** 

Great — this is a perfect candidate for object-oriented redesign. Your original solution works functionally, but everything is inside `main`, which makes it procedural rather than object-oriented.

Let’s break this down in a structured way so you can:

1. Apply **object-oriented decomposition**  
2. Use **encapsulation, inheritance, polymorphism**  
3. Show how you used AI suggestions (me) in your reflection  
4. Fix previous rubric issues (empty file case \+ package structure)

---

# **1️⃣ Problems With Current Design (Why It’s Not OO)**

Your current version:

* Everything is inside `main`  
* No separation of responsibilities  
* No domain objects (Product is not a real class)  
* No abstraction of ETL steps  
* Inner class `TransformedRow` is just a data holder  
* File reading, transformation logic, and writing are tightly coupled

It works — but it’s procedural.

---

# **2️⃣ Object-Oriented Decomposition**

Let’s decompose the system by responsibility.

Instead of one big class, think in terms of objects:

### **High-Level ETL Components**

| Responsibility | Class |
| ----- | ----- |
| Read input file | `ProductReader` |
| Represent raw product | `Product` |
| Apply transformations | `ProductTransformer` |
| Represent transformed product | `TransformedProduct` |
| Write output file | `ProductWriter` |
| Orchestrate pipeline | `ETLPipeline` |

This gives us proper **separation of concerns**.

---

# **3️⃣ Proposed Object-Oriented Design**

## **📦 Package (Fix Previous Rubric Issue)**

`package org.howard.edu.lsp.assignment3;`

Make sure your folder structure is:

`src/`  
  `org/`  
    `howard/`  
      `edu/`  
        `lsp/`  
          `assignment3/`

This ensures it compiles without instructor modification.

---

# **4️⃣ Core Domain Objects (Encapsulation)**

## **Product (Raw Input Object)**

`public class Product {`  
    `private int productId;`  
    `private String name;`  
    `private double price;`  
    `private String category;`

    `public Product(int productId, String name, double price, String category) {`  
        `this.productId = productId;`  
        `this.name = name;`  
        `this.price = price;`  
        `this.category = category;`  
    `}`

    `public int getProductId() { return productId; }`  
    `public String getName() { return name; }`  
    `public double getPrice() { return price; }`  
    `public String getCategory() { return category; }`  
`}`

### **OO Concepts Used:**

* **Object**: Product represents a real-world entity.  
* **Encapsulation**: Fields are private.  
* Public getters expose controlled access.

---

## **TransformedProduct**

`public class TransformedProduct {`  
    `private int productId;`  
    `private String name;`  
    `private double price;`  
    `private String category;`  
    `private String priceRange;`

    `public TransformedProduct(int productId, String name,`  
                              `double price, String category,`  
                              `String priceRange) {`  
        `this.productId = productId;`  
        `this.name = name;`  
        `this.price = price;`  
        `this.category = category;`  
        `this.priceRange = priceRange;`  
    `}`

    `@Override`  
    `public String toString() {`  
        `return productId + "," + name + "," +`  
               `String.format("%.2f", price) + "," +`  
               `category + "," + priceRange;`  
    `}`  
`}`

Encapsulation \+ object modeling.

---

# **5️⃣ Transformer (Polymorphism Opportunity)**

Instead of hardcoding transformation logic inside `main`, define an interface:

`public interface Transformer<T, R> {`  
    `R transform(T input);`  
`}`

Now implement:

`public class ProductTransformer implements Transformer<Product, TransformedProduct> {`

    `@Override`  
    `public TransformedProduct transform(Product product) {`

        `String name = product.getName().toUpperCase();`  
        `double price = product.getPrice();`  
        `String category = product.getCategory();`

        `if (category.equalsIgnoreCase("Electronics")) {`  
            `price *= 0.9;`  
            `if (price > 500) {`  
                `category = "Premium Electronics";`  
            `}`  
        `}`

        `price = Math.round(price * 100.0) / 100.0;`

        `String priceRange;`  
        `if (price <= 10) priceRange = "Low";`  
        `else if (price <= 100) priceRange = "Medium";`  
        `else if (price <= 500) priceRange = "High";`  
        `else priceRange = "Premium";`

        `return new TransformedProduct(`  
            `product.getProductId(),`  
            `name,`  
            `price,`  
            `category,`  
            `priceRange`  
        `);`  
    `}`  
`}`

### **OO Concepts Used:**

* **Interface**  
* **Polymorphism** — You could later create:  
  * `DiscountTransformer`  
  * `CategoryTransformer`  
  * `LuxuryTransformer`  
* The pipeline can accept *any* Transformer.

---

# **6️⃣ Reader Class**

`public class ProductReader {`

    `public List<Product> read(String filePath) {`  
        `List<Product> products = new ArrayList<>();`

        `// reading logic here`  
        `return products;`  
    `}`  
`}`

Now file reading is separate from business logic.

---

# **7️⃣ Writer Class (Fix Empty File Issue)**

`public class ProductWriter {`

    `public void write(String filePath, List<TransformedProduct> products) {`

        `try (BufferedWriter writer =`  
                `new BufferedWriter(new FileWriter(filePath))) {`

            `writer.write("ProductID,Name,Price,Category,PriceRange");`  
            `writer.newLine();`

            `for (TransformedProduct p : products) {`  
                `writer.write(p.toString());`  
                `writer.newLine();`  
            `}`

        `} catch (IOException e) {`  
            `System.out.println("Error writing output file.");`  
        `}`  
    `}`  
`}`

⚠️ Notice:  
Even if `products` is empty, the header is still written.

This fixes your 0/10 Case B issue.

---

# **8️⃣ Pipeline Orchestrator**

`public class ETLPipeline {`

    `private ProductReader reader;`  
    `private ProductWriter writer;`  
    `private Transformer<Product, TransformedProduct> transformer;`

    `public ETLPipeline() {`  
        `reader = new ProductReader();`  
        `writer = new ProductWriter();`  
        `transformer = new ProductTransformer();`  
    `}`

    `public void run(String input, String output) {`

        `List<Product> products = reader.read(input);`

        `List<TransformedProduct> transformed =`  
                `new ArrayList<>();`

        `for (Product p : products) {`  
            `transformed.add(transformer.transform(p));`  
        `}`

        `writer.write(output, transformed);`  
    `}`

    `public static void main(String[] args) {`  
        `ETLPipeline pipeline = new ETLPipeline();`  
        `pipeline.run(`  
            `"data/products.csv",`  
            `"data/transformed_products.csv"`  
        `);`  
    `}`  
`}`

---

# **9️⃣ Where You Demonstrate OO Concepts**

You can explicitly state in your write-up:

### **✔ Object**

* `Product`  
* `TransformedProduct`

### **✔ Class**

* ProductReader  
* ProductWriter  
* ProductTransformer  
* ETLPipeline

### **✔ Encapsulation**

* Private fields  
* Public getters  
* No direct data manipulation

### **✔ Inheritance**

If you want to go further:

`public abstract class AbstractTransformer<T, R>`  
        `implements Transformer<T, R> {`  
`}`

Then:

`public class ProductTransformer`  
        `extends AbstractTransformer<Product, TransformedProduct> {`  
`}`

### **✔ Polymorphism**

* `Transformer<Product, TransformedProduct>` interface  
* Pipeline depends on interface, not concrete class  
* Can swap different transformers

---

# **🔟 How You Can Write the AI Reflection**

You must explain how you used AI. Here's a clean example structure:

---

### **Example Reflection Paragraph**

I used a generative AI assistant to help brainstorm how to decompose my procedural ETL pipeline into object-oriented components. The AI suggested separating responsibilities into distinct classes such as ProductReader, ProductWriter, ProductTransformer, and ETLPipeline. I adapted these suggestions by implementing encapsulation through private fields, introducing a Transformer interface to demonstrate polymorphism, and modeling domain objects such as Product and TransformedProduct. I modified the AI’s suggestions to ensure they aligned with the assignment requirements and preserved my original transformation logic. Additionally, I improved error handling and ensured that an output file is created even when the input contains only a header row.

---

# **🎯 How This Improves Your Grade**

| Rubric Item | Now Covered? |
| ----- | ----- |
| Compiles without modification | ✔ (correct package) |
| Robust sample | ✔ |
| Empty input case | ✔ (writer always creates file) |
| Missing input case | ✔ |
| OO decomposition | ✔ |
| Use of encapsulation | ✔ |
| Use of inheritance | ✔ |
| Use of polymorphism | ✔ |

---

# **🔥 If You Want To Make It Even More OO (Advanced Option)**

You could model ETL itself as:

`public interface PipelineStep<T, R> {`  
    `R execute(T input);`  
`}`

Then Reader, Transformer, and Writer all become pipeline steps.

That would show very strong OO decomposition.

---

If you’d like, I can next:

* Help you design a **clean UML diagram**  
* Help you write the **reflection section professionally**  
* Or provide a **complete polished Assignment 3 version** ready to submit

What would you like to work on next?

**\#\#Prompt** 

Help me understand how I can redesign the solution into multiple classes with clearer responsibilities. Mainly sure my program still meets the exact same requirements as Assignment 2: same inputs, same outputs, same transformations, same error handling, and same relative paths. 1\) Extract Read a CSV file named products.csv from the data/ directory. The file contains the following columns: • ProductID (integer) • Name (string) • Price (decimal number) • Category (string) The first row is a header and must not be transformed. 2\) Transform (Apply in This Exact Order) 1\. Convert all product names to UPPERCASE. 2\. If the category is "Electronics", apply a 10% discount to the price. 3\. If the final rounded price is strictly greater than $500.00 AND the original category was "Electronics", change the category to "Premium Electronics". 4\. Add a new field PriceRange based on the final rounded price: • \<= $10.00 → Low • \> $10.00 and \<= $100.00 → Medium • \> $100.00 and \<= $500.00 → High • \> $500.00 → Premium 3\) Load Write the transformed data to data/transformed\_products.csv. Output column order: ProductID, Name, Price, Category, PriceRange Always write a header row.

**\#\#AI Response** 

Good — this is exactly the right question to ask before you start coding.

You are **not changing behavior**.  
You are only changing **structure**.

So think:

Same logic. Same output. Cleaner responsibilities.

Let’s walk through this slowly and clearly.

---

# **Step 1: Identify Responsibilities in Your Current Code**

Right now your `main` does **five different jobs**:

1. File existence handling  
2. Reading CSV  
3. Validating rows  
4. Transforming business logic  
5. Writing output  
6. Tracking counts (read / transformed / skipped)

That’s why it feels long and procedural.

We’re going to separate those responsibilities into different classes.

---

# **Step 2: Think in Terms of “Objects”**

Object-Oriented design asks:

What real-world things exist in this system?

In your case:

• A Product  
• A Transformed Product  
• A Reader  
• A Transformer  
• A Writer  
• A Pipeline Controller

Those become your classes.

---

# **Step 3: New Class Structure (Clear Responsibilities)**

Here’s the clean redesign:

`org.howard.edu.lsp.assignment3`  
`│`  
`├── ETLPipeline.java          (main + orchestrator)`  
`├── Product.java              (raw input object)`  
`├── TransformedProduct.java   (output object)`  
`├── ProductReader.java        (extract step)`  
`├── ProductTransformer.java   (transform step)`  
`├── ProductWriter.java        (load step)`

Each class has ONE job.

---

# **Step 4: Match EXACT Assignment Requirements**

We now verify that every requirement still happens.

---

# **🔹 1\) Extract Step → ProductReader**

Responsibility:  
• Read `data/products.csv`  
• Skip header  
• Validate rows  
• Count read / skipped  
• Return List\<Product\>

Important:  
Keep the exact same:

* relative path  
* error message for missing file  
* skipping invalid rows

Example structure (simplified for clarity):

`public class ProductReader {`

    `public List<Product> read(String filePath) {`  
        `List<Product> products = new ArrayList<>();`

        `try (BufferedReader reader =`  
                 `new BufferedReader(new FileReader(filePath))) {`

            `String header = reader.readLine(); // skip header`  
            `if (header == null) {`  
                `return products;  // empty input case`  
            `}`

            `String line;`  
            `while ((line = reader.readLine()) != null) {`  
                `// validation logic EXACTLY like Assignment 2`  
            `}`

        `} catch (FileNotFoundException e) {`  
            `System.out.println("Input file not found: " + filePath);`  
        `} catch (IOException e) {`  
            `e.printStackTrace();`  
        `}`

        `return products;`  
    `}`  
`}`

Nothing about transformation happens here.

Just reading \+ validation.

---

# **🔹 2\) Transform Step → ProductTransformer**

Responsibility:  
Apply transformations in the **exact required order**.

Important: Order matters.

You must follow:

1. Uppercase name  
2. Apply 10% discount if Electronics  
3. Round  
4. If rounded price \> 500 AND original category was Electronics → Premium Electronics  
5. Determine PriceRange

This is important:

Step 3 requires using the ORIGINAL category check.

So inside transform method:

`public TransformedProduct transform(Product product) {`

    `String originalCategory = product.getCategory();`  
    `String name = product.getName().toUpperCase();`

    `double price = product.getPrice();`

    `if (originalCategory.equalsIgnoreCase("Electronics")) {`  
        `price *= 0.9;`  
    `}`

    `// round AFTER discount`  
    `price = new BigDecimal(price)`  
                `.setScale(2, RoundingMode.HALF_UP)`  
                `.doubleValue();`

    `String category = originalCategory;`

    `if (price > 500.00 &&`  
        `originalCategory.equalsIgnoreCase("Electronics")) {`  
        `category = "Premium Electronics";`  
    `}`

    `String priceRange = calculatePriceRange(price);`

    `return new TransformedProduct(`  
        `product.getProductId(),`  
        `name,`  
        `price,`  
        `category,`  
        `priceRange`  
    `);`  
`}`

Notice:  
This preserves the EXACT transformation logic.

---

# **🔹 3\) Load Step → ProductWriter**

Responsibility:  
• Always write header  
• Write to `data/transformed_products.csv`  
• Correct column order  
• Use same formatting (2 decimal places)

Important fix from your grade:  
Even if list is empty → still write header.

`public class ProductWriter {`

    `public void write(String filePath,`  
                      `List<TransformedProduct> products) {`

        `try (BufferedWriter writer =`  
                 `new BufferedWriter(new FileWriter(filePath))) {`

            `writer.write("ProductID,Name,Price,Category,PriceRange");`  
            `writer.newLine();`

            `for (TransformedProduct p : products) {`  
                `writer.write(p.toString());`  
                `writer.newLine();`  
            `}`

        `} catch (IOException e) {`  
            `e.printStackTrace();`  
        `}`  
    `}`  
`}`

This guarantees Case B gets full points.

---

# **🔹 4\) ETLPipeline (Controller Class)**

This class coordinates everything.

It does NOT:  
• read file directly  
• transform directly  
• write directly

It delegates.

`public class ETLPipeline {`

    `private ProductReader reader;`  
    `private ProductTransformer transformer;`  
    `private ProductWriter writer;`

    `public ETLPipeline() {`  
        `reader = new ProductReader();`  
        `transformer = new ProductTransformer();`  
        `writer = new ProductWriter();`  
    `}`

    `public void run() {`

        `String input = "data/products.csv";`  
        `String output = "data/transformed_products.csv";`

        `List<Product> products = reader.read(input);`

        `List<TransformedProduct> transformed =`  
                `new ArrayList<>();`

        `for (Product p : products) {`  
            `transformed.add(transformer.transform(p));`  
        `}`

        `writer.write(output, transformed);`  
    `}`

    `public static void main(String[] args) {`  
        `new ETLPipeline().run();`  
    `}`  
`}`

Same input.  
Same output.  
Same paths.  
Same logic.

Different structure.

---

# **Step 5: Where OO Concepts Appear**

Now let’s connect to the assignment requirement.

### **Object**

* Product  
* TransformedProduct

### **Encapsulation**

* Private fields  
* Getters  
* No direct field access

### **Class**

* Reader  
* Transformer  
* Writer  
* Pipeline

### **Polymorphism (Optional but strong)**

You could define:

`public interface Transformer<T, R> {`  
    `R transform(T input);`  
`}`

Then:

`public class ProductTransformer`  
        `implements Transformer<Product, TransformedProduct>`

Now ETLPipeline depends on the interface — not the concrete class.

That’s polymorphism.

### **Inheritance (Optional)**

You could create:

`public abstract class AbstractFileHandler {`  
    `protected String filePath;`  
`}`

But inheritance is not required if you already demonstrate polymorphism clearly.

---

# **Step 6: Confirm Requirements Checklist**

Let’s verify everything:

✅ Reads from data/products.csv  
✅ Skips header  
✅ Same validation logic  
✅ Same transformation order  
✅ Same rounding method  
✅ Same price range logic  
✅ Same column order  
✅ Always writes header  
✅ Same relative paths  
✅ Same missing file message

Only structure changed.

Behavior did not change.

That’s what the assignment wants.

---

# **Step 7: How To Explain This in Your Reflection**

You’ll say something like:

I redesigned my procedural ETL pipeline into separate classes representing the extract, transform, and load stages. I created domain objects (Product and TransformedProduct) to encapsulate data. I separated responsibilities into ProductReader, ProductTransformer, and ProductWriter to follow single-responsibility principles. The ETLPipeline class orchestrates these components. I ensured that all transformation logic, error handling, relative paths, and output format remain identical to Assignment 2\.

---

If you want next, I can:

• Draw a simple UML diagram  
• Show you how to structure the folder correctly in Eclipse  
• Help you write the reflection section  
• Or help you implement the reader validation cleanly

What would you like to tackle next?

**\#\#Prompt**   
show me ideas of my solution into multiple classes with clearer responsibilities, laying out the classes clearly. My program must still meet the exact same requirements as Assignment 2: same inputs, same outputs, same transformations, same error handling, and same relative paths. 

Perfect — let’s **brainstorm clean design ideas** without changing a single requirement.

You are redesigning structure, not behavior.

Everything must stay the same:

* ✅ Same input: `data/products.csv`  
* ✅ Same output: `data/transformed_products.csv`  
* ✅ Same transformation order  
* ✅ Same rounding logic  
* ✅ Same price ranges  
* ✅ Same error message for missing file  
* ✅ Same relative paths  
* ✅ Always write header

We’re only improving **responsibility separation**.

---

# **🔹 DESIGN OPTION 1 (Clean & Simple – Most Practical)**

This keeps things straightforward and very readable.

## **📦 Package**

`org.howard.edu.lsp.assignment3`

---

## **1️⃣ ETLPipeline (Controller / Orchestrator)**

**Responsibility:**

* Coordinates everything  
* Does NOT read, transform, or write directly  
* Maintains row counters (read / transformed / skipped)

`ETLPipeline`  
`------------`  
`+ run()`  
`+ main()`

This replaces your massive `main`.

---

## **2️⃣ Product (Raw Input Object)**

Represents one valid row from input file.

`Product`  
`------------`  
`- productId : int`  
`- name : String`  
`- price : double`  
`- category : String`  
`+ getters`

Responsibility:

* Holds raw data  
* Encapsulates fields

No transformation logic inside.

---

## **3️⃣ TransformedProduct (Output Object)**

Represents final output row.

`TransformedProduct`  
`------------`  
`- productId`  
`- name`  
`- price`  
`- category`  
`- priceRange`  
`+ toCSV()`

Responsibility:

* Represents final row  
* Formats itself for writing

Keeps writing clean.

---

## **4️⃣ ProductReader (Extract Step)**

`ProductReader`  
`------------`  
`+ read(String path) : List<Product>`

Responsibility:

* Opens `data/products.csv`  
* Skips header  
* Validates rows  
* Handles:  
  * Empty file  
  * Missing file  
  * Invalid rows  
* Tracks skipped rows  
* Returns valid Product objects

It does NOT:

* Transform  
* Write output

---

## **5️⃣ ProductTransformer (Transform Step)**

`ProductTransformer`  
`------------`  
`+ transform(Product p) : TransformedProduct`

Responsibility:  
Applies transformations in EXACT order:

1. Uppercase name  
2. Apply 10% discount if Electronics  
3. Round to 2 decimals  
4. If rounded price \> 500 AND original category was Electronics → Premium Electronics  
5. Determine PriceRange

Nothing else.

No file logic.  
No printing.

---

## **6️⃣ ProductWriter (Load Step)**

`ProductWriter`  
`------------`  
`+ write(String path, List<TransformedProduct>)`

Responsibility:

* Always writes header  
* Writes rows in correct column order  
* Writes to `data/transformed_products.csv`

Even if list is empty → header still written.

This fixes your previous grading issue.

---

# **🔹 Why This Design Is Better**

| Before | After |
| ----- | ----- |
| Everything inside main | Clear class boundaries |
| File \+ logic mixed | Separation of concerns |
| No domain model | Product is real object |
| Hard to test | Each class testable |
| Procedural | Object-Oriented |

---

# **🔹 DESIGN OPTION 2 (More Object-Oriented)**

If you want to show stronger OO concepts:

Introduce an interface.

---

## **Add a Transformer Interface (Polymorphism)**

`Transformer<T, R>`  
`------------------`  
`+ transform(T input) : R`

Then:

`ProductTransformer implements Transformer<Product, TransformedProduct>`

Now ETLPipeline depends on the interface:

`private Transformer<Product, TransformedProduct> transformer;`

That demonstrates:

✔ Polymorphism  
✔ Programming to abstraction

You could later swap transformers without changing pipeline.

---

# **🔹 DESIGN OPTION 3 (Stronger ETL Modeling)**

You could model the pipeline stages explicitly.

---

## **Create Interfaces for Each Stage**

`Extractor<T>`  
`Transformer<T, R>`  
`Loader<R>`

Then:

`ProductExtractor`  
`ProductTransformer`  
`ProductLoader`

ETLPipeline wires them together.

This makes the design feel like a true ETL engine.

Still same behavior — just cleaner modeling.

---

# **🔹 EXACT Behavior Preservation Strategy**

Here’s how you guarantee behavior stays identical:

### **1\. Copy transformation logic EXACTLY**

Do not rewrite logic differently.  
Just move it into `ProductTransformer`.

### **2\. Keep same rounding method**

Use:

`BigDecimal.setScale(2, RoundingMode.HALF_UP)`

Exactly like before.

### **3\. Keep same file paths**

Hardcode:

`"data/products.csv"`  
`"data/transformed_products.csv"`

### **4\. Keep same missing file message**

`Input file not found: data/products.csv`

Exactly identical text.

### **5\. Always write header**

Writer always writes header first.

---

# **🔹 How Responsibilities Are Now Clear**

| Class | Responsibility |
| ----- | ----- |
| Product | Raw input data |
| TransformedProduct | Final output data |
| ProductReader | Extract |
| ProductTransformer | Transform |
| ProductWriter | Load |
| ETLPipeline | Orchestrator |

Each class has ONE job.

That’s object-oriented decomposition.

---

# **🔹 What You Should NOT Do**

❌ Do not change transformation order  
❌ Do not change rounding logic  
❌ Do not change output formatting  
❌ Do not change relative paths  
❌ Do not change error message wording

Only move logic into appropriate classes.

---

# **🔹 If You Want To Be Extra Clear in Your Submission**

You could include a short design summary like:

`ETLPipeline`  
   `├── ProductReader`  
   `├── ProductTransformer`  
   `└── ProductWriter`

And mention that each class follows the Single Responsibility Principle.

---

# **🔥 The Key Idea**

Your old program was:

One big machine.

Your new program is:

A system of collaborating objects.

Same behavior.  
Better design.

---

If you want next, I can:

* Help you decide which design option is best for your grade level  
* Help you structure the exact code skeleton  
* Help you write your AI reflection section  
* Or review your redesign once you draft it

What would you like to do next?

