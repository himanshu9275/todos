import java.util.*;

class Cart<T> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public void removeItem(T item) {
        items.remove(item);
    }

    public void displayItems() {
        System.out.println("Cart items:");
        for (T item : items) {
            System.out.println("- " + item);
        }
    }
}

// Example product types
class Electronics {
    String name;
    Electronics(String name) { this.name = name; }
    public String toString() { return "Electronics: " + name; }
}

class Clothing {
    String name;
    Clothing(String name) { this.name = name; }
    public String toString() { return "Clothing: " + name; }
}

public class GenericCartDemo {
    public static void main(String[] args) {

        Cart<Electronics> electronicsCart = new Cart<>();
        electronicsCart.addItem(new Electronics("Laptop"));
        electronicsCart.addItem(new Electronics("Headphones"));

        Cart<Clothing> clothingCart = new Cart<>();
        clothingCart.addItem(new Clothing("T-Shirt"));
        clothingCart.addItem(new Clothing("Jeans"));

        System.out.println("Electronics Cart:");
        electronicsCart.displayItems();

        System.out.println("\nClothing Cart:");
        clothingCart.displayItems();

        // ❌ This won't compile:
        // electronicsCart.addItem(new Clothing("Shirt"));
    }
}
