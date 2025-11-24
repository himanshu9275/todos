import java.util.Scanner;

public class TriangularParkRun {

    // Method to compute number of rounds for 5 km
    public static double computeRounds(double a, double b, double c) {
        double perimeter = a + b + c;     // in meters
        double distance = 5000.0;         // 5 km in meters
        return distance / perimeter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter side 1 of triangle (in meters): ");
        double s1 = sc.nextDouble();

        System.out.print("Enter side 2 of triangle (in meters): ");
        double s2 = sc.nextDouble();

        System.out.print("Enter side 3 of triangle (in meters): ");
        double s3 = sc.nextDouble();

        double rounds = computeRounds(s1, s2, s3);

        System.out.println("The athlete must complete " + rounds + " rounds to finish 5 km.");
    }
}
