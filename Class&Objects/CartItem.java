class CartItem {
    String itemName;
    double price;
    int quantity;

    // Add item to cart
    void addItem(String name, double itemPrice, int qty) {
        itemName = name;
        price = itemPrice;
        quantity = qty;
        System.out.println("Item added to cart successfully!");
    }

    // Remove item (simply clear attributes)
    void removeItem() {
        System.out.println("Item removed from cart.");
        itemName = "";
        price = 0;
        quantity = 0;
    }

    // Calculate total cost
    double getTotalCost() {
        return price * quantity;
    }

    // Display item and total cost
    void displayCart() {
        System.out.println("\n----- Cart Details -----");
        System.out.println("Item Name : " + itemName);
        System.out.println("Price     : " + price);
        System.out.println("Quantity  : " + quantity);
        System.out.println("Total Cost: " + getTotalCost());
    }
}

public class CartItemTest {
    public static void main(String[] args) {
        CartItem cart = new CartItem();

        cart.addItem("Headphones", 799.99, 2);
        cart.displayCart();

        cart.removeItem();
        cart.displayCart();
    }
}
