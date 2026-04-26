/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class AccountDAO {

    public void addAccount(int customerId, String type, double balance) {
        String query = "INSERT INTO Account (customer_id, account_type, balance) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, customerId);
            stmt.setString(2, type);
            stmt.setDouble(3, balance);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateAccount(int accountId, String type, double balance) {
        String query = "UPDATE Account SET account_type=?, balance=? WHERE account_id=?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, type);
            stmt.setDouble(2, balance);
            stmt.setInt(3, accountId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean accountExists(int accountId) {
        String query = "SELECT account_id FROM Account WHERE account_id = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, accountId);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Fills JTable with Customer and Account data joined together
    public void loadCustomerAccountsToTable(javax.swing.table.DefaultTableModel model, String searchQuery) {
        model.setRowCount(0); // Clear table

        // Only filters by Account ID
        String query = "SELECT a.account_id, c.first_name, c.last_name, c.email, c.phone_number, a.balance, a.account_type "
                + "FROM Customer c JOIN Account a ON c.customer_id = a.customer_id "
                + "WHERE a.account_id LIKE ?";

        try (java.sql.Connection conn = DBConnection.getConnection(); java.sql.PreparedStatement stmt = conn.prepareStatement(query)) {

            String searchParam = "%" + (searchQuery == null ? "" : searchQuery) + "%";

            // Only 1 parameter needed now because there is only one "?" in the query
            stmt.setString(1, searchParam);

            java.sql.ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
 
                model.addRow(new Object[]{
                    rs.getInt("account_id"), // Column 0
                    rs.getString("first_name"), // Column 1
                    rs.getString("last_name"), // Column 2
                    rs.getString("email"), // Column 3
                    rs.getString("phone_number"), // Column 4   
                    rs.getDouble("balance"), // Column 5
                    rs.getString("account_type") // Column 6
                });
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

}
