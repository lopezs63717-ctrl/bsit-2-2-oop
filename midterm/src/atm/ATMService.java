package atm;

public class ATMService {

    // Overloading method 1
    public void deposit(Account account, double amount) {
        account.deposit(amount);
        System.out.printf("Deposited PHP %.2f. New balance: PHP %.2f%n",
                amount, account.getBalance());
    }

    // Overloading method 2
    public void deposit(Account account, double amount, String note) {
        account.deposit(amount);
        System.out.printf("Deposited PHP %.2f (%s). New balance: PHP %.2f%n",
                amount, note, account.getBalance());
    }

    // Varargs demonstration
    public double depositAll(Account account, double... amounts) {
        double total = 0;
        for (double amount : amounts) {
            account.deposit(amount);
            total += amount;
        }
        return total;
    }

    // Pass-by-Value (Reassignment)
    public void tryToReplace(Account account) {
        account = new SavingsAccount("XX-000", "Ghost Account", 0, 0);
        System.out.println("Inside the method  : " + account);
        /*
         * EXPLANATION:
         * Java passes object references by value. The parameter 'account' is a COPY
         * of the original reference. Reassigning 'account' to a new object inside this
         * method only changes where the copy points; it does not change the reference
         * held by the variable in the caller (main).
         */
    }

    // Pass-by-Value (Mutation)
    public void addBonus(Account account, double bonus) {
        account.deposit(bonus);
        /*
         * EXPLANATION:
         * Although the reference itself was passed by value, both the local variable
         * and main()'s variable point to the exact same object on the heap. Calling
         * methods that modify internal state (mutations) directly affects the shared
         * object, making the change visible outside this method.
         */
    }

    // Account transfer
    public void transfer(Account from, Account to, double amount)
            throws InsufficientFundsException {
        from.withdraw(amount); // Withdraw first to prevent creating money out of nowhere
        to.deposit(amount);
    }
}