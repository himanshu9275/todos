import java.util.Scanner;

public class TotalPrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter unit price: ");
        float unitPrice = sc.nextFloat();

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        float total = unitPrice * quantity;

        System.out.println("The total purchase price is INR " + total 
                           + " if the quantity " + quantity 
                           + " and unit price is INR " + unitPrice);
    }
}
