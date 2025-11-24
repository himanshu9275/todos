import java.util.Scanner;

public class ReverseNumberArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int temp = Math.abs(number);

        // Step 1: Count digits
        int count = 0;
        if (temp == 0) {
            count = 1;
        } else {
            while (temp != 0) {
                temp /= 10;
                count++;
            }
        }

        // Step 2: Store digits in array (in original order)
        int[] digits = new int[count];
        temp = Math.abs(number);

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }

        // Step 3: Create reverse array
        int[] reversed = new int[count];
        for (int i = 0; i < count; i++) {
            reversed[i] = digits[count - 1 - i];
        }

        // Step 4: Display reversed digits (this is the reversed number)
        System.out.print("Digits in reverse order: ");
        if (number < 0) {
            System.out.print("- "); // show sign if negative
        }
        for (int i = 0; i < count; i++) {
            System.out.print(reversed[i] + " ");
        }
        System.out.println();
    }
}
