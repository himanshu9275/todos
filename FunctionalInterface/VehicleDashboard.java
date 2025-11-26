public interface VehicleDashboard {
    void displaySpeed();

    default void displayBattery() {
        // by default vehicles without battery need not implement
        System.out.println("Battery info not available");
    }
}

class PetrolCar implements VehicleDashboard {
    @Override public void displaySpeed() { System.out.println("Speed: 80 km/h"); }
}

class ElectricCar implements VehicleDashboard {
    @Override public void displaySpeed() { System.out.println("Speed: 60 km/h"); }
    @Override public void displayBattery() { System.out.println("Battery: 78%"); }
}

public class DashboardDemo {
    public static void main(String[] args) {
        VehicleDashboard car = new PetrolCar();
        VehicleDashboard ev = new ElectricCar();
        car.displaySpeed(); car.displayBattery();
        ev.displaySpeed(); ev.displayBattery();
    }
}
