import java.util.Scanner;

public class ChocolateDistribution {

    // Method to return quotient and remainder
    public static int[] findRemainderAndQuotient(int chocolates, int children) {
        int eachChildGets = chocolates / children;
        int remaining = chocolates % children;
        return new int[]{eachChildGets, remaining};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of chocolates: ");
        int chocolates = sc.nextInt();

        System.out.print("Enter number of children: ");
        int children = sc.nextInt();

        int[] result = findRemainderAndQuotient(chocolates, children);

        System.out.println("\nEach child gets = " + result[0] + " chocolates");
        System.out.println("Remaining chocolates = " + result[1]);
    }
}
