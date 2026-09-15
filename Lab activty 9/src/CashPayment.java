// CashPayment.java
// A CHILD of Payment that is NOT Refundable.[cite: 1]
// TODO 9: Make this class extend Payment. Do NOT implement Refundable.[cite: 1]
public class CashPayment extends Payment {

    public CashPayment(int id, String payerName, double amount) {
        super(id, payerName, amount);
    }

    @Override
    public String provider() {
        return "CASH";
    }

    @Override
    public void pay() {
        System.out.printf("   Cash: PHP %.2f received. Please get your change.\n", getAmount());
    }
}