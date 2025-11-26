import java.util.*;

// ---------------------------
// Employee Management System
// ---------------------------

abstract class Employee {
    private String employeeId;
    private String name;
    private double baseSalary; // monthly base salary

    public Employee(String employeeId, String name, double baseSalary) {
        setEmployeeId(employeeId);
        setName(name);
        setBaseSalary(baseSalary);
    }

    // Abstract method — subclasses compute their salary
    public abstract double calculateSalary();

    // Concrete method to display common details
    public void displayDetails() {
        System.out.printf("ID: %s | Name: %s | Base Salary: %.2f | Final Salary: %.2f%n",
                employeeId, name, baseSalary, calculateSalary());
    }

    // Encapsulation: getters & setters with basic validation
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) {
        if (employeeId == null || employeeId.trim().isEmpty()) throw new IllegalArgumentException("Invalid employeeId");
        this.employeeId = employeeId.trim();
    }

    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Invalid name");
        this.name = name.trim();
    }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0) throw new IllegalArgumentException("Base salary cannot be negative");
        this.baseSalary = baseSalary;
    }
}

// Interface for Department behavior
interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}

// Full-time employee: fixed base salary + performance bonus percentage
class FullTimeEmployee extends Employee implements Department {
    private double bonusPercent; // e.g., 10 means 10%
    private String department;

    public FullTimeEmployee(String id, String name, double baseSalary, double bonusPercent) {
        super(id, name, baseSalary);
        setBonusPercent(bonusPercent);
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + (getBaseSalary() * bonusPercent / 100.0);
    }

    public double getBonusPercent() { return bonusPercent; }
    public void setBonusPercent(double bonusPercent) {
        if (bonusPercent < 0) throw new IllegalArgumentException("Bonus cannot be negative");
        this.bonusPercent = bonusPercent;
    }

    // Department methods
    @Override
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    @Override
    public String getDepartmentDetails() {
        return department == null ? "No Department" : department;
    }
}

// Part-time employee: paid hourly
class PartTimeEmployee extends Employee implements Department {
    private double hoursWorked;
    private double hourlyRate;
    private String department;

    public PartTimeEmployee(String id, String name, double hourlyRate, double hoursWorked) {
        super(id, name, 0); // baseSalary not used for part-time (left 0)
        setHourlyRate(hourlyRate);
        setHoursWorked(hoursWorked);
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    public double getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(double hoursWorked) {
        if (hoursWorked < 0) throw new IllegalArgumentException("Hours cannot be negative");
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate < 0) throw new IllegalArgumentException("Hourly rate cannot be negative");
        this.hourlyRate = hourlyRate;
    }

    // Department methods
    @Override
    public void assignDepartment(String deptName) { this.department = deptName; }

    @Override
    public String getDepartmentDetails() {
        return department == null ? "No Department" : department;
    }
}

// ---------------------------
// E-Commerce Platform
// ---------------------------

// Taxable interface for applicable products
interface Taxable {
    double calculateTax(); // return tax amount
    String getTaxDetails();
}

// Abstract product
abstract class Product {
    private String productId;
    private String name;
    private double price; // base price

    public Product(String productId, String name, double price) {
        setProductId(productId);
        setName(name);
        setPrice(price);
    }

    // Abstract discount rule — concrete classes implement
    public abstract double calculateDiscount(); // returns discount amount

    // Final price after discount and tax will be (price - discount + tax)
    public double finalPrice() {
        double discount = calculateDiscount();
        double tax = (this instanceof Taxable) ? ((Taxable)this).calculateTax() : 0.0;
        return Math.max(0.0, price - discount + tax);
    }

    // Encapsulation: getters & setters with validation
    public String getProductId() { return productId; }
    public void setProductId(String productId) {
        if (productId == null || productId.trim().isEmpty()) throw new IllegalArgumentException("Invalid productId");
        this.productId = productId.trim();
    }

    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Invalid name");
        this.name = name.trim();
    }

    public double getPrice() { return price; }
    public void setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
        this.price = price;
    }

    public void displayDetails() {
        System.out.printf("Product[%s] %s | Price: %.2f | Discount: %.2f | Final Price: %.2f%n",
                productId, name, price, calculateDiscount(), finalPrice());
        if (this instanceof Taxable) {
            System.out.println("  Tax details: " + ((Taxable)this).getTaxDetails());
        }
    }
}

// Electronics: discount percentage + tax (say 18%)
class Electronics extends Product implements Taxable {
    private double discountPercent; // e.g., 10 => 10% discount
    private static final double TAX_RATE = 0.18; // 18%

