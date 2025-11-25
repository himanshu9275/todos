import java.util.ArrayList;
import java.util.List;

// Base Product
abstract class Product {
    String name;
    double price;
    String category;

    Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public double getPrice() { return price; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return category + " - " + name + " (₹" + price + ")";
    }
}

// Specific product types
class Book extends Product {
    Book(String name, double price) {
        super(name, price, "Book");
    }
}

class ClothingProduct extends Product {
    ClothingProduct(String name, double price) {
        super(name, price, "Clothing");
    }
}

class Gadget extends Product {
    Gadget(String name, double price) {
        super(name, price, "Gadget");
    }
}

// Generic Product Catalog
class ProductCatalog<T extends Product> {
    private List<T> products = new ArrayList<>();

    public void addProduct(T product) {
        products.add(product);
    }

    public List<T> getProducts() {
        return products;
    }

    public List<T> filterByCategory(String category) {
        List<T> result = new ArrayList<>();
        for (T p : products) {
            if (p.getCategory().equalsIgnoreCase(category)) {
                result.add(p);
            }
        }
        return result;
    }

    public List<T> filterByPriceRange(double minPrice, double maxPrice) {
        List<T> result = new ArrayList<>();
        for (T p : products) {
            if (p.getPrice() >= minPrice && p.getPrice() <= maxPrice) {
                result.add(p);
            }
        }
        return result;
    }

    public void displayAll() {
        for (T p : products) {
            System.out.println(p);
        }
    }
}

public class MarketplaceDemo {
    public static void main(String[] args) {
        ProductCatalog<Product> catalog = new ProductCatalog<>();

        catalog.addProduct(new Book("Java Basics", 499));
        catalog.addProduct(new Book("DSA Handbook", 799));
        catalog.addProduct(new ClothingProduct("T-Shirt", 399));
        catalog.addProduct(new ClothingProduct("Jacket", 1499));
        catalog.addProduct(new Gadget("Smartwatch", 2499));
        catalog.addProduct(new Gadget("Bluetooth Earbuds", 1999));

        System.out.println("All Products:");
        catalog.displayAll();

        System.out.println("\nBooks under ₹700:");
        for (Product p : catalog.filterByPriceRange(0, 700)) {
            if (p.getCategory().equals("Book")) {
                System.out.println(p);
            }
        }

        System.out.println("\nGadgets:");
        for (Product p : catalog.filterByCategory("Gadget")) {
            System.out.println(p);
        }
    }
}
