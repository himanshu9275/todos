import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Get input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int originalNumber = number;  // to compare later
        int sum = 0;                  // to store sum of cubes

        // Step 2: Loop to extract digits
        while (originalNumber != 0) {
            int digit = originalNumber % 10;    // last digit
            sum += digit * digit * digit;       // cube added to sum
            originalNumber = originalNumber / 10;  // remove last digit
        }

        // Step 3: Check Armstrong condition
        if (sum == number) {
            System.out.println(number + " is an Armstrong Number.");
        } else {
            System.out.println(number + " is NOT an Armstrong Number.");
        }
    }
}
