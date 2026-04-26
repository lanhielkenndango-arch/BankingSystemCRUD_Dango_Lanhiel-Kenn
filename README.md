# Simple Banking System 🏦

## 📖 What is this project?
The **Simple Banking System** is a beginner-friendly Java application that works just like a real bank! It uses **Java Swing** for the screens and buttons (the GUI) and **MySQL** to save all the data behind the scenes. 

It is designed to show how databases and Java code talk to each other in a real-world scenario.

### Cool Features:
* **Manage Customers:** Add new people to the bank and update their info.
* **Multiple Accounts:** One person can open more than one account (for example, one customer can have both a "Savings" and a "Current" account!).
* **Make Transactions:** Deposit money into accounts or withdraw it. The system is smart—it checks for blank text boxes and won't let you withdraw more money than you actually have!
* **View History:** A neat, searchable table that shows a list of every single deposit and withdrawal ever made, just like a real bank statement.

---

## 📊 How the Database Works (ERD Explained Simply)
Our database uses three separate "tables" (think of them like three different Excel sheets) that link together to keep everything organized.

### 1. Customer Table 🧑
* **What it does:** Stores personal details about the person.
* **Important Info:** Every person gets a unique `customer_id` automatically. It also saves their first name, last name, email, and phone number.

### 2. Account Table 💳
* **What it does:** Stores the actual money and the type of account.
* **How it connects:** It uses the `customer_id` to know *who* owns the money. 
* **The Rule (One-to-Many):** One customer can own *many* accounts, but an account can only belong to *one* customer.

### 3. Transaction Table 🧾
* **What it does:** Acts like a receipt book. It logs every single time money goes in or out.
* **How it connects:** It uses the `account_id` to know *which* specific account the money was moved from or to.
* **The Rule (One-to-Many):** One account will have *many* transactions saved over time.

---

## 🚀 How to Run this Code on Your Computer

### What you need first:
* **Java IDE:** Apache NetBeans is highly recommended for this project!
* **Database:** MySQL Server and MySQL Workbench installed on your computer.

### Step 1: Set up the Database
1. Open MySQL Workbench.
2. Create a new database by typing and running this code:
   ```sql
   CREATE DATABASE simple_banking_system;
