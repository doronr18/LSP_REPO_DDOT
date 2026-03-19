# Proposed Design Using CRC Cards

### CRC Card 1
Class: Order  

Responsibilities:
- Store order information (customer, items, price)
- Calculate subtotal, tax, and total  
- Apply discounts  
  
Collaborators:
- None (self-contained for order data and calculations)



### CRC Card 2
Class: OrderPrinter  

Responsibilities:  
- Print order receipts  
  
Collaborators:
- Order (to retrieve order details)



### CRC Card 3
Class: OrderPersistence  

Responsibilities: 
- Save orders to storage
    
Collaborators: 
- Order (to access order data)



### CRC Card 4
Class: NotificationService 

Responsibilities: 
- Send confirmation emails or messages 
 
Collaborators: 
- Order (to access customer email and order details)



### CRC Card 5
Class: OrderProcessor  

Responsibilities: 
  - Coordinate order processing workflow  
  - Apply discounts  
  - Persist order  
  - Print receipt  
  - Send notifications  
  - Log processing  
  
Collaborators:  
- Order  
- OrderPrinter  
- OrderPersistence  
- NotificationService