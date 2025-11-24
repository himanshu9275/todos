import java.util.Scanner;

public class SmallestLargestOfThree {

    // Method to find smallest of 3
    public static int smallest(int a, int b, int c) {
        int min = a;
        if (b < min) min = b;
        if (c < min) min = c;
        return min;
    }

    // Method to find largest of 3
    public static int largest(int a, int b, int c) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int n1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int n2 = sc.nextInt();

        System.out.print("Enter third number: ");
        int n3 = sc.nextInt();

        int min = smallest(n1, n2, n3);
        int max = largest(n1, n2, n3);

        System.out.println("Smallest of the three numbers is: " + min);
        System.out.println("Largest of the three numbers is: " + max);
    }
}
