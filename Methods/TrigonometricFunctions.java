import java.util.Scanner;

public class TrigonometricFunctions {

    // Method returns {sin, cos, tan}
    public static double[] calculateTrigonometricFunctions(double degree) {
        double radians = Math.toRadians(degree);

        double sin = Math.sin(radians);
        double cos = Math.cos(radians);
        double tan = Math.tan(radians);

        return new double[]{sin, cos, tan};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter angle in degrees: ");
        double degree = sc.nextDouble();

        double[] results = calculateTrigonometricFunctions(degree);

        System.out.println("sin(" + degree + ") = " + results[0]);
        System.out.println("cos(" + degree + ") = " + results[1]);
        System.out.println("tan(" + degree + ") = " + results[2]);
    }
}
