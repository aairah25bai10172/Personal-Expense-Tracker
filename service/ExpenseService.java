package service;

import model.Expense;
import storage.FileStorage;

import java.util.ArrayList;

public class ExpenseService {

    private ArrayList<Expense> expenses;
    private FileStorage storage;

    public ExpenseService() {
        storage = new FileStorage();
        expenses = storage.loadExpenses();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
        storage.saveExpenses(expenses);
        System.out.println("Expense added successfully.");
    }

    public void viewExpenses() {

        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        System.out.printf(
            "%-5s %-12s %-15s %-15s %s%n",
            "ID",
            "Amount",
            "Category",
            "Date",
            "Description"
        );

        System.out.println("---------------------------------------------------------------");

        for (Expense expense : expenses) {
            expense.displayExpense();
        }
    }

    public void searchByCategory(String category) {

        boolean found = false;

        for (Expense expense : expenses) {

            if (expense.getCategory().equalsIgnoreCase(category)) {
                expense.displayExpense();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No expenses found in this category.");
        }
    }

    public void deleteExpense(int id) {

        boolean removed = expenses.removeIf(
            expense -> expense.getId() == id
        );

        if (removed) {
            storage.saveExpenses(expenses);
            System.out.println("Expense deleted successfully.");
        } else {
            System.out.println("Expense ID not found.");
        }
    }

    public double calculateTotal() {

        double total = 0;

        for (Expense expense : expenses) {
            total += expense.getAmount();
        }

        return total;
    }

    public double calculateCategoryTotal(String category) {

        double total = 0;

        for (Expense expense : expenses) {

            if (expense.getCategory().equalsIgnoreCase(category)) {
                total += expense.getAmount();
            }
        }

        return total;
    }

    public int getNextId() {

        int highestId = 0;

        for (Expense expense : expenses) {

            if (expense.getId() > highestId) {
                highestId = expense.getId();
            }
        }

        return highestId + 1;
    }
}