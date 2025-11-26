// Rentable.java
public interface Rentable {
    void rent(String customer);
    void returnVehicle();
}

// Car.java
class Car implements Rentable {
    @Override public void rent(String customer) { System.out.println("Car rented to " + customer); }
    @Override public void returnVehicle() { System.out.println("Car returned"); }
}

// Bike.java
class Bike implements Rentable {
    @Override public void rent(String customer) { System.out.println("Bike rented to " + customer); }
    @Override public void returnVehicle() { System.out.println("Bike returned"); }
}

// Demo
public class RentalDemo {
    public static void main(String[] args) {
        Rentable c = new Car();
        Rentable b = new Bike();
        c.rent("Alice"); b.rent("Bob");
        c.returnVehicle(); b.returnVehicle();
    }
}
