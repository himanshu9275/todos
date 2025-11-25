import java.util.*;

abstract class Product {
    double price;
    Product(double price) { this.price = price; }
    double getPrice() { return price; }
    public abstract String toString();
}

class Mobile extends Product {
    String model;
    Mobile(String model, double price) {
        super(price);
        this.model = model;
    }
    public String toString() {
        return "Mobile: " + model + " (₹" + price + ")";
    }
}

class Laptop extends Product {
    String model;
    Laptop(String model, double price) {
        super(price);
        this.model = model;
    }
    public String toString() {
        return "Laptop: " + model + " (₹" + price + ")";
    }
}

public class PriceCalculatorDemo {

    public static double calculateTotal(List<? extends Product> items) {
        double total = 0.0;
        for (Product p : items) {
            total += p.getPrice();
        }
        return total;
    }

    public static void main(String[] args) {
        List<Mobile> mobiles = Arrays.asList(
                new Mobile("iPhone 15", 80000),
                new Mobile("Samsung S24", 70000)
        );

        List<Laptop> laptops = Arrays.asList(
                new Laptop("MacBook Air", 110000),
                new Laptop("Dell XPS", 95000)
        );

        System.out.println("Mobiles:");
        for (Mobile m : mobiles) System.out.println(m);
        System.out.println("Total Mobile Price: " + calculateTotal(mobiles));

        System.out.println("\nLaptops:");
        for (Laptop l : laptops) System.out.println(l);
        System.out.println("Total Laptop Price: " + calculateTotal(laptops));
    }
}
