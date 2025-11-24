import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = sc.nextInt();

        int count = 0;
        int temp = number;

        // if number is 0, it has 1 digit
        if (temp == 0) {
            count = 1;
        } else {
            // count digits
            while (temp != 0) {
                temp = temp / 10;   // remove last digit
                count++;            // increase count
            }
        }

        System.out.println("Number of digits in " + number + " is: " + count);
    }
}
