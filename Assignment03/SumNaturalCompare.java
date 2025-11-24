import java.util.Scanner;

public class SumNaturalCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("The number " + n + " is not a natural number");
        } else {
            // Using formula n * (n + 1) / 2
            int formulaSum = n * (n + 1) / 2;

            // Using while loop
            int i = 1;
            int loopSum = 0;
            while (i <= n) {
                loopSum += i;
                i++;
            }

            System.out.println("Sum using formula  n*(n+1)/2 : " + formulaSum);
            System.out.println("Sum using while loop        : " + loopSum);

            if (formulaSum == loopSum) {
                System.out.println("Both results are equal. Computation is correct.");
            } else {
                System.out.println("Results are NOT equal. There is an error.");
            }
        }
    }
}
