import java.util.Scanner;

public class SmallestCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number1: ");
        int number1 = sc.nextInt();

        System.out.print("Enter number2: ");
        int number2 = sc.nextInt();

        System.out.print("Enter number3: ");
        int number3 = sc.nextInt();

        boolean result = (number1 < number2 && number1 < number3);

        System.out.println("Is the first number the smallest? " + result);
    }
}
