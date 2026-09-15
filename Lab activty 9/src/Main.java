import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentGateway gateway = new PaymentGateway();

        // Sample initial data for testing
        gateway.add(new GCashPayment(1001, "Ana", 1500.00, "0917-555-0134"));
        gateway.add(new MayaPayment(1002, "Jerome", 899.50, "jerome@liceo.edu.ph"));
        gateway.add(new CashPayment(1003, "Liza", 250.00));

        boolean running = true;
        int nextId = 1004;

        while (running) {
            System.out.println("\n=== LICEO PAY GATEWAY ===");
            System.out.println("1. Make a Payment");
            System.out.println("2. Process All Payments (Print Receipts)");
            System.out.println("3. Find Payment by ID");
            System.out.println("4. Show Total Amount Collected");
            System.out.println("5. Refund All Refundable Payments");
            System.out.println("6. Show Service Fees (Overloading Test)");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("\n--- Make a Payment ---");
                    System.out.print("Enter Payer Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Select Payment Method:");
                    System.out.println("1. GCash");
                    System.out.println("2. Maya");
                    System.out.println("3. Cash");
                    System.out.print("Choice: ");
                    int method = scanner.nextInt();
                    scanner.nextLine();

                    if (method == 1) {
                        System.out.print("Enter Mobile Number: ");
                        String mobile = scanner.nextLine();
                        gateway.add(new GCashPayment(nextId++, name, amount, mobile));
                        System.out.println("GCash payment recorded.");
                    } else if (method == 2) {
                        System.out.print("Enter Email Address: ");
                        String email = scanner.nextLine();
                        gateway.add(new MayaPayment(nextId++, name, amount, email));
                        System.out.println("Maya payment recorded.");
                    } else if (method == 3) {
                        gateway.add(new CashPayment(nextId++, name, amount));
                        System.out.println("Cash payment recorded.");
                    } else {
                        System.out.println("Invalid payment method.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- All Payment Receipts ---");
                    gateway.processAll();
                    break;

                case 3:
                    System.out.print("\nEnter Payment ID to find: ");
                    int searchId = scanner.nextInt();
                    Payment p = gateway.findById(searchId);
                    if (p != null) {
                        System.out.println("Payment Found:");
                        p.printReceipt();
                    } else {
                        System.out.println("Payment ID " + searchId + " not found.");
                    }
                    break;

                case 4:
                    System.out.printf("\nTotal Collected: PHP %.2f\n", gateway.totalCollected());
                    break;

                case 5:
                    System.out.println("\n--- Refunding Payments ---");
                    gateway.refundAll();
                    break;

                case 6:
                    System.out.println("\n--- Service Fees ---");
                    gateway.showServiceFees();
                    break;

                case 7:
                    System.out.println("Exiting program. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please choose between 1 and 7.");
            }
        }
        scanner.close();
    }
}