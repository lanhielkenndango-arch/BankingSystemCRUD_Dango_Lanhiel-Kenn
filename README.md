# Simple Banking System 🏦

## 📖 System Description
The **Simple Banking System** is a desktop-based Java application built using Java Swing for the Graphical User Interface (GUI) and MySQL for database management. It is designed to simulate basic banking operations, allowing bank tellers or administrators to manage customer information, open new accounts, process financial transactions, and view detailed transaction logs.

### Key Features:
* **Customer & Account Management:** Add, update, view, and delete customers. Supports a one-to-many relationship where a single customer can open multiple accounts (e.g., Savings, Current).
* **Transaction Processing:** Securely process Deposits and Withdrawals. Includes an account verification step and built-in protections against insufficient funds and invalid inputs.
* **Transaction History:** A detailed, searchable log of all transactions containing Transaction IDs, Account IDs, Transaction Types, Amounts, and Timestamps.
* **Input Validation:** Prevents blank entries, invalid numbers, and ensures database integrity.

---

## 📊 ERD (Entity-Relationship Diagram) Explanation
The system's database relies on three core tables interconnected by relational foreign keys to maintain data integrity.

### 1. Customer Table
* **Description:** Stores the personal information of the bank's clients.
* **Primary Key:** `customer_id` (Auto-incremented)
* **Fields:** `first_name`, `last_name`, `email`, `phone_number`

### 2. Account Table
* **Description:** Stores the financial account details belonging to a customer.
* **Primary Key:** `account_id` (Auto-incremented)
* **Foreign Key:** `customer_id` (References `Customer.customer_id` with ON DELETE CASCADE)
* **Fields:** `account_type` (e.g., Savings, Checking), `balance`
* **Relationship:** **1-to-Many** with the Customer table. One customer can own multiple accounts, but one account belongs to exactly one customer.

### 3. Transaction Table
* **Description:** Acts as a ledger, logging every deposit and withdrawal made to any account.
* **Primary Key:** `transaction_id` (Auto-incremented)
* **Foreign Key:** `account_id` (References `Account.account_id` with ON DELETE CASCADE)
* **Fields:** `transaction_type` (Deposit/Withdraw), `amount`, `transaction_date`
* **Relationship:** **1-to-Many** with the Account table. One account can have hundreds of transactions over time.

---

## 🚀 How to Run the Program

### Prerequisites
1. **Java Development Kit (JDK):** Ensure JDK 8 or higher is installed.
2. **IDE:** Apache NetBeans (Recommended) or IntelliJ/Eclipse.
3. **Database:** MySQL Server and MySQL Workbench.
4. **Driver:** MySQL Connector/J (JDBC Driver).

### Step 1: Database Setup
1. Open MySQL Workbench.
2. Create a new database named `simple_banking_system`:
   ```sql
   CREATE DATABASE simple_banking_system;
