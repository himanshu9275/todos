import java.util.*;

// Interface for items that can receive discounts
interface Discountable {
    /**
     * Apply discount to the item and return discount amount (absolute).
     * Implementations should not mutate price permanently unless intended.
     */
    double applyDiscount();

    /**
     * Human-readable discount details (e.g., "10% seasonal discount").
     */
    String getDiscountDetails();
}

// Abstract FoodItem with encapsulated fields
abstract class FoodItem {
    private final String itemName;
    private double price;    // unit price
    private int quantity;    // ordered quantity

    public FoodItem(String itemName, double price, int quantity) {
        if (itemName == null || itemName.trim().isEmpty()) throw new IllegalArgumentException("Invalid item name");
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
        if (quantity < 0) throw new IllegalArgumentException("Quantity cannot be negative");

        this.itemName = itemName.trim();
        this.price = price;
        this.quantity = quantity;
    }

    // Abstract method: each subclass computes its own total price (unit price * qty + possible extras)
    public abstract double calculateTotalPrice();

    // Concrete method to display item details
    public String getItemDetails() {
        return String.format("%s | Unit Price: ₹%.2f | Quantity: %d | Subtotal: ₹%.2f",
                itemName, price, quantity, calculateTotalPrice());
    }

    // Encapsulated getters and controlled setters
    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public void setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
        this.price = price;
    }

    public int getQuantity() { return quantity; }

    // Change quantity via method (encapsulation). Disallow negative quantities.
    public void setQuantity(int quantity) {
        if (quantity < 0) throw new IllegalArgumentException("Quantity cannot be negative");
        this.quantity = quantity;
    }

    // Increase/decrease by delta (useful for cart adjustments)
    public void changeQuantityBy(int delta) {
        if (this.quantity + delta < 0) throw new IllegalArgumentException("Resulting quantity cannot be negative");
        this.quantity += delta;
    }
}

// VegItem: eligible for discount (implements Discountable)
class VegItem extends FoodItem implements Discountable {
    private final double discountPercent; // e.g., 10 means 10% seasonal discount

    public VegItem(String name, double price, int qty, double discountPercent) {
        super(name, price, qty);
        if (discountPercent < 0) throw new IllegalArgumentException("Discount cannot be negative");
        this.discountPercent = discountPercent;
    }

    @Override
    public double calculateTotalPrice() {
        double base = getPrice() * getQuantity();
        double discount = base * discountPercent / 100.0;
        return base - discount;
    }

    @Override
    public double applyDiscount() {
        double base = getPrice() * getQuantity();
        double discount = base * discountPercent / 100.0;
        // We do not change unit price permanently; return discount amount so caller can report it.
        return discount;
    }

    @Override
    public String getDiscountDetails() {
        return String.format("%.2f%% Veg Discount", discountPercent);
    }
}

// NonVegItem: not discountable in this example, but adds an extra non-veg charge/per-item (e.g., special handling)
class NonVegItem extends FoodItem {
    private final double nonVegChargePerUnit; // extra charge per unit (e.g., for special ingredients/handling)

    public NonVegItem(String name, double price, int qty, double nonVegChargePerUnit) {
        super(name, price, qty);
        if (nonVegChargePerUnit < 0) throw new IllegalArgumentException("Charge cannot be negative");
        this.nonVegChargePerUnit = nonVegChargePerUnit;
    }

    @Override
    public double calculateTotalPrice() {
        double base = getPrice() * getQuantity();
        double extra = nonVegChargePerUnit * getQuantity();
        return base + extra;
    }

    public double getNonVegChargePerUnit() { return nonVegChargePerUnit; }
}

// Order class that encapsulates list of items and locks after placing
class Order {
    private final List<FoodItem> items = new ArrayList<>();
    private boolean placed = false; // once placed, order cannot be modified

    // Add item to order (if not placed)
    public void addItem(FoodItem item) {
        ensureNotPlaced();
        if (item == null) throw new IllegalArgumentException("Item cannot be null");
        items.add(item);
    }

