/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class TransactionDAO {

    public boolean processTransaction(int accountId, double amount, String type) {
        String checkBalance = "SELECT balance FROM Account WHERE account_id = ?";
        String updateBalance = "UPDATE Account SET balance = balance + ? WHERE account_id = ?";
        String logTransaction = "INSERT INTO Transaction (account_id, transaction_type, amount, transaction_date) VALUES (?, ?, ?, CURRENT_DATE)";

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false); // Start database transaction

            // Check balance for withdrawals
            if (type.equals("Withdraw")) {
                try (PreparedStatement stmt = conn.prepareStatement(checkBalance)) {
                    stmt.setInt(1, accountId);
                    ResultSet rs = stmt.executeQuery();
                    if (rs.next() && rs.getDouble("balance") < amount) {
                        JOptionPane.showMessageDialog(null, "Insufficient Funds!");
                        return false;
                    }
                }
                // Make the amount negative so the "+ ?" query subtracts it
                amount = -amount;
            }

            //  Update the Account balance
            try (PreparedStatement stmt = conn.prepareStatement(updateBalance)) {
                stmt.setDouble(1, amount); // If withdraw, this is now a negative number
                stmt.setInt(2, accountId);
                stmt.executeUpdate();
            }

            //  Log the transaction 
            // Convert amount back to positive if you want to store it as a positive number in history
            try (PreparedStatement stmt = conn.prepareStatement(logTransaction)) {
                stmt.setInt(1, accountId);
                stmt.setString(2, type);
                stmt.setDouble(3, Math.abs(amount)); 
                stmt.executeUpdate();
            }

            conn.commit(); // Save changes
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void loadTransactionsToTable(DefaultTableModel model, String accountIdStr) {
        model.setRowCount(0);
        String query = "SELECT * FROM Transaction";
        if (accountIdStr != null && !accountIdStr.isEmpty()) {
            query += " WHERE account_id = ?";
        }
        query += " ORDER BY transaction_date DESC";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            if (accountIdStr != null && !accountIdStr.isEmpty()) {
                stmt.setInt(1, Integer.parseInt(accountIdStr));
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
               
                model.addRow(new Object[]{
                    rs.getInt("transaction_id"),       // Column 0: Transaction ID
                    rs.getInt("account_id"),           // Column 1: Account ID
                    rs.getString("transaction_type"),  // Column 2: Type
                    rs.getDouble("amount"),            // Column 3: Amount
                    rs.getDate("transaction_date")     // Column 4: Date
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
