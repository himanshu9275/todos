import java.util.*;

/**
 * Ride-Hailing Application Demo
 *
 * - Abstract Vehicle with private fields: vehicleId, driverName, ratePerKm
 * - Abstract calculateFare(distance)
 * - Concrete getVehicleDetails() showing masked driver info
 * - Subclasses Car, Bike, Auto override calculateFare()
 * - GPS interface with getCurrentLocation() and updateLocation() implemented in Vehicle
 * - Encapsulation: sensitive fields are private; location and driver name exposed in controlled ways
 * - Polymorphism: calculate fares for mixed vehicles via a single method
 */

// GPS interface
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Abstract Vehicle implementing GPS (so every vehicle has location)
abstract class Vehicle implements GPS {
    private final String vehicleId;   // immutable once set
    private String driverName;        // sensitive — keep private, provide masked getter
    private double ratePerKm;         // base rate per km
    private String currentLocation;   // current GPS location string (simple representation)

    public Vehicle(String vehicleId, String driverName, double ratePerKm, String initialLocation) {
        if (vehicleId == null || vehicleId.trim().isEmpty()) throw new IllegalArgumentException("vehicleId required");
        if (driverName == null || driverName.trim().isEmpty()) throw new IllegalArgumentException("driverName required");
        if (ratePerKm < 0) throw new IllegalArgumentException("ratePerKm cannot be negative");

        this.vehicleId = vehicleId.trim();
        this.driverName = driverName.trim();
        this.ratePerKm = ratePerKm;
        this.currentLocation = (initialLocation == null) ? "Unknown" : initialLocation.trim();
    }

    // Abstract fare calculation
    public abstract double calculateFare(double distanceKm);

    // Concrete method to show vehicle details - driver name masked for privacy
    public String getVehicleDetails() {
        return String.format("Vehicle[%s] | Driver: %s | Rate/km: ₹%.2f | Location: %s",
                vehicleId, getMaskedDriverName(), ratePerKm, currentLocation);
    }

    // Controlled accessors (encapsulation)
    public String getVehicleId() { return vehicleId; }

    // Return driver name masked (e.g., "R**** S")
    public String getMaskedDriverName() {
        String[] parts = driverName.split("\\s+");
        StringBuilder masked = new StringBuilder();
        for (String p : parts) {
            if (p.length() <= 1) masked.append("* ");
            else masked.append(p.charAt(0)).append("*** ");
        }
        return masked.toString().trim();
    }

    // Full driver name intentionally not exposed as public getter to protect privacy.
    // Provide a secure method that returns name only when a correct secret/token is provided.
    public String getDriverNameSecure(String secretToken) {
        // In real system we'd check authentication/authorization.
        if ("SHOW_NAME".equals(secretToken)) return driverName;
        throw new SecurityException("Unauthorized access to driver name");
    }

    // ratePerKm getter & setter (controlled)
    public double getRatePerKm() { return ratePerKm; }
    public void setRatePerKm(double ratePerKm) {
        if (ratePerKm < 0) throw new IllegalArgumentException("ratePerKm cannot be negative");
        this.ratePerKm = ratePerKm;
    }

    // GPS interface implementation
    @Override
    public String getCurrentLocation() { return currentLocation; }

    @Override
    public void updateLocation(String newLocation) {
        if (newLocation == null || newLocation.trim().isEmpty()) throw new IllegalArgumentException("Invalid location");
        this.currentLocation = newLocation.trim();
    }
}

// Car: may have a base booking fee and higher comfort surcharge
class Car extends Vehicle {
    private double bookingFee;
    private double comfortSurchargePercent; // e.g., 10% of base fare

    public Car(String vehicleId, String driverName, double ratePerKm, String initialLocation,
               double bookingFee, double comfortSurchargePercent) {
        super(vehicleId, driverName, ratePerKm, initialLocation);
        if (bookingFee < 0 || comfortSurchargePercent < 0) throw new IllegalArgumentException("Invalid surcharges");
        this.bookingFee = bookingFee;
        this.comfortSurchargePercent = comfortSurchargePercent;
    }

    @Override
    public double calculateFare(double distanceKm) {
        if (distanceKm < 0) throw new IllegalArgumentException("Distance cannot be negative");
        double base = getRatePerKm() * distanceKm;
        double surcharge = base * (comfortSurchargePercent / 100.0);
        return roundToPaise(bookingFee + base + surcharge);
    }

    private double roundToPaise(double amt) {
        return Math.round(amt * 100.0) / 100.0;
    }
}

// Bike: cheaper, minimal booking fee, possible surge multiplier for peak hours (simple param)
class Bike extends Vehicle {
    private double surgeMultiplier; // e.g., 1.0 normal, 1.5 surge

