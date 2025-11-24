import java.util.Scanner;

public class SumNaturalNumbers {

    // Method to find sum of n natural numbers using loop
    public static int sumOfNaturalNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n (natural number): ");
        int n = sc.nextInt();

        if (n < 1) {
            System.out.println("n must be a natural number (>=1).");
        } else {
            int sum = sumOfNaturalNumbers(n);
            System.out.println("The sum of first " + n + " natural numbers is: " + sum);
        }
    }
}
