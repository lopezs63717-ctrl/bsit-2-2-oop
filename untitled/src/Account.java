public class Account {
    // Fields are PRIVATE - no one outside can touch them directly.
    private String owner;
    private double balance;

    // Constructor: runs when the account is created.
    public Account(String owner, double openingBalance) {
        this.owner = owner;
        // TODO 1: only accept an opening balance of 0 or more.
        // If it is negative, set the balance to 0 instead.
        if (openingBalance < 0) {
            this.balance = 0;
        } else {
            this.balance = openingBalance;
        }
    }

    // TODO 2: add a getter named getOwner() that RETURNS the owner.
    public String getOwner() {
        return this.owner;
    }

    // TODO 3: add a getter named getBalance() that RETURNS the balance.
    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        // TODO 4: if amount <= 0, print "Invalid amount." and return.
        // Otherwise add amount to balance and print the new balance.
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }
        this.balance += amount;
        System.out.println("Deposited " + amount + ". New balance: " + this.balance);
    }

    public void withdraw(double amount) {
        // TODO 5: if amount <= 0, print "Invalid amount." and return.
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }
        // TODO 6: if amount > balance, print "Insufficient funds." and return.
        // Otherwise subtract amount from balance and print the new balance.
        if (amount > this.balance) {
            System.out.println("Insufficient funds.");
            return;
        }
        this.balance -= amount;
        System.out.println("Withdrew " + amount + ". New balance: " + this.balance);
    }
}