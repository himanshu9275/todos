import java.util.Random;

class NegativeAmountException extends Exception { NegativeAmountException(String m){super(m);} }
class NetworkFailureException extends Exception { NetworkFailureException(String m){super(m);} }

public class Transaction {
    static void doTransaction() throws NegativeAmountException, InsufficientFundsException, NetworkFailureException {
        int pick = new Random().nextInt(3);
        if (pick == 0) throw new NegativeAmountException("Negative transaction amount.");
        if (pick == 1) throw new InsufficientFundsException("Insufficient funds for transaction.");
        if (pick == 2) throw new NetworkFailureException("Network failure during transaction.");
    }

    public static void main(String[] args) {
        try {
            doTransaction();
            System.out.println("Transaction successful.");
        } catch (NegativeAmountException e) {
            System.out.println("Transaction failed: Invalid amount.");
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        } catch (NetworkFailureException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
    }
}
