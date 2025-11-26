import java.util.*;

// -----------------------------
// Vehicle Rental System
// -----------------------------

// Insurable interface
interface Insurable {
    double calculateInsurance(int days);    // returns insurance amount for the rental period
    String getInsuranceDetails();           // readable insurance details (policy id masked, etc.)
}

// Abstract Vehicle
abstract class Vehicle {
    private String vehicleNumber;   // e.g., "MH12AB1234"
    private String type;            // Car / Bike / Truck
    private double rentalRatePerDay;

    public Vehicle(String vehicleNumber, String type, double rentalRatePerDay) {
        setVehicleNumber(vehicleNumber);
        setType(type);
        setRentalRatePerDay(rentalRatePerDay);
    }

    // Abstract method: different vehicles can compute cost differently (discounts, extra fees, ...)
    public abstract double calculateRentalCost(int days);

    // Common method to display basic details
    public void displayDetails() {
        System.out.printf("%s [%s] - Rate/day: %.2f%n", getVehicleNumber(), getType(), getRentalRatePerDay());
    }

    // Encapsulation: getters & setters with validation
    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) {
        if (vehicleNumber == null || vehicleNumber.trim().isEmpty()) throw new IllegalArgumentException("Invalid vehicle number");
        this.vehicleNumber = vehicleNumber.trim();
    }

    public String getType() { return type; }
    protected void setType(String type) {
        if (type == null || type.trim().isEmpty()) throw new IllegalArgumentException("Invalid vehicle type");
        this.type = type.trim();
    }

    public double getRentalRatePerDay() { return rentalRatePerDay; }
    public void setRentalRatePerDay(double rentalRatePerDay) {
        if (rentalRatePerDay < 0) throw new IllegalArgumentException("Rental rate cannot be negative");
        this.rentalRatePerDay = rentalRatePerDay;
    }
}

// -----------------------------
// Concrete vehicle implementations
// -----------------------------

// Car is insurable
class Car extends Vehicle implements Insurable {
    private int seatingCapacity;
    // Insurance policy number is sensitive; keep it private and expose only via getInsuranceDetails()
    private final String insurancePolicyNumber;
    private static final double INSURANCE_RATE_PER_DAY_PERCENT = 0.03; // 3% of daily rate per day as example

    public Car(String vehicleNumber, double ratePerDay, int seatingCapacity, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", ratePerDay);
        this.seatingCapacity = seatingCapacity;
        if (insurancePolicyNumber == null || insurancePolicyNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Insurance policy number required for Car");
        }
        this.insurancePolicyNumber = insurancePolicyNumber.trim();
    }

    @Override
    public double calculateRentalCost(int days) {
        if (days < 1) throw new IllegalArgumentException("Days must be >= 1");
        double base = getRentalRatePerDay() * days;
        // Example: if renting >7 days give 10% long-term discount
        if (days > 7) {
            base *= 0.90;
        }
        return base;
    }

    // Insurable implementation
    @Override
    public double calculateInsurance(int days) {
        // Simple model: insurance = days * dailyRate * INSURANCE_RATE_PER_DAY_PERCENT
        return days * getRentalRatePerDay() * INSURANCE_RATE_PER_DAY_PERCENT;
    }

    @Override
    public String getInsuranceDetails() {
        // Mask insurance policy number except last 4 chars
        int keep = Math.min(4, insurancePolicyNumber.length());
        String masked = "****" + insurancePolicyNumber.substring(insurancePolicyNumber.length() - keep);
        return String.format("Car Insurance Policy: %s (type: Comprehensive, rate: %.2f%%/day)", masked, INSURANCE_RATE_PER_DAY_PERCENT*100);
    }

    public int getSeatingCapacity() { return seatingCapacity; }
}

// Bike (not insurable in this example; small insurance optional — choose not to implement Insurable)
class Bike extends Vehicle {
    private boolean hasHelmetIncluded;

    public Bike(String vehicleNumber, double ratePerDay, boolean hasHelmetIncluded) {
        super(vehicleNumber, "Bike", ratePerDay);
        this.hasHelmetIncluded = hasHelmetIncluded;
    }

