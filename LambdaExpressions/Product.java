import java.util.*;

class Product {
    String name;
    double price;
    double rating; // 0..5
    double discountPercent;

    Product(String n, double p, double r, double d) { name=n; price=p; rating=r; discountPercent=d; }

    @Override public String toString() {
        return name + " (price: " + price + ", rating: " + rating + ", discount: " + discountPercent + "%)";
    }

    public static void main(String[] args) {
        List<Product> items = Arrays.asList(
            new Product("Phone", 699, 4.6, 10),
            new Product("Headphones", 199, 4.2, 25),
            new Product("Laptop", 1299, 4.8, 5),
            new Product("Mouse", 49, 4.1, 15)
        );

        System.out.println("Sort by price (ascending):");
        items.sort(Comparator.comparingDouble(p -> p.price));
        items.forEach(System.out::println);

        System.out.println("\nSort by rating (descending):");
        items.sort((a,b) -> Double.compare(b.rating, a.rating));
        items.forEach(System.out::println);

        System.out.println("\nSort by discount (descending) for a sale:");
        items.sort(Comparator.comparingDouble((Product p) -> p.discountPercent).reversed());
        items.forEach(System.out::println);
    }
}
