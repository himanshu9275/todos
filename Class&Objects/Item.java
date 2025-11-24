class Item {
    int itemCode;
    String itemName;
    double price;

    void displayItemDetails() {
        System.out.println("Item Code : " + itemCode);
        System.out.println("Item Name : " + itemName);
        System.out.println("Price     : " + price);
    }

    double calculateTotalCost(int quantity) {
        return price * quantity;
    }
}

public class ItemTest {
    public static void main(String[] args) {
        Item item = new Item();
        item.itemCode = 501;
        item.itemName = "Keyboard";
        item.price = 899.50;

        item.displayItemDetails();
        System.out.println("Total Cost for 3 items: " + item.calculateTotalCost(3));
    }
}