    @Override
    public double calculateRentalCost(int days) {
        if (days < 1) throw new IllegalArgumentException("Days must be >= 1");
        double base = getRentalRatePerDay() * days;
        // short-term discount: 5% if renting 3-6 days
        if (days >= 3 && days <= 6) base *= 0.95;
        return base;
    }

    public boolean isHelmetIncluded() { return hasHelmetIncluded; }
}

// Truck is insurable
class Truck extends Vehicle implements Insurable {
    private double loadCapacityTons;
    private final String insurancePolicyNumber;
    private static final double INSURANCE_FLAT_PER_DAY = 150.0; // flat per day for trucks

    public Truck(String vehicleNumber, double ratePerDay, double loadCapacityTons, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", ratePerDay);
        if (loadCapacityTons < 0) throw new IllegalArgumentException("Load capacity cannot be negative");
        this.loadCapacityTons = loadCapacityTons;
        if (insurancePolicyNumber == null || insurancePolicyNumber.trim().isEmpty())
            throw new IllegalArgumentException("Insurance policy number required for Truck");
        this.insurancePolicyNumber = insurancePolicyNumber.trim();
    }

    @Override
    public double calculateRentalCost(int days) {
        if (days < 1) throw new IllegalArgumentException("Days must be >= 1");
        double base = getRentalRatePerDay() * days;
        // trucks have additional usage charge per ton per day
        base += days * loadCapacityTons * 20.0;
        return base;
    }

    @Override
    public double calculateInsurance(int days) {
        // simple model: flat per day + small percentage of base
        return days * INSURANCE_FLAT_PER_DAY + days * getRentalRatePerDay() * 0.01;
    }

    @Override
    public String getInsuranceDetails() {
        String masked = "****" + insurancePolicyNumber.substring(Math.max(0, insurancePolicyNumber.length() - 4));
        return String.format("Truck Insurance Policy: %s (flat/day: %.2f)", masked, INSURANCE_FLAT_PER_DAY);
    }

    public double getLoadCapacityTons() { return loadCapacityTons; }
}

// -----------------------------
// Demo: Polymorphism & encapsulation in action
// -----------------------------
public class VehicleRentalDemo {
    public static void main(String[] args) {
        List<Vehicle> fleet = new ArrayList<>();

        // Create sample vehicles (some insurable, some not)
        fleet.add(new Car("MH12AB1234", 2500.0, 5, "CARPOL1234567890"));
        fleet.add(new Bike("MH12XY6789", 500.0, true));
        fleet.add(new Truck("MH12TR0001", 6000.0, 10.0, "TRKPOL0987654321"));
        fleet.add(new Car("MH12CC9999", 1800.0, 4, "CARPOL0000111122"));

        // Simulate various rental periods
        int[] rentalDays = {2, 5, 10, 1}; // days corresponding to vehicles above (for demo)

        System.out.println("=== Vehicle Rental Summary ===");
        for (int i = 0; i < fleet.size(); i++) {
            Vehicle v = fleet.get(i);
            int days = rentalDays[i % rentalDays.length];
            v.displayDetails();

            // Polymorphic rental cost calculation
            double rentalCost = v.calculateRentalCost(days);
            System.out.printf("Rental days: %d, Rental Cost: %.2f%n", days, rentalCost);

            // If vehicle supports insurance, compute insurance via interface (no direct access to raw policy number)
            if (v instanceof Insurable) {
                Insurable ins = (Insurable) v;
                double insurance = ins.calculateInsurance(days);
                System.out.printf("Insurance Cost for %d day(s): %.2f%n", days, insurance);
                System.out.println("Insurance Info: " + ins.getInsuranceDetails());
            } else {
                System.out.println("Insurance: Not provided by rental for this vehicle type.");
            }

            System.out.println("-----------------------------------");
        }

        // Example: trying to access insurance policy number directly would NOT compile:
        // Car c = (Car) fleet.get(0);
        // System.out.println(c.insurancePolicyNumber); // <-- ERROR: insurancePolicyNumber is private

        // But we can still get masked details via getInsuranceDetails()
        System.out.println("Demo complete.");
    }
}
