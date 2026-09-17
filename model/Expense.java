package model;

public class Expense {

    private int id;
    private double amount;
    private String category;
    private String date;
    private String description;

    public Expense(int id, double amount, String category, String date, String description) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String toFileString() {
        return id + "|" + amount + "|" + category + "|" + date + "|" + description;
    }

    public void displayExpense() {
        System.out.printf(
            "%-5d %-12.2f %-15s %-15s %s%n",
            id,
            amount,
            category,
            date,
            description
        );
    }
}