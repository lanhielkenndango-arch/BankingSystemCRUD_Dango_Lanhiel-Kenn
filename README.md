# Simple Banking System

## System Description
The Simple Banking System is a desktop application created using Java and MySQL. It is built to show how a basic bank operates. The project uses Java Swing for the visual screens and buttons, and a MySQL database to securely save all the information. 

### Key Features:
* **Customer and Account Management:** Users can add, update, and delete customer profiles. The system allows a single customer to open more than one account (for example, a Savings account and a Checking account).
* **Process Transactions:** Users can securely deposit and withdraw money. The system includes safety checks, such as preventing withdrawals if the account does not have enough balance.
* **Transaction History:** A detailed, searchable table that acts as a bank statement, showing exactly when and how much money was moved.
* **Input Protection:** The system prevents users from leaving required fields blank or typing text into number fields, preventing database errors.

---

## ERD (Entity-Relationship Diagram) Explanation
The database is divided into three connected tables to keep the data organized and prevent duplicate information. 

### 1. Customer Table
* **Purpose:** Stores the personal details of the people using the bank.
* **Columns:** Customer ID (automatically created), First Name, Last Name, Email, and Phone Number.

### 2. Account Table
* **Purpose:** Stores the money and the specific type of account.
* **How it connects:** It contains the Customer ID to identify who owns the account.
* **Relationship (1-to-Many):** One customer can own multiple accounts, but a specific account belongs to only one customer.

### 3. Transaction Table
* **Purpose:** Acts as a history log for every deposit and withdrawal.
* **How it connects:** It contains the Account ID to identify where the money went.
* **Relationship (1-to-Many):** One account will have multiple transactions recorded over time.

---

## How to Run the Program

### What You Need Installed
1. **Java Development Kit (JDK):** Version 8 or higher.
2. **Code Editor:** Apache NetBeans (Recommended) or similar IDEs.
3. **Database:** MySQL Server and MySQL Workbench.
4. **Driver:** MySQL Connector/J (JDBC Driver) so Java can talk to MySQL.

### Set Up the Database
1. Open MySQL Workbench.
2. Create a new database by running this SQL command:
   ```sql
   CREATE DATABASE simple_banking_system;

This is the demo po sir
   https://drive.google.com/file/d/1tOnB6tOB8-ljTB4qfxXPaobvOdkfY4Js/view?usp=drive_link

   <img width="1186" height="599" alt="image" src="https://github.com/user-attachments/assets/b06a3331-9659-463a-9831-ae5b66b1965e" />

   <img width="980" height="854" alt="image" src="https://github.com/user-attachments/assets/a2a8a955-7121-4008-8a7d-9649e1f8131c" />
   <img width="489" height="293" alt="image" src="https://github.com/user-attachments/assets/b34f2e44-489f-4fa8-bc88-778d921bd200" />
   <img width="528" height="400" alt="image" src="https://github.com/user-attachments/assets/b36b7486-c899-4a19-a439-86313d6f59bf" />
   <img width="516" height="327" alt="image" src="https://github.com/user-attachments/assets/31d5707a-d455-4518-a769-b1bc00effc42" />
   <img width="718" height="559" alt="image" src="https://github.com/user-attachments/assets/0bb6dfe3-cdf6-4a99-aa47-9570a4fc2239" />






