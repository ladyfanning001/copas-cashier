# 📋 Copas Cashier Application

## Project Overview
**Copas** is a growing food and beverage outlet known for its flavorful dishes. As customer visits increase, Copas faces operational challenges due to a manual order-taking process using paper notes and calculators. This often leads to calculation errors and delays during peak hours, as well as the absence of standardized receipts for customers.

To address these issues, Copas has implemented a **simple cashier application** designed to improve efficiency, accuracy, and service quality. This application streamlines the order and payment process, minimizes input errors, and generates professional receipts for customers.

---

## 🧾 Cashier Workflow

1. **Customer Orders**  
   - Customers arrive and choose menu items (e.g., *Nasi Goreng Bebek Cabe Ijo*, *Salted Caramel Coffee*).  
   - They relay their order to the cashier.

2. **Cashier Inputs the Order**  
   - The cashier selects items from a digital menu within the app.  
   - Quantity is entered.  
   - Presses "Add to Order" to update the current customer order.

3. **Real-Time Order Display**  
   - Each added item appears instantly in the order summary section.  
   - Includes: Item name, quantity, unit price, and subtotal per item.

4. **Automatic Total Calculation**  
   - The app calculates the overall total once all items are entered.

5. **Payment Process**  
   - The cashier informs the customer of the total amount.  
   - Payment is made (cash or non-cash).

6. **Receipt Generation**  
   - The cashier clicks "Print Receipt".  
   - The receipt includes:
     - List of all ordered items  
     - Quantity and unit price  
     - Subtotal per item  
     - Total amount paid

---

## 🔧 Technical Features

### Object-Oriented Programming Concepts

#### ✅ Abstraction & Inheritance
- `MenuItem` is an **abstract class** representing general menu items.
- `Food` and `Drink` are **subclasses** that inherit from `MenuItem`.
- The `getDescription()` method is abstract and must be implemented by all subclasses.

#### ✅ Polymorphism
- Achieved through **method overriding**, allowing subclasses (`Food`, `Drink`) to customize behavior such as:
  - `getDescription()`  
  - `calculateExtraCost()` *(if applicable)*

#### ✅ Interface
- A `Printable` **interface** defines a `printReceipt()` method.  
- Classes responsible for formatting and printing the receipt (e.g., `OrderReceipt`) implement this interface, ensuring a consistent contract for receipt printing.

#### ✅ Generics & Collections
- Menu items are managed using collections (e.g., `ArrayList<MenuItem>`).  
- This enables dynamic handling of orders and simplifies iteration and processing.

---

## 💾 Data Persistence

- Order data is saved using **Java Serialization** (`.ser` file format).
- Receipts can also be saved as standard `.txt` files for easy viewing and archival.

---

## 🖥️ Graphical User Interface (GUI)

- Built using **NetBeans Matisse GUI Builder**.
- Features include:
  - Organized order form with separate tabs for Food and Drink.
  - Functional buttons: *Add to Order*, *Print Receipt*, etc.
  - A table view for displaying current order details.
  - **Receipt Preview Dialog**: Allows users to preview the receipt before printing or saving.

---

## ✅ Summary

The Copas Cashier Application is a practical, object-oriented Java application that simplifies the transaction process at a growing food outlet. It enhances customer experience and cashier productivity by ensuring faster service, accurate order handling, and professional documentation.

---
