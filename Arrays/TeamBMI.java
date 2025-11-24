import java.util.Scanner;

public class TeamBMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        double[] weights = new double[n];     // in kg
        double[] heightsCm = new double[n];   // in cm
        double[] bmi = new double[n];
        String[] status = new String[n];

        // Input: weight and height
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for person " + (i + 1));

            System.out.print("Weight (kg): ");
            weights[i] = sc.nextDouble();

            System.out.print("Height (cm): ");
            heightsCm[i] = sc.nextDouble();
        }

        // Calculate BMI and weight status
        for (int i = 0; i < n; i++) {
            double heightM = heightsCm[i] / 100.0;
            bmi[i] = weights[i] / (heightM * heightM);

            if (bmi[i] < 18.5) {
                status[i] = "Underweight";
            } else if (bmi[i] < 25) {
                status[i] = "Normal weight";
            } else if (bmi[i] < 30) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        // Display all details
        System.out.println("\n=== BMI Report ===");
        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1) + ":");
            System.out.println("  Height: " + heightsCm[i] + " cm");
            System.out.println("  Weight: " + weights[i] + " kg");
            System.out.println("  BMI   : " + bmi[i]);
            System.out.println("  Status: " + status[i]);
            System.out.println();
        }
    }
}
