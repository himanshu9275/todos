import java.util.Scanner;

public class FactorsAnalysis {

    // Method to find all factors and return them in an int array
    public static int[] findFactors(int number) {
        int count = 0;

        // First loop: count factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        // Create array with exact size
        int[] factors = new int[count];
        int index = 0;

        // Second loop: store factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index] = i;
                index++;
            }
        }

        return factors;
    }

    // Sum of factors
    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int f : factors) {
            sum += f;
        }
        return sum;
    }

    // Product of factors
    public static long productOfFactors(int[] factors) {
        long product = 1;
        for (int f : factors) {
            product *= f;
        }
        return product;
    }

    // Sum of squares of factors
    public static long sumOfSquareOfFactors(int[] factors) {
        long sumSq = 0;
        for (int f : factors) {
            sumSq += (long) Math.pow(f, 2);
        }
        return sumSq;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] factors = findFactors(number);

        System.out.print("Factors of " + number + " are: ");
        for (int f : factors) {
            System.out.print(f + " ");
        }
        System.out.println();

        int sum = sumOfFactors(factors);
        long product = productOfFactors(factors);
        long sumSq = sumOfSquareOfFactors(factors);

        System.out.println("Sum of factors           = " + sum);
        System.out.println("Product of factors       = " + product);
        System.out.println("Sum of squares of factors= " + sumSq);
    }
}
