import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Class to represent each expense
class Expense {
    private String name;
    private double amount;
    private String category;

    public Expense(String name, double amount, String category) {
        this.name = name;
        this.amount = amount;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Expense [Name: " + name + ", Amount: $" + amount + ", Category: " + category + "]";
    }
}

// Main Expense Tracker class
public class ExpenseTracker {
    private static List<Expense> expenses = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Expense Tracker!");

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. View Total Expenses");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (option) {
                case 1:
                    addExpense(scanner);
                    break;
                case 2:
                    viewAllExpenses();
                    break;
                case 3:
                    viewTotalExpenses();
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting the Expense Tracker. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option! Please select a valid option.");
            }
        }

        scanner.close();
    }

    // Method to add a new expense
    private static void addExpense(Scanner scanner) {
        System.out.print("Enter expense name: ");
        String name = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline
        System.out.print("Enter category (e.g., Food, Transport, Entertainment): ");
        String category = scanner.nextLine();

        Expense newExpense = new Expense(name, amount, category);
        expenses.add(newExpense);

        System.out.println("Expense added successfully!");
    }

    // Method to view all expenses
    private static void viewAllExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded yet.");
        } else {
            System.out.println("\nAll Expenses:");
            for (Expense expense : expenses) {
                System.out.println(expense);
            }
        }
    }

    // Method to view total expenses
    private static void viewTotalExpenses() {
        double total = 0.0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        System.out.println("Total Expenses: $" + total);
    }
}