    public Bike(String vehicleId, String driverName, double ratePerKm, String initialLocation, double surgeMultiplier) {
        super(vehicleId, driverName, ratePerKm, initialLocation);
        if (surgeMultiplier < 1.0) throw new IllegalArgumentException("Surge multiplier must be >= 1.0");
        this.surgeMultiplier = surgeMultiplier;
    }

    @Override
    public double calculateFare(double distanceKm) {
        if (distanceKm < 0) throw new IllegalArgumentException("Distance cannot be negative");
        double fare = getRatePerKm() * distanceKm * surgeMultiplier;
        return Math.round(fare * 100.0) / 100.0;
    }
}

// Auto: autorickshaw style with minimum fare and per-km plus small convenience fee
class Auto extends Vehicle {
    private double minimumFare;
    private double convenienceFee;

    public Auto(String vehicleId, String driverName, double ratePerKm, String initialLocation,
                double minimumFare, double convenienceFee) {
        super(vehicleId, driverName, ratePerKm, initialLocation);
        if (minimumFare < 0 || convenienceFee < 0) throw new IllegalArgumentException("Invalid fees");
        this.minimumFare = minimumFare;
        this.convenienceFee = convenienceFee;
    }

    @Override
    public double calculateFare(double distanceKm) {
        if (distanceKm < 0) throw new IllegalArgumentException("Distance cannot be negative");
        double fare = getRatePerKm() * distanceKm + convenienceFee;
        fare = Math.max(fare, minimumFare);
        return Math.round(fare * 100.0) / 100.0;
    }
}

// Utility class to demonstrate polymorphism
class RideHailingService {
    /**
     * Calculate and print fare for a ride using polymorphism.
     * @param v vehicle to use
     * @param distanceKm distance in km
     * @return fare calculated
     */
    public static double calculateFareForRide(Vehicle v, double distanceKm) {
        System.out.println("Using vehicle: " + v.getVehicleDetails());
        double fare = v.calculateFare(distanceKm);
        System.out.printf("Distance: %.2f km | Estimated Fare: ₹%.2f%n", distanceKm, fare);
        return fare;
    }

    /**
     * Calculate fares for a list of vehicles (polymorphic handling).
     */
    public static void calculateFaresForFleet(List<Vehicle> fleet, double distanceKm) {
        System.out.printf("Calculating fares for distance: %.2f km across %d vehicles%n", distanceKm, fleet.size());
        for (Vehicle v : fleet) {
            double fare = v.calculateFare(distanceKm); // polymorphic call
            System.out.printf("%s -> ₹%.2f%n", v.getVehicleDetails(), fare);
        }
    }
}

// Demo main
public class RideHailingDemo {
    public static void main(String[] args) {
        // Create vehicles
        Vehicle car1 = new Car("CAR-101", "Ramesh Kumar", 20.0, "MG Road", 40.0, 10.0);
        Vehicle bike1 = new Bike("BIKE-501", "Seema Rao", 8.0, "Maple Street", 1.2); // surge 1.2
        Vehicle auto1 = new Auto("AUTO-301", "Sanjay", 12.0, "Central Park", 50.0, 10.0);

        // Polymorphic single-ride calculations
        System.out.println("=== Single Ride Fare Estimates ===");
        RideHailingService.calculateFareForRide(car1, 12.5);
        RideHailingService.calculateFareForRide(bike1, 12.5);
        RideHailingService.calculateFareForRide(auto1, 12.5);

        // Update locations via GPS
        car1.updateLocation("Church Street");
        bike1.updateLocation("5th Avenue");
        auto1.updateLocation("Market Junction");

        System.out.println("\n=== Fleet Fare Comparison ===");
        List<Vehicle> fleet = Arrays.asList(car1, bike1, auto1);
        RideHailingService.calculateFaresForFleet(fleet, 7.8);

        // Demonstrate secure access to driver name (authorized)
        try {
            System.out.println("\nAuthorized driver name access for CAR-101: " + ((Car) car1).getDriverNameSecure("SHOW_NAME"));
        } catch (SecurityException se) {
            System.out.println("Security error: " + se.getMessage());
        }

        // Attempt unauthorized access
        try {
            System.out.println("Attempting unauthorized access to driver name for BIKE-501:");
            // Bike doesn't expose getDriverNameSecure directly (method is on Vehicle), cast to Vehicle:
            System.out.println(((Vehicle) bike1).getDriverNameSecure("WRONG_TOKEN"));
        } catch (SecurityException ex) {
            System.out.println("Expected security exception: " + ex.getMessage());
        }

        System.out.println("\nDemo complete.");
    }
}
