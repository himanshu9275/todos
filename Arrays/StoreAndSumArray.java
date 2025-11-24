import java.util.Scanner;

public class StoreAndSumArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] values = new double[10];
        double total = 0.0;
        int index = 0;

        // Take input until 0/negative or array full
        while (true) {
            if (index == 10) {
                System.out.println("Array is full (10 values).");
                break;
            }

            System.out.print("Enter a number (0 or negative to stop): ");
            double val = sc.nextDouble();

            if (val <= 0) {
                break;
            }

            values[index] = val;
            index++;
        }

        // Sum and display entered values
        System.out.println("You entered the following numbers:");
        for (int i = 0; i < index; i++) {
            System.out.println(values[i]);
            total += values[i];
        }

        System.out.println("The sum of all numbers is: " + total);
    }
}
