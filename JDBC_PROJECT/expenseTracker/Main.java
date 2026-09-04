package com.expenseTracker;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ExpenseDAO dao = new ExpenseDAO();

        while (true) {

            System.out.println("\n==============================");
            System.out.println("       EXPENSE TRACKER");
            System.out.println("==============================");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Update Expense");
            System.out.println("4. Delete Expense");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();

                    System.out.print("Enter expense title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String dateInput = sc.nextLine();

                    Date expenseDate = Date.valueOf(dateInput);

                    Expense expense = new Expense(
                            title,
                            amount,
                            category,
                            expenseDate
                    );

                    dao.addExpense(expense);
                    break;

                case 2:
                    List<Expense> expenses = dao.getAllExpenses();

                    if (expenses.isEmpty()) {
                        System.out.println("No expenses found.");
                    } else {
                        System.out.println("\n-------------------------------------------------------------");
                        System.out.printf(
                                "%-5s %-20s %-10s %-15s %-15s%n",
                                "ID", "TITLE", "AMOUNT", "CATEGORY", "DATE"
                        );
                        System.out.println("-------------------------------------------------------------");

                        for (Expense e : expenses) {
                            System.out.printf(
                                    "%-5d %-20s %-10.2f %-15s %-15s%n",
                                    e.getId(),
                                    e.getTitle(),
                                    e.getAmount(),
                                    e.getCategory(),
                                    e.getExpenseDate()
                            );
                        }

                        System.out.println("-------------------------------------------------------------");
                    }
                    break;

                case 3:
                    System.out.print("Enter expense ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new title: ");
                    String newTitle = sc.nextLine();

                    System.out.print("Enter new amount: ");
                    double newAmount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter new category: ");
                    String newCategory = sc.nextLine();

                    System.out.print("Enter new date (YYYY-MM-DD): ");
                    String newDateInput = sc.nextLine();

                    Date newDate = Date.valueOf(newDateInput);
                    dao.updateExpense(
                            updateId,
                            newTitle,
                            newAmount,
                            newCategory,
                            newDate
                    );
                    break;

                case 4:
                    System.out.print("Enter expense ID to delete: ");
                    int deleteId = sc.nextInt();

                    dao.deleteExpense(deleteId);
                    break;

                case 5:
                    System.out.println("Thank you for using Expense Tracker!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
