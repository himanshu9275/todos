import java.util.*;
import java.util.stream.Collectors;

class Invoice {
    String transactionId;
    Invoice(String transactionId) { this.transactionId = transactionId; }
    @Override public String toString() { return "Invoice{" + transactionId + "}"; }
}

public class InvoiceFactory {
    public static void main(String[] args) {
        List<String> txIds = Arrays.asList("TX1001", "TX1002", "TX1003");

        // constructor reference Invoice::new
        List<Invoice> invoices = txIds.stream().map(Invoice::new).collect(Collectors.toList());

        invoices.forEach(System.out::println);
    }
}
