import java.util.Scanner;

public class DigitsLargestSecondLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int maxDigit = 10;                // maximum digits to store
        int[] digits = new int[maxDigit];
        int index = 0;

        int temp = Math.abs(number);      // handle negative numbers gracefully

        // Extract digits and store in array
        while (temp != 0) {
            if (index == maxDigit) {      // stop if array full
                break;
            }
            int digit = temp % 10;
            digits[index] = digit;
            index++;
            temp = temp / 10;
        }

        if (index == 0) { // number was 0
            digits[0] = 0;
            index = 1;
        }

        // Find largest and second largest digit
        int largest = 0;
        int secondLargest = 0;

        for (int i = 0; i < index; i++) {
            int d = digits[i];

            if (d > largest) {
                secondLargest = largest;
                largest = d;
            } else if (d > secondLargest && d != largest) {
                secondLargest = d;
            }
        }

        System.out.print("Digits stored (up to 10 digits): ");
        for (int i = 0; i < index; i++) {
            System.out.print(digits[i] + " ");
        }
        System.out.println();

        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);
    }
}
