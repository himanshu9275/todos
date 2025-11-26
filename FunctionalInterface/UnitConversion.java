public interface UnitConversion {
    static double kmToMiles(double km) { return km * 0.621371; }
    static double kgToLbs(double kg) { return kg * 2.20462; }
    static double milesToKm(double m) { return m / 0.621371; }
}

// Demo
public class UnitDemo {
    public static void main(String[] args) {
        System.out.println("10 km -> " + UnitConversion.kmToMiles(10) + " miles");
        System.out.println("5 kg -> " + UnitConversion.kgToLbs(5) + " lbs");
    }
}