    // Remove item (by name) - returns true if removed
    public boolean removeItem(String itemName) {
        ensureNotPlaced();
        Iterator<FoodItem> it = items.iterator();
        while (it.hasNext()) {
            FoodItem f = it.next();
            if (f.getItemName().equalsIgnoreCase(itemName)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    // Change quantity for an item
    public boolean updateQuantity(String itemName, int newQty) {
        ensureNotPlaced();
        for (FoodItem f : items) {
            if (f.getItemName().equalsIgnoreCase(itemName)) {
                f.setQuantity(newQty);
                return true;
            }
        }
        return false;
    }

    // Calculate raw total (before any discounts applied externally)
    public double calculateRawTotal() {
        double total = 0;
        for (FoodItem f : items) total += f.calculateTotalPrice();
        return total;
    }

    // Apply discounts where available and return total discount amount (does not mutate item prices)
    public double applyDiscountsAndReturnTotalDiscount() {
        double totalDiscount = 0;
        for (FoodItem f : items) {
            if (f instanceof Discountable) {
                Discountable d = (Discountable) f;
                totalDiscount += d.applyDiscount();
            }
        }
        return totalDiscount;
    }

    // Place order: lock and compute final cost. Returns final cost.
    public double placeOrder() {
        if (placed) throw new IllegalStateException("Order already placed");
        placed = true;

        // compute costs:
        double subtotal = 0;
        double totalDiscount = 0;
        for (FoodItem f : items) {
            subtotal += f.getPrice() * f.getQuantity(); // base price*qty
            if (f instanceof Discountable) {
                totalDiscount += ((Discountable) f).applyDiscount();
            }
        }

        // For simplicity, taxes/fees: apply flat delivery charge of ₹50 if subtotal < 500, otherwise free.
        double deliveryCharge = (subtotal - totalDiscount) < 500 ? 50.0 : 0.0;

        double finalTotal = subtotal - totalDiscount + deliveryCharge;
        System.out.printf("Order placed. Subtotal: ₹%.2f, Discount: ₹%.2f, Delivery: ₹%.2f, Final Total: ₹%.2f%n",
                subtotal, totalDiscount, deliveryCharge, finalTotal);
        return finalTotal;
    }

    // Helper to ensure not modified after placement
    private void ensureNotPlaced() {
        if (placed) throw new IllegalStateException("Order already placed; no modifications allowed");
    }

    // Display order summary (does not place)
    public void displayOrderSummary() {
        System.out.println("=== Order Summary ===");
        if (items.isEmpty()) {
            System.out.println("No items in order.");
            return;
        }
        for (FoodItem f : items) {
            System.out.println(f.getItemDetails());
            if (f instanceof Discountable) {
                System.out.println("  Discount: " + ((Discountable)f).getDiscountDetails() +
                        " | Discount Amount: ₹" + String.format("%.2f", ((Discountable)f).applyDiscount()));
            } else if (f instanceof NonVegItem) {
                System.out.println("  Non-Veg handling charge per unit: ₹" + String.format("%.2f", ((NonVegItem)f).getNonVegChargePerUnit()));
            }
        }
        double rawTotal = calculateRawTotal();
        System.out.printf("Raw total (after item-specific rules) : ₹%.2f%n", rawTotal);
    }
}

// Demo main
public class OnlineFoodDeliveryDemo {
    public static void main(String[] args) {
        Order order = new Order();

        // Create items
        VegItem paneerButterMasala = new VegItem("Paneer Butter Masala", 220.0, 2, 10.0); // 10% veg discount
        VegItem dalTadka = new VegItem("Dal Tadka", 140.0, 1, 5.0); // 5% veg discount
        NonVegItem butterChicken = new NonVegItem("Butter Chicken", 280.0, 1, 30.0); // ₹30 non-veg extra per unit
        NonVegItem fishFry = new NonVegItem("Fish Fry", 200.0, 2, 25.0);

        // Add items to order
        order.addItem(paneerButterMasala);
        order.addItem(dalTadka);
        order.addItem(butterChicken);
        order.addItem(fishFry);

        // Show summary before placing order
        order.displayOrderSummary();

        // Update quantity (shows encapsulated setter)
        System.out.println("\nUpdating quantity of Dal Tadka to 2...");
        order.updateQuantity("Dal Tadka", 2);

        // Show summary again
        order.displayOrderSummary();

        // Show total discount amount (computed without placing)
        double discountAmt = order.applyDiscountsAndReturnTotalDiscount();
        System.out.printf("\nTotal discounts applicable (without placing order): ₹%.2f%n", discountAmt);

        // Place order: locks it and prints final cost breakdown
        System.out.println("\nPlacing order...");
        double finalAmount = order.placeOrder();

        // After placing, any attempt to modify throws exception
        System.out.println("\nAttempting to remove item after placing (should fail)...");
        try {
            order.removeItem("Fish Fry");
        } catch (IllegalStateException ex) {
            System.out.println("Expected error: " + ex.getMessage());
        }

        System.out.printf("\nFinal amount charged: ₹%.2f%n", finalAmount);
        System.out.println("Demo complete.");
    }
}
