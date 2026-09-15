
public interface Refundable {
    // TODO 1: Declare an abstract method called refund that returns a String and takes no parameters.[cite: 1]
    String refund();

    // TODO 2: Write a DEFAULT method called printRefundNotice that returns nothing (void) and takes no parameters.[cite: 1]
    default void printRefundNotice() {
        System.out.println("   " + refund());
    }
}