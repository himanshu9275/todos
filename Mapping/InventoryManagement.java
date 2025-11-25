import java.util.*;

public class InventoryManagement {

    public static void main(String[] args) {

        // Map: productName → quantity
        Map<String, Integer> stock = new HashMap<>();

        // 1. Add new products
        stock.put("Rice Bag", 50);
        stock.put("Sugar", 30);
        stock.put("Milk Packet", 20);
        stock.put("Bread", 15);

        System.out.println("Initial Stock: " + stock);

        // 2. Customer buys items
        System.out.println("\nCustomer buys 10 Sugar...");
        reduceStock(stock, "Sugar", 10);

        System.out.println("Customer buys 20 Milk Packet...");
        reduceStock(stock, "Milk Packet", 20); // becomes zero

        // 3. New shipment arrives
        System.out.println("\nNew shipment: 40 Rice Bags");
        increaseStock(stock, "Rice Bag", 40);

        // 4. Query product
        System.out.println("\nQuerying product 'Bread':");
        queryProduct(stock, "Bread");

        System.out.println("\nFinal Stock: " + stock);
    }

    // Reduce stock when customer buys items
    public static void reduceStock(Map<String, Integer> stock, String product, int quantity) {
        if (!stock.containsKey(product)) {
            System.out.println(product + " is not stocked.");
            return;
        }

        int current = stock.get(product);
        int newQuantity = current - quantity;

        if (newQuantity <= 0) {
            System.out.println(product + " is now OUT OF STOCK.");
            stock.put(product, 0); // or remove(product)
        } else {
            stock.put(product, newQuantity);
            System.out.println("Updated " + product + ": " + newQuantity + " left.");
        }
    }

    // Increase stock when shipment arrives
    public static void increaseStock(Map<String, Integer> stock, String product, int quantity) {
        int newQuantity = stock.getOrDefault(product, 0) + quantity;
        stock.put(product, newQuantity);
        System.out.println("Updated " + product + ": " + newQuantity + " in stock.");
    }

    // Query product availability
    public static void queryProduct(Map<String, Integer> stock, String product) {
        if (!stock.containsKey(product)) {
            System.out.println(product + " is NOT stocked.");
        } else {
            System.out.println(product + " available: " + stock.get(product));
        }
    }
}
