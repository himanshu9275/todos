import java.util.Scanner;
public class Problem11_BasicCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double n1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double n2 = sc.nextDouble();
        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers " + n1 + " and " + n2 + " is " + (n1+n2) + ", " + (n1-n2) + ", " + (n1*n2) + ", and " + (n1/n2));
        sc.close();
    }
}