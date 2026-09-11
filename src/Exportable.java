// Exportable.java
// An INTERFACE = a list of promises. It says WHAT, never HOW.
//
// Any class that implements Exportable promises it can turn itself
// into one line of CSV text, for example: 1,Razz,razz@liceo.edu.ph,ADMIN
public interface Exportable {
    // TODO 1: Declare an abstract method called toCsv that returns a String
    // and takes no parameters.
    String toCsv();

    // TODO 2: Write a DEFAULT method called printExport that returns nothing
    // (void) and takes no parameters.
    default void printExport() {
        System.out.println(toCsv());
    }
}
