# Design Evaluation
<!--Observed Design Issues -->

1. Poor Encapsulation
The data of customerName, email, item, price are declared public. This exposes internal state, making it easy for external code to modify attributes in unintended ways, violating the principle of encapsulation.

2. Single Responsibility Violation
The processOrder method handles multiple responsibilities:  
     - Calculating tax and discounts  
     - Printing a receipt  
     - Persisting order to a file  
     - Sending confirmation email  
     - Logging activity  
According to the Single Responsibility Principle, each class or method should have one reason to change. Violating this principle makes maintenance difficult.

3. Violation of Design Heuristics (Arthur Riel):
   - Avoid doing too much in one class: The class combines domain logic, persistence, and UI.  
   - Prefer polymorphic behavior over conditionals: Discount application and order logging could be separated into classes or strategies.  
   - Encapsulate what varies: Methods like saving orders or sending emails may change independently but are not encapsulated.

<!-- Consequences -->

- Poor maintainability: Adding a new notification method or changing persistence requires modifying this class.  
- Poor testability: Methods are difficult to unit test due to tight coupling with I/O and System.out.  
- Limited extensibility: Adapting the system to multiple order types, multiple storage mechanisms, or multiple notification channels is difficult to handle.  

The OrderProcessor mixes responsibilities, exposes data, and hardcodes behaviors, violating key object-oriented principles. Refactoring is needed to improve encapsulation, cohesion, and maintainability.