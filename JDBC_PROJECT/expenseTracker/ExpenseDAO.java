package com.expenseTracker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO {

    public void addExpense(Expense expense) {

        String sql = "INSERT INTO expense (title, amount, category, expense_date) VALUES (?, ?, ?, ?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, expense.getTitle());
            ps.setDouble(2, expense.getAmount());
            ps.setString(3, expense.getCategory());
            ps.setDate(4, expense.getExpenseDate());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Expense added successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Expense> getAllExpenses() {

        List<Expense> expenses = new ArrayList<>();
        String sql = "SELECT * FROM expense";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {

                Expense expense = new Expense();

                expense.setId(rs.getInt("id"));
                expense.setTitle(rs.getString("title"));
                expense.setAmount(rs.getDouble("amount"));
                expense.setCategory(rs.getString("category"));
                expense.setExpenseDate(rs.getDate("expense_date"));

                expenses.add(expense);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return expenses;
    }

    public void updateExpense(int id, String title, double amount,
                              String category, Date expenseDate) {

        String sql = "UPDATE expense SET title = ?, amount = ?, category = ?, expense_date = ? WHERE id = ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, title);
            ps.setDouble(2, amount);
            ps.setString(3, category);
            ps.setDate(4, expenseDate);
            ps.setInt(5, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Expense updated successfully!");
            } else {
                System.out.println("Expense ID not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteExpense(int id) {

        String sql = "DELETE FROM expense WHERE id = ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Expense deleted successfully!");
            } else {
                System.out.println("Expense ID not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

