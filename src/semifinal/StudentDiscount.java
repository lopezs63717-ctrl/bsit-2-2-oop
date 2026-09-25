package semifinal;


public interface StudentDiscount {

    // TODO 1 (5 pts): Declare an abstract method named discountedFare()
    //   that returns a double. No body - just end it with a semicolon.
    double discountedFare();


    default void printDiscount() {
        System.out.printf("  Student fare   : PHP %.2f%n", discountedFare());
    }
}