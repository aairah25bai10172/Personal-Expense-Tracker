package storage;

import model.Expense;

import java.io.*;
import java.util.ArrayList;

public class FileStorage {

    private final String filePath = "data/expenses.txt";

    public FileStorage() {
        File directory = new File("data");

        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    public void saveExpenses(ArrayList<Expense> expenses) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            for (Expense expense : expenses) {
                writer.write(expense.toFileString());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving expenses.");
        }
    }

    public ArrayList<Expense> loadExpenses() {

        ArrayList<Expense> expenses = new ArrayList<>();

        File file = new File(filePath);

        if (!file.exists()) {
            return expenses;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("\\|", -1);

                if (parts.length == 5) {

                    int id = Integer.parseInt(parts[0]);
                    double amount = Double.parseDouble(parts[1]);

                    Expense expense = new Expense(
                        id,
                        amount,
                        parts[2],
                        parts[3],
                        parts[4]
                    );

                    expenses.add(expense);
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading expenses.");
        }

        return expenses;
    }
}