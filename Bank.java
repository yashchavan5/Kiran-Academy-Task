import java.util.Scanner;

/**
 * Task 03: Banking Console Application - Balance, Deposit & Withdrawal
 * Kiran Academy
 */
public class BankingApp {

    private static final String RUPEE = "\u20B9";          
    private static final double OPENING_BALANCE = 10000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = OPENING_BALANCE;

        System.out.println("Welcome to Kiran Bank");
        System.out.println("Opening Balance: " + RUPEE + format(balance));

        while (true) {
            System.out.println();
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            String input = sc.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                continue;
            }

            if (choice == 1) {
                System.out.println("Current Balance: " + RUPEE + format(balance));

            } else if (choice == 2) {
                System.out.print("Enter deposit amount: ");
                double amount = readAmount(sc);
                if (amount <= 0) {
                    System.out.println("Invalid amount. Deposit must be greater than " + RUPEE + "0.");
                } else {
                    balance += amount;
                    System.out.println("Deposit successful. Updated Balance: " + RUPEE + format(balance));
                }

            } else if (choice == 3) {
                System.out.print("Enter withdrawal amount: ");
                double amount = readAmount(sc);
                if (amount <= 0) {
                    System.out.println("Invalid amount. Withdrawal must be greater than " + RUPEE + "0.");
                } else if (amount > balance) {
                    System.out.println("Transaction failed: Insufficient balance.");
                    System.out.println("Current Balance: " + RUPEE + format(balance));
                } else {
                    balance -= amount;
                    System.out.println("Withdrawal successful. Updated Balance: " + RUPEE + format(balance));
                }

            } else if (choice == 4) {
                System.out.println("Thank you for banking with us. Goodbye!");
                break;

            } else {
                System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }

        sc.close();
    }

  
    private static double readAmount(Scanner sc) {
        String input = sc.nextLine().trim();
        try {
            double value = Double.parseDouble(input);
            if (Double.isNaN(value) || Double.isInfinite(value)) {
                return -1;
            }
            return value;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

   
    private static String format(double amount) {
        if (amount == Math.floor(amount)) {
            return String.valueOf((long) amount);
        }
        return String.format("%.2f", amount);
    }
}
