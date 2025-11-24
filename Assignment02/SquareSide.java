import java.util.Scanner;

public class SquareSide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter perimeter: ");
        float perimeter = sc.nextFloat();

        float side = perimeter / 4;

        System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);
    }
}
