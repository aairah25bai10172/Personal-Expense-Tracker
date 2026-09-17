import model.Expense;
import service.ExpenseService;
import util.InputValidator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ExpenseService service = new ExpenseService();

        int choice;

        do {

            System.out.println("\n======================================");
            System.out.println("       PERSONAL EXPENSE TRACKER");
            System.out.println("======================================");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Search by Category");
            System.out.println("4. Delete Expense");
            System.out.println("5. Show Total Expense");
            System.out.println("6. Show Category Total");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Enter a valid number: ");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter amount: ");

                    while (!scanner.hasNextDouble()) {
                        System.out.print("Enter a valid amount: ");
                        scanner.next();
                    }

                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    if (!InputValidator.isValidAmount(amount)) {
                        System.out.println("Amount must be greater than zero.");
                        break;
                    }

                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();

                    if (InputValidator.isEmpty(category)) {
                        System.out.println("Category cannot be empty.");
                        break;
                    }

                    System.out.print("Enter date: ");
                    String date = scanner.nextLine();

                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();

                    Expense expense = new Expense(
                        service.getNextId(),
                        amount,
                        category,
                        date,
                        description
                    );

                    service.addExpense(expense);
                    break;

                case 2:

                    service.viewExpenses();
                    break;

                case 3:

                    System.out.print("Enter category to search: ");
                    String searchCategory = scanner.nextLine();

                    System.out.println("\nMatching Expenses:");
                    service.searchByCategory(searchCategory);
                    break;

                case 4:

                    System.out.print("Enter expense ID to delete: ");

                    while (!scanner.hasNextInt()) {
                        System.out.print("Enter a valid ID: ");
                        scanner.next();
                    }

                    int id = scanner.nextInt();
                    scanner.nextLine();

                    service.deleteExpense(id);
                    break;

                case 5:

                    System.out.printf(
                        "Total Expense: ₹%.2f%n",
                        service.calculateTotal()
                    );
                    break;

                case 6:

                    System.out.print("Enter category: ");
                    String totalCategory = scanner.nextLine();

                    System.out.printf(
                        "Total for %s: ₹%.2f%n",
                        totalCategory,
                        service.calculateCategoryTotal(totalCategory)
                    );
                    break;

                case 7:

                    System.out.println("Thank you for using Expense Tracker!");
                    break;

                default:

                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 7);

        scanner.close();
    }
}