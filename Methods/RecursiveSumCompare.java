import java.util.Scanner;

public class RecursiveSumCompare {

    // Recursive method to find sum of n natural numbers
    public static long recursiveSum(long n) {
        if (n <= 0) return 0;          // base for n <= 0
        if (n == 1) return 1;
        return n + recursiveSum(n - 1);
    }

    // Formula method: n*(n+1)/2
    public static long formulaSum(long n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n (natural number): ");
        long n = sc.nextLong();

        if (n < 0) {
            System.out.println("The number " + n + " is not a natural number.");
            return;
        }

        long rec = recursiveSum(n);
        long formula = formulaSum(n);

        System.out.println("Sum using recursion : " + rec);
        System.out.println("Sum using formula   : " + formula);

        if (rec == formula) {
            System.out.println("Both results are equal. Computation is correct.");
        } else {
            System.out.println("Results are NOT equal. There is an error.");
        }
    }
}
