import java.util.ArrayList;
import java.util.List;

// Base abstract type
abstract class WarehouseItem {
    String name;

    WarehouseItem(String name) {
        this.name = name;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return getType() + ": " + name;
    }
}

// Subclasses
class Electronics extends WarehouseItem {
    Electronics(String name) { super(name); }
    @Override public String getType() { return "Electronics"; }
}

class Groceries extends WarehouseItem {
    Groceries(String name) { super(name); }
    @Override public String getType() { return "Groceries"; }
}

class Furniture extends WarehouseItem {
    Furniture(String name) { super(name); }
    @Override public String getType() { return "Furniture"; }
}

// Generic storage
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }
}

// Wildcard display method
class WarehouseUtils {
    public static void displayItems(List<? extends WarehouseItem> items) {
        System.out.println("Items in storage:");
        for (WarehouseItem wi : items) {
            System.out.println(" - " + wi);
        }
    }
}

public class SmartWarehouseDemo {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Smartphone"));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Rice"));
        groceriesStorage.addItem(new Groceries("Milk"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));

        // Display using wildcard method
        System.out.println("Electronics Storage:");
        WarehouseUtils.displayItems(electronicsStorage.getItems());

        System.out.println("\nGroceries Storage:");
        WarehouseUtils.displayItems(groceriesStorage.getItems());

        System.out.println("\nFurniture Storage:");
        WarehouseUtils.displayItems(furnitureStorage.getItems());
    }
}
