package semifinal;


// TODO 4 (4 pts): Complete the class header so Tricycle
//   EXTENDS Ride and IMPLEMENTS StudentDiscount.
public class Tricycle extends Ride implements StudentDiscount {


    public Tricycle(String passenger, double km) {
        super(passenger, km);
    }

    // TODO 5 (8 pts): Override THREE methods. Put @Override above each.
    //   a) fare()           - if getKm() <= 2 return 20.00,
    //                         otherwise 20.00 + (getKm() - 2) * 8.00
    //   b) vehicle()        - return "Tricycle"
    //   c) discountedFare() - return fare() * 0.80
    @Override
    public double fare() {
        if (getKm() <= 2) {
            return 20.00;
        }
        return 20.00 + (getKm() - 2) * 8.00;
    }

    @Override
    public String vehicle() {
        return "Tricycle";
    }

    @Override
    public double discountedFare() {
        return fare() * 0.80;
    }
}