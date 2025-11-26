import java.util.Scanner;

public class PrimitiveToWrapper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int primitive = sc.nextInt();

        Integer wrapper = Integer.valueOf(primitive); // boxing
        System.out.println("Primitive int: " + primitive);
        System.out.println("Wrapper Integer: " + wrapper);
    }
}
