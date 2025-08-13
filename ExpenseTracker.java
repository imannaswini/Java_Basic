
import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String category;
    double amount;

    Expense(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return category + " - ₹" + amount;
    }
}

public class ExpenseTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Expense> expenses = new ArrayList<>();
        double total = 0;

        while (true) {
            System.out.println("\n=== Expense Tracker ===");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Total");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }
            switch(choice)
             {
                case 1:
                    System.out.print("Enter category: ");
                    String category = sc.nextLine();
                    double amount;
                    try {
                        System.out.print("Enter amount: ₹");
                        amount = Double.parseDouble(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid amount! Please enter a number.");
                        break;
                    }
                    expenses.add(new Expense(category, amount));
                    total += amount;
                    System.out.println("Expense added!");
                    break;

                case 2:
                    if (expenses.isEmpty()) {
                        System.out.println("No expenses recorded.");
                    } else {
                        System.out.println("\nYour Expenses:");
                        for (Expense exp : expenses) {
                            System.out.println("- " + exp);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Total Expenses: ₹" + total);
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
