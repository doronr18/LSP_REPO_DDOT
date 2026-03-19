# Design Evaluation
<!-- Observed Problems -->

1. Violates Open/Closed Principle (OCP)  
Adding a new customer type requires modifying the calculatePrice method. The class is not easily extensible because behavior is hard-coded.

2. Use of Conditional Logic
Multiple if statements handle different customer types which won't scale well if the number of customer types increases.

3. Single Responsibility Violation
The class is responsible for knowing all discount rules and performing calculations, rather than delegating responsibility to dedicated components.

<!-- Consequences -->

The design is rigid and not maintainable. Adding promotions or different pricing strategies requires modifying this class. The system would be better with a design pattern that encapsulates discount behaviors and supports extension without modification.