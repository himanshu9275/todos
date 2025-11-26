// Payment.java
public interface Payment {
    boolean pay(double amount);
}

// UPI.java
class UPI implements Payment {
    @Override public boolean pay(double amount) { System.out.println("Paid ₹" + amount + " via UPI"); return true; }
}

// Card.java
class Card implements Payment {
    @Override public boolean pay(double amount) { System.out.println("Paid ₹" + amount + " via Card"); return true; }
}

// Demo
public class PaymentDemo {
    public static void main(String[] args) {
        Payment p1 = new UPI();
        Payment p2 = new Card();
        p1.pay(1200); p2.pay(499.99);
    }
}
