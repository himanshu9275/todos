class ServiceOverdueException extends Exception { ServiceOverdueException(String m){super(m);} }
class InvalidMileageException extends Exception { InvalidMileageException(String m){super(m);} }

public class Vehicle {
    int mileage;
    java.time.LocalDate nextServiceDate;

    public Vehicle(int mileage, java.time.LocalDate nextServiceDate) {
        this.mileage = mileage; this.nextServiceDate = nextServiceDate;
    }

    void checkMaintenance() throws ServiceOverdueException, InvalidMileageException {
        if (mileage < 0) throw new InvalidMileageException("Negative mileage: " + mileage);
        if (java.time.LocalDate.now().isAfter(nextServiceDate)) throw new ServiceOverdueException("Service overdue since " + nextServiceDate);
        System.out.println("Vehicle maintenance OK.");
    }

    public static void main(String[] args) {
        Vehicle v = new Vehicle(-10, java.time.LocalDate.now().minusDays(1));
        try {
            v.checkMaintenance();
        } catch (InvalidMileageException | ServiceOverdueException e) {
            System.out.println("Maintenance check failed: " + e.getMessage());
        }
    }
}
