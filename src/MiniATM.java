import java.util.Scanner;

public class MiniATM {

    static double balance = 1000.00;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println(" WELCOME TO THE MINI ATM");
        System.out.println("=========================================");

        boolean running = true;

        while (running) {
            printMenu();
            String choice = input.nextLine().trim();

            switch (choice) {
                case "1":
                    deposit();
                    break;
                case "2":
                    withdraw();
                    break;
                case "3":
                    checkBalance();
                    break;
                case "4":
                    running = false;
                    System.out.println("\nThank you for using the Mini ATM. Goodbye!");
                    break;
                default:
                    System.out.println("\n[!] Please choose a number from 1 to 4.\n");
            }
        }
    }

    static void printMenu() {
        System.out.println("Current options:");
        System.out.println(" [1] Deposit");
        System.out.println(" [2] Withdraw");
        System.out.println(" [3] Check balance");
        System.out.println(" [4] Exit");
        System.out.print("Enter your choice: ");
    }

    // You'll add deposit(), withdraw(), and checkBalance() below.
}