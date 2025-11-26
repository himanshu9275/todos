public interface PaymentProcessor {
    boolean pay(double amount);

    default boolean refund(double amount) {
        System.out.println("Default refund processed for ₹" + amount);
        return true;
    }
}

// A provider implementing only pay()
class SimpleGateway implements PaymentProcessor {
    @Override public boolean pay(double amount) { System.out.println("Paid ₹" + amount + " via SimpleGateway"); return true; }
}

// Demo
public class PaymentDefaultDemo {
    public static void main(String[] args) {
        PaymentProcessor p = new SimpleGateway();
        p.pay(500);
        p.refund(200); // uses default method
    }
}
