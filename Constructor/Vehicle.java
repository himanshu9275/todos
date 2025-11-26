class Vehicle {
    // Instance variables
    private String ownerName;
    private String vehicleType;

    // Class variable
    private static double registrationFee = 5000;

    // Constructor
    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method
    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: ₹" + registrationFee);
    }

    // Class method
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
}

// Test class
public class VehicleRegistrationDemo {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Amit Sharma", "Car");
        Vehicle v2 = new Vehicle("Riya Mehta", "Bike");

        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();

        System.out.println("\nUpdating Registration Fee...\n");
        Vehicle.updateRegistrationFee(6500);

        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();
    }
}