    public Electronics(String id, String name, double price, double discountPercent) {
        super(id, name, price);
        setDiscountPercent(discountPercent);
    }

    public void setDiscountPercent(double discountPercent) {
        if (discountPercent < 0) throw new IllegalArgumentException("Discount cannot be negative");
        this.discountPercent = discountPercent;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * discountPercent / 100.0;
    }

    @Override
    public double calculateTax() {
        return getPrice() * TAX_RATE;
    }

    @Override
    public String getTaxDetails() {
        return String.format("Electronic tax @ %.2f%% = %.2f", TAX_RATE * 100, calculateTax());
    }
}

// Clothing: seasonal flat discount + tax (12%)
class Clothing extends Product implements Taxable {
    private double flatDiscount; // absolute amount
    private static final double TAX_RATE = 0.12; // 12%

    public Clothing(String id, String name, double price, double flatDiscount) {
        super(id, name, price);
        setFlatDiscount(flatDiscount);
    }

    public void setFlatDiscount(double flatDiscount) {
        if (flatDiscount < 0) throw new IllegalArgumentException("Discount cannot be negative");
        this.flatDiscount = flatDiscount;
    }

    @Override
    public double calculateDiscount() {
        return Math.min(flatDiscount, getPrice()); // can't exceed price
    }

    @Override
    public double calculateTax() {
        return getPrice() * TAX_RATE;
    }

    @Override
    public String getTaxDetails() {
        return String.format("Clothing tax @ %.2f%% = %.2f", TAX_RATE * 100, calculateTax());
    }
}

// Groceries: small discount (no tax in this example)
class Groceries extends Product {
    private double discount; // absolute

    public Groceries(String id, String name, double price, double discount) {
        super(id, name, price);
        setDiscount(discount);
    }

    public void setDiscount(double discount) {
        if (discount < 0) throw new IllegalArgumentException("Discount cannot be negative");
        this.discount = discount;
    }

    @Override
    public double calculateDiscount() {
        return Math.min(discount, getPrice());
    }

    // No Taxable implementation — groceries are tax-exempt in our simplified example
}

// ---------------------------
// Demo / Main
// ---------------------------

public class SystemDemo {
    public static void main(String[] args) {
        System.out.println("=== Employee Management System Demo ===");
        employeeDemo();

        System.out.println("\n=== E-Commerce Platform Demo ===");
        ecommerceDemo();
    }

    private static void employeeDemo() {
        List<Employee> employees = new ArrayList<>();

        FullTimeEmployee f1 = new FullTimeEmployee("F001", "Asha Sharma", 50000, 10); // 10% bonus
        f1.assignDepartment("Engineering");

        FullTimeEmployee f2 = new FullTimeEmployee("F002", "Vikram Patel", 65000, 12);
        f2.assignDepartment("Sales");

        PartTimeEmployee p1 = new PartTimeEmployee("P001", "Rina Das", 400, 80); // 400/hr, 80 hours
        p1.assignDepartment("Support");

        PartTimeEmployee p2 = new PartTimeEmployee("P002", "Sahil Mehra", 300, 60);
        p2.assignDepartment("Maintenance");

        employees.add(f1);
        employees.add(f2);
        employees.add(p1);
        employees.add(p2);

        // Polymorphism: process via Employee references
        for (Employee e : employees) {
            e.displayDetails();
            // If department is available, cast to Department to print department
            if (e instanceof Department) {
                System.out.println("  Department: " + ((Department)e).getDepartmentDetails());
            }
        }
    }

    private static void ecommerceDemo() {
        List<Product> catalog = new ArrayList<>();

        Product p1 = new Electronics("E100", "Smartphone", 25000, 8); // 8% discount
        Product p2 = new Clothing("C200", "Denim Jeans", 1999, 200); // ₹200 off
        Product p3 = new Groceries("G300", "Olive Oil 1L", 799, 50); // ₹50 off
        Product p4 = new Electronics("E101", "Laptop", 75000, 5); // 5% discount
        Product p5 = new Clothing("C201", "T-Shirt", 499, 50);

        catalog.add(p1);
        catalog.add(p2);
        catalog.add(p3);
        catalog.add(p4);
        catalog.add(p5);

        // Display using Product reference (polymorphism)
        for (Product pc : catalog) {
            pc.displayDetails();
        }

        // Example: apply an update (encapsulation ensures validation)
        try {
            p1.setPrice(24000); // update allowed via setter
            ((Electronics)p1).setDiscountPercent(10); // increase discount
            System.out.println("\nAfter price/discount update:");
            p1.displayDetails();
        } catch (IllegalArgumentException ex) {
            System.out.println("Update failed: " + ex.getMessage());
        }
    }
}
