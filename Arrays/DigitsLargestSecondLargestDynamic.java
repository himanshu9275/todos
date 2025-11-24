import java.util.Scanner;

public class DigitsLargestSecondLargestDynamic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int maxDigit = 10;                // initial size
        int[] digits = new int[maxDigit];
        int index = 0;

        int temp = Math.abs(number);      // handle negative numbers

        // Special case: number is 0
        if (temp == 0) {
            digits[0] = 0;
            index = 1;
        } else {
            // Extract digits and store in array (with dynamic resizing)
            while (temp != 0) {
                if (index == maxDigit) {
                    // Increase maxDigit by 10
                    maxDigit = maxDigit + 10;

                    // Create new temp array and copy existing digits
                    int[] tempArray = new int[maxDigit];
                    for (int i = 0; i < index; i++) {
                        tempArray[i] = digits[i];
                    }

                    // Assign back to digits
                    digits = tempArray;
                }

                int digit = temp % 10;
                digits[index] = digit;
                index++;
                temp = temp / 10;
            }
        }

        // Find largest and second largest digit
        int largest = -1;
        int secondLargest = -1;

        for (int i = 0; i < index; i++) {
            int d = digits[i];

            if (d > largest) {
                secondLargest = largest;
                largest = d;
            } else if (d > secondLargest && d != largest) {
                secondLargest = d;
            }
        }

        System.out.print("Digits stored: ");
        for (int i = 0; i < index; i++) {
            System.out.print(digits[i] + " ");
        }
        System.out.println();

        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);
    }
}
