package atm;

public class SavingsAccount extends Account {

    public static final double MAINTAINING_BALANCE = 500.0;
    private double interestRate; // e.g., 0.02 for 2%

    public SavingsAccount(String accountNumber, String ownerName,
                          double openingBalance, double interestRate) {
        super(accountNumber, ownerName, openingBalance);
        this.interestRate = interestRate;
    }

    @Override
    public String getAccountType() {
        return "SAVINGS";
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        }

        double remaining = getBalance() - amount;
        if (remaining < MAINTAINING_BALANCE) {
            double shortfall = MAINTAINING_BALANCE - remaining;
            throw new InsufficientFundsException(shortfall);
        }

        super.withdraw(amount);
    }

    public double monthlyInterest() {
        return getBalance() * interestRate / 12;
    }
}

/*
 * THINK ABOUT IT ANSWERS:
 * 1. Why is getAccountType() declared abstract in Account instead of returning "ACCOUNT"?
 *    Declaring it abstract forces every concrete subclass (SavingsAccount, CheckingAccount)
 *    to explicitly define its specific type name. It prevents generic or incomplete
 *    instantiations and guarantees polymorphism works accurately.
 *
 * 2. Why can SavingsAccount call super.withdraw(amount) and applyWithdrawal(amount),
 *    but cannot read the private balance field by name?
 *    The 'balance' field is private to Account, making it completely invisible even to
 *    subclasses to ensure strict encapsulation. Subclasses must interact with balance
 *    through public/protected methods (like getBalance() or applyWithdrawal()) inherited
 *    from the parent.
 */