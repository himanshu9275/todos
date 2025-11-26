class Product {
    // Instance variables
    private String productName;
    private double price;

    // Class variable (shared)
    private static int totalProducts = 0;

    // Constructor
    public Product(String productName, double price) {https://github.com/himanshu9275/todos/tree/main/Constructors/class%20Product%20%7B%20%20%20%20%20
        this.productName = productName;
        this.price = price;
        totalProducts++; // increment when object is created
    }

    // Instance method
    public void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: ₹" + price);
    }

    // Class method
    public static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }
}

// Test class
public class ProductInventoryDemo {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 55000);
        Product p2 = new Product("Smartphone", 18000);

        p1.displayProductDetails();
        System.out.println();
        p2.displayProductDetails();

        System.out.println();
        Product.displayTotalProducts();
    }
}
