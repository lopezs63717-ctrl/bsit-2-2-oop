// Payment.java
// The ABSTRACTION. This class holds everything that is true of EVERY payment.[cite: 1]
// TODO 3: Add the keyword "abstract" before the word class.[cite: 1]
public abstract class Payment {
    private final int id;
    private String payerName;
    private double amount;

    public Payment(int id, String payerName, double amount) {
        this.id = id;
        this.payerName = payerName;
        this.amount = amount;
    }

    public int getId() { return id; }
    public String getPayerName() { return payerName; }
    public double getAmount() { return amount; }

    // TODO 4: Declare TWO abstract methods here: pay() and provider()[cite: 1]
    public abstract void pay();
    public abstract String provider();

    // Version 1 of serviceFee (standard fee is 2% of the amount)[cite: 1]
    public double serviceFee() {
        return amount * 0.02;
    }

    // TODO 5: OVERLOADING. Write a SECOND serviceFee method that takes a double rate parameter.[cite: 1]
    public double serviceFee(double rate) {
        return amount * rate;
    }

    // TODO 6: Write ONE System.out.printf line inside printReceipt().[cite: 1]
    public void printReceipt() {
        System.out.printf("[%d] %-6s %-10s PHP %8.2f\n", id, provider(), payerName, amount);
        pay();
    }

    public void printThankYou() {
        System.out.println("   Thank you for your payment.");
    }
}