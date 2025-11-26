import java.util.Random;

class OutOfStockException extends Exception { OutOfStockException(String m){super(m);} }
class PaymentFailedException extends Exception { PaymentFailedException(String m){super(m);} }

public class OrderProcessing {
    static void placeOrder() throws OutOfStockException, PaymentFailedException {
        int outcome = new Random().nextInt(3); // 0 ok, 1 out of stock, 2 payment fail
        if (outcome == 1) throw new OutOfStockException("Product out of stock.");
        if (outcome == 2) throw new PaymentFailedException("Payment failed.");
        System.out.println("Order placed successfully!");
    }

    public static void main(String[] args) {
        try {
            placeOrder();
        } catch (OutOfStockException e) {
            System.out.println("Order error: " + e.getMessage());
        } catch (PaymentFailedException e) {
            System.out.println("Payment error: " + e.getMessage());
        }
    }
}
